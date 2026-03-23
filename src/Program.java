import Emp.Employee;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        System.out.print("How many employees will be registered? ");
        int n = sc.nextInt();

        List<Employee> list = new ArrayList<>();


        for (int i = 0; i < n; i++) {
            System.out.println("Employee #" + (i + 1) + ":");

            System.out.print("Id: ");
            int id = sc.nextInt();

            boolean exists = false;

           for( Employee emp : list ) {
               if( emp.getId() == id ) {
                   exists = true;
                   break;
               }

           }

            while (exists) {
                System.out.print("Id already taken! Try again: ");
                id = sc.nextInt();

                exists = false;

                for (Employee emp : list) {
                    if( emp.getId() == id ) {
                        exists = true;
                        break;
                    }
                }

            }

            System.out.print("Name: ");
            sc.nextLine();
            String name = sc.nextLine();

            System.out.print("Salary: ");
             double salary = sc.nextDouble();


          Employee emp = new Employee(name, salary, id);
          list.add(emp);
        }

        System.out.print("Enter the employee id that will have salary increase: ");
        int searchId = sc.nextInt();
        Employee found = null;
        for (Employee emp : list) {
            if( emp.getId() == searchId ) {
                found = emp;
                break;
            }
        }
        if( found == null ) {
            System.out.print("No employee with that id found");
        } else  {
            System.out.print("Enter the percentage: ");
            double percentage = sc.nextDouble();
            found.increaseSalary(percentage);
        }
        System.out.println();
        System.out.println("List of employees:");
        for( Employee emp : list ) {
            System.out.println(emp.toString());
        }


         sc.close();

    }
}
