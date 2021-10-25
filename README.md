# MicroServices with Spring Boot

Three services, M1, M2, and M3, connect with each other over Kafka topic k1-topic and k2-topic in this project.
M1 Geneates data and passes to M2
M2 check the data and passes it to M3
Finally,M3 writes to Cassandra(database) 

## Installation

Change the Version in checkout to the latest version avaiable

```bash
git clone https://github.com/dedsec995/Microservies-with-Spring-Boot
git branch -r | grep -v '\->' | while read remote; do git branch --track "${​​​​​​​​​​​​​remote#origin/}​​​​​​​​​​​​​​​​​​​​" "$remote"; done
git fetch --all
git pull --all
git checkout v1.3
```

## Dependencies
Configuration and dependencies used while setting up [Spring](https://start.spring.io/)

```python
Spring Boot Config(For All):
  --Project: Maven
  --Language: Java
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
  --Linux: 3.0.0 Scala 2.13
```

## Contributing
Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.

Please make sure to update tests as appropriate.
