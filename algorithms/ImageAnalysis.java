package algorithms;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;

import javax.imageio.ImageIO;

public class ImageAnalysis {
	private HashSet<double[]> successSet, failSet;
	
	public ImageAnalysis(String filename){
		// Loading the data sets
		successSet = new HashSet<double[]>();
		failSet = new HashSet<double[]>();
		try{
			BufferedReader br = new BufferedReader(new FileReader(filename));
			String line;
			while((line = br.readLine()) != null){
				String tokens[] = line.split(",");
				double[] data = {Double.parseDouble(tokens[1]),Double.parseDouble(tokens[2]),Double.parseDouble(tokens[3])};
				if(tokens[0].equals("S")){
					successSet.add(data);
				}else{
					failSet.add(data);
				}
			}
			br.close();
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	
	public static BufferedImage loadImage(String filename){
		BufferedImage returnImage = null;
		try {
			returnImage = ImageIO.read(new File(filename));
		} catch (IOException e) {
			System.out.println("IMG " + filename + " not found");
			e.printStackTrace();
		}
		return returnImage;
	}
	
	public boolean compareImage(BufferedImage img1, BufferedImage img2){
		
		
		// Check for same dimension
		if(img1.getHeight() != img2.getHeight() || img1.getWidth() != img2.getWidth()){
			return false;
		}else{
			// PART1 - RGB ANALYSIS
			int[] dataRGB = img1.getRGB(0, 0, img1.getWidth(), img1.getHeight(), null, 0, img1.getWidth());
			int[] stdRGB = img2.getRGB(0, 0, img2.getWidth(), img2.getHeight(), null, 0, img2.getWidth());

			// Compare each pixel
			ArrayList<Integer> diffList = new ArrayList<Integer>();
			int diff;
			for(int k=0; k<dataRGB.length; k++){
				Color dataColor = new Color(dataRGB[k]);
				Color stdColor = new Color(stdRGB[k]);

				int dataRed = dataColor.getRed();
				int dataGreen = dataColor.getGreen();
				int dataBlue = dataColor.getBlue();

				int stdRed = stdColor.getRed();
				int stdGreen = stdColor.getGreen();
				int stdBlue = stdColor.getBlue();
				
				// Check color difference
				diff = 0;
				diff += Math.abs(dataRed - stdRed);
				diff += Math.abs(dataGreen - stdGreen);
				diff += Math.abs(dataBlue - stdBlue);

				diffList.add(new Integer(diff));
			}

			// PART2 - DIFF ANALYSIS
			Collections.sort(diffList);
			double median = 0, average = 0, stdDeviation = 0; // RANGES: median: 0-765 avg: 0-765

			// median
			if(diffList.size()%2 == 0){
				median = (diffList.get(diffList.size()/2) + diffList.get((diffList.size()/2)+1)) /2 ;
			}else{
				median = diffList.get(diffList.size()/2);
			}

			// average
			Iterator<Integer> it = diffList.iterator();
			while(it.hasNext()){
				average += it.next();
			}
			average = average/diffList.size();

			// stdDeviation
			it = diffList.iterator();
			while(it.hasNext()){
				stdDeviation += Math.pow((it.next() - average),2);
			}
			stdDeviation = Math.pow(stdDeviation/diffList.size(), 0.5);

			double[] vector = {median/765.0, average/765.0, stdDeviation/500.0};
			
			// PART3 - FIND NEAREST NEIGHBOR (KNN = 3)
			
			double[] distances = {Double.MAX_VALUE,Double.MAX_VALUE,Double.MAX_VALUE};
			int[] votes = {0,0,0}; // If not fulled (less than 3 study cases), this will make a default guess of NO MATCH
			Iterator<double[]> succIt = successSet.iterator();
			Iterator<double[]> failIt = failSet.iterator();
			double[] data = new double[3];
			double medianDist,  averageDist, stdDevDist, totalDist;
			while(succIt.hasNext() || failIt.hasNext()){
				if(succIt.hasNext()){
					data = succIt.next();
				}else{
					data = failIt.next();
				}
				
				medianDist = Math.pow(data[0]-vector[0], 2);
				averageDist = Math.pow(data[1]-vector[1], 2);
				stdDevDist = Math.pow(data[2]-vector[2], 2);
				totalDist = medianDist + averageDist + stdDevDist;
				
				if(totalDist < distances[0]){
					distances[2] = distances[1];
					distances[1] = distances[0];
					distances[0] = totalDist;
					
					votes[2] = votes[1];
					votes[1] = votes[0];
					votes[0] = 1;
				}else if(totalDist < distances[1]){
					distances[2] = distances[1];
					distances[1] = totalDist;
					
					votes[2] = votes[1];
					votes[1] = 1;
				}else if(totalDist < distances[2]){
					distances[2] = totalDist;
					votes[2] = 1;
				}
			}
			
			// Final vote
			int finalVote = votes[0] + votes[1] + votes[2];
			return (finalVote >= 2);

		}	
	}

}
