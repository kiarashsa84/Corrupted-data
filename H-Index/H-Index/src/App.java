import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in); 

        int count_article = input.nextInt(); 

        int[] citation = new int[count_article]; 

        for (int i = 0 ; i < count_article; i++){
            citation[i] = input.nextInt(); 
        }

        for (int i = 0; i < citation.length; i++){
            for (int j = i +1 ; j < citation.length; j++){
                if (citation[i] > citation[j]){
                    int tmp = citation[j]; 
                    citation[j] = citation[i]; 
                    citation[i] = tmp; 
                }
            }
        } 

        int h_index = citation.length ; 
        int cnt =0; 

        while (true){
            if (citation[cnt] >= h_index){
                break; 
            }
            else{
                h_index--; 
                citation[cnt++] = -1;
            }
        }
        System.out.println(h_index);

        
    }
}
