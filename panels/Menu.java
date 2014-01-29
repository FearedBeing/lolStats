package panels;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;
import frames.Main;

@SuppressWarnings("serial")
public class Menu extends JPanel{
	private Main parent;
	
	public Menu(Main main){
		this.parent = main;
		this.setLayout(new MigLayout());
		
		JButton buttRecord = new JButton("Record a Game");
		buttRecord.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				parent.changePanel("GameRecord");
			}
		});
		this.add(buttRecord, "cell 0 0");
		JButton settings = new JButton("Settings");
		this.add(settings, "cell 0 1");
	}

}
