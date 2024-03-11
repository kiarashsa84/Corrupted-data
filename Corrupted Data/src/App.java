import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        int indexline = -1; 

        boolean flag = false; 

        int laset_busy = -1; 

        Scanner input = new Scanner(System.in); 

        int  count = input.nextInt(); 
        input.nextLine(); 

        double count_1 = count /2.0;  

        int count_2 = (int)Math.ceil(count_1);

        int[][] twoArray = new int[count - count_2 + 1 ][2];
        
        int[][] elements  = new int[count - count_2 + 1 ][count];

        for (int i = 0 ; i < elements.length; i++){
            for (int j = 0 ; j < count; j++){
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
            indexline++; 

            int LengthNum = (int)Math.ceil(line.length() / 2.0);

            
        for (int k = 0; k < twoArray.length; k++){
            
            if (twoArray[k][0] == LengthNum){
                flag = true; 
                twoArray[k][1]++;
                for (int t = 0; t < count ; t++){
                    if (elements[k][t]  == -1){
                        elements[k][t] = indexline; 
                        break; 
                    }
                }
                break; 
            }

        }

        if (flag == false){

            if (laset_busy == -1 ){
                twoArray[0][0] = LengthNum; 
                twoArray[0][1] = 1;
                elements[0][0] = indexline; 
                laset_busy = 0; 
            }

            else{
                twoArray[laset_busy+1][0] = LengthNum; 
                twoArray[laset_busy+1][1] = 1;
                elements[laset_busy+1][0] = indexline; 
                
                laset_busy++; 

            }
        }




    }



    int max_tekrar = -2; 

    for (int i = 0; i < count - count_2 + 1 ; i++){
        
        if (max_tekrar < twoArray[i][1]){
            max_tekrar = twoArray[i][1]; 
        }
    }

    for (int i = 0; i < count - count_2 +1; i++){
        if (twoArray[i][1] < max_tekrar){
            for (int r =0; r < count; r++){

                if(elements[i][r] == -1){
                    break; 
                }

                System.out.println(elements[i][r]);
                
            }
        }
    }




}
}
