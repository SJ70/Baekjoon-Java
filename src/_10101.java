import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class _10101 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashSet<Integer> hs = new HashSet<>();

        int sum=0;
        for(int i=0; i<3; i++){
            int value = Integer.parseInt(br.readLine());
            sum += value;
            hs.add(value);
        }

        if(sum!=180){
            System.out.println("Error"); return;
        }

        switch(hs.size()){
            case 1:
                System.out.println("Equilateral"); return;
            case 2:
                System.out.println("Isosceles"); return;
            case 3:
                System.out.println("Scalene"); return;
        }
    }
}
