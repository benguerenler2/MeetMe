<%-- 
    Document   : main
    Created on : May 7, 2016, 10:24:58 AM
    Author     : tcagla
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import = "javax.servlet.RequestDispatcher" %>
<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
        <title>TODO supply a title</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        
        <link rel="stylesheet" type="text/css" href="./style/signin.css">     
          <link rel="stylesheet" type="text/css" href="./style/signup.css">  
          <link rel="stylesheet" href="./style/bootstrap.min.css">
        <link rel="stylesheet" href="./style/bootstrap-theme.min.css">
        <script type="text/javascript" src="/js/bootstrap.min.js"></script>
        
        <script src="//code.jquery.com/jquery-1.12.0.min.js"></script>
        <script src="//code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
        <script type="text/javascript">
            function toggleForm()
            {
                if(document.getElementById("form_signin").style.display == "none")
                {
                    document.getElementById("form_signin").style.display='block';
                    document.getElementById("form_signup").style.display='none';
                    document.getElementById("togglebutton").innerHTML='Not a member?';
                }
                else
                {
                    document.getElementById("form_signup").style.display='block';
                    document.getElementById("form_signin").style.display='none';
                    document.getElementById("togglebutton").innerHTML='Already a member?';
                }
                
            }
            /*
            $( document ).ready(function() {
                method = "post"; // Set method to post by default if not specified.
                // method = method || "post";
                path = "./MainController";
                // The rest of this code assumes you are not using a library.
                // It can be made less wordy if you use one.
                var form = document.createElement("form");
                form.setAttribute("method", method);
                form.setAttribute("action", path);
                var hiddenField = document.createElement("input");
                hiddenField.setAttribute("type", "hidden");
                hiddenField.setAttribute("name", "action");
                hiddenField.setAttribute("value", "GetTweet");
                /-*
                for(var key in params) {
                    if(params.hasOwnProperty(key)) {
                        var hiddenField = document.createElement("input");
                        hiddenField.setAttribute("type", "hidden");
                        hiddenField.setAttribute("name", key);
                        hiddenField.setAttribute("value", params[key]);

                        form.appendChild(hiddenField);
                     }
                }
                *-/
                document.body.appendChild(form);
                form.submit();
            });*/
        </script>
    </head>
    <body>
        <form class="form-signin" id="form_signin" method="post" action="./MainPageController">
            <fieldset class="form-group">
                <button class="btn btn-lg btn-primary btn-block" type="submit" name="action" value="CreateEvent">Create Event</button>
            </fieldset>            
            <fieldset class="form-group">
                <button class="btn btn-lg btn-primary btn-block" type="submit" name="action" value="DisplayEvent">Display Event</button>
            </fieldset>          
        </form>
        
        <form class="form-signin" id="form_signin" method="post" action="./SignoutController">
            <button class="btn btn-lg btn-primary btn-block" type="submit" name="action" value="Signout">Sign Out</button>
        </form>
        <%
            /*
            RequestDispatcher rd = request.getRequestDispatcher("/MainController");
            request.setAttribute("pageLoad","getTweets");
            rd.forward(request, response);
            */
        %>
        <% 
            
            //final int userid =  Integer.parseInt((String)request.getAttribute("sessionuid")); 
            //final String tweets =  (String)request.getAttribute("usertweets"); 
            //    out.println(request.getAttribute("usertweets"));
            
        %>
        
    </body>
</html>