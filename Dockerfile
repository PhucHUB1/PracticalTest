FROM tomcat:10-jdk17
ADD target/PracticalTest-1.0-SNAPSHOT /usr/local/tomcat/webapps/hello.war
EXPOSE 8080
CMD ["catalina.sh", "run"]