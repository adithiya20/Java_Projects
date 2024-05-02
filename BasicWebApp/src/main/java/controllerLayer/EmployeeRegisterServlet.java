package controllerLayer;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelLayer.Employee;

import java.io.IOException;

import daoLayer.EmployeeDao;

/**
 * Servlet implementation class EmployeeRegisterServlet
 */
public class EmployeeRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private EmployeeDao employeeDao;


    public void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {

        String firstName = request.getParameter("fname");
        String lastName = request.getParameter("lname");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String address = request.getParameter("address");
        String contact = request.getParameter("contact");
        
        //System.out.println(firstName);

        Employee employee = new Employee(firstName,lastName,username,password,address,contact);
       // System.out.println(employee.toString());
        try {
        	employeeDao = new EmployeeDao();
            employeeDao.registerEmployee(employee);
            
            System.out.println("Registered");
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        //response.sendRedirect("employeedetails.jsp");
    }

}
