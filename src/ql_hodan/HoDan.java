package ql_hodan;

public class HoDan {
	private String maHoDan;
	private int soThanhVien;
	private String soNha;
	private String maKhuPho;
	public HoDan(String maHoDan,int soThanhVien,String soNha, String maKhuPho) {
		this.maHoDan = maHoDan;
		this.soThanhVien = soThanhVien;
		this.soNha = soNha;
		this.maKhuPho = maKhuPho;
	}
	public HoDan() {
		
	}
	public void setIdKhuPho(String maKhuPho) {
		this.maKhuPho = maKhuPho;
	}
	public void setIdHoDan(String maHoDan) {
		this.maHoDan = maHoDan;
	}
	public void setSoThanhVien(int soThanhVien) {
		this.soThanhVien = soThanhVien;
	}
	public void setSoNha(String soNha) {
		this.soNha = soNha;
	}
	public String getIdKhuPho() {
		return maKhuPho;
	}
	public String getIdHoDan() {
		return maHoDan;
	}
	public int getSoThanhVien() {
		return soThanhVien;
	}
	public String getSoNha() {
		return soNha;
	}
}
