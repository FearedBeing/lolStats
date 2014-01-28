package panels;

import java.awt.CardLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import ressources.ComboBox;
import net.miginfocom.swing.MigLayout;

@SuppressWarnings("serial")
public class GameRecord extends JPanel{
	
	JPanel header, gameInfo, matchUp, party, control;
	
	public GameRecord(){
		this.initializeSubPanes(); // Initializing SubPanes
		
		// Layout Management
		this.setLayout(new MigLayout("fill","50[fill]30[fill]30[fill]50","50px[fill]50px"));
		this.add(header, "spanx 3, dock north");
		this.add(gameInfo, "cell 0 0");
		this.add(matchUp, "cell 1 0");
		this.add(party, "cell 2 0");
		this.add(control, "spanx 3, dock south");
		
	}
	
	private void initializeSubPanes(){
		this.header = new HeaderPanel();
		this.gameInfo = new GameInfoPanel();
		this.matchUp = new MatchUpPanel();
		this.party = new PartyPanel();
		this.control = new ControlPanel();
	}
	
	private class HeaderPanel extends JPanel{
		
		public HeaderPanel(){
			this.setLayout(new MigLayout());
			JLabel lbl = new JLabel("Game Logger");
			lbl.setFont(new Font(lbl.getFont().getName(), Font.BOLD, 36));
			lbl.setHorizontalAlignment(JLabel.CENTER);
			this.add(lbl, "cell 0 0, dock center");
		}
	}
	
	private class GameInfoPanel extends JPanel{
		private JComboBox<String> cbPatch, cbMode, cbType, cbSide, cbVictory;
		
		public GameInfoPanel(){
			this.initializeCB(); // Initializing comboBoxes
			
			// Layout management
			this.setLayout(new MigLayout("fill","fill","fill"));
			this.add(new JLabel("Patch"), "cell 0 0");
			this.add(new JLabel("Mode"), "cell 0 1");
			this.add(new JLabel("Type"), "cell 0 2");
			this.add(new JLabel("Side"), "cell 0 3");
			this.add(new JLabel("Victory"), "cell 0 4");
			this.add(cbPatch, "cell 1 0");
			this.add(cbMode, "cell 1 1");
			this.add(cbType, "cell 1 2");
			this.add(cbSide, "cell 1 3");
			this.add(cbVictory, "cell 1 4");
		}
		
		private void initializeCB(){
			cbPatch = new JComboBox<String>(ComboBox.patchList);
			cbMode = new JComboBox<String>(ComboBox.modeList);
			cbType = new JComboBox<String>(ComboBox.typeList);
			cbSide = new JComboBox<String>(ComboBox.sideList);
			cbVictory = new JComboBox<String>(ComboBox.victoryList);
		}
	}
	
	private class MatchUpPanel extends JPanel{
		private JComboBox<String> cbPosition, cbOpponent, cbAllyDuo, cbEnemyDuo;
		
		public MatchUpPanel(){
			this.initializeCB(); // Initializing comboBoxes
			
			// Layout Management
			this.setLayout(new MigLayout("fill","fill","fill"));
			this.add(new JLabel("Position"), "cell 0 0");
			this.add(new JLabel("Opponent"), "cell 0 1");
			this.add(new JLabel("Ally Duo"), "cell 0 2");
			this.add(new JLabel("Enemy Duo"), "cell 0 3");
			this.add(cbPosition, "cell 1 0");
			this.add(cbOpponent, "cell 1 1");
			this.add(cbAllyDuo, "cell 1 2");
			this.add(cbEnemyDuo, "cell 1 3");
		}
		
		private void initializeCB(){
			cbPosition = new JComboBox<String>(ComboBox.positionList);
			cbOpponent = new JComboBox<String>(ComboBox.championList);
			cbAllyDuo = new JComboBox<String>(ComboBox.championList);
			cbEnemyDuo = new JComboBox<String>(ComboBox.championList);
		}
	}
	
	private class PartyPanel extends JPanel{
		private ArrayList<JComboBox<String>> cbPosition, cbChampion;
		private ArrayList<JTextField> tfName, tfKills, tfAssists, tfDeaths, tfCS, tfGold;
		private ArrayList<JButton> back, next;
		CardLayout layoutMngr;
		
		public PartyPanel(){
			this.initializeComponents(); // Initialize the lists
			
			//Layout Management
			layoutMngr = new CardLayout();
			this.setLayout(layoutMngr);
			for(int k=0; k<4; k++){
				JPanel pane = new JPanel();
				pane.setLayout(new MigLayout("fill","fill","fill"));
				pane.add(new JLabel("Name"), "cell 0 0");
				pane.add(new JLabel("Champion"), "cell 0 1");
				pane.add(new JLabel("Position"), "cell 0 2");
				pane.add(new JLabel("Kills"), "cell 0 3");
				pane.add(new JLabel("Deaths"), "cell 0 4");
				pane.add(new JLabel("Assists"), "cell 0 5");
				pane.add(new JLabel("CS"), "cell 0 6");
				pane.add(new JLabel("Gold"), "cell 0 7");
				pane.add(back.get(k), "cell 0 8");
				pane.add(tfName.get(k), "cell 1 0");
				pane.add(cbChampion.get(k), "cell 1 1");
				pane.add(cbPosition.get(k), "cell 1 2");
				pane.add(tfKills.get(k), "cell 1 3");
				pane.add(tfDeaths.get(k), "cell 1 4");
				pane.add(tfAssists.get(k), "cell 1 5");
				pane.add(tfCS.get(k), "cell 1 6");
				pane.add(tfGold.get(k), "cell 1 7");
				pane.add(next.get(k), "cell 1 8");
				this.add(pane);
			}
		}
		
		private void initializeComponents(){
			cbPosition = new ArrayList<JComboBox<String>>();
			cbChampion = new ArrayList<JComboBox<String>>();
			tfName = new ArrayList<JTextField>();
			tfKills = new ArrayList<JTextField>();
			tfAssists = new ArrayList<JTextField>();
			tfDeaths = new ArrayList<JTextField>();
			tfCS = new ArrayList<JTextField>();
			tfGold = new ArrayList<JTextField>();
			back = new ArrayList<JButton>();
			next = new ArrayList<JButton>();
			
			for(int k=0; k<4; k++){
				cbPosition.add(new JComboBox<String>(ComboBox.positionList));
				cbChampion.add(new JComboBox<String>(ComboBox.championList));
				tfName.add(new JTextField());
				tfKills.add(new JTextField());
				tfAssists.add(new JTextField());
				tfDeaths.add(new JTextField());
				tfCS.add(new JTextField());
				tfGold.add(new JTextField());
				back.add(new JButton("Back"));
				next.add(new JButton("Next"));
				back.get(k).addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e){
						layoutMngr.previous(PartyPanel.this);
					}
				});
				next.get(k).addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e){
						layoutMngr.next(PartyPanel.this);
					}
				});
			}
			back.get(0).setEnabled(false);
			next.get(3).setEnabled(false);
		}
	}
	
	private class ControlPanel extends JPanel{
		public JButton back, save;
		public JLabel status;
		
		public ControlPanel(){
			this.initializeComponents();
			
			// Layout Management
			this.setLayout(new MigLayout("fill","fill",""));
			this.add(back, "cell 0 0");
			this.add(status, "cell 1 0");
			this.add(save, "cell 2 0");
		}
		
		private void initializeComponents(){
			back = new JButton("Back to Menu");
			save = new JButton("Save this Game");
			
			status = new JLabel("STATUS");
			status.setHorizontalAlignment(JLabel.CENTER);
		}
	}

}
