package Master;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JPopupMenu;

import java.awt.Component;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JSlider;

import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.eclipse.wb.swing.FocusTraversalOnArray;
import org.omg.IOP.TransactionService;

import Transactions.LoanSanction;


public class MainScreen extends JFrame {

	private JPanel contentPane;
	public static Statement st;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainScreen frame = new MainScreen();
					frame.setLocation(300,100);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
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
	/**
	 * Create the frame.
	 */
	public MainScreen() {
		setBackground(Color.WHITE);
		setTitle("Finance Management System");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 722, 416);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		//Master Menu
		JMenu mnMaster = new JMenu("Master");
		menuBar.add(mnMaster);

		JMenuItem mntmCustomer = new JMenuItem("Customer");
		mnMaster.add(mntmCustomer);
		mntmCustomer.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent click) {

				CustomerMaster customermaster=new CustomerMaster();
				customermaster.setVisible(true);
				customermaster.setSize(750,550);
				customermaster.setAlwaysOnTop(true);
				customermaster.setLocation(250, 20);
				customermaster.setVisible(true);


			}

		});

		JMenuItem mntmGuarantor = new JMenuItem("Guarantor");
		mntmGuarantor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				GuarantorMaster guarantormaster=new GuarantorMaster();
				guarantormaster.setVisible(true);
				guarantormaster.setSize(900,700);
				guarantormaster.setAlwaysOnTop(true);
				guarantormaster.setLocation(200, 0);				
				guarantormaster.setVisible(true);

			}
		});
		mnMaster.add(mntmGuarantor);

		JSeparator separator = new JSeparator();
		mnMaster.add(separator); 

		JMenuItem mntmOffice = new JMenuItem("Office");
		mntmOffice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OfficeMaster officemaster = new OfficeMaster();
				officemaster.setVisible(true);
			}
		});
		mnMaster.add(mntmOffice);

		JSeparator separator_1 = new JSeparator();
		mnMaster.add(separator_1);

		JMenuItem mntmAgent = new JMenuItem("Agent");
		mntmAgent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AgentMaster agentmaster = new AgentMaster();
				agentmaster.setLocation(300,200);
				agentmaster.setVisible(true);
			}
		});
		mnMaster.add(mntmAgent);

		JSeparator separator_2 = new JSeparator();
		mnMaster.add(separator_2);

		JMenuItem mntmDocuments = new JMenuItem("Documents");
		mntmDocuments.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Master.DocumentMaster dm=new Master.DocumentMaster();
				dm.setVisible(true);
			}
		});
		mnMaster.add(mntmDocuments);

		JSeparator separator_3 = new JSeparator();
		mnMaster.add(separator_3);
		
		JMenuItem mntmBank = new JMenuItem("Bank");
		mntmBank.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			BankMaster bankmaster=new BankMaster();
			bankmaster.setLocation(400,200);
			bankmaster.setVisible(true);
			}
		});
		mnMaster.add(mntmBank);

		JMenuItem mntmCompanyInfo = new JMenuItem("Company Info");
		mnMaster.add(mntmCompanyInfo);

		//Transaction Menu

		JMenu mnTransaction = new JMenu("Transaction");
		menuBar.add(mnTransaction);

		JMenuItem mntmLoanApplication = new JMenuItem("Loan Application");
		mntmLoanApplication.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Transactions.LoanApplicationTransaction loanappicationform=new Transactions.LoanApplicationTransaction();
				loanappicationform.setLocation(100,10);
				loanappicationform.setVisible(true);
				

			}
		});
		mnTransaction.add(mntmLoanApplication);

		JSeparator separator_5 = new JSeparator();
		mnTransaction.add(separator_5);

		JMenuItem mntmEmiRecieved = new JMenuItem("EMI Received");
		mntmEmiRecieved.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Transactions.EmiTransaction emi=new Transactions.EmiTransaction();
				emi.setLocation(200,150);
				emi.setVisible(true);
			}
		});
		
		JMenuItem mntmLoanSanction = new JMenuItem("Loan Sanction");
		mntmLoanSanction.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				LoanSanction ls=new LoanSanction();
				ls.setVisible(true);
			}
		});
		mnTransaction.add(mntmLoanSanction);
		mnTransaction.add(mntmEmiRecieved);

		JMenuItem mntmPenaltyReceived = new JMenuItem("Penalty Charged/Recieved");
		mntmPenaltyReceived.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Transactions.PenaltyTransaction pt=new Transactions.PenaltyTransaction();
				pt.setVisible(true);
			}
		});
		mnTransaction.add(mntmPenaltyReceived);

		JSeparator separator_6 = new JSeparator();
		mnTransaction.add(separator_6);

		JMenuItem mntmAccountForeclosure = new JMenuItem("Account Foreclosure");
		mntmAccountForeclosure.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Transactions.AccountForclosureTransaction af=new Transactions.AccountForclosureTransaction();
				af.setVisible(true);
			}
		});
		mnTransaction.add(mntmAccountForeclosure);

		JSeparator separator_7 = new JSeparator();
		mnTransaction.add(separator_7);

		JMenuItem mntmAgentPayment = new JMenuItem("Agent Payment");
		mnTransaction.add(mntmAgentPayment);

		//Reports menu

		JMenu mnReports = new JMenu("Reports");
		menuBar.add(mnReports);

		JMenuItem mntmCustomerList = new JMenuItem("Customer List");
		mnReports.add(mntmCustomerList);

		JMenuItem mntmGuarantorList = new JMenuItem("Guarantor List");
		mnReports.add(mntmGuarantorList);

		JSeparator separator_8 = new JSeparator();
		mnReports.add(separator_8); 

		JMenuItem mntmEmiDueStatement = new JMenuItem("EMI Due Statement");
		mnReports.add(mntmEmiDueStatement);

		JSeparator separator_9 = new JSeparator();
		mnReports.add(separator_9); 

		JMenuItem mntmLoanApplicationChart = new JMenuItem("Loan Application Chart");
		mnReports.add(mntmLoanApplicationChart);

		JMenuItem mntmLoanApplicationReport = new JMenuItem("Loan Application Report");
		mnReports.add(mntmLoanApplicationReport);

		JSeparator separator_10 = new JSeparator();
		mnReports.add(separator_10); 

		JMenuItem mntmLoanSanctionReport = new JMenuItem("Loan Sanction Report");
		mnReports.add(mntmLoanSanctionReport);

		JSeparator separator_11 = new JSeparator();
		mnReports.add(separator_11); 

		JMenuItem mntmLoanLedger = new JMenuItem("Loan Ledger");
		mnReports.add(mntmLoanLedger);

		JSeparator separator_12 = new JSeparator();
		mnReports.add(separator_12); 

		JMenuItem mntmSendReminderMessage = new JMenuItem("Send Reminder Message");
		mnReports.add(mntmSendReminderMessage);

		JSeparator separator_13 = new JSeparator();
		mnReports.add(separator_13); 

		JMenuItem mntmCustomerHistory = new JMenuItem("Customer History");
		mnReports.add(mntmCustomerHistory);

		JMenuItem mntmAgentHistory = new JMenuItem("Agent History");
		mnReports.add(mntmAgentHistory);

		JSeparator separator_14 = new JSeparator();
		mnReports.add(separator_14); 

		JMenuItem mntmForm = new JMenuItem("Form 13");
		mnReports.add(mntmForm);

		JSeparator separator_15 = new JSeparator();
		mnReports.add(separator_15); 

		JMenuItem mntmAgentCommissionCum = new JMenuItem("Agent Commission Cum Interest Statement");
		mnReports.add(mntmAgentCommissionCum);

		JMenuItem mntmAgentLedger = new JMenuItem("Agent Ledger");
		mnReports.add(mntmAgentLedger);

		JMenuItem mntmInterestStatement = new JMenuItem("Interest Statement");
		mnReports.add(mntmInterestStatement);

		JMenu mnAccounting = new JMenu("Accounting");
		menuBar.add(mnAccounting);

		JMenuItem mntmCashBook = new JMenuItem("Cash Book");
		mnAccounting.add(mntmCashBook);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{menuBar, mnMaster, mntmCustomer, mntmGuarantor, separator, mntmOffice, separator_1, mntmAgent, separator_2, mntmDocuments, separator_3, mntmCompanyInfo, mnTransaction, mntmLoanApplication, separator_5, mntmEmiRecieved, mntmPenaltyReceived, separator_6, mntmAccountForeclosure, separator_7, mntmAgentPayment, mnReports, mntmCustomerList, mntmGuarantorList, mntmEmiDueStatement, mntmLoanApplicationChart, mntmLoanApplicationReport, mntmLoanSanctionReport, mntmLoanLedger, mntmSendReminderMessage, mntmCustomerHistory, mntmAgentHistory, mntmForm, mntmAgentCommissionCum, mntmAgentLedger, mntmInterestStatement, mnAccounting, mntmCashBook, contentPane}));
	}
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}
