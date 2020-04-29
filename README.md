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
