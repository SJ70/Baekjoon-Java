import java.io.*;

public class _27325 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String str = br.readLine();
        int index = 1;
        int three = 0;
        for(int i=0; i<N; i++){
            if(str.charAt(i)=='L'){
                if(index>1) index--;
            }
            else{
                if(index<3) index++;
                if(index==3) three++;
            }
        }
        System.out.println(three);
    }
}
