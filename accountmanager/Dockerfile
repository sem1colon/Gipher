FROM java:8-jre
WORKDIR usr/src
ENV MYSQL_DATABASE=gipherdb
ENV MYSQL_USER=gipheruser
ENV MYSQL_PASSWORD=gipherpwd
ENV MYSQL_CI_URL=jdbc:mysql://localhost:3306/gipherdb
ADD ./target/accountmanager-1.0.jar /usr/src/accountmanager-1.0.jar
ENTRYPOINT ["java", "-jar", "accountmanager-1.0.jar"]
