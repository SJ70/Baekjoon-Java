import java.io.*;
import java.util.*;

public class _1181 {
    public static class Arr{
        ArrayList<String> arr = new ArrayList<>();
    }
    public static void main(String[] args) throws IOException{
        Arr[] List = new Arr[50];
        for(int i=0; i<50; i++){
            List[i] = new Arr();
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for(int i=0; i<N; i++){
            String str = br.readLine();
            List[str.length()-1].arr.add(str);
        }
        for(int i=0; i<50; i++){
            Collections.sort(List[i].arr);
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String tmp = "";
        for(int i=0; i<50; i++){
            for(int j=0; j<List[i].arr.size(); j++){
                String str = List[i].arr.get(j);
                if(str.equals(tmp)) continue;
                tmp = str;
                bw.write(str+"\n");
            }
        }
        bw.flush();
        bw.close();
    }
}