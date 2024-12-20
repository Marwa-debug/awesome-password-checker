package fr.isima.codereview.tp1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.List;

public class AwesomePasswordChecker {

    private static AwesomePasswordChecker instance;

    public final List<double[]> clusterCenters = new ArrayList<>();

    public static AwesomePasswordChecker getInstance(File file) throws IOException {
        if (instance == null) {
            instance = new AwesomePasswordChecker(new FileInputStream(file));
        }
        return instance;
    }

    public static AwesomePasswordChecker getInstance() throws IOException {
        if (instance == null) {
            InputStream is = AwesomePasswordChecker.class.getClassLoader().getResourceAsStream("cluster_centers_HAC_aff.csv");
            if (is == null) {
                throw new IOException("Fichier de centres de clusters introuvable.");
            }
            instance = new AwesomePasswordChecker(is);
        }
        return instance;
    }

    public AwesomePasswordChecker(InputStream is) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        String line;
        while ((line = br.readLine()) != null) {
            String[] values = line.split(",");
            double[] center = new double[values.length];

            for (int i = 0; i < values.length; ++i) {
                center[i] = Double.parseDouble(values[i]);
            }
            clusterCenters.add(center);
        }
        br.close();
    }

    public int[] maskAff(String password) {
    int[] maskArray = new int[28]; // Limiter à 28 caractères
    int limit = Math.min(password.length(), 28);

    for (int i = 0; i < limit; ++i) {
        char c = password.charAt(i);
        switch (c) {
            case 'e': case 's': case 'a': case 'i': case 't':
            case 'n': case 'r': case 'u': case 'o': case 'l':
                maskArray[i] = 1;  // Lettres fréquemment utilisées en minuscule
                break;
            case 'E': case 'S': case 'A': case 'I': case 'T':
            case 'N': case 'R': case 'U': case 'O': case 'L':
                maskArray[i] = 3;  // Lettres fréquemment utilisées en majuscule
                break;
            case '>': case '<': case '-': case '?': case '.':
            case '/': case '!': case '%': case '@': case '&':
                maskArray[i] = 6;  // Caractères spéciaux
                break;
            default:
                if (Character.isLowerCase(c)) {
                    maskArray[i] = 2;  // Lettres minuscules autres que celles listées
                } else if (Character.isUpperCase(c)) {
                    maskArray[i] = 4;  // Lettres majuscules autres que celles listées
                } else if (Character.isDigit(c)) {
                    maskArray[i] = 5;  // Chiffres
                } else {
                    maskArray[i] = 7;  // Autres caractères
                }
        }
    }

    // Compléter avec des 0 si le mot de passe est plus court que 28 caractères
    for (int i = limit; i < 28; i++) {
        maskArray[i] = 0;
    }
    return maskArray;
}


    public double getDistance(String password1, String password2) {
        int[] mask1 = maskAff(password1);
        int[] mask2 = maskAff(password2);
        return euclideanDistance(mask1, mask2);
    }

    public double euclideanDistance(int[] a, int[] b) {
        double sum = 0;
        for (int i = 0; i < Math.min(a.length, b.length); i++) {
            sum += Math.pow(a[i] - b[i], 2);
        }
        return Math.sqrt(sum);
    }
}
