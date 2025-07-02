package TicTacToe;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class tictactoe implements ActionListener{

	String[][] textBoard = new String[3][3];
	JButton[][] buttons = new JButton[3][3];
	
	public static void main(String[] args) {
		new tictactoe();
	}
	

	JFrame frame = new JFrame();
	
	int height = 200;
	int width = 200;
	int distanceV = 20;
	int distanceH = 20;
	
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();;

	JButton vBorderLeft = new JButton();
	JButton vBorderRight = new JButton();
	JButton hBorderUp = new JButton();
	JButton hBorderDown = new JButton();
	
	public tictactoe() {
		frame.setVisible(true);
		frame.setSize(680+16,680+39);
		frame.setResizable(false);
		frame.setLayout(null);
		frame.setLocation(screenSize.width/2-frame.getWidth()/2,screenSize.height/2-frame.getHeight()/2);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		startGame();
	}
	
	public void startGame() {
		setBorders();
		setBorderIcons();
		fillArrays();
		setButtonLoc();
	}
	
	public void setBorders() {
		vBorderLeft.setVisible(true);
		vBorderLeft.setBounds(20+width+2,20,14,height*3+20*2);
		vBorderLeft.setBorder(null);
		vBorderLeft.setEnabled(false);
		frame.add(vBorderLeft);

		vBorderRight.setVisible(true);
		vBorderRight.setBounds((20+width)*2+2,20,14,height*3+20*2);
		vBorderRight.setBorder(null);
		vBorderRight.setEnabled(false);
		frame.add(vBorderRight);
		
		hBorderUp.setVisible(true);
		hBorderUp.setBounds(20,20+height+2,width*3+20*2,14);
		hBorderUp.setBorder(null);
		hBorderUp.setEnabled(false);
		frame.add(hBorderUp);
		
		hBorderDown.setVisible(true);
		hBorderDown.setBounds(20,(20+height)*2+2,width*3+20*2,14);
		hBorderDown.setBorder(null);
		hBorderDown.setEnabled(false);
		frame.add(hBorderDown);
	}
	
	public void setBorderIcons() {

		vBorderLeft.setIcon(new ImageIcon(getClass().getClassLoader().getResource("vBorder.jpg")));
		vBorderLeft.setDisabledIcon(new ImageIcon(getClass().getClassLoader().getResource("vBorder.jpg")));
		
		vBorderRight.setIcon(new ImageIcon(getClass().getClassLoader().getResource("vBorder.jpg")));
		vBorderRight.setDisabledIcon(new ImageIcon(getClass().getClassLoader().getResource("vBorder.jpg")));

		hBorderUp.setIcon(new ImageIcon(getClass().getClassLoader().getResource("hBorder.jpg")));
		hBorderUp.setDisabledIcon(new ImageIcon(getClass().getClassLoader().getResource("hBorder.jpg")));

		hBorderDown.setIcon(new ImageIcon(getClass().getClassLoader().getResource("hBorder.jpg")));
		hBorderDown.setDisabledIcon(new ImageIcon(getClass().getClassLoader().getResource("hBorder.jpg")));
	}
	
	public void fillArrays() {
		for(int i =0;i<buttons.length;i++) {
			for(int j=0;j<buttons[i].length;j++) {
				buttons[i][j] = new JButton();
				buttons[i][j].setVisible(true);
				buttons[i][j].addActionListener(this);
				buttons[i][j].setBorder(null);
				buttons[i][j].setEnabled(true);
				buttons[i][j].setIcon(new ImageIcon(getClass().getClassLoader().getResource("button200.jpg")));
				buttons[i][j].setDisabledIcon(new ImageIcon(getClass().getClassLoader().getResource("button200.jpg")));
				frame.add(buttons[i][j]);
				textBoard[i][j] = "";
			}
		}

	}
	
	public void setButtonLoc() {
		for(int i =0;i<buttons.length;i++) {
			for(int j=0;j<buttons[i].length;j++) {
				buttons[i][j].setBounds(distanceH,distanceV,width,height);
				distanceH+=width+20;
			}
			distanceH=20;
			distanceV+=height+20;
		}
	}
	
	public void checkWinner() {
		if((textBoard[0][0].equals("X")&&textBoard[0][1].equals("X")&&textBoard[0][2].equals("X"))||
		   (textBoard[1][0].equals("X")&&textBoard[1][1].equals("X")&&textBoard[1][2].equals("X"))||
		   (textBoard[2][0].equals("X")&&textBoard[2][1].equals("X")&&textBoard[2][2].equals("X"))||
		   (textBoard[0][0].equals("X")&&textBoard[1][0].equals("X")&&textBoard[2][0].equals("X"))||
		   (textBoard[0][1].equals("X")&&textBoard[1][1].equals("X")&&textBoard[2][1].equals("X"))||
		   (textBoard[0][2].equals("X")&&textBoard[1][2].equals("X")&&textBoard[2][2].equals("X"))||
		   (textBoard[0][0].equals("X")&&textBoard[1][1].equals("X")&&textBoard[2][2].equals("X"))||
		   (textBoard[0][2].equals("X")&&textBoard[1][1].equals("X")&&textBoard[2][0].equals("X"))) {
			
			disableButtons();
			JOptionPane.showMessageDialog(frame, "'X' is the Winner!");
			int input = JOptionPane.showConfirmDialog(frame, "Do you want to play again?", null, JOptionPane.OK_CANCEL_OPTION);
			if(input == JOptionPane.OK_OPTION) {

				new tictactoe();
				
			}else {
				System.exit(0);
			}
			
		}else if(
		   (textBoard[0][0].equals("O")&&textBoard[0][1].equals("O")&&textBoard[0][2].equals("O"))||
		   (textBoard[1][0].equals("O")&&textBoard[1][1].equals("O")&&textBoard[1][2].equals("O"))||
		   (textBoard[2][0].equals("O")&&textBoard[2][1].equals("O")&&textBoard[2][2].equals("O"))||
		   (textBoard[0][0].equals("O")&&textBoard[1][0].equals("O")&&textBoard[2][0].equals("O"))||
		   (textBoard[0][1].equals("O")&&textBoard[1][1].equals("O")&&textBoard[2][1].equals("O"))||
		   (textBoard[0][2].equals("O")&&textBoard[1][2].equals("O")&&textBoard[2][2].equals("O"))||
		   (textBoard[0][0].equals("O")&&textBoard[1][1].equals("O")&&textBoard[2][2].equals("O"))||
		   (textBoard[0][2].equals("O")&&textBoard[1][1].equals("O")&&textBoard[2][0].equals("O"))) {
			
			disableButtons();
			JOptionPane.showMessageDialog(frame, "'O' is the Winner!");
			int input = JOptionPane.showConfirmDialog(frame, "Do you want to play again?", null, JOptionPane.OK_CANCEL_OPTION);
			if(input == JOptionPane.OK_OPTION) {

				new tictactoe();
				
			}else {
				System.exit(0);
			}
			
		}else if(
				!buttons[0][0].isEnabled()&&!buttons[0][1].isEnabled()&&!buttons[0][2].isEnabled()&&
				!buttons[1][0].isEnabled()&&!buttons[1][1].isEnabled()&&!buttons[1][2].isEnabled()&&
				!buttons[2][0].isEnabled()&&!buttons[2][1].isEnabled()&&!buttons[2][2].isEnabled()) {
			
			JOptionPane.showMessageDialog(frame, "It's a draw!");
			int input = JOptionPane.showConfirmDialog(frame, "Do you want to play again?", null, JOptionPane.OK_CANCEL_OPTION);
			if(input == JOptionPane.OK_OPTION) {

				new tictactoe();
				
			}else {
				System.exit(0);
			}
		}
	}
	
	public void disableButtons() {
		for(int i =0;i<buttons.length;i++) {
			for(int j=0;j<buttons[i].length;j++) {
				if(textBoard[i][j].equals("")) {
					buttons[i][j].setEnabled(false);
				}
			}
		}
	}

	int turn = 0;
	
	@Override
	public void actionPerformed(ActionEvent e) {
		for(int i =0;i<buttons.length;i++) {
			for(int j=0;j<buttons[i].length;j++) {
				
				

				if(turn==0) {
					if(e.getSource()==buttons[i][j]&&textBoard[i][j].equals("")) {
						buttons[i][j].setText("X");
						textBoard[i][j] = "X";
						buttons[i][j].setIcon( new ImageIcon(getClass().getClassLoader().getResource("button200.jpg")));
						buttons[i][j].setDisabledIcon(new ImageIcon(getClass().getClassLoader().getResource("X.jpg")));
						buttons[i][j].setEnabled(false);
						checkWinner();
						turn = 1;
					}
				}else if(turn==1){
					if(e.getSource()==buttons[i][j]&&textBoard[i][j].equals("")) {
						buttons[i][j].setText("O");
						textBoard[i][j] = "O";
						buttons[i][j].setIcon( new ImageIcon(getClass().getClassLoader().getResource("button200.jpg")));
						buttons[i][j].setDisabledIcon(new ImageIcon(getClass().getClassLoader().getResource("O.jpg")));
						buttons[i][j].setEnabled(false);
						checkWinner();
						turn =0;
					}
				}
				
				
			}
		}
	}
}
