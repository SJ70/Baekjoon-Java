import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _17470 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int R,C,COMMAND_CNT;
    static int[][] Matrix;
    static int[] MiniMap = {0,1,2,3};
    static int[][][][] InnerMapIndex = new int[4][2][2][2]; //[dividedMap][R][C][rcIndex]
    static boolean Rotated;
    public static void main(String[] args) throws IOException{
        init();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<COMMAND_CNT; i++){
//            PrintInnerMapIndex();
//            PrintMatrix();
//            System.out.println();
            Operate(Integer.parseInt(st.nextToken()));
        }
        PrintMatrix();
    }
    public static void init() throws IOException{
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        COMMAND_CNT = Integer.parseInt(st.nextToken());
        Matrix = new int[R][C];
        for(int r=0; r<R; r++){
            st = new StringTokenizer(br.readLine());
            for(int c=0; c<C; c++){
                Matrix[r][c] = Integer.parseInt(st.nextToken());
            }
        }
        for(int i=0; i<2; i++){
            for(int j=0; j<2; j++){
                int k = 2*i + j;
                int r1 = i*(R/2);
                int c1 = j*(C/2);
                int r2 = (i+1)*(R/2)-1;
                int c2 = (j+1)*(C/2)-1;
                //System.out.println(r1+","+c1+"\n"+r1+","+c2+"\n"+r2+","+c1+"\n"+r2+","+c2+"\n");
                InnerMapIndex[k][0][0][0] = r1;
                InnerMapIndex[k][0][0][1] = c1;
                InnerMapIndex[k][0][1][0] = r1;
                InnerMapIndex[k][0][1][1] = c2;
                InnerMapIndex[k][1][0][0] = r2;
                InnerMapIndex[k][1][0][1] = c1;
                InnerMapIndex[k][1][1][0] = r2;
                InnerMapIndex[k][1][1][1] = c2;
            }
        }
    }
    public static void Operate(int o){
        switch(o){
            case 1: FlipUpAndDown(); break;
            case 2: FlipLeftAndRight(); break;
            case 3: Rotate(MiniMap,true); Rotate(InnerMapIndex,true); break;
            case 4: Rotate(MiniMap,false); Rotate(InnerMapIndex,false); break;
            case 5: Rotate(MiniMap,true); break;
            case 6: Rotate(MiniMap,false); break;
        }
    }
    public static void FlipUpAndDown(){
        ChangeValues(MiniMap,0,2);
        ChangeValues(MiniMap,1,3);
        ChangeValues(InnerMapIndex,0,0,1,0);
        ChangeValues(InnerMapIndex,0,1,1,1);
    }
    public static void FlipLeftAndRight(){
        ChangeValues(MiniMap,0,1);
        ChangeValues(MiniMap,2,3);
        ChangeValues(InnerMapIndex,0,0,0,1);
        ChangeValues(InnerMapIndex,1,0,1,1);
    }
    public static void ChangeValues(int[] Arr, int i1, int i2){
        int tmp = Arr[i1];
        Arr[i1] = Arr[i2];
        Arr[i2] = tmp;
    }
    public static void ChangeValues(int[][][][] Arr, int r1, int c1, int r2, int c2){
        for(int k=0; k<4; k++){
            for(int i=0; i<2; i++){
                int tmp = Arr[k][r1][c1][i];
                Arr[k][r1][c1][i] = Arr[k][r2][c2][i];
                Arr[k][r2][c2][i] = tmp;
            }
        }
    }
    public static void Rotate(int[] Arr, boolean Clockwise){
        int a,b;
        if(Clockwise){
            a=2;
            b=1;
        }
        else{
            a=1;
            b=2;
        }
        int tmp = Arr[0];
        Arr[0] = Arr[a];
        Arr[a] = Arr[3];
        Arr[3] = Arr[b];
        Arr[b] = tmp;
    }
    public static void Rotate(int[][][][] Arr, boolean Clockwise){
        Rotated=!Rotated;
        int a,b;
        if(Clockwise){
            a=1;
            b=0;
        }
        else{
            a=0;
            b=1;
        }
        for(int k=0; k<4; k++){
            for(int i=0; i<2; i++){
                int tmp = Arr[k][0][0][i];
                Arr[k][0][0][i] = Arr[k][a][b][i];
                Arr[k][a][b][i] = Arr[k][1][1][i];
                Arr[k][1][1][i] = Arr[k][b][a][i];
                Arr[k][b][a][i] = tmp;
            }
        }
    }
    public static void PrintInnerMapIndex(){
        for(int k=0; k<3; k+=2){
            for(int r=0; r<2; r++){
                for(int c=0; c<2; c++){
                    System.out.printf("%d,%d ",InnerMapIndex[k][r][c][0],InnerMapIndex[k][r][c][1]);
                }
                for(int c=0; c<2; c++){
                    System.out.printf("%d,%d ",InnerMapIndex[k+1][r][c][0],InnerMapIndex[k+1][r][c][1]);
                }
                System.out.println();
            }
        }
        System.out.println();
    }
    public static void PrintMatrix(){
        StringBuilder sb = new StringBuilder();
        int row = Rotated?1:0;
        int column = Rotated?0:1;
        for(int k=0; k<3; k+=2){
            int r1 = InnerMapIndex[MiniMap[k]][0][0][row];
            int r2 = InnerMapIndex[MiniMap[k]][1][0][row];
            int r3 = InnerMapIndex[MiniMap[k+1]][0][1][row];
            int r4 = InnerMapIndex[MiniMap[k+1]][1][1][row];
            int c1 = InnerMapIndex[MiniMap[k]][0][0][column];
            int c2 = InnerMapIndex[MiniMap[k]][0][1][column];
            int c3 = InnerMapIndex[MiniMap[k+1]][1][0][column];
            int c4 = InnerMapIndex[MiniMap[k+1]][1][1][column];
            if(r1==r3){
                for(int r=r1; (r1<r2)?r<=r2:r>=r2; r+=(r1<r2)?1:-1){
                    for(int c=c1; (c1<c2)?c<=c2:c>=c2; c+=(c1<c2)?1:-1){
                        sb.append(Matrix[Rotated?c:r][Rotated?r:c]).append(' ');
                    }
                    for(int c=c3; (c3<c4)?c<=c4:c>=c4; c+=(c3<c4)?1:-1){
                        sb.append(Matrix[Rotated?c:r][Rotated?r:c]).append(' ');
                    }
                    sb.append('\n');
                }
            }
            else{
                StringBuilder[] sbTmp = new StringBuilder[Rotated?C:R];
                for(int r=0; r<(Rotated?C:R); r++){
                    sbTmp[r] = new StringBuilder();
                }
                int sb_row = 0;
                for(int r=r1; (r1<r2)?r<=r2:r>=r2; r+=(r1<r2)?1:-1){
                    for(int c=c1; (c1<c2)?c<=c2:c>=c2; c+=(c1<c2)?1:-1){
                        sbTmp[sb_row].append(Matrix[Rotated?c:r][Rotated?r:c]).append(' ');
                    }
                    sb_row++;
                }
                sb_row = 0;
                for(int r=r3; (r3<r4)?r<=r4:r>=r4; r+=(r3<r4)?1:-1){
                    for(int c=c1; (c1<c2)?c<=c2:c>=c2; c+=(c1<c2)?1:-1){
                        sbTmp[sb_row].append(Matrix[Rotated?c:r][Rotated?r:c]).append(' ');
                    }
                    sb_row++;
                }
                for(int r=0; r<(Rotated?C:R)/2; r++){
                    sb.append(sbTmp[r]).append('\n');
                }
            }
        }
        System.out.print(sb);
    }
}