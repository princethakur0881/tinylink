FROM node:22-alpine AS builder

WORKDIR /app

RUN npm install -g npm@11.9.0

COPY package.json package-lock.json ./

RUN npm ci

COPY . .

RUN npm run build

FROM nginx:1.27-alpine

COPY nginx.conf /etc/nginx/conf.d/default.conf

COPY --from=builder /app/dist/frontend/browser /usr/share/nginx/html

EXPOSE 80
