### Goto Kafka installation directory
    # cd /usr/local/kafka/bin

    # cat ../config/zookeeper.properties 
    dataDir=/var/lib/zookeeper
    clientPort=2181
    maxClientCnxns=0
    admin.enableServer=false
    tickTime=2000


### Start Zookeeper server
    # ./zookeeper-server-start.sh ../config/zookeeper.properties`


### Start Kafka Server
    # ./kafka-server-start.sh ../config/server.properties`


#### Verify Java processes
    root@prasad-udesk:~# jps
    2536 Kafka
    1661 QuorumPeerMain
    3023 Jps


### List Kafka Topics
    root@prasad-udesk:/usr/local/kafka/bin# ./kafka-topics.sh --list --zookeeper localhost:2181
    __consumer_offsets
    test

### Start Kafka Consumer
    root@prasad-udesk:/usr/local/kafka/bin# ./kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic test --from-beginning
    test 1

### Start Kafka Producer
    root@prasad-udesk:/usr/local/kafka/bin# ./kafka-console-producer.sh --broker-list localhost:9092 --topic test
    >test 1
    >test 2
    >
