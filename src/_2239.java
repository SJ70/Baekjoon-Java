import java.util.*;

public class _2239 {
    public static void main(String[] args){
        Input();
        Fill(0);
        Print();
    }
    static int[][] Map = new int[9][9];
    static ArrayList<Integer> ZeroR = new ArrayList<>();
    static ArrayList<Integer> ZeroC = new ArrayList<>();
    static boolean Success;
    public static void Input(){
        Scanner sc = new Scanner(System.in);
        for(int r=0; r<9; r++) {
            String str = sc.nextLine();
            for(int c=0; c<9; c++){
                int N = str.charAt(c)-'0';
                if(N==0){   // 0인 위치만 이후 계산
                    ZeroR.add(r);
                    ZeroC.add(c);
                }
                else Map[r][c] = N;
            }
        }
    }
    public static void Print(){
        for(int r=0; r<9; r++) {
            for(int c=0; c<9; c++)
                System.out.printf("%d",Map[r][c]);
            System.out.println();
        }
        //System.out.println();
    }
    public static void Fill(int index){
        if(index==ZeroR.size()){
            Success=true;
            return;
        }
        int r = ZeroR.get(index);
        int c = ZeroC.get(index);
        for(int i=0; i<=9; i++){
            if(canFill(r,c,i)){
                Map[r][c]=i;
                Fill(index+1);
                if(Success) return;
                Map[r][c]=0;
            }
        }
    }
    public static boolean canFill(int r, int c, int n){
        //가로세로
        for(int i=0; i<9; i++)
            if( Map[r][i]==n || Map[i][c]==n ) return false;
        //뭉탱이
        int r0 = r- r%3;
        int c0 = c- c%3;
        for(int i=0; i<3; i++)
            for(int j=0; j<3; j++)
                if( Map[r0+i][c0+j]==n ) return false;
        return true;
    }
}
