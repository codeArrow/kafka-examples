# cd /usr/local/kafka/bin

# cat ../config/zookeeper.properties 
# Licensed to the Apache Software Foundation (ASF) under one or more
# contributor license agreements.  See the NOTICE file distributed with
# this work for additional information regarding copyright ownership.
# The ASF licenses this file to You under the Apache License, Version 2.0
# (the "License"); you may not use this file except in compliance with
# the License.  You may obtain a copy of the License at
# 
#    http://www.apache.org/licenses/LICENSE-2.0
# 
# Unless required by applicable law or agreed to in writing, software
# distributed under the License is distributed on an "AS IS" BASIS,
# WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
# See the License for the specific language governing permissions and
# limitations under the License.
# the directory where the snapshot is stored.
dataDir=/var/lib/zookeeper
# the port at which the clients will connect
clientPort=2181
# disable the per-ip limit on the number of connections since this is a non-production config
maxClientCnxns=0
# Disable the adminserver by default to avoid port conflicts.
# Set the port to something non-conflicting if choosing to enable this
admin.enableServer=false
# admin.serverPort=8080

tickTime=2000

# ./zookeeper-server-start.sh ../config/zookeeper.properties


On another terminal
# ./kafka-server-start.sh ../config/server.properties


Verify Java processes
root@prasad-udesk:~# jps
2536 Kafka
1661 QuorumPeerMain
3023 Jps



List Topics
--
root@prasad-udesk:/usr/local/kafka/bin# ./kafka-topics.sh --list --zookeeper localhost:2181
__consumer_offsets
test


Start Consumer
---
root@prasad-udesk:/usr/local/kafka/bin# ./kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic test --from-beginning
test 1

Start Producer
--
root@prasad-udesk:/usr/local/kafka/bin# ./kafka-console-producer.sh --broker-list localhost:9092 --topic test
>test 1
>test 2
>3
>4
>5
>6
>

