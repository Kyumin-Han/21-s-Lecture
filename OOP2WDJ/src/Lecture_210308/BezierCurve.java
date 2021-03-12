package Lecture_210308;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.GeneralPath;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class BezierCurve extends JPanel implements MouseMotionListener, MouseListener {
	
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		
		frame.setSize(600, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(new BezierCurve());
		frame.setVisible(true);
	}
	
	// ������ ��� ����� ���ؼ��� �� 4���� �ʿ���
	
	private int[] xs = {50, 150, 400, 450};
	private int[] ys = {200, 50, 300, 200};
	// ������ ��� �׸��� ���� x, y��ǥ�� ����
	
	private int dragIndex = -1;
	// ���õ� ���� �����ϱ� ���� ����
	
	public BezierCurve() {
		
	}
	
	@Override
	public void paintComponent(Graphics g) {
		// ������ �� �� 4�� �׸���
		g.setColor(Color.BLUE);
		g.fillRect(xs[0], ys[0], 16, 16);
		g.fillRect(xs[2], ys[2], 16, 16);
		
		g.setColor(Color.RED);
		g.fillRect(xs[1], ys[1], 16, 16);
		g.fillRect(xs[3], ys[3], 16, 16);
		
		// ������ � �׸���
		Graphics2D g2 = (Graphics2D) g;
		g2.setColor(Color.BLACK);
		GeneralPath path = new GeneralPath();
		
		path.moveTo(xs[0], ys[0]);
		path.curveTo(xs[1], ys[1], xs[2], ys[2], xs[3], ys[3]);
		
		g2.draw(path);
	}


	@Override
	public void mousePressed(MouseEvent e) {
		dragIndex = -1;
		// 4���� �� �߿��� � ���� ������� �˻�
		
		for(int i = 0; i < 4; i++)
		{
			Rectangle r = new Rectangle(xs[i] - 4, ys[i] - 4, 20, 20);
			// ������ �����ְ� �ξ �ֺ��� �����ص� ���� �� �� �ֵ��� �Ѵ�
			
			if(r.contains(e.getX(), e.getY()))
			{
				dragIndex = i;
				break;
			}
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		dragIndex = -1;
	}
	
	@Override
	public void mouseDragged(MouseEvent e) {
		
		if(dragIndex != -1)
		{
			xs[dragIndex] = e.getX();
			ys[dragIndex] = e.getY();
		}
		
		repaint();
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {}

	@Override
	public void mouseEntered(MouseEvent e) {}

	@Override
	public void mouseExited(MouseEvent e) {}


	@Override
	public void mouseMoved(MouseEvent e) {}
	
	
	
}
