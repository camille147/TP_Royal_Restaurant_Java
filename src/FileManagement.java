import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileManagement {
    public static void createRestaurantFile() {
        Scanner scanner = new Scanner(System.in);

        File folderBase = new File("Data");
        if (!folderBase.exists()) {
            folderBase.mkdir();
            System.out.println("dossier Data => créer");
        }

        int restaurantNumber = 1;
        if (folderBase.exists() && folderBase.isDirectory()) {
            restaurantNumber = folderBase.list((current, name) -> new File(current, name).isDirectory()).length +1;
        }

        System.out.println("Veuillez entrer le nom du restaurant: ");
        String name = scanner.nextLine();

        System.out.println("Veuillez entrer l'adresse de ce restaurant: ");
        String adress = scanner.nextLine();

        Restaurant restaurant = new Restaurant(restaurantNumber, name, adress);

        String fileDirectory = "Data/Restaurant" + restaurant.getId();
        File dossierRestaurant = new File(fileDirectory);
        File employeesFolder = new File(fileDirectory + "/Employees");
        
        if (!dossierRestaurant.exists()) {
            dossierRestaurant.mkdir();
            System.out.println("Dossier créé : " + fileDirectory);
        } else {
            System.out.println("le dossier de ce restaurant existe déjà");
        }

        if (!employeesFolder.exists()) {
            employeesFolder.mkdir();
            System.out.println("Dossier créé : " + fileDirectory + "/Employees");
        } else {
            System.out.println("le dossier employees de ce restaurant existe déjà");
        }

        File fileInformation = new File(fileDirectory + "/informations.txt");

        try {
            FileWriter writer = new FileWriter(fileInformation);
            writer.write("ID: " + restaurant.getId() + "\n");
            writer.write("Nom: " + restaurant.getName() + "\n");
            writer.write("Adresse: " + restaurant.getAdress() + "\n");
            writer.close();
            // creer tous les fichiers et dossier lors création d'un reatsurant 

        } catch (IOException e) {
            System.out.println("Erreur lors création informations.txt" + e.getMessage());
        }
    }

    public static void displayRestaurants() {
        File folderData = new File("Data");

        if (!folderData.exists() || !folderData.isDirectory()) {
            System.out.println("Data n'existe pas");
            return;
        }

        File[] restaurants = folderData.listFiles(File::isDirectory);

        if(restaurants == null || restaurants.length == 0) {
            System.out.println("Aucun restaurants trouvé");
        }

        for (File folderRestaurant : restaurants) {
            File fileInfo = new File(folderRestaurant, "informations.txt");

            if (fileInfo.exists()) {
                try (BufferedReader reader = new BufferedReader(new FileReader(fileInfo))) {
                    String data;
                    while ((data = reader.readLine()) != null) {
                        if (data.startsWith("Nom:")) { 
                            System.out.println("➡️ " + data.substring(5)); 
                            break;
                        }
                    }
                } catch (IOException e) {
                    System.out.println("Erreur lors de al lectre de " + folderRestaurant);
                }

            }else {
                System.out.println("le fichier informations.txt est manquant pour" + folderRestaurant.getName());
            }
        }

    }
}