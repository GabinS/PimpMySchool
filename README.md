# PimpMySchool
## Importer le projet sur votre environnement local
>**Pour commencer, cloner le projet dans votre répertoire de travail.**

    git clone https://github.com/GabinS/PimpMySchool.git

>**Importer le projet dans Eclipse**

    File > Import > Maven > Existing Maven Project
    Renseigner l'emplacement du projet PympMySchool
    Sélectionner l'ensemble du projet
    Ciquer sur Finish

>**Ajouter les librairies manquantes**
    
    Clique droit sur le projet
    Build Path > Add Librairies...
    Sélectionner Serveur Runtime > Apache Tomcat

>**Démarer le projet**
    
    Lancer le projet sur votre serveur Tomcat
    
**_Voilà! Il n'y a plus qu'à travailler ;)_**

## Ligne de conduite
>**La structure du projet suit le pattern MCV**

>**La syntaxe générale à utiliser :**
- `Classe`
- `variableDeClass`
- `Fonction`
- `variableDeFonction`
- `package`

>**Commenter le code produit**

>**Penser à commit régulièrement en précisant son contenu (à chaque nouvelle fonctionnalité par exemple)**

*Lorsque vous voulez mettre à jour la branche principale avec les ajouts de votre branche, faites un merge request sur l'interface git, je m'occuperais de mettre votre branche à jour*


## Pour ceux qui ne sont pas à l'aise avec Git
### Navigation
> **Changer de branche**

    git checkout <nom de la branche>

> **Créer une branche**

*La branche sera liée à la branche sur laquelle elle a été créée*

    git checkout -b <nom de la branche>

### Gestion
> **Mettre sa branche à jour**

*Pour voir si il y a des modifs sur votre branche*

    git fetch

*Récupérer les modifs*

    git pull 

### Pousser des modifs
> **Voir les fichier modifiés**

    git status
    
> **Ajouter des modifs dans un dépot**

    git add <nom complet fichier>

>**Sauvegarder un dépot**

*Préciser ce que contient le commit dans le message*

    git commit -m "<message>"

>**Pousser un dépot**

    git push

**_Voilà! Vos modifs sont accessible sur le serveur git_**
