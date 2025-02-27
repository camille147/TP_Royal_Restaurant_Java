import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Restaurant {
    protected int id;
    private String name;
    private String adress;
    private ArrayList<Menu> menus;
    private ArrayList<Order> orders;
    private ArrayList<Employee> employees;

    public Restaurant(int id, String name, String adress) {
        this.id = id;
        this.name = name;
        this.adress = adress;
        this.menus = new ArrayList<>();
        this.orders = new ArrayList<>();
        this.employees = new ArrayList<>();
    }
    
    public int getId() {
        return id;
    }
    public void setIdEmployee(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getAdress() {
        return adress;
    }
    public void setAdress(String adress) {
        this.adress = adress;
    }

    public ArrayList<Menu> getMenu() {
        return menus;
    }
    public void setMenu(ArrayList<Menu> menus) {
        this.menus = menus;
    }

    public ArrayList<Order> getOrders() {
        return orders;
    }
    public void setOrders(ArrayList<Order> orders) {
        this.orders = orders;
    }

    public ArrayList<Employee> getEmployees() {
        return employees;
    }
    public void setEmployees(ArrayList<Employee> employees) {
        this.employees = employees;
    }

    public void addOrder(Order order) {
        orders.add(order);
    }

    public void displayOrders() {
        for (Order order : orders) {
            System.out.println(order);
        }
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public void deleteEmployee( Employee employee) {
        employees.remove(employee);
    }

    public String searchEmployeeByJob(String job) {
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).getJob().equals(job)) {
                String employee = employees.get(i).getName();
                return employee + employees.get(i).getLastName();
            }
        }
        return null;
    }

    public void displayEmployees() {
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }
    public void saveOrders(String file) {
        
        
        //To do
    }

    public double totalOfEmployeesSalary() {
        double total = 0;
        for (Employee employee : employees) {
            total = total + employee.getSalary();
        } 
        return total;                                                                                                                                                               
    }

    public void loadOrders(String file) {
        //to do
    }

    public void displayRestaurant() {
        System.out.println("Restaurant#" + id + " : " + name + ", Adress:" + adress);
        System.out.println("Employees: \n");
        System.out.println("-Waiters:" + searchEmployeeByJob("Waiter"));
        System.out.println("-Floor manager:" + searchEmployeeByJob("Floor manager"));
        System.out.println("-Chef:" + searchEmployeeByJob("Chef"));
    
    }

    public int totalSales() {
        int total = 0;
        for ( Order order : orders) {
            total += order.calculateTotal();
        }
        return total;
    }

    public void save(Restaurant restaurant) {
        // String filename = String.format("restaurant_%d.txt", id);
        // System.out.println("Sauvegarde du restaurant dans " + filename);
        // File f = new File(filename);
        // try {
        //     BufferedWriter writer = new BufferedWriter(new FileWriter(f));
        //     writer.append(Integer.toString(id));
        //     writer.append("\n");
        //     writer.append(name);
        //     writer.append("\n");
        //     writer.append(adress);
        //     writer.append("\n");
        //     writer.close();
        // } catch (IOException e) {
        //     System.out.println("Erreur lors de la sauvegarde du restaurant");
        // }   


        String fileDirectory = "Data/Restaurant" + restaurant.getId();
        File dossierRestaurant = new File(fileDirectory);
        File employeesFolder = new File(fileDirectory + "/Employees");
        File menusFolder = new File(fileDirectory + "/Menus");

        
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

        if (!menusFolder.exists()) {
            menusFolder.mkdir();
            System.out.println("Dossier créé : " + fileDirectory + "/Menus");
        } else {
            System.out.println("le dossier menus de ce restaurant existe déjà");
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

    

}
