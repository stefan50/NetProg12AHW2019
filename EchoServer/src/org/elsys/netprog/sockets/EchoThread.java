package org.elsys.netprog.sockets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class EchoThread extends Thread {

	protected List<PrintWriter> outs;
	protected List<BufferedReader> ins;
	
	
	public EchoThread(List<PrintWriter> outs, List<BufferedReader> ins) {
		this.outs = outs;
		this.ins = ins;
	}
	
	public void run() {
		try {
		    while (true) {
		    	synchronized(this) {
		    		if(Thread.interrupted()) {
		    			throw new InterruptedException();
		    		}
			    	for(BufferedReader inStream: ins) {
			    		if(inStream.ready()) {
			    			String inputLine = inStream.readLine();
			    			for(PrintWriter outStream: outs) {
			    				outStream.println(inputLine);
			    			}
			    		}
			    	}
		    	}
		    }
		} catch (IOException | InterruptedException e) {
			//e.printStackTrace();
			System.out.println("in here");
		}
		
		
	}
}
