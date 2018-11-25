/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Logic.AuthBeanLocal;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.accessors.UserBeanLocal;
import model.Useraccount;
import Logic.SessionControlBeanLocal;
import model.Activesession;

/**
 *
 * @author tcagla
 */
@WebServlet(name = "SigninController", urlPatterns = {"/SigninController"})
public class SigninController extends HttpServlet {

@EJB
private UserBeanLocal userBean;
@EJB
private AuthBeanLocal authBean;
@EJB
private SessionControlBeanLocal userSessionBean; 
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username"); 
        System.out.println("username: "+username);
        String password = request.getParameter("password");    
        System.out.println("password: "+password);
        Useraccount temp = userBean.getUserUsername(username);
                if(temp == null)
                {
                    temp = userBean.getUserEmail(username);
                    if(temp != null)
                    {
                        boolean token;
                        if(authBean.checkUser(password, temp))
                        {
                            String sessionToken = userSessionBean.addSession(temp);
                            request.getSession(true).setAttribute("authToken", sessionToken);
                       /*Activesession authToken = 
                        userSessionBean.findSession(
                                (String) request.getSession()
                                        .getAttribute("authToken")
                        );
                        int id = authToken.getUserid();
                        List<Tweets> result = tweetBean.getAllTweets(id);

                        StringBuilder sb = new StringBuilder();

                        sb.append("<ul class=\"list-group\">");
                        for(Tweets tw : result)
                        {
                            sb.append("<li class=\"list-group-item\">"+tw.getTweet()+"</li>");
                        }
                        sb.append("</ul>");
                        request.setAttribute("usertweets", sb.toString());
                        request.getRequestDispatcher("main.jsp").forward(request, response);*/
                            //request.setAttribute("sessionuid", Integer.toString(temp.getUid()));
                            request.getRequestDispatcher("main.jsp").forward(request, response);
                            
                        }
                        else
                        {
                            request.setAttribute("failed", "1");
                            request.getRequestDispatcher("index.jsp").forward(request, response);
                        }
                    }
                    else{
                        request.setAttribute("failed", "1");
                        request.getRequestDispatcher("index.jsp").forward(request, response);
                    }
                }
                else
                {    
                    if(authBean.checkUser(password, temp))
                    {
                        String sessionToken = userSessionBean.addSession(temp);
                        request.getSession(true).setAttribute("authToken", sessionToken);
                        /*Authenticated authToken = 
                            userSessionBean.findSession(
                                    (String) request.getSession()
                                            .getAttribute("authToken")
                            );
                    
                        int id = authToken.getUid();
                        List<Tweets> result = tweetBean.getAllTweets(id);

                        if(result != null){
                            StringBuilder sb = new StringBuilder();

                            sb.append("<ul class=\"list-group\">");
                            for(Tweets tw : result)
                            {
                                sb.append("<li class=\"list-group-item\">"+tw.getTweet()+"</li>");
                            }
                            sb.append("</ul>");
                            request.setAttribute("usertweets", sb.toString());
                        }
                        request.getRequestDispatcher("main.jsp").forward(request, response); 
                        */
                        //request.setAttribute("sessionuid", Integer.toString(temp.getUid()));
                        request.getRequestDispatcher("main.jsp").forward(request, response);
                    }
                    else
                    {
                        request.setAttribute("failed", "1");
                        request.getRequestDispatcher("index.jsp").forward(request, response);
                    }
                }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
