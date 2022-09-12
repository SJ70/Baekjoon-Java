import java.io.*;
import java.util.*;
// 같은 형태의 행만 전부 켤 수 있음
public class _1034 {
    static int R,C,K;
    static HashMap<String,Integer> HM = new HashMap<>();
    public static void main(String[] args) throws IOException{
        Init();
        // HM에 저장된 가장 많은 형태의 행부터, 다 켤 수 있는지 측정
        for(int i=CntMax; i>=0; i--){
            if(gotAnswer(i)){
                System.out.println(i);
                return;
            }
        }
        System.out.println(0);
    }
    static int CntMax = 1;
    public static void Init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        for(int r=0; r<R; r++){
            String str = br.readLine();
            if(!HM.containsKey(str)) HM.put(str,1);
            else{
                int tmp = HM.get(str)+1;
                HM.replace(str, tmp);
                CntMax = Math.max(CntMax,tmp);
            }
        }
        K = Integer.parseInt(br.readLine());
    }
    public static boolean gotAnswer(int n){
        for(Map.Entry<String,Integer> es : HM.entrySet()){
            if(es.getValue()==n){
                //System.out.println(es.getKey()+":"+es.getValue());
                if(canTurnOnAll(es.getKey())){
                    return true;
                }
            }
        }
        return false;
    }
    public static boolean canTurnOnAll(String str){
        int Zero = 0;
        for(int i=0; i<str.length(); i++){
            if(str.charAt(i)=='0') Zero++;
        }
        // 켜야 하는 전구와 전구 조작 횟수의 홀짝이 맞지 않으면 전부 켤 수 없음
        // 켜야 하는 전구가 전구 조작 횟수보다 많은 경우 켤 수 없음
        return (K%2 == Zero%2) && (Zero <= K);
    }
}
