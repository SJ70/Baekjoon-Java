import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class _16724 {
    public static void main(String[] args) throws IOException{
        init();
        divideSection();
        System.out.println(SectionIndex);
    }
    static int R,C;
    static char[][] Map;
    public static void init() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        Map = new char[R][C];
        for(int r=0; r<R; r++){
            String str = br.readLine();
            for(int c=0; c<C; c++){
                Map[r][c] = str.charAt(c);
            }
        }
    }
    static int[][] Section;
    static int SectionIndex;
    static Queue<Integer> currentSectionQ;  // 섹션을 통일해야 하는 경우를 위한 큐
    public static void divideSection(){
        Section = new int[R][C];
        SectionIndex = 0;
        currentSectionQ = new ArrayDeque<>();

        for(int r=0; r<R; r++){
            for(int c=0; c<C; c++){
                if(Section[r][c]==0){
                    SectionIndex++;
                    setSection(r,c);
                }
            }
        }
    }
    public static void setSection(int r, int c){
        if(Section[r][c]==SectionIndex){
            // 사이클이 돈 경우
            return;
        }
        else if(Section[r][c]!=0){
            // 다른 섹션에 도달한 경우 : 통일 필요
            equalizeSection(Section[r][c]);
            return;
        }
        Section[r][c] = SectionIndex;
        currentSectionQ.add(r);
        currentSectionQ.add(c);
        switch(Map[r][c]){
            case'U': setSection(r-1,c); break;
            case'D': setSection(r+1,c); break;
            case'L': setSection(r,c-1); break;
            case'R': setSection(r,c+1); break;
            default: break;
        }
    }
    public static void equalizeSection(int index){
        while(!currentSectionQ.isEmpty()){
            Section[currentSectionQ.poll()][currentSectionQ.poll()] = index;
        }
        SectionIndex--;
        // 현재 측정하던 섹션이 사라졌으므로 --;
    }
}
