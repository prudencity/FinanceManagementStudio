package Master;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.rowset.spi.TransactionalWriter;
import javax.swing.DebugGraphics;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import org.eclipse.wb.swing.FocusTraversalOnArray;

import ca.odell.glazedlists.GlazedLists;
import ca.odell.glazedlists.swing.AutoCompleteSupport;

import com.mysql.jdbc.StringUtils;

import java.awt.Font;

import javax.swing.JComboBox;


public class CustomerMaster extends JFrame {

	public static CustomerMaster frame;
	public String nameofperson;
	private static ResultSet res;
	public JPanel contentPane;
	public String aj=null;
	public static JButton btnLeft;
	public static JButton btnRight;
	public JButton btnDelete;
	public JTextField firmname_text=null;
	public static JTextField customerid_text;
	static public JTextField nameofperson_text;
	public static JTextField fathersname_text=null;
	public static JTextArea address_text=null;
	public static JTextField city_text=null;
	public static JTextField phone1_text=null;
	public static JTextField mobile1_text=null;
	public static JTextField birthdate_text=null;
	public static JTextField email_text=null;
	public static JTextField referredby_text=null;
	public static JTextField mobileref_text=null;
	public static JTextField interestrate_text=null, phoneref_text=null, penalty_text=null, pin_text=null, mobile2_text=null, phone2_text=null, anniversary_text=null, photo_text=null;
	static JTextField textField_15=null;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new CustomerMaster();
					frame.setSize(750,550);
					frame.setAlwaysOnTop(true);
					frame.setLocation(200, 0);
					frame.setVisible(true);
										
