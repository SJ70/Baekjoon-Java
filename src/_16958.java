import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _16958 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, TimeToTeleport;
    /** [index][s,r,c] */
    static int[][] CityInfo;
    static int[][] M;
    public static void main(String[] args) throws IOException{
        init();
        Floyd();
        System.out.println(Answer());
    }
    public static void init() throws IOException{
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        TimeToTeleport = Integer.parseInt(st.nextToken());

        CityInfo = new int[N][3];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int k=0; k<3; k++)
                CityInfo[i][k] = Integer.parseInt(st.nextToken());
        }

        M = new int[N][N];
        for(int r=0; r<N; r++){
            for(int c=r+1; c<N; c++){
                M[r][c] = M[c][r] = getDistance(r,c);
            }
        }
    }
    public static void Floyd(){
        for(int across=0; across<N; across++){
            for(int from=0; from<N; from++){
                if(across==from) continue;
                for(int to=0; to<N; to++){
                    if(across==to || from==to) continue;
                    M[from][to] = Math.min(M[from][across]+M[across][to], M[from][to]);
                }
            }
//            printMatrix();
        }
    }
    public static void printMatrix(){
        for(int r=0; r<N; r++){
            for(int c=0; c<N; c++){
                System.out.printf("%4d",M[r][c]);
            }
            System.out.println();
        }
        System.out.println();
    }
    public static int getDistance(int from, int to){
        int distance = Math.abs(CityInfo[from][1]-CityInfo[to][1]) + Math.abs(CityInfo[from][2]-CityInfo[to][2]);
        if(CityInfo[from][0]==1 && CityInfo[to][0]==1)
            distance = Math.min(distance, TimeToTeleport);
        return distance;
    }
    public static StringBuilder Answer() throws IOException{
        StringBuilder sb = new StringBuilder();
        int Question = Integer.parseInt(br.readLine());
        for(int q=0; q<Question; q++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken()) -1;
            int j = Integer.parseInt(st.nextToken()) -1;
            sb.append(getDistance(M,i,j)).append('\n');
        }
        return sb;
    }
    public static int getDistance(int[][] Map, int i, int j){
        int from = Math.min(i,j);
        int to = Math.max(i,j);
        return Map[from][to];
    }
}
