package com.test;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Select extends JPanel implements ActionListener {
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
	private JButton lastb;
	private JButton nextb;

	private ArrayList<Book> temp;
	int index = 0;
	boolean is = false;
	private UI UI;
	private JRadioButton rdbtnAuthor;
	private JRadioButton rdbtnId;

	/**
	 * Create the panel.
	 */
	public Select(UI ui) {
		this.UI = ui;
		setBounds(0, 0, 703, 432);
		setLayout(null);

		rdbtnId = new JRadioButton("ID");
		rdbtnId.setFont(new Font("宋体", Font.PLAIN, 20));
		buttonGroup.add(rdbtnId);
		rdbtnId.setBounds(32, 10, 110, 23);
		add(rdbtnId);

		rdbtnAuthor = new JRadioButton("Author");
		rdbtnAuthor.setFont(new Font("宋体", Font.PLAIN, 20));
		buttonGroup.add(rdbtnAuthor);
		rdbtnAuthor.setBounds(32, 48, 110, 23);
		add(rdbtnAuthor);

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

		button = new JButton("\u6E05\u7A7A");
		button.addActionListener(this);
		button.setBounds(239, 371, 133, 36);
		add(button);

		button_1 = new JButton("\u786E\u5B9A");
		button_1.addActionListener(this);
		button_1.setBounds(62, 371, 133, 36);
		add(button_1);

		lastb = new JButton("\u4E0A\u4E00\u4E2A");
		lastb.addActionListener(this);
		lastb.setEnabled(false);
		lastb.setBounds(399, 316, 80, 27);
		add(lastb);

		nextb = new JButton("\u4E0B\u4E00\u4E2A");
		nextb.addActionListener(this);
		nextb.setEnabled(false);
		nextb.setBounds(399, 353, 80, 27);
		add(nextb);
	}

	protected ArrayList<Book> function9(sel_data d) {
		return UI.select(d);
	}

	private void show(Book b) {
		id.setText("" + b.getID());
		name.setText(b.getShu_ming());
		author.setText(b.getZuo_zhe());
		jia_ge.setText(b.getJia_ge());
		chu_ban_she.setText(b.getChu_ban_she());
		date.setText(b.getChu_ban_nian_yue());
	}

	private void show(ArrayList<Book> b) {
		nextb.setEnabled(false);
		lastb.setEnabled(false);
		temp = b;
		index = 0;
		if (b.size() > 0) {
			is = true;
			show(temp.get(index));
			if (b.size() > 1) {
				nextb.setEnabled(true);
			}
		} else {
			is = false;
		}
	}

	private void next() {
		int s = temp.size();
		show(temp.get(++index));
		if (index == s - 1) {
			nextb.setEnabled(false);
		}
		lastb.setEnabled(true);
	}

	private void last() {
		show(temp.get(--index));
		if (index == 0) {
			lastb.setEnabled(false);
		}
		nextb.setEnabled(true);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource().equals(button)) {
			id.setText("");
			name.setText("");
			author.setText("");
			chu_ban_she.setText("");
			jia_ge.setText("");
			date.setText("");
			nextb.setEnabled(false);
			lastb.setEnabled(false);
		} else if (arg0.getSource().equals(button_1)) {
			try {
				String s;
				if (rdbtnAuthor.isSelected()) {
					s = textField_1.getText();
					if (s.isEmpty()) {
						JOptionPane.showMessageDialog(null, "未输入作者", "错误", JOptionPane.ERROR_MESSAGE);
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
				sel_data d = new sel_data(rdbtnId.isSelected(), rdbtnAuthor.isSelected(), s);
				temp = function9(d);
				show(temp);
			} catch (Exception exception) {
			}
		} else if (arg0.getSource().equals(lastb)) {
			last();
		} else if (arg0.getSource().equals(nextb)) {
			next();
		}
	}
}
