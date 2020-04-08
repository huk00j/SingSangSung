package TCP;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.StringTokenizer;

import DB.LoginDAO;

public class Scenter extends Thread {

	Socket socket = null;
	InputStream input = null;
	OutputStream output = null;

	String join = null;
	
	LoginDAO ldao = new LoginDAO();

	Scenter(Socket socket) {
		this.socket = socket;
		run();
	}

	@Override
	public void run() {
		receive();
//		send();
	}

	private void send() {

		try {
			output = socket.getOutputStream();
			output.write(this.join.getBytes());

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void receive() {
		try {
			while (true) {
				input = socket.getInputStream();
				byte bb[] = new byte[100];
				input.read(bb);
				String jj = new String(bb);
				jj = jj.trim();
				joincode(jj); // 회원가입신청 받기

				output = socket.getOutputStream();
				output.write(this.join.getBytes());

			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void joincode(String jj) {
//		switch (jj) {
//		case "회원가입신청":
//			this.join = "회원가입수락";
//			break;
//		case "계정중복확인":
////			ldao.
//			break;
//		default:
//			break;
//		}

		if (jj.equals("회원가입신청")) {
			this.join = "회원가입수락";
		}
		
		if(jj.contains("계정중복확인")) {
			StringTokenizer st = new StringTokenizer(jj, "/");
			String jjck = st.nextToken();
			String jjid = st.nextToken();
			int chknum = ldao.idCheck(jjid);
			if(chknum == 1) {	// 해당 아이디가 DB에 있으면.
				
			} else {	// 해당 아이디가 DB에 없으면.
				
			}
		}
		
	}

}




