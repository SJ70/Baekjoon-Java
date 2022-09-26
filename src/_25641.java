import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _25641 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String str = br.readLine();
        int s = 0;
        int t = 0;
        int lastSameIndex = -1;
        for(int i=N-1; i>=0; i--){
            if(str.charAt(i)=='s') s++;
            else t++;
            if(s==t) lastSameIndex = i;
        }
        System.out.println(str.substring(lastSameIndex));
    }
}