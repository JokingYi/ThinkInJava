package com.lzh.servletContainer;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Locale;

import javax.servlet.ServletOutputStream;
import javax.servlet.ServletResponse;

public class Response implements ServletResponse
{
	private static final int BUFFER_SIZE=1024;
	private Request request;
	private OutputStream output;
	PrintWriter writer;
	
	public Response(OutputStream output)
	{
		this.output = output;
	}
	public void setRequest(Request request)
	{
		this.request=request;
	}
	
	public OutputStream getOut()
	{
		return output;
	}
	
	public void sendStaticResource()
	{
		byte[] bytes=new byte[BUFFER_SIZE];
		FileInputStream fis=null;
		
		File file=new File(Constants.WEB_ROOT, request.getUri());
		
		try
		{
			if (file.exists())
			{
				fis=new FileInputStream(file);
				String header="HTTP/1.1 200 OK\r\n"
						+ "Content-Type: text/plain\r\n"
						+ "Content-length: \r\n"
						+ "Connection: close\r\n"
						+ "\r\n";
				output.write(header.getBytes());
				int ch=fis.read(bytes, 0, BUFFER_SIZE);
				while(ch!=-1)
				{
					output.write(bytes, 0, ch);
					ch=fis.read(bytes, 0, BUFFER_SIZE);
				}
			}else 
			{
				String errorMessage="HTTP/1.1 404 File Not Found\r\n"
						+ "Content-Type: text/html\r\n"
						+ "Content-length: 23\r\n"
						+ "Connection: close\r\n"
						+ "\r\n"
						+ "<h1>File Not Found</h1>";
				output.write(errorMessage.getBytes());
			}
			
		} catch (FileNotFoundException e)
		{
			e.printStackTrace();
		} catch (IOException e)
		{
			e.printStackTrace();
		}finally
		{
			try
			{
				if (fis!=null)
				{
					fis.close();
				}
				if (output!=null)
				{
					output.close();
				}
			} catch (IOException e)
			{
				e.printStackTrace();
			}
		}
	}
	
	@Override
	public String getCharacterEncoding()
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getContentType()
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ServletOutputStream getOutputStream() throws IOException
	{
		return null;
	}

	@Override
	public PrintWriter getWriter() throws IOException
	{
		writer=new PrintWriter(output, true);
		return writer;
	}

	@Override
	public void setCharacterEncoding(String charset)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setContentLength(int len)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setContentType(String type)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setBufferSize(int size)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getBufferSize()
	{
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void flushBuffer() throws IOException
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resetBuffer()
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isCommitted()
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void reset()
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setLocale(Locale loc)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public Locale getLocale()
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setContentLengthLong(long arg0)
	{
		// TODO Auto-generated method stub
		
	}

}
