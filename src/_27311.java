import java.io.*;
import java.util.*;

public class _27311 {
    public static void main(String[] args) throws IOException{
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<T; i++){
            sb.append(getResult()).append('\n');
        }
        System.out.println(sb);
    }
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static int getResult() throws IOException{
        int[][] info = new int[2][3]; // {start, end, cnt}
        StringTokenizer st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        int r=0;
        // #이 나올 때까지 탐색, 있다면 info[0]에 추가
        for(; r<R; r++){
            String str = br.readLine();

            // 연속을 탐색
            int c=0;
            for(; c<C && str.charAt(c)=='.'; c++);
            if(c==C) continue; // 모두 '.'이라면 다음 줄

            info[0][0] = c;
            for(; c<C && str.charAt(c)=='#'; c++);
            info[0][1] = c-1;
            info[0][2] = 1;

//            System.out.printf("%d, %d \n",info[0][0],info[0][1]);

            // 연속되지 않은 #
            for(; c<C; c++){
                if(str.charAt(c)=='#'){
                    for(r++; r<R; r++) br.readLine(); // 남은 입력 버리기
                    return 0;
                }
            }
            break;
        }

        // 다른 모양이 나올 때까지 탐색, 있다면 info[1]에 추가
        for(r++; r<R; r++){
            String str = br.readLine();

            // 연속을 탐색
            int c=0;
            for(; c<C && str.charAt(c)=='.'; c++);
            if(c==C){
                // 모두 '.'
                for(r++; r<R; r++) br.readLine(); // 남은 입력 버리기
                return 0;
            }
            int start = c;
            for(; c<C && str.charAt(c)=='#'; c++);
            int end = c-1;
//            System.out.printf("%d, %d \n",start,end);

            // 연속되지 않은 #
            for(; c<C; c++){
                if(str.charAt(c)=='#'){
                    for(r++; r<R; r++) br.readLine(); // 남은 입력 버리기
                    return 0;
                }
            }

            if(info[0][0]==start && info[0][1]==end){
                info[0][2]++;
            }
            else{
                if(info[0][0]!=start && info[0][1]!=end){
                    // 둘 중 하나는 값이 같아야 함
                    for(r++; r<R; r++) br.readLine(); // 남은 입력 버리기
                    return 0;
                }
                info[1][0]=start;
                info[1][1]=end;
                info[1][2]=1;
                break;
            }
        }

        // info[1]의 갯수를 측정
        for(r++; r<R; r++){
            String str = br.readLine();

            // 연속을 탐색
            int c=0;
            for(; c<C && str.charAt(c)=='.'; c++);
            if(c==C){
                // 모두 '.'
                break;
            }
            int start = c;
            for(; c<C && str.charAt(c)=='#'; c++);
            int end = c-1;
//            System.out.printf("%d, %d \n",start,end);

            if(info[1][0]==start && info[1][1]==end){
                info[1][2]++;
            }
            else{
                for(r++; r<R; r++) br.readLine(); // 남은 입력 버리기
                return 0;
            }
        }

        // 남은 줄이 비어있는지 확인
        for(r++; r<R; r++){
            String str = br.readLine();
            for(int c=0; c<C; c++) {
                if(str.charAt(c)=='#'){
                    for(r++; r<R; r++) br.readLine(); // 남은 입력 버리기
                    return 0;
                }
            }
        }

        int shortIndex = (info[0][1]-info[0][0] < info[1][1]-info[1][0]+1) ? 0 : 1;
        int longIndex = 1 - shortIndex;
        int shortWidth = info[shortIndex][1]-info[shortIndex][0]+1;
        int shortHeight = info[shortIndex][2];
        int longWidth = info[longIndex][1]-info[longIndex][0]+1;
        int longHeight = info[longIndex][2];
//        System.out.printf("%d %d %d %d\n",shortWidth,shortHeight,longWidth,longHeight);

        return (shortWidth==longHeight && shortHeight==longWidth-shortWidth) ? 1 : 0;
    }
}
