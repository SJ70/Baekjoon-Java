import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _25955 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] Arr1 = new int[N];
        int[] Arr2 = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            String str = st.nextToken();
            Arr1[i] = Arr2[i] = getInt(str);
        }

        Arrays.sort(Arr2);
        boolean diff = false;
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<N; i++){
            if(Arr1[i]!=Arr2[i]){
                sb.append(getString(Arr2[i])).append(' ');
                diff=true;
            }
        }
        if(diff){
            System.out.println("KO");
            System.out.println(sb);
        }
        else{
            System.out.println("OK");
        }
    }
    public static int getInt(String str){
        int num = 1000 - Integer.parseInt(str.substring(1));
        switch(str.charAt(0)){
            case 'B' : num+=10000; break;
            case 'S' : num+=20000; break;
            case 'G' : num+=30000; break;
            case 'P' : num+=40000; break;
            case 'D' : num+=50000; break;
        }
        return num;
    }
    public static String getString(int num){
        String str = String.valueOf(1000-(num%10000));
        char front = ' ';
        switch(num/10000){
            case 1 : front='B'; break;
            case 2 : front='S'; break;
            case 3 : front='G'; break;
            case 4 : front='P'; break;
            case 5 : front='D'; break;
        }
        return front+str;
    }
}
