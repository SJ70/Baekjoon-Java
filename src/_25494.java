import java.io.*;
import java.util.StringTokenizer;

public class _25494 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int t=0; t<T; t++){
            int result = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            for(int x=1; x<=a; x++){
                for(int y=1; y<=b; y++){
                    for(int z=1; z<=c; z++){
                        int tmp = x%y;
                        if(y%z==tmp && z%x==tmp){
                            result++;
                        }
                    }
                }
            }
            sb.append(result).append('\n');
        }
        System.out.print(sb);
    }
}
