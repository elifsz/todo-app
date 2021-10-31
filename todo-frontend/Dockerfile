FROM node:14.17.3-alpine3.14
WORKDIR '/todo-frontend'
COPY package.json .
RUN npm install
COPY . .
CMD ["npm","start"]