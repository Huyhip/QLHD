package Form;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DatabaseAccessObject.KhuPhoDAO;
import ql_hodan.KhuPho;


import javax.swing.JLabel;

import javax.swing.JOptionPane;


import javax.swing.SwingConstants;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FormMenu extends JFrame {

	private JPanel contentPane;
	private JTextField txtID;
	private static JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormMenu frame = new FormMenu();
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
	public FormMenu() {
		setTitle("Menu");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 810, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nhập mã khu phố để sửa hoặc xóa");
		lblNewLabel.setBounds(10, 10, 325, 41);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		contentPane.add(lblNewLabel);
		
		txtID = new JTextField();
		txtID.setBounds(335, 10, 430, 41);
		contentPane.add(txtID);
		txtID.setColumns(10);
		
		JButton btn_sua = new JButton("Sửa");
		btn_sua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String Id = txtID.getText().trim();
					KhuPho kp = new KhuPho();
					kp = KhuPhoDAO.getKhuPho();
					if(!Id.isEmpty()){
						FormSua them = new FormSua(Id);
			        	dispose();
			        	them.setLocationRelativeTo(null);
			        	them.setVisible(true);
					}
					else {
			            JOptionPane.showMessageDialog(null, "Không hợp lệ!");
			            txtID.setText("");
					}
				}catch (Exception ex) {
					JOptionPane.showMessageDialog(null,"Không hợp lệ!");
					ex.printStackTrace();
				}
			}
		});
		btn_sua.setBounds(306, 98, 159, 29);
		btn_sua.setFont(new Font("Times New Roman", Font.BOLD, 16));
		contentPane.add(btn_sua);
		
		JButton btn_xoa = new JButton("Xóa");
		btn_xoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String Id = txtID.getText().trim();
					KhuPho kp = new KhuPho();
					kp = KhuPhoDAO.getKhuPho();
					if (!Id.isEmpty()) {
						kp.setIdKhuPho(Id);
						KhuPhoDAO.delete(kp);
						JOptionPane.showMessageDialog(null,"Xong!");
						txtID.setText("");
						showdata(KhuPhoDAO.selectAll());
					}
					else {
			            JOptionPane.showMessageDialog(null, "Không hợp lệ!");
			            txtID.setText("");
					}
				}catch (Exception ex) {
					JOptionPane.showMessageDialog(null,"Không hợp lệ!");
					ex.printStackTrace();
				}
			}
		});
		btn_xoa.setBounds(573, 98, 159, 29);
		btn_xoa.setFont(new Font("Times New Roman", Font.BOLD, 16));
		contentPane.add(btn_xoa);
		
		JButton btn_themkp = new JButton("Thêm khu phố");
		btn_themkp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					FormThem them = new FormThem();
		        	dispose();
		        	them.setLocationRelativeTo(null);
		        	them.setVisible(true);
				
					}catch (Exception ex) {
						JOptionPane.showMessageDialog(null,"Không hợp lệ!");
					}				
			}
		});
		btn_themkp.setBounds(10, 95, 159, 33);
		btn_themkp.setFont(new Font("Times New Roman", Font.BOLD, 18));
		contentPane.add(btn_themkp);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(10, 169, 766, 284);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setShowHorizontalLines(false);
		table.setCellSelectionEnabled(true);
		table.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
			},
			new String[] {
				"Mã khu phố", "Tên khu phố"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(20);
		table.getColumnModel().getColumn(0).setMinWidth(100);
		table.getColumnModel().getColumn(1).setPreferredWidth(700);
		table.getColumnModel().getColumn(1).setMinWidth(100);
		scrollPane.setViewportView(table);
		showdata(KhuPhoDAO.selectAll());
	}
	public void showdata(List<KhuPho>kp1) {
		List<KhuPho> kpList = new ArrayList<>();
		kpList = kp1;
		DefaultTableModel tableModel1;
		table.getModel();
		tableModel1 = (DefaultTableModel)table.getModel();
		tableModel1.setRowCount(0);
		
		kpList.forEach((khupho) -> {
			tableModel1.addRow(new Object[] {
					khupho.getIdKhuPho(), khupho.getNameKhuPho()
			});
		});
	}
}
