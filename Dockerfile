# Stage 1 - the build process
FROM openjdk:8-jre as build

# Install Node
RUN curl -sL https://deb.nodesource.com/setup_10.x | bash -

RUN apt-get update && \
    apt-get -y install nodejs

WORKDIR /usr/src/app
COPY package.json yarn.lock ./
COPY . ./
RUN npm install
RUN npm run-script build

# Stage 2 - the production environment
FROM nginx:stable
# support running as arbitrary user which belogs to the root group
RUN chmod g+rwx /var/cache/nginx /var/run /var/log/nginx
# users are not allowed to listen on priviliged ports
RUN sed -i.bak 's/listen\(.*\)80;/listen 8080;/' /etc/nginx/conf.d/default.conf
EXPOSE 8080:80
# comment user directive as master process is run as user in OpenShift anyhow
RUN sed -i.bak 's/^user/#user/' /etc/nginx/nginx.conf
# Copy content
COPY --from=build /usr/src/app/build /usr/share/nginx/html
CMD ["nginx", "-g", "daemon off;"]

