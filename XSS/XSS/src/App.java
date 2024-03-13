import java.util.Scanner; 

public class App {



    public static void main(String[] args) throws Exception {
        
        Scanner input  = new Scanner(System.in); 

        String[][] usernames = new String[100][2]; 

        boolean exist = false; 

        int cout_users = 0;
        
        boolean exit = false; 

        while(!exit){

            String menu = input.nextLine(); 
             

            if (checkxss(menu) || checkxss_2(menu)){

                System.out.println("XSS Attack!");
                continue; 

            }

            
            switch (menu) {

                case "signup":
                // System.out.println("signup mode");
                
                
                // System.out.println("enter your username: ");
                String username = input.nextLine(); 
                if (checkxss(username) || checkxss_2(username)){

                    System.out.println("XSS Attack!");
                    continue; 
    
                }
                    for (int i = 0 ; i < 100; i++){

                        // System.out.println(usernames[i][0]);
                        if(username.equals(usernames[i][0])) {
                            

                            exist = true; 
                            break;
                        } 
                    }

                    if (exist){
                        System.out.println("Username Exists!");
                        break;
                    }

                    else {
                        
                    
                        // System.out.println("enter your password: ");
                        String password = input.nextLine(); 

                        if (checkxss(password) || checkxss_2(password)){

                            System.out.println("XSS Attack!");
                            continue; 
            
                        }
                        boolean verify_cap = false;
                        boolean lower = false; 
                        boolean verify_digit = false;
                        boolean symbols = false;


                        if (password.length() < 8){

                            System.out.println("Password Not Valid!");
                            

                        }else{
                            for (char c: password.toCharArray()){
                                if(Character.isDigit(c)){
                                    verify_digit = true; 
                                }
                                else if(Character.isUpperCase(c)){
                                    verify_cap = true;
                                }
                                else if(Character.isLowerCase(c)){
                                    lower = true; 
                                }else if(!Character.isLetterOrDigit(c)){
                                    symbols = true;
                                }
                            }


                            if (verify_cap & lower & verify_digit & symbols){
                            
                                usernames[cout_users][0] = username;
                                usernames[cout_users][1] = password;  
                                cout_users++; 
                                System.out.println("SignUp Successful!");
                            
                            } else{
                                System.out.println("Password Not Valid!");

                            }
                        
                    }

                }

                    break;

                case "login":
                    // System.out.println("hello");

                    String inUser = input.nextLine();
                    
                    
                    if (checkxss(inUser) || checkxss_2(inUser)){

                        System.out.println("XSS Attack!");
                        continue; 
        
                    }


                    String inPass = input.nextLine(); 


                    
                    boolean suclogin = false; 

                    for(int i = 0; i < 100; i++){

                        if(inUser.equals(usernames[i][0])){
                            if(inPass.equals(usernames[i][1])){
                                System.out.println("Login Successful!");
                                suclogin = true;

                            }
                        }
                        

                    }

                    if(!suclogin){
                        System.out.println("Invalid Username or Password!");
                    }




                    break; 
                
                case "exit":

                    exit = true;
                    break; 
            
                default:
                    break;
            }
        }
    }

    public static boolean checkxss(String input){

        String line = input.toLowerCase(); 

        if (line.contains("<")){

            if(line.contains("<script>")|| line.contains("</script>")){
                return true;
            }
            else{ 

                int indexoff = line.indexOf("<"); 
                boolean space = true;
                
                if(line.charAt(++indexoff) ==  ' ' ){
                    
                    while(space){
                        indexoff++; 
                        if (line.charAt(indexoff) != ' '){
                            // System.out.println(line.charAt(indexoff));
                            space = false; 
                        }

                    }

                    if (line.substring(indexoff, indexoff+6).equals("script")){
                        indexoff += 6 ;
                        space = true;
                        //
                        if (indexoff >= line.length()){
                            return false; 
                        }
                        if (line.charAt(indexoff) == ' '){
                            while(space){
                                indexoff++; 
                                if (line.charAt(indexoff) != ' '){
                                    // System.out.println(line.charAt(indexoff));
                                    space = false; 
                                }
        
                            }        
                            }
                            
                        }
                        if(line.charAt(indexoff) == '>'){
                            return true;
                        }
                        
                    }
                }   

            }

            return false; 
    }





    public static boolean checkxss_2(String input){

        String line = input.toLowerCase(); 

        if (line.contains("<")){

            if(line.contains("<script>")|| line.contains("</script>")){
                return true;
            }
            else{ 

                int indexoff = line.indexOf("<"); 
                boolean space = true;
                
                if(line.charAt(++indexoff) ==  ' ' ){
                    
                    while(space){
                        indexoff++; 
                        if (line.charAt(indexoff) != ' '){
                            // System.out.println(line.charAt(indexoff));
                            space = false; 
                        }

                    }

                    if (line.charAt(indexoff) == '/'){
                        indexoff += 1 ;
                        space = true;
                        if (line.charAt(indexoff) == ' '){
                            while(space){
                                indexoff++; 
                                if (line.charAt(indexoff) != ' '){
                                    // System.out.println(line.charAt(indexoff));
                                    space = false; 
                                }
        
                            }        
                            }
                            
                        }
                        if(line.substring(indexoff, indexoff+6).equals("script")){
                            indexoff += 6 ;
                            if(line.charAt(indexoff) ==  ' ' ){
                    
                                while(space){
                                    indexoff++; 
                                    if (line.charAt(indexoff) != ' '){
                                        // System.out.println(line.charAt(indexoff));
                                        space = false; 
                                    }
            
                                }

                                
                        }
                        if(line.charAt(indexoff) == '>') {
                            return true;
                        }
                    }
                }   

            }

            
    }
    return false; 
}


}

