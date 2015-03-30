package Master;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;

import ca.odell.glazedlists.GlazedLists;
import ca.odell.glazedlists.swing.AutoCompleteSupport;

import javax.swing.JList;

import java.awt.CardLayout;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Test extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Test frame = new Test();
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
	@SuppressWarnings("unchecked")
	public Test() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);



		contentPane.setLayout(null);

		JButton btnNewButton = new JButton("New button");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//	public void addCheckbox(JCheckBox checkBox) {
				//ListModel currentList = this.getModel();
				//JCheckBox[] newList = new JCheckBox[currentList.getSize() + 1];
				//for (int i = 0; i < currentList.getSize(); i++) {
				//   newList[i] = (JCheckBox) currentList.getElementAt(i);
				// }
				// newList[newList.length - 1] = checkBox;
				// setListData(newList);
				//}
			}
		});
		btnNewButton.setBounds(135, 27, 37, 23);
		contentPane.add(btnNewButton);
	}
}
