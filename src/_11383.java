import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _11383 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        String[] arr = new String[R];
        for(int r=0; r<R; r++){
            arr[r] = br.readLine();
        }
        for(int r=0; r<R; r++){
            String str = br.readLine();
            for(int c=0; c<C; c++){
                char c1 = str.charAt(2*c);
                char c2 = str.charAt(2*c+1);
                char c3 = arr[r].charAt(c);
                if(c1!=c2 || c2!=c3){
                    System.out.print("Not Eyfa");
                    return;
                }
            }
        }
        System.out.print("Eyfa");
    }
}