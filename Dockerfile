# Étape 1 : Construction avec Maven
FROM maven:3.8.5-openjdk-17 AS build

# Définir le répertoire de travail à l'intérieur du conteneur
WORKDIR /app

# Copier les fichiers de configuration Maven et le code source
COPY pom.xml ./
COPY src ./src

# Télécharger les dépendances sans construire le projet
RUN mvn dependency:go-offline -B

# Construire l'application (générer le fichier .jar)
RUN mvn clean package -DskipTests

# Vérifier que le fichier JAR est bien généré
RUN ls -al /app/target

# Étape 2 : Image finale avec JDK pour exécuter l'application
FROM openjdk:17-jdk-alpine

# Définir le répertoire de travail dans le conteneur
WORKDIR /app

# Copier le fichier JAR généré depuis l'étape de construction

COPY --from=build /app/target/*.jar /app/app.jar


# Exposer le port sur lequel l'application va fonctionner
EXPOSE 1000

# Commande d'exécution de l'application
ENTRYPOINT ["java", "-jar", "/app/app.jar"]

