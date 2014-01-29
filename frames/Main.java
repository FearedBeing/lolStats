package frames;

import java.awt.CardLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

import panels.GameRecord;
import panels.Menu;

@SuppressWarnings("serial")
public class Main extends JFrame{
	private CardLayout layoutMngr;
	private JPanel contentPane;
	
	public Main(){
		// Frame Settings
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setSize(new Dimension(960,720));
		this.setTitle("lolStats");
		
		// Panel management
		layoutMngr = new CardLayout();
		contentPane = new JPanel(layoutMngr);
		contentPane.add(new Menu(this), "Menu");
		contentPane.add(new GameRecord(this), "GameRecord");
		this.setContentPane(contentPane);
		
		
		this.setVisible(true);
	}
	
	public void changePanel(String panelName){
		switch(panelName){
		case "Menu": layoutMngr.show(contentPane, "Menu"); break;
		case "GameRecord": layoutMngr.show(contentPane, "GameRecord"); break;
		}
	}
	
	
	// Program start
	public static void main(String[] args){
		new Main();
	}
	
	
	
	

}
