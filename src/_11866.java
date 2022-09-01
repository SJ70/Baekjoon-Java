import java.io.*;
import java.util.*;

public class _11866 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N,K;
    static int index = 0;
    static ArrayList<Integer> arr;
    public static void main(String[] args) throws IOException{
        Init();
        bw.write("<");
        while(true){
            bw.write(String.valueOf(Remove()));
            if(arr.size()==0) break;
            bw.write(", ");
        }
        bw.write(">");
        bw.flush();
        bw.close();
    }
    public static void Init() throws IOException{
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new ArrayList<>();
        for(int i=1; i<=N; i++){
            arr.add(i);
        }
    }
    public static int Remove(){
        index = (index+K-1) % arr.size();
        int result = arr.get(index);
        arr.remove(index);
        return result;
    }
}
