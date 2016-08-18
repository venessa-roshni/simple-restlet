Installation:

1) Git:
sudo apt-get install git
git init 
git clone https://github.com/venessa-roshni/Assignment.git

2) Maven:
sudo apt-get install maven

3) Java:
sudo add-apt-repository ppa:webupd8team/java
sudo apt-get update
sudo apt-get install oracle-java7-installer


4) Jenkins:
wget -q -O - https://pkg.jenkins.io/debian/jenkins-ci.org.key | sudo apt-key add -
sudo sh -c 'echo deb http://pkg.jenkins.io/debian-stable binary/ > /etc/apt/sources.list.d/jenkins.list'
sudo apt-get update
sudo apt-get install jenkins


6) MySQL:
sudo apt-get install mysql-server

Username: root  
Password: root


7)Tomcat:
 sudo apt-get install tomcat7

/var/lib/tomcat7/conf/server.xml (changed port since jenkins runs on 8080)


In the tomcat-users.xml add the following line 
<user username="deployer" password="deployer" roles="manager-script" />
This allows jenkins to deploy the war in tomcat.


Steps to pull the code from git and build and deploy automatically using Jenkins:

1) To clone repository:
   git clone https://github.com/venessa-roshni/simple-restlet.git

2) To connect to database and create new database and tables:
   mysql -u root -p < create.sql


3) Connecting to Jenkins:

http://52.66.124.172:8080
Username:venessa
Password: venessa

To create a new job:  Jenkins configurations

1)To checkout code from git
      Source code management :
        Select git 
        Enter Repository url

2) To maven build
       Build : Invoke top-level maven targets
       Goals: clean install

3) To deploy on tomcat	
       Post build actions: 
          Deploy war/ear to container
          War files:**/target/*.war
          Containers: tomcat 7.x
          Manager : Enter username: deployer , Password: deployer
          Tomcat url 

