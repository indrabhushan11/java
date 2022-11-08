<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="error1.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%--!
	
	class MyException extends Exception 
    {
		String message;
		
		MyException(String message)
		{
			this.message=message;
		}

        public String toString() 
        {
            return "Custom Exception: Please try again  " +message;
        }
		
    }
--%>
	
	<%  String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		int age = Integer.parseInt(request.getParameter("age"));%>
	<%-- conditional statements --%>
	<%if (fname.isBlank() || lname.isBlank() || age == 0) 
	{
		throw new Exception(" fields are empty");
		} else {%>
	First Name:<%=fname%><br>
	 Last Name:<%=lname%><br> 
	 Age:<%=age%><br>
	<%}%>

</body>
</html>
