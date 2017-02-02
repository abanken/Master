import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class JMouseActionFrame extends JFrame implements MouseListener{
//variables
	private int x, y ;   //for the mouse coordinates
	private JLabel label  = new JLabel ("Do something with the mouse.");
	String msg = "";
	
	//Constructor
	public JMouseActionFrame(){
		super("MouseActiosn");
		this.setLayout(new FlowLayout());
		this.addMouseListener(this);
		this.add(label);
	}
	
	public static void main(String[] args) {
		JMouseActionFrame aFrame = new JMouseActionFrame ();
		aFrame.setSize(750,300);
		aFrame.setVisible(true);
		aFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		//determine which mouse button was cliked
		int whichButton = e.getButton();
		msg ="You pressed mouse";
		if(whichButton == MouseEvent.BUTTON1){
			msg += "button 1(left button) . ";
					
		}
		else if(whichButton == MouseEvent.BUTTON2){
			msg += "button 2(scroll button ).";
		}
		else {
			msg += "button 3(right button ).";
		}
		
		//locate mouse position
		x= e.getX();
		y= e.getY();
		msg += "at (X,Y) = (" + x +" , "+ y +").";
		 
		
		//determine single  or double click
		if(e.getClickCount()== 2){
			msg +=" You double-clicked.";
		}
		else {
			msg +=" You single-clicked.";
		}
		label.setText(msg);
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		//tell us if the mouse is out of the frame
		msg="You exited the frame.";
		label.setText(msg);
	}

	@Override
	public void mouseExited(MouseEvent e) {
		//tell us if the mosue is out of the frame
		msg="You exited the frame.";
		label.setText(msg);	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
