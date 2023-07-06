package Interfaces;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class GetDonor {

	public JFrame frame;
	private JTextField textField;
	public static int donorId;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GetDonor window = new GetDonor();
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
	public GetDonor() {
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
		
		JLabel lblViewDonor = new JLabel("View Donor");
		lblViewDonor.setBounds(167, 33, 129, 21);
		frame.getContentPane().add(lblViewDonor);
		
		JLabel lblDonorId = new JLabel("Donor NIC");
		lblDonorId.setBounds(84, 112, 70, 15);
		frame.getContentPane().add(lblDonorId);
		
		textField = new JTextField();
		textField.setBounds(231, 108, 158, 24);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Continue");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PreparedStatement ps;
		        ResultSet rs;
		        
		        try {
		        	
		        	String NIC = textField.getText();
		        	String sqlQuery = "SELECT*FROM `Donors` WHERE `donor_nic`='"+NIC+"'";
					ps = DbConncetor.getConnection().prepareStatement(sqlQuery);
					
					rs = ps.executeQuery();
				    if(rs.next()){
				    	donorId = rs.getInt("donor_id");  
				    	ViewDonor viewDonor = new ViewDonor();
				    	viewDonor.frame.setVisible(true);
		            } 
				    else {
				    	JOptionPane.showMessageDialog(null, "No such donor", "failed", 2);
				    	textField.setText("");
				    }
					
		        }
		        catch (SQLException ex) {
					ex.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(241, 179, 106, 24);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Cancel");
		btnNewButton_1.setBounds(109, 179, 81, 25);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ManagePatients manageDonor = new ManagePatients();
				frame.dispose();
				manageDonor.frame.setVisible(true);
			}
		});
		btnBack.setBounds(12, 12, 70, 21);
		frame.getContentPane().add(btnBack);
	}

}
