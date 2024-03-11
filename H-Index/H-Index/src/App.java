import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in); 

        int count_article = input.nextInt(); 

        int[] citation = new int[count_article]; 

        for (int i = 0 ; i < count_article; i++){
            citation[i] = input.nextInt(); 
        }

        int min = 1000; 
        int h_index = count_article; 
        int pos = 100; 
        
        while (true) {
            min = 1000; 
        
            for (int i =0 ; i < count_article; i++){
        
                if (citation[i] < min){
                    min = citation[i];
                    citation[i] = 1000; 
                    pos = i; 
                }  
            
            }
    

            if (min < h_index){
                h_index--; 

            }   
            else break;  
        }

        System.out.println(h_index);
        
        
    }
}
