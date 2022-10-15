FROM openjdk:16-jdk-alpine
RUN addgroup -S spring && adduser -S spring -G spring
EXPOSE 8080

ENV JAVA_PROFILE db
ARG DEPENDENCY=target/dependency
COPY ${DEPENDENCY}/BOOT-INF/lib /app/lib
COPY ${DEPENDENCY}/META-INF /app/META-INF
COPY ${DEPENDENCY}/BOOT-INF/classes /app

ENTRYPOINT ["java" ,   "-Dspring.profiles.active=${JAVA_PROFILE}",\
           "-cp","app:app/lib/*","src/main/java/com/example/phamacy_linechatbot_backend/PhamacyLineChatBotBackendApplication.java"]
