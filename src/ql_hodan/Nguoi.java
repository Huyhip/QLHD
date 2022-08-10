package ql_hodan;

public class Nguoi {
	private String maNguoi;
	private String hoVaTen;
	private int tuoi;
	private int namSinh;
	private String ngheNghiep;
	private String maHoDan;
	
	public Nguoi (String maNguoi, String hoVaTen, int tuoi, int namSinh, String ngheNghiep, String maHoDan)
	{
		this.maNguoi = maNguoi;
		this.hoVaTen = hoVaTen;
		this.tuoi = tuoi;
		this.namSinh = namSinh;
		this.ngheNghiep = ngheNghiep;
		this.maHoDan = maHoDan;
		
	}
	public Nguoi() {
		
	}
	public void setIdNguoi(String maNguoi) {
		this.maNguoi = maNguoi;
	}
	public void setName(String hoVaTen) {
		this.hoVaTen = hoVaTen;
	}
	public void setAge(int tuoi) {
		this.tuoi = tuoi;
	}
	public void setYear(int namSinh) {
		this.namSinh = namSinh;
	}
	public void setJob(String ngheNghiep) {
		this.ngheNghiep = ngheNghiep;
	}
	public void setIdHoDan(String maHoDan) {
		this.maHoDan = maHoDan;
	}
	public String getIdNguoi() {
		return maNguoi;
	}
	public String getName() {
		return hoVaTen;
	}
	public int getAge() {
		return tuoi;
	}
	public int getYear() {
		return namSinh;
	}
	public String getJob() {
		return ngheNghiep;
	}
	public String getIdHoDan() {
		return maHoDan;
	}
}


