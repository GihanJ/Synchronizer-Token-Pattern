package controllers;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import attributes.CookieFunction;
import info.Credentials;

@WebServlet("/SignInController")
public class SignInController extends HttpServlet
{
	public static Map<String, String> csrfTokenStore = new HashMap<String, String>();
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
	   response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String email = request.getParameter("email");
	    String password = request.getParameter("password");
	    HttpSession session = request.getSession(true); // create a new session if not exists

	    if (Credentials.isValidUser(email, password))
	    {
	      String csrfToken = createToken(session.getId());
	      csrfTokenStore.put(session.getId(), csrfToken); // adding to token store
	      response.addCookie(CookieFunction.COOKIE_WITH_SESSION_ID.apply(session));
	      response.sendRedirect("jsp/Home.jsp");
	    }
	    else
	    {
	      response.sendRedirect("SignIn.jsp");
	    }
	  }
	 private String createToken(String strClearText)
	 {
	    return strClearText + "." + createRandomString();
	 }
	 private String createRandomString()
	 {
	    UUID randomUuid = UUID.randomUUID();
	    return randomUuid.toString();
	 }

}
