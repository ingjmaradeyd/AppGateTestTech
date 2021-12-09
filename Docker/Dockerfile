FROM centos
RUN yum update -y
RUN yum install -y git 
RUN yum install -y wget 
RUN yum install -y unzip
RUN cd / 
WORKDIR /opt 
RUN mkdir gradle 
WORKDIR /opt/gradle
RUN wget https://services.gradle.org/distributions/gradle-7.3.1-bin.zip
RUN unzip gradle-7.3.1-bin.zip
RUN ln -s /opt/gradle/gradle-7.3.1/bin/gradle /usr/bin/gradle 
WORKDIR / 
RUN yum install -y java-11-openjdk-devel
RUN mkdir appgate 
RUN chmod 777 -R appgate 
WORKDIR /appgate
RUN git clone -b main https://github.com/ingjmaradeyd/AppGateTestTech.git
WORKDIR /appgate/AppGateTestTech/PruebaTecnicaSuma 
RUN gradle build --exclude-task test -i
WORKDIR /appgate/AppGateTestTech/PruebaTecnicaSuma/build/libs
RUN java -jar PruebaTecnicaSuma-1.0.jar &
WORKDIR /appgate/AppGateTestTech/PruebaTecnicaResta
RUN gradle build --exclude-task test -i
WORKDIR /appgate/AppGateTestTech/PruebaTecnicaResta/build/libs
RUN java -jar PruebaTecnicaResta-1.0.jar &
WORKDIR /appgate/AppGateTestTech/PruebaTecnicaMultiplicacion
RUN gradle build --exclude-task test -i
WORKDIR /appgate/AppGateTestTech/PruebaTecnicaMultiplicacion/build/libs
RUN java -jar PruebaTecnicaMultiplicacion-1.0.jar &
WORKDIR /appgate/AppGateTestTech/PruebaTecnicaDivision
RUN gradle build --exclude-task test -i
WORKDIR /appgate/AppGateTestTech/PruebaTecnicaDivision/build/libs
RUN java -jar PruebaTecnicaDivision-1.0.jar &
WORKDIR /appgate/AppGateTestTech/PruebaTecnicaPotencia
RUN gradle build --exclude-task test -i
WORKDIR /appgate/AppGateTestTech/PruebaTecnicaPotencia/build/libs
RUN java -jar PruebaTecnicaPotencia-1.0.jar &
WORKDIR /appgate/AppGateTestTech/PruebaTecnicaOperaciones
RUN gradle build --exclude-task test -i
WORKDIR /appgate/AppGateTestTech/PruebaTecnicaOperaciones/build/libs
RUN java -jar PruebaTecnicaOperaciones-1.0.jar &
WORKDIR /appgate/AppGateTestTech/PruebaTecnicaInicial
RUN gradle build --exclude-task test -i
WORKDIR /appgate/AppGateTestTech/PruebaTecnicaInicial/build/libs
RUN java -jar PruebaTecnicaInicial-1.0.jar &