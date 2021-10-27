# MicroServices with Spring Boot

Three services, M1, M2, and M3, connect with each other over Kafka topic k1-topic and k2-topic in this project.
M1 Geneates data and passes to M2
M2 check the data and passes it to M3
Finally,M3 writes to Cassandra(database) 

## Installation

Change the Version in checkout to the latest version avaiable

```bash
git clone https://github.com/dedsec995/Microservices-with-Spring-Boot.git
cd Microservices-with-Spring-Boot
git branch -r | grep -v '\->' | while read remote; do git branch --track "${remote#origin/}" "$remote"; done
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
  
Apache Cassandra:
  --Both OS: 3.11.11

```

## Setting up Kafka
### In Linux:
Fire up a Terminal
```bash
bin/zookeeper-server-start.sh config/zookeeper.properties
```
In Another Terminal
```bash
bin/kafka-server-start.sh config/server.properties
```
Creating Topics
```bash
bin/kafka-topics.sh --create --topic k1-topic --bootstrap-server localhost:9092
bin/kafka-topics.sh --create --topic k2-topic --bootstrap-server localhost:9092
```
Another Terminal for Cassandra
```bash
sudo Cassandra -R
```
### In Windows:
Open Command Prompt
```bash
./bin/windows/zookeeper-server-start.bat config/zookeeper.properties
```
Open Another Cmd
```cmd
./bin/windows/kafka-server-start.bat config/server.properties
```
Creating Topics
```cmd
./bin/windows/kafka-topics.bat --create --topic k1-topic --bootstrap-server localhost:9092
./bin/windows/kafka-topics.bat --create --topic k2-topic --bootstrap-server localhost:9092
```
Another Window to the /bin folder of Cassandra
```cmd
cassandra
```

## Setting up Cassandra
### In Linux:
Download Cassandra from [here](https://www.apache.org/dyn/closer.lua/cassandra/3.11.11/apache-cassandra-3.11.11-bin.tar.gz)
```bash
sudo Cassandra -R
```
To interact with cassandra open up cqlsh (python2.7 is required)
```bash
cqlsh
```
```bash
CREATE KEYSPACE cassdb WITH replication = {'class':'SimpleStrategy', 'replication_factor' : 1};
USE cassdb;
CREATE TABLE User(
    vin text ,
    verified text,
    speed int,
    alert text,
    timest Timestamp,
    PRIMARY KEY(timest,vin),
);
```
To view the data
```bash
use cassdb;
select vin,verified,speed,alert,timest from User;
```
### In Windows:
Download Cassandra from [here](https://www.apache.org/dyn/closer.lua/cassandra/3.11.11/apache-cassandra-3.11.11-bin.tar.gz) and open command prompt at the /bin folder of Cassandra
```cmd
cassandra
```
To interact with cassandra open up cqlsh (python2.7 is required)
```bash
cqlsh
```
```bash
CREATE KEYSPACE cassdb WITH replication = {'class':'SimpleStrategy', 'replication_factor' : 1};
USE cassdb;
CREATE TABLE User(
    vin text ,
    verified text,
    speed int,
    alert text,
    timest Timestamp,
    PRIMARY KEY(timest,vin),
);
```
To view the data
```bash
use cassdb;
select vin,verified,speed,alert,timest from User;
```


## Contributing
Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.

Please make sure to update tests as appropriate.
