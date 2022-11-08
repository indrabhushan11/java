
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns="/servlet4B", initParams = {@WebInitParam(name = "user", value = "rvce"),
													@WebInitParam(name = "pass", value = "rvce")})

public class servlet4B extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public servlet4B() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		ServletConfig sc=getServletConfig();
		String s1=request.getParameter("username");
		String s2=request.getParameter("password");
		if(s1.equalsIgnoreCase("rvce") && s2.equalsIgnoreCase("rvce"))
		{
		out.println("<html><body bgcolor='lightgreen' text='black'><br><br>");
		out.println("<center><h1>LOGIN AUTHORIZATION PAGE....</h1></center>");
		out.println("Login Succesfull\n");
		out.println("</body></html>");
		}
		else
		{
		out.println("Login UnSuccesfull");
		}
	}
}
