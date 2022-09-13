import java.io.*;
import java.util.*;

public class _1520 {
    static int R,C;
    static int[][] Map,Route;
    static boolean[][] Visited;
    static ArrayList<Integer> Value = new ArrayList<>();
    static ArrayList<Integer> RArr = new ArrayList<>();
    static ArrayList<Integer> CArr = new ArrayList<>();
    public static void main(String[] args) throws IOException{
        InitMap();
        InputArr(0,0,1);
        for(int i=0; i<Value.size(); i++){
            //PrintArr(i);
            Visit(RArr.get(i),CArr.get(i));
        }
        System.out.println(Route[R-1][C-1]);
    }
    public static void InitMap() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        Map = new int[R][C];
        Route = new int[R][C]; // 경로의 수 저장
        Visited = new boolean[R][C];
        for(int r=0; r<R; r++){
            st = new StringTokenizer(br.readLine());
            for(int c=0; c<C; c++){
                Map[r][c] = Integer.parseInt(st.nextToken());
            }
        }
    }
    public static void Visit(int r, int c){
        if(r==R-1 && c==C-1) return;
        if(Visited[r][c]) return;
        Visited[r][c]=true;
        if( r-1>=0 && Map[r-1][c]<Map[r][c] ) InputArr(r-1,c,Route[r][c]);
        if( r+1<R && Map[r+1][c]<Map[r][c] ) InputArr(r+1,c,Route[r][c]);
        if( c-1>=0 && Map[r][c-1]<Map[r][c] ) InputArr(r,c-1,Route[r][c]);
        if( c+1<C && Map[r][c+1]<Map[r][c] ) InputArr(r,c+1,Route[r][c]);
    }
    public static void InputArr(int r, int c, int route){
        if(Visited[r][c]) return;
        Route[r][c]+=route;
        int index = BS(Map[r][c],0,Value.size());
        Value.add(index,Map[r][c]);
        RArr.add(index,r);
        CArr.add(index,c);
    }
    public static int BS(int value, int left, int right){
        //System.out.println(value+"?"+left+"~"+right);
        if(left==right) return left;
        int mid = (left+right)/2;
        if(value>Value.get(mid)) return BS(value,left,mid);
        if(value==Value.get(mid)) return mid;
        return BS(value,mid+1,right); //if(value<Value.get(mid))
    }
    public static void PrintArr(int currentIndex){
        System.out.println();
        for(int i=0; i<Value.size(); i++){
            System.out.print((currentIndex==i)?">":" ");
            int r = RArr.get(i);
            int c = CArr.get(i);
            System.out.printf("%2d(%2d,%2d):%2d\n",Value.get(i),r,c,Route[r][c]);
        }
    }
}
