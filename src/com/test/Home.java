package com.test;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class Home extends JPanel {
	/**
	 * Create the panel.
	 */
	public Home() {
		setBounds(0, 0, 703, 432);
		setLayout(null);
		JLabel lblNewLabel = new JLabel("\u56FE\u4E66\u7BA1\u7406\u7CFB\u7EDF");
		lblNewLabel.setBackground(new Color(255, 248, 220));
		lblNewLabel.setForeground(new Color(220, 120, 255));
		lblNewLabel.setFont(new Font("¿¬Ìå", Font.PLAIN, 60));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 10, 683, 412);
		add(lblNewLabel);

	}
}
