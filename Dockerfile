FROM debian:testing

RUN apt-get update && apt-get full-upgrade -y

RUN apt-get install -y maven openjdk-11-jdk

RUN mvn 

CMD java -jar 
