# pact-example
This repo provides you the minimal setup to play a bit with [pact](https://docs.pact.io), understand it concepts and benefits it can bring to the way how you, your team and the teams around you approach the *consumer driven contracts*.

It contains 3 services which implement some minimal functionality just enough to be able to demonstrate the idea behind *CDC*s and *pact*. You can start everything up by building info-app and hamburg-service by ```gradlew build``` in both directories and running ```docker-compose up``` and executing a HTTP GET against http://localhost:8080/vehicles/hamburg
#### info-app
The **consumer** of the data provided by the 2 others. Written as a very basic [spring boot] app providing just one HTTP endpoint and exposing how the PACTs are being created by the consumers.

The contract (pact) generation happens here:
- src/test/java/example/vehicles/clients/CologneClientTest.java
- src/test/java/example/vehicles/clients/HamburgClientTest.java

To run the tests just execute ```gradlew test``` this will also create the pact files in **target/pacts**. You can either share them between the different services directly as paths (then you need to execute this ```cp target/pacts/* ../pacts/```) or via the broker. Currently there is no automatic upload configured, so you need to upload them by hand (remember to spin up the pact-broker before 🤓) by doing:
```
curl -v -XPUT \-H "Content-Type: application/json" \
-d@info-app-hamburg-service.json \
http://localhost/pacts/provider/hamburg-service/consumer/info-app/version/1.0.0

curl -v -XPUT \-H "Content-Type: application/json" \
-d@info-app-cologne-service.json \
http://localhost/pacts/provider/cologne-service/consumer/info-app/version/1.0.0
```
#### hamburg-service
One of the **providers**, also based on the spring boot framework, demonstrating how the provider-verification works using [pact-jvm-provider-spring](https://github.com/DiUS/pact-jvm/tree/master/pact-jvm-provider-spring).

To execute the tests just type ```gradlew test```

The contract (pact) verification happens here:
- src/test/java/example/vehicles/VehiclesContractTest.java

#### cologne-service
Another **provider**, this time based on [express.js](https://expressjs.com/) and node 8, showing the usage of [pact-js](https://github.com/pact-foundation/pact-js).

To execute the tests just type ```npm test``` (but remember to have done an ```npm install``` once to set up dependencies, and to have started the server with ```npm start```.

The contract (pact) verification happens here:
- spec/registrationsSpec.js

### pact-broker
You can also spin up a [pact-broker](https://github.com/pact-foundation/pact_broker) by running ```docker-compose up``` in the **pact-broker-dockerized** dir. You can access it's UI via http://localhost

A longer introduction to CDCs and PACT will follow as a blog post. Watch [https://lplotni.github.io](https://lplotni.github.io) for updates.
