package panels;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import ressources.ComboBox;
import net.miginfocom.swing.MigLayout;

@SuppressWarnings("serial")
public class GameRecord extends JPanel{
	JComboBox<String> cbPatch, cbMode, cbType, cbSide, cbVictory;
	JComboBox<String> cbPosition, cbOpponent, cbAllyDuo, cbEnemyDuo;
	JPanel gameInfo, matchUp;
	
	public GameRecord(){
		initializeCB(); // Initializing all comboBoxes
		initializeSubPanes();
		
		this.setLayout(new MigLayout());
		this.add(gameInfo, "cell 0 0");
		this.add(matchUp, "cell 1 0");
		
		
	
	}
	
	private void initializeSubPanes(){
		// GameInfo
		gameInfo = new JPanel();
		gameInfo.setLayout(new MigLayout());
		gameInfo.add(new JLabel("Patch"), "cell 0 0");
		gameInfo.add(new JLabel("Mode"), "cell 0 1");
		gameInfo.add(new JLabel("Type"), "cell 0 2");
		gameInfo.add(new JLabel("Side"), "cell 0 3");
		gameInfo.add(new JLabel("Victory"), "cell 0 4");
		gameInfo.add(cbPatch, "cell 1 0");
		gameInfo.add(cbMode, "cell 1 1");
		gameInfo.add(cbType, "cell 1 2");
		gameInfo.add(cbSide, "cell 1 3");
		gameInfo.add(cbVictory, "cell 1 4");
		
		// Match-up
		matchUp = new JPanel();
		matchUp.setLayout(new MigLayout());
		matchUp.add(new JLabel("Position"), "cell 0 0");
		matchUp.add(new JLabel("Opponent"), "cell 0 1");
		matchUp.add(new JLabel("Ally Duo"), "cell 0 2");
		matchUp.add(new JLabel("Enemy Duo"), "cell 0 3");
		matchUp.add(cbPosition, "cell 1 0");
		matchUp.add(cbOpponent, "cell 1 1");
		matchUp.add(cbAllyDuo, "cell 1 2");
		matchUp.add(cbEnemyDuo, "cell 1 3");
	}
	
	private void initializeCB(){
		cbPatch = new JComboBox<String>(ComboBox.patchList);
		cbMode = new JComboBox<String>(ComboBox.modeList);
		cbType = new JComboBox<String>(ComboBox.typeList);
		cbSide = new JComboBox<String>(ComboBox.sideList);
		cbVictory = new JComboBox<String>(ComboBox.victoryList);
		cbPosition = new JComboBox<String>(ComboBox.positionList);
		cbOpponent = new JComboBox<String>(ComboBox.championList);
		cbAllyDuo = new JComboBox<String>(ComboBox.championList);
		cbEnemyDuo = new JComboBox<String>(ComboBox.championList);
	}

}
