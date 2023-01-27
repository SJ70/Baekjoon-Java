import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _27211 {
    public static void main(String[] args) throws IOException{
        input();
//        printMap();
        int sectionNum = 0;
        for(int r=0; r<R; r++){
            for(int c=0; c<C; c++){
                if(Map[r][c]==0){
                    sectionNum++;
                    setSectionNum(r,c,sectionNum);
                }
            }
        }
//        printMap();
        System.out.println(sectionNum);
    }
    static int R,C;
    static int[][] Map;
    public static void input() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        Map = new int[R][C];
        for(int r=0; r<R; r++){
            st = new StringTokenizer(br.readLine());
            for(int c=0; c<C; c++){
                Map[r][c] = - Integer.parseInt(st.nextToken());
            }
        }
    }
    public static void printMap(){
        for(int r=0; r<R; r++){
            System.out.println();
            for(int c=0; c<C; c++){
                System.out.printf("%3d",Map[r][c]);
            }
        }
    }
    public static void setSectionNum(int r, int c, int num){
        Map[r][c] = num;
        visit((r>0 ? r-1 : R-1), c, num);
        visit((r<R-1 ? r+1 : 0), c, num);
        visit(r, (c>0 ? c-1 : C-1), num);
        visit(r, (c<C-1 ? c+1 : 0), num);
    }
    public static void visit(int r, int c, int num){
        if(Map[r][c]==0){
            setSectionNum(r,c,num);
        }
    }
}
