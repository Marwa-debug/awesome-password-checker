package fr.isima.codereview.tp1;

import fr.isima.codereview.tp1.AwesomePasswordChecker;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.io.IOException;

public class AwesomePasswordCheckerTest {

    @Test
public void testMaskAff() throws IOException {
    // Obtention de l'instance de la classe
    AwesomePasswordChecker checker = AwesomePasswordChecker.getInstance();
    
    // Exemple d'appel de la méthode maskAff et vérification de la sortie
    int[] result = checker.maskAff("mypassword");
    
    // Transformation du tableau de masques en une chaîne de caractères pour la vérification
    StringBuilder maskedPassword = new StringBuilder();
    for (int i : result) {
        maskedPassword.append(i);
    }

    // Mappage attendu après modification de maskAff
    String expectedMask = "2221112112000000000000000000";  // Vérification avec mappage correct
    assertEquals(expectedMask, maskedPassword.toString(), "La méthode maskAff ne masque pas correctement le mot de passe");
}


@Test
public void testGetDistanceCompletelyDifferentStrings() throws IOException {
    AwesomePasswordChecker checker = AwesomePasswordChecker.getInstance();
    
    // Test de la distance entre deux chaînes complètement différentes
    double distance = checker.getDistance("abcd", "xyz");
    assertEquals(2.23606797749979, distance, 0.001, "La méthode getDistance ne calcule pas la distance correcte pour des chaînes complètement différentes");
}

    @Test
    public void testEmptyPasswordMaskAff() throws IOException {
        AwesomePasswordChecker checker = AwesomePasswordChecker.getInstance();
        
        // Test d'un mot de passe vide
        int[] result = checker.maskAff("");
        assertEquals(28, result.length, "La méthode maskAff ne gère pas correctement le mot de passe vide (la longueur doit être 28)");
    }

    @Test
    public void testGetDistanceIdenticalStrings() throws IOException {
        AwesomePasswordChecker checker = AwesomePasswordChecker.getInstance();
        
        // Test de la distance entre deux chaînes identiques
        double distance = checker.getDistance("password", "password");
        assertEquals(0, distance, 0.001, "La méthode getDistance devrait retourner 0 pour deux chaînes identiques");
    }

    
}
