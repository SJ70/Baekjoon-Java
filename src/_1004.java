import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1004 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static int x1,y1,x2,y2;
    static int PlanetsCnt,Result;
    public static void main(String[] args) throws IOException{
        int T = Integer.parseInt(br.readLine());
        for(int t=0; t<T; t++){
            init();
            for(int i=0; i<PlanetsCnt; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                int Px = Integer.parseInt(st.nextToken());
                int Py = Integer.parseInt(st.nextToken());
                int Pr = Integer.parseInt(st.nextToken());
                Pr *= Pr;   //GetDistance()가 오차를 방지하기 위해 루트를 하지 않음.
                if(PassByPlanetarySystem(Px,Py,Pr)){
                    Result++;
                }
            }
            sb.append(Result).append('\n');
        }
        System.out.print(sb);
    }
    public static void init() throws IOException{
        StringTokenizer st = new StringTokenizer(br.readLine());
        x1 = Integer.parseInt(st.nextToken());
        y1 = Integer.parseInt(st.nextToken());
        x2 = Integer.parseInt(st.nextToken());
        y2 = Integer.parseInt(st.nextToken());
        PlanetsCnt = Integer.parseInt(br.readLine());
        Result = 0;
    }
    public static boolean PassByPlanetarySystem(int Px, int Py, int Pr){
        //출발점이나 도착점이 행성계 경계에 걸쳐진 경우 역시 입력으로 주어지지 않는다.
        int Dist_A_P = getDistance(x1,y1,Px,Py);
        boolean A_in_PS = Dist_A_P < Pr;
        int Dist_B_P = getDistance(x2,y2,Px,Py);
        boolean B_in_PS = Dist_B_P < Pr;
        return A_in_PS != B_in_PS;
    }
    public static int getDistance(int x1, int y1, int x2, int y2){
        //오차를 방지하기 위해 루트는 하지 않음.
        return (x1-x2)*(x1-x2) + (y1-y2)*(y1-y2);
    }
}