package Lecture_210315;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class PizzaOrderDemo extends JFrame implements ActionListener {

	private int sum = 0;
	private int temp1;
	private int temp2; 
	private int temp3;
	
	private JButton orderBtn, cancelBtn;
	private JPanel orderPanel;
	private JTextField priceField;
	
	// inner class로 JPanel을 상속받은 패널을 새로 만든다
	// inner class를 포함한 클래스의 멤버변수들을 자유롭게 가져다 쓰기 위해서
	// inner class로 사용한다
	JPanel welcomePanel = new WelcomePanel();
	
	JPanel typePanel = new TypePanel();
	JPanel toppingPanel = new ToppingPanel();
	JPanel sizePanel = new SizePanel();
	
	public PizzaOrderDemo() {
		this.setSize(500,200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("피자 주문");
		
		orderBtn = new JButton("주문");
		orderBtn.addActionListener(this);
		
		cancelBtn = new JButton("취소");
		cancelBtn.addActionListener(this);
		
		priceField = new JTextField();
		priceField.setEditable(false);
		priceField.setColumns(6);
		
		orderPanel = new JPanel();
		orderPanel.add(orderBtn);
		orderPanel.add(cancelBtn);
		orderPanel.add(priceField);
		
		this.add(welcomePanel, BorderLayout.NORTH);
		this.add(orderPanel, BorderLayout.SOUTH);
		this.add(sizePanel, BorderLayout.EAST);
		this.add(typePanel, BorderLayout.WEST);
		this.add(toppingPanel, BorderLayout.CENTER);
		
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	public static void main(String[] args) {
		new PizzaOrderDemo();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == orderBtn)
		{
			// 선택된 항목에 따른 가격을 계산하여 텍스트 필드에 표시
			sum = temp1 + temp2 + temp3;
			
			priceField.setText(String.valueOf(sum));
			System.out.println("temp1: " + temp1 + ", temp2: " + temp2 + ", temp3: " + temp3);
		}
		else if(e.getSource() == cancelBtn)
		{
			temp1 = 0;
			temp2 = 0;
			temp3 = 0;
			sum = 0;
			priceField.setText(String.valueOf(sum));
		}
	}
	
	class WelcomePanel extends JPanel {
		private JLabel message;
		
		public WelcomePanel() {
			message = new JLabel("자바 피자에 오신것을 환영합니다.");
			this.add(message);
		}
	}
	
	class TypePanel extends JPanel implements ChangeListener {
		private JRadioButton combo, potato, bulgogi;
		private ButtonGroup btnGroup;
		
		public TypePanel() {
			this.setLayout(new GridLayout(3, 1));
			combo = new JRadioButton("콤보", true);
			combo.addChangeListener(this);
			
			potato = new JRadioButton("포테이토");
			potato.addChangeListener(this);
			
			bulgogi = new JRadioButton("불고기");
			bulgogi.addChangeListener(this);
			
			
			btnGroup = new ButtonGroup();
			btnGroup.add(combo);
			btnGroup.add(potato);
			btnGroup.add(bulgogi);

			this.setBorder(BorderFactory.createTitledBorder("종류"));
			
			this.add(combo);
			this.add(potato);
			this.add(bulgogi);
		}

		@Override
		public void stateChanged(ChangeEvent e) {
			if(combo.isSelected())
			{
				temp1 = 7000;
			}
			else if(potato.isSelected())
			{
				temp1 = 5000;
			}
			else if(bulgogi.isSelected())
			{
				temp1 = 9000;
			}
			
		}
	}
	
	class ToppingPanel extends JPanel implements ChangeListener {
		private JRadioButton pepper, cheese, peperoni, bacon;
		
		private ButtonGroup btnGroup;
		
		public ToppingPanel() {
			this.setLayout(new GridLayout(4, 1));
			
			pepper = new JRadioButton("피망", true);
			pepper.addChangeListener(this);
			
			cheese = new JRadioButton("치즈");
			cheese.addChangeListener(this);
			
			peperoni = new JRadioButton("페페로니");
			peperoni.addChangeListener(this);
			
			bacon = new JRadioButton("베이컨");
			bacon.addChangeListener(this);
			
			btnGroup = new ButtonGroup();
			btnGroup.add(pepper);
			btnGroup.add(cheese);
			btnGroup.add(peperoni);
			btnGroup.add(bacon);
			
			this.setBorder(BorderFactory.createTitledBorder("추가 토핑"));
			
			this.add(pepper);
			this.add(cheese);
			this.add(peperoni);
			this.add(bacon);
		}

		@Override
		public void stateChanged(ChangeEvent e) {
			if(pepper.isSelected())
			{
				temp2 = 3000;
			}
			else if(cheese.isSelected())
			{
				temp2 = 5000;
			}
			else if(peperoni.isSelected())
			{
				temp2 = 6000;
			}
			else if(bacon.isSelected())
			{
				temp2 = 6000;
			}
			
		}	
	}
	
	class SizePanel extends JPanel implements ChangeListener {
		private JRadioButton small, medium, large;
		private ButtonGroup btnGroup;
		
		public SizePanel() {
			this.setLayout(new GridLayout(3 ,1));
			small = new JRadioButton("small", true);
			small.addChangeListener(this);
			
			medium = new JRadioButton("medeium");
			medium.addChangeListener(this);
			
			large = new JRadioButton("large");
			large.addChangeListener(this);
			
			btnGroup = new ButtonGroup();
			btnGroup.add(small);
			btnGroup.add(medium);
			btnGroup.add(large);
			
			this.setBorder(BorderFactory.createTitledBorder("크기"));
			
			this.add(small);
			this.add(medium);
			this.add(large);
		}

		@Override
		public void stateChanged(ChangeEvent e) {
			if(small.isSelected())
			{
				temp3 = 10000;
			}
			else if(medium.isSelected())
			{
				temp3 = 13000;
			}
			else if(large.isSelected())
			{
				temp3 = 15000;
			}
			
		}
		
		
	}

}
