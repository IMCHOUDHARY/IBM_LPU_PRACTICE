package com.example.JDBCSr;

import java.util.UUID;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.example.JDBCSr.bean.ToDo;
import com.example.JDBCSr.repo.ToDoRepository;
import com.example.JDBCSr.repo.ToDoRepositoryImpl;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
		ToDoRepository toDoRepository=context.getBean("toDoRepositoryImpl",ToDoRepositoryImpl.class);
    	
		ToDo todo=toDoRepository.createToDo(new ToDo(UUID.randomUUID().toString(), "compile"));
		System.out.println(todo);
		toDoRepository.displayAll();
    }
}
