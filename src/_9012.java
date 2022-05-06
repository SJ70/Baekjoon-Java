import java.io.*;

public class _9012 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException{
        int T = Integer.parseInt(br.readLine());
        for(int k=0; k<T; k++){
            int counter = 0;
            String S = br.readLine();
            for(int i=0; i<S.length(); i++){
                if(counter<0) break; // 괄호가 열리지 않았는데 먼저 닫힌 경우
                else if(S.charAt(i)=='(') counter++;
                else counter--;
            }
            if(counter==0) System.out.println("YES");
            else System.out.println("NO");
        }
    }
}
