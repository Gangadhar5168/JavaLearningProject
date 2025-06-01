package main;
import auth.AuthService;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        AuthService authorise = new AuthService();
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.println("-----Welcome------");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("0. Exit");
            int input = sc.nextInt();
            sc.nextLine();
            if(input==1){
                System.out.println("Please enter username: ");
                String username = sc.nextLine();
                System.out.println("Please enter password: ");
                String password = sc.nextLine();
                System.out.println("Please enter role (Teacher/Student):");
                String role = sc.nextLine();
                authorise.registerUser(username, password, role);
            }
            else if(input == 2){
                 System.out.println("Please enter username: ");
                String username = sc.nextLine();
                System.out.println("Please enter password: ");
                String password = sc.nextLine();
                String role = authorise.loginUser(username, password);
                if(role!=null && role.equalsIgnoreCase("teacher")){
                    System.out.println("Teacher login Successful");
                    System.out.println("redirecting to Teacher module");
                    return;
                }
                else if(role!=null && role.equalsIgnoreCase("student")){
                    System.out.println("Student login Successful");
                    System.out.println("Redirecting to Student Module");
                    return;
                }

            }
            else if(input==0){
                System.out.println("Exiting the system");
                System.exit(0);
            }
            else{
                System.out.println("You have entered wrong choice");
                System.out.println("Exiting the system");
                System.exit(0);
            }
        }
        
    }
}
