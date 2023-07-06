package Interfaces;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class ViewDonor {

	public JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewDonor window = new ViewDonor();
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
	public ViewDonor() {
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
		
		JLabel lblYourProfile = new JLabel("Donor Details");
		lblYourProfile.setBounds(178, 12, 128, 22);
		frame.getContentPane().add(lblYourProfile);
		
		JLabel lblName = new JLabel("Name ");
		lblName.setBounds(58, 95, 44, 22);
		frame.getContentPane().add(lblName);
		
		JLabel lblId = new JLabel("Id");
		lblId.setBounds(58, 68, 38, 15);
		frame.getContentPane().add(lblId);
		
		JLabel lblContactN = new JLabel("Contact No");
		lblContactN.setBounds(58, 126, 91, 15);
		frame.getContentPane().add(lblContactN);
		
		
		JLabel lblNic = new JLabel("NIC");
		lblNic.setBounds(58, 153, 70, 15);
		frame.getContentPane().add(lblNic);
		
		JLabel lblBloodType = new JLabel("Blood Type");
		lblBloodType.setBounds(58, 180, 111, 15);
		frame.getContentPane().add(lblBloodType);
		
		JLabel lblRegisteredDate = new JLabel("Registered Date");
		lblRegisteredDate.setBounds(58, 207, 128, 15);
		frame.getContentPane().add(lblRegisteredDate);
		
		
		JLabel labelId = new JLabel(" ");
		labelId.setBounds(244, 69, 191, 15);
		frame.getContentPane().add(labelId);
		
		JLabel labelName = new JLabel(" ");
		labelName.setBounds(244, 96, 191, 15);
		frame.getContentPane().add(labelName);
		
		JLabel labelContactNo = new JLabel(" ");
		labelContactNo.setBounds(244, 124, 191, 15);
		frame.getContentPane().add(labelContactNo);
		
		JLabel labelNIC = new JLabel(" ");
		labelNIC.setBounds(244, 151, 191, 15);
		frame.getContentPane().add(labelNIC);
		
		JLabel labelBloodType = new JLabel(" ");
		labelBloodType.setBounds(244, 178, 191, 15);
		frame.getContentPane().add(labelBloodType);
		
		JLabel labelRegDate = new JLabel(" ");
		labelRegDate.setBounds(244, 207, 191, 15);
		frame.getContentPane().add(labelRegDate);
		
		JButton btnUpdate = new JButton("Edit");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UpdateDonor updateDonor = new UpdateDonor();
				frame.dispose();
				updateDonor.frame.setVisible(true);
			}
		});
		btnUpdate.setBounds(288, 244, 75, 22);
		frame.getContentPane().add(btnUpdate);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ManageAdmins manageAdmin = new ManageAdmins();
				frame.dispose();
				manageAdmin.frame.setVisible(true);
			}
		});
		btnBack.setBounds(141, 244, 82, 22);
		frame.getContentPane().add(btnBack);
		
		PreparedStatement ps;
        ResultSet rs;
        String sqlQuery = "SELECT * FROM `Donors` WHERE `donor_id` =?";
        try {
        	
        	int current = GetDonor.donorId;
			ps = DbConncetor.getConnection().prepareStatement(sqlQuery);
			ps.setInt(1, current);
			rs  = ps.executeQuery();
			
		    if(rs.next()){
			    labelId.setText(rs.getString("donor_id"));
				labelName.setText(rs.getString("donor_first_name") + " " +rs.getString("donor_last_name"));
				labelContactNo.setText(rs.getString("donor_contact_number"));
				labelNIC.setText(rs.getString("donor_nic"));
				labelBloodType.setText(rs.getString("donor_blood_type"));
				labelRegDate.setText(rs.getString("registered_date"));
            	
            } 
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
