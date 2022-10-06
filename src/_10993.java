import java.util.Scanner;

public class _10993 {
    static int N,R,C,currentHeight;
    static boolean[][] Map;
    static int[] Width;
    static int[] Height;
    public static void main(String[] args){
        Init();
        currentHeight = (N%2==1) ? Height[N]-1 : 0;
        for(int n=N; n>=1; n--){
            if(n%2==1) FillMapOdd(n);
            else FillMapEven(n);
        }
        PrintMap();
    }
    public static void Init(){
        N = new Scanner(System.in).nextInt();
        Width = new int[N+1];
        Height = new int[N+1];
        Height[0] = 0;
        for(int i=1; i<=N; i++){
            Height[i] = (Height[i-1]+1)*2 -1;
            Width[i] = Height[i]*2 -1;
        }
        R = Height[N];
        C = Width[N];
        Map = new boolean[R][C];
    }
    public static void FillMapEven(int n){
        int height = Height[n];
        int width = Width[n];
        for(int i=0; i<height; i++){
            Map[currentHeight][Height[N]-height+i]=true;
            Map[currentHeight][Height[N]+height-2-i]=true;
            Map[currentHeight+i][Height[N]-height+i]=true;
            Map[currentHeight+i][Height[N]+height-2-i]=true;
        }
        currentHeight += Height[n]/2;
    }
    public static void FillMapOdd(int n){
        int height = Height[n];
        int width = Width[n];
        for(int i=0; i<height; i++){
            Map[currentHeight][Height[N]-height+i]=true;
            Map[currentHeight][Height[N]+height-2-i]=true;
            Map[currentHeight-i][Height[N]-height+i]=true;
            Map[currentHeight-i][Height[N]+height-2-i]=true;
        }
        currentHeight -= Height[n]/2;
    }
    public static void PrintMap(){
        StringBuilder sb = new StringBuilder();
        for(int r=0; r<R; r++){
            int limit = N%2==1 ? Height[N]+r : Width[N]-r;
            for(int c=0; c<limit; c++){
                sb.append(Map[r][c]?'*':' ');
            }
            sb.append('\n');
        }
        System.out.print(sb);
    }
}
