import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _2490 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int i=0; i<3; i++){
            System.out.println(GetResult(new StringTokenizer(br.readLine())));
        }
    }
    public static char GetResult(StringTokenizer st){
        int sum = 0;
        for(int i=0; i<4; i++){
            sum += Integer.parseInt(st.nextToken());
        }
        switch(sum){
            case 3 : return 'A';
            case 2 : return 'B';
            case 1 : return 'C';
            case 0 : return 'D';
            case 4 : return 'E';
        }
        return '\0';
    }
}