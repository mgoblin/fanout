java -jar wiremock-standalone-2.26.3.jar \
 --port 8080 \
 --async-response-enabled true \
 --async-response-threads 50 \
 --no-request-journal \
 --container-threads 20 \
 --jetty-acceptor-threads 5 \
 --jetty-accept-queue-size 100000 \
 --global-response-templating
