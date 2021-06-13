# Projet Java : Pointeuse

## Sujet proposé et encadré par Monsieur Carl Esswein - Polytech Tours

### Étudiants :  
- **Theo BOISSEAU (theo.boisseau@etu.univ-tours.fr)**
- **Sarah DENIS (sarah.denis-2@etu.univ-tours.fr)**  
- **Mohammed RMICH (mohammed.rmich@etu.univ-tours.fr)**  
- **Chadi YASSIN (chadi.yassin@etu.univ-tours.fr)**

#### Application
L'application développée permet de gérer les pointages (arrivées et départs) des employés d'une entreprise donnée.  

Les sources relatives au deux programmes demandés ont été codées dans un seul
projet *Eclipse*, les classes sont ainsi selon des packages de **l'application principale** et de **l'émulateur**.
Cependant, nous avons utilisé le modèle **MVC** afin de mieux structurer notre projet et lui donner 
une meilleur lisibilité. Nous avons réparti l'ensemble de nos classes dans des packages **model**, **view**, et **controller**
qui sont propres à chacun des deux programmes (application principale, émulateur).  
En plus de ces packages, nous avons créé d'autres dont les classes sont partagées entre **l'application principale** et **l'émulateur**,
en particulier les classes qui permettent de s'occuper de la communication **TCP** et de la gestion de l'historique
des pointages.
Nous avons également suivi une conception qui respecte les procédures du *génie logiciel*,
dans le but de rendre l'entretien de notre code plus facile.  
Au niveau de l'emplacement des méthodes main, celle de l'application principale se trouve dans le package **controller.mainapp** et dans la classe **Mainapp**.Celle de l'émulateur a été placée dans le package **controller.emulator**, dans la classe **Emulator**. Les fichiers de sauvegarde des données sérialisées
de l'application principale (respectivement l'émulateur) se trouve dans le dossier **backupMainapp** (respectivement **backupEmulator**).
Pour effectuer une sauvegarde, il suffit de fermer les fenêtres principales de l'émulateur, ensuite de l'application principale. Les sauvegardes se feront tout de même à des intervalles réguliers.   

Afin que l'émulateur puisse communiquer avec l'application principale, celle-ci doit être allumée. Une fois la connexion établie,
l'émulateur reçoit les dernières mises à jour des listes des employées inscrits dans le système, ce qui lui permettra
de valider ou non un identifiant, lors d'un pointage.