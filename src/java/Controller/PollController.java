/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.StringTokenizer;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Gr8Poll;
import model.Gr8PollSlot;
import model.Vote;
import model.accessors.Gr8PollBeanLocal;
import model.accessors.Gr8PollSlotBeanLocal;
import model.accessors.VoteBeanLocal;

/**
 *
 * @author tcagla
 */
@WebServlet(name = "PollController", urlPatterns = {"/PollController"})
public class PollController extends HttpServlet {

    @EJB
    private Gr8PollSlotBeanLocal pollSlotBean;
    @EJB
    private Gr8PollBeanLocal pollBean;
    @EJB
    private VoteBeanLocal voteBean;
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
        String action = request.getParameter("submitPoll");
        
        if(action == null)
        {
            String voterid = request.getParameter("voter");
            String pollid = request.getParameter("pollid");
            System.out.println("Voterid: "+voterid);
            System.out.println("Pollid: "+pollid);
            if(voterid != null && pollid != null)
            {
                request.getSession(true).setAttribute("voterid", voterid);
                request.getSession(true).setAttribute("pollid", pollid);

                List<Gr8PollSlot> pollTimes = pollSlotBean.getByPollid(Integer.parseInt(pollid));
                Gr8Poll poll = pollBean.getByPollid(Integer.parseInt(pollid));

                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");
                StringBuilder sb = new StringBuilder();
                sb.append("<div class=\"list-group\">\n" +
                    "<h4 class=\"list-group-item-heading\">Event</h4>\n" +
                    "<p class=\"list-group-item-text\">"+poll.getEventName()+"</p>\n" +
                        "<h4 class=\"list-group-item-heading\">Description</h4>\n" +
                    "<p class=\"list-group-item-text\">"+poll.getEventDescription()+"</p>\n" +
                    "</div>");
                for(Gr8PollSlot temp : pollTimes)
                {
                    sb.append("<button class=\"btn btn-lg btn-block gr8PollChoice\" "
                            + "type=\"button\" id=\"cb"+temp.getSlotid()+"\" value=0"
                            + " onclick=\"processChoice(this)\" >"+
                            dateFormat.format(temp.getSlotdate())+", "+
                            timeFormat.format(temp.getStartTime())+" - "+
                            timeFormat.format(temp.getEndTime())+
                            "</button>");
                }
                request.setAttribute("pollHTML", sb.toString());
                request.getRequestDispatcher("poll.jsp").forward(request, response);
            }
            else{
                request.getRequestDispatcher("main.jsp").forward(request, response);
            }
        }
        else if(action != null && action.equals("SUBMITPOLL"))
        {
            int vid = Integer.parseInt((String)request.getSession().getAttribute("voterid"));
            int poid = Integer.parseInt((String)request.getSession().getAttribute("pollid"));
                
            String votes = request.getParameter("votesHidden");
            System.out.println("Votes: "+votes);
            //cb9@3cb10@2cb11@1
            // 9@3 10@2 11@1
            votes = votes.replaceAll("cb", " ");
            StringTokenizer tokenizer = new StringTokenizer(votes);
            String token = null;
            while(tokenizer.hasMoreTokens())
            {
                token = tokenizer.nextToken();
                System.out.println(token);
                String[] elements = token.split("@");
                voteBean.castVote(new Vote(vid, poid,
                        Integer.parseInt(elements[0]),
                        Integer.parseInt(elements[1])));
            }
            request.getRequestDispatcher("index.jsp").forward(request, response);
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
