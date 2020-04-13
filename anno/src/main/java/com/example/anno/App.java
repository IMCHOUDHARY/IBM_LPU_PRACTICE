package com.example.anno;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.example.anno.component.Image;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	ApplicationContext context = new ClassPathXmlApplicationContext("annoBasics.xml");
        Image obj = (Image)context.getBean("image",Image.class); 
        System.out.println(obj.toString());
    }
}
