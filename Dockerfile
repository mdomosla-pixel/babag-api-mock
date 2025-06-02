FROM java:8

MAINTAINER "Karolis Labrencis <karolis@labrencis.lt>"

COPY entrypoint.sh /entrypoint.sh
RUN chmod +x /entrypoint.sh

COPY target/babag-api-mock-*-standalone.jar /babag-api-mock-standalone.jar

# API mimicking the one of real `babag-api`
EXPOSE 9090
# Query API for checking status of sent SMSes
EXPOSE 9191

CMD /entrypoint.sh

