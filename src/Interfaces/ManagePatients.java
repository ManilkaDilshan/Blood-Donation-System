package Interfaces;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;

public class ManagePatients {

	public JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManagePatients window = new ManagePatients();
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
	public ManagePatients() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("Dialog", Font.PLAIN, 9));
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Add Donor");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddDonor addDonor = new AddDonor();
				frame.dispose();
				addDonor.frame.setVisible(true);
			}
		});
		btnNewButton.setBounds(159, 97, 136, 25);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("View Patient Details");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GetDonor getDonor = new GetDonor();
				frame.dispose();
				getDonor.frame.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(138, 145, 183, 25);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnAddDonation = new JButton("Add Donation ");
		btnAddDonation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddDonation addDonation = new AddDonation();
				frame.dispose();
				addDonation.frame.setVisible(true);
			}
		});
		btnAddDonation.setBounds(148, 193, 162, 25);
		frame.getContentPane().add(btnAddDonation);
		
		JLabel lblManageDonors = new JLabel("MANAGE DONORS");
		lblManageDonors.setFont(new Font("Dialog", Font.BOLD, 14));
		lblManageDonors.setBounds(170, 28, 162, 25);
		frame.getContentPane().add(lblManageDonors);
		
		JButton btnNewButton_2 = new JButton("Back");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminHome adminhome = new AdminHome();
				frame.dispose();
				adminhome.frame.setVisible(true);
			}
		});
		btnNewButton_2.setFont(new Font("Dialog", Font.BOLD, 9));
		btnNewButton_2.setBounds(12, 30, 69, 16);
		frame.getContentPane().add(btnNewButton_2);
	}

}
