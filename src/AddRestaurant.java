
import java.io.File;
import java.util.Scanner;


public class AddRestaurant extends Command {
    Scanner scanner = new Scanner(System.in);

    public AddRestaurant(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public String getLabel() {
        return "Ajouter un restaurant";
    }

    @Override
    public void execute() {
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
        restaurant.save(restaurant);
    }
    
}
