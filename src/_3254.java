import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _3254 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        int time;
        for(time=1; time<=21; time++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            Throw(Integer.parseInt(st.nextToken())-1,'S');
            //PrintMap();
            if(Bingo) break;
            Throw(Integer.parseInt(st.nextToken())-1,'J');
            //PrintMap();
            if(Bingo) break;
        }
        if(Bingo) System.out.println(Winner+" "+time);
        else System.out.println("ss");
    }
    static char[][] Map = new char[6][7];
    public static void Throw(int c, char player){
         for(int r=0; r<6; r++){
             if(r==5 || Map[r+1][c]!='\0'){
                 Map[r][c] = player;
                 Check4(r,c,player);
                 break;
             }
         }
    }
    static boolean Bingo = false;
    static String Winner;
    public static void Check4(int r, int c, char player){
        if(( 1 + CheckSame(r,c,-1,0,player) + CheckSame(r,c,1,0,player) >= 4 ) //수직
         ||( 1 + CheckSame(r,c,0,-1,player) + CheckSame(r,c,0,1,player) >= 4 ) //수평
         ||( 1 + CheckSame(r,c,1,-1,player) + CheckSame(r,c,-1,1,player) >= 4 )//대각1
         ||( 1 + CheckSame(r,c,-1,-1,player) + CheckSame(r,c,1,1,player) >= 4 )//대각2
        ){
            Bingo = true;
            Winner = player=='S'?"sk":"ji";
        }
    }
    public static int CheckSame(int r, int c, int dr, int dc, char player){
        r+=dr;
        c+=dc;
        if( r<0 || r>=6 || c<0 || c>=7 ) return 0;
        if(Map[r][c]==player)
            return 1 + CheckSame(r,c,dr,dc,player);
        else
            return 0;
    }
    public static void PrintMap(){
        System.out.println();
        for(int r=0; r<6; r++){
            for(int c=0; c<7; c++){
                System.out.printf(" %c",Map[r][c]=='\0'?'.':Map[r][c]);
            }
            System.out.println();
        }
    }
}
