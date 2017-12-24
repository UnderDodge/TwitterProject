FROM sgrio/java-oracle
MAINTAINER Speedwagon IO-44
RUN apt-get update
RUN apt-get install -y maven
COPY pom.xml /usr/local/service/pom.xml
COPY src /usr/local/service/src
WORKDIR /usr/local/service
RUN mvn package
CMD ["java","-cp","target/TwitterProject-1.0-SNAPSHOT.jar", "sample.Main"]