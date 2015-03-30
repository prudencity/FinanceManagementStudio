package Transactions;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.ScrollPane;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.UIManager;

import java.awt.Color;

import javax.swing.DefaultListModel;
import javax.swing.DefaultListSelectionModel;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.KeyStroke;
import javax.swing.ListCellRenderer;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;

import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import Master.CustomerMaster;
import ca.odell.glazedlists.GlazedLists;
import ca.odell.glazedlists.swing.AutoCompleteSupport;

import com.toedter.calendar.JDateChooser;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JList;
import javax.swing.ListModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JTable;
import javax.swing.event.CaretListener;
import javax.swing.event.CaretEvent;
import javax.swing.JTextArea;

@SuppressWarnings("serial")
public class LoanSanction extends JFrame {

	private static Statement st;
	private JPanel contentPane;
	private JTextField sanctionchequeno_ls_text;
	private JTextField period_ls_text;
	private JTextField interestrate_ls_text;
	private JTextField penaltyrate_ls_text;
	private JTextField emi_ls_text;
	private JTextField sanctionamount_ls_text;
	private JTextField bank_text;
	private JTextField bankaddress_text;
	private JTextField bankchequeno_text;
	public static JButton btnDetails;
	private JTable table;
	private JTable table_1;
	DefaultTableModel dtm;
	private int index;
	private JTextField bankchequeamount_text;
	public static JComboBox customername_combo;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoanSanction frame = new LoanSanction();
					frame.setVisible(true);
					frame.setSize(900,550);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	@SuppressWarnings({ "unchecked", "rawtypes", "unused" })
	public LoanSanction() {
		setTitle("Loan Sanction");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 867, 707);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Loan Sanction", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(10, 48, 484, 179);
		contentPane.add(panel);

		JLabel label = new JLabel("Form of Payment");
		label.setBounds(10, 27, 99, 14);
		panel.add(label);

