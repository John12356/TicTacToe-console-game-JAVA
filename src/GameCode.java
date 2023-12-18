import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class GameCode implements ActionListener {
	Random random=new Random();
	JFrame frame=new JFrame("Tic Tac Toe");
	JPanel buttonPanel=new JPanel();
	JLabel textField=new JLabel();
	JPanel titlePanel = new JPanel();
	JButton[] buttons= new JButton[9];
	boolean player1Turn;
	GameCode(){
		
		frame.setVisible(true);
		frame.setSize(600,600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		frame.setResizable(true);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setPreferredSize(new Dimension(600,600));
		frame.setLayout(new BorderLayout());
		frame.getContentPane().setBackground(Color.DARK_GRAY);
		frame.pack();
		
		textField.setBackground(Color.black);
		textField.setForeground(Color.green);
		textField.setFont(new Font("Ink Free",Font.BOLD,75));
		textField.setHorizontalAlignment(JLabel.CENTER);
		textField.setText("Tic Tac Toe");
		textField.setOpaque(true);
		
		titlePanel.setLayout(new BorderLayout());
		titlePanel.setBounds(0,0,800,100);
		
		buttonPanel.setLayout(new GridLayout(3,3));
		buttonPanel.setBackground(new Color(150,150,150));
		
		for(int i=0;i<9;i++) {
			buttons[i]=new JButton();
			buttonPanel.add(buttons[i]);
			buttons[i].setFont(new Font("MV Boli",Font.BOLD,100));
			buttons[i].setFocusable(false);
			buttons[i].addActionListener(this);
		}
		
		titlePanel.add(textField);
		frame.add(textField,BorderLayout.NORTH);
		frame.add(buttonPanel);
		
		turn();
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		for(int i=0;i<9;i++) {
			if(e.getSource()==buttons[i]) {
				if(player1Turn) {
					if(buttons[i].getText()=="") {
						buttons[i].setForeground(new Color(255,0,0));
						buttons[i].setText("X");
						player1Turn=false;
						textField.setText("O Turn");
						check();
					}
				}
				else {
					if(buttons[i].getText()=="") {
						buttons[i].setForeground(new Color(0,0,255));
						buttons[i].setText("O");
						player1Turn=true;
						textField.setText("X Turn");
						check();
					}
				}
			}
		}
		
	}
	public void turn() {
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(random.nextInt(2)==0) {
			player1Turn=true;
			textField.setText("X Turn");
		}
		else {
			player1Turn=false;
			textField.setText("O Turn");
		}
		
	}
	public void check() {
		//for x
		if((buttons[0].getText()=="X") && (buttons[1].getText()=="X") && (buttons[2].getText()=="X")) {
			xWins(0,1,2);
		}
		if((buttons[6].getText()=="X") && (buttons[7].getText()=="X") && (buttons[8].getText()=="X")) {
			xWins(6,7,8);
		}
		if((buttons[0].getText()=="X") && (buttons[3].getText()=="X") && (buttons[6].getText()=="X")) {
			xWins(0,3,6);
		}
		if((buttons[1].getText()=="X") && (buttons[4].getText()=="X") && (buttons[7].getText()=="X")) {
			xWins(1,4,7);
		}
		if((buttons[2].getText()=="X") && (buttons[5].getText()=="X") && (buttons[8].getText()=="X")) {
			xWins(2,5,8);
		}
		if((buttons[0].getText()=="X") && (buttons[4].getText()=="X") && (buttons[8].getText()=="X")) {
			xWins(0,4,8);
		}
		if((buttons[2].getText()=="X") && (buttons[4].getText()=="X") && (buttons[6].getText()=="X")) {
			xWins(2,4,6);
		}
		if((buttons[3].getText()=="X") && (buttons[4].getText()=="X") && (buttons[5].getText()=="X")) {
			xWins(3,4,5);
		}
		//for o
		if((buttons[0].getText()=="O") && (buttons[1].getText()=="O") && (buttons[2].getText()=="O")) {
			oWins(0,1,2);
		}
		if((buttons[6].getText()=="O") && (buttons[7].getText()=="O") && (buttons[8].getText()=="O")) {
			oWins(6,7,8);
		}
		if((buttons[0].getText()=="O") && (buttons[3].getText()=="O") && (buttons[6].getText()=="O")) {
			oWins(0,3,6);
		}
		if((buttons[1].getText()=="O") && (buttons[4].getText()=="O") && (buttons[7].getText()=="O")) {
			oWins(1,4,7);
		}
		if((buttons[2].getText()=="O") && (buttons[5].getText()=="O") && (buttons[8].getText()=="O")) {
			oWins(2,5,8);
		}
		if((buttons[0].getText()=="O") && (buttons[4].getText()=="O") && (buttons[8].getText()=="O")) {
			oWins(0,4,8);
		}
		if((buttons[2].getText()=="O") && (buttons[4].getText()=="O") && (buttons[6].getText()=="O")) {
			oWins(2,4,6);
		}
		if((buttons[3].getText()=="O") && (buttons[4].getText()=="O") && (buttons[5].getText()=="O")) {
			oWins(3,4,5);
		}
	}
	
	public void xWins(int a,int b,int c) {
		buttons[a].setBackground(Color.GREEN);
		buttons[b].setBackground(Color.GREEN);
		buttons[c].setBackground(Color.GREEN);
		for(int i=0;i<9;i++) {
			buttons[i].setEnabled(false);
		}
		textField.setText("X Wins");
	}
	public void oWins(int a,int b,int c) {
		buttons[a].setBackground(Color.GREEN);
		buttons[b].setBackground(Color.GREEN);
		buttons[c].setBackground(Color.GREEN);
		for(int i=0;i<9;i++) {
			buttons[i].setEnabled(false);
		}
		textField.setText("O Wins");
	}
	
}
