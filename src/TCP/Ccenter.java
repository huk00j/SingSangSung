package TCP;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

import JTable.Table2;

public class Ccenter extends Thread {

	Socket socket = null;
	OutputStream output = null;
	InputStream input = null;

	Table2 table2 = null;
//	String join;	// 회원가입 눌렀을 때.

	public Ccenter(Socket socket) {
		this.socket = socket;
		table2 = new Table2(this); // Table2랑 연결 되었음.
		run();
	}

	@Override
	public void run() {
//		send();
		receive();
	}

	private void receive() {
		new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					while (true) {
						input = socket.getInputStream();
						byte bb[] = new byte[100];
						input.read(bb);
						String jjj = new String(bb);
						jjj = jjj.trim();
						System.out.println(jjj + " ☜    jjj 가 뭐니");
//						table2.joinQQ(jjj);
						codejoin(jjj);	// 어쩔 땐 버튼이 보이고 안 보이고 함.
					}
				} catch (IOException e) {
					e.printStackTrace();
				}

			}
		}).start();
	}

	public void send(String jj) {
		try {
			output = socket.getOutputStream();
			output.write(jj.getBytes());

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void codejoin(String jjj) {
		if(jjj.equals("회원가입수락")) {
			table2.joinQQ(jjj);
		}
	}

}
