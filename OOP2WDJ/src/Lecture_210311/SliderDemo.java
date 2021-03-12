package Lecture_210311;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class SliderDemo extends JFrame implements ChangeListener {
	// 초기 버튼 크기 지정을 위한 상수를 설정
	static final int INIT_VALUE = 15;
	
	// 슬라이더 생성을 위한 JSlider형 변수 slider 선언
	private JSlider slider;
	private JButton btn;
	
	public SliderDemo() {
		JPanel panel;
		
		this.setTitle("슬라이더 테스트");
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		
		panel = new JPanel();
		JLabel label = new JLabel("슬라이더를 움직여 보세요" , SwingConstants.CENTER);
		panel.add(label);
		
		// 슬라이더 객체를 실제로 생성한다
		// (슬라이더의 최솟값, 슬라이더의 최댓값, 초기값)
		slider = new JSlider(0, 50, INIT_VALUE);
		
		// 주 눈금의 간격
		slider.setMajorTickSpacing(10);
		
		// 부 눈금의 간격
		slider.setMinorTickSpacing(1);
		
		// 눈금을 실제로 출력
		slider.setPaintTicks(true);
		
		// 라벨의 눈금마다의 숫자 출력
		slider.setPaintLabels(true);
		
		// 슬라이더가 선택되고 계속 변화되고 있는지 확인
		slider.addChangeListener(this);
		panel.add(slider);
		
		btn = new JButton(" ");
		ImageIcon icon = new ImageIcon("dog.png");
		btn.setIcon(icon);
		btn.setSize(INIT_VALUE * 10, INIT_VALUE * 10);
		panel.add(btn);
		
		this.add(panel);
		this.setSize(600, 600);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setVisible(true);
	}
	public static void main(String[] args) {
		new SliderDemo();
	}

	@Override
	public void stateChanged(ChangeEvent e) {
		JSlider source = (JSlider) e.getSource();
		
		// 슬라이더를 움직이는 상태가 아니면 버튼의 사이즈를 조정하게 하는 조건문
		if(!source.getValueIsAdjusting())
		{
			int value = source.getValue();
			btn.setSize(value * 10, value * 10);
		}
	}
	
	

}
