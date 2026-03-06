# Calculatrice — Hugo, Cyril & Zaid

Calculatrice en ligne de commande développée en **Java (JDK 17+)**, suivant une architecture orientée objet stricte avec séparation des responsabilités, design patterns et tests unitaires JUnit 4.

---

## Fonctionnalités

- Expressions **binaires** : `2 + 3`, `8 * 9`, `(-2) * 4`, `-2.5 + 1.2`
- Expressions **unaires** : `5!`, `5 !`, `-3!` (factorielle)
- Opérateurs supportés : `+` `-` `*` `/` `^` `!`
- Validation et normalisation automatique de l'expression saisie
- Gestion d'erreurs claire : expression invalide, division par zéro, opérateur inconnu, opérande invalide

---

## Architecture

Le projet suit le principe **Single Responsibility** (SRP) — chaque classe a un rôle unique.

src/
├── exceptions/
│ ├── ExpressionInvalideException.java
│ ├── DivisionParZeroException.java
│ ├── OperateurInconnuException.java
│ └── InvalideOperandeException.java
│
├── Operateur.java # Classe abstraite de base
├── Binaire.java # Classe abstraite — opérateurs binaires
├── Unaire.java # Classe abstraite — opérateurs unaires
├── Addition.java
├── Soustraction.java
├── Multiplication.java
├── Division.java
├── Exponentiel.java
├── Factorielle.java
│
├── Operande.java # Représente un nombre (double)
├── Expression.java # Classe abstraite — expression calculable
├── ExpressionBinaire.java # Expression avec deux opérandes
├── ExpressionUnaire.java # Expression avec un opérande
│
├── Validateur.java # Valide et normalise l'expression brute
├── Parseur.java # Transforme la String en objet Expression
├── OperateurFactory.java # Factory — crée l'opérateur selon le symbole
├── Calculateur.java # Exécute le calcul sur une Expression
├── Calculatrice.java # Orchestrateur : valider → parser → calculer
├── InterfaceUtilisateur.java # Gère l'entrée/sortie console
└── Main.java # Point d'entrée du programme

tests/
├── TestAddition.java
├── TestSoustraction.java
├── TestMultiplication.java
├── TestDivision.java
├── TestExponentiel.java
├── TestFactorielle.java
├── TestOperande.java
├── TestOperateurFactory.java
├── TestParseur.java
├── TestValidateur.java
├── TestExpressionBinaire.java
├── TestExpressionUnaire.java
├── TestCalculateur.java
├── TestCalculatrice.java
└── TestInterfaceUtilisateur.java

---

## Flux d'exécution

Saisie utilisateur
↓
InterfaceUtilisateur.lireInput()
↓
Validateur.valider() → normalise "8*9" → "8 * 9" / "5!" → "5 !"
↓
Parseur.parse() → ExpressionBinaire ou ExpressionUnaire
↓
Calculateur.calculer() → expression.calculer()
↓
InterfaceUtilisateur.afficherResultat()

---

## Prérequis

- Java **JDK 17** ou supérieur
- **IntelliJ IDEA** (recommandé) ou tout autre IDE Java
- **JUnit 4.13.2** + **Hamcrest 3.0** (fournis dans `librairies/`)

---

## Installation et lancement

### 1. Cloner le dépôt

```bash
git clone https://github.com/fargela/Calculatrice.git
2. Ouvrir dans IntelliJ IDEA
File > Open → sélectionner le dossier Calculatrice-Zaid-Cyril-Hugo.

Marquer src/ comme Sources Root (clic droit → Mark Directory as > Sources Root).

Marquer tests/ comme Test Sources Root.

Ajouter les .jar : File > Project Structure > Libraries > + > Java → sélectionner junit-4.13.2.jar et hamcrest-3.0.jar dans librairies/.

3. Lancer le programme
Clic droit sur Main.java → Run 'Main'.

Exemple d'utilisation

=== Calculatrice ===
Entrez une expression du type : 3 + 5 ou 10 / 2
Opérateurs supportés : +  -  *  / ! ^
Tapez 'entrer' pour valider.
====================
Entrez une expression : 8*9
= 72

Entrez une expression : 5!
= 120

Entrez une expression : (-2)*4
= -8

Entrez une expression : 2^10
= 1024

Entrez une expression : 10 / 0
[ERREUR] Division par zéro interdite.

Entrez une expression : abc
[ERREUR] Format invalide : attendu ex. '-2 + 3', '(-2 * 4)' ou '5!'
Lancer les tests
Clic droit sur le dossier tests/ → Run 'All Tests'.

Ou pour une classe spécifique : clic droit sur TestCalculatrice.java → Run 'TestCalculatrice'.

Résultat attendu :

Tests run: XX,  Failures: 0,  Errors: 0
OK (XX tests)
Design patterns utilisés
Pattern	Où	Rôle
Factory	OperateurFactory	Crée l'opérateur adapté selon le symbole +/-/*/…
Strategy	Binaire, Unaire et leurs sous-classes	Chaque opérateur encapsule son propre algorithme
Template	Expression (abstraite)	Définit le contrat calculer() pour toutes les expressions

Auteurs

Hugo

Cyril

Zaid
