<%-- 
    Document   : createevent
    Created on : May 7, 2016, 2:18:34 PM
    Author     : tcagla
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>TODO supply a title</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        
        <link rel="stylesheet" href="https://formden.com/static/cdn/bootstrap-iso.css" /> 

<!--Font Awesome (added because you use icons in your prepend/append)-->
<link rel="stylesheet" href="https://formden.com/static/cdn/font-awesome/4.4.0/css/font-awesome.min.css" />

<!-- Inline CSS based on choices in "Settings" tab -->
<style>.bootstrap-iso .formden_header h2, .bootstrap-iso .formden_header p, .bootstrap-iso form{font-family: Arial, Helvetica, sans-serif; color: black}.bootstrap-iso form button, .bootstrap-iso form button:hover{color: white !important;} .asteriskField{color: red;}</style>
        
        <link rel="stylesheet" type="text/css" href="./style/signin.css">     
          <link rel="stylesheet" type="text/css" href="./style/signup.css">  
          <link rel="stylesheet" type="text/css" href="./style/event.css"> 
          <link rel="stylesheet" href="./style/bootstrap.min.css">
        <link rel="stylesheet" href="./style/bootstrap-theme.min.css">
        <script type="text/javascript" src="/js/bootstrap.min.js"></script>
        
        <script src="//code.jquery.com/jquery-1.12.0.min.js"></script>
        <script src="//code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
        
        <script>
	$(document).ready(function() {
		$('.nav-pills > li > a').click(function(event){
		event.preventDefault();//stop browser to take action for clicked anchor
					
		//get displaying tab content jQuery selector
		var active_tab_selector = $('.nav-pills > li.active > a').attr('href');					
					
		//find actived navigation and remove 'active' css
		var actived_nav = $('.nav-pills > li.active');
		actived_nav.removeClass('active');
					
		//add 'active' css into clicked navigation
		$(this).parents('li').addClass('active');
					
		//hide displaying tab content
		$(active_tab_selector).removeClass('active');
		$(active_tab_selector).addClass('hide');
					
		//show target tab content
		var target_tab_selector = $(this).attr('href');
		$(target_tab_selector).removeClass('hide');
		$(target_tab_selector).addClass('active');
	     });
	  });
	</script>
 <!-- Extra JavaScript/CSS added manually in "Settings" tab -->
<!-- Include jQuery -->
<script type="text/javascript" src="https://code.jquery.com/jquery-1.11.3.min.js"></script>

<!-- Include Date Range Picker -->
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/js/bootstrap-datepicker.min.js"></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/css/bootstrap-datepicker3.css"/>
<link type="text/css" href="css/bootstrap.min.css" />
        <link type="text/css" href="css/bootstrap-timepicker.min.css" />
        <script type="text/javascript" src="js/jquery.min.js"></script>
        <script type="text/javascript" src="js/bootstrap.min.js"></script>
        <script type="text/javascript" src="js/bootstrap-timepicker.min.js"></script>
