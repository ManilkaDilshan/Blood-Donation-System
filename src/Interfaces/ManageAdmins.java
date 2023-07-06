package Interfaces;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.SwingConstants;

public class ManageAdmins {

	public JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManageAdmins window = new ManageAdmins();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ManageAdmins() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnViewAdminDetails = new JButton("View Admin Details");
		btnViewAdminDetails.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewAdmin viewAdmin = new ViewAdmin();
				frame.dispose();
				viewAdmin.frame.setVisible(true);
			}
		});
		btnViewAdminDetails.setBounds(151, 74, 190, 25);
		frame.getContentPane().add(btnViewAdminDetails);
		
		JButton btnEditAdminDetails = new JButton("Edit Admin Details");
		btnEditAdminDetails.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UpdateAdmin updateAdmin = new UpdateAdmin();
				frame.dispose();
				updateAdmin.frame.setVisible(true);
			}
		});
		btnEditAdminDetails.setBounds(151, 118, 188, 25);
		frame.getContentPane().add(btnEditAdminDetails);
		
		JButton btnRegisterN = new JButton("Register New Admin");
		btnRegisterN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminRegister adminRegister = new AdminRegister();
				frame.dispose();
				adminRegister.frame.setVisible(true);
			}
		});
		btnRegisterN.setBounds(153, 163, 188, 25);
		frame.getContentPane().add(btnRegisterN);
		
		JLabel lblManageAdmins = new JLabel("MANAGE ADMINS");
		lblManageAdmins.setFont(new Font("Dialog", Font.BOLD, 14));
		lblManageAdmins.setBounds(173, 25, 152, 15);
		frame.getContentPane().add(lblManageAdmins);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminHome window = new AdminHome();
				frame.dispose();
				window.frame.setVisible(true);
			}
			
		});
		btnBack.setHorizontalAlignment(SwingConstants.LEFT);
		btnBack.setFont(new Font("Dialog", Font.BOLD, 9));
		btnBack.setBounds(12, 27, 57, 15);
		frame.getContentPane().add(btnBack);
	}
}
