package Form;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DatabaseAccessObject.*;
import ql_hodan.*;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import java.util.ArrayList;
import java.util.List;

public class FormSua extends JFrame {

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
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormSua frame = new FormSua("KP3");
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
	public FormSua(String IDKP) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 851, 642);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblMNgi = new JLabel("Mã người");
		lblMNgi.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblMNgi.setBounds(494, 93, 118, 32);
		contentPane.add(lblMNgi);
		
		JLabel lblHVTn = new JLabel("Họ và tên");
		lblHVTn.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblHVTn.setBounds(494, 135, 118, 32);
		contentPane.add(lblHVTn);
		
		JLabel lblTui = new JLabel("Tuổi");
		lblTui.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblTui.setBounds(494, 177, 118, 32);
		contentPane.add(lblTui);
		
		JLabel lblNmSinh = new JLabel("Năm sinh");
		lblNmSinh.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNmSinh.setBounds(494, 219, 118, 32);
		contentPane.add(lblNmSinh);
		
		JLabel lblNghNghip = new JLabel("Nghề nghiệp");
		lblNghNghip.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNghNghip.setBounds(494, 261, 118, 32);
		contentPane.add(lblNghNghip);
		
		txtIdN = new JTextField();
		txtIdN.setColumns(10);
		txtIdN.setBounds(604, 93, 187, 27);
		contentPane.add(txtIdN);
		
		txtName = new JTextField();
		txtName.setColumns(10);
		txtName.setBounds(604, 139, 187, 27);
		contentPane.add(txtName);
		
		txtAge = new JTextField();
		txtAge.setColumns(10);
		txtAge.setBounds(604, 177, 187, 27);
		contentPane.add(txtAge);
		
		txtYear = new JTextField();
		txtYear.setColumns(10);
		txtYear.setBounds(604, 219, 187, 27);
		contentPane.add(txtYear);
		
		txtJob = new JTextField();
		txtJob.setColumns(10);
		txtJob.setBounds(604, 261, 187, 27);
		contentPane.add(txtJob);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(204, 204, 204));
		panel.setBounds(453, 73, 357, 286);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btn_luuN = new JButton("Lưu");
		btn_luuN.addActionListener(new ActionListener() {
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
						NguoiDAO.update(nv);
						JOptionPane.showMessageDialog(null,"Xong!");
						showdata(NguoiDAO.selectKP(IDKP));
					}
				
					}catch (Exception ex) {
						JOptionPane.showMessageDialog(null,"Không hợp lệ!");
					}
			}
		});
		btn_luuN.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btn_luuN.setBounds(117, 224, 134, 39);
		panel.add(btn_luuN);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 204, 255));
		panel_2.setBounds(20, 73, 396, 292);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Mã khu phố");
		lblNewLabel.setBounds(34, 10, 118, 32);
		panel_2.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 16));
		
		txtTenKp = new JTextField();
		txtTenKp.setBounds(144, 52, 187, 27);
		panel_2.add(txtTenKp);
		txtTenKp.setColumns(10);
		
		txtIdKp = new JTextField();
		txtIdKp.setBounds(144, 14, 187, 27);
		panel_2.add(txtIdKp);
		txtIdKp.setColumns(10);
		
		txtIdKp.setText(IDKP);
		
		JLabel lblTnKhuPh = new JLabel("Tênn khu phố");
		lblTnKhuPh.setBounds(34, 52, 118, 32);
		panel_2.add(lblTnKhuPh);
		lblTnKhuPh.setFont(new Font("Times New Roman", Font.BOLD, 16));
		
		JLabel lblMHDn = new JLabel("Mã hộ dân");
		lblMHDn.setBounds(34, 109, 118, 32);
		panel_2.add(lblMHDn);
		lblMHDn.setFont(new Font("Times New Roman", Font.BOLD, 16));
		
		txtIdHd = new JTextField();
		txtIdHd.setBounds(144, 113, 187, 27);
		panel_2.add(txtIdHd);
		txtIdHd.setColumns(10);
		
		txtSoNha = new JTextField();
		txtSoNha.setBounds(144, 162, 187, 27);
		panel_2.add(txtSoNha);
		txtSoNha.setColumns(10);
		
		JLabel lblSNh = new JLabel("Số nhà");
		lblSNh.setBounds(34, 158, 118, 32);
		panel_2.add(lblSNh);
		lblSNh.setFont(new Font("Times New Roman", Font.BOLD, 16));
		
		JButton btn_luuHd = new JButton("Lưu");
		btn_luuHd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String maHD = txtIdHd.getText().trim();
					String soNha = txtSoNha.getText().trim();
					if (maHD.isEmpty() || soNha.isEmpty()) {
			        	JOptionPane.showMessageDialog(null, "Vui lòng nhập điền thông tin!");
			            return;
			        }
					else {				
						HoDan nv = new HoDan();
						nv.setIdHoDan(maHD);
						nv.setIdKhuPho(txtIdKp.getText());
						nv.setSoNha(soNha);
						HoDanDAO.update(nv);
						JOptionPane.showMessageDialog(null,"Xong!");
					}
				
					}catch (Exception ex) {
						JOptionPane.showMessageDialog(null,"Không hợp lệ!");
					}
			}
		});
		btn_luuHd.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btn_luuHd.setBounds(130, 223, 134, 39);
		panel_2.add(btn_luuHd);
		
		JButton btn_thoat = new JButton("Thoát");
		btn_thoat.setBounds(657, 10, 134, 39);
		contentPane.add(btn_thoat);
		btn_thoat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FormMenu menu = new FormMenu();
	        	dispose();
	        	menu.setLocationRelativeTo(null);
	        	menu.setVisible(true); 
			}
		});
		btn_thoat.setFont(new Font("Times New Roman", Font.BOLD, 16));
		
		JButton btn_luuKp = new JButton("Lưu");
		btn_luuKp.setBounds(500, 10, 134, 39);
		contentPane.add(btn_luuKp);
		btn_luuKp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String tenKP = txtTenKp.getText().trim();
					if (tenKP.isEmpty()) {
			        	JOptionPane.showMessageDialog(null, "Vui lòng nhập điền thông tin!");
			            return;
			        }
					else {
						KhuPho nv = new KhuPho();
						nv.setIdKhuPho(IDKP);
						nv.setNameKhuPho(tenKP);
						KhuPhoDAO.update(nv);
						JOptionPane.showMessageDialog(null,"Xong!");
					}
				
					}catch (Exception ex) {
						JOptionPane.showMessageDialog(null,"Không hợp lệ!");
					}
			}
		});
		btn_luuKp.setFont(new Font("Times New Roman", Font.BOLD, 16));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 375, 807, 220);
		contentPane.add(scrollPane);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(30, 375, 797, 220);
		contentPane.add(scrollPane_1);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
			},
			new String[] {
				"M\u00E3 ng\u01B0\u1EDDi", "H\u1ECD v\u00E0 t\u00EAn", "Tu\u1ED5i", "N\u0103m sinh", "Ngh\u1EC1 nhi\u1EC7p"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(61);
		table.getColumnModel().getColumn(1).setPreferredWidth(211);
		table.getColumnModel().getColumn(2).setPreferredWidth(67);
		table.getColumnModel().getColumn(4).setPreferredWidth(246);
		scrollPane_1.setViewportView(table);
		
		table = new JTable();
		table.setShowHorizontalLines(false);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
			},
			new String[] {
				"Mã người", "Họ và tên", "Tuổi", "Năm sinh", "Nghề nghiêp"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(58);
		table.getColumnModel().getColumn(1).setPreferredWidth(268);
		table.getColumnModel().getColumn(2).setPreferredWidth(53);
		table.getColumnModel().getColumn(3).setPreferredWidth(91);
		table.getColumnModel().getColumn(4).setPreferredWidth(206);
		scrollPane.setViewportView(table);
		showdata(NguoiDAO.selectKP(IDKP));
	}
	public void showdata(List<Nguoi>kp1) {
		List<Nguoi> kpList = new ArrayList<>();
		kpList = kp1;
		DefaultTableModel tableModel1;
		table.getModel();
		tableModel1 = (DefaultTableModel)table.getModel();
		tableModel1.setRowCount(0);
		
		kpList.forEach((nguoi) -> {
			tableModel1.addRow(new Object[] {
					nguoi.getIdNguoi(), nguoi.getName(),nguoi.getAge(),nguoi.getYear(),nguoi.getJob()
			});
		});
	}
}
