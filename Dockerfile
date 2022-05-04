FROM maven:3.8.1-jdk-11

RUN mkdir project
WORKDIR project

RUN git clone https://github.com/vshadrin1991/AutomationShadrin_QA11.git
WORKDIR AutomationShadrin_QA11

RUN mvn clean test -Dsuite="src/test/resources/Lecture_13.xml"