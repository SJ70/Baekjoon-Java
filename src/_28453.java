import java.io.*;

public class _28453 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] arr = br.readLine().split(" ");

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<arr.length; i++){
            int lv = Integer.parseInt(arr[i]);
            int result = lv>=300 ? 1 : lv>=275 ? 2 : lv>=250 ? 3 : 4;
            sb.append(result);
            if(i<arr.length) sb.append(' ');
        }
        System.out.println(sb);
    }
}
