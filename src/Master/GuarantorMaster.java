package Master;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.DebugGraphics;
import javax.swing.JButton;

import org.omg.CosNaming.NamingContextExtPackage.AddressHelper;

import com.mysql.jdbc.StringUtils;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.border.TitledBorder;

public class GuarantorMaster extends JFrame {

	private JPanel contentPane;
	public static JTextField guarantorid_gm_text, nameofperson_gm_text, fathersname_gm_text, pin_gm_text, phone1_gm_text, guarantorbank_gm_text;
	public static JTextField mobile1_gm_text, email_gm_text,  bankaddress_gm_text, chequedetails_gm_text, remarks_gm_text, city_gm_text, mobile2_gm_text, phone2_gm_text;
	public static JTextArea address_gm_text;
	public ResultSet res;
	public JButton btn_Left;
	public JButton btn_Right;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GuarantorMaster frame = new GuarantorMaster();
					frame.setLocation(200,100);
					frame.setSize(750,580);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public void SetSearchResults(ResultSet rs) throws SQLException {
		res = rs;
		showRecord();

	}


	public void showRecord() throws SQLException {

		guarantorid_gm_text.setText(res.getString("GuarantorId"));
		nameofperson_gm_text.setText(res.getString("GuarantorName"));
		fathersname_gm_text.setText(res.getString("GuarantorFatherName"));
		address_gm_text.setText(res.getString("GuarantorAddress"));
		city_gm_text.setText(res.getString("GuarantorCity"));
		email_gm_text.setText(res.getString("GuarantorEmail"));
		mobile1_gm_text.setText(res.getString("GuarantorMobile"));
		mobile2_gm_text.setText(res.getString("GuarantorMobile2"));
		phone1_gm_text.setText(res.getString("GuarantorPhone"));
		phone2_gm_text.setText(res.getString("GuarantorPhone2"));
		pin_gm_text.setText(res.getString("GuarantorPin"));
		guarantorbank_gm_text.setText(res.getString("GuarantorBank"));
		bankaddress_gm_text.setText("GuarantorbankAddress");
		chequedetails_gm_text.setText("GuarantorChequeDetails");

	}

	public void changeNavigationState() throws SQLException {
		if(res.isFirst())
		{
			btn_Left.setEnabled(false);
		}
		else {
			btn_Left.setEnabled(true);
		}

		if(res.isLast())
		{
			btn_Right.setEnabled(false);
		}
		else {
			btn_Right.setEnabled(true);
		}
	}
	/**
	 * Create the frame.
	 */
	public GuarantorMaster() {
		setTitle("Guarantor Master");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 767, 576);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel.setBounds(0, 0, 860, 536);
		contentPane.add(panel);

		JLabel lblGuarantorid = new JLabel("GuarantorId");
		lblGuarantorid.setBounds(30, 26, 92, 14);
		panel.add(lblGuarantorid);

		JLabel label_1 = new JLabel("Name of Person *");
		label_1.setBounds(30, 56, 133, 14);
		panel.add(label_1);

		JLabel label_2 = new JLabel("Father's Name");
		label_2.setBounds(30, 86, 102, 14);
		panel.add(label_2);

		JLabel label_3 = new JLabel("Address");
		label_3.setBounds(30, 116, 80, 14);
		panel.add(label_3);

		JLabel label_4 = new JLabel("City");
		label_4.setBounds(30, 176, 46, 14);
		panel.add(label_4);

		JLabel label_5 = new JLabel("Phone");
		label_5.setBounds(30, 211, 46, 14);
		panel.add(label_5);

		JLabel label_6 = new JLabel("Mobile");
		label_6.setBounds(30, 236, 46, 14);
		panel.add(label_6);

		JPanel panel_1 = new JPanel();
		panel_1.setName("");
		panel_1.setInheritsPopupMenu(true);
		panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Bank Details", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBounds(10, 302, 541, 175);
		panel.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblRemarks = new JLabel("Remarks");
		lblRemarks.setBounds(10, 121, 80, 14);
		panel_1.add(lblRemarks);

		JLabel lblGuarantorBank = new JLabel("Guarantor Bank");
		lblGuarantorBank.setBounds(10, 31, 120, 14);
		panel_1.add(lblGuarantorBank);

		JLabel lblBankAddress = new JLabel("Bank Address");
		lblBankAddress.setBounds(10, 61, 92, 14);
		panel_1.add(lblBankAddress);

