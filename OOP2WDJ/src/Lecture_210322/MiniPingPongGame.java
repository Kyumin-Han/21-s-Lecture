package Lecture_210322;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MiniPingPongGame extends JPanel implements KeyListener{
	private Ball ball;
	protected Racquet racquet1;
	protected Racquet racquet2;
	protected JLabel scoreLabel1, scoreLabel2, scoreLabel3;
	
	public MiniPingPongGame() {
		ball = new Ball(this, Color.RED);
		this.setBackground(Color.GREEN);
		
		// 라켓이 패널 안의 범위에 있어야 하는지 알기 위해서는
		// 패널에 접근할 수 있어야 하기 때문에 생성자에 이 객체를 준다
		racquet1 = new Racquet(this, 10, 150, Color.BLUE, 1);
		racquet2 = new Racquet(this, 560, 150, Color.YELLOW, 2);
		scoreLabel1 = new JLabel("0");
		scoreLabel2 = new JLabel("0");
		scoreLabel3 = new JLabel(" : ");
		
		scoreLabel1.setFont(new Font("bold", 40, 40));
		scoreLabel2.setFont(new Font("bold", 40, 40));
		scoreLabel3.setFont(new Font("bold", 40, 40));
		
		
		this.add(scoreLabel1);
		this.add(scoreLabel3);
		this.add(scoreLabel2);
		this.setLayout(new FlowLayout());
		this.addKeyListener(this);
		this.setFocusable(true);
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2 = (Graphics2D) g;
		ball.draw(g2);
		racquet1.draw(g2);
		racquet2.draw(g2);
		
	}
	
	public void move() {
		ball.move();
		racquet1.move();
		racquet2.move2();
	}
	
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setTitle("PingPong");
		frame.setSize(600, 400);
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		MiniPingPongGame game = new MiniPingPongGame();
		frame.add(game);
		frame.setVisible(true);
		
		while(true) 
		{
			game.move();
			game.repaint();
			try {
				Thread.sleep(10);
			} catch(InterruptedException e) {
				e.printStackTrace();
			}
		}

	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		racquet1.keyPressed(e);
		racquet2.keyPressed(e);
	}
	@Override
	public void keyReleased(KeyEvent e) {
		racquet1.keyReleased(e);
		racquet2.keyReleased(e);
		
	}
	
	@Override
	public void keyTyped(KeyEvent e) {}
	
}

class Ball {
	private static final int RADIUS = 20;
	private int x = 0, y = 0, xSpeed = 6, ySpeed = 1;
	private MiniPingPongGame game;
	private Color color;
	
	public Ball(MiniPingPongGame game, Color color) {
		this.game = game;
		this.color = color;
	}
	
	public void move() {
		if(x + xSpeed < 0)
		{
			xSpeed = 6;
			int y = Integer.parseInt(game.scoreLabel2.getText());
			game.scoreLabel2.setText(String.valueOf(++y));
		}
			
		if(x + xSpeed > game.getWidth() - 2 * RADIUS)
		{
			xSpeed = -6;
			int y = Integer.parseInt(game.scoreLabel1.getText());
			game.scoreLabel1.setText(String.valueOf(++y));
		}
						
		if(y + ySpeed < 0)
			ySpeed = 6;
		if(y + ySpeed > game.getHeight() - 2 * RADIUS)
			ySpeed = -1;
		if(collision())
			xSpeed = -xSpeed;
		x += xSpeed;
		y += ySpeed;
	}
	
	public Rectangle getBounds() {
		return new Rectangle(x, y, 2 * RADIUS, 2 * RADIUS);
	}
	
	private boolean collision() {
		return game.racquet1.getBounds().intersects(getBounds()) 
				|| game.racquet2.getBounds().intersects(getBounds());
	}
	public void draw(Graphics2D g) {
		g.setColor(color);
		g.fillOval(x, y, 2 * RADIUS, 2 * RADIUS);
	}
}

class Racquet {
	private static final int WIDTH = 10;
	private static final int HEIGHT = 80;
	private int x = 0, y = 0;
	private int ySpeed = 0;
	private int ySpeed2 = 0;
	private MiniPingPongGame game;
	private Color color;
	private int racquetCount;
	
	public Racquet(MiniPingPongGame game, int x, int y , Color color, int racquetCount) {
		this.game = game;
		this.x = x;
		this.y = y;
		this.color = color;
		this.racquetCount = racquetCount;
	}
	
	// 라켓이 패널 안에서만 움직이게 한다
	public void move() {
		if(y + ySpeed > 0 && y + ySpeed < game.getHeight() - HEIGHT)
			y += ySpeed;
	}
	
	public void move2() {
		if(y + ySpeed2 > 0 && y + ySpeed < game.getHeight() - HEIGHT)
		{
			y += ySpeed2;
		}
	}
	
	public Rectangle getBounds() {
		return new Rectangle(x, y, WIDTH, HEIGHT);
	}
	
	public void draw(Graphics2D g) {
		g.setColor(color);
		g.fillRect(x, y, WIDTH, HEIGHT);
	}
	
	// 각 키가 눌렸을때의 방향 조절
	public void keyPressed(KeyEvent e) {
		if(racquetCount == 2) 
		{
			if(e.getKeyCode() == KeyEvent.VK_UP)
				ySpeed2 = -3;
			else if(e.getKeyCode() == KeyEvent.VK_DOWN)
				ySpeed2 = 3;
		}
		else
		{
			if(e.getKeyCode() == KeyEvent.VK_W)
				ySpeed = -3;
			else if(e.getKeyCode() == KeyEvent.VK_S)
				ySpeed = 3;
		}
		
	}
	
	// 키를 뗐을때 움직이지 않도록 한다
	public void keyReleased(KeyEvent e) {
		ySpeed = 0;
		ySpeed2 = 0;
	}
}
