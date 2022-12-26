import java.io.*;
import java.util.*;

public class _6063 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static char[][] cube = new char[6][9];
    static final int LEFT = 0;
    static final int FRONT = 1;
    static final int RIGHT = 2;
    static final int BACK = 3;
    static final int TOP = 4;
    static final int BOTTOM = 5;

    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException{
        int T = Integer.parseInt(br.readLine());
        for(int i=1; i<=T; i++){
            init();
            int N = Integer.parseInt(br.readLine());
            for(int j=0; j<N; j++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                roll(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
//                printCube();
            }
            sb.append("Scenario #").append(i).append(":\n");
            printCube();
            sb.append('\n');
        }
        System.out.print(sb);
    }
    public static void init() throws IOException{
        StringTokenizer st;
        for(int r=0; r<3; r++){
            st = new StringTokenizer(br.readLine());
            for(int c=0; c<3; c++) cube[TOP][r*3+c] = st.nextToken().charAt(0);
        }
        for(int r=0; r<3; r++){
            st = new StringTokenizer(br.readLine());
            for(int c=0; c<3; c++) cube[LEFT][r*3+c] = st.nextToken().charAt(0);
            for(int c=0; c<3; c++) cube[FRONT][r*3+c] = st.nextToken().charAt(0);
            for(int c=0; c<3; c++) cube[RIGHT][r*3+c] = st.nextToken().charAt(0);
            for(int c=0; c<3; c++) cube[BACK][r*3+c] = st.nextToken().charAt(0);
        }
        for(int r=0; r<3; r++){
            st = new StringTokenizer(br.readLine());
            for(int c=0; c<3; c++) cube[BOTTOM][r*3+c] = st.nextToken().charAt(0);
        }
    }
    public static void roll(int flat, int dir){
        roll_flat(flat, dir==1);
        roll_side(flat, dir==1);
    }
    static int[] roll_flat_index = {0,1,2,5,8,7,6,3};
    public static void roll_flat(int flat, boolean isClockwise){
        if(isClockwise){
            char tmp1 = cube[flat][roll_flat_index[6]];
            char tmp2 = cube[flat][roll_flat_index[7]];
            for(int i=7; i>=2; i--){
                cube[flat][roll_flat_index[i]] = cube[flat][roll_flat_index[i-2]];
            }
            cube[flat][0] = tmp1;
            cube[flat][1] = tmp2;
        }
        else{
            char tmp1 = cube[flat][0];
            char tmp2 = cube[flat][1];
            for(int i=0; i<=5; i++){
                cube[flat][roll_flat_index[i]] = cube[flat][roll_flat_index[i+2]];
            }
            cube[flat][roll_flat_index[6]] = tmp1;
            cube[flat][roll_flat_index[7]] = tmp2;
        }
    }
    static int[][][] roll_side_index = {
            {   {TOP,0},   {TOP,3},   {TOP,6},      {FRONT,0},{FRONT,3},{FRONT,6},  {BOTTOM,0},{BOTTOM,3},{BOTTOM,6},   {BACK,8}, {BACK,5}, {BACK,2}    },  //LEFT
            {   {TOP,6},   {TOP,7},   {TOP,8},      {RIGHT,0},{RIGHT,3},{RIGHT,6},  {BOTTOM,2},{BOTTOM,1},{BOTTOM,0},   {LEFT,8}, {LEFT,5}, {LEFT,2}    },  //FRONT
            {   {TOP,8},   {TOP,5},   {TOP,2},      {BACK,0}, {BACK,3}, {BACK,6},   {BOTTOM,8},{BOTTOM,5},{BOTTOM,2},   {FRONT,8},{FRONT,5},{FRONT,2}   },  //RIGHT
            {   {TOP,2},   {TOP,1},   {TOP,0},      {LEFT,0}, {LEFT,3}, {LEFT,6},   {BOTTOM,6},{BOTTOM,7},{BOTTOM,8},   {RIGHT,8},{RIGHT,5},{RIGHT,2}   },  //BACK
            {   {BACK,2}, {BACK,1},  {BACK,0},      {RIGHT,2},{RIGHT,1},{RIGHT,0},  {FRONT,2}, {FRONT,1},  {FRONT,0},   {LEFT,2}, {LEFT,1}, {LEFT,0}    },  //TOP
            {   {FRONT,6},{FRONT,7}, {FRONT,8},     {RIGHT,6},{RIGHT,7},{RIGHT,8},  {BACK,6},   {BACK,7},   {BACK,8},   {LEFT,6}, {LEFT,7}, {LEFT,8}    },  //BOTTOM
    };
    public static void roll_side(int flat, boolean isClockwise){
        if(isClockwise){
            char tmp1 = cube[roll_side_index[flat][9][0]][roll_side_index[flat][9][1]];
            char tmp2 = cube[roll_side_index[flat][10][0]][roll_side_index[flat][10][1]];
            char tmp3 = cube[roll_side_index[flat][11][0]][roll_side_index[flat][11][1]];
            for(int i=11; i>=3; i--){
                cube[roll_side_index[flat][i][0]][roll_side_index[flat][i][1]] = cube[roll_side_index[flat][i-3][0]][roll_side_index[flat][i-3][1]];
            }
            cube[roll_side_index[flat][0][0]][roll_side_index[flat][0][1]] = tmp1;
            cube[roll_side_index[flat][1][0]][roll_side_index[flat][1][1]] = tmp2;
            cube[roll_side_index[flat][2][0]][roll_side_index[flat][2][1]] = tmp3;
        }
        else{
            char tmp1 = cube[roll_side_index[flat][0][0]][roll_side_index[flat][0][1]];
            char tmp2 = cube[roll_side_index[flat][1][0]][roll_side_index[flat][1][1]];
            char tmp3 = cube[roll_side_index[flat][2][0]][roll_side_index[flat][2][1]];
            for(int i=0; i<=8; i++){
                cube[roll_side_index[flat][i][0]][roll_side_index[flat][i][1]] = cube[roll_side_index[flat][i+3][0]][roll_side_index[flat][i+3][1]];
            }
            cube[roll_side_index[flat][9][0]][roll_side_index[flat][9][1]] = tmp1;
            cube[roll_side_index[flat][10][0]][roll_side_index[flat][10][1]] = tmp2;
            cube[roll_side_index[flat][11][0]][roll_side_index[flat][11][1]] = tmp3;
        }
    }
    public static void printCube(){
        for(int r=0; r<3; r++){
            sb.append("      ");
            for(int c=0; c<3; c++) sb.append(cube[TOP][r*3+c]).append(' ');
            sb.append('\n');
        }
        for(int r=0; r<3; r++){
            for(int c=0; c<3; c++) sb.append(cube[LEFT][r*3+c]).append(' ');
            for(int c=0; c<3; c++) sb.append(cube[FRONT][r*3+c]).append(' ');
            for(int c=0; c<3; c++) sb.append(cube[RIGHT][r*3+c]).append(' ');
            for(int c=0; c<3; c++) sb.append(cube[BACK][r*3+c]).append(' ');
            sb.append('\n');
        }
        for(int r=0; r<3; r++){
            sb.append("      ");
            for(int c=0; c<3; c++) sb.append(cube[BOTTOM][r*3+c]).append(' ');
            sb.append('\n');
        }
    }
}
