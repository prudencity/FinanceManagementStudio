package Transactions;

import java.awt.BorderLayout;
import java.awt.Event;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;

import javax.swing.JFormattedTextField;

import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.DefaultListModel;
import javax.swing.JCheckBox;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.KeyStroke;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.SwingConstants;
import javax.swing.JButton;













import Master.BankMaster;
import Master.CustomerMaster;
import Master.GuarantorMaster;
import ca.odell.glazedlists.GlazedLists;
import ca.odell.glazedlists.swing.AutoCompleteSupport;

import com.mysql.jdbc.StringUtils;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.event.CaretListener;
import javax.swing.event.CaretEvent;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import java.awt.Color;

import javax.swing.JScrollPane;
import javax.swing.JScrollBar;

import java.awt.Dimension;

import javax.swing.JList;

import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JDayChooser;
import com.toedter.calendar.JCalendar;

import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class LoanApplicationTransaction extends JFrame {

	private JPanel contentPane;
	private JTextField customerid_la_text=null;
	private JTextField formno_text;
	private JTextField loanamount_la_text;
	private JTextField textField_26;
	public static Statement st;
	public String date, applicationdate, sanctiondate, chequedate;
	public String customerid;
	public ResultSet cid;
	public static JComboBox customer_la_combo;


	public void setChequeList() 
	{

	}
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoanApplicationTransaction frame = new LoanApplicationTransaction();
					frame.setVisible(true);
					frame.setSize(600,400);
					frame.setLocation(200,0);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public final void clearCustomerDetails() {

	}

	/**
	 * Create the frame.
	 */
	@SuppressWarnings("rawtypes")
	public LoanApplicationTransaction() {
		setTitle("Loan Application");
		setTitle("Loan Application");
		//setSize(1113,690);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 604, 358);
		contentPane = new JPanel();
		contentPane.setLocation(-16, -379);
		contentPane.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent arg0) {
			}
		});
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JComboBox<String> agent_la_combo = new JComboBox();
		agent_la_combo.addItem(null);
		try {
			databaseConnectivity();
			ResultSet res=st.executeQuery("SELECT * FROM agent_master ");
			while(res.next())
			{
				agent_la_combo.addItem(res.getString("AgentName"));
			}
		} catch (ClassNotFoundException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		agent_la_combo.setFocusable(false);
		agent_la_combo.setBounds(113, 17, 305, 20);

		contentPane.add(agent_la_combo);

		JLabel lblAgent = new JLabel("Agent");
		lblAgent.setBounds(22, 20, 46, 14);

		contentPane.add(lblAgent);

		JLabel lblOffice = new JLabel("Office");
		lblOffice.addComponentListener(new ComponentAdapter() {


		});
		lblOffice.setBounds(22, 50, 46, 14);
		contentPane.add(lblOffice);

		JComboBox<String> office_la_combo = new JComboBox();
		office_la_combo.addItem(null);
		try {
			databaseConnectivity();
			ResultSet res2=st.executeQuery("SELECT * FROM office_master ");
			while(res2.next())
			{
				office_la_combo.addItem(res2.getString("OfficeName"));
			}
		} catch (ClassNotFoundException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		office_la_combo.setFocusable(false);
		office_la_combo.setBounds(113, 48, 305, 20);
		contentPane.add(office_la_combo);

		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Customer Details", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_4.setBounds(16, 109, 415, 172);
		contentPane.add(panel_4);
		panel_4.setLayout(null);

		JLabel lblCustomerId = new JLabel("CustomerId");
		lblCustomerId.setBounds(10, 23, 77, 14);
		panel_4.add(lblCustomerId);

		customerid_la_text = new JTextField();
		customerid_la_text.setBounds(132, 21, 180, 20);
		panel_4.add(customerid_la_text);



		customerid_la_text.setColumns(10);

		JLabel lblName = new JLabel("Customer Name *");
		lblName.setBounds(10, 53, 103, 14);
		panel_4.add(lblName);

		JButton btn_CustomerDetails = new JButton("Details");
		btn_CustomerDetails.setBounds(322, 51, 84, 20);
		panel_4.add(btn_CustomerDetails);

		JLabel customervalidate = new JLabel("!");
		customervalidate.setVisible(false);
		customervalidate.setForeground(Color.RED);
		customervalidate.setFont(new Font("Tahoma", Font.PLAIN, 16));
		customervalidate.setBounds(117, 55, 13, 14);
		panel_4.add(customervalidate);

		JLabel lblNewLabel_1 = new JLabel("Guarantor Name");
		lblNewLabel_1.setBounds(10, 83, 104, 14);
		panel_4.add(lblNewLabel_1);

		JLabel lblLoanAmount = new JLabel("Loan Amount");
		lblLoanAmount.setBounds(10, 113, 91, 14);
		panel_4.add(lblLoanAmount);

		loanamount_la_text = new JTextField();
		loanamount_la_text.setBounds(132, 111, 112, 20);
		panel_4.add(loanamount_la_text);
		loanamount_la_text.setColumns(10);

		JLabel lblApplicationDate = new JLabel("Application Date");
		lblApplicationDate.setBounds(10, 143, 102, 14);
		panel_4.add(lblApplicationDate);

		JDateChooser dateChooser_applicationdate = new JDateChooser();
		dateChooser_applicationdate.setBounds(132, 141, 113, 20);
		panel_4.add(dateChooser_applicationdate);
		dateChooser_applicationdate.setDateFormatString("YYYY-MM-d");

		// Customer Name Combobox. Adding list of names from the database. 


		customer_la_combo = new JComboBox();
		customer_la_combo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String customerid = null;
				String nameofcustomer;
				try {
					databaseConnectivity();
					nameofcustomer=(String) customer_la_combo.getSelectedItem();
					if(nameofcustomer!=null)
					{
						ResultSet res=st.executeQuery("SELECT * FROM customer_master WHERE NameOfPerson='"+nameofcustomer+"'");
						if(res.next())
						{
							customerid=res.getString("CustomerId");
						}
						if(customer_la_combo.getSelectedItem().equals(nameofcustomer))
						{
							customervalidate.setVisible(false);
							customerid_la_text.setText(customerid);
						}

					} 
				}
				catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
				catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});

		int i=1;
		String[] elements = new String[1000] ;
		elements[0]="";
		try {
			databaseConnectivity();
			ResultSet cname=st.executeQuery("SELECT * FROM customer_master");
			while(cname.next())
			{	
				elements[i]=cname.getString("NameOfPerson");
				i=i+1;
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		customer_la_combo.setSelectedItem("");
		//Autofill implemented for the customer name combobox.

		AutoCompleteSupport.install(customer_la_combo, GlazedLists.eventListOf(elements));


		customer_la_combo.setBounds(132, 52, 180, 20);
		panel_4.add(customer_la_combo);



		// Guarantor Name Combobox. Adding list of names from the database.


		JComboBox guarantor_la_combo = new JComboBox();
		int i1=0;
		String[] elements1 = new String[1000] ;
		try {
			databaseConnectivity();
			ResultSet cname=st.executeQuery("SELECT * FROM guarantor_master");
			while(cname.next())
			{	
				elements1[i1]=cname.getString("GuarantorName");
				i1=i1+1;
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		//Autofill implemented for the customer name combobox.

		AutoCompleteSupport.install(guarantor_la_combo, GlazedLists.eventListOf(elements1));

		guarantor_la_combo.setBounds(132, 80, 180, 20);
		panel_4.add(guarantor_la_combo);

		JButton btn_GuarantorDetails = new JButton("Details");
		btn_GuarantorDetails.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					GuarantorMaster gm = new GuarantorMaster();
					databaseConnectivity();
					String nameofguarantor=(String) guarantor_la_combo.getSelectedItem();
					ResultSet res=st.executeQuery("SELECT * FROM guarantor_master WHERE GuarantorName='"+nameofguarantor+"'");
					if(res.next())
					{

						GuarantorMaster.guarantorid_gm_text.setText(res.getString("GuarantorId"));
						GuarantorMaster.nameofperson_gm_text.setText(res.getString("GuarantorName"));
						GuarantorMaster.fathersname_gm_text.setText(res.getString("GuarantorFatherName"));
						GuarantorMaster.address_gm_text.setText(res.getString("GuarantorAddress"));
						GuarantorMaster.city_gm_text.setText(res.getString("GuarantorCity"));
						GuarantorMaster.email_gm_text.setText(res.getString("GuarantorEmail"));
						GuarantorMaster.mobile1_gm_text.setText(res.getString("GuarantorMobile"));
						GuarantorMaster.mobile2_gm_text.setText(res.getString("GuarantorMobile2"));
						GuarantorMaster.phone1_gm_text.setText(res.getString("GuarantorPhone"));
						GuarantorMaster.phone2_gm_text.setText(res.getString("GuarantorPhone2"));
						GuarantorMaster.pin_gm_text.setText(res.getString("GuarantorPin"));
						GuarantorMaster.guarantorbank_gm_text.setText(res.getString("GuarantorBank"));
						GuarantorMaster.bankaddress_gm_text.setText("GuarantorbankAddress");
						GuarantorMaster.chequedetails_gm_text.setText("GuarantorChequeDetails");
						gm.setSize(750,550);
						gm.setVisible(true);
					}
				} 
				catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} 
				catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}


			}
		});
		btn_GuarantorDetails.setBounds(322, 82, 84, 20);
		panel_4.add(btn_GuarantorDetails);

		btn_CustomerDetails.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					CustomerMaster cm = new CustomerMaster();
					databaseConnectivity();
					String nameofcustomer=(String) customer_la_combo.getSelectedItem();
					ResultSet res=st.executeQuery("SELECT * FROM customer_master WHERE NameOfPerson='"+nameofcustomer+"'");
					if(res.next())
					{

						CustomerMaster.customerid_text.setText(res.getString("CustomerId"));
						CustomerMaster.nameofperson_text.setText(res.getString("NameOfPerson"));
						CustomerMaster.fathersname_text.setText(res.getString("FathersName"));
						CustomerMaster.address_text.setText(res.getString("Address"));
						CustomerMaster.birthdate_text.setText(res.getString("BirthDate"));
						CustomerMaster.anniversary_text.setText(res.getString("Anniversary"));
						CustomerMaster.city_text.setText(res.getString("City"));
						CustomerMaster.email_text.setText(res.getString("Email"));
						CustomerMaster.mobile1_text.setText(res.getString("Mobile1"));
						CustomerMaster.mobile2_text.setText(res.getString("Mobile2"));
						CustomerMaster.interestrate_text.setText(res.getString("InterestRate"));
						CustomerMaster.penalty_text.setText(res.getString("Penalty"));
						CustomerMaster.phone1_text.setText(res.getString("Phone1"));
						CustomerMaster.phone2_text.setText(res.getString("Phone2"));
						CustomerMaster.pin_text.setText(res.getString("Pin"));
						CustomerMaster.referredby_text.setText(res.getString("ReferredBy"));
						CustomerMaster.mobileref_text.setText(res.getString("MobileRef"));
						cm.setSize(750,550);
						cm.setVisible(true);
					}
				} 
				catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} 
				catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}




			}
		});
		lblCustomerId.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent e) {
			}
		});

		JLabel lblLoanId = new JLabel("Loan Id");
		lblLoanId.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent arg0) {
			}
		});
		lblLoanId.setBounds(22, 80, 77, 14);
		contentPane.add(lblLoanId);

		formno_text = new JTextField();
		formno_text.setEnabled(false);
		formno_text.setColumns(10);
		formno_text.setBounds(113, 78, 86, 20);
		contentPane.add(formno_text);
		DefaultListModel listModel = new DefaultListModel();
		listModel.addElement("Cheque No."+"               "+"Cheque Date");



		JButton btn_la_delete = new JButton("Delete");
		btn_la_delete.setEnabled(false);
		btn_la_delete.setBounds(231, 292, 99, 23);
		contentPane.add(btn_la_delete);

		JButton btn_la_find = new JButton("Find");
		btn_la_find.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(customer_la_combo.getSelectedItem()==null)
					customervalidate.setVisible(true);
				else
				{
					System.out.println(customerid_la_text.getText());
					String customer=customer_la_combo.getSelectedItem().toString();

					try {
						databaseConnectivity();

						ResultSet rs=st.executeQuery("SELECT NameOfPerson, AgentName, OfficeName, GuarantorName, LoanAmount, ApplicationDate FROM loanapplication_transaction l, customer_master c, guarantor_master g, office_master o, agent_master a  where l.CustomerId=c.CustomerId AND l.AgentId=a.AgentId AND l.OfficeId=o.OfficeId AND l.GuarantorId=g.GuarantorId");
						if(rs.next())
						{
							customer_la_combo.setSelectedItem(rs.getString("NameOfPerson"));
							guarantor_la_combo.setSelectedItem(rs.getString("GuarantorName"));
							agent_la_combo.setSelectedItem(rs.getString("AgentName"));
							office_la_combo.setSelectedItem(rs.getString("OfficeName"));
							loanamount_la_text.setText(rs.getString("LoanAmount"));
							java.util.Date date = new SimpleDateFormat("yyyy-MM-dd").parse(rs.getString("ApplicationDate"));
							dateChooser_applicationdate.setDate(date);
						}
						//st.executeU
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (ParseException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

				}
			}
		});

		btn_la_find.setBounds(125, 292, 96, 23);
		contentPane.add(btn_la_find);


		JButton btn_la_save = new JButton("Save");
		btn_la_save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Object agent= agent_la_combo.getSelectedItem();

				Object office=office_la_combo.getSelectedItem();
				String applicationdate= ((JTextField)dateChooser_applicationdate.getDateEditor().getUiComponent()).getText();
				String loanamount=loanamount_la_text.getText().toString();
				//System.out.println(date);

				try {
					databaseConnectivity();
					String agentid = null;
					String officeid=null;
					String guarantorid=null;
					String customerid=null;
					String guarantor=guarantor_la_combo.getSelectedItem().toString();
					String customer=customer_la_combo.getSelectedItem().toString();
					ResultSet aid=st.executeQuery("SELECT * FROM agent_master where AgentName='"+agent+"'");
					if(aid.next())
						agentid = aid.getString("AgentId");

					ResultSet oid=st.executeQuery("Select * From office_master where OfficeName='"+office+"'");
					if(oid.next())
						officeid = oid.getString("OfficeId");

					ResultSet gid=st.executeQuery("Select * From guarantor_master where GuarantorName='"+guarantor+"'");
					if(gid.next())
						guarantorid = gid.getString("GuarantorId");

					cid=st.executeQuery("Select * From customer_master where NameOfPerson='"+customer+"'");
					if(cid.next())
						customerid = cid.getString("CustomerId");

					int res=st.executeUpdate("INSERT INTO `fms`.`loanapplication_transaction` (`AgentId`, `OfficeId`, `CustomerId`, `GuarantorId`, `ApplicationDate`, `LoanAmount`) "
							+ "VALUES ('"+agentid+"', '"+officeid+"', '"+customerid+"', '"+guarantorid+"', '"+applicationdate+"', '"+loanamount+"');");

					JOptionPane.showMessageDialog(btn_la_save, "Data Successfully Saved");
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}			
		});
		btn_la_save.setBounds(16, 292, 99, 23);
		contentPane.add(btn_la_save);


		JButton button = new JButton("Clear");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				agent_la_combo.setSelectedItem(null);
				office_la_combo.setSelectedItem(null);

				guarantor_la_combo.setSelectedItem(null);
				customerid_la_text.setText("");
				loanamount_la_text.setText("");
				dateChooser_applicationdate.setDate(null);
				customer_la_combo.setSelectedItem(null);
			}
		});
		button.setBounds(340, 292, 99, 23);
		contentPane.add(button);

		JButton btnLoanChart = new JButton("Loan Chart");
		btnLoanChart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnLoanChart.setBounds(666, 597, 97, 23);
		contentPane.add(btnLoanChart);

		textField_26 = new JTextField();
		textField_26.setBounds(465, 11, 111, 87);
		contentPane.add(textField_26);
		textField_26.setColumns(10);

		JLabel lblNewLabel_5 = new JLabel("Customer Photo");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setBounds(465, 109, 111, 14);
		contentPane.add(lblNewLabel_5);

		JLabel label_4 = new JLabel("!");
		label_4.setForeground(Color.RED);
		label_4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_4.setBounds(90, 20, 13, 14);
		contentPane.add(label_4);

		JLabel label_5 = new JLabel("!");
		label_5.setForeground(Color.RED);
		label_5.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_5.setBounds(90, 50, 13, 14);
		contentPane.add(label_5);

		JButton btnLoanSanction = new JButton(" Loan Sanction");
		btnLoanSanction.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				LoanSanction ls=new LoanSanction();
				ls.setVisible(true);
				ls.setSize(900,550);
			
					ls.customername_combo.setSelectedItem(customer_la_combo.getSelectedItem().toString());
				
				dispose();
			}
		});
		btnLoanSanction.setBounds(458, 292, 118, 23);
		contentPane.add(btnLoanSanction);



	}


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
