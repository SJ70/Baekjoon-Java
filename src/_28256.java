import java.io.*;
import java.util.StringTokenizer;

public class _28256 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException{
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int t=0; t<T; t++){
            sb.append(solve()).append('\n');
        }
        System.out.print(sb);
    }
    private static int solve() throws IOException{
        boolean[] Box = new boolean[8];
        Integer N = 0;
        int[] ChocolateCnt = new int[8];
        input(Box, N, ChocolateCnt);
        count(Box, ChocolateCnt);
        return isSame(ChocolateCnt) ? 1 : 0;
    }
    private static void input( boolean[] Box, Integer N, int[] ChocolateCnt ) throws IOException{
        String[] box = new String[3];
        for(int i=0; i<3; i++){
            box[i] = br.readLine();
        }
        for(int i=0; i<3; i++){
            Box[i] = box[0].charAt(i)=='O';
        }
        Box[3] = box[1].charAt(2)=='O';
        Box[7] = box[1].charAt(0)=='O';

        for(int i=0; i<3; i++){
            Box[4+i] = box[2].charAt(2-i)=='O';
        }
//        for(boolean e : Box)
//        System.out.print(e?'O':'X');
//        System.out.println();

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        for(int i=0; i<N; i++){
            ChocolateCnt[ Integer.parseInt(st.nextToken())-1 ]++;
        }
    }
    private static void count( boolean[] Box, int[] ChocolateCnt ){
        int left = 0;
        int right = 7;
        int cnt = 0;
//        for(int a : ChocolateCnt)
//            System.out.print(a);
//        System.out.println();

        while(right>=0 && Box[right]){
            right--;
            cnt++;
        }
        for(int i=left; i<right; i++){
            if(Box[i]){
                cnt++;
            }
            else{
                if(cnt!=0){
                    ChocolateCnt[cnt-1]--;
//                    System.out.print(cnt);
                    cnt=0;
                }
            }
        }
        if(cnt!=0){
            ChocolateCnt[cnt-1]--;
//            System.out.print(cnt);
        }
//        System.out.println();
    }
    private static boolean isSame(int[] ChocolateCnt){
//        for(int a : ChocolateCnt)
//            System.out.print(a);
//        System.out.println();
        for(int cnt : ChocolateCnt){
            if(cnt!=0) return false;
        }
        return true;
    }
}
