import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class _4386 {
    static int N;
    static double[][] pos, D;
    static boolean[][] connected;
    public static class Vortex{
        double value;
        int i1,i2;
        public Vortex(double value, int i1, int i2){
            this.value = value;
            this.i1 = i1;
            this.i2 = i2;
        }
    }
    static ArrayList<Vortex> Sorted;
    static double result_Sum = 0f;
    static int connectCnt = 0;
    public static void main(String[] args) throws IOException{
        init();
//        printList();
//        printMatrix();
        for(Vortex v : Sorted){
            connect(v);
//            printConnected();
            if(connectCnt == N*N-N) break;
        }
        System.out.printf("%f",result_Sum);
    }
    public static void init() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        pos = new double[N][2];
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            pos[i][0] = Double.parseDouble(st.nextToken());
            pos[i][1] = Double.parseDouble(st.nextToken());
        }

        Sorted = new ArrayList<>();
        D = new double[N][N];
        connected = new boolean[N][N];
        for(int r=0; r<N; r++){
            for(int c=r+1; c<N; c++){
                D[r][c] = D[c][r] = getDistance(r,c);
                AddList(r,c);
            }
        }
    }
    public static double getDistance(int i1, int i2){
        double A = pos[i1][0] - pos[i2][0];
        double B = pos[i1][1] - pos[i2][1];
        return Math.sqrt(A*A + B*B);
    }
    public static void AddList(int i1, int i2){
        if(Sorted.isEmpty()){
            Sorted.add(new Vortex(D[i1][i2],i1,i2));
        }
        else {
            Sorted.add(getListIndex(D[i1][i2], 0,Sorted.size()-1), new Vortex(D[i1][i2],i1,i2));
        }
//        printList();
    }
    public static int getListIndex(double value, int left, int right){
        if(value <= Sorted.get(left).value){
            return left;
        }
        if(value >= Sorted.get(right).value){
            return right+1;
        }

        int mid = (left+right)/2;
//        System.out.printf("%.2f(%d) : %.2f(%d) : %.2f(%d)\n",Sorted.get(left).value,left,Sorted.get(mid).value,mid,Sorted.get(right).value,right);

        if(value < Sorted.get(mid).value)
            return getListIndex(value,left,mid);
        else if(value > Sorted.get(mid).value)
            return getListIndex(value,mid+1,right);
        else
            return mid;
    }
    public static void connect(Vortex v){
        if(!connected[v.i1][v.i2]){
            connected[v.i1][v.i2] = connected[v.i2][v.i1] = true;
            connectCnt+=2;
            result_Sum += v.value;
            floyd();
        }
    }
    public static void floyd(){
        for(int across=0; across<N; across++){
            for(int from=0; from<N; from++){
                if(!connected[from][across]) continue;
                for(int to=from+1; to<N; to++){
                    if(!connected[across][to] || connected[from][to]) continue;
                    connectCnt+=2;
                    connected[from][to] = connected[to][from] = true;
                }
            }
        }
    }
    public static void printList(){
        for(Vortex data : Sorted){
            System.out.printf("%5.2f(%d,%d)\n",data.value,data.i1,data.i2);
        }
        System.out.println();
    }
    public static void printMatrix(){
        for(int r=0; r<N; r++){
            for(int c=0; c<N; c++){
                System.out.printf("%5.2f ",D[r][c]);
            }
            System.out.println();
        }
        System.out.println();
    }
    public static void printConnected(){
        for(int r=0; r<N; r++){
            for(int c=0; c<N; c++){
                System.out.print(connected[r][c]?"  O":"  .");
            }
            System.out.println();
        }
        System.out.println();
    }
}
