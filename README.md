# PimpMySchool
## Importer le projet sur votre environnement local
>**Pour commencer, cloner le projet dans votre r�pertoire de travail.**

    git clone https://github.com/GabinS/PimpMySchool.git

>**Importer le projet dans Eclipse**

    File > Import > Maven > Existing Maven Project
    Renseigner l'emplacement du projet PympMySchool
    S�lectionner l'ensemble du projet
    Ciquer sur Finish

>**Ajouter les librairies manquantes**
    
    Clique droit sur le projet
    Build Path > Add Librairies...
    S�lectionner Serveur Runtime > Apache Tomcat

>**D�marer le projet**
    
    Lancer le projet sur votre serveur Tomcat
    
**_Voil�! Il n'y a plus qu'� travailler ;)_**

## Ligne de conduite
>**La structure du projet suit le pattern MCV**

>**La syntaxe g�n�rale � utiliser :**
- `Classe`
- `variableDeClass`
- `listVariableDeClass` (Pour les liasons n\*\*n)
- `Fonction`
- `variableDeFonction`
- `package`

>**Commenter le code produit**

>**Penser � commit r�guli�rement en pr�cisant son contenu (� chaque nouvelle fonctionnalit� par exemple)**

*Lorsque vous voulez mettre � jour la branche principale avec les ajouts de votre branche, faites un merge request sur l'interface git, je m'occuperais de mettre votre branche � jour*


## Pour ceux qui ne sont pas � l'aise avec Git
### Navigation
> **Changer de branche**

    git checkout <nom de la branche>

> **Cr�er une branche**

*La branche sera li�e � la branche sur laquelle elle a �t� cr��e*

    git checkout -b <nom de la branche>

### Gestion
> **Mettre sa branche � jour**

*Pour voir si il y a des modifs sur votre branche*

    git fetch

*R�cup�rer les modifs*

    git pull 

### Pousser des modifs
> **Voir les fichier modifi�s**

    git status
    
> **Ajouter des modifs dans un d�pot**

    git add <nom complet fichier>

>**Sauvegarder un d�pot**

*Pr�ciser ce que contient le commit dans le message*

    git commit -m "<message>"

>**Pousser un d�pot**

    git push

**_Voil�! Vos modifs sont accessibles sur le serveur git_**

| D�v�loppeur | Entit� |
| ----------- | ------ |
| Emilie   | Planning |
| Robin    | Formation |
| Damien   | RessourceMaterielle / Disponibilite / Salle |
| Mathieu  | RessourceMaterielle / Disponibilite / Ordinateur |
| Sofiane  | RessourceMaterielle / Disponibilite / VideoProjecteur |
| Joris    | Formateur / Techinicien / Gestionnaire / Stagiaire |
| Gabin    | UniteEnseignement / Matiere |

## Les Pages

- Menu
    - D�connexion
    - Mes informations
    - Ressource Mat�rielle
    - Planning
    - Formation (unit� d'enseignement)
- Home
    - planning journ�e actuelle
    - Alerte ressource mat�rielle (technicien)
- Inscription
- Connexion
- Mes informations
    - CRUD
    - Disponibilit�s
- Ressource Mat�rielle
    - Disponibilit�s
    - Affectation planning
    - CRUD
- Planning
    - Affectation des cours / formateur
    - Affectation du mat�rielle
    - Navigation du planning
    - Alerte
- Formation
    - CRUD Formation
    - CRUD Unit� d'enseignement
    - CRUD Mati�re
    - Lien vers le planning d'une formation
