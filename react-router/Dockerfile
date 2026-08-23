
FROM node:20.19.0-alpine AS dependencies

WORKDIR /app

COPY package.json package-lock.json ./
RUN npm ci


FROM node:20.19.0-alpine AS build

WORKDIR /app

COPY . .
COPY --from=dependencies /app/node_modules ./node_modules

RUN npm run build

FROM nginxinc/nginx-unprivileged:alpine

COPY nginx.conf /etc/nginx/conf.d/default.conf
COPY --from=build /app/dist /usr/share/nginx/html

EXPOSE 8080