package com.example.JDBC;

import java.util.UUID;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.example.JDBC.bean.ToDo;
//import com.example.JDBC.repo.ToDoRepository;
//import com.example.JDBC.repo.ToDoRepositoryImpl;
import com.example.JDBC.service.ToDoService;
import com.example.JDBC.service.ToDoServiceImpl;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
		//ToDoRepository toDoRepository=context.getBean("toDoRepositoryImpl",ToDoRepositoryImpl.class);
    	
    	ToDoService toDoService=(ToDoService) context.getBean("toDoServiceImpl",ToDoServiceImpl.class);
    	ToDo todo=toDoService.createToDoService(new ToDo(UUID.randomUUID().toString(), "compile"));
		System.out.println(todo);
		toDoService.displayAllService();
	
    }
}
