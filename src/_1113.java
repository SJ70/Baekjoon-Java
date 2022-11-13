import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _1113 {
    static int FillAmount = 0;
    public static void main(String[] args) throws IOException{
        init();
        for(int i=1; i<=8; i++){
             while(!DepthQ.get(i).isEmpty()){
                 fillPool(i);
//                 System.out.printf("\n*** depth %d ***\n\n",i);
//                 printSections();
//                 printMap();
             }
        }
        System.out.println(FillAmount);
    }
    static int R,C;
    static int[][] Map;
    static ArrayList<Queue<Integer>> DepthQ;
    public static void init() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        Map = new int[R][C];
        DepthQ = new ArrayList<>();
        for(int i=0; i<=9; i++)
            DepthQ.add(new ArrayDeque<>());

        for(int r=0; r<R; r++){
            String str = br.readLine();
            for(int c=0; c<C; c++){
                Map[r][c] = str.charAt(c)-'0';
                if(Map[r][c]>=1 && Map[r][c]<=8){
                    DepthQ.get(Map[r][c]).add(r);
                    DepthQ.get(Map[r][c]).add(c);
                }
            }
        }
    }

    static int[][] SectionNum;
    static Queue<Integer> FillQ = new ArrayDeque<>();
    static ArrayList<Boolean> canFillSection;
    public static void fillPool(int depth){
        SectionNum = new int[R][C];
        canFillSection = new ArrayList<>();
        canFillSection.add(false); // index 0 (더미)
        int index = 1;

        while(!DepthQ.get(depth).isEmpty()){
            int r = DepthQ.get(depth).poll();
            int c = DepthQ.get(depth).poll();
            if(SectionNum[r][c]==0){
                canFillSection.add(true);
                separateSection(r,c,depth,index);
                index++;
            }
        }
        while(!FillQ.isEmpty()){
            int r = FillQ.poll();
            int c = FillQ.poll();
            if(canFillSection.get(SectionNum[r][c])){
                Map[r][c]++;
                FillAmount++;
                DepthQ.get(depth+1).add(r);
                DepthQ.get(depth+1).add(c);
            }
        }
    }
    public static void separateSection(int r, int c, int depth, int index){
        if(Map[r][c]>depth){
            return;
        }
        if(Map[r][c]<depth){
            canFillSection.set(index,false);
            return;
        }

        if(r==0 || c==0 || r==R-1 || c==C-1)
            canFillSection.set(index,false);

        if(SectionNum[r][c]!=0 || Map[r][c]!=depth) return;
        SectionNum[r][c] = index;
        FillQ.add(r); FillQ.add(c);

        if(r-1>=0) separateSection(r-1,c,depth,index);
        if(r+1<R) separateSection(r+1,c,depth,index);
        if(c-1>=0) separateSection(r,c-1,depth,index);
        if(c+1<C) separateSection(r,c+1,depth,index);
    }
    public static void printMap(){
        System.out.printf("[depth] \n");
        for(int r=0; r<R; r++){
            for(int c=0; c<C; c++){
                System.out.print(Map[r][c]);
            }
            System.out.println();
        }
        System.out.println();
    }
    public static void printSections(){
        System.out.printf("[section]");
        for(int i=1; i<canFillSection.size(); i++){
            if(canFillSection.get(i))
                System.out.printf(" %d",i);
        }
        System.out.println();
        for(int r=0; r<R; r++){
            for(int c=0; c<C; c++){
                int n = SectionNum[r][c];
                System.out.print(n==0?".":n);
            }
            System.out.println();
        }
        System.out.println();
    }
}