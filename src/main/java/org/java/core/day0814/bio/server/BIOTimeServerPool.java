package org.java.core.day0814.bio.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class BIOTimeServerPool {
	public static void main(String[] args) {
		int port = 8080;
		if (args != null && args.length > 0) {
			try {
				port = Integer.valueOf(args[0]);
			} catch (NumberFormatException e) {
				// 采用默认值
			}
		}
		ServerSocket server = null;
		try {
			server = new ServerSocket(port);
			System.out.println("The time server is start in port : " + port);
			Socket socket = null;
			BIOTimeServerHandlerExecutePool singleExecutor = new BIOTimeServerHandlerExecutePool(50, 10000);// 创建I/O任务线程池
			while (true) {
				socket = server.accept();
				singleExecutor.execute(new BIOTimeServerHandler(socket));
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (server != null) {
				System.out.println("The time server close");
				try {
					server.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
				server = null;
			}
		}
	}
}
