FROM node:12.18-alpine
ENV NODE_ENV=production
ENV PORT=8080
WORKDIR /app
COPY . .
RUN npm install --silent
EXPOSE 80
CMD ["npm", "start"]