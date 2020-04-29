FROM maven:3-openjdk-11

RUN apt-get update && apt-get full-upgrade -y

RUN apt-get install git
RUN git clone https://github.com/requiem958/pangolin.git
RUN cd pangolin && mvn

CMD java -jar /pangolin/target/pangolin.jar 
