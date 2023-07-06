package Interfaces;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.awt.event.ActionEvent;

public class AdminRegister {

	public JFrame frame;
	private JTextField textFirstNameField;
	private JTextField textLastNameField;
	private JTextField textContactNumberField;
	private JTextField textEmailField;
	private JTextField textNICField;
	private JTextField textUsernameField;
	private JPasswordField passwordField;
	private JPasswordField confirm_passwordField;

    String[] errors = new String[5];

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminRegister window = new AdminRegister();
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
				if (Email.equals(rs.getString("admin_email"))) {
					errors[2] = "Email already exist";
					JOptionPane.showMessageDialog(null, errors[2]);
					textEmailField.setText("");
					checkUser = true;
				}
				else if (Nic.equals(rs.getString("admin_nic"))) {
					errors[3] = "NIC already exist";
					JOptionPane.showMessageDialog(null, errors[3]);
					textNICField.setText("");
					checkUser = true;
				}
				else if (Username.equals(rs.getString("admin_username"))) {
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
	public AdminRegister() {
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
		
		JLabel lblRegister = new JLabel("Administrator SignUp");
		lblRegister.setBounds(244, 23, 159, 35);
		frame.getContentPane().add(lblRegister);
		
		JLabel lblFirstName = new JLabel("First Name");
		lblFirstName.setBounds(65, 80, 119, 20);
		frame.getContentPane().add(lblFirstName);
		
		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setBounds(65, 119, 137, 14);
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
		lblPassword.setBounds(65, 313, 119, 14);
		frame.getContentPane().add(lblPassword);
		
		JLabel lblReenterPassword = new JLabel("Confirm Password");
		lblReenterPassword.setBounds(65, 352, 159, 14);
		frame.getContentPane().add(lblReenterPassword);
		
		textFirstNameField = new JTextField();
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
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ManageAdmins manageAdmin = new ManageAdmins();
				frame.dispose();
				manageAdmin.frame.setVisible(true);
			}
		});
		btnBack.setBounds(12, 12, 82, 22);
		frame.getContentPane().add(btnBack);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.addActionListener(new ActionListener() {
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
		        	String sqlQuery = "INSERT INTO `Administrators` (`admin_first_name`, `admin_last_name`, `admin_contact_number`, `admin_email`, `admin_nic`, `admin_username`, `admin_password`) VALUES(?,?,?,?,?,?,?)";
		        	
		        	try {
		        		ps = DbConncetor.getConnection().prepareStatement(sqlQuery);
		        		ps.setString(1, FirstName);
			            ps.setString(2, LastName);
			            ps.setString(3, Contact);
			            ps.setString(4, Email);
			            ps.setString(5, NIC);
			            ps.setString(6, Username);
			            ps.setString(7, Password);

			            
		        		if(ps.executeUpdate()>0) {
		        			frame.dispose();
		        			JOptionPane.showMessageDialog(null, "Successful", "Successful", 2);
		        			Login newLogin2 = new Login();
			            	newLogin2.frame.setVisible(true);
		        			
		        		}
		        	}
		        	catch(Exception ex) {
		        		System.out.println(ex);
		        	}
		        	
		        }		       
	        }
		});
		btnRegister.setBounds(436, 167, 103, 28);
		frame.getContentPane().add(btnRegister);
		
		JButton btnReset = new JButton("Cancel");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textFirstNameField.setText("");
				textLastNameField.setText("");
				textContactNumberField.setText("");
				textEmailField.setText("");
				textNICField.setText("");
				textUsernameField.setText("");
				passwordField.setText("");
				confirm_passwordField.setText("");
			}
			
		});
		btnReset.setBounds(436, 222, 103, 28);
		frame.getContentPane().add(btnReset);
	}
}
