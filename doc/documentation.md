Projet : Analyseur de livre dont vous êtes le héros

ETAPES:

************************RECUPERER LE GRAPHE A PARTIR D'UN FICHIER TEXTE OU JSON************************

Cette etape consiste a prendre les numéros de page et les informations associé à cette page.
Chaque page ici est consideré comme un noeud et la collection comme notre graphe.
Nous devons gérer l'extraction des pages sur les fichiers textes et json de manière distincte,
pour faire ceci nous avons besoin d'une interface qui a une methode qui nous retourne la 
liste des pages. Par consequent, chaque classe responsable de l'extraction des pages devra 
implementer cette interface.


************************CONSTRUIRE NOTRE GRAPHE************************

Ici nous allons organiser notre graphe comme suit

             |--->id(numero de chaque page)
----Noeud ---|--->liste d'arret(suivants de notre page)
             |--->texte(texte associe a la page)
             
             |---->poids(1 par defaut)
----Arret ---|---->Noeud( choix de la page)
             |---->

----Grape --->liste de noeud


************************AFFICHER NOTRE GRAPHE************************

Pour afficher notre graphe nous devons d'abord implementer un algorithme de force.
Nous avons choisi comme algorithme de force(Fruchterman Reingold). Son algorithme est
base sur la loi de Hooke(la force entre les noeud est proportionnel a la distance entre 
ces noeuds). Plus les noeuds sont proches, plus la force de repulsion est grande et
plus les noeuds sont eloignés plus la force d'attraction est grande.
Après avoir implementer cet algorithme, nous allons l'utiliser pour afficher notre graphe 
avec Swing.


************************Analyse************************
Cette etape consiste a determiner a travers les donnees provenant de notre graphe :
- le plus court chemin vers la victoire grace à l'algorithme du Breadth-First Search (BFS) 
- le nombre total de combat grace à un attribut fight qui nous permet de savoir s'il y a un combat ou pas
- le plus grand nombre de combat pour un noeud etant le nombre de fois où il est citer dans les combats 
- le noeud en question 
- le nombre total de defaite possible correspondant aux noeuds qui n'ont pas de successeurs
- le noeuds correspondants à ces defaites 
- le plus court chemin vers une defaite correspondant au chemin du debut du graphe jusqu'à l'un de ces noeuds de defaites
- la probabilité de victoire pour un nombre determiner d'essai 
-tous les chemins qui nous mène à la victoire 
-le plus long chemin correspondant au chemin du debut du graphe la fin du graphe

*************************Execution******************

Pour lancer le jeu en version graphique, il faut se positionner dans la racine du projet,ouvrez un
terminale et taper les commandes suivantes :

 -ant compile
 -ant runMain

Pour afficher les différentes pages du fichier Text

- ant compile
- ant runText

Pour afficher les différentes pages du fichier Json

- ant compile
- ant runJson

Pour afficher les différents analyses qu'on a effectué sur le graphe

- ant compile
- ant runMainAnalyse
 










