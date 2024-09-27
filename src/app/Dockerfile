# Étape 1 : Construire l'application Angular
FROM node:16 AS build

# Définit le répertoire de travail
WORKDIR /app

# Copie le package.json et le package-lock.json
COPY package*.json ./

# Installe les dépendances
RUN npm install

# Copie le reste des fichiers de l'application
COPY . .

# Construire l'application Angular
RUN npm run build


# Étape 2 : Exécuter l'application Angular
FROM nginx:alpine

# Copie les fichiers construits dans le répertoire de Nginx
COPY --from=build /app/dist/front /usr/share/nginx/html

# Expose le port 80
EXPOSE 80

# Commande pour démarrer Nginx
CMD ["nginx", "-g", "daemon off;"]
