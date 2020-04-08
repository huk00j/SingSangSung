package JTable;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import DB.DTO;
import DB.LoginDAO;

public class Join extends JFrame {

	JLabel id, pw;
	JTextField idd, pww1, pww2;
	JButton join, idcheck;
	JPanel panel = new JPanel();
	JPanel up, middle, middle2, down;
	
	LoginDAO ldao = new LoginDAO();
//	DTO dto = new DTO();
	
	Join(){
		window();
		windowUp();
		windowMiddle();
		windowDown();
		
		Dimension size = new Dimension(250,270);
		this.setLocation(500, 200); // 위치
		this.setSize(size);	// 사이즈 조정 x
		this.add(panel, "Center");
		this.setVisible(true); // 창 보이게 함.
		this.setDefaultCloseOperation(this.DISPOSE_ON_CLOSE);
		
		ActionID();
	}
	
	
	public void window() {
		panel.setLayout(new BorderLayout());
		
		id = new JLabel("ID   ");
		idd = new JTextField(8);
		idcheck = new JButton("중복 확인");
		pw = new JLabel("PW     ");
		pww1 = new JTextField(8);
		pww2 = new JTextField(8);
		join = new JButton("가입");
	}
	
	public void windowUp() {
		up = new JPanel();
		up.add(id);
		up.add(idd);
		up.add(idcheck);
		panel.add(up, "North");
	}
	
	public void windowMiddle() {
		middle = new JPanel();
		middle2 = new JPanel();
		middle2.setLayout(new BorderLayout());
		middle2.add(pw, "West");
		middle2.add(pww1);
		middle2.add(pww2, "South");
		middle.add(middle2);
		panel.add(middle, "Center");
	}
	
	public void windowDown() {
		down = new JPanel();
		down.add(join);
		panel.add(down, "South");
	}
	
	public void ActionID() {
		idcheck.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String in = idd.getText();
				checkID(in);
			}
		});
	}
	
	public void checkID(String in) {
		int k = ldao.idCheck(in);
		System.out.println(k + " << 뭐가 나오니");
		if(k==0) {
			System.out.println("없는 아이디"); // 안 썼 을 때 포함.
		} else if(k==1) {
			System.out.println("이미 있는 아이디");
			alreadyID();
		}
		
	}
	
	private void alreadyID() {
		JPanel al = new JPanel();
		
	}
	
	
	public static void main(String[] args) {
		new Join();
	}
	
	
	
	
}
