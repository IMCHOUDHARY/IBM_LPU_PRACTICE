<%@page import="org.example.model.ToDo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% 
//scriptlet
ToDo todo=(ToDo)request.getAttribute("todo");
out.println(todo.getTodoId()+" , "+todo.getTodoName()+" , "+todo.getCompletedBy());
%>

</body>
</html>