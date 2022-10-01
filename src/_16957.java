import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class _16957 {
    public static void main(String[] args) throws IOException{
        Init();
        for(int i=0; i<Order.size(); i++){
            MoveBall(Order.get(i));
        }
        PrintResult();
    }
    static int R,C;
    static int[][][] Map;
    static final int VALUE = 0;
    static final int Ball_cnt = 1;
    public static void Init() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        Map = new int[2][R][C];
        for(int r=0; r<R; r++){
            st = new StringTokenizer(br.readLine());
            for(int c=0; c<C; c++){
                Map[VALUE][r][c] = Integer.parseInt(st.nextToken());
                Map[Ball_cnt][r][c] = 1;
                InsertOrder(r,c);
            }
        }
//        for(int i=0; i<Order.size(); i++){
//            System.out.printf("%d %d %d\n",Order.get(i)[0],Order.get(i)[1],Order.get(i)[2]);
//        }
    }
    static ArrayList<int[]> Order = new ArrayList<>();
    static final int ORDER_R = 1;
    static final int ORDER_C = 2;
    public static void InsertOrder(int r, int c){
        int insertIndex = BS(Map[VALUE][r][c],0,Order.size());
        int[] tmp = {Map[VALUE][r][c], r, c};
        Order.add(insertIndex, tmp );
    }
    public static int BS(int object, int left, int right){
        if(left==right) return left;
        int mid = (left+right)/2;
        if(object==Order.get(mid)[VALUE]) return mid;
        if(object>Order.get(mid)[VALUE]) return BS(object,0,mid);
        else return BS(object,mid+1,right);
    }
    public static void MoveBall(int[] info){
        int object = info[VALUE];
        int r = info[ORDER_R];
        int c = info[ORDER_C];
        int Next_object = object;
        int Next_r = r;
        int Next_c = c;
        for(int i=r-1; i<=r+1; i++){
            if(i<0 || i>=R) continue;
            for(int j=c-1; j<=c+1; j++){
                if(j<0 || j>=C) continue;
                if(Next_object > Map[VALUE][i][j]){
                    Next_object = Map[VALUE][i][j];
                    Next_r = i;
                    Next_c = j;
                }
            }
        }
        if(r==Next_r && c==Next_c) return;
        Map[Ball_cnt][Next_r][Next_c]+=Map[Ball_cnt][r][c];
        Map[Ball_cnt][r][c]=0;
    }
    public static void PrintResult(){
        StringBuilder sb = new StringBuilder();
        for(int r=0; r<R; r++){
            for(int c=0; c<C; c++){
                sb.append(Map[Ball_cnt][r][c]+" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}