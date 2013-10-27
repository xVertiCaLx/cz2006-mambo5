package mambo5.Form2;

import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

import mambo5.Controller.JInterfaceController;

public class NumPad extends JPanel implements JInterfaceController {

	private JButton num1, num2, num3, num4, num5, num6, num7, num8,num9, num0, delete, enter;
	private int posX = 0, posY = 0;
	
	public NumPad() {
		setLayout(null);
		num1 = new JButton("1");
		num2 = new JButton("2");
		num3 = new JButton("3");
		num4 = new JButton("4");
		num5 = new JButton("5");
		num6 = new JButton("6");
		num7 = new JButton("7");
		num8 = new JButton("8");
		num9 = new JButton("9");
		num0 = new JButton("0");
		
		delete = new JButton("DELETE");
		enter = new JButton("ENTER");
		
		num1.setSize(new Dimension(KEYPAD_WIDTH, KEYPAD_HEIGHT));
		num2.setSize(new Dimension(KEYPAD_WIDTH, KEYPAD_HEIGHT));
		num3.setSize(new Dimension(KEYPAD_WIDTH, KEYPAD_HEIGHT));
		num4.setSize(new Dimension(KEYPAD_WIDTH, KEYPAD_HEIGHT));
		num5.setSize(new Dimension(KEYPAD_WIDTH, KEYPAD_HEIGHT));
		num6.setSize(new Dimension(KEYPAD_WIDTH, KEYPAD_HEIGHT));
		num7.setSize(new Dimension(KEYPAD_WIDTH, KEYPAD_HEIGHT));
		num8.setSize(new Dimension(KEYPAD_WIDTH, KEYPAD_HEIGHT));
		num9.setSize(new Dimension(KEYPAD_WIDTH, KEYPAD_HEIGHT));
		num0.setSize(new Dimension(KEYPAD_WIDTH, KEYPAD_HEIGHT));
		delete.setSize(new Dimension(KEYPAD_SPECIAL_WIDTH, KEYPAD_SPECIAL_HEIGHT));
		enter.setSize(new Dimension(KEYPAD_SPECIAL_WIDTH, KEYPAD_SPECIAL_HEIGHT));
		
		num1.setBorder(BorderFactory.createEmptyBorder());
		num2.setBorder(BorderFactory.createEmptyBorder());
		num3.setBorder(BorderFactory.createEmptyBorder());
		num4.setBorder(BorderFactory.createEmptyBorder());
		num5.setBorder(BorderFactory.createEmptyBorder());
		num6.setBorder(BorderFactory.createEmptyBorder());
		num7.setBorder(BorderFactory.createEmptyBorder());
		num8.setBorder(BorderFactory.createEmptyBorder());
		num9.setBorder(BorderFactory.createEmptyBorder());
		num0.setBorder(BorderFactory.createEmptyBorder());
		delete.setBorder(BorderFactory.createEmptyBorder());
		enter.setBorder(BorderFactory.createEmptyBorder());
		
		num1.setBackground(KEYPAD_BACKGROUND_COLOUR);
		num2.setBackground(KEYPAD_BACKGROUND_COLOUR);
		num3.setBackground(KEYPAD_BACKGROUND_COLOUR);
		num4.setBackground(KEYPAD_BACKGROUND_COLOUR);
		num5.setBackground(KEYPAD_BACKGROUND_COLOUR);
		num6.setBackground(KEYPAD_BACKGROUND_COLOUR);
		num7.setBackground(KEYPAD_BACKGROUND_COLOUR);
		num8.setBackground(KEYPAD_BACKGROUND_COLOUR);
		num9.setBackground(KEYPAD_BACKGROUND_COLOUR);
		num0.setBackground(KEYPAD_BACKGROUND_COLOUR);
		delete.setBackground(KEYPAD_BACKGROUND_COLOUR);
		enter.setBackground(KEYPAD_BACKGROUND_COLOUR);
		
		num1.setForeground(KEYPAD_FOREGROUND_COLOUR);
		num2.setForeground(KEYPAD_FOREGROUND_COLOUR);
		num3.setForeground(KEYPAD_FOREGROUND_COLOUR);
		num4.setForeground(KEYPAD_FOREGROUND_COLOUR);
		num5.setForeground(KEYPAD_FOREGROUND_COLOUR);
		num6.setForeground(KEYPAD_FOREGROUND_COLOUR);
		num7.setForeground(KEYPAD_FOREGROUND_COLOUR);
		num8.setForeground(KEYPAD_FOREGROUND_COLOUR);
		num9.setForeground(KEYPAD_FOREGROUND_COLOUR);
		num0.setForeground(KEYPAD_FOREGROUND_COLOUR);
		delete.setForeground(KEYPAD_FOREGROUND_COLOUR);
		enter.setForeground(KEYPAD_FOREGROUND_COLOUR);
		
		//settled anything else? see here. wiat ah
		num1.setLocation(posX, posY);
		posX += num1.getWidth() + MARGIN;
		num2.setLocation(posX, posY);
		posX += num2.getWidth() + MARGIN;
		num3.setLocation(posX, posY);
		posX += num3.getWidth() + MARGIN;
		delete.setLocation(posX, posY);
		
		posX = 0;
		posY += num1.getHeight() + MARGIN;
		
		num4.setLocation(posX, posY);
		posX += num4.getWidth() + MARGIN;
		num5.setLocation(posX, posY);
		posX += num5.getWidth() + MARGIN;
		num6.setLocation(posX, posY);
		
		posX = 0;
		posY += num1.getHeight() + MARGIN;
		
		num7.setLocation(posX, posY);
		posX += num7.getWidth() + MARGIN;
		num8.setLocation(posX, posY);
		posX += num8.getWidth() + MARGIN;
		num9.setLocation(posX, posY);
		
		posX = num1.getWidth() + MARGIN;
		posY += num1.getHeight() + MARGIN;
		
		num0.setLocation(posX, posY);
		
		posX += 2*num0.getWidth() + 2*MARGIN;
		posY = delete.getHeight() + MARGIN;
		
		enter.setLocation(posX, posY);
		
		add(num1);
		add(num2);
		add(num3);
		add(num4);
		add(num5);
		add(num6);
		add(num7);
		add(num8);
		add(num9);
		add(num0);
		add(delete);
		add(enter);		
	}
	
	public JButton num1() {
		return num1;
	}
	
	public JButton num2() {
		return num2;
	}
	
	public JButton num3() {
		return num3;
	}
	
	public JButton num4() {
		return num4;
	}

	public JButton num5() {
		return num5;
	}
	
	public JButton num6() {
		return num6;
	}
	
	public JButton num7() {
		return num7;
	}
	
	public JButton num8() {
		return num8;
	}
	
	public JButton num9() {
		return num9;
	}
	
	public JButton num0() {
		return num0;
	}
	
	public JButton delete() {
		return delete;
	}
	
	public JButton enter() {
		return enter;
	}
	
	public void setEnterName(String name) {
		enter.setText(name);
	}

}
