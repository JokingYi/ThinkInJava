package com.lzh.socket;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class TheServerSocket
{
	public static void main(String[] args) throws IOException
	{
		PrintWriter out=null;
		BufferedReader input=null;
		ServerSocket server=null;
		try
		{
			server=new ServerSocket(6000);
			System.out.println("server socket created");
			System.out.println("waiting...");
			Socket socket=server.accept();
			System.out.println("waiting...");
			
			out=new PrintWriter(socket.getOutputStream());
			input=new BufferedReader(
					new FileReader(new File("d:/testServer.txt")));
			
			String string=input.readLine();
			boolean first=true;
			while(!"end".equals(string))
			{
				if (first)
				{
					first=false;
					out.println(string);
					out.flush();
				}
				string=input.readLine();
				out.println(string);
				out.flush();
				System.out.println(string);
			}
		} catch (IOException e)
		{
			e.printStackTrace();
		}finally {
			if (input!=null)
				input.close();
			if(out!=null)
				out.close();
			if (server!=null)
				server.close();
			
		}
	}
}
