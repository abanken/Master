import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class MathGame extends JFrame implements ActionListener {
	JPanel main = new JPanel();
	JTextField num1tf = new JTextField(5);
	JTextField num2tf = new JTextField(5);
	JTextField guessTF = new JTextField(5);
	JButton checkButton = new JButton("Check sum");
	JTextField resultTF = new JTextField(20);

	JButton top = new JButton("Click to get two numbers to add:");
	JButton reset = new JButton("Reset");

	//variables
	int num1 = 0, num2 = 0, sum = 0, guess = 0;

	public MathGame(){
		super("Math Game");

		this.add(top,BorderLayout.NORTH);

		this.add(main,BorderLayout.CENTER);


		//main is a grid
		main.setLayout(new GridLayout(6, 1, 5, 5));  // 6 rows, 1 column, and 5 pixals of gap scaling
		main.add(num1tf);
		num1tf.setEditable(false);
		num1tf.setHorizontalAlignment(SwingConstants.CENTER);
		main.add(num2tf);
		num2tf.setEditable(false);
		num2tf.setHorizontalAlignment(SwingConstants.CENTER);
		main.add(guessTF);
		main.add(checkButton);
		main.add(resultTF);
		resultTF.setHorizontalAlignment(SwingConstants.CENTER);
		main.add(reset);

		top.addActionListener(this);
		checkButton.addActionListener(this);
		reset.addActionListener(this);
		guessTF.addActionListener(this);

	}

	public static void main(String[] args) {
		MathGame aFrame = new MathGame();
		final int WIDTH = 300;
		final int HEIGHT = 300;
		aFrame.setSize(WIDTH, HEIGHT);
		aFrame.setVisible(true);
		aFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object event = e.getSource();
		if (event== top ){
			num1 = (int)(Math.random()*50)+1;
			num2 = (int)(Math.random()*30)+1;
			
			//put into text fields
			num1tf.setText("" + num1);
			num2tf.setText("" + num2);
			
			//get the correct sunm
			sum = num1+num2;
			
			//clear guess field and set curosor there
			guessTF.setText("");
			guessTF.requestFocus();
			resultTF.setText("");
		}
		else if (event ==checkButton || event == guessTF){
			String guessStr = guessTF.getText();
			System.out.println(guessStr);
			try{
				guess = Integer.parseInt(guessStr);
			if (guess==sum){
				resultTF.setText("Good Answer");
			}
			else {
				resultTF.setText("Wrong! Correct answer is : " + sum);
			
			
			}
			}
			
			catch(NumberFormatException nf){
				JOptionPane.showMessageDialog(null,"Enter an Integer responce!");
				//clear guess field and set cursor there
				guessTF.setText("");
				guessTF.requestFocus();
			}//end catch
				
		}//else
		else if (event == reset){
			num1tf.setText("");
			num2tf.setText("");
			guessTF.setText("");
			guessTF.requestFocus();
			resultTF.setText("");
		}
	}
}
