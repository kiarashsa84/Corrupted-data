import java.util.Scanner; 


public class App {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in); 

        int satr = input.nextInt(); 
        int soton = input.nextInt(); 

        int[][] matrix = new int[satr][soton]; 

        for (int i = 0 ; i < satr; i++){
            for (int j = 0; j<soton; j++){
                matrix[i][j] = input.nextInt(); 
            }
        }

        int pos_satr = input.nextInt(); 
        int pos_soton = input.nextInt(); 
        input.nextLine();

        while(input.hasNext()){


            String line = input.nextLine(); 

            int cnt =0; 
             
            int last  = 0; 
            while(true){
                

                if(line.indexOf("i", last) != -1){
                    cnt++; 
                    last = line.indexOf("i", last) +1 ;
                }else{
                    break;
                }
            }

            last = 0; 
            while(true){
                 
                if(line.indexOf("a", last) != -1){
                    cnt++; 
                    last = line.indexOf("a", last) +1 ;
                }else{
                    break;
                }
            }

            last  =0 ; 
            while(true){
                 
                
                if(line.indexOf("o", last) != -1){
                    cnt++; 
                    last = line.indexOf("o", last) +1 ;
                }else{
                    break;
                }
            }
            last  = 0; 
            while(true){
                

                if(line.indexOf("e", last) != -1){
                    cnt++; 
                    last = line.indexOf("e", last) +1 ;
                }else{
                    break;
                }
            }

            last = 0; 
            while(true){
                 
                if(line.indexOf("u", last) != -1){
                    cnt++; 
                    last = line.indexOf("u", last) +1 ;
                }else{
                    break;
                }
            }
            int count_element = 0; 

            for (int i = -cnt ; i <= cnt; i ++){
                if (pos_satr+i >= 0 & pos_satr+i < satr){
                    for (int j = -cnt; j <= cnt; j++){
                        if(pos_soton +j >= 0 & pos_soton+j < soton){
                            count_element += matrix[pos_satr + i][pos_soton + j]; 
                        }else{
                            continue;
                        }
                    }
                }else{
                    continue;
                }
            }  
            
            
            System.out.println(count_element);

        }

        
    }
}
