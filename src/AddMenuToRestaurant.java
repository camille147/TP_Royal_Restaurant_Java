import java.io.File;
import java.time.LocalDate;
import java.util.Scanner;

public class AddMenuToRestaurant extends Command {
    Scanner scanner = new Scanner(System.in);

    public AddMenuToRestaurant(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public String getLabel() {
        return "Ajouter un menu à un restaurant";
    }

    @Override
    public void execute() {
        
        File folderBase = new File("Data");
        if (!folderBase.exists()) {
            folderBase.mkdir();
            System.out.println("dossier Data => créer");
        }

        Restaurant[] restaurants = Database.loadRestaurants();
        for (int i = 0; i < restaurants.length; i++) {
            System.out.printf("%d. %s : %s\n", i+1, restaurants[i], restaurants[i].getName());
        }            

        System.out.println("Veuillez entrer le numéro du restaurant auquel vous voulez ajouter un menu");
        int number = scanner.nextInt();
        scanner.nextLine();

        if (number < 1 || number > restaurants.length) {
            System.out.println("Numéro de restaurant invalide.");
            return;
        }

        File folderRestaurantEmployees = new File("Data/Restaurant" + number + "/Menus");

        int menuNumber = 1;
        File[] menuFiles = folderRestaurantEmployees.listFiles((current, name) -> name.endsWith(".txt"));
        if (menuFiles != null && menuFiles.length > 0) {
            menuNumber = menuFiles.length + 1;
        }

        

        
        System.out.println("Veuillez entrer le nom du menu: ");
        String name = scanner.nextLine();

        System.out.println("Veuillez entrer le type de ce menu: ");
        String type  = scanner.nextLine();

        Menu menu = new Menu(menuNumber, name ,LocalDate.now(), type );
        menu.save(menu, number);    
        
        
    
    }
    
}
