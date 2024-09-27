# Étape 1 : Construire l'application Angular
FROM node:16 AS build

WORKDIR /app

COPY package*.json ./

RUN npm install

COPY . .

RUN npm run build

# Étape 2 : Exécuter l'application Angular avec NGINX
FROM nginx:alpine

# Copie les fichiers construits dans NGINX
COPY --from=build /app/dist/front /usr/share/nginx/html

# Copie le fichier de configuration NGINX personnalisé
COPY nginx.conf /etc/nginx/conf.d/default.conf

EXPOSE 80

CMD ["nginx", "-g", "daemon off;"]
