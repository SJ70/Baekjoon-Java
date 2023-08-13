import java.io.*;

public class _28454 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int today = toIntegerValue(br.readLine());
        int N = Integer.parseInt(br.readLine());
        int result = 0;
        for(int i=0; i<N; i++){
            int value = toIntegerValue(br.readLine());
            if(today<=value) result++;
        }
        System.out.println(result);
    }
    private static int toIntegerValue(String date){
        String[] arr = date.split("-");
        return Integer.parseInt(arr[0])*10000 + Integer.parseInt(arr[1])*100 + Integer.parseInt(arr[2]);
    }
}
