import java.io.*;
import java.util.*;

public class _1759 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int L,C;
    static ArrayList<String> arr = new ArrayList<>();

    public static void Input() throws IOException{
        st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<C; i++)
            arr.add(st.nextToken());
        Collections.sort(arr);
    }
    public static boolean isAble(String str){
        int cnt = 0;
        for(int i=0; i<str.length(); i++){
            char c = str.charAt(i);
            if( c=='a'||c=='e'||c=='i'||c=='o'||c=='u' ) cnt++;
        }
        return (cnt>=1 && cnt<=L-2);
    }
    public static void BF(String str, int index) throws IOException{
        if(str.length()==L && isAble(str)) bw.write(str+"\n");
        else{
            for(int i=index; i<C; i++){
                BF(str+arr.get(i),i+1);
            }
        }
    }
    public static void main(String[] args) throws IOException{
        Input();
        BF("",0);
        bw.flush();
    }
}
