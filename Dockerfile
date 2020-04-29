FROM debian:testing

RUN apt-get update && apt-get full-upgrade -y

RUN apt-get install -y maven && apt-get install -y openjdk-11-jdk

CMD echo coucou
