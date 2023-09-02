import java.io.*;
import java.util.*;

public class _4154 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();

        while(true){
            try{
                sb.append(isHeHonest() ? "Stan may be honest\n" : "Stan is dishonest\n");
            }
            catch (IllegalArgumentException e){
                break;
            }
        }

        System.out.print(sb);
    }

    private static boolean isHeHonest() throws IOException {
        int min = 1;
        int max = 10;
        while(true){
            int number = Integer.parseInt(br.readLine());
            if(number == 0){
                throw new IllegalArgumentException("game over");
            }
            switch(br.readLine()){
                case "too high" :
                    if(number <= min){
                        while(!br.readLine().equals("right on"));
                        return false;
                    }
                    max = Math.min(number - 1, max);
                    break;
                case "too low"  :
                    if(number >= max){
                        while(!br.readLine().equals("right on"));
                        return false;
                    }
                    min = Math.max(number + 1, min);
                    break;
                case "right on" :
                    return number >= min && number <= max;
            }
//            System.out.printf("min: %d, max: %d \n",min,max);
        }
    }
}
