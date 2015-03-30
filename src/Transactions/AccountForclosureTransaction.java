package Transactions;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;

public class AccountForclosureTransaction extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AccountForclosureTransaction frame = new AccountForclosureTransaction();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AccountForclosureTransaction() {
		setTitle("Account Forclosure");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 416, 288);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("Customer Name");
		label.setBounds(10, 20, 101, 14);
		contentPane.add(label);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(127, 17, 235, 20);
		contentPane.add(comboBox);
		
		JLabel label_1 = new JLabel("Customer Bank");
		label_1.setBounds(10, 50, 101, 14);
		contentPane.add(label_1);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(127, 47, 235, 20);
		contentPane.add(comboBox_1);
		
		JLabel label_2 = new JLabel("Amount");
		label_2.setBounds(10, 110, 76, 14);
		contentPane.add(label_2);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(127, 107, 56, 20);
		contentPane.add(textField);
		
		JLabel label_3 = new JLabel("Date");
		label_3.setBounds(10, 80, 46, 14);
		contentPane.add(label_3);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(127, 78, 235, 20);
		contentPane.add(dateChooser);
		
		JLabel lblNetAmount = new JLabel("Previous Amount");
		lblNetAmount.setBounds(10, 140, 101, 14);
		contentPane.add(lblNetAmount);
		
		textField_1 = new JTextField();
		textField_1.setBounds(127, 137, 235, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNetAmount_1 = new JLabel("Net Amount");
		lblNetAmount_1.setBounds(10, 170, 101, 14);
		contentPane.add(lblNetAmount_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(127, 168, 235, 20);
		contentPane.add(textField_2);
		
		JLabel lblRemarks = new JLabel("Remarks");
		lblRemarks.setBounds(10, 200, 76, 14);
		contentPane.add(lblRemarks);
		
		textField_3 = new JTextField();
		textField_3.setBounds(127, 197, 235, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel label_4 = new JLabel("@");
		label_4.setBounds(193, 110, 24, 14);
		contentPane.add(label_4);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(217, 107, 56, 20);
		contentPane.add(textField_4);
		
		JLabel label_5 = new JLabel("=");
		label_5.setBounds(283, 110, 24, 14);
		contentPane.add(label_5);
		
		textField_5 = new JTextField();
		textField_5.setBounds(306, 107, 56, 20);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
	}
}
