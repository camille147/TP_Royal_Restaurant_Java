
import java.util.Scanner;

public class Main {
    //public static void main(String[] args) {
        

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            while (true) {
                System.out.println("Menu :");
    
                Command[] commands = {
                    new AddRestaurant(scanner),
                    new PrintRestaurantList(),
                    new AddEmployeToRestaurant(scanner),
                    new AddMenuToRestaurant(scanner),
                    new Quit()
                };
    
                for (int i = 0; i < commands.length; i++) {
                    System.out.println((i + 1) + ". " + commands[i].getLabel());
                }
                
                int option = chooseOption(scanner);
    
                if (option < 0 || option >= commands.length) {
                    System.out.println("Option inconnue");
                    continue;
                }
    
                commands[option].execute();
            }
        }
    
        private static int chooseOption(Scanner scanner) {
            try {
                if (scanner.hasNextInt()) {
                    int option = scanner.nextInt();
                    scanner.nextLine();
                    return option - 1;
                    //return scanner.nextInt() - 1;
                } else {
                    scanner.next();
                    return -1;
                }
            } catch (Exception e) {
                return -1;
            }
        }

        //Scanner scanner = new Scanner(System.in);
        //int choix;

        //while(true) {
            //System.out.println("Menu utilisateur :");
            //System.out.println("1. Ajouter un restaurant");
            //System.out.println("2. Afficher la liste des restaurants");
            //System.out.println("3. Ajouter un employé à un restaurant");
            //System.out.println("4. Ajouter un plat au menu d'un restaurant");
            //System.out.println("5. Afficher les employés d'un restaurant");
            //System.out.println("6. Prendre une commande dans un restaurant");
            //System.out.println("7. Afficher les commandes d'un restaurant");
            //System.out.println("8. Sauvegarder et charger les infos");
            //System.out.println("9. Quitter");

            


            // System.out.print("Faites votre choix : ");
            // choix = scanner.nextInt();
            // scanner.nextLine(); 

            // switch (choix) {
            //     case 1:
            //         System.out.println("Vous avez choisi d'ajouter un restaurant.");
            //         FileManagement.createRestaurantFile();
            //         break;
            //     case 2:
            //         System.out.println("Vous avez choisi d'afficher la liste des restaurants.");
            //         FileManagement.displayRestaurants();
            //         break;
            //     //case 3:
            //     //    System.out.println("Vous avez choisi d'ajouter un plat.");
            //     //    break;
            //     case 9:
            //         System.out.println("Au revoir !");
            //         scanner.close();
            //         System.exit(0);
            //     default:
            //         System.out.println("Choix invalide.");
            //         break;
            //}

        //} 
    

    


        // File dossierData = new File("Data");
        // int numeroRestaurant = 2;
        
        // if (dossierData.exists() && dossierData.isDirectory()) {
        //     System.out.println("Le dossier Data existe");
        // } else {
        //     System.out.println("Le dossier Data n'existe pas");
        // }

        
        // Restaurant restaurant = new Restaurant(numeroRestaurant, "hola", "Orleans");

        // FileManagement.createRestaurantFile(restaurant);
        // System.out.println("Fichiers créés");
    //}
}