		JComboBox formofpayment_combo = new JComboBox();
		formofpayment_combo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				if(formofpayment_combo.getSelectedItem().equals("Cash"))
				{
					sanctionchequeno_ls_text.setEditable(false);
				}
				else if(formofpayment_combo.getSelectedItem().equals("Cheque"))
				{
					sanctionchequeno_ls_text.setEditable(true);
				}
			}
		});
		formofpayment_combo.addItem("");
		formofpayment_combo.addItem("Cash");
		formofpayment_combo.addItem("Cheque");
		formofpayment_combo.setBounds(126, 24, 113, 20);
		panel.add(formofpayment_combo);




		JLabel label_1 = new JLabel("EMI");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setBounds(10, 150, 75, 14);
		panel.add(label_1);

		sanctionchequeno_ls_text = new JTextField();
		sanctionchequeno_ls_text.setColumns(10);
		sanctionchequeno_ls_text.setBounds(358, 54, 112, 20);
		panel.add(sanctionchequeno_ls_text);

		JLabel label_3 = new JLabel("Loan Bank");
		label_3.setBounds(10, 57, 75, 14);
		panel.add(label_3);

		JLabel lblSanctionAmount = new JLabel("Sanction Amount");
		lblSanctionAmount.setBounds(10, 87, 99, 14);
		panel.add(lblSanctionAmount);

		JLabel label_5 = new JLabel("Periods");
		label_5.setBounds(263, 87, 91, 14);
		panel.add(label_5);

		period_ls_text = new JTextField();
		period_ls_text.setColumns(10);
		period_ls_text.setBounds(358, 84, 113, 20);
		panel.add(period_ls_text);

		JLabel label_6 = new JLabel("Interest Rate (%)");
		label_6.setBounds(10, 117, 104, 14);
		panel.add(label_6);

		JLabel label_7 = new JLabel("Penalty");
		label_7.setBounds(263, 112, 91, 14);
		panel.add(label_7);

		interestrate_ls_text = new JTextField();
		interestrate_ls_text.setColumns(10);
		interestrate_ls_text.setBounds(127, 117, 112, 20);
		panel.add(interestrate_ls_text);

		penaltyrate_ls_text = new JTextField();
		penaltyrate_ls_text.setColumns(10);
		penaltyrate_ls_text.setBounds(358, 115, 113, 20);
		panel.add(penaltyrate_ls_text);



		JComboBox loantype_combo = new JComboBox();
		loantype_combo.setBounds(358, 24, 112, 20);
		loantype_combo.addItem("Daily");
		loantype_combo.addItem("Monthly");
		loantype_combo.addItem("Yearly");
		loantype_combo.setSelectedItem("Monthly");
		panel.add(loantype_combo);

		JLabel label_8 = new JLabel("Loan Type");
		label_8.setBounds(263, 27, 89, 14);
		panel.add(label_8);

		emi_ls_text = new JTextField();
		emi_ls_text.setEditable(true);
		emi_ls_text.setColumns(10);
		emi_ls_text.setBounds(126, 147, 113, 20);
		panel.add(emi_ls_text);

		sanctionamount_ls_text = new JTextField();
		sanctionamount_ls_text.setColumns(10);
		sanctionamount_ls_text.setBounds(126, 84, 113, 20);
		panel.add(sanctionamount_ls_text);

		JLabel label_9 = new JLabel("Cheque No");
		label_9.setBounds(263, 57, 85, 14);
		panel.add(label_9);

		JComboBox loanbank_combo = new JComboBox();
		loanbank_combo.addItem("");
		try {
			databaseConnectivity();
			ResultSet rs=st.executeQuery("SELECT * FROM bank_master");
			while(rs.next())
			{
				loanbank_combo.addItem(rs.getString("BankName"));
			}
		} catch (ClassNotFoundException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}

		loanbank_combo.setBounds(127, 55, 112, 20);
		panel.add(loanbank_combo);

		JLabel label_11 = new JLabel("!");
		label_11.setForeground(Color.RED);
		label_11.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_11.setBounds(341, 57, 13, 14);
		panel.add(label_11);

		JButton btnGetEmi = new JButton("Get EMI");
		btnGetEmi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i=Integer.parseInt(sanctionamount_ls_text.getText());
				int j=Integer.parseInt(interestrate_ls_text.getText());
				int period=Integer.parseInt(period_ls_text.getText());
				int emi=(i+(i*j/100))/period;
				emi_ls_text.setText(Integer.toString(emi));
			}
		});
		btnGetEmi.setBounds(263, 146, 89, 23);
		panel.add(btnGetEmi);

		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Bank Details", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBounds(10, 250, 484, 193);
		contentPane.add(panel_1);

		JLabel label_12 = new JLabel("Bank");
		label_12.setBounds(10, 27, 46, 14);
		panel_1.add(label_12);

		JLabel label_13 = new JLabel("Address");
		label_13.setBounds(10, 57, 56, 14);
		panel_1.add(label_13);

		JLabel label_14 = new JLabel("Cheque No.");
		label_14.setBounds(10, 87, 91, 14);
		panel_1.add(label_14);

		bank_text = new JTextField();
		bank_text.setColumns(10);
		bank_text.setBounds(124, 24, 344, 20);
		panel_1.add(bank_text);

		bankaddress_text = new JTextField();
		bankaddress_text.setColumns(10);
		bankaddress_text.setBounds(124, 54, 344, 20);
		panel_1.add(bankaddress_text);

		bankchequeno_text = new JTextField();
		bankchequeno_text.setColumns(10);
		bankchequeno_text.setBounds(123, 84, 129, 20);
		panel_1.add(bankchequeno_text);

		bankchequeamount_text = new JTextField();
		bankchequeamount_text.setColumns(10);
		bankchequeamount_text.setBounds(123, 114, 129, 20);
		panel_1.add(bankchequeamount_text);

		JDateChooser ChequeDateChooser = new JDateChooser();
		ChequeDateChooser.setDateFormatString("YYYY-MM-d");
		ChequeDateChooser.setBounds(351, 85, 113, 20);
		panel_1.add(ChequeDateChooser);



		JLabel label_15 = new JLabel("Cheque Date");
		label_15.setBounds(262, 87, 91, 14);
		panel_1.add(label_15);

		//		JList list = new JList((ListModel) null);
		//		list.setBorder(UIManager.getBorder("TextField.border"));
		//		list.setBounds(539, 254, 201, 123);
		//		contentPane.add(list);

		JLabel lblCustomerName = new JLabel("Customer Name");
		lblCustomerName.setBounds(20, 14, 102, 14);
		contentPane.add(lblCustomerName);

		customername_combo = new JComboBox();
		int i=0;
		String[] elements = new String[1000] ;
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

		AutoCompleteSupport.install(customername_combo, GlazedLists.eventListOf(elements));
		//		comboBox.setBounds(595, 233, 130, 20);
		//		contentPane.add(comboBox);
		customername_combo.setBounds(132, 11, 130, 20);
		contentPane.add(customername_combo);

		btnDetails = new JButton("Details");
		btnDetails.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CustomerMaster cm=new CustomerMaster();
				try {
					//cm = new CustomerMaster();
					databaseConnectivity();
					String nameofcustomer=(String) customername_combo.getSelectedItem();
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

					}
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				cm.setSize(750,550);
				cm.setVisible(true);
				//Master.CustomerMaster.findCustomerDetails(btnDetails);
			}
		});
		btnDetails.setBounds(272, 10, 89, 23);
		contentPane.add(btnDetails);

		JDateChooser SanctiondateChooser = new JDateChooser();
		SanctiondateChooser.setBounds(497, 11, 113, 20);
		contentPane.add(SanctiondateChooser);
		SanctiondateChooser.setDateFormatString("YYYY-MM-d");

		JLabel label_2 = new JLabel("Sanction Date");
		label_2.setBounds(409, 14, 91, 14);
		contentPane.add(label_2);


		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Cheque Details", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_2.setBounds(514, 250, 327, 193);
		contentPane.add(panel_2);
		panel_2.setLayout(null);



		JTable chequedetails_table = new JTable();
		chequedetails_table.setBounds(10, 27, 307, 130);
		panel_2.add(chequedetails_table);
		chequedetails_table.setBorder(UIManager.getBorder("TextField.border"));

		dtm = new DefaultTableModel(0, 0);
		String header[] = new String[] { "ChequeNo", "ChequeDate", "Cheque Amount"};
		dtm.setColumnIdentifiers(header);
		dtm.addRow(new Object []{"ChequeNo", "ChequeDate", "Cheque Amount"});

		//set model into the table object
		chequedetails_table.setModel(dtm);
		
		JButton btn_details = new JButton("Details");
		btn_details.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String customername=(String) customername_combo.getSelectedItem();
					String customerid=null;
					databaseConnectivity();
					ResultSet rs1=st.executeQuery("SELECT * FROM customer_master WHERE NameOfPerson='"+customername+"'");
					if(rs1.next())
						 customerid=rs1.getString("CustomerId");
					ResultSet rs=st.executeQuery("SELECT * FROM chequedetails_ls_transactions WHERE CustomerId='"+customerid+"'");
					while(rs.next())
					{
						String a=rs.getString("ChequeNumber");
						String b=rs.getString("ChequeDate");
						String c=rs.getString("ChequeAmount");
						dtm.addRow(new Object[] { a, b, c });
					}
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btn_details.setBounds(110, 162, 89, 23);
		panel_2.add(btn_details);

		String a=bankchequeno_text.getText().toString();
		String b=((JTextField)ChequeDateChooser.getDateEditor().getUiComponent()).getText();
		String c=bankchequeamount_text.getText().toString();

		JButton btn_add = new JButton("Add");
		btn_add.setBounds(10, 159, 89, 23);
		panel_1.add(btn_add);
		btn_add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//
				String a=bankchequeno_text.getText().toString();
				String b=((JTextField)ChequeDateChooser.getDateEditor().getUiComponent()).getText();
				String c=bankchequeamount_text.getText().toString();
				String d=bank_text.getText().toString();
				dtm.addRow(new Object[] { a, b, c });

				try {
					databaseConnectivity();
					st.executeUpdate("INSERT INTO `fms`.`chequedetails_ls_transactions` (`CustomerId`, `ChequeDate`, `ChequeNumber`, `ChequeBank`, `ChequeAmount`) "
							+ "VALUES ('6', '"+b+"', '"+a+"','"+d+"', '"+c+"');");
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

		});

		JButton btn_remove = new JButton("Remove");
		btn_remove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
			
				if (dtm.getRowCount() > 0 && chequedetails_table.getSelectedRow() != -1 )
				{
					int row = chequedetails_table.getSelectedRow();
					String chequenumber=(String) chequedetails_table.getValueAt(row, 0);
					dtm.removeRow(chequedetails_table.getSelectedRow());
					
					try {
						databaseConnectivity();
						st.executeQuery("SET SQL_SAFE_UPDATES = 0");
						st.executeUpdate("DELETE FROM `fms`.`chequedetails_ls_transactions` WHERE `ChequeNumber`='"+chequenumber+"';");
					} catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}

				//not found
			}
		});
		btn_remove.setBounds(124, 159, 89, 23);
		panel_1.add(btn_remove);

		JLabel lblChequeAmount = new JLabel("Cheque Amount");
		lblChequeAmount.setBounds(10, 117, 103, 14);
		panel_1.add(lblChequeAmount);

		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Required Documents", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_3.setBounds(514, 48, 246, 179);
		contentPane.add(panel_3);
		panel_3.setLayout(null);
		
		JComboBox requireddoc_combo = new JComboBox();
		int i1=0;
		String[] elements1 = new String[1000] ;
		try {
			databaseConnectivity();
			ResultSet cname=st.executeQuery("SELECT * FROM document_master");
			while(cname.next())
			{	
				elements1[i1]=cname.getString("Document");
				i1=i1+1;
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		AutoCompleteSupport.install(requireddoc_combo, GlazedLists.eventListOf(elements1));

		requireddoc_combo.setBounds(10, 22, 132, 20);
		panel_3.add(requireddoc_combo);
		


		// Adding data in JList. Database Connectivity

		@SuppressWarnings("rawtypes")
		DefaultListModel model = new DefaultListModel();
		JList documents_list = new JList(model);
		
		documents_list.setBorder(UIManager.getBorder("TextField.border"));
		documents_list.setBounds(10, 56, 226, 112);
		panel_3.add(documents_list);
		
		JButton btnNewButton = new JButton("Add");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String nameofdocument=(String) requireddoc_combo.getSelectedItem();
				model.addElement(nameofdocument);
			}
		});
		btnNewButton.setBounds(152, 21, 84, 23);
		panel_3.add(btnNewButton);
		
	

		JButton btnSave = new JButton("Save");
		btnSave.setBounds(10, 454, 89, 23);
		contentPane.add(btnSave);
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sanctiondate= ((JTextField)SanctiondateChooser.getDateEditor().getUiComponent()).getText();
				String formofpayment=(String) formofpayment_combo.getSelectedItem();
				String loantype=(String) loantype_combo.getSelectedItem();
				String loanbank=(String) loanbank_combo.getSelectedItem();
				String period=period_ls_text.getText().toString();
				String sanctionamount=sanctionamount_ls_text.getText().toString();
				String sanctionchequeno=sanctionchequeno_ls_text.getText().toString();
				String interestrate=interestrate_ls_text.getText().toString();
				String penaltyrate=penaltyrate_ls_text.getText().toString();
				String emi=emi_ls_text.getText().toString();
				String customername=(String) customername_combo.getSelectedItem();
				String customerid=null;
				String bankid=null;
				int i=1;

				try {
					databaseConnectivity();


					ResultSet rs=st.executeQuery("SELECT * FROM customer_master WHERE NameOfPerson='"+customername+"'");
					if(rs.next())
						customerid=rs.getString("CustomerId");
					ResultSet rs1=st.executeQuery("SELECT * FROM bank_master WHERE BankName='"+loanbank+"'");
					if(rs1.next())
						bankid=rs1.getString("BankId");

					st.executeUpdate("INSERT INTO `fms`.`loansanction_transaction` (`CustomerId`, `FormOfPayment`, `LoanType`, `BankId`, `Periods`, `SanctionAmount`, `ChequeNo`, `InterestRate`, `PenaltyRate`, `EMI`) "
							+ "VALUES ('"+customerid+"', '"+formofpayment+"', '"+loantype+"', '"+bankid+"', '"+period+"', '"+sanctionamount+"', '"+sanctionchequeno+"', '"+interestrate+"', '"+penaltyrate+"', '"+emi+"');");
					JOptionPane.showMessageDialog(btnSave, "Data Saved");

				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

		});
		// to get checked items 
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
