package Master;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.SwingConstants;

import java.awt.Font;
import java.awt.Color;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;


public class BankMaster extends JFrame {

	private JPanel contentPane;
	private JTextField bankname_bm_text;
	private JTextField accountname_bm_text;
	private JTextField bankaddress_bm_text;
	private static Statement st;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BankMaster frame = new BankMaster();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void clearScreen() {
		bankname_bm_text.setText(null);
		bankaddress_bm_text.setText(null);
		accountname_bm_text.setText(null);
	}

	/**
	 * Create the frame.
	 */
	public BankMaster() {
		setTitle("Bank Master");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 443, 221);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNameOfThe = new JLabel("Bank Name *");
		lblNameOfThe.setBounds(10, 20, 100, 14);
		contentPane.add(lblNameOfThe);

		bankname_bm_text = new JTextField();
		
		bankname_bm_text.setBounds(132, 17, 239, 20);
		contentPane.add(bankname_bm_text);
		bankname_bm_text.setColumns(10);

		JLabel lblNewLabel = new JLabel("Bank Address *");
		lblNewLabel.setBounds(10, 60, 100, 14);
		contentPane.add(lblNewLabel);

		accountname_bm_text = new JTextField();
		accountname_bm_text.setBounds(132, 97, 239, 20);
		contentPane.add(accountname_bm_text);
		accountname_bm_text.setColumns(10);

		JLabel lblAccountNumber = new JLabel("Account Number *");
		lblAccountNumber.setBounds(10, 100, 112, 14);
		contentPane.add(lblAccountNumber);

		bankaddress_bm_text = new JTextField();
		bankaddress_bm_text.setColumns(10);
		bankaddress_bm_text.setBounds(132, 57, 239, 20);
		contentPane.add(bankaddress_bm_text);
		
		JLabel lbl_validate = new JLabel("!");
		lbl_validate.setVisible(false);
		lbl_validate.setForeground(Color.RED);
		lbl_validate.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_validate.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbl_validate.setBounds(373, 15, 19, 20);
		contentPane.add(lbl_validate);
		
		JLabel lbl_validate1 = new JLabel("!");
		lbl_validate1.setVisible(false);
		lbl_validate1.setForeground(Color.RED);
		lbl_validate1.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_validate1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbl_validate1.setBounds(373, 57, 19, 20);
		contentPane.add(lbl_validate1);
		
		JLabel lbl_validate2 = new JLabel("!");
		lbl_validate2.setVisible(false);
		lbl_validate2.setForeground(Color.RED);
		lbl_validate2.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_validate2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbl_validate2.setBounds(373, 97, 19, 20);
		contentPane.add(lbl_validate2);

		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String bankname=bankname_bm_text.getText().toString();
				String bankaddress=bankaddress_bm_text.getText().toString();
				String accountnumber=accountname_bm_text.getText().toString();

				//Validate all the required fields

				if(bankname_bm_text.getText().equals(""))
				{
					lbl_validate.setVisible(true);
					lbl_validate1.setVisible(false);
					lbl_validate1.setVisible(false);
					bankname_bm_text.setBorder(new LineBorder(Color.RED));
					bankaddress_bm_text.setBorder(new LineBorder(Color.GRAY));
					accountname_bm_text.setBorder(new LineBorder(Color.GRAY));
				}
				else if(bankaddress_bm_text.getText().equals(""))
				{
					bankname_bm_text.setBorder(new LineBorder(Color.GRAY));
					bankaddress_bm_text.setBorder(new LineBorder(Color.RED));
					accountname_bm_text.setBorder(new LineBorder(Color.GRAY));
					lbl_validate1.setVisible(true);
					lbl_validate.setVisible(false);
					lbl_validate2.setVisible(false);
				}
				else if(accountname_bm_text.getText().equals(""))
					
					{
					lbl_validate2.setVisible(true);
					lbl_validate.setVisible(false);
					lbl_validate1.setVisible(false);
			
					bankname_bm_text.setBorder(new LineBorder(Color.GRAY));
					bankaddress_bm_text.setBorder(new LineBorder(Color.GRAY));
					accountname_bm_text.setBorder(new LineBorder(Color.RED));
					}
					
				else{


					try {

						databaseConnectivity();
						int res=st.executeUpdate("INSERT INTO `fms`.`bank_master` (`BankName`, `BankAddress`, ` BankAccountNumber`) VALUES ('"+bankname+"', '"+bankaddress+"', '"+accountnumber+"');");
						if(res==1)
							JOptionPane.showMessageDialog(btnSave, "Data Saved Sucessfully");
						clearScreen();
					} catch (ClassNotFoundException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

				}
			}

		});
		btnSave.setBounds(10, 140, 74, 23);
		contentPane.add(btnSave);

		JButton btnFind = new JButton("Find");
		btnFind.setBounds(102, 140, 74, 23);
		contentPane.add(btnFind);

		// Clear Button
		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clearScreen();
			}
		});
		btnClear.setBounds(201, 140, 74, 23);
		contentPane.add(btnClear);

		JButton btn_Delete = new JButton("Delete");
		btn_Delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					Connection conn;
					String dbuser = "root";
					String dbpassw = "mysql";
					String databasename = "fms";
					String url = "jdbc:mysql://localhost/" + databasename;
					Class.forName("com.mysql.jdbc.Driver");
					conn = DriverManager.getConnection (url, dbuser, dbpassw);
					Statement st = conn.createStatement();


					ResultSet res1=st.executeQuery("Select * from bank_master");
					if(res1.next()){
						int i=JOptionPane.showConfirmDialog(btn_Delete, "Are you sure you want to delete this data?");
						if(i == JOptionPane.YES_OPTION){
							String bankname= bankname_bm_text.getText().toString();
							int j=JOptionPane.showConfirmDialog(btn_Delete, "Are you sure you want to delete agent "+bankname+"?");
							if(j==JOptionPane.YES_OPTION)
							{
								st.executeUpdate("DELETE FROM bank_master WHERE BankName='"+bankname+"'");							
								JOptionPane.showMessageDialog(btn_Delete, "Data Successfully Deleted");

							}
							clearScreen();
						}


						else{
							JOptionPane.showMessageDialog(btn_Delete, "No Records to delete");
						}


					}
				}
				catch ( ClassNotFoundException e1 ) {
					JOptionPane.showMessageDialog(btn_Delete,e1.getMessage());
				}
				catch(SQLException e1) {
					JOptionPane.showMessageDialog(btn_Delete,"Please contact the Software Developer and notify that a SQL error occurred on login.");
				}
			}
		});
		btn_Delete.setBounds(297, 140, 74, 23);
		contentPane.add(btn_Delete);
		
	
	}

		//Connection to Database. Returns statement st.
	public static Statement databaseConnectivity() throws ClassNotFoundException,
	SQLException {
		Connection conn;
		String dbuser = "root";
		String dbpassw = "mysql";
		String databasename = "fms";
		String url = "jdbc:mysql://localhost/" + databasename;
		Class.forName("com.mysql.jdbc.Driver");
		conn = DriverManager.getConnection (url, dbuser, dbpassw);
		st = conn.createStatement();
		return st;
	}
	
}

