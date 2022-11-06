import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _10158 {
    static int R,C,initialR,initialC,repeat;
    public static void main(String[] args){
        init();
        StringBuilder sb = new StringBuilder();
        sb.append(getResult(R,initialR)).append(' ').append(getResult(C,initialC));
        System.out.println(sb);
    }
    public static void init(){
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            StringTokenizer st = new StringTokenizer(br.readLine());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            initialR = Integer.parseInt(st.nextToken());
            initialC = Integer.parseInt(st.nextToken());
            repeat = Integer.parseInt(br.readLine());
        }
        catch(Exception e){
        }
    }
    public static int getResult(int size, int pos){
        pos = (pos+repeat)%(2*size);
        if(pos>size) pos = size-(pos-size);
        return pos;
    }
}
