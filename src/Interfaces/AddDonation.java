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

public class AddDonation {

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
					AddDonation window = new AddDonation();
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
	public AddDonation() {
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
		
		JLabel lblDonnation = new JLabel("Donnation");
		lblDonnation.setBounds(175, 22, 93, 15);
		frame.getContentPane().add(lblDonnation);
		
		JLabel lblDonorNic = new JLabel("Donor NIC");
		lblDonorNic.setBounds(86, 97, 70, 15);
		frame.getContentPane().add(lblDonorNic);
		
		textField = new JTextField();
		textField.setBounds(206, 95, 163, 29);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PreparedStatement ps;
		       
		        
		        try {
		        	
		        	String NIC = textField.getText();
		        	String sqlQuery = "INSERT INTO `Donations` (`donor_id`) VALUES (?)";
					ps = DbConncetor.getConnection().prepareStatement(sqlQuery);
					ps.setString(1, NIC);
					
				    if(ps.executeUpdate()>0){
				    	JOptionPane.showMessageDialog(null, "Successfully Donated", "Successful", 2);
				    	textField.setText("");
	        			
		            } 
				    else {
				    	JOptionPane.showMessageDialog(null, "No such donor", "failed", 2);
				    	textField.setText("");
				    }
					
		        }
		        catch (SQLException ex) {
					ex.printStackTrace();
				}
		        catch(Exception ex2){
		        	JOptionPane.showMessageDialog(null, "Add valid nic", "failed", 2);
		        }
			}
		});
		btnAdd.setBounds(256, 170, 70, 25);
		frame.getContentPane().add(btnAdd);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBounds(130, 170, 81, 25);
		frame.getContentPane().add(btnCancel);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ManagePatients manageDonor = new ManagePatients();
				frame.dispose();
				manageDonor.frame.setVisible(true);
			}
		});
		btnBack.setBounds(12, 17, 67, 25);
		frame.getContentPane().add(btnBack);
	}
}
