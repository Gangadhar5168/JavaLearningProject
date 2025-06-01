package teacher;
import java.util.Scanner;
import java.io.*;
public class TeacherService {
    public void startTeacherModule(String username){
       Scanner sc = new Scanner(System.in);
       File gradesFile = new File("JavaLearningProject/gradesFile.txt");
        try {
            if(!gradesFile.exists()){
                gradesFile.createNewFile();
                System.out.println("File has been created"+gradesFile.getName());
            }
            
        } catch (Exception e) {
           System.out.println("Some error occured "+e.getMessage());
        }
        while(true){
            System.out.println("PLease select an action item from menu");
            System.out.println("1. Enter grades for a Student");
            System.out.println("2. View all Grades");
            System.out.println("0. Logout");
            int input = sc.nextInt();
            sc.nextLine();
        if(input == 1){
            System.out.println("PLease enter a Student name:");
            String studentName = sc.nextLine();
            System.out.println("PLease enter Subject Name:");
            String subName = sc.nextLine();
            System.out.println("Please enter the Grade: (like A,B,C) ");
            String studentGrade = sc.nextLine();
            try {
                Scanner reader = new Scanner(gradesFile);
                boolean found = false;
                while(reader.hasNextLine()){
                    String line = reader.nextLine();
                    String[] parts = line.split(",");
                    if(parts[0].equalsIgnoreCase(studentName) && parts[1].equalsIgnoreCase(subName)){
                        found =true;

                    }
                }
                if(!found){
                    BufferedWriter writer = new BufferedWriter(new FileWriter(gradesFile,true));
                    writer.write(studentName+","+subName+","+studentGrade);
                    writer.newLine();
                    System.out.println("Grade is added successfully");
                    writer.close();
                }
                
                reader.close();
            } catch (Exception e) {
            System.out.println("Some error occured "+e.getMessage());
            }
        }
        else if (input == 2){
            try {
                Scanner reader = new Scanner(gradesFile);
                while(reader.hasNextLine()){
                    String line = reader.nextLine();
                    String[] parts = line.split(",");
                    System.out.println("Name: "+parts[0]+" Subject: "+parts[1]+" Grade: "+parts[2]);
                    
                }
                reader.close();
            } catch (Exception e) {
            System.out.println("Some error occured "+e.getMessage());
            }
        }
        else if(input == 0){
            System.out.println("Logging out successfully");
            break;
        }
        
        }
    }
}
