import java.io.*;
import java.util.*;

public class _16722 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException{
        Init();
        GetCases();
        int n = Integer.parseInt(br.readLine());
        for(int i=0; i<n; i++){
            Shout(new StringTokenizer(br.readLine()));
        }
        System.out.println(Score);
    }
    static String[] Shape = new String[9];
    static String[] Color = new String[9];
    static String[] BG = new String[9];
    public static void Init() throws IOException{
        for(int i=0; i<9; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            Shape[i] = st.nextToken();
            Color[i] = st.nextToken();
            BG[i] = st.nextToken();
        }
    }
    static ArrayList<Integer> Cases = new ArrayList<>();
    static String[] Selected = new String[9];
    public static void GetCases(){
        for(int i=0; i<7; i++){
            Add(i, 0);
            for(int j=i+1; j<8; j++){
                Add(j,1);
                for(int k=j+1; k<9; k++){
                    Add(k,2);
                    if(isHap()){
                        int caseCode = (i+1)*100+(j+1)*10+(k+1); //케이스 코드 생성 3자리 숫자
                        Cases.add(caseCode);
//                        System.out.print("\n"+caseCode+" : ");
//                        for(int a=0; a<9; a++)
//                            System.out.print(Selected[a]+" ");
                    }
                }
            }
        }
    }
    public static void Add(int index, int i){
        Selected[i] = Shape[index];
        Selected[i+3] = Color[index];
        Selected[i+6] = BG[index];
    }
    public static boolean isHap(){
        if(SameAll(0,1,2) || DiffAll(0,1,2)){
            if(SameAll(3,4,5) || DiffAll(3,4,5)){
                if(SameAll(6,7,8) || DiffAll(6,7,8)){
                    return true;
                }
            }
        }
        return false;
    }
    public static boolean SameAll(int a, int b, int c){
        return (Objects.equals(Selected[a], Selected[b]) && Objects.equals(Selected[a], Selected[c]));
    }
    public static boolean DiffAll(int a, int b, int c){
        return (!Objects.equals(Selected[a], Selected[b]) && !Objects.equals(Selected[b], Selected[c]) && !Objects.equals(Selected[c], Selected[a]));
    }
    static int Score = 0;
    public static void Shout(StringTokenizer st){
        switch(st.nextToken().charAt(0)){
            case 'H' : {
                int[] arr = new int[3];
                for(int i=0; i<3; i++) arr[i]=Integer.parseInt(st.nextToken());
                Arrays.sort(arr);
                Hap(arr[0]*100 + arr[1]*10 + arr[2]);
                break;
            }
            case 'G' : Gyeol(); break;
        }
    }
    public static void Hap(int Code){
        if(Cases.contains(Code)){
            Cases.remove(Cases.indexOf(Code));
            Score++;
        }
        else Score--;
    }
    static boolean GyeolSucceed = false;
    public static void Gyeol(){
        if(!GyeolSucceed && Cases.isEmpty()){
            GyeolSucceed = true;
            Score+=3;
        }
        else Score--;
    }
}
