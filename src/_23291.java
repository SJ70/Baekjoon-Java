import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _23291 {
    static int[] Map_Line;
    static int[][] Map_Box;
    static Integer[][] Map_Snail;   // 30*30, 시작점: 15,15
    static final int Snail_R = 10;
    static final int Snail_C = 20;
    static final int Snail_R_start = 4;
    static final int Snail_C_start = 5;
    static int N, K;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException{
        init();
        int cnt = 0;
        while( MaxValue() - MinValue() > K ){

            arrange_Line();
//            print_Map_Line();

            convert_Line_to_Snail();
//            print_Map_Snail();
            arrange_Snail();
//            print_Map_Snail();
            convert_Snail_to_Line();
//            print_Map_Line();

            convert_Line_to_Box();
//            print_Map_Box();
            arrange_Box();
//            print_Map_Box();
            convert_Box_to_Line();
//            print_Map_Line();

            cnt++;
        }
        System.out.println(cnt);
    }
    public static void init() throws IOException{
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        Map_Line = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++)
            Map_Line[i] = Integer.parseInt(st.nextToken());
    }

    public static void convert_Line_to_Snail(){
        Map_Snail = new Integer[Snail_R][Snail_C];
        int r = Snail_R_start;
        int c = Snail_C_start;
        int[] r_dir = {0,-1,0,1};
        int[] c_dir = {1,0,-1,0};

        int dir = set_first_dir();
        int current_Index = 0;

        double length = 1.0f;
        while( N-current_Index >= (int)length && N>current_Index ){
            for(int i=0; i<(int)length; i++){
                Map_Snail[r][c] = Map_Line[current_Index];
                r += r_dir[dir];
                c += c_dir[dir];
                current_Index++;
            }
            dir++;
            if(dir==4) dir=0;

            length += 0.5f;
        }

        dir--;
        if(dir==-1) dir=3;
        while(current_Index<N){
            Map_Snail[r][c] = Map_Line[current_Index];
            r += r_dir[dir];
            c += c_dir[dir];
            current_Index++;
        }
    }
    public static int set_first_dir(){
        int n = N-2;
        int dir = 3;
        double length = 2.0f;

        while(n>=(int)length){
            dir--;
            if(dir==-1) dir=3;
            n-=(int)length;

            length += 0.5f;
        }
        return dir;
    }
    public static void convert_Snail_to_Line(){
        Map_Line = new int[N];
        int row_bottom = Snail_R-1;
        while(Map_Snail[row_bottom][Snail_C_start]==null){
            row_bottom--;
        }
        int index = 0;
        for(int c=0; c<Snail_C; c++){
            for(int r=row_bottom; r>=0; r--){
                if(Map_Snail[r][c]==null) break;
                Map_Line[index] = Map_Snail[r][c];
                index++;
            }
        }
    }
    public static void convert_Line_to_Box(){
        Map_Box = new int[4][N/4];
        for(int c=0; c<N/4; c++){
            Map_Box[0][c] = Map_Line[N/4*3-1-c];
            Map_Box[1][c] = Map_Line[N/4+c];
            Map_Box[2][c] = Map_Line[N/4-1-c];
            Map_Box[3][c] = Map_Line[N/4*3+c];
        }
    }
    public static void convert_Box_to_Line(){
        Map_Line = new int[N];
        int index = 0;
        for(int c=0; c<N/4; c++){
            for(int r=3; r>=0; r--){
                Map_Line[index] = Map_Box[r][c];
                index++;
            }
        }
    }

    public static void arrange_Line(){
        int min = MinValue();
        for(int i=0; i<N; i++){
            if(Map_Line[i]==min) Map_Line[i]++;
        }
    }
    static int[][] change;
    public static void arrange_Snail(){
        change = new int[Snail_R][Snail_C];

        //observe
        for(int r=0; r<Snail_R; r++){
            for(int c=0; c<Snail_C; c++){
                if(Map_Snail[r][c]==null) continue;
                if(r-1>=0) move_fish_Snail(r,c,r-1,c);
                if(r+1<Snail_R) move_fish_Snail(r,c,r+1,c);
                if(c-1>=0) move_fish_Snail(r,c,r,c-1);
                if(c+1<Snail_C) move_fish_Snail(r,c,r,c+1);
            }
        }

        //apply
        for(int r=0; r<Snail_R; r++){
            for(int c=0; c<Snail_C; c++){
                if(Map_Snail[r][c]==null) continue;
                Map_Snail[r][c] += change[r][c];
            }
        }
    }
    public static void move_fish_Snail(int r1, int c1, int r2, int c2){
        if(Map_Snail[r2][c2]==null) return;
        int d = (Map_Snail[r1][c1] - Map_Snail[r2][c2]) / 5;
        if(d>0){
            change[r1][c1] -= d;
            change[r2][c2] += d;
        }
    }
    public static void arrange_Box(){
        change = new int[4][N/4];

        //observe
        for(int r=0; r<4; r++){
            for(int c=0; c<N/4; c++){
                if(r-1>=0) move_fish_Box(r,c,r-1,c);
                if(r+1<4) move_fish_Box(r,c,r+1,c);
                if(c-1>=0) move_fish_Box(r,c,r,c-1);
                if(c+1<N/4) move_fish_Box(r,c,r,c+1);
            }
        }

        //apply
        for(int r=0; r<4; r++){
            for(int c=0; c<N/4; c++){
                Map_Box[r][c] += change[r][c];
            }
        }
    }
    public static void move_fish_Box(int r1, int c1, int r2, int c2){
        int d = (Map_Box[r1][c1] - Map_Box[r2][c2]) / 5;
        if(d>0){
            change[r1][c1] -= d;
            change[r2][c2] += d;
        }
    }

    public static void print_Map_Line(){
        for(int i=0; i<N; i++)
            System.out.printf("%2d ",Map_Line[i]);
        System.out.println('\n');
    }
    public static void print_Map_Snail(){
        for(int r=0; r<Snail_R; r++){
            for(int c=0; c<Snail_C; c++){
                if(Map_Snail[r][c]==null) System.out.print(" . ");
                else System.out.printf("%2d ",Map_Snail[r][c]);
            }
            System.out.println();
        }
        System.out.println();
    }
    public static void print_Map_Box(){
        for(int r=0; r<4; r++){
            for(int c=0; c<N/4; c++){
                System.out.printf("%2d ",Map_Box[r][c]);
            }
            System.out.println();
        }
        System.out.println();
    }

    public static int MaxValue(){
        int max = Map_Line[0];
        for(int i=1; i<N; i++){
            if(max < Map_Line[i])
                max = Map_Line[i];
        }
        return max;
    }
    public static int MinValue(){
        int min = Map_Line[0];
        for(int i=1; i<N; i++){
            if(min > Map_Line[i])
                min = Map_Line[i];
        }
        return min;
    }
}
