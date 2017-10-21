package frontend;

import main.AccountService;
import main.UserProfile;
import templater.PageGenerator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("serial")
public class SignUpServlet extends HttpServlet {
	private AccountService accountService;

	public SignUpServlet(AccountService accountService) {
		this.accountService = accountService;
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String familyName = request.getParameter("familyName");
		String age = request.getParameter("age");
		String adress = request.getParameter("adress");
		String data = request.getParameter("data");

		Map<String, Object> pageVariables = new HashMap<>();

		if (accountService.addUser(name, new UserProfile(name, familyName, age, adress, data))) {
			pageVariables.put("signUpStatus",
					"<p class=\"inputText\">" + name + "&nbsp; " + familyName + "</<p>" + "<h1>Congratulation! </h1>"
							+ "<p>" + "You have successfully registered, and now you can choose what to do the next"
							+ "</<p>");
		} else {
			pageVariables.put("signUpStatus",
					"<p>" + "User with name: " + name + " already exists, please sign in." + "</p>");
		}

		response.getWriter().println(PageGenerator.getPage("signupstatus.html", pageVariables));
		response.setStatus(HttpServletResponse.SC_OK);
	}

}
