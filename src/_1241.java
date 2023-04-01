import java.io.*;
import java.util.*;

public class _1241 {
    static int[] arr, result;
    static HashMap<Integer, Integer> HM = new HashMap<>(); // 각 숫자들의 갯수
    public static void main(String[] args) throws IOException{
        inputArr();
        initHM();
        fillResultArr();
        printResult();
    }

    public static void inputArr() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        arr = new int[N];
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
    }

    public static void initHM(){
        for(int e : arr){
            HM.put(e, HM.getOrDefault(e,0)+1);
        }
    }

    public static void fillResultArr(){
        result = new int[arr.length];
        for(int i=0; i<arr.length; i++){
            for(int k=1; k<=Math.sqrt(arr[i]); k++){
                if(arr[i]%k==0){
                    result[i] += HM.getOrDefault(arr[i]/k,0);
                    if(arr[i]/k != k){
                        result[i] +=  HM.getOrDefault(k,0);
                    }
                }
            }
        }
    }

    public static void printResult(){
        StringBuilder sb = new StringBuilder();
        for(int e : result){
            sb.append(e>0?e-1:0).append('\n');
        }
        System.out.print(sb);
    }
}
