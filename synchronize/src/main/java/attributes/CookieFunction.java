package attributes;
import java.util.function.Function;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpSession;

public class CookieFunction 
{
	public static final Function<HttpSession, Cookie> COOKIE_WITH_SESSION_ID = session -> new Cookie("SessionID", session.getId());
}
