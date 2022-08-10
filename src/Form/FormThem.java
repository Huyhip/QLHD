package Form;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DatabaseAccessObject.*;
import ql_hodan.*;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FormThem extends JFrame {

	private JPanel contentPane;
	private JTextField txtIdKp;
	private JTextField txtTenKp;
	private JTextField txtIdHd;
	private JTextField txtSoNha;
	private JTextField txtIdN;
	private JTextField txtName;
	private JTextField txtAge;
	private JTextField txtYear;
	private JTextField txtJob;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormThem frame = new FormThem();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FormThem() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 436, 593);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblMHDn = new JLabel("Mã hộ dân");
		lblMHDn.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblMHDn.setBounds(43, 104, 118, 32);
		contentPane.add(lblMHDn);
		
		JLabel lblSNh = new JLabel("Số nhà");
		lblSNh.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblSNh.setBounds(43, 146, 118, 32);
		contentPane.add(lblSNh);
		
		JLabel lblMNgi = new JLabel("Mã người");
		lblMNgi.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblMNgi.setBounds(43, 188, 118, 32);
		contentPane.add(lblMNgi);
		
		JLabel lblHVTn = new JLabel("Họ và tên");
		lblHVTn.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblHVTn.setBounds(43, 230, 118, 32);
		contentPane.add(lblHVTn);
		
		JLabel lblTui = new JLabel("Tuổi");
		lblTui.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblTui.setBounds(43, 272, 118, 32);
		contentPane.add(lblTui);
		
		JLabel lblNmSinh = new JLabel("Năm sinh");
		lblNmSinh.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNmSinh.setBounds(43, 314, 118, 32);
		contentPane.add(lblNmSinh);
		
		JLabel lblNghNghip = new JLabel("Nghề nghiệp");
		lblNghNghip.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNghNghip.setBounds(43, 356, 118, 32);
		contentPane.add(lblNghNghip);
		
		txtIdHd = new JTextField();
		txtIdHd.setColumns(10);
		txtIdHd.setBounds(153, 106, 187, 27);
		contentPane.add(txtIdHd);
		
		txtSoNha = new JTextField();
		txtSoNha.setColumns(10);
		txtSoNha.setBounds(153, 143, 187, 27);
		contentPane.add(txtSoNha);
		
		txtIdN = new JTextField();
		txtIdN.setColumns(10);
		txtIdN.setBounds(153, 188, 187, 27);
		contentPane.add(txtIdN);
		
		txtName = new JTextField();
		txtName.setColumns(10);
		txtName.setBounds(153, 234, 187, 27);
		contentPane.add(txtName);
		
		txtAge = new JTextField();
		txtAge.setColumns(10);
		txtAge.setBounds(153, 272, 187, 27);
		contentPane.add(txtAge);
		
		txtYear = new JTextField();
		txtYear.setColumns(10);
		txtYear.setBounds(153, 314, 187, 27);
		contentPane.add(txtYear);
		
		txtJob = new JTextField();
		txtJob.setColumns(10);
		txtJob.setBounds(153, 356, 187, 27);
		contentPane.add(txtJob);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(204, 204, 204));
		panel.setBounds(23, 180, 338, 245);
		contentPane.add(panel);
		panel.setLayout(null);
		JButton btn_ttnguoi = new JButton("Tiếp tục nhập thành viên");
		btn_ttnguoi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String maN = txtIdN.getText().trim();
					String maHD = txtIdHd.getText().trim();
					String ten = txtName.getText().trim();
					String tuoi = txtAge.getText().trim();
					String namsinh = txtYear.getText().trim();
					String job = txtJob.getText().trim();
					if (maN.isEmpty() || maHD.isEmpty() || ten.isEmpty() || tuoi.isEmpty() || namsinh.isEmpty() || job.isEmpty()) {
			        	JOptionPane.showMessageDialog(null, "Vui lòng nhập điền thông tin!");
			            return;
			        }
					else {				
						Nguoi nv = new Nguoi();
						nv.setIdHoDan(maHD);
						nv.setIdNguoi(maN);
						nv.setName(ten);
						nv.setJob(job);
						nv.setAge(Integer.parseInt(txtAge.getText()));
						nv.setYear(Integer.parseInt(txtYear.getText()));
						NguoiDAO.insert(nv);
						JOptionPane.showMessageDialog(null,"Xong!\n"+"Bạn vừa nhập thành công mã người là: "+ maN + "\n" + ten+" sinh năm "+namsinh+" "+tuoi+" tuổi"+" đang là "+job);
						txtIdN.setText("");
						txtName.setText("");
						txtAge.setText("");
						txtYear.setText("");
						txtJob.setText("");
					}
				
					}catch (Exception ex) {
						JOptionPane.showMessageDialog(null,"Không hợp lệ!");
					}
			}
		});
		btn_ttnguoi.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btn_ttnguoi.setBounds(134, 214, 194, 21);
		panel.add(btn_ttnguoi);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(153, 255, 255));
		panel_1.setBounds(10, 93, 373, 368);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JButton btn_tthodan = new JButton("Tiếp tục nhập hộ dân");
		btn_tthodan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					String maKP = txtIdKp.getText().trim();
					String maHD = txtIdHd.getText().trim();
					String soNha = txtSoNha.getText().trim();
					if (maKP.isEmpty() || maHD.isEmpty() || soNha.isEmpty()) {
			        	JOptionPane.showMessageDialog(null, "Vui lòng nhập điền thông tin!");
			            return;
			        }
					else {				
						HoDan nv = new HoDan();
						nv.setIdHoDan(maHD);
						nv.setIdKhuPho(maKP);
						nv.setSoNha(soNha);
						HoDanDAO.insert(nv);
						JOptionPane.showMessageDialog(null,"Xong!");
						txtIdHd.setText("");
						txtSoNha.setText("");
					}
				
					}catch (Exception ex) {
						JOptionPane.showMessageDialog(null,"Không hợp lệ!");
					}
			}
		});
		btn_tthodan.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btn_tthodan.setBounds(147, 337, 194, 21);
		panel_1.add(btn_tthodan);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 204, 255));
		panel_2.setBounds(10, 10, 396, 509);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Mã khu phố");
		lblNewLabel.setBounds(34, 10, 118, 32);
		panel_2.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 16));
		
		txtIdKp = new JTextField();
		txtIdKp.setBounds(144, 14, 187, 27);
		panel_2.add(txtIdKp);
		txtIdKp.setColumns(10);
		
		JLabel lblTnKhuPh = new JLabel("Tên khu phố");
		lblTnKhuPh.setBounds(34, 45, 118, 32);
		panel_2.add(lblTnKhuPh);
		lblTnKhuPh.setFont(new Font("Times New Roman", Font.BOLD, 16));
		
		txtTenKp = new JTextField();
		txtTenKp.setBounds(144, 52, 187, 27);
		panel_2.add(txtTenKp);
		txtTenKp.setColumns(10);
		
		JButton btn_hoanthanh = new JButton("Hoàn thành");
		btn_hoanthanh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String maKP = txtIdKp.getText().trim();
					String tenKP = txtTenKp.getText().trim();
					if (maKP.isEmpty() || tenKP.isEmpty()) {
			        	JOptionPane.showMessageDialog(null, "Vui lòng nhập điền thông tin!");
			            return;
			        }
					else {
						KhuPho nv = new KhuPho();
						nv.setIdKhuPho(maKP);
						nv.setNameKhuPho(tenKP);
						KhuPhoDAO.insert(nv);
						JOptionPane.showMessageDialog(null,"Xong!\n"+"Bạn vừa nhập mã khu phố là: "+ maKP +"\n" + "Tên khu phố là: "+ tenKP);
						txtIdKp.setText("");
						txtTenKp.setText("");
					}
				
					}catch (Exception ex) {
						JOptionPane.showMessageDialog(null,"Không hợp lệ!");
					}
			}
		});
		btn_hoanthanh.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btn_hoanthanh.setBounds(21, 460, 134, 39);
		panel_2.add(btn_hoanthanh);
		
		JButton btn_thoat = new JButton("Thoát");
		btn_thoat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FormMenu menu = new FormMenu();
	        	dispose();
	        	menu.setLocationRelativeTo(null);
	        	menu.setVisible(true); 
			}
		});
		btn_thoat.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btn_thoat.setBounds(225, 460, 134, 39);
		panel_2.add(btn_thoat);
	}
}
