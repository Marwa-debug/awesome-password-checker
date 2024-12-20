
# Awesome Password Checker

## 📝 Description
Le projet **Awesome Password Checker** est un outil de calcul de la force des mots de passe. Initialement développé à des fins académiques, il a été révisé et industrialisé en respectant les meilleures pratiques de développement, y compris le contrôle de la qualité du code, les tests unitaires et les pipelines CI/CD.

## 🚀 Caractéristiques
- Calcul de la "distance" entre les mots de passe à l'aide d'algorithmes avancés.
- Outil open-source, mais son usage commercial est interdit.
- Couverture de code garantie par JaCoCo.

## 🛠️ Technologies
- **Langage** : Java 8
- **Build Tool** : Maven 3.8+
- **Tests** : JUnit, JaCoCo (couverture du code)
- **Qualité** : Checkstyle, Semgrep (analyse statique)
- **CI/CD** : GitHub Actions

## Installation
### Prérequis
- Java 8
- Maven 3.8+
- Git

### Étapes d'installation
1. Clonez le projet :
   git clone https://github.com/Marwa-debug/awesome-password-checker
   cd Revue_de_code

2. Installez les dépendances :
   touch pm.xml

3. Compiler :
   mvn clean install
   

4. Exécutez les tests :
   mvn test


## 📘 Utilisation
Exemple de code :
import fr.isima.codereview.tp1.AwesomePasswordChecker;

public class Main {
    public static void main(String[] args) throws IOException {
        AwesomePasswordChecker checker = AwesomePasswordChecker.getInstance();
        double distance = checker.getDistance("password123", "password456");
        System.out.println("Distance entre les mots de passe : " + distance);
    }
}
Voir AwesomePasswordChecker.java      pour les fonctions
Voir AwesomePasswordCheckerTest.java  pour les tests


## 📂 Structure du projet
.
├── bug_report.md
├── pom.xml
├── pull_request_template.md
├── README.md
├── SECURITY.md
├── src
│   ├── main
│   │   ├── java
│   │   │   └── fr
│   │   │       └── isima
│   │   │           └── codereview
│   │   │               └── tp1
│   │   │                   └── AwesomePasswordChecker.java
│   │   └── resources
│   │       ├── checkstyle.xml
│   │       └── cluster_centers_HAC_aff.csv
│   └── test
│       └── java
│           └── fr
│               └── isima
│                   └── codereview
│                       └── tp1
│                           └── AwesomePasswordCheckerTest.java
└── target
    ├── classes
    │   ├── checkstyle.xml
    │   ├── cluster_centers_HAC_aff.csv
    │   └── fr
    │       └── isima
    │           └── codereview
    │               └── tp1
    │                   └── AwesomePasswordChecker.class
    ├── generated-sources
    │   └── annotations
    ├── generated-test-sources
    │   └── test-annotations
    ├── jacoco.exec
    ├── maven-status
    │   └── maven-compiler-plugin
    │       ├── compile
    │       │   └── default-compile
    │       │       ├── createdFiles.lst
    │       │       └── inputFiles.lst
    │       └── testCompile
    │           └── default-testCompile
    │               ├── createdFiles.lst
    │               └── inputFiles.lst
    ├── surefire-reports
    │   ├── fr.isima.codereview.tp1.AwesomePasswordCheckerTest.txt
    │   └── TEST-fr.isima.codereview.tp1.AwesomePasswordCheckerTest.xml
    └── test-classes
        └── fr
            └── isima
                └── codereview
                    └── tp1
                        └── AwesomePasswordCheckerTest.class



## 🛠️ Tests
Les tests couvrent :
- **Tests unitaires** avec JUnit.
- **Tests de performance** sur la méthode `ComputeMD5`.
- **Couverture du code** (JaCoCo) visant 90% de couverture minimale.

Commandes :
# Lancer les tests unitaires
mvn test

# Générer le rapport de couverture de code
mvn jacoco:report


## 🔒 Sécurité
Pour signaler une vulnérabilité, veuillez suivre les instructions du fichier [SECURITY.md](SECURITY.md).


## CI/CD
Pour chaque **pull request**, le pipeline CI vérifie :
- **Checkstyle** (respect des normes de code)
- **Tests unitaires** (100% de tests réussis)
- **Couverture du code** (objectif de 90%)
- **Analyse SAST** (analyse de la sécurité du code avec Semgrep)
- **Tests de performance**

---

## 📜 Licence
Ce projet est sous la licence **MIT**. Cependant, l'usage commercial du code est interdit. Voir [LICENSE](LICENSE) pour plus de détails.

---

## 🤝 Contribution
Pour contribuer :
1. Fork le dépôt.
2. Créez une branche.
3. Envoyez une pull request.


## ✨ Auteur
- **Marwa HMAOUI** ~ Développeuse principale


## 📞 Support
Pour toute question, ouvrez une issue dans le [tracker GitHub](https://github.com/Marwa-debug/awesome-password-checker).


