FROM tomcat:8.5-alpine
CMD ["mkdir", "app"]
WORKDIR app/
COPY target/usermanager-0.0.1-SNAPSHOT.war app/usermanager-app.war
EXPOSE 8082
RUN sh -c 'touch app/usermanager-app.war'
ENTRYPOINT [ "sh", "-c", "java -jar app/usermanager-app.war" ]