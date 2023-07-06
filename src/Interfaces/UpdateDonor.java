package Interfaces;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.AbstractButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


public class UpdateDonor {

	public JFrame frame;
	
	String[] errors = new String[5];

	private JTextField textFirstNameField;

	private JTextField textContactNumberField;

	private JTextField textLastNameField;

	private JTextField textNICField;

	private AbstractButton textBloodTypeField;

	private String nic;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdateDonor window = new UpdateDonor();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
public boolean checkDonor(String Nic) {
		
		PreparedStatement ps;
		ResultSet rs;
		boolean checkUser = false;
		String SqlQuery = "SELECT * FROM `Donors` WHERE `donor_nic`='"+Nic+"'";
		
		try {
			
			ps = DbConncetor.getConnection().prepareStatement(SqlQuery);
			rs  = ps.executeQuery();
			if (rs.next()) {
				
				if (Nic.equals(rs.getString("donor_nic"))&& !Nic.equals(nic)) {
					errors[3] = "NIC already exist";
					JOptionPane.showMessageDialog(null, errors[3]);
					textNICField.setText("");
					checkUser = true;
				}
								
			}
		}catch(Exception e) {
			System.out.println(e);
		}
		return checkUser;
	}

	/**
	 * Create the application.
	 */
	public UpdateDonor() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 583, 384);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblRegister = new JLabel("Donor Registration");
		lblRegister.setBounds(244, 23, 159, 35);
		frame.getContentPane().add(lblRegister);
		
		JLabel lblFirstName = new JLabel("First Name");
		lblFirstName.setBounds(65, 80, 119, 20);
		frame.getContentPane().add(lblFirstName);
		
		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setBounds(65, 119, 137, 14);
		frame.getContentPane().add(lblLastName);
		
		JLabel lblContactno = new JLabel("Contact  Number");
		lblContactno.setBounds(65, 157, 137, 17);
		frame.getContentPane().add(lblContactno);
		
		JLabel lblNIC = new JLabel("NIC");
		lblNIC.setBounds(65, 201, 74, 14);
		frame.getContentPane().add(lblNIC);
		
		
		JLabel lblBloodType = new JLabel("Blood Type");
		lblBloodType.setBounds(65, 245, 119, 14);
		frame.getContentPane().add(lblBloodType);
		
		textFirstNameField = new JTextField();
		textFirstNameField.setBounds(201, 80, 202, 20);
		frame.getContentPane().add(textFirstNameField);
		textFirstNameField.setColumns(10);
		
		textLastNameField = new JTextField();
		textLastNameField.setColumns(10);
		textLastNameField.setBounds(201, 117, 202, 20);
		frame.getContentPane().add(textLastNameField);
		
		textContactNumberField = new JTextField();
		textContactNumberField.setColumns(10);
		textContactNumberField.setBounds(201, 156, 202, 20);
		frame.getContentPane().add(textContactNumberField);
		
		textNICField = new JTextField();
		textNICField.setColumns(10);
		textNICField.setBounds(201, 199, 202, 20);
		frame.getContentPane().add(textNICField);
		
		JComboBox comboBoxBloodtype = new JComboBox();
		comboBoxBloodtype.setModel(new DefaultComboBoxModel(new String[] {"A+", "A-", "B+","B-","AB+","AB-","O+","O-"}));
		comboBoxBloodtype.setToolTipText("");
		comboBoxBloodtype.setBounds(202, 241, 201, 22);
		frame.getContentPane().add(comboBoxBloodtype);
		
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ManagePatients manageDonor = new ManagePatients();
				frame.dispose();
				manageDonor.frame.setVisible(true);
			}
		});
		btnBack.setBounds(12, 12, 82, 22);
		frame.getContentPane().add(btnBack);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				String FirstName = textFirstNameField.getText();
		        String LastName = textLastNameField.getText();
		        String Contact = textContactNumberField.getText();
		        String NIC = textNICField.getText();
		        String BloodType = comboBoxBloodtype.getSelectedItem().toString();
		        
		        if (FirstName.equals("") || LastName.equals("") || Contact.equals("")||  NIC.equals("") ) {
		        	errors[0] = "All fields are required";
		        	JOptionPane.showMessageDialog(null, errors[0]);
		        	
		        }
		        
		        else if (checkDonor(NIC)) {
		        }
		        else{
		        	PreparedStatement ps;
		        	int current = GetDonor.donorId;
		        	String sqlQuery = "UPDATE `Donors` SET `donor_first_name`='"+FirstName+"', `donor_last_name`='"+LastName+"', `donor_contact_number`='"+Contact+"', `donor_nic`='"+NIC+"', `donor_blood_type`='"+BloodType+"' WHERE `donor_id`= ?";
				        	
		        	try {
		        		
		        		
		        		ps = DbConncetor.getConnection().prepareStatement(sqlQuery);
		        		ps.setInt(1, current);
			           			            
		        		if(ps.executeUpdate()>0) {
		        			
		        			JOptionPane.showMessageDialog(null, "Successful", "Successful", 2);
		        			frame.dispose();
		        			ManagePatients managePatients = new ManagePatients();
		        			managePatients.frame.setVisible(true);
		        			
		        		}
		        	}
		        	catch(Exception ex) {
		        		System.out.println(ex);
		        	}
		        	
		        }		       
	        }
		});
		btnUpdate.setBounds(436, 167, 103, 28);
		frame.getContentPane().add(btnUpdate);
		
		PreparedStatement ps;
        ResultSet rs;
        String sqlQuery = "SELECT * FROM `Donors` WHERE `donor_id` =?";
        try {
        	
        	int current = GetDonor.donorId;
        	
			ps = DbConncetor.getConnection().prepareStatement(sqlQuery);
			ps.setInt(1, current);
			
			rs  = ps.executeQuery();
			
		    if(rs.next()){
		    	textFirstNameField.setText(rs.getString("donor_first_name"));
		    	textLastNameField.setText(rs.getString("donor_last_name"));
		    	textContactNumberField.setText(rs.getString("donor_contact_number"));
		    	
		    	textNICField.setText(rs.getString("donor_nic"));
		    	comboBoxBloodtype.setToolTipText(rs.getString("donor_blood_type"));
		    	
		    	
		    	
		    	nic = rs.getString("donor_nic");
		    	
		    }
        }
	    catch (SQLException e) {
			e.printStackTrace();
		}
        JButton btnReset = new JButton("Cancel");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textFirstNameField.setText("");
				textLastNameField.setText("");
				textContactNumberField.setText("");
				textNICField.setText("");
			}
			
		});
		btnReset.setBounds(436, 222, 103, 28);
		frame.getContentPane().add(btnReset);
        
	}
}
        
	


