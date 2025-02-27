import java.io.File;
import java.time.LocalDate;
import java.util.Scanner;

public class AddEmployeToRestaurant extends Command {
    Scanner scanner = new Scanner(System.in);

    public AddEmployeToRestaurant(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public String getLabel() {
        return "Ajouter un employé à un restaurant";
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

            System.out.println("Veuillez entrer le numéro du restaurant auquel vous voulez ajouter un employé");
            int number = scanner.nextInt();
            scanner.nextLine();

            if (number < 1 || number > restaurants.length) {
                System.out.println("Numéro de restaurant invalide.");
                return;
            }

            File folderRestaurantEmployees = new File("Data/Restaurant" + number + "/Employees");

            int employeeNumber = 1 ;
            //File[] employeeFiles = folderRestaurantEmployees.listFiles((current, name) -> name.endsWith(".txt"));
            //if (employeeFiles != null && employeeFiles.length > 0) {
            //    employeeNumber = employeeFiles.length + 1;
           // }

           File[] restaurantDirs = folderBase.listFiles((current, name) -> new File(current, name).isDirectory());
        if (restaurantDirs != null) {
            for (File restaurantDir : restaurantDirs) {
                File employeesFolder = new File(restaurantDir, "Employees");
                if (employeesFolder.exists() && employeesFolder.isDirectory()) {
                    // Vérifier tous les fichiers employeeX.txt dans ce dossier
                    File[] employeeFiles = employeesFolder.listFiles((current, name) -> name.startsWith("employee") && name.endsWith(".txt"));
                    if (employeeFiles != null) {
                        for (File employeeFile : employeeFiles) {
                            try {
                                String fileName = employeeFile.getName();
                                int currentEmployeeNumber = Integer.parseInt(fileName.replace("employee", "").replace(".txt", ""));
                                if (currentEmployeeNumber >= employeeNumber) {
                                    employeeNumber = currentEmployeeNumber + 1;
                                }
                            } catch (NumberFormatException e) {
                                // Ignore files that don't match the expected format
                                System.out.println("Fichier ignoré: " + employeeFile.getName());
                            }
                        }
                    }
                }
            }
        }
        
                        
            System.out.println("Veuillez entrer le nom de l'employé: ");
            String name = scanner.nextLine();

            System.out.println("Veuillez entrer le prénom de l'employé: ");
            String lastName = scanner.nextLine();

            System.out.println("Veuillez entrer le métier de l'employé: ");
            String job = scanner.nextLine();
    
            System.out.println("Veuillez entrer le salire de cet employé: ");
            double salary = scanner.nextDouble();
    
            Employee employee = new Employee(employeeNumber, name, lastName, job, LocalDate.now(), salary);
            employee.save(employee, number);
    }
    
}
