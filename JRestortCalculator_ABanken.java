import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
public class JRestortCalculator_ABanken extends JFrame implements ItemListener{
	// constants
	final int BASE_PRICE = 200;
	final int WEEKEND_PREMIUM = 100;
	final int BREAKFAST_PREMIUM = 20;
	final int GOLF_PREMIUM = 75;
	int totalPrice = BASE_PRICE;
	
	//JCheckbox Objects
	JCheckBox weekendBox = new JCheckBox (" Weekeend Premium $ "+ WEEKEND_PREMIUM, false);
	JCheckBox breakfastBox = new JCheckBox ("Breakfast $ " + BREAKFAST_PREMIUM, false);
	JCheckBox golfBox = new JCheckBox ("Golf $" +  GOLF_PREMIUM, false);
	
	//JLabels and text fields
	JLabel resortLabel = new JLabel(" Restort Price Caclulator");
	JLabel ePrice = new JLabel ("The price for your stay is ");
	JTextField totPrice = new JTextField (4);
	JLabel optionExplainLabel1 = new JLabel ("Base price for a room is $200");
	JLabel optionExplainLabel2 = new JLabel ("Check the options you want");
	
	//Class constructor 
	public JRestortCalculator_ABanken()
	{
		super("Resort Price Estimator");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout (new FlowLayout());
		add(resortLabel);
		add (optionExplainLabel1);
		add (optionExplainLabel2);
		add(weekendBox);
		add (breakfastBox);
		add (golfBox);
		add(ePrice);
		add(totPrice);
		totPrice.setText("$" + totalPrice);
		weekendBox.addItemListener(this);
		breakfastBox.addItemListener(this);
		golfBox.addItemListener(this);
		
	}
	
	public void itemStateChanged(ItemEvent event)
	{
		Object Source= event.getSource();
		int select = event.getStateChange();
		
		if (Source == weekendBox)
			if(select == ItemEvent.SELECTED)
				totalPrice += WEEKEND_PREMIUM;
		
			else totalPrice -= WEEKEND_PREMIUM;
		else if (Source == breakfastBox)
	
			if (select == ItemEvent.SELECTED)
				totalPrice += BREAKFAST_PREMIUM;
			else 
				totalPrice -= BREAKFAST_PREMIUM;
		
		else 
			if (select == ItemEvent.SELECTED)
				totalPrice += GOLF_PREMIUM;
			else
				totalPrice-= GOLF_PREMIUM;
		totPrice.setText("$" + totalPrice);
		
		
	}
	public static void main(String[] args) {
		JRestortCalculator_ABanken aFrame = new JRestortCalculator_ABanken();
		 final int WIDTH = 300;
		 final int HEIGHT = 200;
		 aFrame.setSize (WIDTH, HEIGHT);
		 aFrame.setVisible(true);
		
	}

}
