# ReportServer
This is the Broadband plugin for CIAB.

1. Install Java 1.8
2. Install Gradle
3. Install MongoDB
4. git clone https://github.com/urvin-shah/report-server.git
5. cd report-server
6. ./gradlew bootRun
7. Rest APIs

## Installation

 - Install Java 1.8 from oracle site and set the path of of bin directory
 - Follow below step to install MongoDB :
   2.1 Create a directory mongodb
	 	   mkdir mongodb
		   cd mongodb
	 2.2 download mongodb using
	     curl -O http://downloads.mongodb.org/linux/mongodb-linux-x86_64-2.6.3.tgz
			 Extract the mongodb-linux-x86_64-2.6.3.tgz file in mongodb directory
	 2.3 Set path
	     export PATH=$PATH:<Your Home path>/mongodb/mongodb/bin
	 2.4 Create data folder inside the mongodb directory	 		 		 
 Follow below step to install gradle
	  
 - Update the system
	    sudo apt-get update
    	sudo apt-get -y upgrade
 - Download gradle
	   wget https://services.gradle.org/distributions/gradle-2.12-bin.zip
 - Install gradle
	     sudo mkdir /opt/gradle
	     sudo unzip -d /opt/gradle gradle-2.12-bin.zip		 
		 export PATH=$PATH:/opt/gradle/gradle-2.12/bin
 - Execute the mongodb    ./mongod --dbpath <Home
   PATH>/mongodb/mongodb/data &
 - Clone the repository or download zip of report-server	 


----------


## To Run

./gradlew bootRun


----------


## REST APIs
1. **User management**
    1.1 /users : This API list all users
    1.2 /login?userName=admin&pass=admin : This API is used to validate the userName
    1.3 /addUser?userName=<username>&role=<role-name>&pass=<password> : This api is used to add a new user in the database
    1.4 /changePassword?userName=<username>&newPass=<NewPass> : This API is used to change the password
2. **Web Site visit details**
   2.1 /visits : This API is used to display all website visit details
   2.2 /topwebsites?visitDate=2016-01-13 : This API is used to display top 5 visted website on specified date. Date format YYYY-mm-DD
