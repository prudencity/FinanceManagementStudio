package Transactions;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import java.awt.Color;
import com.toedter.calendar.JDateChooser;
import javax.swing.JButton;

public class PenaltyTransaction extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PenaltyTransaction frame = new PenaltyTransaction();
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
	public PenaltyTransaction() {
		setTitle("Penalty");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 329, 249);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Penalty Charged", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(16, 19, 289, 148);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblCustomerName = new JLabel("Customer Name");
		lblCustomerName.setBounds(10, 28, 101, 14);
		panel.add(lblCustomerName);
		
		JLabel lblCustomerbank = new JLabel("Customer Bank");
		lblCustomerbank.setBounds(10, 58, 101, 14);
		panel.add(lblCustomerbank);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(108, 55, 166, 20);
		panel.add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(108, 25, 166, 20);
		panel.add(comboBox_1);
		
		JLabel lblAmount = new JLabel("Amount");
		lblAmount.setBounds(10, 88, 76, 14);
		panel.add(lblAmount);
		
		textField = new JTextField();
		textField.setBounds(108, 85, 166, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblDate = new JLabel("Date");
		lblDate.setBounds(10, 118, 46, 14);
		panel.add(lblDate);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(108, 116, 166, 20);
		panel.add(dateChooser);
		
		JButton btnNewButton = new JButton("Charge");
		btnNewButton.setBounds(66, 178, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnRecieve = new JButton(" Recieve");
		btnRecieve.setBounds(183, 178, 89, 23);
		contentPane.add(btnRecieve);
	}
}
