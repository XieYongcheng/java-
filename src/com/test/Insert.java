package com.test;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Insert extends JPanel implements ActionListener {
	private JTextField id;
	private JTextField name;
	private JTextField author;
	private JTextField chu_ban_she;
	private JTextField jia_ge;
	private JTextField date;
	private UI UI;
	private JButton clear;
	private JButton ok;

	/**
	 * Create the
	 */
	public Insert(UI ui) {
		this.UI = ui;
		setBounds(0, 0, 703, 432);
		setLayout(null);

		JLabel lblId = new JLabel("ID");
		lblId.setHorizontalAlignment(SwingConstants.RIGHT);
		lblId.setFont(new Font("宋体", Font.PLAIN, 22));
		lblId.setBounds(48, 48, 135, 36);
		add(lblId);

		JLabel label = new JLabel("\u4E66\u540D");
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		label.setFont(new Font("宋体", Font.PLAIN, 22));
		label.setBounds(48, 94, 135, 36);
		add(label);

		JLabel label_1 = new JLabel("\u4F5C\u8005");
		label_1.setHorizontalAlignment(SwingConstants.RIGHT);
		label_1.setFont(new Font("宋体", Font.PLAIN, 22));
		label_1.setBounds(48, 140, 135, 36);
		add(label_1);

		JLabel label_2 = new JLabel("\u51FA\u7248\u793E");
		label_2.setHorizontalAlignment(SwingConstants.RIGHT);
		label_2.setFont(new Font("宋体", Font.PLAIN, 22));
		label_2.setBounds(48, 186, 135, 36);
		add(label_2);

		JLabel label_3 = new JLabel("\u4EF7\u683C");
		label_3.setHorizontalAlignment(SwingConstants.RIGHT);
		label_3.setFont(new Font("宋体", Font.PLAIN, 22));
		label_3.setBounds(48, 232, 135, 36);
		add(label_3);

		JLabel label_4 = new JLabel("\u51FA\u7248\u5E74\u6708");
		label_4.setHorizontalAlignment(SwingConstants.RIGHT);
		label_4.setFont(new Font("宋体", Font.PLAIN, 22));
		label_4.setBounds(48, 278, 135, 36);
		add(label_4);

		id = new JTextField();
		id.setBounds(212, 54, 176, 29);
		add(id);
		id.setColumns(20);

		name = new JTextField();
		name.setColumns(20);
		name.setBounds(212, 104, 176, 29);
		add(name);

		author = new JTextField();
		author.setColumns(20);
		author.setBounds(212, 150, 176, 29);
		add(author);

		chu_ban_she = new JTextField();
		chu_ban_she.setColumns(20);
		chu_ban_she.setBounds(212, 196, 176, 29);
		add(chu_ban_she);

		jia_ge = new JTextField();
		jia_ge.setColumns(20);
		jia_ge.setBounds(212, 242, 176, 29);
		add(jia_ge);

		date = new JTextField();
		date.setToolTipText("yyyy/mm/dd");
		date.setColumns(20);
		date.setBounds(212, 288, 176, 29);
		add(date);

		clear = new JButton("\u6E05\u7A7A");
		clear.addActionListener(this);
		clear.setBounds(255, 342, 133, 36);
		add(clear);

		ok = new JButton("\u786E\u5B9A");
		ok.addActionListener(this);
		ok.setBounds(78, 342, 133, 36);
		add(ok);
	}

	protected void function5(Book book) {
		UI.insert(book);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(clear)) {
			id.setText("");
			name.setText("");
			author.setText("");
			chu_ban_she.setText("");
			jia_ge.setText("");
			date.setText("");
		} else if (e.getSource().equals(ok)) {
			try {
				Integer.parseInt(id.getText());
				Double.parseDouble(jia_ge.getText());
				new SimpleDateFormat("yyyy/MM/dd").parse(date.getText());
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, "数值格式错误", "error", JOptionPane.ERROR_MESSAGE);
				return;
			}
			function5(new Book(Integer.parseInt(id.getText()), name.getText(), author.getText(), chu_ban_she.getText(),
					jia_ge.getText(), date.getText()));
		}
	}
}
