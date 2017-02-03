import java.awt.*;

import javax.swing.*;
public class Graphic_Abanken extends JFrame{
	public Graphic_Abanken(){
		super("Castle");
		this.setSize(900,700);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel center =  new JPanel();
		this.add(center, BorderLayout.CENTER);
		center.setBackground(Color.BLACK);
	}
	public void paint(Graphics g){
		super.paint(g);
	
		Color browndoor = new Color (175,109 ,73 ); 
		Color graycastle = new Color (128,128 ,128 );  

		String word = "Andrew Banken's Castle";
		Font bigfont = new Font("Rod", Font.ITALIC, 25);
		g.setFont(bigfont);
		g.setColor(Color.WHITE);
		g.drawString(word, 300, 125);
		
		g.setColor(Color.BLACK);
		g.drawArc(175, 120, 125, 120, 180, 180); // piller 1top
		g.drawArc(625, 120, 125, 120, 180, 180); // piller 2top
		
		g.setColor(graycastle);
		g.fillRect(650, 200, 75, 100);	//piller 2 base
		g.fillRect(200, 200, 75, 100);	//piller 1 base
		
		g.fillArc(175, 120, 125, 120, 180, 180); // left piller top
		g.fillArc(625, 120, 125, 120, 180, 180); // right piller top
		
		g.fillRect(200, 300, 525, 300);	//recatangle base


		//horizontal lines
		g.setColor(Color.BLACK);
		g.drawLine(174, 180, 298, 180);	//left piller
		g.drawLine(178, 195, 295, 195);	//left piller
		g.drawLine(182, 210, 292, 210);	//left piller
		g.drawLine(200, 225, 280, 225);	//left piller
		g.drawLine(200, 240, 275, 240);	//left piller
		g.drawLine(200, 255, 275, 255);	//left piller
		g.drawLine(200, 270, 275, 270);	//left piller
		g.drawLine(200, 285, 275, 285);	//left piller
	
		g.drawLine(628, 180, 750, 180);	//right piller
		g.drawLine(628, 195, 735, 195);	//right piller
		g.drawLine(628, 195, 745, 195);	//right piller
		g.drawLine(635, 210, 740, 210);	//right piller
		g.drawLine(650, 225, 725, 225);	//right piller
		g.drawLine(650, 240, 725, 240);	//right piller
		g.drawLine(650, 255, 725, 255);	//right piller
		g.drawLine(650, 270, 725, 270);	//right piller
		g.drawLine(650, 285, 725, 285);	//right piller
		
		g.drawLine(200, 300, 725, 300);
		g.drawLine(200, 315, 725, 315);
		g.drawLine(200, 330, 725, 330);
		g.drawLine(200, 345, 725, 345);
		g.drawLine(200, 360, 725, 360);
		g.drawLine(200, 375, 725, 375);
		g.drawLine(200, 390, 725, 390);
		g.drawLine(200, 405, 725, 405);
		g.drawLine(200, 420, 725, 420);
		g.drawLine(200, 435, 725, 435);
		g.drawLine(200, 450, 725, 450);
		g.drawLine(200, 465, 725, 465);
		g.drawLine(200, 480, 725, 480);
		g.drawLine(200, 495, 725, 495);
		g.drawLine(200, 510, 725, 510);
		g.drawLine(200, 525, 725, 525);
		g.drawLine(200, 540, 725, 540);
		g.drawLine(200, 555, 725, 555);
		g.drawLine(200, 570, 725, 570);
		g.drawLine(200, 585, 725, 585);
		g.drawLine(200, 600, 725, 600);
		
		
		//vertical lines
		g.drawLine(200,180,200,599);//piller 1 left side
		g.drawLine(225,180,225,599);//piller 1 left middle side
		g.drawLine(250,180,250,599);//piller 1 right middle side
		g.drawLine(275,180,275,599);//piller 1 right side
		g.drawLine(300, 285, 300, 599);
		g.drawLine(325, 285, 325, 599);
		g.drawLine(350, 285, 350, 599);
		g.drawLine(375, 285, 375, 599);
		g.drawLine(400, 285, 400, 599);
		g.drawLine(425, 285, 425, 599);
		g.drawLine(450, 285, 450, 599);
		g.drawLine(475, 285, 475, 599);
		g.drawLine(500, 285, 500, 599);
		g.drawLine(525, 285, 525, 599);
		g.drawLine(550, 285, 550, 599);
		g.drawLine(575, 285, 575, 599);
		g.drawLine(600, 285, 600, 599);
		g.drawLine(625, 285, 625, 599);
		g.drawLine(650, 180, 650, 599);	//piller 2 left side
		g.drawLine(675, 180, 675, 599);	//piller2 middle left
		g.drawLine(700, 180, 700, 599);	//piller 2 middle right
		g.drawLine(725,180,725,599);//piller 2 right side
		

		// top middle
		g.setColor(graycastle);  
		g.fillRect(175,165,25,15);
		g.fillRect(225,165,25,15);
		g.fillRect(275,165,25,15);
		g.fillRect(300,285, 25, 15);
		g.fillRect(350,285, 25, 15);
		g.fillRect(400,285, 25, 15);
		g.fillRect(450,285, 25, 15);
		g.fillRect(500,285, 25, 15);
		g.fillRect(550,285, 25, 15);
		g.fillRect(600,285, 25, 15);
		g.fillRect(625,165,25,15);
		g.fillRect(675,165,25,15);
		g.fillRect(725,165,25,15);
		
		//gate
		g.setColor(browndoor);  
		g.fillArc(400, 450,125, 300, 0, 180);
		g.setColor(Color.BLACK);
		g.drawLine(410, 522, 410, 599);
		g.drawLine(420, 493, 420, 599);
		g.drawLine(430, 475, 430, 599);
		g.drawLine(440, 463, 440, 599);
		g.drawLine(450, 457, 450, 599);
		g.drawLine(460, 453, 460, 599);
		g.drawLine(470, 453, 470, 599);
		g.drawLine(480, 458, 480, 599);
		g.drawLine(490, 467, 490, 599);
		g.drawLine(500, 475, 500, 599);
		g.drawLine(510, 508, 510, 599);
		g.drawLine(520, 541, 520, 599);
		
		//bottom
		g.setColor(Color.white);
		g.drawOval(270, 80, 400, 80);// title circle
		g.drawLine(490,261,490,300); // torso
		g.drawLine(490,279,480,270); // left arm
		g.drawLine(490,279,500,270);	//right arm
		
		g.setColor(Color.YELLOW);
		g.fillOval(480, 242, 20, 20);	//head
		
		g.setColor(Color.BLACK);
		g.fillOval(483, 246, 5, 5);	//left eye
		g.fillOval(490, 246, 5, 5);	//right eye
		g.drawArc(485, 248, 10, 10, 180, 180); //mouth
		
	}
	public static void main(String[] args) {
		Graphic_Abanken aframe = new Graphic_Abanken();
		 aframe.setVisible(true);
	}

}
