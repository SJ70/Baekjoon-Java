import java.io.*;
import java.util.*;

public class _2638 {
    static int Time = 0;
    public static void main(String[] args) throws IOException {
        Input();
        OutsideAir();
        //Print();
        QueueAdd();
        while(!QCr.isEmpty()){
            CheckMelt();
            ApplyMelt();
            CheckInsideAir();
            //Print();
            Time++;
        }
        System.out.println(Time);
    }
    static int R,C;
    static int[][] Map;
    public static void Input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        Map = new int[R][C];
        for(int r=0; r<R; r++){
            st = new StringTokenizer(br.readLine());
            for(int c=0; c<C; c++){
                Map[r][c] = Integer.parseInt(st.nextToken());
            }
        }
    }
    public static void OutsideAir(){
        Queue<Integer> QOAr = new ArrayDeque<>();
        Queue<Integer> QOAc = new ArrayDeque<>();
        for(int r=0; r<R; r++){
            QOAr.add(r);
            QOAc.add(0);
            QOAr.add(r);
            QOAc.add(C-1);
        }
        for(int c=0; c<C; c++){
            QOAr.add(1);
            QOAc.add(c);
            QOAr.add(R-2);
            QOAc.add(c);
        }
        while(!QOAr.isEmpty()){
            setOutsideAir(QOAr.poll(),QOAc.poll());
        }
    }
    public static void setOutsideAir(int r, int c){
        if( r>=0 && r<R && c>=0 && c<C && Map[r][c]==0 ){
            Map[r][c]=2;
            setOutsideAir(r+1,c);
            setOutsideAir(r-1,c);
            setOutsideAir(r,c+1);
            setOutsideAir(r,c-1);
        }
    }
    static Queue<Integer> QCr = new ArrayDeque<>(); //cheese
    static Queue<Integer> QCc = new ArrayDeque<>();
    static Queue<Integer> QIAr = new ArrayDeque<>();    //insideAir
    static Queue<Integer> QIAc = new ArrayDeque<>();
    public static void QueueAdd(){
        for(int r=0; r<R; r++){
            for(int c=0; c<C; c++){
                switch(Map[r][c]){
                    case 0: QIAr.add(r); QIAc.add(c); break;
                    case 1: QCr.add(r); QCc.add(c); break;
                    default: break;
                }
            }
        }
    }
    static Queue<Integer> QMr = new ArrayDeque<>(); //melt
    static Queue<Integer> QMc = new ArrayDeque<>(); //melt
    public static void CheckMelt(){
        int size = QCr.size();
        for(int i=0; i<size; i++){
            int r = QCr.poll();
            int c = QCc.poll();
            if(CntOutsideAir(r,c)>=2){
                QMr.add(r);
                QMc.add(c);
            }
            else {
                QCr.add(r);
                QCc.add(c);
            }
        }
    }
    public static void ApplyMelt(){
        while(!QMr.isEmpty()){
            Map[QMr.poll()][QMc.poll()]=2;
        }
    }
    public static void CheckInsideAir(){
        int size = QIAr.size();
        for(int i=0; i<size; i++){
            int r = QIAr.poll();
            int c = QIAc.poll();
            if(CntOutsideAir(r,c)>0){
                setOutsideAir(r,c);
            }
            else{
                QIAr.add(r);
                QIAc.add(c);
            }
        }
    }
    public static int CntOutsideAir(int r, int c){
        int result = 0;
        if(Map[r-1][c]==2) result++;
        if(Map[r+1][c]==2) result++;
        if(Map[r][c-1]==2) result++;
        if(Map[r][c+1]==2) result++;
        return result;
    }
    public static void Print(){
        System.out.println();
        for(int r=0; r<R; r++){
            System.out.println();
            for(int c=0; c<C; c++){
                if(Map[r][c]==2) System.out.print(" .");
                else if(Map[r][c]==0) System.out.print(" -");
                else System.out.print(" C");
            }
        }
    }
}
