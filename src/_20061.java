import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _20061 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static final int R = 6;
    static final int C = 4;
    static int Score = 0;
    static int[][][] Map = new int[2][R][C];
    static int[][] BlockType;
    static final int GREEN = 0;
    static final int BLUE = 1;
    public static void main(String[] args) throws IOException{
        N = Integer.parseInt(br.readLine());
        BlockType = new int[2][N+1];

        for(int i=1; i<=N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int type = Integer.parseInt(st.nextToken());
            int row = Integer.parseInt(st.nextToken());
            int column = Integer.parseInt(st.nextToken());
            setBlockType(i,type);
            putBlock(GREEN,i,row,column);
            putBlock(BLUE,i,column,row);
//            printMap("put");
            for(int color=GREEN; color<=BLUE; color++){
                eraseLines(color);
                pushLinesIfTooHigh(color);
            }
//            printMap("operate");
        }
//        printMap("");

        StringBuilder sb = new StringBuilder();
        sb.append(Score).append('\n').append(getBlockedTileCnt());
        System.out.println(sb);
    }
    public static void setBlockType(int blockIndex, int type){
        switch(type){
            case 1:
                BlockType[GREEN][blockIndex] = 1;
                BlockType[BLUE][blockIndex] = 1;
                break;
            case 2:
                BlockType[GREEN][blockIndex] = 2;
                BlockType[BLUE][blockIndex] = 3;
                break;
            case 3:
                BlockType[GREEN][blockIndex] = 3;
                BlockType[BLUE][blockIndex] = 2;
                break;
            default:
                break;
        }
    }
    public static void putBlock(int color, int blockIndex, int r, int c){
        switch(BlockType[color][blockIndex]){
            case 1:
                Map[color][0][c] = blockIndex;
//                printMap("put");
                fallBlock(color,0,c);
                break;
            case 2:
                Map[color][0][c] = Map[color][0][c+1] = blockIndex;
//                printMap("put");
                fallBlock(color,0,c);
                break;
            case 3:
                Map[color][0][c] = Map[color][1][c] = blockIndex;
//                printMap("put");
                fallBlock(color,1,c);
                break;
            default: break;
        }
    }
    public static void pushLinesIfTooHigh(int color){
        int lengthToPush=0;
        for(int r=0; r<=1; r++){
            if(lengthToPush==0){
                for(int c=0; c<4; c++){
                    if(Map[color][r][c]>0){
                        lengthToPush=2-r;
                        break;
                    }
                }
            }
        }
        if(lengthToPush==0) return;

        for(int r=R-1; r>=2; r--){
            for(int c=0; c<C; c++){
                Map[color][r][c] = Map[color][r-lengthToPush][c];
                Map[color][r-lengthToPush][c] = 0;
            }
        }
//        printMap("push");
    }
    public static void eraseLines(int color){
        for(int r=2; r<R; r++){
            eraseLine(color, r);
        }
    }
    public static void eraseLine(int color, int r){
        for(int c=0; c<C; c++){
            if(Map[color][r][c]==0) return;
        }
        for(int c=0; c<C; c++){
            Map[color][r][c] = 0;
        }
//        printMap("erase");
        fallFloatedBlocksToErasedLine(2,r,color);
        Score++;
    }
    public static void fallFloatedBlocksToErasedLine(int rFrom, int rUntil, int color){
        for(int r=rUntil; r>=rFrom; r--){
            for(int c=0; c<C; c++){
                Map[color][r][c] = Map[color][r-1][c];
            }
        }
        for(int c=0; c<C; c++){
            Map[color][1][c] = 0;
        }
    }
    public static void fallBlock(int color, int r, int c){
        int blockIndex = Map[color][r][c];
        int arrival;
        switch(BlockType[color][blockIndex]){
            case 1:
                Map[color][r][c] = 0;
                arrival = getFloor(r,R-1,color,c);
                Map[color][arrival][c] = blockIndex;
                break;
            case 2:
                // 가로 블럭이 떨어지지 않은 경우 :
                if(c-1>=0 && Map[color][r][c-1]==blockIndex) break;
                Map[color][r][c] = Map[color][r][c+1] = 0;
                arrival = Math.min(getFloor(r,R-1,color,c), getFloor(r,R-1,color,c+1));
                Map[color][arrival][c] = Map[color][arrival][c+1] = blockIndex;
                break;
            case 3:
                if(r==R-1 || Map[color][r+1][c]>0){
                    break;
                }
                else if(r-1<0 || Map[color][r-1][c]!=blockIndex){
                    Map[color][r][c] = 0;
                    arrival = getFloor(r,R-1,color,c);
                    Map[color][arrival][c] = blockIndex;
                }
                else{
                    Map[color][r][c] = Map[color][r-1][c] = 0;
                    arrival = getFloor(r,R-1,color,c);
                    Map[color][arrival][c] = Map[color][arrival-1][c] = blockIndex;
                }
                break;
            default:
                break;
        }
//        printMap("fall");
    }
    public static int getFloor(int rFrom, int rUntil, int color, int c){
        for(int r=rFrom; r<=rUntil-1; r++){
            if(Map[color][r+1][c]>0){
                return r;
            }
        }
        return R-1;
    }
    public static void printMap(String task){
        System.out.println(task);
        System.out.print(" Green               Blue\n");
        for(int r=0; r<R; r++){
            for(int i=GREEN; i<=BLUE; i++){
                for(int c=0; c<C; c++){
                    System.out.printf("%4d",Map[i][r][c]);
                }
                System.out.print("    ");
            }
            System.out.println();
        }
        System.out.println();
    }
    public static int getBlockedTileCnt(){
        int result = 0;
        for(int color=GREEN; color<=BLUE; color++){
            for(int r=0; r<R; r++){
                for(int c=0; c<C; c++){
                    if(Map[color][r][c]>0){
                        result++;
                    }
                }
            }
        }
        return result;
    }
}
