package TCP;

import java.net.Socket;

import JTable.Table;

public class Cchat {

	Socket socket = null;
	
	Cchat(Socket socket){
		this.socket = socket;
		
//		new Table();	// TCP 연결 확인하려고 임시로 만듦. -> OK.
	}
	
}
