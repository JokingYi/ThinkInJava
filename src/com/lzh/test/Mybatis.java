package com.lzh.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.lzh.mapper.BookMapper;
import com.lzh.mapper.UserMapper;
import com.lzh.model.Book;
import com.lzh.model.User;

public class Mybatis
{
	public static void main(String[] args)
	{
		String resource="mybatis-config.xml";
		InputStream inputStream;
		SqlSession session=null;
		try
		{
			inputStream = Resources.getResourceAsStream(resource);
			SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(inputStream);
			session=factory.openSession();
			
//			BookMapper bookMapper=session.getMapper(BookMapper.class);
//			//如果model对应的属性与数据表不符合，那将不会填充，所以应该使用resultMap
//			Book book=bookMapper.selectBook(1);
//			System.out.println(book);
			
			UserMapper mapper=session.getMapper(UserMapper.class);
			//insert list
//			List<User> users=new ArrayList<>();
//			users.add(new User("list1", "wer"));
//			users.add(new User("list2", "skjflsf"));
//			users.add(new User("list3", "djskf"));
//			mapper.insertList(users);
			//
//			User user=mapper.selectUser(9);
			User user=new User();
			user.setUserName("");
			List<User> users=mapper.selectByUsername(user);
			System.out.println(users.size());
//			自动可以转换为list结果类型
//			System.out.println(mapper.selectUseMap());
			//
//			User user2=new User("what", "my");
//			user2.setBirth(new Date());
//			mapper.insertUser(user2);
//			mapper.insertTest(new User("qwe", "pass"));
			
			
			//remember this line
			session.commit();
//			System.out.println("here");
		} catch (IOException e)
		{
			e.printStackTrace();
		}
		finally 
		{
			session.close();
		}
	}
}
