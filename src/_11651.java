import java.io.*;
import java.util.*;

public class _11651 {
    public static void main(String[] args) throws IOException {
        Init();
        Input();
        Print();
    }
    static y[] Pos = new y[200001];
    public static class y{
        ArrayList<Integer> x = new ArrayList<>();
    }
    public static void Init(){
        for(int i=0; i<200001; i++){
            Pos[i] = new y();
        }
    }
    public static void Input() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int X = Integer.parseInt(st.nextToken());
            int Y = Integer.parseInt(st.nextToken())+100000;
            Pos[Y].x.add(X);
        }
    }
    public static void Print() throws IOException{
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for(int i=0; i<200001; i++){
            Collections.sort(Pos[i].x);
            for(int j=0; j<Pos[i].x.size(); j++){
                bw.write(Pos[i].x.get(j)+" "+(i-100000)+"\n");
            }
        }
        bw.flush();
        bw.close();
    }
}
