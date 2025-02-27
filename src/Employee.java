import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;

public class Employee {
    protected int id;
    private String name;
    private String lastName;
    private String job;
    private LocalDate hireDate;
    private double salary;

    public Employee(int id, String name, String lastName, String job, LocalDate hireDate , double salary) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.job = job;
        this.hireDate = hireDate;
        this.salary = salary;
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
    
    public String getLastName() {
        return lastName;
    }
    
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getJob() {
        return job;
    }
    
    public void setJob(String job) {
        this.job = job;
    }

    public LocalDate getHireDate() {
        return hireDate;
    }
    
    public void setHireDate(LocalDate hireDate) {
        this.hireDate = hireDate;
    }

    public Double getSalary() {
        return salary;
    }
    
    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public String toString() {
        return "Employee#" + id + " : Name : " + name + ", Last Name : " + lastName + ", Job : " + job + ", Hire Date : " + hireDate + ", Salary : " + salary + "euros";
    }

    public void save(Employee employee, int numberRestaurant) {
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


        String fileDirectory = "Data/Restaurant" + numberRestaurant + "/Employees";        

        File fileEmployee = new File(fileDirectory + "/employee" + employee.getId() + ".txt");

        try {
            FileWriter writer = new FileWriter(fileEmployee);
            writer.write("ID: " + employee.getId() + "\n");
            writer.write("Nom: " + employee.getName() + "\n");
            writer.write("Prénom: " + employee.getLastName() + "\n");
            writer.write("Métier: " + employee.getJob() + "\n");
            writer.write("Date d'embauche: " + employee.getHireDate() + "\n");
            writer.write("Salaire : " + employee.getSalary() + "\n");

            writer.close();
            

        } catch (IOException e) {
            System.out.println("Erreur lors création employee.txt" + e.getMessage());
        }
    }
}
