import java.io.*;

public class _28255 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        for(int i=0; i<N; i++){
            sb.append( isTriple(br.readLine()) ? 1 : 0 ).append('\n');
        }
        System.out.print(sb);
    }
    public static boolean isTriple(String str){
        String A,B,C;
        int length = (str.length()+2)/3;
//        System.out.println(length);
        switch(str.length()%3){
            // S + rev(S) + S
            case 0:{
                A = str.substring(0,length);
                B = str.substring(length,length*2);
                C = str.substring(length*2,length*3);
//                System.out.printf("%s %s %s \n\n",A,B,C);
                return isRev(A,B) && isSame(A,C);
            }
            // S + tail(rev(S)) + S
            // S + rev(S) + tail(rev(S))
            case 2:{
                A = str.substring(0,length);
                B = str.substring(length,length*2-1);
                C = str.substring(length*2-1,length*3-1);
//                System.out.printf("%s %s %s \n\n",A,B,C);
                if(isTailRev(A,B) && isSame(A,C)){
                    return true;
                }
                B = str.substring(length,length*2);
                C = str.substring(length*2,length*3-1);
//                System.out.printf("%s %s %s \n\n",A,B,C);
                return (isRev(A,B) && isTail(A,C));
            }
            // S + tail(rev(S)) + tail(S)
            case 1:{
                A = str.substring(0,length);
                B = str.substring(length,length*2-1);
                C = str.substring(length*2-1,length*3-2);
//                System.out.printf("%s %s %s \n\n",A,B,C);
                return isTailRev(A,B) && isTail(A,C);
            }
        }
        return false;
    }
    public static boolean isSame(String A, String B){
        return A.equals(B);
    }
    public static boolean isRev(String A, String B){
        int length = A.length();
        for(int i=0; i<length; i++){
            if( A.charAt(i) != B.charAt(length-1-i) ){
                return false;
            }
        }
        return true;
    }
    public static boolean isTail(String A, String B){
        int length = B.length();
        for(int i=0; i<length; i++){
            if( A.charAt(i+1) != B.charAt(i) ){
                return false;
            }
        }
        return true;
    }
    public static boolean isTailRev(String A, String B){
        int length = B.length();
        for(int i=0; i<length; i++){
            if( A.charAt(i) != B.charAt(length-1-i) ){
                return false;
            }
        }
        return true;
    }
}
