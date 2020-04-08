package IDCheck;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import DB.DTO;
import DB.LoginDAO;

public class Join extends JFrame {

	
//	public void ActionID() {
//		idcheck.addActionListener(new ActionListener() {
//			
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				String in = idd.getText();
//				idd.setText("");
//				checkID(in);
//			}
//			
//		});
//	}
//	
//	public void checkID(String in) {
//		dto = ldao.idCheck(in);
//		if(dto != null) {
//			System.out.println(dto.getId() + " << 뭐가 나오니");
//		} else {
//			System.out.println("우아아아아");
//		}
//		
//	}
	
	
	//--------------------------------------------------------------
	
	
//	public DTO idCheck(String in) {
////		ArrayList<String[]> list = new ArrayList<>();
//		DTO dtoId = null;
//		if (connect()) {
//			try {
//				stmt = conn.createStatement();
//				String sql = "select id from login where id='"+in+"'";
//				rs = stmt.executeQuery(sql);
//				if (rs.next()) {
//					dtoId = new DTO();
//					dtoId.setId(rs.getString("id"));
//					
//					return dtoId;
//				}
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//
//		} else {
//			System.out.println("DB에 아이디가 없나?");
//		}
//		return dtoId;
//	}
	
	
}
