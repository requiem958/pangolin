FROM maven:3-openjdk-11

COPY . /pangolin
WORKDIR /pangolin

RUN apt-get update && apt-get full-upgrade -y

RUN mvn

CMD java -jar /pangolin/target/pangolin.jar 
