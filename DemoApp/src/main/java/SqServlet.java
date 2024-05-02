

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class SqServlet
 */
public class SqServlet extends HttpServlet {
	@Override
		public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

			PrintWriter out = res.getWriter();
			out.println("hello to Sq");
			
			//code to receive request dispatcher
			//int k = (int)req.getAttribute("k");
			//k*=k;
			//out.println("Result is "+k);
		}

}
