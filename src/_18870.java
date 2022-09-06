import java.io.*;
import java.util.*;

public class _18870 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] Num = new int[N];
        ArrayList<Integer> arrSorted = new ArrayList<>();
        for(int i=0; i<N; i++){
            int n = Integer.parseInt(st.nextToken());
            Num[i] = n;
            arrSorted.add(n);
        }

        Collections.sort(arrSorted);

        // 해쉬맵에 (숫자,순위) 삽입
        HashMap<Integer,Integer> hm = new HashMap<>();
        int index = 0;
        for(int i=0; i<arrSorted.size(); i++){
            int n = arrSorted.get(i);
            if(!hm.containsKey(n)){
                hm.put(n,index);
                index++;
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<N; i++){
            sb.append(hm.get(Num[i])+" ");
        }
        System.out.println(sb);
    }
}
