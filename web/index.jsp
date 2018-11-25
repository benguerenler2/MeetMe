<%-- 
    Document   : index
    Created on : May 6, 2016, 7:32:07 PM
    Author     : tcagla
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
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
        </script>
    </head>
    <body>
        <% 
            final String failed = (String) request.getAttribute("failed"); 
            if(failed != null && failed.equals("1")){
                out.println("Failed signin");
            }
        %>
        <div id="signin" class="container">
            <form class="form-signin" id="form_signin" method="post" action="./SigninController">
                <h2 class="form-signin-heading">Please sign in</h2>
                
                <label for="username" class="sr-only">User name / Email address</label>
                <input type="text" id="username" name="username" class="form-control" placeholder="User name / Email address" required autofocus>
                
                <label for="password" class="sr-only">Password</label>
                <input type="password" id="password" name="password" class="form-control" placeholder="Password" required autofocus>
                
                <button class="btn btn-lg btn-primary btn-block" type="submit" name="action" value="Signin">Sign in</button>
            </form>
        </div>
        <div id="signup" class="container">
            <form class="form-signup" id="form_signup" method="post" action="./SignupController" style="display: none">
                <h2 class="form-signup-heading">Please register</h2>
                
                <label for="firstname" class="sr-only">First name</label>
                <input type="text" id="firstname" name="firstname" class="form-control" placeholder="First name" required autofocus>
                
                <label for="lastname" class="sr-only">Last name</label>
                <input type="text" id="lastname" name="lastname" class="form-control" placeholder="Last name" required autofocus>
                
                <label for="username" class="sr-only">User name</label>
                <input type="text" id="username" name="username" class="form-control" placeholder="User name" required autofocus>
                
                <label for="email" class="sr-only">Email address</label>
                <input type="email" id="email" name="email" class="form-control" placeholder="Email address" required autofocus>
                
                <label for="password" class="sr-only">Password</label>
                <input type="password" id="password" name="password" class="form-control" placeholder="Password" required autofocus>
                
                <label for="password2" class="sr-only">Password</label>
                <input type="password" id="password2" name="password2" class="form-control" placeholder="Password" required autofocus>
                
                <button class="btn btn-lg btn-primary btn-block" type="submit" name="action" value="Signup">Sign up</button>
            </form>
            <button id="togglebutton" 
                    class="btn btn-lg btn-primary btn-block togglebutton" 
                    value=0 type="button" 
                    onclick="toggleForm()">Not a member?</button>
        </div>
    </body>
</html>
