import java.io.*;

public class _2857 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<5; i++){
            if(br.readLine().contains("FBI")){
                sb.append(i+1).append(' ');
            }
        }
        String result = sb.toString();
        System.out.println(result.length()==0 ? "HE GOT AWAY!" : result);
    }
}
