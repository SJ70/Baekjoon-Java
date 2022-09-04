import java.util.*;
import java.io.*;

public class _25305 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> arr = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++)
            arr.add(Integer.parseInt(st.nextToken()));
        Collections.sort(arr,Collections.reverseOrder());
        System.out.println(arr.get(k-1));
    }
}