		JLabel lblChequeDetails = new JLabel("Cheque Details");
		lblChequeDetails.setBounds(10, 91, 92, 14);
		panel_1.add(lblChequeDetails);

		guarantorbank_gm_text = new JTextField();
		guarantorbank_gm_text.setBounds(140, 28, 391, 20);
		panel_1.add(guarantorbank_gm_text);
		guarantorbank_gm_text.setText((String) null);
		guarantorbank_gm_text.setColumns(10);

		bankaddress_gm_text = new JTextField();
		bankaddress_gm_text.setBounds(140, 58, 391, 20);
		panel_1.add(bankaddress_gm_text);
		bankaddress_gm_text.setText((String) null);
		bankaddress_gm_text.setColumns(10);

		chequedetails_gm_text = new JTextField();
		chequedetails_gm_text.setBounds(140, 88, 391, 20);
		panel_1.add(chequedetails_gm_text);
		chequedetails_gm_text.setColumns(10);

		remarks_gm_text = new JTextField();
		remarks_gm_text.setBounds(140, 118, 391, 41);
		panel_1.add(remarks_gm_text);
		remarks_gm_text.setColumns(10);

		JLabel label_9 = new JLabel("Email");
		label_9.setBounds(30, 266, 46, 14);
		panel.add(label_9);

		JLabel label_13 = new JLabel("Pin");
		label_13.setBounds(339, 179, 46, 14);
		panel.add(label_13);

		JLabel label_14 = new JLabel("Alternate Phone");
		label_14.setHorizontalAlignment(SwingConstants.CENTER);
		label_14.setBounds(310, 206, 111, 14);
		panel.add(label_14);

		JLabel label_15 = new JLabel("Mobile");
		label_15.setBounds(339, 236, 46, 14);
		panel.add(label_15);

		JLabel label_19 = new JLabel("Photo");
		label_19.setHorizontalAlignment(SwingConstants.CENTER);
		label_19.setBounds(572, 179, 143, 14);
		panel.add(label_19);

		guarantorid_gm_text = new JTextField();
		guarantorid_gm_text.setToolTipText("You cannot enter");
		guarantorid_gm_text.setText((String) null);
		guarantorid_gm_text.setEditable(false);
		guarantorid_gm_text.setColumns(10);
		guarantorid_gm_text.setBounds(160, 23, 391, 20);
		panel.add(guarantorid_gm_text);

		nameofperson_gm_text = new JTextField();
		nameofperson_gm_text.setToolTipText("Enter Full Name");
		nameofperson_gm_text.setColumns(10);
		nameofperson_gm_text.setBounds(160, 53, 391, 20);
		panel.add(nameofperson_gm_text);

		fathersname_gm_text = new JTextField();
		fathersname_gm_text.setText((String) null);
		fathersname_gm_text.setColumns(10);
		fathersname_gm_text.setBounds(160, 83, 391, 20);
		panel.add(fathersname_gm_text);

		address_gm_text = new JTextArea();
		address_gm_text.setText((String) null);
		address_gm_text.setLineWrap(true);
		address_gm_text.setDebugGraphicsOptions(DebugGraphics.NONE_OPTION);
		address_gm_text.setColumns(10);
		address_gm_text.setBorder(UIManager.getBorder("TextField.border"));
		address_gm_text.setBounds(160, 113, 391, 49);
		panel.add(address_gm_text);

		pin_gm_text = new JTextField();
		pin_gm_text.setText((String) null);
		pin_gm_text.setColumns(10);
		pin_gm_text.setBounds(431, 173, 120, 20);
		panel.add(pin_gm_text);

		phone1_gm_text = new JTextField();
		phone1_gm_text.setText((String) null);
		phone1_gm_text.setColumns(10);
		phone1_gm_text.setBounds(160, 203, 120, 20);
		panel.add(phone1_gm_text);

		mobile1_gm_text = new JTextField();
		mobile1_gm_text.setText((String) null);
		mobile1_gm_text.setColumns(10);
		mobile1_gm_text.setBounds(160, 233, 120, 20);
		panel.add(mobile1_gm_text);

		email_gm_text = new JTextField();
		email_gm_text.setText((String) null);
		email_gm_text.setColumns(10);
		email_gm_text.setBounds(160, 266, 391, 20);
		panel.add(email_gm_text);

