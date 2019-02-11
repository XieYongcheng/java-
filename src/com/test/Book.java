package com.test;

public class Book {
	// id、书名、作者、出版社、价格、出版年月
	private int ID;
	private String shu_ming;
	private String zuo_zhe;
	private String chu_ban_she;
	private String jia_ge;
	private String chu_ban_nian_yue;

	public Book(int iD, String shu_ming, String zuo_zhe, String chu_ban_she, String jia_ge, String chu_ban_nian_yue) {
		ID = iD;
		this.shu_ming = shu_ming;
		this.zuo_zhe = zuo_zhe;
		this.chu_ban_she = chu_ban_she;
		this.jia_ge = jia_ge;
		this.chu_ban_nian_yue = chu_ban_nian_yue;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getShu_ming() {
		return shu_ming;
	}

	public void setShu_ming(String shu_ming) {
		this.shu_ming = shu_ming;
	}

	public String getZuo_zhe() {
		return zuo_zhe;
	}

	public void setZuo_zhe(String zuo_zhe) {
		this.zuo_zhe = zuo_zhe;
	}

	public String getChu_ban_she() {
		return chu_ban_she;
	}

	public void setChu_ban_she(String chu_ban_she) {
		this.chu_ban_she = chu_ban_she;
	}

	public String getJia_ge() {
		return jia_ge;
	}

	public void setJia_ge(String jia_ge) {
		this.jia_ge = jia_ge;
	}

	public String getChu_ban_nian_yue() {
		return chu_ban_nian_yue;
	}

	public void setChu_ban_nian_yue(String chu_ban_nian_yue) {
		this.chu_ban_nian_yue = chu_ban_nian_yue;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ID;
		result = prime * result + ((chu_ban_nian_yue == null) ? 0 : chu_ban_nian_yue.hashCode());
		result = prime * result + ((chu_ban_she == null) ? 0 : chu_ban_she.hashCode());
		result = prime * result + ((jia_ge == null) ? 0 : jia_ge.hashCode());
		result = prime * result + ((shu_ming == null) ? 0 : shu_ming.hashCode());
		result = prime * result + ((zuo_zhe == null) ? 0 : zuo_zhe.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		if (ID != other.ID)
			return false;
		if (chu_ban_nian_yue == null) {
			if (other.chu_ban_nian_yue != null)
				return false;
		} else if (!chu_ban_nian_yue.equals(other.chu_ban_nian_yue))
			return false;
		if (chu_ban_she == null) {
			if (other.chu_ban_she != null)
				return false;
		} else if (!chu_ban_she.equals(other.chu_ban_she))
			return false;
		if (jia_ge == null) {
			if (other.jia_ge != null)
				return false;
		} else if (!jia_ge.equals(other.jia_ge))
			return false;
		if (shu_ming == null) {
			if (other.shu_ming != null)
				return false;
		} else if (!shu_ming.equals(other.shu_ming))
			return false;
		if (zuo_zhe == null) {
			if (other.zuo_zhe != null)
				return false;
		} else if (!zuo_zhe.equals(other.zuo_zhe))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Book [ID=" + ID + ", shu_ming=" + shu_ming + ", zuo_zhe=" + zuo_zhe + ", chu_ban_she=" + chu_ban_she
				+ ", jia_ge=" + jia_ge + ", chu_ban_nian_yue=" + chu_ban_nian_yue + "]";
	}

}
