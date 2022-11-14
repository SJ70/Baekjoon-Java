import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class _2342 {
    static final int _00 = 0;
    static final int _01 = 1;
    static final int _02 = 2;
    static final int _03 = 3;
    static final int _04 = 4;
    static final int _12 = 5;
    static final int _13 = 6;
    static final int _14 = 7;
    static final int _23 = 8;
    static final int _24 = 9;
    static final int _34 = 10;
    static StringTokenizer order;
    static int[][] Arr = new int[100001][11];
    static Queue<Integer> Q = new ArrayDeque<>();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        order = new StringTokenizer(br.readLine());

        int nextNum;
        int index=0;
        Q.add(_00);
        Arr[0][_00] = 0;

        while( (nextNum = Integer.parseInt(order.nextToken())) > 0 ){
            int loop = Q.size();
            for(int i=0; i<loop; i++){
                DP(index, Q.poll(), nextNum);
            }
            index++;
        }

//        printArr(index);
        System.out.println(getMinResult(index));
    }
    public static void DP(int index, int from, int to){
        int currentValue = Arr[index][from];
        switch(from){
            case _00 :
                if     (to==1) setValue(index,_01,currentValue+2);
                else if(to==2) setValue(index,_02,currentValue+2);
                else if(to==3) setValue(index,_03,currentValue+2);
                else if(to==4) setValue(index,_04,currentValue+2);
                break;
            case _01 :
                if     (to==1) setValue(index,_01,currentValue+1);
                else if(to==2){
                    setValue(index,_02,currentValue+3);
                    setValue(index,_12,currentValue+2);
                }
                else if(to==3){
                    setValue(index,_03,currentValue+4);
                    setValue(index,_13,currentValue+2);
                }
                else if(to==4){
                    setValue(index,_04,currentValue+3);
                    setValue(index,_14,currentValue+2);
                }
                break;
            case _02 :
                if     (to==1){
                    setValue(index,_01,currentValue+3);
                    setValue(index,_12,currentValue+2);
                }
                else if(to==2) setValue(index,_02,currentValue+1);
                else if(to==3){
                    setValue(index,_03,currentValue+3);
                    setValue(index,_23,currentValue+2);
                }
                else if(to==4){
                    setValue(index,_04,currentValue+4);
                    setValue(index,_24,currentValue+2);
                }
                break;
            case _03 :
                if     (to==1){
                    setValue(index,_01,currentValue+4);
                    setValue(index,_13,currentValue+2);
                }
                else if(to==2){
                    setValue(index,_02,currentValue+3);
                    setValue(index,_23,currentValue+2);
                }
                else if(to==3) setValue(index,_03,currentValue+1);
                else if(to==4){
                    setValue(index,_04,currentValue+3);
                    setValue(index,_34,currentValue+2);
                }
                break;
            case _04 :
                if     (to==1){
                    setValue(index,_01,currentValue+3);
                    setValue(index,_14,currentValue+2);
                }
                else if(to==2){
                    setValue(index,_02,currentValue+4);
                    setValue(index,_24,currentValue+2);
                }
                else if(to==3){
                    setValue(index,_03,currentValue+3);
                    setValue(index,_34,currentValue+2);
                }
                else if(to==4) setValue(index,_04,currentValue+1);
                break;
            case _12 :
                if     (to==1) setValue(index,_12,currentValue+1);
                else if(to==2) setValue(index,_12,currentValue+1);
                else if(to==3){
                    setValue(index,_13,currentValue+3);
                    setValue(index,_23,currentValue+4);
                }
                else if(to==4){
                    setValue(index,_14,currentValue+4);
                    setValue(index,_24,currentValue+3);
                }
                break;
            case _13 :
                if     (to==1) setValue(index,_13,currentValue+1);
                else if(to==2){
                    setValue(index,_12,currentValue+3);
                    setValue(index,_23,currentValue+3);
                }
                else if(to==3) setValue(index,_13,currentValue+1);
                else if(to==4){
                    setValue(index,_14,currentValue+3);
                    setValue(index,_34,currentValue+3);
                }
                break;
            case _14 :
                if     (to==1) setValue(index,_14,currentValue+1);
                else if(to==2){
                    setValue(index,_12,currentValue+4);
                    setValue(index,_24,currentValue+3);
                }
                else if(to==3){
                    setValue(index,_13,currentValue+3);
                    setValue(index,_34,currentValue+4);
                }
                else if(to==4) setValue(index,_14,currentValue+1);
                break;
            case _23 :
                if     (to==1){
                    setValue(index,_12,currentValue+4);
                    setValue(index,_13,currentValue+3);
                }
                else if(to==2) setValue(index,_23,currentValue+1);
                else if(to==3) setValue(index,_23,currentValue+1);
                else if(to==4){
                setValue(index,_24,currentValue+3);
                setValue(index,_34,currentValue+4);
            }
                break;
            case _24 :
                if     (to==1){
                    setValue(index,_12,currentValue+3);
                    setValue(index,_14,currentValue+3);
                }
                else if(to==2) setValue(index,_24,currentValue+1);
                else if(to==3){
                    setValue(index,_23,currentValue+3);
                    setValue(index,_34,currentValue+3);
                }
                else if(to==4) setValue(index,_24,currentValue+1);
                break;
            case _34 :
                if     (to==1){
                    setValue(index,_13,currentValue+3);
                    setValue(index,_14,currentValue+4);
                }
                else if(to==2){
                    setValue(index,_23,currentValue+4);
                    setValue(index,_24,currentValue+3);
                }
                else if(to==3) setValue(index,_34,currentValue+1);
                else if(to==4) setValue(index,_34,currentValue+1);
                break;
        }
    }
    public static void setValue(int index, int to, int value){
        if(Arr[index+1][to]==0 || Arr[index+1][to]>value){
            Arr[index+1][to] = value;
            Q.add(to);
        }
    }
    public static void printArr(int index){
        System.out.println("   00   01   02   03   04   12   13   14   23   24   34\n");
        for(int i=0; i<=index; i++){
            for(int j=0; j<11; j++){
                System.out.printf("%5d",Arr[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }
    public static int getMinResult(int index){
        if(index==0) return 0;
        int result = 999999;
        for(int i=0; i<11; i++){
            if(Arr[index][i]==0) continue;
            result = Math.min(Arr[index][i], result);
        }
        return result;
    }
}
