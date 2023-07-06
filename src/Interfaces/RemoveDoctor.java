package Interfaces;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class RemoveDoctor {

	public JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RemoveDoctor window = new RemoveDoctor();
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
	public RemoveDoctor(){
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
		
		JLabel lblRemoveDoctor = new JLabel("Remove Doctor");
		lblRemoveDoctor.setBounds(167, 23, 146, 20);
		frame.getContentPane().add(lblRemoveDoctor);
		
		JLabel lblDoctorId = new JLabel("Doctor Id");
		lblDoctorId.setBounds(83, 95, 70, 15);
		frame.getContentPane().add(lblDoctorId);
		
		textField = new JTextField();
		textField.setBounds(222, 93, 137, 19);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnRemove = new JButton("Remove");
		btnRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 
				PreparedStatement ps;
		        ResultSet rs;
		        
		        try {
		        	
		        	int ID = Integer.parseInt(textField.getText());
		        	String sqlQuery = "DELETE FROM `Doctors` WHERE `doctor_id`='"+ID+"'";
					ps = DbConncetor.getConnection().prepareStatement(sqlQuery);
					
				    if(ps.executeUpdate()>0){
				    	JOptionPane.showMessageDialog(null, "Successful", "Successful", 2);
				    	textField.setText("");
		            	
		            } 
				    else {
				    	JOptionPane.showMessageDialog(null, "No such user", "ailed", 2);
				    	textField.setText("");
				    }
					
				} catch(NumberFormatException ex1){
					JOptionPane.showMessageDialog(null, "Enter only numbers", "ailed", 2);
					
				}
		        catch (SQLException ex) {
					ex.printStackTrace();
				}
			}
			
		});
		btnRemove.setBounds(219, 159, 94, 20);
		frame.getContentPane().add(btnRemove);
		
		JButton btnCance = new JButton("Cancel");
		btnCance.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText("");
			}
		});
		btnCance.setBounds(102, 159, 81, 20);
		frame.getContentPane().add(btnCance);
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ManageDoctors manageDoctors = new ManageDoctors();
				frame.dispose();
				manageDoctors.frame.setVisible(true);
			}
		});
		btnNewButton.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton.setFont(new Font("Dialog", Font.BOLD, 9));
		btnNewButton.setBounds(12, 23, 57, 20);
		frame.getContentPane().add(btnNewButton);
	}
}
