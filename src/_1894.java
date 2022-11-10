import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class _1894 {
    public static class Pos{
        double r,c;
        public Pos(double r, double c){
            this.r = r;
            this.c = c;
        }
        public boolean isSame(Pos p){
            return this.r==p.r && this.c==p.c;
        }
    }
    static ArrayList<Pos> pos;
    static Pos DuplicatedPos;
    public static void main(String[] args){
        while(sc.hasNext()){
            pos = new ArrayList<>();
            DuplicatedPos = null;
            input();
            printResult();
        }
    }
    static Scanner sc = new Scanner(System.in);
    public static void input(){
        StringTokenizer st = new StringTokenizer(sc.nextLine());
        for(int i=0; i<4; i++){
            Pos p = new Pos(Double.parseDouble(st.nextToken()),Double.parseDouble(st.nextToken()));
            int index = SamePosIndex(p);
            if(DuplicatedPos==null && index!=-1) {
                pos.remove(index);
                DuplicatedPos = p;
            }
            else{
                pos.add(p);
            }
        }
    }
    public static int SamePosIndex(Pos p){
        for(int i=0; i<pos.size(); i++){
            if(pos.get(i).isSame(p)) return i;
        }
        return -1;
    }
    public static void printResult(){
//        System.out.printf("%.3f %.3f \n %.3f %.3f \n %.3f %.3f \n\n",pos.get(0).r,pos.get(0).c,DuplicatedPos.r,DuplicatedPos.c,pos.get(1).r,pos.get(1).c);
        double R = pos.get(0).r + (pos.get(1).r - DuplicatedPos.r);
        double C = pos.get(0).c + (pos.get(1).c - DuplicatedPos.c);
        System.out.printf("%.3f %.3f\n",R,C);
    }
}
