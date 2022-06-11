import java.io.*;
import java.util.*;

public class _7490 {
    static Scanner sc = new Scanner(System.in);
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int N;
    static char[] Parity;

    public static void main(String[] args) throws IOException {
        int T = sc.nextInt();
        for(int i=0; i<T; i++){
            N = sc.nextInt();
            Parity = new char[N-1];
            MakeZero(0);
            bw.write('\n');
        }
        bw.flush();
        bw.close();
    }
    public static void MakeZero(int index) throws IOException{
        if(index==N-1){
//            bw.write('1');
//            for(int i=2; i<=N; i++)
//                bw.write(Parity[i-2]+String.valueOf(i));
//            bw.write(" = "+(Calc()));
//            bw.write('\n');
            if(Calc()==0){
                bw.write('1');
                for(int i=2; i<=N; i++)
                    bw.write(Parity[i-2]+String.valueOf(i));
                bw.write('\n');
            }
        }
        else{
            Parity[index]=' ';
            MakeZero(index+1);
            Parity[index]='+';
            MakeZero(index+1);
            Parity[index]='-';
            MakeZero(index+1);
        }
    }
    public static int Calc(){
        Stack<Integer> S = new Stack<>();
        // 거꾸로 계산
        int result = 0;
        int tmp = 1; // 첫 숫자
        for(int i=2; i<=N; i++){
            char C = Parity[i-2];
            if(C==' '){
                tmp = tmp*10 + i;
            }
            else{
                if(S.empty()) result += tmp;
                else result += tmp * S.pop();
                tmp = i;
                S.add( (C=='+')? 1:-1 );
            }
        }
        // 스택에 부호가 하나 남은 상태 (없다면 전부 다 공백인 값)
        if(S.empty()) result += tmp;
        else result += tmp * S.pop();

        return result;
    }
}
