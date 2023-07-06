package Interfaces;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class ManageDoctors {

	public JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManageDoctors window = new ManageDoctors();
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
	public ManageDoctors() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
			
		JButton btnEditDoctorDetails = new JButton("Remove Doctor");
		btnEditDoctorDetails.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RemoveDoctor removeDoctor = new RemoveDoctor();
				frame.dispose();
				removeDoctor.frame.setVisible(true);
			}
		});
		btnEditDoctorDetails.setBounds(108, 114, 217, 25);
		frame.getContentPane().add(btnEditDoctorDetails);
		
		JButton btnRegisterN = new JButton("Register New Doctor");
		btnRegisterN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DoctorRegister doctorRegister = new DoctorRegister();
				frame.dispose();
				doctorRegister.frame.setVisible(true);
			}
		});
		btnRegisterN.setBounds(108, 163, 217, 25);
		frame.getContentPane().add(btnRegisterN);
		
		JLabel lblManageDoctors = new JLabel("MANAGE DOCTORS");
		lblManageDoctors.setBounds(152, 58, 152, 15);
		frame.getContentPane().add(lblManageDoctors);
		
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
		btnBack.setBounds(12, 27, 57, 25);
		frame.getContentPane().add(btnBack);
	
	}

}
