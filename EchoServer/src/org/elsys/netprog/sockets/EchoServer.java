package org.elsys.netprog.sockets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class EchoServer {

	public static void main(String[] args) throws IOException {
		ServerSocket serverSocket1 = null;
		try {
			final int PORT = 10001;
			serverSocket1 = new ServerSocket(PORT);
			List<PrintWriter> outs = new ArrayList<>();
			List<BufferedReader> ins = new ArrayList<>();
			Thread master = new EchoThread(outs, ins);
			while(true) {
				try {
					Socket clientSocket = serverSocket1.accept();
					System.out.println("client connected from " + clientSocket.getInetAddress());
					PrintWriter out =
					        new PrintWriter(clientSocket.getOutputStream(), true);
					BufferedReader in = new BufferedReader(
					        new InputStreamReader(clientSocket.getInputStream()));
					outs.add(out);
					ins.add(in);
					master.interrupt();
					master = new EchoThread(outs, ins);
					master.start();
				} catch(Exception e) {
					System.out.println("No client!");
				}
			}


				
		        //if (inputLine1.equals("exit") || inputLine2.equals("exit"))
		        //    break;
		        	
		} catch (Throwable t) {
			System.out.println(t.getMessage());
		} finally {
			if (serverSocket1 != null && !serverSocket1.isClosed()) {
				serverSocket1.close();
			}
			
			System.out.println("Server closed");
		}
	}

}
