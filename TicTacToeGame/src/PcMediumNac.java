import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JFrame;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.util.Random;
import java.awt.event.ActionEvent;
import java.util.Random;


public class PcMediumNac extends JFrame implements ActionListener {
//Inizialize all the buttons, frame, variables and labels
	//private JFrame frame;
	private JLabel statusLabel;//Label where I'll print the result of the game and who has made the last move for each turn
	private JButton[] buttons;//array of buttons, so I can put all 9 buttons in one array
	private int counter=0; // counter that counts the total moves done
	private int userCount;//counter that count the total moves done by the user
	private int pcCount;//counter that count the total moves done by the computer
	String whoMoved; //Who made the last move

	public PcMediumNac() {
		
		JPanel game = new JPanel(); //inizialize JPanel
		statusLabel = new JLabel(); //initialize new JLabel
		statusLabel.setHorizontalAlignment(JLabel.CENTER);//set the alignment
		statusLabel.setForeground(Color.RED);// set the color of the text
		statusLabel.setFont(new Font("Arial", Font.PLAIN, 20));//set the format of the text
		game.setLayout(new GridLayout(3,3));//set layout using GridLayout with 3 rows and 3 columns
		
		buttons = new JButton[9];//initialize new JButtons with 9 elements
		
		for(int i=0;i<9;i++){ //entering all the buttons in the array
			buttons[i]=new JButton();
			buttons[i].setPreferredSize(new Dimension(60, 60));//set size of the buttons
			buttons[i].setBackground(Color.BLACK);//set color of the background of the buttons
			buttons[i].setForeground(Color.WHITE);//set color of the text in the buttons
			buttons[i].setFont(new Font("Arial", Font.PLAIN, 45));//set format of the text in the buttons
			buttons[i].addActionListener(this); //add an ActionListener to each button, add an "action" to each button
			game.add(buttons[i]);// add the buttons to the panel
		}		
		
		for(int k=0;k<1;k++){ 
			pcTurn();
			whoMoved="The computer ";
			displayWhoMadeTheMove(whoMoved);
			pcCount++;
			counter=pcCount+userCount;
			checkwinner();
			}
		
		getContentPane().add(game,BorderLayout.CENTER); //I use getConentPane because I'm creating a new JFrame Object and I need to put the values of the buttons initialize in game, in the frame.
		getContentPane().add(statusLabel,BorderLayout.SOUTH);
	}

public static void main() {
	// start the game
	PcMediumNac game = new PcMediumNac();
		game.setSize(500,500);
		game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		game.setVisible(true);	
	}

public void actionPerformed(ActionEvent e) {
	
	if(counter==-1){//It counter has been reseted as -1 if a winning message or draw message has been displayed
		//in this case, the table will be emptied.
		emptyTable();
		}
	
	else{
		for(JButton button : buttons){ //it's going to check all the buttons in the array!
			
			if (e.getSource()==button){ //if you press one specific button then
				if(button.getText().equals("")){//if it is empty 
						button.setText("O");//write X
						whoMoved="The user ";
						displayWhoMadeTheMove(whoMoved);//display who made the last move calling this function 
						userCount++;//increase counter for related to the user
						counter=userCount+pcCount;//set the new value for counter
						checkwinner();//check if someone wan
						if(counter != -1){//if the user not wan yet, go inside
						for(int k=0;k<1;k++){ //loop to go just once in the pcTurn function
							pcTurn();
							whoMoved="The computer ";
							displayWhoMadeTheMove(whoMoved);//display who made the last move calling this function 
							pcCount++;//increase counter for related to the pc
							}
					
			}}}}
				
				counter=userCount+pcCount;
				checkwinner(); 
			
	}}

private void emptyTable() {//delete the text in each button to have a new empty grid
	for(int i=0;i<9;i++){
		buttons[i].setText("");
		
	}
}

private void pcTurn() {
	//defense (see if the user is winning)
		if(buttons[0].getText().equals("O") && buttons[2].getText().equals("O")&&buttons[1].getText().equals("")) {
			buttons[1].setText("X");
		}
		else if(buttons[0].getText().equals("O") && buttons[6].getText().equals("O")&&buttons[3].getText().equals("")) {
			buttons[3].setText("X");
		}
		else if(buttons[2].getText().equals("O") && buttons[8].getText().equals("O")&&buttons[5].getText().equals("")) {
			buttons[5].setText("X");
		}
		else if(buttons[6].getText().equals("O") && buttons[8].getText().equals("O")&&buttons[7].getText().equals("")) {
			buttons[7].setText("X");
		}
		else if(buttons[0].getText().equals("O") && buttons[1].getText().equals("O")&&buttons[2].getText().equals("")){
			buttons[2].setText("X");
		}
		else if(buttons[1].getText().equals("O") && buttons[2].getText().equals("O")&&buttons[0].getText().equals("")) {
			buttons[0].setText("X");
		}
		else if(buttons[0].getText().equals("O") && buttons[3].getText().equals("O")&&buttons[6].getText().equals("")) {
			buttons[6].setText("X");
		}
		else if(buttons[0].getText().equals("O") && buttons[4].getText().equals("O")&&buttons[8].getText().equals("")) {
			buttons[8].setText("X");
		}
		else if(buttons[1].getText().equals("O") && buttons[4].getText().equals("O")&&buttons[7].getText().equals("")) {
			buttons[7].setText("X");
		}
		else if(buttons[2].getText().equals("O") && buttons[5].getText().equals("O")&&buttons[8].getText().equals("")) {
			buttons[8].setText("X");
		}
		else if(buttons[3].getText().equals("O") && buttons[4].getText().equals("O")&&buttons[5].getText().equals("")) {
			buttons[5].setText("X");
		}
		else if(buttons[3].getText().equals("O") && buttons[6].getText().equals("O")&&buttons[0].getText().equals("")){
			buttons[0].setText("X");
		}
		else if(buttons[4].getText().equals("O") && buttons[2].getText().equals("O")&&buttons[6].getText().equals("")) {
			buttons[6].setText("X");
		}
		else if(buttons[4].getText().equals("O") && buttons[5].getText().equals("O")&&buttons[3].getText().equals("")) {
			buttons[3].setText("X");
		}
		else if(buttons[4].getText().equals("O") && buttons[8].getText().equals("O")&&buttons[0].getText().equals("")) {
			buttons[0].setText("X");
		}
		else if(buttons[4].getText().equals("O") && buttons[7].getText().equals("O")&&buttons[1].getText().equals("")) {
			buttons[1].setText("X");
		}
		else if(buttons[4].getText().equals("O") && buttons[6].getText().equals("O")&&buttons[2].getText().equals("")) {
			buttons[2].setText("X");
		}
		else if(buttons[5].getText().equals("O") && buttons[8].getText().equals("O")&&buttons[2].getText().equals("")) {
			buttons[2].setText("X");
		}
		else if(buttons[8].getText().equals("O") && buttons[7].getText().equals("O")&&buttons[6].getText().equals("")) {
			buttons[6].setText("X");
		}//if it's not winning, put x in one of the corners or in the middle
		else if(buttons[4].getText().equals("")){
			buttons[4].setText("X");
		}
		else if(buttons[0].getText().equals("")){
			buttons[0].setText("X");
		}
		else if(buttons[2].getText().equals("")){
			buttons[2].setText("X");
		}
		else if(buttons[6].getText().equals("")){
			buttons[6].setText("X");
		}
		else if(buttons[8].getText().equals("")){
			buttons[8].setText("X");
		}
		
		else if (counter == 8){ //for the last round search for the only one empty button
			for(int i=0;i<9;i++){
					Random rand = new Random();
					i=rand.nextInt(9);
					if(buttons[i].getText().equals("")){
					buttons[i].setText("X");
				break;
			    }}
		}//if none of the above cases are happening search for an empty button
		else{
			for(int i=0;i<9;i++){
					Random rand = new Random();
					i=rand.nextInt(9);
			    if(buttons[i].getText().equals("")){
					buttons[i].setText("X");
					break;
			    }}
			}	
}	
private void checkwinner() {
	String result="";
	String winnerIS="";
	//check who wan, for each case , if the condition is true call the function to print the Label to show who is the winner
	//check row1 for the user
	if(buttons[0].getText().equals("O") && buttons[1].getText().equals("O") && buttons[2].getText().equals("O")){
		winnerIS="user";
		displayWinnerMessage(winnerIS);
		return;
	}//check row2 for the user
	else if(buttons[3].getText().equals("O") && buttons[4].getText().equals("O") && buttons[5].getText().equals("O")){
		winnerIS="user";
		displayWinnerMessage(winnerIS);
		return;
	}//check row3 for the user
	else if(buttons[6].getText().equals("O") && buttons[7].getText().equals("O") && buttons[8].getText().equals("O")){
		winnerIS="user";
		displayWinnerMessage(winnerIS);
		return;
	}//check column1 for the user
	else if(buttons[0].getText().equals("O") && buttons[3].getText().equals("O") && buttons[6].getText().equals("O")){
			winnerIS="user";
			displayWinnerMessage(winnerIS);
			return;
		}//check column2 for the user
	else if(buttons[1].getText().equals("O") && buttons[4].getText().equals("O") && buttons[7].getText().equals("O")){
			winnerIS="user";
			displayWinnerMessage(winnerIS);
			return;
		}//check column3 for the user
	else if(buttons[2].getText().equals("O") && buttons[5].getText().equals("O") && buttons[8].getText().equals("O")){
			winnerIS="user";
			displayWinnerMessage(winnerIS);
			return;
		}//check diagonal left to right for the user
	else if(buttons[0].getText().equals("O") && buttons[4].getText().equals("O") && buttons[8].getText().equals("O")){
			winnerIS="user";
			displayWinnerMessage(winnerIS);
			return;
		}//check diagonal right to left for the user
	else if(buttons[2].getText().equals("O") && buttons[4].getText().equals("O") && buttons[6].getText().equals("O")){
			winnerIS="user";
			displayWinnerMessage(winnerIS);
			return;
		}//the same for the computer (so check each row, column and diagonal) and call the function to print the Label to show the winner
	else if(buttons[0].getText().equals("X") && buttons[1].getText().equals("X") && buttons[2].getText().equals("X")){
		winnerIS="pc";
		displayWinnerMessage(winnerIS);
		return;
	}
	else if(buttons[3].getText().equals( "X") && buttons[4].getText().equals("X") &&buttons[5].getText().equals("X")){
		winnerIS="pc";
		displayWinnerMessage(winnerIS);
		return;
	}
	else if(buttons[6].getText().equals("X") && buttons[7].getText().equals("X") && buttons[8].getText().equals("X")){
		winnerIS="pc";
		displayWinnerMessage(winnerIS);
		return;
	}
	else if(buttons[0].getText().equals("X") && buttons[3].getText().equals("X") && buttons[6].getText().equals("X")){
		winnerIS="pc";
		displayWinnerMessage(winnerIS);
		return;
	}
	else if(buttons[1].getText().equals("X") && buttons[4].getText().equals("X") && buttons[7].getText().equals("X")){
		winnerIS="pc";
		displayWinnerMessage(winnerIS);
		return;
	}
	else if(buttons[2].getText().equals("X") && buttons[5].getText().equals("X") && buttons[8].getText().equals("X")){
		winnerIS="pc";
		displayWinnerMessage(winnerIS);
		return;
	}
	else if(buttons[0].getText().equals("X") && buttons[4].getText().equals("X") && buttons[8].getText().equals("X")){
		winnerIS="pc";
		displayWinnerMessage(winnerIS);
		return;
	}
	else if(buttons[2].getText().equals("X") && buttons[4].getText().equals("X") && buttons[6].getText().equals("X")){
		winnerIS="pc";
		displayWinnerMessage(winnerIS);
		return;
	}
	else if (counter == 9){//if we are in the last turn and anyone wan it's a DRAW call the function to print the Label DRAW
		result="DRAW";
		displayDrawMessage(result);
		return;
	}	
	
	
}
private void displayWinnerMessage(String winnerIS) {//function to print who is the winner
    statusLabel.setText(" The Winner is: " + winnerIS);
    counter=-1;//set counter = -1 
    windowOption.main(null);// call the main class to start a new game
}
private void displayDrawMessage(String result) {//function to print the result DRAW
	   statusLabel.setText(result);
	   counter=-1;
	   windowOption.main(null);// call the main class to start a new game
	}
	private void displayWhoMadeTheMove(String whoMoved){//function to print who made the last move
		statusLabel.setText(whoMoved + " has made the move.");
	}
	}