		city_gm_text = new JTextField();
		city_gm_text.setText((String) null);
		city_gm_text.setColumns(10);
		city_gm_text.setBounds(160, 173, 120, 20);
		panel.add(city_gm_text);

		mobile2_gm_text = new JTextField();
		mobile2_gm_text.setText((String) null);
		mobile2_gm_text.setColumns(10);
		mobile2_gm_text.setBounds(431, 233, 120, 20);
		panel.add(mobile2_gm_text);

		phone2_gm_text = new JTextField();
		phone2_gm_text.setText((String) null);
		phone2_gm_text.setColumns(10);
		phone2_gm_text.setBounds(431, 203, 120, 20);
		panel.add(phone2_gm_text);

		JButton btn_save = new JButton("Save");
		btn_save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {


				try {
					Connection conn;
					String dbuser = "root";
					String dbpassw = "mysql";
					String databasename = "fms";
					String url = "jdbc:mysql://localhost/" + databasename;
					Class.forName("com.mysql.jdbc.Driver");
					conn = DriverManager.getConnection (url, dbuser, dbpassw);
					Statement st = conn.createStatement();

					String nameofperson= nameofperson_gm_text.getText().toString();
					String fathersname= fathersname_gm_text.getText().toString();					
					String address= address_gm_text.getText().toString();
					String city= city_gm_text.getText().toString();
					String pin=pin_gm_text.getText().toString();
					String phone1= phone1_gm_text.getText().toString();
					String phone2= phone2_gm_text.getText().toString();
					String mobile1= mobile1_gm_text.getText().toString();
					String mobile2= mobile2_gm_text.getText().toString();
					String email=email_gm_text.getText().toString();             
					String guarantorbank=guarantorbank_gm_text.getText().toString();
					String bankaddress=bankaddress_gm_text.getText().toString();
					String chequedetails=chequedetails_gm_text.getText().toString();


					ResultSet res=st.executeQuery("Select * from guarantor_master");		
					if(res.next()){
						if(nameofperson=="")
						{
							JOptionPane.showInputDialog(nameofperson_gm_text);

						}
						st.executeUpdate("INSERT INTO `fms`.`guarantor_master` (`GuarantorName`, `GuarantorFatherName`, `GuarantorAddress`, `GuarantorCity`, `GuarantorPin`, `GuarantorPhone`, `GuarantorPhone2`, `GuarntorMobile`, `GuarantorMobile2`, `GuarantorEmail`, `GuarantorBank`, `GuarantorBankAddress`, `GuarantorChequeDetails`) VALUES ('"+nameofperson+"', '"+fathersname+"', '"+address+"', '"+city+"', '"+pin+"', '"+phone1+"', '"+phone2+"', '"+mobile1+"', '"+mobile2+"', '"+email+"', '"+guarantorbank+"', '"+bankaddress+"', '"+chequedetails+"');");
						JOptionPane.showMessageDialog(btn_save, "Data Successfully Added");
						clearScreen();
						Transactions.LoanApplicationTransaction la=new Transactions.LoanApplicationTransaction();
						la.setVisible(true);
						
						
						//dispose();
					}


					else{
						st.executeUpdate("INSERT INTO `fms`.`guarantor_master` (`GuarantorId`, `GuarantorName`, `GuarantorFatherName`, `GuarantorAddress`, `GuarantorCity`, `GuarantorPin`, `GuarantorPhone`, `GuarantorPhone2`, `GuarntorMobile`, `GuarantorMobile2`, `GuarantorEmail`, `GuarantorBank`, `GuarantorBankAddress`, `GuarantorChequeDetails`) VALUES ('1', '"+nameofperson+", '"+fathersname+"', '"+address+"', '"+city+"', '"+pin+"', '"+phone1+"', '"+phone2+"', '"+mobile1+"', '"+mobile2+"', '"+email+"', '"+guarantorbank+"', '"+bankaddress+"', '"+chequedetails+"');");
						JOptionPane.showMessageDialog(btn_save, "Data Successfully Added");
						Transactions.LoanApplicationTransaction la=new Transactions.LoanApplicationTransaction();
						la.setVisible(true);
						dispose();
					}



				}
				catch ( ClassNotFoundException e ) {
					JOptionPane.showMessageDialog(btn_save,e.getMessage());
				}
				catch(SQLException e) {

					JOptionPane.showMessageDialog(btn_save,"Please contact the Software Developer and notify that a SQL error occurred on login.");
					e.printStackTrace();
					dispose();
				}



			}
		});
		btn_save.setBounds(30, 502, 71, 23);
		panel.add(btn_save);

		btn_Left = new JButton("Left");
		btn_Left.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					if (res.previous())
					{		
						showRecord();
					}
					changeNavigationState();

				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		btn_Left.setBounds(121, 502, 66, 23);
		panel.add(btn_Left);

		btn_Right = new JButton("Right");
		btn_Right.setEnabled(false);
		btn_Right.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					if (res.next())
					{
						showRecord();
					}
					changeNavigationState();

				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		btn_Right.setBounds(300, 502, 66, 23);
		panel.add(btn_Right);

		JButton btn_Find = new JButton("Find");
		btn_Find.addActionListener(new ActionListener() {
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

					String name=nameofperson_gm_text.getText().toString();
					if(name.equals(""))
						name=null;

					String mobileno=mobile1_gm_text.getText().toString();
					if (mobileno.equals(""))
						mobileno="";
					res=st.executeQuery("SELECT * FROM guarantor_master where "
							+ "GuarantorName LIKE '%"+name+"%' OR GuarntorMobile='"+mobileno+"'"	);

					if (!res.next() ) {
						JOptionPane.showMessageDialog(btn_Find, "No records found");
					} else {
						SetSearchResults(res);
					}
				}
				catch ( ClassNotFoundException e1 ) {
					JOptionPane.showMessageDialog(btn_Find,e1.getMessage());
				}
				catch(SQLException e1) {
					JOptionPane.showMessageDialog(btn_Find,"Please contact the Software Developer"
							+ " and notify that a SQL error occurred on login.");
					e1.printStackTrace();
				}

			}
		});
		btn_Find.setBounds(207, 502, 66, 23);
		panel.add(btn_Find);

		JButton btn_Clear = new JButton("Clear");
		btn_Clear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				clearScreen();
			}
		});
		btn_Clear.setBounds(485, 502, 66, 23);
		panel.add(btn_Clear);

		JButton btn_delete = new JButton("Delete");
		btn_delete.addActionListener(new ActionListener() {
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


					ResultSet res1=st.executeQuery("Select * from customer_master");
					if(res1.next()){
						int i=JOptionPane.showConfirmDialog(btn_delete, "Are you sure you want to delete this data?");
						if(i == JOptionPane.YES_OPTION){
							String nameofperson= nameofperson_gm_text.getText().toString();
							int j=JOptionPane.showConfirmDialog(btn_delete, "Are you sure you want to delete guarantor "+nameofperson+"?");
							if(j==JOptionPane.YES_OPTION)
							{
								st.executeUpdate("DELETE FROM customer_master WHERE NameofPerson='"+nameofperson+"'");							
								JOptionPane.showMessageDialog(btn_delete, "Data Successfully Deleted");

							}
							clearScreen();
						}


						else{
							JOptionPane.showMessageDialog(btn_delete, "No Records to delete");
						}


					}
				}
				catch ( ClassNotFoundException e1 ) {
					JOptionPane.showMessageDialog(btn_delete,e1.getMessage());
				}
				catch(SQLException e1) {
					JOptionPane.showMessageDialog(btn_delete,"Please contact the Software Developer and notify that a SQL error occurred on login.");
				}
			}
		});
		btn_delete.setBounds(391, 502, 71, 23);
		panel.add(btn_delete);

		JLabel photo_set = new JLabel("");
		photo_set.setOpaque(true);
		photo_set.setBorder(UIManager.getBorder("TextField.border"));
		photo_set.setBackground(Color.WHITE);
		photo_set.setBounds(575, 23, 140, 140);
		panel.add(photo_set);
	}

	protected void clearScreen() {
		// TODO Auto-generated method stub
		guarantorid_gm_text.setText(null);
		nameofperson_gm_text.setText(null);
		fathersname_gm_text.setText(null);						
		address_gm_text.setText(null);								
		city_gm_text.setText(null);				
		phone1_gm_text.setText(null);
		mobile1_gm_text.setText(null);				
		email_gm_text.setText(null);
		guarantorbank_gm_text.setText(null);
		bankaddress_gm_text.setText(null);
		chequedetails_gm_text.setText(null);							
		phone2_gm_text.setText(null);						
		mobile2_gm_text.setText(null);			
		pin_gm_text.setText(null);

	}

}
