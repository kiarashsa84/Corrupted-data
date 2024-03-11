import java.util.Scanner; 

public class App {
    public static void main(String[] args) throws Exception {
        
        Scanner input  = new Scanner(System.in); 

        String[] usernames = new String[100]; 

        boolean exist = false; 

        int cout_users = 0;
        
        boolean exit = false; 

        while(!exit){

            String menu = input.nextLine(); 

            
            switch (menu) {

                case "signup":

                String username = input.nextLine(); 
                    for (int i = 0 ; i < 100; i++){
                        if(username == usernames[i]) {
                            exist = true; 
                            break;
                        } 
                    }

                    if (exist){
                        System.out.println("Username Exists!");
                        break;
                    }

                    else {
                        usernames[cout_users] = username; 
                        cout_users++; 
                    }

                    String password = input.nextLine(); 
                    boolean verify_cap = true;
                    boolean verify_digit = true;
                    boolean symbols = true;


                    if (password.length() < 8){

                        System.out.println("Password Not Valid!");
                        break;

                    }else{
                        System.out.println("complete this part");
                    }




                    

                    break;

                case "login":
                    break; 
                
                case "exit":
                    break; 
            
                default:
                    break;
            }
        }
    }
}
