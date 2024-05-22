FROM tomcat:10-jdk17
ADD target/PracticalTest-1.0-SNAPSHOT /usr/local/tomcat/practicaltest/hello.war
EXPOSE 8080
CMD ["catalina.sh", "run"]