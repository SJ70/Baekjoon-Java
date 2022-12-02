import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 나갈 수 있다면 높이 = 0
// 나갈 수 없다면 다다를 수 있는 섬의 최소높이 +1
public class _1109_Incomplete {
    static int R,C;
    static Chamber[][] M;
    public static class Chamber{
        char value;
        int sectionNum;
        public Chamber(char c){
            this.value = c;
        }
        public boolean isGround(){
            return this.value=='x';
        }
        public boolean isWater(){
            return this.value=='.';
        }
        public void setSectionNum(int n){
            this.sectionNum = n;
        }
        public void printInfo(){
            System.out.print(isGround()?sectionNum:".");
        }
    }

    public static void main(String[] args) throws IOException{
        init();
        separateSections();
        printSection();
        if(SectionCnt==0){
            System.out.println(-1);
            return;
        }
        observeDepth();
        printResult();
    }

    public static void init() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        M = new Chamber[R][C];
        for(int r=0; r<R; r++){
            String str = br.readLine();
            for(int c=0; c<C; c++){
                M[r][c] = new Chamber(str.charAt(c));
            }
        }
    }

    static boolean[][] visited;
    public static void separateSections(){
        visited = new boolean[R][C];
        int sectionNum = 0;
        for(int r=0; r<R; r++){
            for(int c=0; c<C; c++){
                if(!visited[r][c] && M[r][c].isGround()){
                    sectionNum++;
                    spreadSection(r,c,sectionNum);
//                    System.out.printf("%d,%d\n",r,c);
//                    printSection();
                }
            }
        }
        SectionCnt = sectionNum;
    }
    public static void spreadSection(int r, int c, int num){
//        printM();
        M[r][c].setSectionNum(num);
        visited[r][c] = true;
        for(int i=r-1; i<=r+1; i++){
            if(i<0 || i>=R) continue;
            for(int j=c-1; j<=c+1; j++){
                if(j<0 || j>=C) continue;
                if(!visited[i][j] && M[i][j].isGround()){
                    spreadSection(i,j, num);
                }
            }
        }
    }

    static int SectionCnt, depth;
    static int[] SectionDepth;
    public static void observeDepth(){
        SectionDepth = new int[SectionCnt+1];
        visited = new boolean[R][C];
        // 높이 설정 로직 필요
    }

    public static void printSection(){
        for(int r=0; r<R; r++){
            for(int c=0; c<C; c++){
                M[r][c].printInfo();
            }
            System.out.println();
        }
        System.out.println();
    }
    public static void printSectionDepth(){
        for(int i=1; i<=SectionCnt; i++){
            System.out.printf("[%d:%d] ",i,SectionDepth[i]);
        }
        System.out.println();
    }
    public static void printVisited(){
        for(int r=0; r<R; r++){
            for(int c=0; c<C; c++){
                System.out.print(visited[r][c]?'v':'.');
            }
            System.out.println();
        }
        System.out.println();
    }
    public static void printResult(){
        int[] result = new int[depth+1];
        for(int element : SectionDepth){
            result[element]++;
            System.out.println(element);
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<=depth; i++)
            sb.append(result[i]).append(' ');
        System.out.println(sb);
    }
}
