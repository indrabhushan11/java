<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.io.*,java.util.* " %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
		
		<%
	
		Date createTime = new Date(session.getCreationTime());
	    Date lastAccessTime = new Date(session.getLastAccessedTime());
	   
	    String first=request.getParameter("first");
	    String last=request.getParameter("last");
	    
	    out.println("First Name:"+first+"<br>");
	    out.println("Last Name:"+last+"<br>");
	    out.println("Session ID:"+ session.getId()+"<br/>");
	    out.println("CreateTime:"+createTime+"<br>");
	    out.println("lastAccessTime:"+lastAccessTime+"<br/>");
	    
	    
	    //Set Cookies
	      Cookie firstName = new Cookie("first_name", first);
   		  Cookie lastName = new Cookie("last_name",last);
   		  firstName.setMaxAge(60*60*24*7);
   		  lastName.setMaxAge(60*60*24*7);
   		  
   		  response.addCookie( firstName );
   	      response.addCookie( lastName );
   	   // <a href="newpage.jsp">display</a>
   	   
   	   // new file create 
   	   
   	   
   	   
   	   	  Cookie cookie = null;
          Cookie[] cookies = null;
       
       // Get an array of Cookies associated with the this domain
       cookies = request.getCookies();
   	      
   	   if( cookies != null ) 
   	   	{
           out.println("<h2> Found Cookies Name and Value</h2>");
           
           for (int i = 0; i < cookies.length; i++) 
           {
              cookie = cookies[i];
              out.print("Cookies Name : " + cookie.getName( ) + " <br/>");
              out.print("Cookies Value: " + cookie.getValue( )+" <br/>");
           }
        } 
   	   else 
   	   {
           out.println("<h2>No cookies founds</h2>");
       }
	%>

</body>
</html>
