retrobuf
==========

POC example of Retrofit + Dropwizard + Protocol Buffers. 

Running the example
-------------------

Build artifacts:

    mvn clean package

Start server:

    java -jar server/target/server.jar server server/retrobuf.yml

Run client:

    java -jar client/target/client.jar

Client's main class will perform protobuf-encoded GET and POST requests and print the result.
