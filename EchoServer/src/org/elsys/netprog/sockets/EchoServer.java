package org.elsys.netprog.sockets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {

	public static void main(String[] args) throws IOException {
		ServerSocket serverSocket = null;
		try {
			serverSocket = new ServerSocket(10001);
		    Socket clientSocket1 = serverSocket.accept();
		    Socket clientSocket2 = serverSocket.accept();
		    System.out.println("client connected from " + clientSocket1.getInetAddress());
		    System.out.println("client connected from " + clientSocket2.getInetAddress());
		    PrintWriter out1 =
		        new PrintWriter(clientSocket1.getOutputStream(), true);
		    BufferedReader in1 = new BufferedReader(
		        new InputStreamReader(clientSocket1.getInputStream()));
		    PrintWriter out2 =
			    new PrintWriter(clientSocket2.getOutputStream(), true);
			BufferedReader in2 = new BufferedReader(
			    new InputStreamReader(clientSocket2.getInputStream()));
		    
		    String inputLine1 = "in";
		    String inputLine2 = "in";

		    while ((inputLine1 = in1.readLine()) != null && (inputLine2 = in2.readLine()) != null) {
		        if (inputLine1.equals("exit") || inputLine2.equals("exit"))
		            break;
		        out1.println(inputLine2);
		        out2.println(inputLine1);
		    }
		} catch (Throwable t) {
			System.out.println(t.getMessage());
		} finally {
			if (serverSocket != null && !serverSocket.isClosed()) {
				serverSocket.close();
			}
			
			System.out.println("Server closed");
		}
	}

}
