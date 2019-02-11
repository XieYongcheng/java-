package com.test;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Delete extends JPanel implements ActionListener {
	private JTextField textField;
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
	private JLabel lblId;
	private UI UI;

	/**
	 * Create the panel.
	 */
	public Delete(UI ui) {
		this.UI = ui;
		setBounds(0, 0, 703, 432);
		setLayout(null);

		textField = new JTextField();
		textField.setBounds(148, 10, 101, 21);
		add(textField);
		textField.setColumns(10);

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
		id.setEnabled(false);
		id.setEditable(false);
		id.setColumns(20);
		id.setBounds(196, 83, 176, 29);
		add(id);

		name = new JTextField();
		name.setEnabled(false);
		name.setEditable(false);
		name.setColumns(20);
		name.setBounds(196, 133, 176, 29);
		add(name);

		author = new JTextField();
		author.setEnabled(false);
		author.setEditable(false);
		author.setColumns(20);
		author.setBounds(196, 179, 176, 29);
		add(author);

		chu_ban_she = new JTextField();
		chu_ban_she.setEnabled(false);
		chu_ban_she.setEditable(false);
		chu_ban_she.setColumns(20);
		chu_ban_she.setBounds(196, 225, 176, 29);
		add(chu_ban_she);

		jia_ge = new JTextField();
		jia_ge.setEnabled(false);
		jia_ge.setEditable(false);
		jia_ge.setColumns(20);
		jia_ge.setBounds(196, 271, 176, 29);
		add(jia_ge);

		date = new JTextField();
		date.setEnabled(false);
		date.setEditable(false);
		date.setColumns(20);
		date.setBounds(196, 317, 176, 29);
		add(date);

		button = new JButton("\u5220\u9664");
		button.addActionListener(this);
		button.setBounds(239, 371, 133, 36);
		add(button);

		button_1 = new JButton("\u67E5\u8BE2");
		button_1.addActionListener(this);
		button_1.setBounds(62, 371, 133, 36);
		add(button_1);

		lblId = new JLabel("ID");
		lblId.setHorizontalAlignment(SwingConstants.RIGHT);
		lblId.setFont(new Font("宋体", Font.PLAIN, 20));
		lblId.setBounds(32, 10, 110, 23);
		add(lblId);
	}

	protected Book function7(String s) {
		return UI.select(Integer.parseInt(s));
	}

	protected void function6(String s) {
		UI.delete(Integer.parseInt(s));
	}

	private void show(Book b) {
		id.setText("" + b.getID());
		name.setText(b.getShu_ming());
		author.setText(b.getZuo_zhe());
		jia_ge.setText(b.getJia_ge());
		chu_ban_she.setText(b.getChu_ban_she());
		date.setText(b.getChu_ban_nian_yue());
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(button)) {
			try {
				id.setText("");
				name.setText("");
				author.setText("");
				chu_ban_she.setText("");
				jia_ge.setText("");
				date.setText("");
				String s;
				s = textField.getText();
				if (s.isEmpty()) {
					JOptionPane.showMessageDialog(null, "未输入ID", "错误", JOptionPane.ERROR_MESSAGE);
					throw new Exception();
				}
				function6(s);
			} catch (Exception exception) {
			}
		} else if (e.getSource().equals(button_1)) {
			try {
				String s;
				s = textField.getText();
				if (s.isEmpty()) {
					JOptionPane.showMessageDialog(null, "未输入ID", "错误", JOptionPane.ERROR_MESSAGE);
					throw new Exception();
				}
				Book b = function7(s);
				show(b);
			} catch (Exception exception) {
			}
		}
	}

}
