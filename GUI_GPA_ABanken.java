import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;
import javax.swing.*;

public class GUI_GPA_ABanken extends JFrame implements ActionListener{
	JPanel top =new JPanel();				//title panel	
	JPanel main =new JPanel();				//main center panel	
	JPanel p1 =new JPanel();				// Enter the number of courses line
	JPanel p2 =new JPanel();				// Pick the grade you got :
	JPanel p3 =new JPanel();				// a,b,c,d,f radio button line
	JPanel p4 =new JPanel();				// enter the number of credits for the course line
	JPanel p5 =new JPanel();				// click to add course info line
	JPanel p6 =new JPanel();				// cumulative gpa line
	
	JLabel titleLabel = new JLabel("GPA Calculator");
	JLabel coursesLabel = new JLabel("Enter Number of Courses: ");
	JLabel gradeLabel = new JLabel("Pick the grade you got: ");
	JLabel creditsLabel = new JLabel("Enter the number of credits for the course: ");
	JLabel cumulativeLabel = new JLabel("Cumulative GPA: ");
	
	JTextField coursesTF = new JTextField(4);		// courses text field
	JTextField creditsTF = new JTextField(4);		// credits text field
	JTextField cumulativeTF = new JTextField(4);	// cumulative gpa text field
	
	ButtonGroup group =new ButtonGroup();				//new button group 	
	
	JRadioButton AButton= new JRadioButton("A");
	JRadioButton BButton= new JRadioButton("B");
	JRadioButton CButton= new JRadioButton("C");
	JRadioButton DButton= new JRadioButton("D");
	JRadioButton FButton= new JRadioButton("F");
	
	JCheckBox hidden = new JCheckBox("");
	
	JButton courseinfoButton = new JButton("Click to add course info");
	
	int counter = 0;
	int coursesnumbers = 0;
	int creditsnumbers =0;
	double coursegpa = 0.0;
	double cumlativegpa = 0.0;
	double honorpoints = 0.0;
	double totalcredits = 0.0;

	double [] gradesarray = new double[0];
	double[] creditsarray = new double[0];
		
	public GUI_GPA_ABanken (){
		super ("GPA Calculator by Banken");
		this.add(top,BorderLayout.NORTH);
		this.add(main,BorderLayout.CENTER); 
		
		top.setBackground(Color.BLACK);
		main.setBackground(Color.BLACK);
		p1.setBackground(Color.BLACK);
		p2.setBackground(Color.BLACK);
		p3.setBackground(Color.BLACK);
		p4.setBackground(Color.BLACK);
		p5.setBackground(Color.BLACK);
		p6.setBackground(Color.BLACK);
		AButton.setBackground(Color.BLACK);
		BButton.setBackground(Color.BLACK);
		CButton.setBackground(Color.BLACK);
		DButton.setBackground(Color.BLACK);
		FButton.setBackground(Color.BLACK);
		
		titleLabel.setForeground(Color.WHITE);
		coursesLabel.setForeground(Color.WHITE);
		gradeLabel.setForeground(Color.WHITE);
		creditsLabel.setForeground(Color.WHITE);
		cumulativeLabel.setForeground(Color.WHITE);
		AButton.setForeground(Color.WHITE);
		BButton.setForeground(Color.WHITE);
		CButton.setForeground(Color.WHITE);
		DButton.setForeground(Color.WHITE);
		FButton.setForeground(Color.WHITE);
		
		top.add(titleLabel);
		
		main.add(p1);
		p1.add(coursesLabel);
		p1.add(coursesTF);
		
		main.add(p2);
		p2.add(gradeLabel);
		
		main.add(p3);
		p3.setLayout(new GridLayout(1, 5));
		p3.add(AButton);
		p3.add(BButton);
		p3.add(CButton);
		p3.add(DButton);
		p3.add(FButton);
		group.add(AButton);
		group.add(BButton);
		group.add(CButton);
		group.add(DButton);
		group.add(FButton);
		group.add(hidden);
		AButton.setEnabled(false);
		BButton.setEnabled(false);
		CButton.setEnabled(false);
		DButton.setEnabled(false);
		FButton.setEnabled(false);
		
		main.add(p4);
		p4.add (creditsLabel);
		p4.add(creditsTF);
		creditsTF.setEditable(false);
		
		main.add (p5);
		p5.add(courseinfoButton);
		courseinfoButton.setEnabled(false);
		
		main.add(p6);
		p6.add(cumulativeLabel);
		p6.add(cumulativeTF);
		
		cumulativeTF.setEditable(false);
		
		coursesTF.addActionListener(this);
		AButton.addActionListener(this);
		BButton.addActionListener(this);
		CButton.addActionListener(this);
		DButton.addActionListener(this);
		FButton.addActionListener(this);
		creditsTF.addActionListener(this);
		courseinfoButton.addActionListener(this);
	}
	public void actionPerformed(ActionEvent e) {
		Object event = e.getSource();		
		if (event == coursesTF){
			String usercourses = coursesTF.getText();
			try{	
				coursesnumbers = Integer.parseInt(usercourses);
				gradesarray = new double[coursesnumbers];
				creditsarray =  new double[coursesnumbers];
				AButton.setEnabled(true);
				BButton.setEnabled(true);
				CButton.setEnabled(true);
				DButton.setEnabled(true);
				FButton.setEnabled(true);
				coursesTF.setEditable(false);
				creditsTF.setEditable(true);
				creditsTF.requestFocus();				
			}//end try
			catch(NumberFormatException nf){
				JOptionPane.showMessageDialog(null,"Enter an Integer response!");
				coursesTF.setText("");
				coursesTF.requestFocus();
			}//end catch			
		}	
		for (int gb =0; gb < gradesarray.length; gb ++)	
		{
			if(event == AButton){
				gradesarray[gb]= 4.0;
			}
			else if(event == BButton){
				gradesarray[gb]= 3.0;
			}
			else if(event == CButton){
				gradesarray[gb]= 2.0;
			}
			else if(event == DButton){
				gradesarray[gb]= 1.0;
			}
			else if(event == FButton){
				gradesarray[gb]= 0.0;
			}
		for (int cb =0; cb < creditsarray.length; cb ++)
		{
		if (event == creditsTF){
			
			String usercredits = creditsTF.getText();
			try{
				creditsnumbers= Integer.parseInt(usercredits);
				creditsarray[cb] = creditsnumbers;
				courseinfoButton.setEnabled(true);
			}//end try
			catch(NumberFormatException nf){
				JOptionPane.showMessageDialog(null,"Enter an Integer responce!");
				creditsTF.setText("3");
				creditsTF.requestFocus();	
			}//end catch
		}
		if (event == courseinfoButton){
		
			
			DecimalFormat precision = new DecimalFormat("0.00");
			precision.format(cumlativegpa);
			totalcredits += creditsarray[cb];
			honorpoints += gradesarray[gb] * creditsarray[cb];
			cumlativegpa = honorpoints/totalcredits;
			cumulativeTF.setText( "" + cumlativegpa);
			creditsTF.setText("");
			creditsTF.requestFocus();
			hidden.setSelected(true);
			counter++;
			
		}//event coursebutton
	}	// first for loop
		}	//second for loop
	}		
	public static void main(String[] args) {
		GUI_GPA_ABanken aFrame = new GUI_GPA_ABanken();
		final int WIDTH = 330;
		final int HEIGHT = 300;
		aFrame.setSize(WIDTH, HEIGHT);
		aFrame.setVisible(true);
		aFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
