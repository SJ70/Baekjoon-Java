import java.io.*;

public class _12904 {
    static String From, To;
    public static void main(String[] args) throws IOException{
        input();
        System.out.println(canMake()?1:0);
    }
    public static void input() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        From = br.readLine();
        To = br.readLine();
    }
    public static boolean canMake(){
        int left = 0;
        int right = To.length()-1;
        boolean reversed = false;

        while(right-left+1 > From.length()){
            if(!reversed){
                if(To.charAt(right)=='B') reversed = true;
                right--;
            }
            else{
                if(To.charAt(left)=='B') reversed = false;
                left++;
            }
        }

        for(int i=0; i<From.length(); i++){
            int j = reversed ? right-i : left+i;
            if(From.charAt(i)!=To.charAt(j))
                return false;
        }
        return true;
    }
}
