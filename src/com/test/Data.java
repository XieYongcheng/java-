package com.test;

import java.util.ArrayList;
import java.util.Comparator;

public class Data implements Comparator<Book> {
	public ArrayList<Book> data;

	public Data() {
		data = new ArrayList<Book>();
	}

	public Book get(int index) {
		try {
			return data.get(index);
		} catch (Exception e) {
			return null;
		}
	}

	public void add(Book b) throws Exception {
		if (-1 == find_id(b.getID()))
			if (-1 == find_name(b.getShu_ming())) {
				data.add(b);
				data.sort(this);
			} else
				throw new Exception("name existed");
		else
			throw new Exception("ID existed");
	}

	public void remove(Book b) {
		data.remove(b);
	}

	public void remove(int i) {
		data.remove(find_id(i));
	}

	public int find(Book b) {
		int i = 0;
		boolean a = false;
		for (; i < data.size(); ++i) {
			if (data.get(i).equals(b)) {
				a = true;
				break;
			}
		}
		return a ? i : -1;
	}

	public int find_id(int id) {
		int i = 0;
		boolean a = false;
		for (; i < data.size(); ++i) {
			if (data.get(i).getID() == id) {
				a = true;
				break;
			}
		}
		return a ? i : -1;
	}

	public int find_name(String name) {
		int i = 0;
		boolean a = false;
		for (; i < data.size(); ++i) {
			if (data.get(i).getShu_ming().equals(name)) {
				a = true;
				break;
			}
		}
		return a ? i : -1;
	}

	public ArrayList<Integer> find_author(String author) {
		ArrayList<Integer> t = new ArrayList<Integer>();
		for (int i = 0; i < data.size(); ++i) {
			if (data.get(i).getZuo_zhe().equals(author)) {
				t.add(i);
			}
		}
		return t;
	}

	@Override
	public String toString() {
		return "Data [up_data=" + data + "]";
	}

	@Override
	public int compare(Book b1, Book b2) {
		return (b1.getID() > b2.getID()) ? 1 : (b1.getID() < b2.getID() ? -1 : 0);
	}

}
