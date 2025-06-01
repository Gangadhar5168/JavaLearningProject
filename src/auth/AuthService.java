package auth;
import java.io.*;
import java.util.Scanner;
// This class handles authentication and user management, including:
// Registering users
// Logging users in
// Validating credentials
// Reading/writing user info to a file (like users.txt)


public class AuthService {
    private File userFile;
    public AuthService(){
         this.userFile = new File("JavaLearningProject/user.txt");
    try{
   
    if(!userFile.exists()){
        userFile.createNewFile();
        System.out.println("UserFile has been created");
    }
    else{
        System.out.println("FIle already exists");
    }
}
    catch(IOException e){
        System.out.println("An Error occured while creating the file");

    };


}
public void registerUser(String username, String password, String role){
try {
    Scanner reader = new Scanner(userFile);
    while(reader.hasNextLine()){
        String line = reader.nextLine();
        String[] parts = line.split(",");
        if(parts[0].equals(username)){
            System.out.println("Username already exists.");
            reader.close();
            return;
        }

    }
    reader.close();
    BufferedWriter writer = new BufferedWriter(new FileWriter(userFile,true));
    writer.write(username+","+password+","+role+"\n");
    writer.close();
    System.out.println("User registered successfully");

} catch (Exception e) {
   System.out.println("Some error occured"+e.getMessage());
}

}

public String loginUser(String username,String password){
    try {
        Scanner reader = new Scanner(userFile);
        while(reader.hasNextLine()){
            String line = reader.nextLine();
            String[] parts = line.split(",");
            if(username.equals(parts[0])&&password.equals(parts[1])){
                reader.close();
                System.out.println("Login Successful");
                return parts[2];
            }
        }
        System.out.println("Invalid Username or password");
    } catch (Exception e) {
           System.out.println("Some error occured"+e.getMessage());
    }
    return null;
    
}


}
