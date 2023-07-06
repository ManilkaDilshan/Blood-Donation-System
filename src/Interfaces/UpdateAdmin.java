package Interfaces;

import java.awt.EventQueue;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UpdateAdmin {

	public JFrame frame;
	private JTextField textFirstNameField;
	private JTextField textLastNameField;
	private JTextField textContactNumberField;
	private JTextField textEmailField;
	private JTextField textNICField;
	private JTextField textUsernameField;
	private JPasswordField passwordField;
	private JPasswordField confirm_passwordField;
	public String userEmail;
	public String nic;
	public String username;
	
	String[] errors = new String[5];


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdateAdmin window = new UpdateAdmin();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public boolean checkUserName(String Username, String Email, String Nic) {
		
		PreparedStatement ps;
		ResultSet rs;
		boolean checkUser = false;
		String SqlQuery = "SELECT * FROM `Administrators` WHERE `admin_username`= '"+Username+"' OR `admin_email`='"+Email+"' OR `admin_nic`='"+Nic+"'";
		
		try {
			
			ps = DbConncetor.getConnection().prepareStatement(SqlQuery);
			rs  = ps.executeQuery();
			if (rs.next()) {
				if (Email.equals(rs.getString("admin_email")) && !Email.equals(userEmail)) {
					errors[2] = "Email already exist";
					JOptionPane.showMessageDialog(null, errors[2]);
					textEmailField.setText("");
					checkUser = true;
				}
				else if (Nic.equals(rs.getString("admin_nic")) && !Nic.equals(nic)) {
					errors[3] = "NIC already exist";
					JOptionPane.showMessageDialog(null, errors[3]);
					textNICField.setText("");
					checkUser = true;
				}
				else if (Username.equals(rs.getString("admin_username")) && !Nic.equals(username)) {
					errors[4] = "Username already exist";
					JOptionPane.showMessageDialog(null, errors[4]);
					textUsernameField.setText("");
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
	public UpdateAdmin() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frame = new JFrame();
		frame.setBounds(100, 100, 638, 457);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblRegister = new JLabel("Update Admin Details");
		lblRegister.setBounds(244, 23, 159, 35);
		frame.getContentPane().add(lblRegister);
		
		JLabel lblFirstName = new JLabel("First Name");
		lblFirstName.setBounds(65, 80, 151, 20);
		frame.getContentPane().add(lblFirstName);
		
		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setBounds(65, 119, 151, 14);
		frame.getContentPane().add(lblLastName);
		
		JLabel lblContactno = new JLabel("Contact  Number");
		lblContactno.setBounds(65, 156, 137, 17);
		frame.getContentPane().add(lblContactno);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(65, 195, 46, 14);
		frame.getContentPane().add(lblEmail);
		
		JLabel lblNIC = new JLabel("NIC");
		lblNIC.setBounds(65, 236, 46, 14);
		frame.getContentPane().add(lblNIC);
		
		JLabel lblUserName = new JLabel("Username");
		lblUserName.setBounds(65, 276, 89, 14);
		frame.getContentPane().add(lblUserName);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(65, 313, 137, 14);
		frame.getContentPane().add(lblPassword);
		
		JLabel lblReenterPassword = new JLabel("Confirm Password");
		lblReenterPassword.setBounds(65, 352, 216, 14);
		frame.getContentPane().add(lblReenterPassword);
		
		textFirstNameField = new JTextField();
		textFirstNameField.setText("");
		textFirstNameField.setBounds(201, 80, 202, 20);
		frame.getContentPane().add(textFirstNameField);
		textFirstNameField.setColumns(10);
		
		textLastNameField = new JTextField();
		textLastNameField.setColumns(10);
		textLastNameField.setBounds(201, 116, 202, 20);
		frame.getContentPane().add(textLastNameField);
		
		textContactNumberField = new JTextField();
		textContactNumberField.setColumns(10);
		textContactNumberField.setBounds(201, 156, 202, 20);
		frame.getContentPane().add(textContactNumberField);
		
		textEmailField = new JTextField();
		textEmailField.setColumns(10);
		textEmailField.setBounds(201, 192, 202, 20);
		frame.getContentPane().add(textEmailField);
		
		textNICField = new JTextField();
		textNICField.setColumns(10);
		textNICField.setBounds(201, 233, 202, 20);
		frame.getContentPane().add(textNICField);
		
		textUsernameField = new JTextField();
		textUsernameField.setColumns(10);
		textUsernameField.setBounds(201, 273, 202, 20);
		frame.getContentPane().add(textUsernameField);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(201, 310, 202, 20);
		frame.getContentPane().add(passwordField);
		
		confirm_passwordField = new JPasswordField();
		confirm_passwordField.setBounds(201, 349, 202, 20);
		frame.getContentPane().add(confirm_passwordField);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String FirstName = textFirstNameField.getText();
		        String LastName = textLastNameField.getText();
		        String Contact = textContactNumberField.getText();
		        String Email = textEmailField.getText();
		        String NIC = textNICField.getText();
		        String Username = textUsernameField.getText();
		        String Password = String.valueOf(passwordField.getPassword());
		        String ConfirmPassword = String.valueOf(confirm_passwordField.getPassword());
		        

	        	
		        
		        if (FirstName.equals("") || LastName.equals("") || Contact.equals("")|| Email.equals("") || Password.equals("")|| ConfirmPassword.equals("") ) {
		        	errors[0] = "All fields are required";
		        	JOptionPane.showMessageDialog(null, errors[0]);
		        	
		        }
		        

		        else if (!Password.equals(ConfirmPassword)) {
		        	errors[1]= "Type again your password correctly";
		        	JOptionPane.showMessageDialog(null, errors[1]);
		        	confirm_passwordField.setText("");
		        	
		        }
		        
		        else if (checkUserName(Username, Email, NIC)) {
		        }
		        else{
		        	PreparedStatement ps;
		        	ResultSet rs;
		        	int current = Login.userId;
		        	
		        	String sqlQuery = "UPDATE `Administrators` SET `admin_first_name`='"+FirstName+"', `admin_last_name`='"+LastName+"', `admin_contact_number`='"+Contact+"', `admin_email`='"+Email+"', `admin_nic`='"+NIC+"', `admin_username`='"+Username+"', `admin_password`='"+Password+"' WHERE `admin_id`= ?";
		        	
		        	
		        	try {
		        		ps = DbConncetor.getConnection().prepareStatement(sqlQuery);
			            ps.setInt(1, current);
						
		        		if(ps.executeUpdate()>0) {
		        			JOptionPane.showMessageDialog(null, "Successful", "Successful", 2);
		        			ManageAdmins manageAdmin = new ManageAdmins();
		        			frame.dispose();
		        			manageAdmin.frame.setVisible(true);
		        			
		        		}
		        	}
		        	catch(Exception ex) {
		        		System.out.println(ex);
		        	}
		        	
		        }		       
	        }
		});
			
		btnUpdate.setBounds(457, 154, 89, 20);
		frame.getContentPane().add(btnUpdate);
		
		JButton btnReset = new JButton("Cancel");
		btnReset.setBounds(457, 211, 89, 20);
		frame.getContentPane().add(btnReset);
		
	    JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ManageAdmins manageAdmins = new ManageAdmins();
				frame.dispose();
				manageAdmins.frame.setVisible(true);
			}
		});
		btnBack.setBounds(12, 12, 82, 22);
		frame.getContentPane().add(btnBack);
	
		PreparedStatement ps;
        ResultSet rs;
        String sqlQuery = "SELECT * FROM `Administrators` WHERE `admin_id` =?";
        try {
        	
        	int current = Login.userId;
        	
			ps = DbConncetor.getConnection().prepareStatement(sqlQuery);
			ps.setInt(1, current);
			
			rs  = ps.executeQuery();
			
		    if(rs.next()){
		    	textFirstNameField.setText(rs.getString("admin_first_name"));
		    	textLastNameField.setText(rs.getString("admin_last_name"));
		    	textContactNumberField.setText(rs.getString("admin_contact_number"));
		    	textEmailField.setText(rs.getString("admin_email"));
		    	textNICField.setText(rs.getString("admin_nic"));
		    	textUsernameField.setText(rs.getString("admin_username"));
		    	passwordField.setText(rs.getString("admin_password"));
		    	confirm_passwordField.setText(rs.getString("admin_password"));
		    	
		    	userEmail = rs.getString("admin_email");
		    	nic = rs.getString("admin_nic");
		    	username = rs.getString("admin_username");
            } 
			
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
    
	}
	
}
