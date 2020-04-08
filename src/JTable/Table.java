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
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import DB.SongDAO;
import DB.DTO;

public class Table extends JFrame {

	String header[] = { "No", "곡명", "가수명", "장르", "앨범" };
	DefaultTableModel tableModel = new DefaultTableModel(null, header);
	JTable table = new JTable(tableModel);
	JScrollPane tableScroll = new JScrollPane(table);
	
	//-------------------------------------------
//	JPanel panelLeft = new JPanel();
	JPanel panelLight = new JPanel();
	
	JLabel id, pw;
	JTextField idd, pww;
	JButton suggest, listen, login, join, blahblah;
	
	JPanel division = new JPanel();
	JPanel divUp = new JPanel();
	JPanel divDown = new JPanel();
	JPanel divUp1;
	JPanel divUp2;
	JPanel divUp3;
	
	SongDAO dao = new SongDAO();
	
	
	public Table(){
		createtab();
		table();
		
		Dimension size = new Dimension(600,400);
		
		this.setLocation(50, 200); // 위치
		this.setSize(size);	// 사이즈 조정 x
//		this.add(panelLeft, "West"); // 탭 등록.
		this.add(tableScroll);
		this.add(panelLight, "East");
		this.setVisible(true); // 창 보이게 함.
		this.setDefaultCloseOperation(this.DISPOSE_ON_CLOSE);
	}
	
	
	private void createtab() {
//		panelLeft.setLayout(new BorderLayout());	// 큰 왼쪽꺼.
//		panelLeft.add(tableScroll);
//		this.add(tableScroll);

		panelLight.setLayout(new BorderLayout()); // 큰 오른쪽꺼.
		panelLight.add(division);
		
		division.setLayout(new BorderLayout()); // 큰 오른쪽 위아래 나눔.
		
		//-------------------------------- 로그인 쪽.
		login = new JButton("로그인");
		join = new JButton("회원 가입");
		id = new JLabel("ID   ");
		pw = new JLabel("PW");
		idd = new JTextField(7);
		pww = new JTextField(7);

		//---------------------- 로그인쪽에서 나누기 작업 시작.
		divUp.setLayout(new BorderLayout());
		
		divUp1 = new JPanel();
		divUp1.add(id);
		divUp1.add(idd);
		divUp.add(divUp1,"North");
		
		divUp2 = new JPanel();
		divUp2.add(pw);
		divUp2.add(pww);
		divUp.add(divUp2,"Center");
		
		divUp3 = new JPanel();
		divUp3.add(login);
		divUp3.add(join);
		divUp.add(divUp3, "South");
		
		division.add(divUp, "North");
		
		//----------
		join.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new Join2();
				
			}
		});
		
		//--------------------------------- 중간에 리스트 넣을 곳에 미리 버튼 큼지막하게 하나 넣어두기.
//		blahblah = new JButton("아무거나");
//		division.add(blahblah, "Center");
		
		//--------------------------------- 듣기 버튼 쪽.
		suggest = new JButton("추천");
		listen = new JButton("듣기");

		divDown.setLayout(new BorderLayout());
		divDown.add(suggest, "North");
		divDown.add(listen, "South");
		
		division.add(divDown, "South");
		
	}
	
	public void table() {
		ArrayList<String[]> tList = new ArrayList<>();
		tList = dao.tableList();
		for(int i = 0 ; i < tList.size() ; i++) {
			tableModel.addRow(tList.get(i));
		}
				
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Table();
	}
	
}
