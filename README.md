# Microservies-with-Spring-Boot
----------------To run the Code------------------------------
git clone https://github.com/dedsec995/Microservies-with-Spring-Boot
git branch -r | grep -v '\->' | while read remote; do git branch --track "${​​​​​​​​​​​​​remote#origin/}​​​​​​​​​​​​​​​​​​​​" "$remote"; done
git fetch --all
git pull --all
git checkout (~latest version~) => e.g. "git checkout v1.3"

##Dependencies

Spring Boot Config(For All):
  --Project: Maven
  --Lanuage: Java
  --Spring Boot: 2.5.6
  --Packaging: Jar
  --Java: 11
  
Dependencies for M1:
  --Spring Web
  --Spring for Apache Kafka
Dependencies for M2:
  --Spring Web
  --Spring for Apache Kafka

Dependencies for M3:
  --Spring Data for Apache Cassandra
  --Spring Web
  --Spring for Apache Kafka
  --Lombok

Kafka Version:
  --Windows: 2.8.0 Scala 2.12
  --linux: 3.0.0 Scala 2.13
