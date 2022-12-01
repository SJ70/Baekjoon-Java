import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class _1141 {
    static int N;
    static String[] arr;
    public static void main(String[] args) throws IOException{
        init();
        System.out.println(getResult());
    }
    public static void init() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new String[N];
        for(int i=0; i<N; i++){
            arr[i] = br.readLine();
        }
        Arrays.sort(arr);
//        for(String str : arr) System.out.println(str);
    }
    public static int getResult(){
        int prefixCnt = 0;
        for(int i=0; i<=N-2; i++){
//            System.out.printf("%s : %s\n",arr[i+1],arr[i]);
            if(arr[i+1].startsWith(arr[i]))
                prefixCnt++;
        }
        return N-prefixCnt;
    }
}
