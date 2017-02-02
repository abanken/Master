import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Gui_Assign3_ABanken extends JFrame implements ItemListener, ActionListener{
	
	JLabel titlelabel = new JLabel("Welcome to Jimmie Pizza Calculator");   	//title label
	JLabel pizzatypelabel = new JLabel("Size of pizza : ");   					//pizza type label label
	JLabel numpizzalabel = new JLabel("Number of pizzas : ");   				//number of pizzas label
	JLabel numtoppinglabel = new JLabel("Number of toppings : ");   			//number of toppings label
	JLabel totalpricelabel = new JLabel("Total price");   						//total price label
	
	
	Font titleFont = new Font("Comic Sans MS", Font.BOLD, 24);					//title font
	Font numpizzaFont = new Font(" Comic Sans MS",Font.BOLD, 16);				// number of pizzas font
	Font pizzatypeFont = new Font(" Comic Sans MS",Font.BOLD, 16);				//pizza size font
	Font numtoppingFont = new Font(" Comic Sans MS",Font.BOLD, 16);				//topping font
		
	String[] numpizza = {"Select the number of pizzas", "1" , "2", "3", "4" , "5"};		// user number sof pizzas
	String[] numpizzaselected = {"", "1", "2", "3", "4", "5"};							// number of pizza selected
	String[] pizzasize = {"Select the size of pizza", "Small", "Medium", "Large", "Jumbo"};// pizza type array
	String[] pizzaprice = {"", "$7.00","$9.00","$11.00" , "$14.00"};					// pizza type pricing array
	String[] numtopping = {"Select the number of toppings" , "1", "2", "3", "4","5"}; 	//meat topping total array
	String[] toppingprice = {"", "$1.00" , "$2.00" , "$3.00" ,"$4.00" , "$5.00"};   	//meat topping pricing array
		

	final double SMALLP = 7.00;							//small pizza price
	final double MEDIUMP = 9.00;						//medium pizza price
	final double LARGEP = 11.00;						//large pizza price
	final double JUMBOP = 14.00;						//jumbo pizza price
	final double MEATTOPPING = 1.00;							// meat topping price
	final double EXTRACHEESE = 2.00;							// extra cheese price
	final double EATIN = 4.00;									// eat in price
	final double DELIVERY = 6.00;								// delivery price
	double totalprice = 0;							//total price of delivery or eatin AND cheese
	double baseprice = 0;							//total for pizza size* number of pizza
	double meatprice = 0;							//total for meat toppings price* number of pizza
	double sum = 0;									//TOTAL OF EVERYTHING
	
	JRadioButton eatinButton= new JRadioButton("Eat-in $4.00");		//eat in option RADIOBOX
	JRadioButton deliveryButton= new JRadioButton("Delivery $6.00");	//delivery option RADIOBOX
	
	JCheckBox cheeseBox = new JCheckBox ("Extra cheese $2.00", false);	//cheese check boxJComboBox<String> numpizzaJC = new JComboBox (numpizza);	//number of pizza combo box
	JCheckBox hidden = new JCheckBox("");							// Reset button
	
	JComboBox<String> numpizzaJC = new JComboBox (numpizza);	//combo box number of pizza
	JComboBox<String> pizzasizeJC = new JComboBox (pizzasize);	//combo box pizza size
	JComboBox<String> numtoppingJC = new JComboBox (numtopping);	//number of meat topping text field

	
	JTextField numpizzaTF = new JTextField(8);				//number of pizza text field
	JTextField totalpriceTF = new JTextField(8);			//total price text field
	JTextField sizepriceTF = new JTextField(8);				//number of pizza text field
	JTextField toppingpriceTF = new JTextField(8);			// meat topping price text field
		
	JButton checkedButton= new JButton("");				// Checked button
	JButton reset = new JButton("Reset");				//Rest button
	ButtonGroup group =new ButtonGroup();				//new button group 
	
	JPanel p1 = new JPanel ();						// p1= north
	JPanel p2 = new JPanel ();						// p2= center


	
	
	//Constructor
	public Gui_Assign3_ABanken(){
		// call super class
		super("Jimmie Pizza Order Application");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		 //layout order
		setLayout (new FlowLayout());	

		//set frame layout
		this.setLayout(new BorderLayout());

		//add the panels to the frame
		this.add(p1, BorderLayout.NORTH);
		this.add(p2, BorderLayout.CENTER);


		//color panels
		p1.setBackground(Color.BLACK);									//setting p1 background 
		titlelabel.setForeground(Color.WHITE);							//setting  p1 font color 
		titlelabel.setFont(titleFont);									//setting  p1 font
		p2.setBackground(Color.ORANGE);									//setting p2 background
		numpizzalabel.setFont(numpizzaFont);							//setting numpizzaalabel font
		pizzatypelabel.setFont(pizzatypeFont);							//setting pizzatypelabel font
		numtoppinglabel.setFont(numtoppingFont);						//setting numtoppinglabel font
		
		sizepriceTF.setEditable(false);			//setting so text field can't be edited
		numpizzaTF.setEditable(false);			
		toppingpriceTF.setEditable(false);		
		totalpriceTF.setEditable(false);
		
		p1.add(titlelabel);						//adding title label
		
		p2.add(numpizzalabel);					//number of pizza label
		p2.add(numpizzaJC);						//number of pizza COMBOBOX
		p2.add(numpizzaTF);						//numpizza TEXT FIELD
		p2.add (pizzatypelabel);				//pizza type LABEL
		p2.add(pizzasizeJC);					//pizza size COMBOBOX
		p2.add(sizepriceTF);					//size price TEXT FIELD
		p2.add(numtoppinglabel);				//number of topping LABEL
		p2.add(numtoppingJC);					//number of topping COMBOBOX
		p2.add(toppingpriceTF);					//number of topping TEXT FIELD
		p2.add (cheeseBox);						//cheese check box
		p2.add(eatinButton);					// eat in BUTTON
		p2.add(deliveryButton);					// delivery BUTTON
		p2.add (totalpricelabel); 				//adding total price LABEL
		p2.add(totalpriceTF);					//adding total price TEXT FEILD
		p2.add (reset);							// adding reset BUTTON

		group.add(eatinButton);					// grouping delivery,eatin, and reset buttons
		group.add(deliveryButton);
		group.add(hidden);
	
		//activating items and actions
		numpizzaJC.addItemListener(this);
		numtoppingJC.addItemListener(this);
		pizzasizeJC.addItemListener(this);
		eatinButton.addItemListener(this);
		deliveryButton.addItemListener(this);
		cheeseBox.addItemListener(this);
		reset.addActionListener(this);
	}
	@Override
	public void itemStateChanged (ItemEvent ie){
		//find out what index was chosen
		Object source = ie.getSource();
		int select = ie.getStateChange();
		// EATIN
		if(source == eatinButton)
			if(select == ItemEvent.SELECTED)
				totalprice += EATIN;	
			else
				totalprice -= EATIN;
		//DELIVERY
		else if (source  == deliveryButton)
			if(select == ItemEvent.SELECTED)
					totalprice += DELIVERY;	
			else
				totalprice -= DELIVERY;
		//CHEESEBOX
		if(source == cheeseBox)
			if(select == ItemEvent.SELECTED)
					totalprice += EXTRACHEESE;
			else 
					totalprice -= EXTRACHEESE;
		
		//SETTING  number of pizza in text field	
		int indexSelected = numpizzaJC.getSelectedIndex();
		numpizzaTF.setText(numpizzaselected[indexSelected]);
		
		//SETTING  pizza size price in text field
		int indexSelected2 = pizzasizeJC.getSelectedIndex();
		sizepriceTF.setText(pizzaprice[indexSelected2]);
		
		//SETTING  topping price in text field
		int indexSelected3 = numtoppingJC.getSelectedIndex();
		toppingpriceTF.setText(toppingprice[indexSelected3]);
		
		//PIZZA SIZE
		if(indexSelected2 == 1){
				baseprice += SMALLP *indexSelected ;
		}
		else if(indexSelected2 ==2){
				baseprice += MEDIUMP *indexSelected ;
		}
		else  if(indexSelected2 == 3){
				baseprice += LARGEP *indexSelected ;
		}		
		else if(indexSelected2 == 4){
				baseprice += JUMBOP *indexSelected ;
		}
		 //MEATTOPPINGS
		if(indexSelected3 == 1){
				meatprice += MEATTOPPING* indexSelected;
		}
		else if(indexSelected3 == 2){
				meatprice += (MEATTOPPING *2)* indexSelected;
		}
		else if(indexSelected3 == 3){
				meatprice += (MEATTOPPING *3)* indexSelected;
		}
		else if(indexSelected3 == 4){
				meatprice += (MEATTOPPING *4)* indexSelected;
		}
		else if(indexSelected3 == 5){
				meatprice += (MEATTOPPING * 5)*indexSelected;	
		}
		
		//getting total of EVERYTHING and displaying it
	
		sum += baseprice += meatprice += totalprice;
		totalpriceTF.setText("$" + sum);
		baseprice=0;
		meatprice=0;
		sum=0;
		
	}//end itemStateChanged()

	public void actionPerformed (ActionEvent ae){
			//reset button
			numpizzaJC.setSelectedIndex(0);		
			numpizzaTF.setText("");
			numtoppingJC.setSelectedIndex(0);
			sizepriceTF.setText("");
			pizzasizeJC.setSelectedIndex(0);
			toppingpriceTF.setText("");
			cheeseBox.setSelected(false);
			hidden.setSelected(true);
			totalpriceTF.setText("");
		}
	public static void main(String[] args) {
		Gui_Assign3_ABanken aFrame = new Gui_Assign3_ABanken();
		 final int WIDTH = 550;
		 final int HEIGHT = 300;
		 aFrame.setSize (WIDTH, HEIGHT);
		 aFrame.setVisible(true);
	}
}
