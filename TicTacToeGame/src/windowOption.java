import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JRadioButton;

import java.awt.Font;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.UIManager;
// this application permits you to play the Naught and Crosses game against the computer. you can choose the level
//of the difficulty and you can choose to start the game or to let the computer start first.
//you can select first who starts and then the level or vice versa.
//NB if you press easy but then you change your mind and you want to try with the difficult level, you can press difficult 
//and then choose who starts the game. however as soon as you have pressed one level and who starts first, 
//the application is going to open the grid to play the game.
//at the end of each game you'll see the result and you can start a new game!
//Have fun!
public class windowOption {

	private JFrame frame;
	String isStarting="";
	String level="";
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					windowOption window = new windowOption();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public windowOption() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(204, 204, 255));
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		//label choose difficulty
		JLabel lblChooseDifficulty = new JLabel("Choose difficulty :");
		lblChooseDifficulty.setForeground(new Color(0, 0, 153));
		lblChooseDifficulty.setFont(new Font("Bookman Old Style", Font.BOLD, 22));
		lblChooseDifficulty.setBounds(10, 11, 264, 27);
		frame.getContentPane().add(lblChooseDifficulty);
		//initialize buttons related to the level
		JButton btnEasy = new JButton("EASY");
		JButton btnMedium = new JButton("MEDIUM");
		JButton btnDifficult = new JButton("DIFFICULT");
		JButton btnUser = new JButton("USER");
		JButton btnComputer = new JButton("COMPUTER");
		
		//set format for those buttons
		
		btnEasy.setBackground(SystemColor.control);
		btnEasy.setForeground(new Color(0, 0, 153));
		
		
		btnMedium.setBackground(SystemColor.control);
		btnMedium.setForeground(new Color(0, 0, 153));
		
		
		btnDifficult.setForeground(new Color(0, 0, 153));
		btnDifficult.setBackground(SystemColor.control);
	
		//ad action to each button
		btnEasy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				level= "easy";
				btnEasy.setBackground(Color.BLUE);
				btnMedium.setBackground(Color.LIGHT_GRAY);
				btnDifficult.setBackground(Color.LIGHT_GRAY);
				if(e.getSource().equals(btnEasy) && isStarting.equals("Computer")){
					PcEasyNaC.main();
				}
				else if(e.getSource().equals(btnEasy) && isStarting.equals("User")){
					UserEasyNaC.main();
				}				
				else if(e.getSource().equals(btnEasy)&& isStarting.equals("")){
					
				}
				
			}
		});
		btnEasy.setBounds(31, 68, 82, 37);
		frame.getContentPane().add(btnEasy);
		
		
		
		
		btnMedium.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				level= "medium";
				btnEasy.setBackground(Color.LIGHT_GRAY);
				btnMedium.setBackground(Color.BLUE);
				btnDifficult.setBackground(Color.LIGHT_GRAY);
				if(e.getSource().equals(btnMedium) && isStarting.equals("Computer")){
					PcMediumNac.main();
				}
				else if(e.getSource().equals(btnMedium) && isStarting.equals("User")){
					UserMediumNaC.main();
				}
				else if(e.getSource().equals(btnMedium)&& isStarting.equals("")){
				}
							
				//btnMedium.setEnabled(false);
			}
		});
		btnMedium.setBounds(137, 68, 106, 37);
		frame.getContentPane().add(btnMedium);
		
		
		btnDifficult.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				level= "difficult";
				btnEasy.setBackground(Color.LIGHT_GRAY);
				btnMedium.setBackground(Color.LIGHT_GRAY);
				btnDifficult.setBackground(Color.BLUE);
				
				if(e.getSource().equals(btnDifficult) && isStarting.equals("Computer")){
					PcDifficultNaC.main();
				}
				else if(e.getSource().equals(btnDifficult) && isStarting.equals("User")){
					UserDifficultNaC.main();
				}
				else if(e.getSource().equals(btnDifficult)&& isStarting.equals("")){
					
				}
				//btnDifficult.setEnabled(false);
			}
		});
		btnDifficult.setBounds(253, 68, 118, 37);
		frame.getContentPane().add(btnDifficult);
		
		
		btnUser.setBackground(SystemColor.control);
		btnUser.setForeground(new Color(51, 0, 153));
		btnUser.setFont(new Font("Bookman Old Style", Font.PLAIN, 17));
		btnUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnUser.setBackground(Color.BLUE);
				btnComputer.setBackground(Color.LIGHT_GRAY);
				isStarting="User";
				if(e.getSource().equals(btnUser) && level.equals("easy")){
					UserEasyNaC.main();
					
				}
				else if(e.getSource().equals(btnUser) && level.equals("medium")){
					UserMediumNaC.main();
				}
				else if(e.getSource().equals(btnUser) && level.equals("difficult")){
					UserDifficultNaC.main();
				}
				else if(e.getSource().equals(btnUser)&& level.equals("")){
					
				}
				
			}
		});
		btnUser.setBounds(85, 190, 89, 48);
		frame.getContentPane().add(btnUser);
		
		
		btnComputer.setEnabled(true);
		btnComputer.setBackground(SystemColor.control);
		btnComputer.setForeground(new Color(51, 0, 153));
		btnComputer.setFont(new Font("Bookman Old Style", Font.PLAIN, 17));
		btnComputer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnUser.setBackground(Color.LIGHT_GRAY);
				btnComputer.setBackground(Color.BLUE);
				isStarting="Computer";
				if(e.getSource().equals(btnComputer) && level.equals("easy")){
					PcEasyNaC.main();
				}
				else if(e.getSource().equals(btnComputer) && level.equals("medium")){
					PcMediumNac.main();
				}
				else if(e.getSource().equals(btnComputer) && level.equals("difficult")){
					PcDifficultNaC.main();
				}
				else if(e.getSource().equals(btnComputer)&& level.equals("")){
					
				}
				
			}
		});
		btnComputer.setBounds(213, 190, 139, 48);
		frame.getContentPane().add(btnComputer);
		
		JLabel lblWhoDoYou = new JLabel("Who do you want to start first?");
		lblWhoDoYou.setForeground(new Color(51, 0, 153));
		lblWhoDoYou.setFont(new Font("Bookman Old Style", Font.BOLD, 25));
		lblWhoDoYou.setBounds(10, 116, 424, 63);
		frame.getContentPane().add(lblWhoDoYou);
		
	
	}
}
