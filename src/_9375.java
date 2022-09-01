import java.io.*;
import java.util.*;
import java.util.Map.*;

public class _9375 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        for(int i=0; i<T; i++){
            Solve();
        }
        bw.flush();
        bw.close();
    }
    public static void Solve() throws IOException{
        HashMap<String,Integer> HM = new HashMap<>();
        int T = Integer.parseInt(br.readLine());
        for(int i=0; i<T; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String str1 = st.nextToken();
            String str2 = st.nextToken();
            if(HM.containsKey(str2))
                HM.replace(str2,HM.get(str2)+1);
            else
                HM.put(str2,1);
        }
        int result = 1;
        for(Entry<String,Integer> entrySet : HM.entrySet()){
            result *= entrySet.getValue() + 1 ;
            //bw.write(entrySet.getKey()+":"+entrySet.getValue()+"\n");
        }
        bw.write((result-1)+"\n");
    }
}