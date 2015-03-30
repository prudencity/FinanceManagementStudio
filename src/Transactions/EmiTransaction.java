package Transactions;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import com.toedter.calendar.JDateChooser;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JList;

public class EmiTransaction extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_8;
	private JTextField textField_1;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTable table;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EmiTransaction frame = new EmiTransaction();
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
	public EmiTransaction() {
		setTitle("EMI Master");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 824, 398);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Customer Details", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(10, 20, 417, 83);
		contentPane.add(panel);
		
		JLabel label = new JLabel("CustomerId");
		label.setBounds(10, 23, 77, 14);
		panel.add(label);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(101, 21, 305, 20);
		panel.add(textField);
		
		JLabel label_8 = new JLabel("Name *");
		label_8.setBounds(10, 53, 46, 14);
		panel.add(label_8);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(101, 51, 212, 20);
		panel.add(textField_8);
		
		JButton button = new JButton("AutoFill");
		button.setBounds(322, 52, 84, 20);
		panel.add(button);
		
		JLabel label_11 = new JLabel("!");
		label_11.setForeground(Color.RED);
		label_11.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_11.setBounds(78, 53, 13, 14);
		panel.add(label_11);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Bank Details", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBounds(10, 124, 417, 159);
		contentPane.add(panel_1);
		
		JLabel label_1 = new JLabel("Bank");
		label_1.setBounds(10, 33, 46, 14);
		panel_1.add(label_1);
		
		JLabel label_4 = new JLabel("Address");
		label_4.setBounds(10, 63, 56, 14);
		panel_1.add(label_4);
		
		JLabel label_5 = new JLabel("Cheque No.");
		label_5.setBounds(10, 93, 91, 14);
		panel_1.add(label_5);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(101, 30, 305, 20);
		panel_1.add(textField_1);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(101, 60, 306, 20);
		panel_1.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(101, 90, 305, 20);
		panel_1.add(textField_5);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setDateFormatString("YYYY-MM-d");
		dateChooser.setBounds(101, 124, 113, 20);
		panel_1.add(dateChooser);
		
		JButton button_1 = new JButton("Add");
		button_1.setBounds(224, 121, 89, 23);
		panel_1.add(button_1);
		
		JButton button_2 = new JButton("Remove");
		button_2.setBounds(323, 121, 89, 23);
		panel_1.add(button_2);
		
		JLabel label_6 = new JLabel("Cheque Date");
		label_6.setBounds(10, 125, 91, 14);
		panel_1.add(label_6);

		Object rowData[][] = { { "Row1-Column1", "Row1-Column2", "Row1-Column3"},
		                       { "Row2-Column1", "Row2-Column2", "Row2-Column3"} };
		Object columnNames[] = { "Column One", "Column Two", "Column Three"};
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "JPanel title", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBounds(462, 20, 336, 306);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		
		JTable table_1 = new JTable();
		table_1.setBounds(10, 53, 316, 242);
		panel_2.add(table_1);
		
		table_1.setBorder(UIManager.getBorder("TextField.border"));
		
		JDateChooser dateChooser_1 = new JDateChooser();
		dateChooser_1.setBounds(10, 22, 113, 20);
		panel_2.add(dateChooser_1);
		dateChooser_1.setDateFormatString("YYYY-MM-d");
		
		JLabel lblPrincipal = new JLabel("Principal");
		lblPrincipal.setBounds(133, 22, 65, 14);
		panel_2.add(lblPrincipal);
		
		textField_2 = new JTextField();
		textField_2.setBounds(208, 22, 97, 20);
		panel_2.add(textField_2);
		textField_2.setColumns(10);
		
		JButton button_3 = new JButton("Clear");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button_3.setBounds(276, 303, 65, 23);
		contentPane.add(button_3);
		
		JButton button_4 = new JButton("Delete");
		button_4.setBounds(190, 303, 65, 23);
		contentPane.add(button_4);
		
		JButton btnPrint = new JButton("Print");
		btnPrint.setBounds(368, 303, 65, 23);
		contentPane.add(btnPrint);
		
		JButton button_6 = new JButton("Find");
		button_6.setBounds(102, 303, 65, 23);
		contentPane.add(button_6);
		
		JButton button_8 = new JButton("Save");
		button_8.setBounds(16, 303, 65, 23);
		contentPane.add(button_8);
	}
}
