<%@page import="java.util.List"%>
<%@page import="hibernate2.logincontroller"%>
<%@page import="hibernate2.login"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<table border = 2 style="margin: 4% 26%; border-radius: 5px; padding: 2%">
       
       
    <thead>
    
        <tr>
            <th style="padding: 4px">Id</th>
            <th style="padding: 4px">Name</th>
            <th style="padding: 4px">Email</th>
            <th style="padding: 4px">Password</th>
            <th style="padding: 4px">Actions</th>
        </tr>
    </thead>
    <tbody>
    <% 
     logincontroller lc = new logincontroller();
     List<login> li = lc.getall();
     for(login l:li){
    %>
        <tr>
            <td style="padding: 4px"><%=l.getId() %></td>
            <td style="padding: 4px"><%=l.getName()%></td>
            <td style="padding: 4px"><%=l.getEmail()%></td>
            <td style="padding: 4px"><%=l.getPassword()%></td>
            <td style="padding: 4px">
            <a href="updatestudent.jsp?pinnumber=<%=l.getId()%>"><button>Update</button></a>
            <a href="delete?id=<%=l.getId()%>"><button>Delete</button></a>
            </td>
        </tr>
        <%
    }
        %>
    </tbody>
</table>

</body>
</html>