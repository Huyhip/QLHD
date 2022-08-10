package ql_hodan;

public class KhuPho {
	private String maKhuPho;
	private String tenKhuPho;
	public KhuPho(String maKhuPho, String tenKhuPho) {
		this.maKhuPho = maKhuPho;
		this.tenKhuPho = tenKhuPho;
	}
	public KhuPho() {
		
	}
	public void setIdKhuPho(String maKhuPho) {
		this.maKhuPho = maKhuPho;
	}
	public void setNameKhuPho(String tenKhuPho) {
		this.tenKhuPho = tenKhuPho;
	}
	public String getIdKhuPho() {
		return maKhuPho;
	}
	public String getNameKhuPho() {
		return tenKhuPho;
	}
}
