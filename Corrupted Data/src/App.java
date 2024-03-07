import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        boolean flag = false; 

        int laset_busy = -1; 

        Scanner input = new Scanner(System.in); 

        int  count = input.nextInt(); 
        input.nextLine(); 

        double count_1 = count /2.0;  

        int count_2 = (int)Math.ceil(count_1);

        int[][] twoArray = new int[count - count_2 + 1 ][2];
        
        int[][] elements  = new int[count - count_2 + 1 ][2];

        for (int i = 0; i < elements.length; i++){
            for (int j = 0; j < 2; j++){
                elements[i][j] = -1; 
            }
        }
        
        for (int i = 0; i < twoArray.length; i++){
            for (int j = 0; j < 2; j++){
                twoArray[i][j] = -1; 
            }
        }
        
        for (int i = 0 ; i< count; i++){

            flag = false; 

            String line = input.nextLine(); 

            int LengthNum = (int)Math.ceil(line.length() / 2.0);

            
        for (int k = 0; k < twoArray.length; k++){
            
            if (twoArray[k][0] == LengthNum){
                flag = true; 
                twoArray[k][1]++; 
                break; 
            }

        }

        if (flag == false){

            if (laset_busy == -1 ){
                twoArray[0][0] = LengthNum; 
                twoArray[0][1] = 1; 
                laset_busy = 0; 
            }

            else{
                twoArray[laset_busy+1][0] = LengthNum; 
                twoArray[laset_busy+1][1] = 1;
                laset_busy++; 

            }
        }




    }

    System.out.println();


}
}
