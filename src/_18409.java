import java.io.*;

public class _18409 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String str = br.readLine();
        int result = 0;
        for(int i=0; i<N; i++){
            switch(str.charAt(i)){
                case 'a' :
                case 'e' :
                case 'i' :
                case 'o' :
                case 'u' : result++;
            }
        }
        System.out.println(result);
    }
}
