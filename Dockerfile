#get image with maven-chrome and jdk-11
FROM markhobson/maven-chrome:jdk-11

#create project dir
RUN mkdir project
WORKDIR project

#maven
ENV MAVEN_VERSION=apache-maven-3.6.3
RUN wget https://mirrors.estointernet.in/apache/maven/maven-3/3.6.3/binaries/$MAVEN_VERSION-bin.tar.gz
RUN tar -xvf $MAVEN_VERSION-bin.tar.gz
RUN mv $MAVEN_VERSION /opt/

#set maven home
ENV M2_HOME=/opt/apache-maven-3.6.3
ENV PATH=$M2_HOME/bin:$PATH
RUN export PATH

#clone project
ENV PROJECT_NAME=AutomationShadrin_QA11
RUN git clone https://github.com/vshadrin1991/$PROJECT_NAME.git
WORKDIR $PROJECT_NAME

#run tests
RUN mvn clean test -Dsuite="src/test/resources/Lecture_13.xml"