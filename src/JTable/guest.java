package JTable;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import DB.DTO;
import DB.LoginDAO;

public class guest extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JButton btnNewButton_1, btnNewButton;
	
		
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					guest frame = new guest();
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
	public guest() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 300, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("ID");
		lblNewLabel.setBounds(25, 35, 30, 30);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("PW");
		lblNewLabel_1.setBounds(25, 75, 30, 30);
		contentPane.add(lblNewLabel_1);

		textField = new JTextField();
		textField.setBounds(60, 40, 110, 25);
		contentPane.add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setBounds(60, 80, 110, 25);
		contentPane.add(textField_1);
		textField_1.setColumns(10);

		textField_2 = new JTextField();
		textField_2.setBounds(60, 110, 110, 25);
		contentPane.add(textField_2);
		textField_2.setColumns(10);

		btnNewButton = new JButton("중복 확인");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(182, 32, 90, 37);
		contentPane.add(btnNewButton);

		btnNewButton_1 = new JButton("가입");
		btnNewButton_1.setBounds(100, 200, 100, 50);
		contentPane.add(btnNewButton_1);
		
		
		ActionID();
	}
	
	
	public void ActionID() {
		btnNewButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String in = textField.getText();
				textField.setText("");
//				saveID(in);
				LoginDAO dao = new LoginDAO();
//				dao.idCheck();
			}
			
		});
	}
	
	public void saveID(String in) {
		DTO dto = new DTO();
		dto.setId(in);
	}
	
}









