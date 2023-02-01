import java.io.*;
import java.util.*;

public class _2217 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        HashMap<Integer, Integer> hs = new HashMap<>();
        for(int i=0; i<N; i++){
            int value = Integer.parseInt(br.readLine());
            if(hs.containsKey(value)) hs.replace(value, hs.get(value)+1);
            else hs.put(value,1);
        }
        ArrayList<int[]> arr = new ArrayList<>();
        hs.forEach((key,value)->{
            arr.add(new int[]{key,value});
        });
        Collections.sort(arr, new SortByNum());

        int answer = 0;
        int cnt = 0;
        for(int[] e : arr){
            cnt += e[1];
//            System.out.println(e[0]+","+cnt+","+e[1]);
            answer = Math.max(answer, e[0]*cnt);
        }
        System.out.println(answer);
    }
    private static class SortByNum implements Comparator<int[]>{
        public int compare(int[] a, int[] b){
            return -a[0]+b[0];
        }
    }
}
