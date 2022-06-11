import java.io.*;

public class _7682 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static String str;
    public static void main(String[] args) throws IOException{
        while(true){
            str = br.readLine();
            if(str.equals("end")) break;
            else bw.write(Valid()+"\n");
        }
        bw.flush();
        bw.close();
    }
    public static String Valid(){
        if( !isFull() && !isBingo('O') && !isBingo('X') ) { // 꽉 차지도 않고 빙고 없이 끝난 경우
            return "invalid";
        }
        int O=0;
        int X=0;
        for(int i=0; i<9; i++){
            if(str.charAt(i) == 'O')O++;
            else if(str.charAt(i) == 'X') X++;
        }
        if(X==O){ // O가 놓은 차례
            if(isBingo('X')) return "invalid"; // X의 빙고가 존재해선 안 됨
            else return "valid";
        }
        else if(X==O+1){ // X가 놓은 차례
            if(isBingo('O')) return "invalid"; // O의 빙고가 존재해선 안 됨
            else return "valid";
        }
        else return "invalid"; // 불가능 (X<O)
    }
    public static boolean isFull(){
        for(int i=0; i<9; i++)
            if(str.charAt(i)=='.') return false;
        return true;
    }
    public static boolean isBingo(char C){
        if(str.charAt(4)==C){
            if(str.charAt(0)==C && str.charAt(8)==C) return true; // 대각 1
            if(str.charAt(2)==C && str.charAt(6)==C) return true; // 대각 2
            if(str.charAt(1)==C && str.charAt(7)==C) return true; // 가로 중
            if(str.charAt(3)==C && str.charAt(5)==C) return true; // 세로 중
        }
        if(str.charAt(0)==C){
            if(str.charAt(1)==C && str.charAt(2)==C) return true; // 가로 상
            if(str.charAt(3)==C && str.charAt(6)==C) return true; // 세로 좌
        }
        if(str.charAt(8)==C){
            if(str.charAt(2)==C && str.charAt(5)==C) return true; // 가로 상
            if(str.charAt(6)==C && str.charAt(7)==C) return true; // 세로 좌
        }
        return false;
    }
}
