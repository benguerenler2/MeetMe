<%-- 
    Document   : poll
    Created on : May 9, 2016, 4:09:07 PM
    Author     : tcagla
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
  <script>
      //$(document).ready(function(){
         var choices = [];
          choices[1] = "NULL";
          choices[2] = "NULL";
          choices[3] = "NULL";        
     // }); 
      function processChoiceButton(choiceID){
        var count =3;  
        while(count>0){
            if(choices[count]==="NULL" && count===3){
                choices[count]=choiceID;
                document.getElementById(choiceID).style.background="#00cc00";
                document.getElementById(choiceID).value=3;
                break;                
            }
            if(choices[count]==="NULL" && count===2){
                choices[count]=choiceID;
                document.getElementById(choiceID).style.background="#ffa500";
                document.getElementById(choiceID).value=2;
                break;
            }
            if(choices[count]==="NULL" && count===1){
                choices[count]=choiceID;
                document.getElementById(choiceID).style.background="#ff6666";
                document.getElementById(choiceID).value=1;
                break;
            }
            count--;
        }
      }
      function processChoice(obj){
            var bVal = obj.value;
            console.log("Choice Button ID: "+obj.id);

            if(bVal==0){
                processChoiceButton(obj.id);
            }
            else{
                choices[bVal]="NULL";
                //obj.value=0;
                document.getElementById(obj.id).value = 0;
                document.getElementById(obj.id).style.background= "#e5e5ff";
            }
        }
        
        function pollSubmit(){
            var buttonValues = "";
            var count =3;  
            while(count>0){
                if(choices[count]!=="NULL")
                    buttonValues += choices[count]+"@"+count;
                
                count--;
            }
            //$('.gr8PollChoice').each(function(i, obj) {
                //var objVal = obj.value;
                //if(objVal > 0)
                //{
              //      buttonValues += obj.id+"@"+obj.value;
                //}
            //});
            if(buttonValues.length > 0){
                document.getElementById("votesHidden").value = buttonValues;
                return true;
            }
            else
            {
                alert("Please vote for at least 1 slot!");
                return false;
            }
        }
      </script>
          <style>
        .container-choices {
            max-width: 330px;
            padding: 15px;
            margin: 0 auto;
        }
        div.button{
       
            color: purple;
         //color: "#e5e5ff";
        }
    </style>
    </head>
    <body>
        <form class="form-group" id="form_poll" method="post" action="./PollController">
            <div class="container" id="container-choices">
            <div class="col-lg-10 col-md">
                <%
                out.println(request.getAttribute("pollHTML"));
                %>
                <!--
                <button class="btn btn-lg btn-block gr8PollChoice" type="button" id="cb1" value=0 onclick="processChoice(this)" >Button1</button>
                <button class="btn btn-lg btn-block gr8PollChoice" type="button" id="cb2" value=0 onclick="processChoice(this)" >Button 2</button>
                <button class="btn btn-lg btn-block gr8PollChoice" type="button" id="cb3" value=0 onclick="processChoice(this)" >Button 3</button>
                <button class="btn btn-lg btn-block gr8PollChoice" type="button" id="cb4" value=0 onclick="processChoice(this)" >Button4</button>
                <button class="btn btn-lg btn-block gr8PollChoice" type="button" id="cb5" value=0 onclick="processChoice(this)" >Button5</button>
                -->
                <input type="hidden" name="votesHidden" id="votesHidden">
                <button class="btn btn-lg btn-primary btn-block" type="submit" onclick="return pollSubmit();" id="submitPoll" name="submitPoll" value="SUBMITPOLL">SUBMIT POLL</button>
            </div>
                
            </div>
        </form>
    </body>

</html>
