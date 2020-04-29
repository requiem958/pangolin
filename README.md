# Projet pangolin

[![codecov](https://codecov.io/gh/requiem958/pangolin/branch/master/graph/badge.svg)](https://codecov.io/gh/requiem958/pangolin)

[![Build Status](https://travis-ci.com/requiem958/pangolin.svg?branch=master)](https://travis-ci.com/requiem958/pangolin)

[![codebeat badge](https://codebeat.co/badges/9be933f7-a732-4e9f-85d7-5539293a373d)](https://codebeat.co/projects/github-com-requiem958-pangolin-master)

[![CodeFactor](https://www.codefactor.io/repository/github/requiem958/pangolin/badge)](https://www.codefactor.io/repository/github/requiem958/pangolin)

## Fonctionnalités implémentées

Actuellement il est possible de :

1. Créer des dataframes à partir de tableaux d'objets de : *integer, double, string*
2. Créer des dataframes à partir de fichiers CSV
3. Récupérer un dataframe par ses colonnes
4. Récupérer un dataframe par ses lignes
5. Afficher entièrement un dataframe
6. Selection avancée avec WHERE et des opérateurs sur une colonne (<,>,=,!=)
7. Affichage partiel, sympathique.
8. Opérations mathématiques simples sur les colonnes.

## Documentation des fonctions

### Dataframe

#### Création

* `Dataframe(Object[][])` : Crée un Dataframe à partir d'un tableau d'objets : String, Integer, Double.
* `Dataframe(String)` : Crée un Dataframe à partir d'un fichier dont on passe le nom, le fichier doit être formaté en CSV, avec une tolérance pour les lignes vides.
* `fromLines(int[])` : Crée un dataframe contenant les lignes données en argument et toutes les colonnes à partir d'un dataframe existant. Les numéros de lignes trop grand sont ignorés.
* `fromColumns(String[])` : Crée un dataframe contenant uniquement les colonnes données en argument et toutes les lignes à partir d'un dataframe existant. Les noms non existant sont ignorés.

### Sélection

* `where(nom,ref,comparateur)` : renvoie un dataframe composé de toutes les lignes et colonnes du dataframe original où la valeur de la colonne `nom` respecte la relation `comparateur` avec la valeur `ref`. La colonne doit être du même type que la valeur `ref`. Comparateur peut prendre pour valeur l'énumération `fr.triangle.pangolin.math.Comparison` (`EQUAL,NOT_EQUAL,STRICT_INF,STRICT_SUP`).

* Exemple : `d.where("age",10,Comparison.EQUAL)` : renvoie un dataframe composé des lignes où la colonne `age` vaut exactement `10`, age doit être un entier, le dataframe résultant à autant de colonnes que l'original `d`.
	  
### Opérateurs Mathématiques

* `operation(op,colonnes)` : renvoie le tableau des valeurs calculées selon l'opération `op` sur chaque colonne de `colonnes`. `op` doit dériver le type `fr.triangle.pangolin.math.MathColumnOperation`, 4 opérations de bases sont proposées : `Min,Max,Sum,Mean`. Toutes les colonnes doivent être de type : `Integer` ou `Double`.

* Exemple : `d.operation(new Sum(), {"age"})` : renvoit un tableau d'un élément qui est la somme des ages.
	
### Utilitaires

* `view()` : permet de récupérer un `Dataview` qui permet la visualisation et l'export des données.

Les dataframes supportent l'opération `equals` ainsi que l'accés à la liste des colonnes enregistrées.

## Dataview

Le Dataview est un objet permettant la visualisation et l'export d'un dataframe quelconque, il dispose des méthodes suivantes, prenant toute un argument un flux où écrire les données, afin de pouvoir facilement exporter dans un fichier.

* `printBeautiful()` qui affiche dans le flux donné une représentation tabulaire et humaine du Dataframe.

* `printAll()` : qui affiche l'entiereté des données au format CSV
* `printFirst()` : qui affiche les 10 premières lignes au format CSV, avec une version prenant le nombre de ligne à afficher.
* `printLast()` :  qui affiche les 10 dernières lignes au format CSV, avec une version prenant le nombre de ligne à afficher.

Une méthode utilitaire : `getData()` permettant de récupérer le dataframe associé.

## Outils utilisés

Nous utilisons pour les tests unitaires : **JUNIT 4.11** car cette version ajoute la méthode *assertNotEquals* très utile.

Le projet est déployé via maven, qui génére les rapports de test, non envoyés sur le github.

Le déploiement se fait via travis-ci qui exécute tout les tests.

Nous avons aussi trois outils pour assurer la qualité du code :

* Codecov : Gestion de la couverture de code.
* Codebeat : Gestion de la qualité du code grâce à leur métrique.
* Codefactor : Gestion de la qualité du code, pour corriger les oublis dans le code et utiliser les bonnes pratiques. 

## Déploiement docker

Une image permettant de lancer l'application de test est disponible sur docker hub à l'adresse :
[DockerHub](https://hub.docker.com/r/monnierm/pangolin)

L'application de test affiche un fichier CSV sur lequel on effectue des sélections, des opérations ...

## Feedback

Les outils utilisés sont intéressants car ils permettent de facilement repérer des erreurs d'inattention à corriger, par contre ils détectent beaucoup de faux positifs (surtout ceux de review de code).

La couverture de code est très utile et permet d'apporter une certaine confiance envers le programme. Par contre il est regrettable de ne pas pouvoir exclure certaines parties du code de la manipulation (Des classes avec uniquement des méthodes statiques qui ne seront jamais instanciées n'ont pas besoin de voir leur instanciation testée par exemple).

L'outil Travis-CI est d'une grande utilité lorsqu'il est utilisé dans un grand pipeline incluant du déploiement et de la livraison continue. Ici nous n'avons mis en place que tardivement le dépot dockerHub et n'avons donc pas pu profiter de toutes les fonctionnalités de travis. Il nous a par contre permis de tester en permanence le code sur une machine standardisée.

DockerHub est lui un service très utile pour gérer ses conteneurs et les proposer facilement à chacun, il souffre par contre de sa lenteur et d'une interface peu agréable (un bouton "annuler le build" qui n'annule rien du tout).


