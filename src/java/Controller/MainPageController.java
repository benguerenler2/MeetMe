/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Logic.SessionControlBeanLocal;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Activesession;
import model.Event;
import model.Gr8Poll;
import model.Gr8PollSlot;
import model.Vote;
import model.accessors.EventBeanLocal;
import model.accessors.Gr8PollBeanLocal;
import model.accessors.Gr8PollSlotBeanLocal;
import model.accessors.VoteBeanLocal;

/**
 *
 * @author tcagla
 */
@WebServlet(name = "MainPageController", urlPatterns = {"/MainPageController"})
public class MainPageController extends HttpServlet {
    @EJB
    private SessionControlBeanLocal userSessionBean;
    @EJB
    private EventBeanLocal eventBean;
    @EJB
    private Gr8PollBeanLocal pollBean;
    @EJB
    private Gr8PollSlotBeanLocal pollSlotBean;
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
        response.setContentType("text/html;charset=UTF-8");
        String action = request.getParameter("action");
        switch(action){
            case "CreateEvent":
                request.getRequestDispatcher("createevent.jsp").forward(request, response);
                break;
            case "DisplayEvent":
            {
                Activesession authToken = 
                        userSessionBean.findSession(
                                (String) request.getSession()
                                        .getAttribute("authToken")
                        );
                int userid = authToken.getUserid();
                
                
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");
                
                List<Event> eventList = eventBean.getByUserid(userid);
                StringBuilder sb = new StringBuilder();
                sb.append("<div class=\"list-group\">\n" +
                    "<h4 class=\"list-group-item-heading\">Events</h4>\n");
                for(Event tempEvent:eventList){
                    sb.append(
                    "<p class=\"list-group-item-text\">"+tempEvent.getEventName()
                            +" Date: "+dateFormat.format(tempEvent.getEventdate())+", "+
                            timeFormat.format(tempEvent.getEventTime())
                            +"</p>\n"
                    );
                }
                
                sb.append("<h4 class=\"list-group-item-heading\">Polls</h4>\n");
                
                List<Gr8Poll> pollList = pollBean.getByUserid(userid);
                for(Gr8Poll tempPoll : pollList)
                {
                    List<Vote> voteList = voteBean.getByPollid(tempPoll.getPollid());
                    SortedMap m = Collections.synchronizedSortedMap(new TreeMap<Integer,Integer>());
                    for(Vote tempVote: voteList)
                    {
                        if(m.get(tempVote.getVotePK().getSlotid())== null)
                        {
                            m.put(tempVote.getVotePK().getSlotid(), tempVote.getVotePK().getWeight());
                        }
                        else{
                            int sum = (int) m.get(tempVote.getVotePK().getSlotid())+tempVote.getVotePK().getWeight();
                            m.put(tempVote.getVotePK().getSlotid(), sum);
                        }
                    }
                    
                    List<Gr8PollSlot> pollSlotList = pollSlotBean.getByPollid(tempPoll.getPollid());
                    sb.append("<p class=\"list-group-item-text\">");
                    sb.append("<div class=\"list-group\">\n" +
                        "<h4 class=\"list-group-item-heading\">"+tempPoll.getEventName()+"</h4>\n");
                    
                    for(Gr8PollSlot tempPollSlot: pollSlotList)
                    {
                        sb.append("<p class=\"list-group-item-text\">"+
                                dateFormat.format(tempPollSlot.getSlotdate())+", "+
                                timeFormat.format(tempPollSlot.getStartTime())+" - "+
                                timeFormat.format(tempPollSlot.getEndTime())+" Votes: "+
                                m.get(tempPollSlot.getSlotid())+
                                "</p>\n"
                        );    
                    }
                    
                    sb.append("</p>\n");
                }
                
                sb.append("</div>");
            
            request.setAttribute("displayEventContent", sb.toString());
            request.getRequestDispatcher("displayEvents.jsp").forward(request, response);
            }    
            break;
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
