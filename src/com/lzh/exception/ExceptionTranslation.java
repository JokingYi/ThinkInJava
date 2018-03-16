package com.lzh.exception;

import java.io.IOException;
import java.sql.SQLException;

class DataException extends Exception
{
	private static final long serialVersionUID = 1L;
	public DataException( Exception exception)
	{
		super(exception);
	}
}
interface DataSource
{
	String getData(int num) throws DataException;
}
class TextDataSource implements DataSource
{
	@Override
	public String getData(int num) throws DataException
	{
		if(num<0)
		{
			IOException exception=new IOException("fake");
			throw new DataException(exception);
		}
		return "";
	}
}
class DBSource implements DataSource
{
	@Override
	public String getData(int num) throws DataException
	{
		if(num<0)
		{
			SQLException exception=new SQLException("fake");
			throw new DataException(exception);
		}
		return "";
	}
	
}
/**
 * prevent from the lower level exception from influence the upper layer
 * @author ASUS
 */
public class ExceptionTranslation
{

}
