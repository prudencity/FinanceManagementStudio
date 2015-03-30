package Master;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.UIManager;


public class DocumentMaster extends JFrame {

	private static Statement st;
	private JPanel contentPane;
	private JTextField documentname_text;
	private JTextField documentremarks_text;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DocumentMaster frame = new DocumentMaster();
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
	public DocumentMaster() {
		setTitle("Document Master");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 425, 181);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel.setBounds(0, 11, 422, 138);
		contentPane.add(panel);
		
		JLabel label = new JLabel("Name");
		label.setBounds(17, 14, 56, 14);
		panel.add(label);
		
		documentname_text = new JTextField();
		documentname_text.setColumns(10);
		documentname_text.setBounds(109, 11, 287, 20);
		panel.add(documentname_text);
		
		JButton button = new JButton("Save");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if(documentname_text.getText().toString().equals(""))
					documentname_text.setBorder(new LineBorder(Color.RED));
				else
				{
				try {
					documentname_text.setBorder(new LineBorder(Color.GRAY));
					databaseConnectivity();
					st.executeUpdate("INSERT INTO `fms`.`document_master` (`Document`, `DocumentRemarks`) VALUES ('"+documentname_text.getText()+"', '"+documentremarks_text.getText()+"');");
							 
					JOptionPane.showMessageDialog(button, "Document Successfully Saved");
					documentname_text.setText(null);
					documentremarks_text.setText(null);
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				}
			}
		});
		button.setBounds(10, 95, 89, 23);
		panel.add(button);
		
		JButton button_1 = new JButton("Find");
		button_1.setBounds(109, 95, 89, 23);
		panel.add(button_1);
		
		JButton button_2 = new JButton("Clear");
		button_2.setBounds(208, 95, 89, 23);
		panel.add(button_2);
		
		JButton button_3 = new JButton("Delete");
		button_3.setBounds(307, 95, 89, 23);
		panel.add(button_3);
		
		JLabel lblNewLabel = new JLabel("Remark");
		lblNewLabel.setBounds(17, 54, 46, 14);
		panel.add(lblNewLabel);
		
		documentremarks_text = new JTextField();
		documentremarks_text.setColumns(10);
		documentremarks_text.setBounds(109, 51, 287, 20);
		panel.add(documentremarks_text);
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
