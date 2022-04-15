import java.io.*;
import java.util.*;
public class _2729 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        for(int t=0; t<T; t++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String A = st.nextToken();
            String B = st.nextToken();

            int[][] N = new int[3][81];
            for(int i=0; i<A.length(); i++)
                N[0][80-i] = A.charAt(A.length()-1-i)-48;
            for(int i=0; i<B.length(); i++)
                N[1][80-i] = B.charAt(B.length()-1-i)-48;
            /*
            for(int i=0; i<=80; i++)
                System.out.print(N[0][i]);
            System.out.println();
            for(int i=0; i<=80; i++)
                System.out.print(N[1][i]);
            System.out.println();
            */
            for(int i=80; i>0; i--){
                N[2][i] += N[0][i]+N[1][i];
                switch(N[2][i]){
                    case 2: N[2][i-1]=1; N[2][i]=0; break;
                    case 3: N[2][i-1]=1; N[2][i]=1; break;
                }
            }
            boolean tmp = false;
            for(int i=0; i<=80; i++){
                if(N[2][i]>0) tmp = true;
                if(tmp) bw.write(String.valueOf(N[2][i]));
            }
            //출력할 값 없는 경우 0 출력
            if(!tmp) bw.write("0");
            bw.write("\n");
            bw.flush();
        }
    }
}
