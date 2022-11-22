import java.io.*;

public class _26004 {
    static int[] cnt = new int[5];
    public static void main(String[] args) throws IOException{
        init();
        int result = Math.min(Math.min(Math.min(cnt[0],cnt[1]),Math.min(cnt[2],cnt[3])),cnt[4]);
        System.out.println(result);
    }
    public static void init() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String str = br.readLine();
        for(int i=0; i<N; i++){
            switch(str.charAt(i)){
                case'H' : cnt[0]++; break;
                case'I' : cnt[1]++; break;
                case'A' : cnt[2]++; break;
                case'R' : cnt[3]++; break;
                case'C' : cnt[4]++; break;
            }
        }
    }
}
