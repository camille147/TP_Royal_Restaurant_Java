import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

public class Menu {
    protected int id;
    private String name;
    private LocalDate creationDate;
    private String type;
    private final ArrayList<Dish> availableDishes;

    public Menu(int id, String name, LocalDate creationDate, String type) {
        this.id = id;
        this.name = name;
        this.creationDate = creationDate;
        this.type = type;
        this.availableDishes = new ArrayList<>();
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    
    public LocalDate getCreationDate() {
        return creationDate;
    }
    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    
    
    public void addDish(Dish dish) {
        availableDishes.add(dish);
    }

    public void deleteDish(Dish dish) {
        availableDishes.remove(dish);
    }

    public void displayDishes() {
        System.out.println(availableDishes);
    }

    public Dish searchDishByName(String name) {
        for (int i = 0; i < availableDishes.size(); i++) {
            if (availableDishes.get(i).getName().equals(name)) {
                return availableDishes.get(i);
            }
        }
        return null;
    }

    
    public String toString() {
        return "Menu: \n ID: " + id + "\n Name:" + name + "\n Creation Date:" + creationDate + "\n Type:" + type + "\n Dishes:" + availableDishes; 
    }

    public void save(Menu menu, int restaurantNumber) {   

        String fileDirectory = "Data/Restaurant" + restaurantNumber + "/Menus";
        File menuFolder = new File(fileDirectory + "/" + menu.name);


        if (!menuFolder.exists()) {
            menuFolder.mkdir();
            System.out.println("Dossier créé : " + menuFolder);
        } else {
            System.out.println("ce menu existe déjà");
        }

        File fileInformation = new File(fileDirectory + "/" + menu.name + "/" + menu.name + ".txt");

        try {
            FileWriter writer = new FileWriter(fileInformation);
            writer.write("ID: " + menu.getId() + "\n");
            writer.write("Nom: " + menu.getName() + "\n");
            writer.write("Date de création: " + menu.getCreationDate() + "\n");
            writer.write("Type: " + menu.getType() + "\n");
            writer.close();

        } catch (IOException e) {
            System.out.println("Erreur lors création d'un menu en particulier.txt" + e.getMessage());
        }
    }


}
