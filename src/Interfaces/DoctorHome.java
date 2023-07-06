package Interfaces;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;

public class DoctorHome {

	public JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DoctorHome window = new DoctorHome();
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
	public DoctorHome() {
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
		
		JLabel lblDoctorHome = new JLabel("Doctor Home ");
		lblDoctorHome.setBounds(174, 28, 120, 15);
		frame.getContentPane().add(lblDoctorHome);
		
		JButton btnNewButton = new JButton("View Patient Details");
		btnNewButton.setBounds(135, 99, 190, 25);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Add Donor Diagnosis");
		btnNewButton_1.setBounds(135, 150, 195, 25);
		frame.getContentPane().add(btnNewButton_1);
	}

}
