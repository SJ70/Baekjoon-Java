import java.io.*;

public class _3085 {
    public static void main(String[] args) throws IOException{
        Input();
        CntEarly();
        //System.out.println(Max);
        for(int r=0; r<N; r++)
            for(int c=0; c<N; c++)
                Solve(r,c);
        System.out.println(Max);
    }
    static int N;
    static char[][] Map;
    public static void Input() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        Map = new char[N][N];
        for(int r=0; r<N; r++){
            String str = br.readLine();
            for(int c=0; c<N; c++){
                Map[r][c] = str.charAt(c);
            }
        }
    }
    static int Max = 0;
    public static void CntEarly(){
        // 초기값의 가로로 가장 긴 연속을 탐색
        for(int r=0; r<N; r++){
            char tmp = ' ';
            int cnt = 1;
            for(int c=0; c<N; c++){
                if( Map[r][c] == tmp ) cnt++;
                else{
                    Max = Math.max(cnt,Max);
                    cnt = 1;
                    tmp = Map[r][c];
                }
            }
            Max = Math.max(cnt,Max);
        }
        // 초기값의 세로로 가장 긴 연속을 탐색
        for(int c=0; c<N; c++){
            char tmp = ' ';
            int cnt = 1;
            for(int r=0; r<N; r++){
                if( Map[r][c] == tmp ) cnt++;
                else{
                    Max = Math.max(cnt,Max);
                    cnt = 1;
                    tmp = Map[r][c];
                }
            }
            Max = Math.max(cnt,Max);
        }
    }
    public static void Solve(int r, int c){ // 해당 칸과 우측/하단을 바꾸었을 때를 계산하는 함수
        // 바꾼 칸 2칸을 기준으로 탐색
        if( r+1<N && Map[r][c]!=Map[r+1][c] ){
            Change(r,c,r+1,c);
            CntLine(r+1,c);
            CntLine(r,c);
            Change(r,c,r+1,c); //되돌리기
        }
        if( c+1<N && Map[r][c]!=Map[r][c+1] ){
            Change(r,c,r,c+1);
            CntLine(r,c+1);
            CntLine(r,c);
            Change(r,c,r,c+1); //되돌리기
        }
    }
    public static void Change(int r1, int c1, int r2, int c2){
        char tmp = Map[r1][c1];
        Map[r1][c1] = Map[r2][c2];
        Map[r2][c2] = tmp;
    }
    public static void CntLine(int r, int c){ // 해당 칸이 ~색일 때 연속을 확인
        char C = Map[r][c];
        int cnt1=1, cnt2=1;
        // 좌측 확인
        for(int i=c-1; i>=0; i--){
            if(Map[r][i]==C) cnt1++;
            else break;
        }
        // 우측 확인
        for(int i=c+1; i<N; i++){
            if(Map[r][i]==C) cnt1++;
            else break;
        }
        // 상단 확인
        for(int i=r-1; i>=0; i--){
            if(Map[i][c]==C) cnt2++;
            else break;
        }
        // 우측 확인
        for(int i=r+1; i<N; i++){
            if(Map[i][c]==C) cnt2++;
            else break;
        }
        Max = Math.max(cnt1,Max);
        Max = Math.max(cnt2,Max);
    }
}
