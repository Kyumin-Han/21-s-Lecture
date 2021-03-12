package Lecture_210304;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.geom.Arc2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MoreShapes extends JFrame {
	
	public MoreShapes() {
		this.setSize(600, 130);
		this.setTitle("JAVA 2D Shpaes");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		JPanel panel = new MyPanel();
		
		this.add(panel);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		
	}
	
	public static void main(String[] args) {
		new MoreShapes();
	}
}

class MyPanel extends JPanel {
	ArrayList<Shape> shapeArray = new ArrayList<Shape>();
	public MyPanel() {
		
		shapeArray.add(new Rectangle2D.Float(10, 10, 70, 80));
		shapeArray.add(new RoundRectangle2D.Float(110, 10, 70, 80, 20, 20));
		shapeArray.add(new Ellipse2D.Float(210, 10, 80, 80));
		shapeArray.add(new Arc2D.Float(310, 10, 80, 80, 90, 90, Arc2D.OPEN));
		shapeArray.add(new Arc2D.Float(410, 10, 80, 80, 0, 100, Arc2D.CHORD));
		shapeArray.add(new Arc2D.Float(510, 10, 80, 80, 45, 45, Arc2D.PIE));
	}
	
	@Override
	public void paintComponent(Graphics g) {
		//paintComponent는 정의되어있는 메소드이기 때문에 Graphics2D를 인수로 받을수는 없고 Graphics형으로만 받을 수 있다
		super.paintComponent(g);
		
		Graphics2D g2 = (Graphics2D) g;
		
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		
		g2.setColor(Color.BLACK);
		g2.setStroke(new BasicStroke(3));
		
		for(Shape s : shapeArray) {
			g2.draw(s);
		}
	}
}
