

public class PrintRestaurantList extends Command {

    @Override
    public String getLabel() {
        return "Lister les restaurants";
    }

    @Override
    public void execute() {
        Restaurant[] restaurants = Database.loadRestaurants();
        for (int i = 0; i < restaurants.length; i++) {
            System.out.printf("%d. %s\n", i+1, restaurants[i].getName());
        }
    }
    
}
