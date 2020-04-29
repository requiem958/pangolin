FROM debian:testing

RUN apt-get update && apt-get full-upgrade -y

RUN apt-get install -y maven openjdk-11-jdk git
RUN git pull https://github.com/requiem958/pangolin.git
RUN cd pangolin && mvn

CMD java -jar target/pangolin-*.jar 
