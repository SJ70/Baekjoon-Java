import java.util.*;
import java.io.*;
public class _1026 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        ArrayList<Integer> A = new ArrayList<>();
        ArrayList<Integer> B = new ArrayList<>();
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            A.add(Integer.parseInt(st1.nextToken()));
            B.add(Integer.parseInt(st2.nextToken()));
        }
        Collections.sort(A);
        Collections.sort(B,Collections.reverseOrder());

//        for(int i=0;i<N;i++)
//            bw.write(String.valueOf(A.get(i)));
//        bw.write("\n");
//        for(int i=0;i<N;i++)
//            bw.write(String.valueOf(B.get(i)));

        int result = 0;
        for(int i=0;i<N;i++)
            result+=A.get(i)*B.get(i);
        bw.write(String.valueOf(result));
        bw.flush();
    }
}