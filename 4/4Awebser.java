

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class webserv
 */
@WebServlet("/webserv")
public class webserv extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public webserv() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		double price1=123.1+Math.random(),price2=1334.43;
		response.setIntHeader("Refresh",1);
		DateFormat dateformat=new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
		Date date=new Date();
		
		StringBuilder sb=new StringBuilder();
		sb.append("<html>")
		.append("<head>")
		.append("<body style=background-color:#1d3555;color:#c2ca88;text-align:center><title>AUTOREFRESH</title>")
		.append("<h1>Auto Refresh</h1>")
		.append("<h2> Current time :   Date "+dateformat.format(date)+"  mins </h2>")
		.append("<table style=text-align:center>")
		.append("<th style=color:#c2ca88;>Stock</th>")
		.append("<th style=color:#c2ca88;>Price</th>")
		.append("<tr>")
		.append("<td style=color:#08f7ca>Tata </td><td style=color:#6fff0c >"+price1+"</td></tr>")
		.append("<tr><td style=color:#08f7ca>Wipro </td><td style=color:#6fff0c >"+price2+"</td>")
		.append("<tr><td style=color:#08f7ca>TCS </td><td style=color:#6fff0c >"+"350.25"+"</td>")
		.append("<tr><td style=color:#08f7ca>Reliance </td><td style=color:#6fff0c >"+"204.54"+"</td>")
		.append("<tr><td style=color:#08f7ca>Nifty</td><td style=color:#6fff0c >"+"220.45"+"</td>")
		.append("<tr><td style=color:#08f7ca>IOC </td><td style=color:#6fff0c >"+"120.55"+"</td>")
		.append("<tr><td style=color:#08f7ca>Bharat </td><td style=color:#6fff0c> "+"250.35"+"</td>")
		.append("<tr><td style=color:#08f7ca>Indian Oil </td><td style=color:#6fff0c> "+"124.45"+"</td>")
		
		.append("</tr>")
		.append("</table>")
		.append("</body>")
		.append("</head>")
		.append("</html>")
		
		;
		response.getWriter().write(sb.toString());
		
		
	}

}

