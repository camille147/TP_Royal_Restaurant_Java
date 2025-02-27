import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Database {
    public static Restaurant[] loadRestaurants() {
        File dataFolder = new File("Data");

        if (!dataFolder.exists() || !dataFolder.isDirectory()) {
            System.out.println("Le dossier 'Data' est introuvable.");
            return new Restaurant[0]; // Retourne un tableau vide si Data n'existe pas
        }

        File[] restaurantFolders = dataFolder.listFiles(File::isDirectory);
        if (restaurantFolders == null || restaurantFolders.length == 0) {
            System.out.println("Aucun restaurant trouvé.");
            return new Restaurant[0];
        }

        ArrayList<Restaurant> restaurants = new ArrayList<>();

        for (File restaurantFolder : restaurantFolders) {
            File infoFile = new File(restaurantFolder, "informations.txt");

            if (infoFile.exists()) {
                Restaurant restaurant = loadRestaurant(infoFile);
                if (restaurant != null) {
                    restaurants.add(restaurant);
                }
            } else {
                System.out.println("⚠️ Fichier 'informations.txt' manquant pour " + restaurantFolder.getName());
            }
        }

        return restaurants.toArray(new Restaurant[0]);
    }

    private static Restaurant loadRestaurant(File file) {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String idLine = reader.readLine();
            String nameLine = reader.readLine();
            String addressLine = reader.readLine();
    
            // Vérifie si toutes les lignes sont lues correctement
            if (idLine == null || nameLine == null || addressLine == null) {
                System.out.println("Fichier mal formaté ou incomplet : " + file.getName());
                return null;
            }
    
            // Vérification du format de chaque ligne
            if (!idLine.startsWith("ID:") || !nameLine.startsWith("Nom:") || !addressLine.startsWith("Adresse:")) {
                System.out.println("Format incorrect dans " + file.getName());
                return null;
            }
    
            // Extraction et nettoyage des valeurs après "ID:", "Nom:", "Adresse:"
            int id;
            try {
                id = Integer.parseInt(idLine.substring(3).trim()); // Extraction de l'ID
            } catch (NumberFormatException e) {
                System.out.println("ID invalide dans " + file.getName() + ": " + idLine);
                return null;
            }
    
            String name = nameLine.substring(4).trim(); // Extraction du nom
            String address = addressLine.substring(8).trim(); // Extraction de l'adresse
    
            // Retourne l'objet Restaurant avec les données extraites
            return new Restaurant(id, name, address);
    
        } catch (IOException e) {
            System.out.println("Erreur lors de la lecture du fichier " + file.getName() + ": " + e.getMessage());
            return null;
        }
    }
    
    
}
