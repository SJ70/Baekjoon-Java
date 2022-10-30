import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _25904 {
    static int pplCnt,initialVolume;
    static int[] MaxVolume;
    public static void main(String[] args) throws IOException{
        init();
        System.out.print(getLoser());
    }
    public static void init() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        pplCnt = Integer.parseInt(st.nextToken());
        initialVolume = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        MaxVolume = new int[pplCnt];
        for(int i=0; i<pplCnt; i++){
            MaxVolume[i] = Integer.parseInt(st.nextToken());
        }
    }
    public static int getLoser(){
        int i=0;
        int VolumeRequire = initialVolume;
        while(true){
            if(MaxVolume[i]<VolumeRequire){
                return i+1;
            }
            VolumeRequire++;
            i++;
            if(i==pplCnt) i=0;
        }
    }
}