<script>
    var participantList = "0";
    var timeRow = 1;
    function addTimeRow(){
        if(timeRow<5){
        timeRow += 1;
        document.getElementById("row"+timeRow).style.display='block';
        }
    }
    function addToParticipantList(obj){
        var bVal = obj.value;
        participantList += "@" + bVal;
        var elm = document.getElementById("pli"+bVal);
        elm.parentNode.removeChild(elm);
        console.log("ParticipantList: "+participantList);
    }
    function checkSubmit()
    {
        document.getElementById("parList").value = participantList;
        var timeInfos = "";
        var sDate1 = document.getElementById("date1").value;
        var sTimeS1 = document.getElementById("timepicker-one").value;
        var sTimeS2 = document.getElementById("timepicker-two").value;
        console.log("Date1: "+ sDate1);
        console.log("T1: "+ sTimeS1);
        console.log("T2: "+ sTimeS2);
        timeInfos += "["+sDate1+","+sTimeS1+","+sTimeS2+"]";
        var sDate2 = document.getElementById("date2").value;
        var sTimeS3 = document.getElementById("timepicker-three").value;
        var sTimeS4 = document.getElementById("timepicker-four").value;
        timeInfos += "["+sDate2+","+sTimeS3+","+sTimeS4+"]";
        console.log("Date2: "+ sDate2);
        console.log("T3: "+ sTimeS3);
        console.log("T4: "+ sTimeS4);
        var sDate3 = document.getElementById("date3").value;
        var sTimeS5 = document.getElementById("timepicker-five").value;
        var sTimeS6 = document.getElementById("timepicker-six").value;
        timeInfos += "["+sDate3+","+sTimeS5+","+sTimeS6+"]";
        console.log("Date3: "+ sDate3);
        console.log("T5: "+ sTimeS5);
        console.log("T6: "+ sTimeS6);
        var sDate4 = document.getElementById("date4").value;
        var sTimeS7 = document.getElementById("timepicker-seven").value;
        var sTimeS8 = document.getElementById("timepicker-eight").value;
        timeInfos += "["+sDate4+","+sTimeS7+","+sTimeS8+"]";
        console.log("Date4: "+ sDate4);
        console.log("T7: "+ sTimeS7);
        console.log("T8: "+ sTimeS8);
        var sDate5 = document.getElementById("date5").value;
        var sTimeS9 = document.getElementById("timepicker-nine").value;
        var sTimeS10 = document.getElementById("timepicker-ten").value;
        timeInfos += "["+sDate5+","+sTimeS9+","+sTimeS10+"]";
        console.log("Date5: "+ sDate5);
        console.log("T9: "+ sTimeS9);
        console.log("T10: "+ sTimeS10);
        console.log("Total: "+timeInfos);
        
        document.getElementById("eventTimeInfo").value = timeInfos;
        
        return true;
    }
    $(document).ready(function(){
		var date_input=$('input[name="date1"]'); //our date input has the name "date"
		var container=$('.bootstrap-iso form').length>0 ? $('.bootstrap-iso form').parent() : "body";
                var nowDate = new Date();
                var today = new Date(nowDate.getFullYear(), nowDate.getMonth(), nowDate.getDate()+1, 0, 0, 0, 0);
		date_input.datepicker({
			format: 'yyyy-mm-dd',
			container: container,
			todayHighlight: true,
			autoclose: true,
                        startDate: today,
                        orientation: 'top auto',
		})
            })
    $(document).ready(function(){
		var date_input=$('input[name="date2"]'); //our date input has the name "date"
		var container=$('.bootstrap-iso form').length>0 ? $('.bootstrap-iso form').parent() : "body";
                var nowDate = new Date();
                var today = new Date(nowDate.getFullYear(), nowDate.getMonth(), nowDate.getDate()+1, 0, 0, 0, 0);
		date_input.datepicker({
			format: 'yyyy-mm-dd',
			container: container,
			todayHighlight: true,
			autoclose: true,
                        startDate: today,
                        orientation: 'top auto',
		})
            })
                $(document).ready(function(){
		var date_input=$('input[name="date3"]'); //our date input has the name "date"
		var container=$('.bootstrap-iso form').length>0 ? $('.bootstrap-iso form').parent() : "body";
                var nowDate = new Date();
                var today = new Date(nowDate.getFullYear(), nowDate.getMonth(), nowDate.getDate()+1, 0, 0, 0, 0);
		date_input.datepicker({
			format: 'yyyy-mm-dd',
			container: container,
			todayHighlight: true,
			autoclose: true,
                        startDate: today,
                        orientation: 'top auto',
		})
            })
                $(document).ready(function(){
		var date_input=$('input[name="date4"]'); //our date input has the name "date"
		var container=$('.bootstrap-iso form').length>0 ? $('.bootstrap-iso form').parent() : "body";
                var nowDate = new Date();
                var today = new Date(nowDate.getFullYear(), nowDate.getMonth(), nowDate.getDate()+1, 0, 0, 0, 0);
		date_input.datepicker({
			format: 'yyyy-mm-dd',
			container: container,
			todayHighlight: true,
			autoclose: true,
                        startDate: today,
                        orientation: 'top auto',
		})
            })
                $(document).ready(function(){
		var date_input=$('input[name="date5"]'); //our date input has the name "date"
		var container=$('.bootstrap-iso form').length>0 ? $('.bootstrap-iso form').parent() : "body";
                var nowDate = new Date();
                var today = new Date(nowDate.getFullYear(), nowDate.getMonth(), nowDate.getDate()+1, 0, 0, 0, 0);
		date_input.datepicker({
			format: 'yyyy-mm-dd',
			container: container,
			todayHighlight: true,
			autoclose: true,
                        startDate: today,
                        orientation: 'top auto',
		})
            })
        
