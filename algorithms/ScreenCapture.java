package algorithms;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.mortennobel.imagescaling.ResampleOp;

public class ScreenCapture {
	
	private final int HUDSCALE = 35;
	private Rectangle topRight, bottomLeft;
	private int captureCounter = 0;
	
	
	public ScreenCapture(){
		// Rectangles - (x0 - xScale, y0, xLength_0 + xScale, yLength_0 + yScale)
		topRight = new Rectangle(1699 - (int)(2.5 * HUDSCALE),0,221 + (int)(2.5 * HUDSCALE),21 + (int)(0.25 * HUDSCALE));
		bottomLeft = new Rectangle(0,1014 - (int)(0.75 * HUDSCALE),176 + (int)(2.0 * HUDSCALE),66 + (int)(0.75 * HUDSCALE));
	}
	
	public void capture(int delay){
		// Initial delay
		try{
			new Robot().delay(delay);
		}catch(AWTException e){
			e.printStackTrace();
		}
		
		// Top Right panel
		{			
			// Capture Region
			BufferedImage scaledImage = null;
			try {
				BufferedImage capture = new Robot().createScreenCapture(topRight);
				ResampleOp scaled = new ResampleOp(221,21); // resize at scale 0.
				scaledImage = scaled.filter(capture, null);
			} catch (AWTException e) {
				e.printStackTrace();
			}
			
			// Split the image
			try{
				// TeamKills
				ImageIO.write(scaledImage.getSubimage(8, 5, 16, 12), "bmp", new File("bmp/data/TeamKills/" + captureCounter + ".bmp"));
				// TeamDeaths
				ImageIO.write(scaledImage.getSubimage(35, 5, 16, 12), "bmp", new File("bmp/data/TeamDeaths/" + captureCounter + ".bmp"));
				// Kills
				ImageIO.write(scaledImage.getSubimage(68, 5, 16, 12), "bmp", new File("bmp/data/Kills/" + captureCounter + ".bmp"));
				// Deaths
				ImageIO.write(scaledImage.getSubimage(100, 5, 16, 12), "bmp", new File("bmp/data/Deaths/" + captureCounter + ".bmp"));
				// Assists
				ImageIO.write(scaledImage.getSubimage(127, 5, 16, 12), "bmp", new File("bmp/data/Assists/" + captureCounter + ".bmp"));
				// CS
				ImageIO.write(scaledImage.getSubimage(156, 5, 16, 12), "bmp", new File("bmp/data/CS/" + captureCounter + ".bmp"));
				// Time
				ImageIO.write(scaledImage.getSubimage(183, 5, 29, 12), "bmp", new File("bmp/data/Time/" + captureCounter + ".bmp"));
			}catch(IOException e){
				e.printStackTrace();
			}
		}
		
		// Bottom Left panel
		{
			// Capture region
			BufferedImage scaledImage = null;
			try {
				BufferedImage capture = new Robot().createScreenCapture(bottomLeft);
				ResampleOp scaled = new ResampleOp(176,66); // resize at scale 0.
				scaledImage = scaled.filter(capture, null);
			} catch (AWTException e) {
				e.printStackTrace();
			}
			
			// Split the image
			try{
				//Items1
				ImageIO.write(scaledImage.getSubimage(96, 3, 12, 19), "bmp", new File("bmp/data/Items1/" + captureCounter + ".bmp"));
				//Items2
				ImageIO.write(scaledImage.getSubimage(117, 3, 12, 19), "bmp", new File("bmp/data/Items2/" + captureCounter + ".bmp"));
				//Items3
				ImageIO.write(scaledImage.getSubimage(139, 3, 12, 19), "bmp", new File("bmp/data/Items3/" + captureCounter + ".bmp"));
				//Items4
				ImageIO.write(scaledImage.getSubimage(96, 25, 12, 19), "bmp", new File("bmp/data/Items4/" + captureCounter + ".bmp"));
				//Items5
				ImageIO.write(scaledImage.getSubimage(117, 25, 12, 19), "bmp", new File("bmp/data/Items5/" + captureCounter + ".bmp"));
				//Items6
				ImageIO.write(scaledImage.getSubimage(139, 25, 12, 19), "bmp", new File("bmp/data/Items6/" + captureCounter + ".bmp"));
				//Trinkets
				ImageIO.write(scaledImage.getSubimage(159, 14, 12, 19), "bmp", new File("bmp/data/Trinkets/" + captureCounter + ".bmp"));
				//Champion
				ImageIO.write(scaledImage.getSubimage(8, 6, 28, 42), "bmp", new File("bmp/data/Champion/" + captureCounter + ".bmp"));
				//Levels
				ImageIO.write(scaledImage.getSubimage(38, 37, 12, 10), "bmp", new File("bmp/data/Levels/" + captureCounter + ".bmp"));
				//Gold-odd1
				ImageIO.write(scaledImage.getSubimage(131, 49, 5, 11), "bmp", new File("bmp/data/Gold/Odd1/" + captureCounter + ".bmp"));
				//Gold-odd2
				ImageIO.write(scaledImage.getSubimage(136, 49, 5, 11), "bmp", new File("bmp/data/Gold/Odd2/" + captureCounter + ".bmp"));
				//Gold-odd3
				ImageIO.write(scaledImage.getSubimage(141, 49, 5, 11), "bmp", new File("bmp/data/Gold/Odd3/" + captureCounter + ".bmp"));
				//Gold-odd4
				ImageIO.write(scaledImage.getSubimage(146, 49, 5, 11), "bmp", new File("bmp/data/Gold/Odd4/" + captureCounter + ".bmp"));
				//Gold-odd5
				ImageIO.write(scaledImage.getSubimage(151, 49, 5, 11), "bmp", new File("bmp/data/Gold/Odd5/" + captureCounter + ".bmp"));
				//Gold-even1
				ImageIO.write(scaledImage.getSubimage(134, 49, 5, 11), "bmp", new File("bmp/data/Gold/Even1/" + captureCounter + ".bmp"));
				//Gold-even2
				ImageIO.write(scaledImage.getSubimage(139, 49, 5, 11), "bmp", new File("bmp/data/Gold/Even2/" + captureCounter + ".bmp"));
				//Gold-even3
				ImageIO.write(scaledImage.getSubimage(144, 49, 5, 11), "bmp", new File("bmp/data/Gold/Even3/" + captureCounter + ".bmp"));
				//Gold-even4
				ImageIO.write(scaledImage.getSubimage(149, 49, 5, 11), "bmp", new File("bmp/data/Gold/Even4/" + captureCounter + ".bmp"));
			}catch(IOException e){
				e.printStackTrace();
			}
		}
		
	}
	
	

}
