package controllers;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/HomeController")
public class HomeController extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		HttpSession session = request.getSession(false);
	    String formToken = request.getParameter("myHiddenField"); //getting token from the submitted form as a parameter
	    String csrfToken = SignInController.csrfTokenStore.get(session.getId()); //getting token from the token store which is stored against the sessionID
	 
	    response.setContentType("text/html");
	    PrintWriter out = response.getWriter();
	    out.println("<html>");
        out.println("<head>");
	    out.println("<script src='./js/jquery.js'></script>");
	    out.println("<script src='./js/sweetalert2.js'></script>");
    	out.println("<link rel='stylesheet' type='text/css' href= './css/sweetalert2.css' />");
    	out.println("</head>");
    	out.println("<body>");
    	
	    if (csrfToken.equals(formToken)) //comparing tokens
	    {
	    	out.println("<script>");
	        out.println("Swal.fire(\r\n" + 
	        		"  'Successful!',\r\n" + 
	        		"  '***Amount Transferred***',\r\n" + 
	        		"  'success'\r\n" + 
	        		")");
	        out.println("</script>");
	     }
	    else
	    {
	    	out.println("<script>");
	        out.println("Swal.fire({\r\n" + 
	        		"  type: 'error',\r\n" + 
	        		"  title: 'ERROR...',\r\n" + 
	        		"  text: 'Something went wrong!',\r\n" + 
	        		"})");
	        out.println("</script>");
	     }
	    out.println("</body>");
	    out.println("</html>");
	 }
}
