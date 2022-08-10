package ql_hodan;

public class Login {
	private String tenTaiKhoan;
	private String matKhau;
	private String vaiTro;
	public Login() {
		
	}
	public Login(String tenTaiKhoan,String matKhau,String vaiTro) {
		this.tenTaiKhoan= tenTaiKhoan;
		this.matKhau = matKhau;
		this.vaiTro = vaiTro;
	}
	public void setUser(String tenTaiKhoan) {
		this.tenTaiKhoan = tenTaiKhoan;
	}
	public void setPass(String matKhau) {
		this.matKhau = matKhau;
	}
	public void setVaiTro(String vaiTro) {
		this.vaiTro = vaiTro;
	}
	public String getUser() {
		return tenTaiKhoan;
	}
	public String getPass() {
		return matKhau;
	}
	public String getVaiTro() {
		return vaiTro;
	}
}