					//AutoSuggestor autoSuggestor = new AutoSuggestor(frame.nameofperson_text, frame, null, Color.WHITE.brighter(), Color.BLUE, Color.RED, 0.75f);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public static void SetSearchResults(ResultSet rs) throws SQLException {
		res = rs;
		showRecord();

	}


	public static void showRecord() throws SQLException {

		//cm.firmname_text.setText(cid);
		customerid_text.setText(res.getString("CustomerId"));
		nameofperson_text.setText(res.getString("NameOfPerson"));
		fathersname_text.setText(res.getString("FathersName"));
		address_text.setText(res.getString("Address"));
		birthdate_text.setText(res.getString("BirthDate"));
		anniversary_text.setText(res.getString("Anniversary"));
		city_text.setText(res.getString("City"));
		email_text.setText(res.getString("Email"));
		mobile1_text.setText(res.getString("Mobile1"));
		mobile2_text.setText(res.getString("Mobile2"));
		interestrate_text.setText(res.getString("InterestRate"));
		penalty_text.setText(res.getString("Penalty"));
		phone1_text.setText(res.getString("Phone1"));
		phone2_text.setText(res.getString("Phone2"));
		pin_text.setText(res.getString("Pin"));
		referredby_text.setText(res.getString("ReferredBy"));
		mobileref_text.setText(res.getString("MobileRef"));


	}
	
	public static void findCustomerDetails(JButton btnFind) {
		try {
			Connection conn;
			String dbuser = "root";
			String dbpassw = "mysql";
			String databasename = "fms";
			String url = "jdbc:mysql://localhost/" + databasename;
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection (url, dbuser, dbpassw);
			Statement st = conn.createStatement();

			String name=nameofperson_text.getText().toString();
			if(name.equals(""))
				name=null;
		
			String mobileno=mobile1_text.getText().toString();
			if (mobileno.equals(""))
				mobileno="jbjhbhjb";
			ResultSet res=st.executeQuery("SELECT * FROM customer_master where "
					+ "NameOfPerson LIKE '%"+name+"%' OR Mobile1='"+mobileno+"'"	);

			if (!res.next() ) {
				JOptionPane.showMessageDialog(btnFind, "No records found");
			} else {
				SetSearchResults(res);
			}
		}
		catch ( ClassNotFoundException e ) {
			JOptionPane.showMessageDialog(btnFind,e.getMessage());
		}
		catch(SQLException e) {
			JOptionPane.showMessageDialog(btnFind,"Please contact the Software Developer"
					+ " and notify that a SQL error occurred on login.");
			e.printStackTrace();
		}
	}	

	public static void changeNavigationState() throws SQLException {
		if(res.isFirst())
		{
			btnLeft.setEnabled(false);
		}
		else {
			btnLeft.setEnabled(true);
		}

		if(res.isLast())
		{
			btnRight.setEnabled(false);
		}
		else {
			btnRight.setEnabled(true);
		}
	}

	public static void clearScreen() {
		customerid_text.setText(null);
		nameofperson_text.setText(null);
		fathersname_text.setText(null);						
		address_text.setText(null);								
		city_text.setText(null);				
		phone1_text.setText(null);
		mobile1_text.setText(null);				
		birthdate_text.setText(null);
		anniversary_text.setText(null);
		email_text.setText(null);
		referredby_text.setText(null);
		mobileref_text.setText(null);
		interestrate_text.setText(null);							
		phoneref_text.setText(null);						
		penalty_text.setText(null);			
		pin_text.setText(null);
	}

	/**
	 * Create the frame.
	 */
	public CustomerMaster() {
		setResizable(false);
		setAlwaysOnTop(true);
		setTitle("Customer Master");

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 866, 565);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblCustomerId = new JLabel("CustomerId");
		lblCustomerId.setBounds(30, 26, 92, 14);
		contentPane.add(lblCustomerId);

		JLabel lblNameOfPerson = new JLabel("Name of Person *");
		lblNameOfPerson.setBounds(30, 56, 102, 14);
		contentPane.add(lblNameOfPerson);

		JLabel lblFathersName = new JLabel("Father's Name");
		lblFathersName.setBounds(30, 86, 102, 14);
		contentPane.add(lblFathersName);

		JLabel lblAddress = new JLabel("Address");
		lblAddress.setBounds(30, 116, 80, 14);
		contentPane.add(lblAddress);

		JLabel lblCity = new JLabel("City");
		lblCity.setBounds(30, 176, 46, 14);
		contentPane.add(lblCity);

		JLabel lblPhone = new JLabel("Phone");
		lblPhone.setBounds(30, 206, 46, 14);
		contentPane.add(lblPhone);

		JLabel lblMobile = new JLabel("Mobile");
		lblMobile.setBounds(30, 236, 46, 14);
		contentPane.add(lblMobile);

		JLabel lblRemarks = new JLabel("Remarks");
		lblRemarks.setBounds(30, 416, 80, 14);
		contentPane.add(lblRemarks);

		JLabel lblBirthDate = new JLabel("Birth Date ");
		lblBirthDate.setToolTipText("YYYY/MM/DD");
		lblBirthDate.setBounds(30, 266, 102, 14);
		contentPane.add(lblBirthDate);

		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(30, 296, 46, 14);
		contentPane.add(lblEmail);

		JLabel lblReferredBy = new JLabel("Referred By");
		lblReferredBy.setBounds(30, 326, 120, 14);
		contentPane.add(lblReferredBy);

		JLabel lblMobile_1 = new JLabel("Mobile");
		lblMobile_1.setBounds(30, 356, 46, 14);
		contentPane.add(lblMobile_1);

		JLabel lblInterestRate = new JLabel("Interest Rate");
		lblInterestRate.setBounds(30, 386, 92, 14);
		contentPane.add(lblInterestRate);


		JLabel lblPin = new JLabel("Pin");
		lblPin.setBounds(310, 176, 46, 14);
		contentPane.add(lblPin);

		JLabel lblPhone_1 = new JLabel("Alternate Phone");
		lblPhone_1.setBounds(310, 206, 111, 14);
		contentPane.add(lblPhone_1);

		JLabel lblMobile_2 = new JLabel("Mobile");
		lblMobile_2.setBounds(310, 236, 46, 14);
		contentPane.add(lblMobile_2);

		JLabel lblAnniversary = new JLabel("Anniversary");
		lblAnniversary.setBounds(310, 266, 102, 14);
		contentPane.add(lblAnniversary);

		JLabel lblPhone_2 = new JLabel("Phone");
		lblPhone_2.setBounds(310, 356, 46, 14);
		contentPane.add(lblPhone_2);

		JLabel lblPenalty = new JLabel("Penalty");
		lblPenalty.setBounds(310, 386, 46, 14);
		contentPane.add(lblPenalty);

		JLabel lblPhoto = new JLabel("Photo");
		lblPhoto.setHorizontalAlignment(SwingConstants.CENTER);
		lblPhoto.setBounds(572, 179, 143, 14);
		contentPane.add(lblPhoto);


		customerid_text = new JTextField();
		customerid_text.setToolTipText("You cannot enter");
		customerid_text.setEditable(false);
		customerid_text.setText(null);
		customerid_text.setBounds(160, 23, 391, 20);
		contentPane.add(customerid_text);
		customerid_text.setColumns(10);


		nameofperson_text = new JTextField();
		nameofperson_text.setToolTipText("Enter Full Name");
		nameofperson_text.setBounds(160, 53, 391, 20);
		contentPane.add(nameofperson_text);
		nameofperson_text.setColumns(10);

		fathersname_text = new JTextField();
		fathersname_text.setText(null);
		fathersname_text.setBounds(160, 83, 391, 20);
		contentPane.add(fathersname_text);
		fathersname_text.setColumns(10);

		address_text = new JTextArea();
		address_text.setBorder(UIManager.getBorder("TextField.border"));
		address_text.setLineWrap(true);
		address_text.setDebugGraphicsOptions(DebugGraphics.NONE_OPTION);
		address_text.setText(null);

		address_text.setBounds(160, 113, 391, 49);
		contentPane.add(address_text);
		address_text.setColumns(10);

		city_text = new JTextField();
		city_text.setText(null);
		city_text.setBounds(431, 173, 120, 20);
		contentPane.add(city_text);
		city_text.setColumns(10);

		phone1_text = new JTextField();
		phone1_text.setText(null);
		phone1_text.setBounds(160, 203, 120, 20);
		contentPane.add(phone1_text);
		phone1_text.setColumns(10);

		mobile1_text = new JTextField();
		mobile1_text.setText(null);
		mobile1_text.setBounds(160, 233, 120, 20);
		contentPane.add(mobile1_text);
		mobile1_text.setColumns(10);

		birthdate_text = new JTextField();
		//birthdate_text.setCaretPosition(1);
		birthdate_text.setText(null);
		birthdate_text.setBounds(160, 263, 120, 20);
		contentPane.add(birthdate_text);
		birthdate_text.setColumns(10);

		email_text = new JTextField();
		email_text.setText(null);
		email_text.setBounds(160, 293, 391, 20);
		contentPane.add(email_text);
		email_text.setColumns(10);

		referredby_text = new JTextField();
		referredby_text.setText(null);
		referredby_text.setBounds(160, 323, 391, 20);
		contentPane.add(referredby_text);
		referredby_text.setColumns(10);

		mobileref_text = new JTextField();
		mobileref_text.setText(null);
		mobileref_text.setBounds(160, 353, 120, 20);
		contentPane.add(mobileref_text);
		mobileref_text.setColumns(10);

		interestrate_text = new JTextField();
		interestrate_text.setBounds(160, 383, 120, 20);
		contentPane.add(interestrate_text);
		interestrate_text.setColumns(10);

		textField_15 = new JTextField();
		textField_15.setBounds(160, 413, 391, 41);
		contentPane.add(textField_15);
		textField_15.setColumns(10);


		phoneref_text = new JTextField();
		phoneref_text.setText(null);
		phoneref_text.setBounds(431, 353, 120, 20);
		contentPane.add(phoneref_text);
		phoneref_text.setColumns(10);

		penalty_text = new JTextField();
		penalty_text.setBounds(431, 383, 120, 20);
		contentPane.add(penalty_text);
		penalty_text.setColumns(10);

		pin_text = new JTextField();
		pin_text.setText(null);
		pin_text.setBounds(160, 173, 120, 20);
		contentPane.add(pin_text);
		pin_text.setColumns(10);

		mobile2_text = new JTextField();
		mobile2_text.setText(null);
		mobile2_text.setBounds(431, 233, 120, 20);
		contentPane.add(mobile2_text);
		mobile2_text.setColumns(10);

		phone2_text = new JTextField();
		phone2_text.setText(null);
		phone2_text.setColumns(10);
		phone2_text.setBounds(431, 203, 120, 20);
		contentPane.add(phone2_text);

		anniversary_text = new JTextField();
		anniversary_text.setText(null);
		anniversary_text.setColumns(10);
		anniversary_text.setBounds(431, 263, 120, 20);
		contentPane.add(anniversary_text);
		
		JLabel lbl_validate = new JLabel("!");
		lbl_validate.setVisible(false);
		lbl_validate.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_validate.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbl_validate.setForeground(Color.RED);
		lbl_validate.setBounds(138, 56, 11, 14);
		contentPane.add(lbl_validate);

		// Save Button. Connection to the Database
		JButton save_button = new JButton("Save");
		save_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				//String code_cm=customerid_text.getText().toString();
				String nameofperson= nameofperson_text.getText().toString();String fathersname= fathersname_text.getText().toString();					
				String address= address_text.getText().toString();
				String city= city_text.getText().toString();
				String phone1= phone1_text.getText().toString();
				String phone2= phone2_text.getText().toString();
				String mobile1= mobile1_text.getText().toString();
				if(mobile1=="")
					mobile1_text.setText(null);
				String mobile2= mobile2_text.getText().toString();
				String birthdate = birthdate_text.getText().toString();
				String anniversary= anniversary_text.getText().toString();
				String email=email_text.getText().toString();             
				String referredby=referredby_text.getText().toString();
				String mobileref=mobileref_text.getText().toString();
				String phoneref=phoneref_text.getText().toString();
				String penalty=penalty_text.getText().toString();
				String pin=pin_text.getText().toString();
				String interest=interestrate_text.getText().toString();

				if(nameofperson_text.getText().equals(""))
				{
					nameofperson_text.setBorder(new LineBorder(Color.RED));
					lbl_validate.setVisible(true);
										
				}
				else
				{
				try {
					Connection conn;
					String dbuser = "root";
					String dbpassw = "mysql";
					String databasename = "fms";
					String url = "jdbc:mysql://localhost/" + databasename;
					Class.forName("com.mysql.jdbc.Driver");
					conn = DriverManager.getConnection (url, dbuser, dbpassw);
					Statement st = conn.createStatement();
					ResultSet res=st.executeQuery("Select * from customer_master");		
					if(res.next()){
						st.executeUpdate("INSERT INTO customer_master (NameOfPerson, FathersName, Address, City, Pin, Phone1, Phone2, Mobile1, Mobile2, BirthDate, Anniversary, Email, ReferredBy, MobileRef, InterestRate, Penalty) VALUES ('"+nameofperson+"', '"+fathersname+"', '"+address+"', '"+city+"', '"+pin+"', '"+phone1+"', '"+phone2+"', '"+mobile1+"', '"+mobile2+"', "+ (StringUtils.isEmptyOrWhitespaceOnly(birthdate)? "NULL": ("'" + birthdate + "'")) +", "+ (StringUtils.isEmptyOrWhitespaceOnly(anniversary)? "NULL": ("'" + anniversary + "'")) +", '"+email+"', '"+referredby+"', '"+mobileref+"', '"+interest+"', '"+penalty+"')");
						JOptionPane.showMessageDialog(save_button, "Data Successfully Added");
						clearScreen();
						Transactions.LoanApplicationTransaction la=new Transactions.LoanApplicationTransaction();
						la.setVisible(true);
						la.customer_la_combo.setSelectedItem(nameofperson);
						
						frame.dispose();
					}


					else{

						if(nameofperson.isEmpty())
							JOptionPane.showMessageDialog(save_button, "Enter Customer name ");;
							System.out.println("INSERT INTO customer_master (CustomerId, NameOfPerson, FathersName, Address, City, Pin, Phone1, Phone2, Mobile1, Mobile2, BirthDate, Anniversary, Email, ReferredBy, MobileRef, InterestRate, Penalty) VALUES ('1', '"+nameofperson+"', '"+fathersname+"', '"+address+"', '"+city+"', '"+pin+"', '"+phone1+"', '"+phone2+"', '"+mobile1+"', '"+mobile2+"', "+ (StringUtils.isEmptyOrWhitespaceOnly(birthdate)? "NULL": ("'" + birthdate + "'")) +", "+ (StringUtils.isEmptyOrWhitespaceOnly(anniversary)? "NULL": ("'" + anniversary + "'")) +" ,'"+email+"', '"+referredby+"', '"+mobileref+"', '"+interest+"', '"+penalty+"')");
							st.executeUpdate("INSERT INTO customer_master (CustomerId, NameOfPerson, FathersName, Address, City, Pin, Phone1, Phone2, Mobile1, Mobile2, BirthDate, Anniversary, Email, ReferredBy, MobileRef, InterestRate, Penalty) VALUES ('1', '"+nameofperson+"', '"+fathersname+"', '"+address+"', '"+city+"', '"+pin+"', '"+phone1+"', '"+phone2+"', '"+mobile1+"', '"+mobile2+"', "+ (StringUtils.isEmptyOrWhitespaceOnly(birthdate)? "NULL": ("'" + birthdate + "'")) +", "+ (StringUtils.isEmptyOrWhitespaceOnly(anniversary)? "NULL": ("'" + anniversary + "'")) +" ,'"+email+"', '"+referredby+"', '"+mobileref+"', '"+interest+"', '"+penalty+"')");
							JOptionPane.showMessageDialog(save_button, "Data Successfully Added");
							Transactions.LoanApplicationTransaction la=new Transactions.LoanApplicationTransaction();
							la.setVisible(true);
							frame.dispose();
					}



				}
				catch ( ClassNotFoundException e ) {
					JOptionPane.showMessageDialog(save_button,e.getMessage());
				}
				catch(SQLException e) {

					JOptionPane.showMessageDialog(save_button,"Please contact the Software Developer and notify that a SQL error occurred on login.");
					e.printStackTrace();
					frame.dispose();
				}

				}
			}
		});
		save_button.setBounds(30, 476, 71, 23);
		contentPane.add(save_button);

		btnLeft = new JButton("Left");
		btnLeft.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					if (res.previous())
					{		
						showRecord();
					}
					changeNavigationState();

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnLeft.setBounds(121, 476, 66, 23);
		contentPane.add(btnLeft);

		btnRight = new JButton("Right");
		btnRight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					if (res.next())
					{
						showRecord();
					}
					changeNavigationState();

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnRight.setBounds(300, 476, 66, 23);
		contentPane.add(btnRight);

		//Find Button 

		JButton btnFind = new JButton("Find");
		btnFind.setBounds(207, 476, 66, 23);
		contentPane.add(btnFind);
		btnFind.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				findCustomerDetails(btnFind);
			}

			
		});


		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				clearScreen();


			}


		});
		btnClear.setBounds(485, 476, 66, 23);
		contentPane.add(btnClear);

		JButton btnDelete = new JButton("Delete");
		btnDelete.setEnabled(false);
		btnDelete.addActionListener(new ActionListener() {
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


					ResultSet res1=st.executeQuery("Select * from customer_master");
					if(res1.next()){
						int i=JOptionPane.showConfirmDialog(save_button, "Are you sure you want to delete this data?");
						if(i == JOptionPane.YES_OPTION){
							String nameofperson= nameofperson_text.getText().toString();
							int j=JOptionPane.showConfirmDialog(save_button, "Are you sure you want to delete customer "+nameofperson+"?");
							if(j==JOptionPane.YES_OPTION)
							{
								st.executeUpdate("DELETE FROM customer_master WHERE NameofPerson='"+nameofperson+"'");							
								JOptionPane.showMessageDialog(save_button, "Data Successfully Deleted");

							}
							clearScreen();
						}


						else{
							JOptionPane.showMessageDialog(save_button, "No Records to delete");
						}


					}
				}
				catch ( ClassNotFoundException e ) {
					JOptionPane.showMessageDialog(save_button,e.getMessage());
				}
				catch(SQLException e) {
					JOptionPane.showMessageDialog(save_button,"Please contact the Software Developer and notify that a SQL error occurred on login.");
				}


			}
		});
		btnDelete.setBounds(391, 476, 71, 23);
		contentPane.add(btnDelete);

		JLabel lblPhotoimage = new JLabel("");

		lblPhotoimage.setBorder(UIManager.getBorder("TextField.border"));
		lblPhotoimage.setOpaque(true);
		lblPhotoimage.setBackground(Color.WHITE);
		lblPhotoimage.setBounds(575, 23, 140, 140);
		contentPane.add(lblPhotoimage);
		
		
		
		
		contentPane.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{nameofperson_text, fathersname_text, address_text, city_text, phone1_text, mobile1_text, birthdate_text, email_text, referredby_text, mobileref_text, interestrate_text, textField_15, phoneref_text, penalty_text, pin_text, mobile2_text, phone2_text, anniversary_text, save_button, btnLeft, btnRight, btnFind, btnClear, btnDelete, lblCustomerId, lblNameOfPerson, lblFathersName, lblAddress, lblCity, lblPhone, lblMobile, lblRemarks, lblBirthDate, lblEmail, lblReferredBy, lblMobile_1, lblInterestRate, lblPin, lblPhone_1, lblMobile_2, lblAnniversary, lblPhone_2, lblPenalty, lblPhoto, customerid_text, lblPhotoimage}));
		setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{contentPane, lblNameOfPerson, lblCustomerId, lblFathersName, lblAddress, lblCity, lblPhone, lblMobile, lblRemarks, lblBirthDate, lblEmail, lblReferredBy, lblMobile_1, lblInterestRate, lblPin, lblPhone_1, lblMobile_2, lblAnniversary, lblPhone_2, lblPenalty, lblPhoto, customerid_text, nameofperson_text, fathersname_text, address_text, city_text, phone1_text, mobile1_text, birthdate_text, email_text, referredby_text, mobileref_text, interestrate_text, textField_15, phoneref_text, penalty_text, pin_text, mobile2_text, phone2_text, anniversary_text, save_button, btnLeft, btnRight, btnFind, btnClear, btnDelete, lblPhotoimage}));



	}
}


