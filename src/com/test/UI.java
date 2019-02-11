package com.test;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

public class UI extends JFrame implements ActionListener {
	private JPanel contentPane;
	private Insert add;
	private Delete del;
	private Update upd;
	private Select sel;
	private Data data;
	private Home home;
	private JMenuItem menuItem;
	private JMenuItem menuItem_4;
	private JMenuItem menuItem_1;
	private JMenuItem menuItem_3;
	private JMenuItem menuItem_2;
	private JMenuItem mntmNewMenuItem;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UI frame = new UI();
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the frame.
	 */
	public UI() {
		super("\u56FE\u4E66\u7BA1\u7406\u7CFB\u7EDF");
		UIManager.put("TextField.inactiveForeground", new Color(0, 0, 0));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 729, 503);

		data = new Data();

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mne = new JMenu("\u9875\u9762");
		menuBar.add(mne);

		menuItem = new JMenuItem("\u6DFB\u52A0");
		menuItem.addActionListener(this);

		menuItem_4 = new JMenuItem("\u4E3B\u9875");
		menuItem_4.addActionListener(this);
		mne.add(menuItem_4);
		mne.add(menuItem);

		menuItem_1 = new JMenuItem("\u67E5\u8BE2");
		menuItem_1.addActionListener(this);
		mne.add(menuItem_1);

		menuItem_3 = new JMenuItem("\u4FEE\u6539");
		menuItem_3.addActionListener(this);
		mne.add(menuItem_3);

		menuItem_2 = new JMenuItem("\u5220\u9664");
		menuItem_2.addActionListener(this);
		mne.add(menuItem_2);

		mntmNewMenuItem = new JMenuItem("\u9000\u51FA");
		mntmNewMenuItem.addActionListener(this);
		mne.add(mntmNewMenuItem);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel panel = new JPanel();
		panel.setLayout(null);
		contentPane.add(panel, BorderLayout.CENTER);

		setAdd(new Insert(this));
		getAdd().setVisible(false);
		panel.add(getAdd());

		setDel(new Delete(this));
		getDel().setVisible(false);
		panel.add(getDel());

		setUpd(new Update(this));
		getUpd().setVisible(false);
		panel.add(getUpd());

		setSel(new Select(this));
		getSel().setVisible(false);
		panel.add(getSel());

		home = new Home();
		panel.add(home);

	}

	public void insert(Book b) {
		try {
			data.add(b);
			JOptionPane.showMessageDialog(null, "成功", "OK", JOptionPane.INFORMATION_MESSAGE);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "error", JOptionPane.ERROR_MESSAGE);
		}
	}

	public Book select(int id) {
		return data.get(data.find_id(id));
	}

	public void delete(int id) {
		data.remove(id);
	}

	public void Update(up_data b) {
		Book t = null;
		if (b.Name) {
			t = data.get(data.find_name(b.str));
		} else if (b.ID) {
			t = select(Integer.parseInt(b.str));
		}
		if (t != null) {
			data.remove(t);
			insert(b.b);
		}
	}

	public ArrayList<Book> select(sel_data b) {
		ArrayList<Book> t = new ArrayList<Book>();
		if (b.Author) {
			ArrayList<Integer> temp = data.find_author(b.str);
			for (Integer i = 0; i < temp.size(); i++) {
				t.add(data.get(temp.get(i)));
			}
		} else if (b.ID) {
			t.add(select(Integer.parseInt(b.str)));
		}
		return t;
	}

	public void close_all() {
		getAdd().setVisible(false);
		getDel().setVisible(false);
		getUpd().setVisible(false);
		getSel().setVisible(false);
		home.setVisible(false);
	}

	public Select getSel() {
		return sel;
	}

	public void setSel(Select sel) {
		this.sel = sel;
	}

	public Update getUpd() {
		return upd;
	}

	public void setUpd(Update upd) {
		this.upd = upd;
	}

	public Delete getDel() {
		return del;
	}

	public void setDel(Delete del) {
		this.del = del;
	}

	public Insert getAdd() {
		return add;
	}

	public void setAdd(Insert add) {
		this.add = add;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource().equals(menuItem)) {
			close_all();
			getAdd().setVisible(true);

		} else if (arg0.getSource().equals(menuItem_4)) {
			close_all();
			home.setVisible(true);
		} else if (arg0.getSource().equals(menuItem_1)) {
			close_all();
			getSel().setVisible(true);
		} else if (arg0.getSource().equals(menuItem_3)) {
			close_all();
			getUpd().setVisible(true);
		} else if (arg0.getSource().equals(menuItem_2)) {
			close_all();
			getDel().setVisible(true);
		} else if (arg0.getSource().equals(mntmNewMenuItem)) {
			dispose();
		}
	}

}
