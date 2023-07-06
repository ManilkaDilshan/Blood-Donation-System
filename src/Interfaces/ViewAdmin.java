package Interfaces;

import java.awt.EventQueue;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ViewAdmin {

	public JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewAdmin window = new ViewAdmin();
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
	public ViewAdmin() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frame = new JFrame();
		frame.setBounds(100, 100, 500, 334);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblYourProfile = new JLabel("My  Profile");
		lblYourProfile.setBounds(178, 12, 128, 22);
		frame.getContentPane().add(lblYourProfile);
		
		JLabel lblName = new JLabel("Name ");
		lblName.setBounds(58, 95, 44, 22);
		frame.getContentPane().add(lblName);
		
		JLabel lblId = new JLabel("Id");
		lblId.setBounds(58, 68, 38, 15);
		frame.getContentPane().add(lblId);
		
		JLabel lblContactN = new JLabel("Contact No");
		lblContactN.setBounds(58, 156, 91, 15);
		frame.getContentPane().add(lblContactN);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(58, 129, 70, 15);
		frame.getContentPane().add(lblEmail);
		
		JLabel lblNic = new JLabel("NIC");
		lblNic.setBounds(58, 183, 70, 15);
		frame.getContentPane().add(lblNic);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(58, 210, 111, 15);
		frame.getContentPane().add(lblUsername);
		
		JLabel lblRegisteredDate = new JLabel("Registered Date");
		lblRegisteredDate.setBounds(58, 237, 128, 15);
		frame.getContentPane().add(lblRegisteredDate);
		
		JLabel lblUserType = new JLabel("User Type");
		lblUserType.setBounds(58, 41, 111, 15);
		frame.getContentPane().add(lblUserType);
		
		JLabel labelUserType = new JLabel("Administrator");
		labelUserType.setBounds(244, 42, 191, 15);
		frame.getContentPane().add(labelUserType);
		
		JLabel labelId = new JLabel(" ");
		labelId.setBounds(244, 69, 191, 15);
		frame.getContentPane().add(labelId);
		
		JLabel labelName = new JLabel(" ");
		labelName.setBounds(244, 96, 191, 15);
		frame.getContentPane().add(labelName);
		
		JLabel labelEmail = new JLabel(" ");
		labelEmail.setBounds(244, 123, 191, 15);
		frame.getContentPane().add(labelEmail);
		
		JLabel labelContactNo = new JLabel(" ");
		labelContactNo.setBounds(244, 154, 191, 15);
		frame.getContentPane().add(labelContactNo);
		
		JLabel labelNIC = new JLabel(" ");
		labelNIC.setBounds(244, 181, 191, 15);
		frame.getContentPane().add(labelNIC);
		
		JLabel labelUserName = new JLabel(" ");
		labelUserName.setBounds(244, 208, 191, 15);
		frame.getContentPane().add(labelUserName);
		
		JLabel labelRegDate = new JLabel(" ");
		labelRegDate.setBounds(244, 237, 191, 15);
		frame.getContentPane().add(labelRegDate);
		
		JButton btnUpdate = new JButton("Edit");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UpdateAdmin updateAdmin = new UpdateAdmin();
				frame.dispose();
				updateAdmin.frame.setVisible(true);
			}
		});
		btnUpdate.setBounds(318, 263, 75, 22);
		frame.getContentPane().add(btnUpdate);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ManageAdmins manageAdmin = new ManageAdmins();
				frame.dispose();
				manageAdmin.frame.setVisible(true);
			}
		});
		btnBack.setBounds(136, 263, 82, 22);
		frame.getContentPane().add(btnBack);
		
		PreparedStatement ps;
        ResultSet rs;
        String sqlQuery = "SELECT * FROM `Administrators` WHERE `admin_id` =?";
        try {
        	
        	int current = Login.userId;
        	
			ps = DbConncetor.getConnection().prepareStatement(sqlQuery);
			ps.setInt(1, current);
			System.out.println(current);
			rs  = ps.executeQuery();
			
		    if(rs.next()){
			    labelId.setText(rs.getString("admin_id"));
				labelName.setText(rs.getString("admin_first_name") + " " +rs.getString("admin_last_name"));
				labelEmail.setText(rs.getString("admin_email"));
				labelContactNo.setText(rs.getString("admin_contact_number"));
				labelNIC.setText(rs.getString("admin_nic"));
				labelUserName.setText(rs.getString("admin_username"));
				labelRegDate.setText(rs.getString("registered_date"));
            	
            } 
			
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
