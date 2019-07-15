<%-- 
    Document   : trainer
    Created on : Jul 9, 2019, 9:09:23 PM
    Author     : Eleni
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Trainers</title>
        <style>
		tr:first-child{
			font-weight: bold;
			background-color: #C6C9C4;
		}
	</style>
    </head>
    <body>
        <h1>List of trainers</h1>
        
        <table>
            <thead>
		
			<th>trainer_id</th>
                        <th>first_name</th>
                        <th>last_name</th>
                        <th>subject</th><th></th>
		
                </thead>
                <tbody>
		<c:forEach items="${greeting}" var="trainer">
                    
			<tr>
			<td>${trainer.trainerId}</td>
			<td>${trainer.firstName}</td>
			<td>${trainer.lastName}</td>
                        <td>${trainer.subject}</td>
			<td><a href="/SpringJPA/trainers/update/${trainer.trainerId}"/>Update</a></td>
			<td><a href="/SpringJPA/trainers/delete/${trainer.trainerId}">Delete</a></td>
			</tr>
		</c:forEach>
                        </tbody>
	</table>
    </body>
</html>

