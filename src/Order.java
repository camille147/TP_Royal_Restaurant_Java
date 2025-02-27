import java.util.ArrayList;

public class Order {
    private int orderNumber;
    private ArrayList<Dish> dishes;
    private double total;

    public Order(int orderNumber) {
        this.orderNumber = orderNumber;
        this.dishes = new ArrayList<>();
        this.total = 0;
    }

    public int getOrderNumber() {
        return orderNumber;
    }
    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    public ArrayList<Dish> getDishes() {
        return dishes;
    }
    public void setDishes(ArrayList<Dish> dishes) {
        this.dishes = dishes;
    }

    public double getTotal() {
        return total;
    }
    public void setTotal(double total) {
        this.total = total;
    }

    public void addDish(Dish dish) {
        dishes.add(dish);
    }

    public double calculateTotal() {
        for (Dish dish : dishes) {
            total = total + dish.getPrice();
        }
        return total;
    }

    public void displayOrder() {
        System.out.println("Order number:" + orderNumber);
        for (Dish dish : dishes) {
            System.out.println(dish.getName());
        }
        System.out.println("Total:" + total + "euros");
    }

    public String toString() {
        String order = "Order number: " + orderNumber + "\n Dishes: " + dishes + "\n Total: " + total + "euros";
        return "Order ";
    }




}
