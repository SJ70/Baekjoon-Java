import java.io.*;
import java.util.*;

public class _16946 {
    public static void main(String[] args) throws IOException{
        Init();
        while(!SpaceQ.isEmpty()){
            CheckSection(SpaceQ.poll(),SpaceQ.poll());
        }
//        PrintMap();
//        PrintSectionNum();
//        PrintSectionSize();
        while(!WallQ.isEmpty()){
            GetResult(WallQ.poll(),WallQ.poll());
        }
        PrintMap();
        bw.flush();
        bw.close();
    }
    //초기화
    static int R,C;
    static int[][] Map;
    static Integer[][] SectionNum;
    static ArrayList<Integer> SectionSize = new ArrayList<>();
    static Queue<Integer> WallQ = new ArrayDeque<>();
    static Queue<Integer> SpaceQ = new ArrayDeque<>();
    public static void Init() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        Map = new int[R][C];
        SectionNum = new Integer[R][C];
        for(int r=0; r<R; r++){
            String str = br.readLine();
            for(int c=0; c<C; c++){
                Map[r][c] = str.charAt(c)-'0';
                if(Map[r][c]==0){
                    SpaceQ.add(r);
                    SpaceQ.add(c);
                }
                else{
                    WallQ.add(r);
                    WallQ.add(c);
                }
            }
        }
    }
    //섹션 구분
    static int SNum = 0;
    static int SSize;
    public static void CheckSection(int r, int c){
        if(SectionNum[r][c]!=null) return;
        SSize=0;
        CheckNearby(r,c);
        SectionSize.add(SSize);
        SNum++;
    }
    public static void CheckNearby(int r, int c){
        if( r<0 || r>=R || c<0 || c>=C || SectionNum[r][c]!=null || Map[r][c]!=0 ) return;
        SectionNum[r][c] = SNum;
        SSize++;
        CheckNearby(r+1,c);
        CheckNearby(r-1,c);
        CheckNearby(r,c+1);
        CheckNearby(r,c-1);
    }
    //결괏값 도출
    static HashSet<Integer> UsedSection = new HashSet<>();
    public static void GetResult(int r, int c){
        UsedSection.clear();
        int Result = 1;
        Result += GetSectionSize(r-1,c);
        Result += GetSectionSize(r+1,c);
        Result += GetSectionSize(r,c-1);
        Result += GetSectionSize(r,c+1);
        Map[r][c] = Result%10;
    }
    public static int GetSectionSize(int r, int c){
        if( r<0 || r>=R || c<0 || c>=C || SectionNum[r][c]==null ) return 0;
        int Num = SectionNum[r][c];
        if(UsedSection.contains(Num)) return 0;
        UsedSection.add(Num);
        return SectionSize.get(Num);
    }
    //출력
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void PrintMap() throws IOException{
        for(int r=0; r<R; r++){
            for(int c=0; c<C; c++){
                bw.write(Map[r][c]+"");
            }
            bw.write("\n");
        }
        bw.write("\n");
    }
    public static void PrintSectionNum() throws IOException{
        bw.write("SectionNum\n");
        for(int r=0; r<R; r++){
            for(int c=0; c<C; c++){
                if(SectionNum[r][c]==null) bw.write(".");
                else bw.write(SectionNum[r][c]+"");
            }
            bw.write("\n");
        }
        bw.write("\n");
    }
    public static void PrintSectionSize() throws IOException{
        bw.write("SectionSize\n");
        for(int i=0; i<SectionSize.size(); i++){
            bw.write(i+" : "+SectionSize.get(i)+"\n");
        }
        bw.write("\n");
    }
}