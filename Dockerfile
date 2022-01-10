FROM couchbase as db
WORKDIR /opt/couchbase
COPY configure-server.sh .
CMD ["/opt/couchbase/configure-server.sh"]


FROM openjdk:11 as app
WORKDIR /hepsiemlak_web_api
ADD  target/studycase-0.0.1-SNAPSHOT.jar .
CMD [ "java","-jar","/hepsiemlak_web_api/studycase-0.0.1-SNAPSHOT.jar" ]

