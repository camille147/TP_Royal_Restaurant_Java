import java.time.LocalDate;

public class Dish {
    private String name;
    private String description;
    private double price;
    private double calories;
    private String category;
    private double portionSize;
    private LocalDate dateAdded;
    private boolean disponibility;
    private String ingredients;
    private String cuisineType;
    private String preparationTime;
    private double specialPrice;
    private String emoji;

    public Dish(String name, String description, double price, double calories, String category, double portionSize, LocalDate dateAdded, boolean disponibility, String ingredients, String cuisineType, String preparationTime, double specialPrice, String emoji) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.calories = calories;
        this.category = category;
        this.portionSize = portionSize;
        this.dateAdded = dateAdded;
        this.disponibility = disponibility;
        this.ingredients = ingredients;
        this.cuisineType = cuisineType;
        this.preparationTime = preparationTime;
        this.specialPrice = specialPrice;
        this.emoji = emoji;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }
    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getCalories() {
        return calories;
    }
    public void setCalories(Double calories) {
        this.calories = calories;
    }

    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }

    public Double getPortionSize() {
        return portionSize;
    }
    public void setPortionSize(Double portionSize) {
        this.portionSize = portionSize;
    }

    public LocalDate getDateAdded() {
        return dateAdded;
    }
    
    public void setDateAdded(LocalDate dateAdded) {
        this.dateAdded = dateAdded;
    }

    public Boolean getDisponibility() {
        return disponibility;
    }
    public void setDisponibility(Boolean disponibility) {
        this.disponibility = disponibility;
    }

    public String getIngredients() {
        return ingredients;
    }
    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public String getCuisineType() {
        return cuisineType;
    }
    public void setCuisineType(String cuisineType) {
        this.cuisineType = cuisineType;
    }

    public String getPreparationTime() {
        return preparationTime;
    }
    public void setPreparationTime(String preparationTime) {
        this.preparationTime = preparationTime;
    }

    public Double getSpecialPrice() {
        return specialPrice;
    }
    public void setSpecialPrice(Double specialPrice) {
        this.specialPrice = specialPrice;
    }

    public String getEmoji() {
        return emoji;
    }
    public void setEmoji(String emoji) {
        this.emoji = emoji;
    }

    public String toString() {
        return "Dish: \n Name: " + name + "\nDescription: " + description + "\nPrice: " + price + "\nCalories: " + calories + "\nCategory: " + category + "\nPortion Size: " + portionSize + "\nDate Added: " + dateAdded + "\nDisponibility: " + disponibility + "\nIngredients: " + ingredients + "\nCuisine Type: " + cuisineType + "\nPreparation Time: " + preparationTime + "\nSpecial Price: " + specialPrice + "\nEmoji: " + emoji;
    }
}
