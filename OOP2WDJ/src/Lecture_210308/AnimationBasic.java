package Lecture_210308;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class AnimationBasic {
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.add(new MyPanel());
		frame.setTitle("Animaion");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500, 300);
		frame.setVisible(true);
	}
}

class MyPanel extends JPanel implements ActionListener {
	
	private Timer timer;
	private BufferedImage image;
	private final int START_X = 0;
	private final int START_Y = 250;
	private int checkDirection = 0;
	private int x, y;
	
	public MyPanel() {
		this.setBackground(Color.BLACK);
		this.setPreferredSize(new Dimension(500, 300));
		this.setDoubleBuffered(true);
		
		File file = new File("space.png");
		System.out.println(file.getAbsolutePath());
		
		
		try {
			image = ImageIO.read(file);
			// BufferedImage ��üŸ���� �����Ѵ�
			// IOException�� �߻��� ���ɼ��� �ִ�
			
		} catch(IOException e) {
			e.printStackTrace();
			System.exit(1);
			// IOException�� �߻��ϸ� 
		}
		
		// awt���� �����ϴ� Timer Ŭ������ �̿��ؼ� �ð����� �׷��ش�
		// awt���� �����ϴ°Ͱ� util���� �����ϴ� Ÿ�̸Ӱ� �ִ�
		
		timer = new Timer(20, this);
		// timer�� �����ϱ� ���ؼ��� actionListener �������̽��� �����ϰ� �־�� �Ѵ�
		// actionPerfomed �޼ҵ带 ���� �ҷ��ش�
		timer.start();
		
		this.x = START_X;
		this.y = START_Y;
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(image, x, y, this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		/*
		 	�̹����� x, y ��ǥ�� ������ �����Ѵ�
		 */
		
//		x++;
//		y--;
		
		// ������ �ȿ����� �̹����� �����̰� �ϱ�
		
		if(x + image.getWidth() >= 500)
		{
			checkDirection = 2;
		}
		
		if(x <= 0)
		{
			checkDirection = 0;
		}
		
		if(y + image.getHeight() >= 300)
		{
			checkDirection = 3;
		}
		
		if(y <= 0)
		{
			checkDirection = 1;
		}
		
		if(checkDirection == 0)
		{
			x++;
			y--;
		}
		else if(checkDirection == 1)
		{
			x++;
			y++;
		}
		else if(checkDirection == 2)
		{
			x--;
			y++;
		}
		else if(checkDirection == 3)
		{
			x--;
			y--;
		}
		
		System.out.println(checkDirection);
		repaint();
	}
	
	
}
