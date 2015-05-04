package com.bon.main;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Main extends JFrame {

	private static final long serialVersionUID = -5311105052652648244L;
	
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException
				| IllegalAccessException | UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
		
		JFrame frame = new JFrame("Hi there!");
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		JPanel main = new JPanel(new GridBagLayout());
		JPanel bar = new JPanel();
		bar.setLayout(new GridBagLayout());
		GridBagConstraints barc = new GridBagConstraints();
		barc.weightx = 1;barc.weighty = 1;
		
		JButton file = new JButton("File");
		barc.gridx=0;barc.gridy=0;
		bar.add(file, barc);
		
		JButton no = new JButton("Hi");
		
		JButton add = new JButton("Add");
		barc.gridx=1;
		add.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				main.add(new JButton("Hi"));
				frame.pack();
			}});
		bar.add(add, barc);
		
		JPanel text = new JPanel();
		text.setLayout(new GridBagLayout());
		
		JTextArea area = new JTextArea();
		area.setPreferredSize(new Dimension(300,300));
		area.setText("I'm a JTextArea");
		barc.gridx=0;barc.gridy=1;
		text.add(area, barc);
		
		barc.gridx=0;barc.gridy=0;
		main.add(bar,barc);
		barc.gridx=0;barc.gridy=1;
		main.add(text,barc);
		frame.add(main);
		frame.pack();
	}

}