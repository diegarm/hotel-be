FROM openjdk:8u121-jre-alpine
ADD target/businesshotel-0.0.1-SNAPSHOT.jar businesshotel-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["sh", "-c", "java -Djava.security.egd=file:/dev/./urandom -cp /businesshotel-0.0.1-SNAPSHOT.jar br.com.cvccorp.hotelbe.BusinesshotelApplication"]