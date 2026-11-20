FROM eclipse-temurin:21-jdk
WORKDIR /app
COPY . .
RUN apt update && apt install maven -y && mvn clean package -Dskiptests
CMD java -jar target/*.jar
