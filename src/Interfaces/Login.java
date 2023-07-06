package Interfaces;

import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Font;


public class Login {

	public JFrame frame;
	private JPasswordField passwordField;
	private JTextField textUsername;
	public static int userId;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
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
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 564, 386);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lbLogin = new JLabel("LOGIN");
		lbLogin.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbLogin.setBounds(231, 26, 83, 41);
		frame.getContentPane().add(lbLogin);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(82, 155, 109, 23);
		frame.getContentPane().add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(84, 202, 170, 19);
		frame.getContentPane().add(lblPassword);
		
		JComboBox comboBoxUserType = new JComboBox();
		comboBoxUserType.setModel(new DefaultComboBoxModel(new String[] {"Administrator", "Doctor"}));
		comboBoxUserType.setToolTipText("");
		comboBoxUserType.setBounds(244, 111, 170, 22);
		frame.getContentPane().add(comboBoxUserType);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(244, 198, 170, 23);
		frame.getContentPane().add(passwordField);
		
		JButton btnSubmit = new JButton("LOGIN ");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PreparedStatement ps;
		        ResultSet rs;
		        String uname = textUsername.getText();
		        String pass = String.valueOf(passwordField.getPassword());
		        String type = comboBoxUserType.getSelectedItem().toString();
		        
		        if(type=="Administrator") {
		        	
		        	String sqlQuery = "SELECT * FROM `Administrators` WHERE `admin_username` =? AND `admin_password` =?";
			        
			        try{
			        	ps = DbConncetor.getConnection().prepareStatement(sqlQuery);
			        	ps.setString(1, uname);
			            ps.setString(2, pass);
			            
			            rs = ps.executeQuery();
			            if(rs.next()){
			            	
			            	userId = rs.getInt("admin_id");
			            	
			            	frame.dispose();
			            	AdminHome adminHome = new AdminHome();
			            	adminHome.frame.setVisible(true);	
			            } 
			            else{
			            	JOptionPane.showMessageDialog(null, "Incorrect Username Or Password", "Login Failed", 2);
			            	textUsername.setText("");
							passwordField.setText("");
			            }
			        	
			        } catch(SQLException ex) {
			        	System.out.println(ex);
			        }
		        }
		        else {
		        	
		        	String sqlQuery = "SELECT * FROM `Doctors` WHERE `doctor_username` =? AND `doctor_password` =?";
			        
			        try{
			        	ps = DbConncetor.getConnection().prepareStatement(sqlQuery);
			        	ps.setString(1, uname);
			            ps.setString(2, pass);
			            
			            rs = ps.executeQuery();
			            if(rs.next()){
			            	
			            	frame.dispose();
			            	DoctorHome doctorHome = new DoctorHome();
			            	doctorHome.frame.setVisible(true);
			            	
			            }
			            else{
			            	JOptionPane.showMessageDialog(null, "Incorrect Username Or Password", "Login Failed", 2);
			            	textUsername.setText("");
							passwordField.setText("");
			            }
			        	
			        } catch(SQLException ex) {
			        	System.out.println(ex);
			        }
		        }
		        
		        
		        
			}

			
		});
		btnSubmit.setBounds(319, 257, 89, 41);
		frame.getContentPane().add(btnSubmit);
		
		textUsername = new JTextField();
		textUsername.setBounds(244, 155, 170, 22);
		frame.getContentPane().add(textUsername);
		textUsername.setColumns(10);
		
		JButton btnReset = new JButton("CANCEL");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				textUsername.setText("");
				passwordField.setText("");
			}
		});
		btnReset.setBounds(200, 256, 89, 43);
		frame.getContentPane().add(btnReset);
		
		JLabel lblUsertype = new JLabel("User Type ");
		lblUsertype.setBounds(82, 115, 78, 14);
		frame.getContentPane().add(lblUsertype);
		
		JButton btnRegister = new JButton("SIGNUP");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String type = comboBoxUserType.getSelectedItem().toString();
				if (type=="Administrator") {
					AdminRegister adminRegister = new AdminRegister();
					frame.dispose();
					adminRegister.frame.setVisible(true);
					
				}else {
					JOptionPane.showMessageDialog(null, "Contact Administrator for signup", "Oops!", 2);
				}
				
			}
		});
		btnRegister.setBounds(82, 259, 98, 41);
		frame.getContentPane().add(btnRegister);
		

	}
}