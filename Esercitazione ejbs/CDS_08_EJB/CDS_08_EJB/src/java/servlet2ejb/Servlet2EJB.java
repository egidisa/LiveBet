
package servlet2ejb;

import java.io.*;
import javax.ejb.EJB;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import util.HTMLFilter;

// Though it is perfectly fine to declare the dependency on the bean
// at the type level, it is not required for stateless session bean
// Hence the next two lines are commented and we rely on the
// container to inject the bean.
// @EJB(name="StatelessSession", beanInterface=StatelessSession.class)

@WebServlet(name="Servlet", urlPatterns={"/servlet"})
public class Servlet2EJB
    extends HttpServlet {

    // Using injection for Stateless session bean is still thread-safe since
    // the ejb container will route every request to different
    // bean instances. However, for Stateful session beans the
    // dependency on the bean must be declared at the type level

    @EJB
    private StatelessSessionBean sless;
    
    @EJB//(name="StatefulSession", beanInterface=StatefulSession.class)
    private StatefulSessionBean sful;

    @Override
    public void service(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        try {

            out.println("<HTML> <HEAD> <TITLE> Servlet & Stateless/StatefulEJBs</TITLE> </HEAD> <BODY BGCOLOR=white>");
            out.println("<CENTER> <FONT size=+1> Servlet2EJBs: Please enter a message </FONT> </CENTER> <p> ");
            out.println("<form method=\"POST\">");
            out.println("<TABLE>");
            out.println("<tr><td>Message for the stateless EJB: </td>");
            out.println("<td><input type=\"text\" name=\"sl_msg\"> </td>");
            out.println("</tr><tr><td></td>");
            out.println("<td><input type=\"submit\" name=\"sub1\"> </td>");
            out.println("</tr>");
            out.println("</TABLE>");
            out.println("</form>");
            
            out.println("<form method=\"POST\">");
            out.println("<TABLE>");
            out.println("<tr><td>Message for the stateful EJB: </td>");
            out.println("<td><input type=\"text\" name=\"sf_msg\"> </td>");
            out.println("</tr><tr><td></td>");
            out.println("<td><input type=\"submit\" name=\"sub2\"> </td>");
            out.println("</tr>");
            out.println("</TABLE>");
            out.println("</form>");
            
            String val = req.getParameter("sl_msg");  
            if ((val != null) && (val.trim().length() > 0)) {
                out.println("<FONT size=+1 color=red> Message back from StatelessSessionBean: </FONT>"
                            + HTMLFilter.filter(sless.bounce(val)) + "<br>");
            }
            else {
                val = req.getParameter("sf_msg");
                
                if ((val != null) && (val.trim().length() > 0)) {
                    out.println("<FONT size=+1 color=red> Message(s) back from StatefulSessionBean: </FONT>"
                                + "<br>"+HTMLFilter.filter(sful.addAndRead(val)).replace("\n", "<br>") + "<br>");
                }
            }
            out.println("</BODY> </HTML> ");

        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("webclient servlet test failed");
            throw new ServletException(ex);
        }
    }
}
