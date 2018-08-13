package org.java.core.day0814.bio.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class BIOTimeServer {
	public static void main(String[] args) {
		int port = 8090;
		if (args != null && args.length > 0) {
			try {
				port = Integer.valueOf(args[0]);
			} catch (NumberFormatException e) {

			}
		}
		ServerSocket serverSocket = null;
		try {
			serverSocket = new ServerSocket(port);
			System.out.println("BIO time server is start in port :" + port);
			Socket socket = null;
			while (true) {
				socket = serverSocket.accept();
				new Thread(new BIOTimeServerHandler(socket)).start();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (serverSocket != null) {
				try {
					serverSocket.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
				serverSocket = null;
			}
		}
	}
}
