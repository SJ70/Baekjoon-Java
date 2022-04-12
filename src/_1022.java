import java.io.*;
import java.util.*;
public class _1022 {
    public static boolean Lr(int x, int y){
        if(Math.abs(x)>=Math.abs(y)) return true;
        else return false;
    }
    public static int GetNum(int r, int c){
//        r=c인 대각선 (~0) : 4n^+1 (1~):(2n+1)^
//        ☒ 형태로 나누었을 때
//        상단(-n,-n~n) : 4r^+1-(c-r)
//        좌측(-n~n,-n) : 4c^+1-(r-c)
//        하단( n,-n~n) : (2r+1)^-(r-c)
//        우측(-n~n, n) : (2c+1)^+(c-r) -8(c)
        // 숫자가 같은 대각
        if(r==c){
            //return 0;
            if(r<=0) return 4*(int)Math.pow(r,2)+1;
            else return (int)Math.pow(2*c+1,2);
        }
        //상단
        else if( r<=0 && Lr(r,c) ){
            //return 11;
            return 4*(int)Math.pow(r,2)+1-(c-r);
        }
        //좌측
        else if( c<=0 && Lr(c,r) ){
            //return 222;
            return 4*(int)Math.pow(c,2)+1+(r-c);
        }
        //하단
        else if( r>0 && Lr(r,c) ){
            //return 3333;
            return (int)Math.pow(2*r+1,2)-(r-c);
        }
        //우측
        else if( c>0 && Lr(c,r) ){
            //return 44444;
            return (int)Math.pow(2*c+1,2)+(c-r)-8*c;
        }
        else return -1;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int r1 = Integer.parseInt(st.nextToken());
        int c1 = Integer.parseInt(st.nextToken());
        int r2 = Integer.parseInt(st.nextToken());
        int c2 = Integer.parseInt(st.nextToken());

        // 숫자 앞 공백 길이 계산을 위한 자릿수 확인
        int max_num = Math.max(Math.max(GetNum(r1,c1),GetNum(r2,c1)),Math.max(GetNum(r1,c2),GetNum(r2,c2)));
        int num_length = 0;
        int tmp = 1;
        while(true){
            num_length++;
            tmp*=10;
            if(max_num/tmp==0) break;
        }

        // 출력
        for(int r=r1; r<=r2; r++){
            for(int c=c1; c<=c2; c++){
                int tmp1 = GetNum(r,c);
                switch(num_length){
                    case 1 : System.out.printf("%1d",tmp1); break;
                    case 2 : System.out.printf("%2d",tmp1); break;
                    case 3 : System.out.printf("%3d",tmp1); break;
                    case 4 : System.out.printf("%4d",tmp1); break;
                    case 5 : System.out.printf("%5d",tmp1); break;
                    case 6 : System.out.printf("%6d",tmp1); break;
                    case 7 : System.out.printf("%7d",tmp1); break;
                    case 8 : System.out.printf("%8d",tmp1); break;
                    case 9 : System.out.printf("%9d",tmp1); break;
                }
                // 맨 앞과 맨 끝에는 공백이 들어가면 안 됨
                if(c<c2) System.out.printf(" ");
            }
            System.out.println();
        }
    }
}
