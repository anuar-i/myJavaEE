package kz.bitlab.servlets;

import entity.Person;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet(value = "/home")
public class HomeServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {
    }

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Create an array of Person objects
        Person[] persons = new Person[4];
        // Initialize each element of the array
        persons[0] = new Person("Me", "One", "Engineering", 5000.0);
        persons[1] = new Person("Jane", "Smith", "HR", 4500.0);
        persons[2] = new Person("Eldar", "Johnson", "Sales", 6000.0);
        persons[3] = new Person("Ilyas", "Zhuanyshev", "IT", 7000.0);

        response.getWriter().println("<html><body>");
        response.getWriter().println("<table>");
        response.getWriter().println("<tr><th>Name</th><th>Surname</th><th>Department</th><th>Salary</th></tr>");

        for (Person person: persons
             ) {
            response.getWriter().println("<tr>");
            response.getWriter().println("<td>" + person.getName() + "</td>");
            response.getWriter().println("<td>" + person.getSurname() + "</td>");
            response.getWriter().println("<td>" + person.getDepartment() + "</td>");
            response.getWriter().println("<td>" + person.getSalary() + "</td>");
            response.getWriter().println("</tr");
        }

        response.getWriter().println("</table>");
        response.getWriter().println("</body></html>");
    }
}