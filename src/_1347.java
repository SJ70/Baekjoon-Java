import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _1347 {

    static int N;
    static String Move;
    static int M;
    static char[][] Maze;

    public static void main(String[] args) throws IOException{
        init();
        digMaze();
        printMaze();
    }

    private static void init() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        Move = br.readLine();
        M = 2*N+1;
        Maze = new char[M][M];
        for(int r=0; r<M; r++){
            for(int c=0; c<M; c++){
                Maze[r][c] = '#';
            }
        }
    }

    private static void digMaze(){
        int[] dr = {1,0,-1,0};
        int[] dc = {0,-1,0,1};
        int dir = 0;
        int r = N;
        int c = N;
        Maze[r][c] = '.';

        for(int i=0; i<Move.length(); i++){
            switch(Move.charAt(i)){
                case 'F':
                    r += dr[dir];
                    c += dc[dir];
                    Maze[r][c] = '.';
                    break;
                case 'R':
                    dir = dir==3 ? 0 : dir+1;
                    break;
                case 'L':
                    dir = dir==0 ? 3 : dir-1;
                    break;
            }
        }
    }

    private static void printMaze(){
        int left = M-1;
        int right = 0;
        int top = M-1;
        int bottom = 0;
        for(int r=0; r<M; r++){
            for(int c=0; c<M; c++){
                if(Maze[r][c]=='.'){
                    left = Math.min(left,c);
                    right = Math.max(right,c);
                    top = Math.min(top,r);
                    bottom = Math.max(bottom,r);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int r=top; r<=bottom; r++){
            for(int c=left; c<=right; c++){
                sb.append(Maze[r][c]);
            }
            sb.append('\n');
        }
        System.out.print(sb);
    }
}
