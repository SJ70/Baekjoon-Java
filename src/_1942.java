import java.io.*;
import java.util.*;

public class _1942 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for(int t=0; t<3; t++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] from = toIntArray(st.nextToken());
            int[] to = toIntArray(st.nextToken());
            int result = 0;
            while(true){

                int tmp = from[0]*10000 + from[1]*100 + from[2];
                if(tmp%3==0) result++;

                if(isSame(from,to)) break;

                from[2]++;
                if(from[2]==60){
                    from[2] = 0;
                    from[1]++;
                }
                if(from[1]==60){
                    from[1] = 0;
                    from[0]++;
                }
                if(from[0]==24) {
                    from[0] = 0;
                }

            }

            sb.append(result).append('\n');
        }

        System.out.println(sb);
    }
    public static int[] toIntArray(String str){
        StringTokenizer st = new StringTokenizer(str,":");
        int[] arr = new int[3];
        for(int i=0; i<3; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        return arr;
    }
    public static boolean isSame(int[] a, int[] b){
        return (a[0]==b[0] && a[1]==b[1] && a[2]==b[2]);
    }
}
