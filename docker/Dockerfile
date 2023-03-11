FROM kubespheredev/java-11-runtime
WORKDIR /app
COPY ./build/libs/hw2.jar .
ENTRYPOINT ["java", "-jar", "/app/hw2.jar"]
ENV HTTP_PORT=8000 APP_LOG_LEVEL=ERROR
