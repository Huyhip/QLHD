package Form;

import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.border.EmptyBorder;

import ql_hodan.Login;
import DatabaseAccessObject.LoginDAO;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.*;

import java.awt.Color;
import java.awt.Window.Type;
import java.awt.Dialog.ModalExclusionType;

public class FormLogin extends JFrame {

	private JPanel contentPane;
	private JTextField txttaikhoan;
	private JPasswordField password;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormLogin frame = new FormLogin();
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
	public FormLogin() {
		setTitle("Đăng Nhập");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 607, 415);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(204, 255, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Phần mềm quản lý khu phố - Nguyễn Quang Huy 20182583");
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 10, 583, 52);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Tài Khoản");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_1.setBounds(65, 96, 102, 36);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Mật Khẩu");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_1_1.setBounds(65, 178, 94, 36);
		contentPane.add(lblNewLabel_1_1);
		
		txttaikhoan = new JTextField();
		txttaikhoan.setFont(new Font("Times New Roman", Font.BOLD, 18));
		txttaikhoan.setBounds(211, 98, 335, 36);
		contentPane.add(txttaikhoan);
		txttaikhoan.setColumns(10);
		
		JButton btnNewButton = new JButton("Đăng Nhập");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String taiKhoan = txttaikhoan.getText();
			        String matKhau =  password.getText();
			        if (!taiKhoan.isEmpty() && matKhau.isEmpty()) {
			        	JOptionPane.showMessageDialog(null, "Vui lòng nhập tài khoản và mật khẩu!");
			            return;
			        }
			        
			        Login dn = new Login();
			        dn = LoginDAO.getLogin();       
			        if(taiKhoan.equals(dn.getUser()) && matKhau.equals(dn.getPass())) {
			        		FormMenu menu = new FormMenu();
				        	dispose();
				        	menu.setLocationRelativeTo(null);
				        	menu.setVisible(true); 
			        }
			         else {
			            JOptionPane.showMessageDialog(null, "Tài khoản, mật khẩu không chính xác!");
			            txttaikhoan.setText("");
						password.setText("");
			        }
					}catch(Exception ex) {
						JOptionPane.showMessageDialog(null, "Không hợp lệ!");
					}
	  
				}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnNewButton.setBounds(251, 283, 131, 36);
		contentPane.add(btnNewButton);
		
		password = new JPasswordField();
		password.setFont(new Font("Times New Roman", Font.BOLD, 18));
		password.setBounds(211, 178, 335, 36);
		contentPane.add(password);
	}
}
