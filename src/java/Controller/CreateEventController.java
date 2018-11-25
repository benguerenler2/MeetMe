/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Logic.EmailSessionBeanLocal;
import Logic.SessionControlBeanLocal;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.Set;
import java.util.TreeSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Activesession;
import model.Gr8Poll;
import model.Gr8PollSlot;
import model.PollVoter;
import model.Useraccount;
import model.accessors.Gr8PollBeanLocal;
import model.accessors.Gr8PollSlotBeanLocal;
import model.accessors.PollVoterBeanLocal;
import model.accessors.UserBeanLocal;

/**
 *
 * @author tcagla
 */
@WebServlet(name = "CreateEventController", urlPatterns = {"/CreateEventController"})
public class CreateEventController extends HttpServlet {

    @EJB
    private SessionControlBeanLocal userSessionBean;
    @EJB
    private Gr8PollBeanLocal pollBean;
    @EJB
    private Gr8PollSlotBeanLocal pollSlotBean;
    @EJB
    private UserBeanLocal userBean;
    @EJB
    private EmailSessionBeanLocal emailBean;
    @EJB
    private PollVoterBeanLocal pollVoterBean;
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

        String eventDesc = request.getParameter("eventDesc");
        String eventName = request.getParameter("eventName");
        String participants = request.getParameter("parList");
        String eventTimeInfo = request.getParameter("eventTimeInfo");
        
        System.out.println(eventDesc+"\n"+eventName+" "+participants+" "+eventTimeInfo);
        
        Activesession authToken = 
                        userSessionBean.findSession(
                                (String) request.getSession()
                                        .getAttribute("authToken")
                        );
        int userid = authToken.getUserid();
        
        if(eventDesc != null && eventName != null && 
                participants !=null && participants.length() > 1 &&// " "(length 1) is set to participants by default
                eventTimeInfo != null && eventTimeInfo.length()>0)
        {
//            Date2: 2016-05-11 createevent.jsp:94:9
//            T3: 07 : 07 createevent.jsp:95:9
//            T4: 09 : 10
            Gr8Poll poll = new Gr8Poll();
            poll.setUserid(userid);
            poll.setEventName(eventName);
            poll.setEventDescription(eventDesc);
            
            poll = pollBean.addPoll(poll);
            
            System.out.println("Poll Info: "+poll.getPollid()+" "+poll.getTs());
            
            
            // Process user selected poll slot
            String[] dateSelection = eventTimeInfo.split("\\]\\[");
            if(dateSelection.length <= 5)
            {
                System.out.println("dateSelection length "+dateSelection.length);
                for(String temp: dateSelection)
                {
                    System.out.println(temp);
                    temp = temp.replaceAll("\\[", "").replaceAll("\\]", "");
                    System.out.println(temp);
                    DateFormat format = new SimpleDateFormat("yyyy-MM-dd','HH : mm");
                    String[] tempDateTime = temp.split(",");
                    if(tempDateTime.length == 3)
                    {
                        try {
                            Date dateStart = format.parse(tempDateTime[0]+","+tempDateTime[1]);
                            System.out.println(dateStart);
                            Date dateEnd = format.parse(tempDateTime[0]+","+tempDateTime[2]);
                            System.out.println(dateEnd);
                            Gr8PollSlot slot = new Gr8PollSlot();
                            slot.setPollid(poll.getPollid());
                            slot.setStartTime(dateStart);
                            slot.setEndTime(dateEnd);
                            format = new SimpleDateFormat("yyyy-MM-dd");
                            slot.setSlotdate(format.parse(tempDateTime[0]));
                            pollSlotBean.addPollSlot(slot);
                        } catch (ParseException ex) {
                            Logger.getLogger(CreateEventController.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
            }
            // Process participants
            participants = participants.trim();
            
            Set<Integer> participantSet = new TreeSet<>();
            for(String temp : participants.split("@"))
                participantSet.add(Integer.parseInt(temp));
            
            System.out.println("Participant Set Size: "+participantSet.size());
            for(int uid : participantSet)
            {
                Useraccount acc = userBean.getUser(uid);
                if(acc != null){
                    pollVoterBean.addPollVoter(new PollVoter(uid, poll.getPollid()));
                    String pollURL = "http://localhost:8080/MEETME/PollController?voter="+uid+"&pollid="+poll.getPollid();

                    String messageBody = "Dear "+acc.getName()+",\n"+
                            "Please vote for the event in the following link.\n"+
                            pollURL+" \nThank you.";
                    emailBean.sendEmail(acc.getEmail(), "Meet Me Poll", messageBody);
                }
            }
        }
        
        request.getRequestDispatcher("main.jsp").forward(request, response);
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
