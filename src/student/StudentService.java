package student;
import java.io.*;
import java.util.Scanner;
public class StudentService {
    public void startStudentModule(String username){
        File gradesFile = new File("JavaLearningProject/gradesFile.txt");
        Scanner sc = new Scanner(System.in);
        try {
            if(!gradesFile.exists()){
                gradesFile.createNewFile();
                System.out.println("File has been created"+gradesFile.getName());
            }
            
        } catch (Exception e) {
           System.out.println("Some error occured "+e.getMessage());
        }
         while (true){
        System.out.println("Please select from Below");
        System.out.println("1. View grades");
        System.out.println("0. Logout");
       int input =sc.nextInt();
       sc.nextLine();
       if(input==1){
        try {
            Scanner reader = new Scanner(gradesFile);
            System.out.println("PLease find the grade details");
            boolean found = false;
            while(reader.hasNextLine()){
                String line = reader.nextLine();
                String[] parts = line.split(",");
                if(parts[0].equals(username)){
                    System.out.println("Subject:"+parts[1]+" Grade: "+parts[2]);
                    found = true;
                }
            }
            if(!found){
                System.out.println("Grades not found");
            }
            reader.close();

        } catch (Exception e) {
            System.out.println("Some error occured"+e.getMessage());
            }
        }
        else if(input == 0){
            System.out.println("Logging out of system");
            break;
        }
    }}
}
