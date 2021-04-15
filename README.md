# ecommerce-bdd-cucumber-java

Projet Maven utilisant Cucumber + Page Object Model (POM) + Selenium + Java + JUnit + ExtentReports (HTML & PDF)

[Magento](https://magento.com/) est une plateforme open source de commerce électronique de même type que [Shopify](https://www.shopify.ca/), [BigCommerce](https://www.bigcommerce.ca/) et [PrestaShop](https://www.prestashop.com/en). Elle permet aux entreprises de créer leur boutique en ligne et offre plusieurs avantages comme le suivi des articles les plus en vente. La version que j'ai testé est la Open Source edition fournise par [Bitnami](https://bitnami.com/) hébergée dans un conteneur [Docker](https://bitnami.com/stack/magento/containers).

Le projet implémente le *Behavior Driven Development (BDD) Framework*, qui est un cadre de développement logiciel facilitant la collaboration entre les testeurs, développeurs, usagers et le client tout au long des essais d'acceptation par l'utilisateur (UAT). Les cas de tests sont ainsi écrits de manière simple et accessible à l'aide des mots clés `Soit`, `Quand` et `Alors`.

## Contenu

 - [Outils](#outils)
 - [Bonnes pratiques](#bonnes-pratiques)
 - [Installation](#installation)
    - [Prérequis](#prérequis)
    - [Comment installer](#comment-installer)
    - [Comment configurer](#comment-configurer)
    - [Comment exécuter](#comment-exécuter)
 - [Contact](#contact)

## Outils

- Eclipse IDE 2020-09 (Java 8)
- Maven (gestion de librairies)
- Cucumber 6 (framework de développement utilisant le langage `Gherkin`)
- Selenium WebDriver (framework d'automatisation web)
- JUnit 4 (framework de test)
- Jenkins (intégration continue)
- Selenium Grid avec Docker (exécution des tests en parallèle)
- Docker Compose (déployer l'application et ses dépendances)
- SelectorsHub, Css and XPath checker, Developer tools (sélecteurs d'élément web)

## Bonnes pratiques

- Utilisation d'expression régulière à la place des types de données.
- Une seule fonctionalité par fichier `.feature`.
- Les scénarios de test ne comportent pas beaucoup d'étapes.
- Les étapes de test sont écrites de manière déclarative plutôt que descriptive.
- Bonne utilisation de `Background` et des `Hooks`.
- Tous les scénarios de test sont étiquetés pour la Couverture de test et la création de la Matrice de traçabilité des exigences (RTM).
- Réutilisabilité des étapes de scénario à travers les fichiers `.feature`.
- Les données de test proviennent de fichier.

## Installation

### Prérequis:

- Obligatoire
  - Java 8 or later (JDK)
  - Maven
  - Docker Compose
- Optionnel
  - Microsoft Edge et son pilote (obligatoire pour l'exécution en local)
  - Selenium Grid (Chrome, Edge et Firefox comme "nodes")
  - Java IDE
  - Cucumber plugin
  - Git Bash

***

Les instructions suivantes sont pour Windows 10:

Dans le `cmd`/`PSH`, entrez les commandes suivantes, pour accéder au **Windows Subsystem for Linux (WSL)** et augmenter la valeur du paramètre `vm.max_map_count`:

```
wsl -d docker-desktop
sysctl -w vm.max_map_count=262144
exit
```

cela allouera la quantité de mémoire virtuelle nécessaire pour exécuter [Elasticsearch](https://www.elastic.co/elasticsearch/).

Dans le fichier `docker-compose.yml` se trouvant dans le dossier `docker-compose/magento`, changer la valeur de la variable d'environnement `MAGENTO_HOST` pour celle de votre adresse IP de version 4 (`IPv4`). Ensuite, dans le même dossier, entrez la commande suivante pour télécharger et démarrer les images de Magento, [MariaDB](https://mariadb.org/) et Elasticsearch:

```
docker-compose up -d
```

et pour l'exécution à distance, exécutez la même commande dans le dossier `docker-compose/selenium-grid`.

### Comment installer:

Tapez la commande suivante dans Git Bash:

```
$ git clone https://github.com/mk-sdet/ecommerce-bdd-cucumber-java.git
```

ou tout simplement télécharger le dépôt et l'extraire dans un dossier de votre choix.

### Comment configurer:

- Dans le fichier `pom.xml` sous `systemPropertyVariables` de l'extension `maven-failsafe-plugin`, inscrivez les adresses URL de votre application Magento et du serveur Selenium Grid pour l'exécution à distance.
- Dans le fichier `test-config.properties` du dossier `src/test/resources`, changer la valeur des propriétés `ENVIRONNEMENT` et `NAVIGATEUR` selon votre choix.
- Dans le fichier `FilePaths.java` du dossier `src/main/java/com/app/constants`, ajouter le chemin de votre exécutable comme valeur de la variable `EDGE_BINARY`.

*Veuillez noter que les tests s'exécutent séquentiellement sur un seul navigateur à la fois et ce peu importe l'environnement d'exécution.*

### Comment exécuter:

#### En local:

Dans `cmd`/`PSH`, exécuter la commande suivante dans le dossier du projet:

```
mvn clean verify
```

#### À distance:

Même commande qu'en local, mais juste assurez-vous que tout est correctement configuré comme indiqué à la section « Comment configurer ».

***

Enfin, vous trouverez les rapports de ExtentReports et de Cucumber dans le dossier `test-output`.

## Contact

Created by [Muana Kimba](https://www.linkedin.com/in/mkimba)
