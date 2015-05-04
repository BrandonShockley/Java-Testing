package Main;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.TimeUnit;

public class Main  {
	
	static int money = 0;
	static Thread t;
	
	static JFrame frame = new JFrame("Button Tycoon");
	static JPanel main = new JPanel(new GridBagLayout());
	static GridBagConstraints c = new GridBagConstraints();
	static JPanel stats = new JPanel();
	static JPanel buttons = new JPanel();
	static JLabel label = new JLabel("Money: ");
	static JLabel sum = new JLabel(Integer.toString(money));
	static JButton manual = new JButton("$1 Click");
	
	static UpgradeableButton one = new UpgradeableButton(10, 1);
	static UpgradeableButton five = new UpgradeableButton(50, 5);
	static UpgradeableButton fifteen = new UpgradeableButton(150, 15);
	
	public static void main(String args[])
	{
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		buttons.setPreferredSize(new Dimension(300,400));
		stats.setPreferredSize(new Dimension(200,200));
		
		manual.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				money++;
				sum.setText(Integer.toString(money));
			}});
		buttons.add(manual);
		buttons.add(one);
		buttons.add(five);
		buttons.add(fifteen);
		
		stats.add(label);
		stats.add(sum);
		
		c.weightx=1;c.weighty=1;
		c.gridx=0;c.gridy=0;
		main.add(stats, c);
		c.gridx=1;
		main.add(buttons, c);
		frame.add(main);
		frame.pack();
	}
}