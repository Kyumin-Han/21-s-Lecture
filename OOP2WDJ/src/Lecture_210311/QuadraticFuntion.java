package Lecture_210311;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class QuadraticFuntion extends JPanel implements ActionListener {
	
	private JTextField aField, bField, cField;
	private double aCE = 1.0, bCE = -5.0, cCE = 6.0;
	
	public QuadraticFuntion() {
		aField = new JTextField("1.0", 10);
		bField = new JTextField("-5.0", 10);
		cField = new JTextField("6.0", 10);
		
		this.add(aField);
		this.add(bField);
		this.add(cField);
		
		JButton drawButton = new JButton("draw");
		this.add(drawButton);
		drawButton.addActionListener(this);
	}
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(600, 400);
		frame.add(new QuadraticFuntion());
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setVisible(true);
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		// Graphics2D���� ��ü�� �ε巴�� �׸��� ���� RenderingHints ����
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		
		// x�� �׸���
		// (���� x��ǥ, ���� y��ǥ, �� x��ǥ, �� y��ǥ)
		g2.drawLine(100, 200, 500, 200);
		
		// y�� �׸���
		// (���� x��ǥ, ���� y��ǥ, �� x��ǥ, �� y��ǥ)
		g2.drawLine(300, 0, 300, 400);
		
		// ����� ���� ������ ���������� ����
		g2.setPaint(Color.RED);
		System.out.println("!aCE" + aCE + "bCE" + bCE + "cCE" + cCE);
		
		for(int i = -20; i < 20; i++)
		{
			int x = i;
			int y = (int) (aCE * x * x -bCE * x + cCE);
			
			// ���� �����Լ����� ���� x�� y��ǥ�� ����ֱ� ���ؼ� �׷��� ���� ��ǥ�� ũ�⸦ ����
			Shape s = new Ellipse2D.Float(300 + x - 2, 200 - y - 2, 4, 4);
			g2.fill(s);
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		aCE = Double.parseDouble(aField.getText());
		bCE = Double.parseDouble(bField.getText());
		cCE = Double.parseDouble(cField.getText());
		
		System.out.println("aCE: " + aCE + "bCE: " + bCE + "cCE: " + cCE);
		repaint();
	}
	
	

}
