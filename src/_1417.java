import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class _1417 {
    static int N, Dasom;
    static int[] competitors;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        if(N==1) {
            System.out.print(0);
            return;
        }
        Dasom = Integer.parseInt(br.readLine());
        final int DasomInitialValue = Dasom;
        competitors = new int[N-1];
        for(int i=0; i<N-1; i++){
            int votes = Integer.parseInt(br.readLine());
            competitors[i] = votes;
        }
        Arrays.sort(competitors);

        while(true){
            //System.out.println();
            if(Dasom > competitors[N-2]){
                System.out.print(Dasom - DasomInitialValue);
                return;
            }
            for(int i=N-2; i>=0; i--){
                if(Dasom > competitors[i]) break;
                if(competitors[i]<competitors[N-2]) break;
                Dasom++;
                competitors[i]--;
                //PrintStatus();
            }
        }
    }
    public static void PrintStatus(){
        System.out.print(Dasom+",");
        for(int i : competitors){
            System.out.printf("%2d",i);
        }
        System.out.println();
    }
}
