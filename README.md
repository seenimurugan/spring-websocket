# Getting Started

**Prerequisite: Docker**

Run the ActiveMQ broker:

```
docker run --name='activemq' -it --rm \
    -e 'ACTIVEMQ_CONFIG_MINMEMORY=512' \
    -e 'ACTIVEMQ_CONFIG_MAXMEMORY=2048'\
    -e 'ACTIVEMQ_ADMIN_LOGIN=admin' -e 'ACTIVEMQ_ADMIN_PASSWORD=admin' \
    -p 8161:8161 \
    -p 61616:61616 \
    -p 61613:61613 \
    -p 61614:61614 \
    webcenter/activemq:latest
```
    
To start the application run the following command:

```
mvn spring-boot:run
```

To Flip between Inmemory and External broker:

Update the below in the **application.yaml** file

```
broker:
  in-memory: false
 
```

**Opening a websocket connection:**

Once application is running with the external or in-memory broker, you can login using the 

**UserName**: user
**Password**: Printedon the console

1. Login
2. Open browser devtool and navigate to the network tab and filter websocket calls
3. Click connect button
4. Type any string and click send
5. Notice on the devtool that additional lines(messages) are produced for each message.

**Issue:**

In memory broker do not send additional line(as message) for each message.
 But external broker sends the additional line ('\') on each message it sent out to the client. why? 
 Also If the payload is just simple string then there is no noise even with the external broker. 
