# MeetMe
The MeetMe is a web application for arranging meetings efficiently to help choose prospective meeting times. In order to perform the purpose of the software, the components needed are database server to store and maintain the user and poll data, application server that communicates with Google Calendar information and web server.

Participants votes on offered dates and time slots which means the system needs its users, a website and a database to store users’ information and poll information. The actions take place is in the following order. First the user uses browser and browser sends a request to the web server. Then Web server is forwarded to an application server. The web application requests information from the database server. At the end, the response is passed back up the chain to the browser. Then it is displayed on the browser.

Therefore, the architecture design we have picked the Three-Tier Architecture that meets with our needs and the requirements of the system.
