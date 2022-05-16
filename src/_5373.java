import java.io.*;
import java.util.StringTokenizer;

public class _5373 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[] index1 = {0,1,2,5,8,7,6,3}; //시계
    static int[] index2 = {3,6,7,8,5,2,1,0}; //반시계
    static class Surface{
        char[] color = new char[9];
        public Surface(char C){
            for(int i=0; i<9; i++)
                    this.color[i] = C;
        }
        public void RollSelf(boolean dir){
            int[] index = (dir) ? index1.clone() : index2.clone();
            char tmp1 = this.color[index[6]];
            char tmp2 = this.color[index[7]];
            for(int i=7; i>1; i--)
                this.color[index[i]] = this.color[index[i-2]];
            this.color[index[0]] = tmp1;
            this.color[index[1]] = tmp2;
        }
        public void Print() throws IOException{
            for(int r=0; r<3; r++){
                for(int c=0; c<3; c++)
                    bw.write(this.color[3*r+c]);
                bw.write("\n");
            }
        }
    }
    static Surface[] Cube = Cube = new Surface[6];
    public static void ResetCube(){
        // 큐브의 인덱스는 교회 모양의 전개도로 (중앙이 윗면)
        Cube[0] = new Surface('w'); // 상: 흰색
        Cube[1] = new Surface('y'); // 하: 노랑
        Cube[2] = new Surface('r'); // 전: 빨강
        Cube[3] = new Surface('o'); // 후: 주황
        Cube[4] = new Surface('g'); // 좌: 초록
        Cube[5] = new Surface('b'); // 우: 파랑
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int i=0; i<T; i++){
            ResetCube();
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++)
                Cubing(st.nextToken());
            Cube[0].Print();
        }
        bw.flush();
    }
    public static void Cubing(String str){
        boolean dir = (str.charAt(1)=='+');
        int[][] index = new int[4][3];
        int[] surface = new int[4];
        switch (str.charAt(0)){
            case 'U' : Cube[0].RollSelf(dir); index = U.clone(); surface = Us.clone(); break;
            case 'D' : Cube[1].RollSelf(dir); index = D.clone(); surface = Ds.clone(); break;
            case 'F' : Cube[2].RollSelf(dir); index = F.clone(); surface = Fs.clone(); break;
            case 'B' : Cube[3].RollSelf(dir); index = B.clone(); surface = Bs.clone(); break;
            case 'L' : Cube[4].RollSelf(dir); index = L.clone(); surface = Ls.clone(); break;
            case 'R' : Cube[5].RollSelf(dir); index = R.clone(); surface = Rs.clone(); break;
        }
        int x = (dir) ? 3 : 0 ;
        char tmp1 = Cube[surface[x]].color[index[x][0]];
        char tmp2 = Cube[surface[x]].color[index[x][1]];
        char tmp3 = Cube[surface[x]].color[index[x][2]];

        if(dir){
            for(int i=3; i>0; i--)
                for(int j=0; j<3; j++)
                    Cube[surface[i]].color[index[i][j]] = Cube[surface[i-1]].color[index[i-1][j]];
        } else {
            for(int i=0; i<3; i++)
                for(int j=0; j<3; j++)
                    Cube[surface[i]].color[index[i][j]] = Cube[surface[i+1]].color[index[i+1][j]];
        }
        x = (dir) ? 0 : 3 ;
        Cube[surface[x]].color[index[x][0]] = tmp1;
        Cube[surface[x]].color[index[x][1]] = tmp2;
        Cube[surface[x]].color[index[x][2]] = tmp3;
    }
    static int[][] U = {{6,7,8},{0,3,6},{2,1,0},{8,5,2}};
    static int[] Us = {3,5,2,4}; //후우전좌
    static int[][] D = {{6,7,8},{8,5,2},{2,1,0},{0,3,6}};
    static int[] Ds = {2,5,3,4}; //전우후좌
    static int[][] F = {{6,7,8},{6,7,8},{2,1,0},{6,7,8}};
    static int[] Fs = {0,5,1,4}; //상우하좌
    static int[][] B = {{2,1,0},{2,1,0},{6,7,8},{2,1,0}};
    static int[] Bs = {0,4,1,5}; //상좌하우
    static int[][] L = {{0,3,6},{0,3,6},{0,3,6},{0,3,6}};
    static int[] Ls = {0,2,1,3}; //상전하후
    static int[][] R = {{8,5,2},{8,5,2},{8,5,2},{8,5,2}};
    static int[] Rs = {0,3,1,2}; //상후하전
}