</script>     

</script>

    </head>
    <body>
        
    <div id="EventCreate" class="container">
    <form class="form-eventcreate" id="form_eventcreate" method="post" action="./CreateEventController">
    <ul  class="nav nav-pills">
        <li class="active">
        <a  href="#1a" data-toggle="tab">Event Description</a>
        </li>
        <li><a href="#2a" data-toggle="tab">Choose Participants</a>
        </li>
        <li><a href="#3a" data-toggle="tab">Choose Time For the Poll</a>
        </li>
        </ul>

            <div class="tab-content clearfix">
                    <div class="tab-pane active" id="1a">
                        
                        <div class="form-group">
                           <label for="eventName" text>Event Name:</label>
                            <input type="text" class="form-control" id="eventName" name="eventName">
                            <label for="eventDesc">Description:</label>
                            <textarea class="form-control" rows="5" id="eventDesc" name="eventDesc"></textarea>
                        </div>
                    </div>
            <div class="tab-pane" id="2a">
                <div class="row">
                <div class="col-lg-6">
                  <div class="input-group">
                    <input type="text" id="participantSearchBox" name="participantSearchBox" class="form-control" placeholder="Search for Participants">
                    
                      
                                       
                  </div><!-- /input-group -->
                </div><!-- /.col-lg-6 -->
              </div><!-- /.row -->
              
                    <div id="fss_callList" class="row col-lg-6">

                    </div>
            </div>
            <div class="tab-pane" id="3a">
                <div class="container-fluid">
                    <div class="row" id="row1">
                        <div class="col-md-3 col-sm-3 col-xs-6">
                            <div class="form-group ">
                            <label class="control-label col-sm-2 requiredField" for="date1">Date<span class="asteriskField">*</span></label>
                            <div class="col-sm-10">
                                <div class="input-group">
                                    <div class="input-group-addon">
                                    <i class="fa fa-calendar"></i>
                                    </div>
                            <input class="form-control" id="date1" name="date1" placeholder="YYYY-MM-DD" type="text"/>
                                </div>
                            </div>
                            </div>

                        </div>
                        <label for="usr">Choice 1: </label> 
                     <label for="startTime"><span>Start Time<span class="asteriskField">*</span></span>
                <input type="text" id="timepicker-one" name="timepicker-one" class="timepicker"/>
                </label>
                <label for="endTime"><span>End Time<span class="asteriskField">*</span></span>
                <input type="text" id="timepicker-two" name="timepicker-two" class="timepicker"/>
                </label>
                    </div>
                <div class="row" id="row2" style="display: none">
                        <div class="col-md-3 col-sm-3 col-xs-6">
                            <div class="form-group ">
                            <label class="control-label col-sm-2 requiredField" for="date2">Date<span class="asteriskField">*</span></label>
                            <div class="col-sm-10">
                                <div class="input-group">
                                    <div class="input-group-addon">
                                    <i class="fa fa-calendar"></i>
                                    </div>
                            <input class="form-control" id="date2" name="date2" placeholder="YYYY-MM-DD" type="text"/>
                                </div>
                            </div>
                            </div>

                        </div>
                        <label for="usr">Choice 2: </label>
                     <label for="startTime"><span>Start Time<span class="asteriskField">*</span> </span>
                <input type="text" id="timepicker-three" name="timepicker-three" class="timepicker"/>
                </label>
                <label for="endTime"><span>End Time<span class="asteriskField">*</span> </span>
                <input type="text" id="timepicker-four" name="timepicker-four" class="timepicker"/>
                </label>
                    </div>
                    <div class="row" id="row3" style="display: none">
                        <div class="col-md-3 col-sm-3 col-xs-6">
                            <div class="form-group ">
                            <label class="control-label col-sm-2 requiredField" for="date3">Date<span class="asteriskField">*</span></label>
                            <div class="col-sm-10">
                                <div class="input-group">
                                    <div class="input-group-addon">
                                    <i class="fa fa-calendar"></i>
                                    </div>
                            <input class="form-control" id="date3" name="date3" placeholder="YYYY-MM-DD" type="text"/>
                                </div>
                            </div>
                            </div>

                        </div>
                      <label for="usr">Choice 3: </label>
                     <label for="startTime"><span>Start Time<span class="asteriskField">*</span></span>
                <input type="text" id="timepicker-five" name="timepicker-five" class="timepicker"/>
                </label>
                <label for="endTime"><span>End Time<span class="asteriskField">*</span> </span>
                <input type="text" id="timepicker-six" name="timepicker-six" class="timepicker"/>
                </label>
                    </div>
                    <div class="row" id="row4" style="display: none">
                        <div class="col-md-3 col-sm-3 col-xs-6">
                            <div class="form-group ">
                            <label class="control-label col-sm-2 requiredField" for="date4">Date<span class="asteriskField">*</span></label>
                            <div class="col-sm-10">
                                <div class="input-group">
                                    <div class="input-group-addon">
                                    <i class="fa fa-calendar"></i>
                                    </div>
                            <input class="form-control" id="date4" name="date4" placeholder="YYYY-MM-DD" type="text"/>
                                </div>
                            </div>
                            </div>

                        </div>
                        <label for="usr">Choice 4: </label>
                     <label for="startTime"><span>Start Time<span class="asteriskField">*</span></span>
                <input type="text" id="timepicker-seven" name="timepicker-seven" class="timepicker"/>
                </label>
                <label for="endTime"><span>End Time<span class="asteriskField">*</span></span>
                <input type="text" id="timepicker-eight" name="timepicker-eight" class="timepicker"/>
                </label>
                    </div>
                    <div class="row" id="row5" style="display: none">
                        <div class="col-md-3 col-sm-3 col-xs-6">
                            <div class="form-group ">
                            <label class="control-label col-sm-2 requiredField" for="date5">Date<span class="asteriskField">*</span></label>
                            <div class="col-sm-10">
                                <div class="input-group">
                                    <div class="input-group-addon">
                                    <i class="fa fa-calendar"></i>
                                    </div>
                            <input class="form-control" id="date5" name="date5" placeholder="YYYY-MM-DD" type="text"/>
                                </div>
                            </div>
                            </div>

                        </div>
                     <label for="usr">Choice 5: </label>
                     <label for="startTime"><span>Start Time<span class="asteriskField">*</span> </span>
                <input type="text" id="timepicker-nine" name="timepicker-nine" class="timepicker"/>
                </label>
                <label for="endTime"><span>End Time<span class="asteriskField">*</span> </span>
                <input type="text" id="timepicker-ten" name="timepicker-ten" class="timepicker"/>
                </label>
                    </div>
                    </div>
                
       <%--         <!-- time picker -->
                <div class= "row" id="row1"> 
                     <label for="usr">Choice 1: </label> 
                     <label for="startTime"><span>Start Time: </span>
                <input type="text" id="timepicker-one" name="timepicker-one" class="timepicker"/>
                </label>
                <label for="endTime"><span>End Time: </span>
                <input type="text" id="timepicker-two" name="timepicker-two" class="timepicker"/>
                </label>
                    <!--  <button class="btn btn-lg btn-primary btn-block" type="submit" id="moreTime1" name="moreTime1" value="AddMoreTime">Add More Time</button> -->
                
                </div>
                <div class="row" id="row2"> 
                     <label for="usr">Choice 2: </label>
                     <label for="startTime"><span>Start Time: </span>
                <input type="text" id="timepicker-three" name="timepicker-three" class="timepicker"/>
                </label>
                <label for="endTime"><span>End Time: </span>
                <input type="text" id="timepicker-four" name="timepicker-four" class="timepicker"/>
                </label>
                     <!-- <button class="btn btn-lg btn-primary btn-block" type="submit" id="moreTime2" name="moreTime2" value="AddMoreTime">Add More Time</button> -->
                </div>
                <div class="row" id="row3"> 
                     <label for="usr">Choice 3: </label>
                     <label for="startTime"><span>Start Time: </span>
                <input type="text" id="timepicker-five" name="timepicker-five" class="timepicker"/>
                </label>
                <label for="endTime"><span>End Time: </span>
                <input type="text" id="timepicker-six" name="timepicker-six" class="timepicker"/>
                </label>
                     <!-- <button class="btn btn-lg btn-primary btn-block" type="submit" id="moreTime3" name="moreTime3" value="AddMoreTime">Add More Time</button> -->
                </div>
                <div class="row" id="row4"> 
                     <label for="usr">Choice 4: </label>
                     <label for="startTime"><span>Start Time: </span>
                <input type="text" id="timepicker-seven" name="timepicker-seven" class="timepicker"/>
                </label>
                <label for="endTime"><span>End Time: </span>
                <input type="text" id="timepicker-eight" name="timepicker-eight" class="timepicker"/>
                </label>
                  <!--  <button class="btn btn-lg btn-primary btn-block" type="submit" id="moreTime4" name="moreTime4" value="AddMoreTime">Add More Time</button> -->
                </div>
                <div class="row" id="row5"> 
                     <label for="usr">Choice 5: </label>
                     <label for="startTime"><span>Start Time: </span>
                <input type="text" id="timepicker-nine" name="timepicker-nine" class="timepicker"/>
                </label>
                <label for="endTime"><span>End Time: </span>
                <input type="text" id="timepicker-ten" name="timepicker-ten" class="timepicker"/>
                </label>
                    <button class="btn btn-lg btn-primary btn-block" type="submit" id="moreTime5" name="moreTime5" value="AddMoreTime">Add More Time</button>
                </div> --%>
                <button class="btn btn-lg btn-primary btn-block" type="button" id="moreTime" name="moreTime" onclick="addTimeRow()" value="AddMoreTime">Add More Time</button>
                <button class="btn btn-lg btn-primary btn-block" type="submit" onclick="return checkSubmit();" id="submitPoll" name="submitPoll" value="SUBMITPOLL">SUBMIT POLL</button>
                <input type="hidden" name="parList" id="parList">
                <input type="hidden" name="eventTimeInfo" id="eventTimeInfo">
            </div>
    </div>
    </form>
    </div>
                <script type="text/javascript" src="javascript/smooth_scroll.js"></script>
                <script type="text/javascript" src="js/wickedpicker.js"></script>
                <link rel="stylesheet" href="css/wickedpicker.css">
                <script  type="text/javascript">$('.timepicker').wickedpicker({twentyFour: true});</script>
               <!--<div class="input-group bootstrap-timepicker timepicker ">
                   <%-- <div id="timepicker" class="input-append"> --%>
                    <label for="usr">Choice 1:</label>
                     <div class="input-group">
                                    <div class="input-group-addon">
                                     <i class="fa fa-clock-o" aria-hidden="true"></i>
                                    </div>
                     <label for="startTime"><span>Start Time: </span>
                         <input class="form-control" id="timerange" name="timerange" data-provide="timepicker" data-template="modal" data-minute-step="1" data-modal-backdrop="true" data-format="hh:mm:ss" placeholder="HH:MM:SS" type="text">
                     </label>
                    <label for="startTime"><span>End Time: </span>
                        <input class="form-control" id="timerange2" name="timerange2" data-provide="timepicker" data-template="modal" data-minute-step="1" data-modal-backdrop="true" data-format="hh:mm:ss" placeholder="HH:MM:SS" type="text">
                     </label>

                  <input class="form-control" id="timerange" name="timerange" data-provide="timepicker" data-template="modal" data-minute-step="1" data-modal-backdrop="true" data-format="hh:mm:ss" placeholder="HH:MM:SS" type="text">
                  <span class="add-on">
                    <i data-time-icon="icon-time">
                    </i>

                  </span>

                </div>
                </div>-->

    
    
        <script>    $( "#participantSearchBox" ).keyup(function() {
            var text = document.getElementById("participantSearchBox").value;
            console.log( "Handler for .keypress() called." );
            console.log("Input text: "+text); 
            //document.getElementById("fss_callList").innerHTML = text;
            //$.post("http://localhost:8080/GR8WS/resources/pss", {});
            $.ajax({
               type: 'POST',
               url: "http://localhost:8080/GR8WS/resources/pss",
               data: "searchText="+text,
               success: function(data, textStatus, jqXHR){
                   document.getElementById("fss_callList").innerHTML = data;
               },
               
               error: function(jqXHR, textStatus, errorThrown){
                   alert("fss Webservice call failed!");
               }
            });
    });
</script>
    </body>
</html>
