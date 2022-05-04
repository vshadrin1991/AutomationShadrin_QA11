FROM markhobson/maven-chrome:jdk-11

RUN mkdir project
WORKDIR project

RUN wget https://mirrors.estointernet.in/apache/maven/maven-3/3.6.3/binaries/apache-maven-3.6.3-bin.tar.gz
RUN tar -xvf apache-maven-3.6.3-bin.tar.gz
RUN mv apache-maven-3.6.3 /opt/
ENV M2_HOME=/opt/apache-maven-3.6.3
ENV PATH=$M2_HOME/bin:$PATH
RUN export PATH

RUN git clone https://github.com/vshadrin1991/AutomationShadrin_QA11.git
WORKDIR AutomationShadrin_QA11

RUN mvn clean test -Dsuite="src/test/resources/Lecture_13.xml"

#FROM maven:3.8.1-jdk-11

#RUN mkdir project
#WORKDIR project


#RUN git clone https://github.com/vshadrin1991/AutomationShadrin_QA11.git
#WORKDIR AutomationShadrin_QA11

#RUN mvn clean test -Dsuite="src/test/resources/Lecture_13.xml"