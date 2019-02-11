package com.test;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Update extends JPanel implements ActionListener {
	private JTextField textField;
	private JTextField textField_1;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JLabel label;
	private JLabel label_1;
	private JLabel label_2;
	private JLabel label_3;
	private JLabel label_4;
	private JLabel label_5;
	private JTextField id;
	private JTextField name;
	private JTextField author;
	private JTextField chu_ban_she;
	private JTextField jia_ge;
	private JTextField date;
	private JButton button;
	private JButton button_1;
	private UI UI;
	private JRadioButton rdbtnId;
	private JRadioButton rdbtnName;

	/**
	 * Create the panel.
	 */
	public Update(UI ui) {
		this.UI = ui;
		setBounds(0, 0, 703, 432);
		setLayout(null);

		rdbtnId = new JRadioButton("ID");
		rdbtnId.setFont(new Font("宋体", Font.PLAIN, 20));
		buttonGroup.add(rdbtnId);
		rdbtnId.setBounds(32, 10, 110, 23);
		add(rdbtnId);

		rdbtnName = new JRadioButton("Name");
		rdbtnName.setFont(new Font("宋体", Font.PLAIN, 20));
		buttonGroup.add(rdbtnName);
		rdbtnName.setBounds(32, 48, 110, 23);
		add(rdbtnName);

		textField = new JTextField();
		textField.setBounds(148, 10, 101, 21);
		add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setBounds(148, 48, 101, 21);
		add(textField_1);
		textField_1.setColumns(10);

		label = new JLabel("ID");
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		label.setFont(new Font("宋体", Font.PLAIN, 22));
		label.setBounds(32, 77, 135, 36);
		add(label);

		label_1 = new JLabel("\u4E66\u540D");
		label_1.setHorizontalAlignment(SwingConstants.RIGHT);
		label_1.setFont(new Font("宋体", Font.PLAIN, 22));
		label_1.setBounds(32, 123, 135, 36);
		add(label_1);

		label_2 = new JLabel("\u4F5C\u8005");
		label_2.setHorizontalAlignment(SwingConstants.RIGHT);
		label_2.setFont(new Font("宋体", Font.PLAIN, 22));
		label_2.setBounds(32, 169, 135, 36);
		add(label_2);

		label_3 = new JLabel("\u51FA\u7248\u793E");
		label_3.setHorizontalAlignment(SwingConstants.RIGHT);
		label_3.setFont(new Font("宋体", Font.PLAIN, 22));
		label_3.setBounds(32, 215, 135, 36);
		add(label_3);

		label_4 = new JLabel("\u4EF7\u683C");
		label_4.setHorizontalAlignment(SwingConstants.RIGHT);
		label_4.setFont(new Font("宋体", Font.PLAIN, 22));
		label_4.setBounds(32, 261, 135, 36);
		add(label_4);

		label_5 = new JLabel("\u51FA\u7248\u5E74\u6708");
		label_5.setHorizontalAlignment(SwingConstants.RIGHT);
		label_5.setFont(new Font("宋体", Font.PLAIN, 22));
		label_5.setBounds(32, 307, 135, 36);
		add(label_5);

		id = new JTextField();
		id.setColumns(20);
		id.setBounds(196, 83, 176, 29);
		add(id);

		name = new JTextField();
		name.setColumns(20);
		name.setBounds(196, 133, 176, 29);
		add(name);

		author = new JTextField();
		author.setColumns(20);
		author.setBounds(196, 179, 176, 29);
		add(author);

		chu_ban_she = new JTextField();
		chu_ban_she.setColumns(20);
		chu_ban_she.setBounds(196, 225, 176, 29);
		add(chu_ban_she);

		jia_ge = new JTextField();
		jia_ge.setColumns(20);
		jia_ge.setBounds(196, 271, 176, 29);
		add(jia_ge);

		date = new JTextField();
		date.setToolTipText("yyyy/mm/dd");
		date.setColumns(20);
		date.setBounds(196, 317, 176, 29);
		add(date);

		button = new JButton("\u6E05\u7A7A");
		button.addActionListener(this);
		button.setBounds(239, 371, 133, 36);
		add(button);

		button_1 = new JButton("\u786E\u5B9A");
		button_1.addActionListener(this);
		button_1.setBounds(62, 371, 133, 36);
		add(button_1);
	}

	protected void function8(up_data d) {
		// TODO 自动生成的方法存根
		UI.Update(d);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO 自动生成的方法存根
		if (e.getSource().equals(button)) {
			id.setText("");
			name.setText("");
			author.setText("");
			chu_ban_she.setText("");
			jia_ge.setText("");
			date.setText("");
		} else if (e.getSource().equals(button_1)) {
			try {
				Integer.parseInt(id.getText());
				Double.parseDouble(jia_ge.getText());
				new SimpleDateFormat("yyyy/MM/dd").parse(date.getText());
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, "数值格式错误", "error", JOptionPane.ERROR_MESSAGE);
				return;
			}
			try {
				String s;
				if (rdbtnName.isSelected()) {
					s = textField_1.getText();
					if (s.isEmpty()) {
						JOptionPane.showMessageDialog(null, "未输入书名", "错误", JOptionPane.ERROR_MESSAGE);
						throw new Exception();
					}
				} else if (rdbtnId.isSelected()) {
					s = textField.getText();
					if (s.isEmpty()) {
						JOptionPane.showMessageDialog(null, "未输入ID", "错误", JOptionPane.ERROR_MESSAGE);
						throw new Exception();
					}
				} else {
					JOptionPane.showMessageDialog(null, "未选择需要查找的书", "错误", JOptionPane.ERROR_MESSAGE);
					throw new Exception();
				}
				up_data d = new up_data(
						new Book(Integer.parseInt(id.getText()), name.getText(), author.getText(),
								chu_ban_she.getText(), jia_ge.getText(), date.getText()),
						rdbtnId.isSelected(), rdbtnName.isSelected(), s);
				function8(d);
			} catch (Exception exception) {
			}
		}
	}
}
