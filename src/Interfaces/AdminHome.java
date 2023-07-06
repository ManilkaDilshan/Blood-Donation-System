package Interfaces;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class AdminHome {

	public JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminHome window = new AdminHome();
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
	public AdminHome() {
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
		
		JButton btnManageAdmin = new JButton("Manage Admins");
		btnManageAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
            	ManageAdmins manageAdmins = new ManageAdmins();
            	manageAdmins.frame.setVisible(true);
			}
		});
		btnManageAdmin.setBounds(139, 67, 162, 25);
		frame.getContentPane().add(btnManageAdmin);
		
		JButton btnNewButton = new JButton("Manage Doctors");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
            	ManageDoctors manageDoctors = new ManageDoctors();
            	manageDoctors.frame.setVisible(true);
			}
			
		});
		btnNewButton.setBounds(139, 126, 162, 25);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Manage Donors");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ManagePatients managePatient = new ManagePatients();
				managePatient.frame.setVisible(true);
			}
			
		});
		btnNewButton_1.setBounds(139, 186, 162, 25);
		frame.getContentPane().add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("ADMIN HOME");
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 15));
		lblNewLabel.setBounds(173, 28, 117, 15);
		frame.getContentPane().add(lblNewLabel);
	}
}
