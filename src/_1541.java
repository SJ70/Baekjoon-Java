import java.util.Scanner;

public class _1541 {
    static Scanner sc = new Scanner(System.in);
    static boolean MinusAppeared = false;
    static String str;
    static int result = 0;
    static int currentNum = 0;
    public static void main(String[] args){
        str = sc.nextLine();
        for(int i=0; i<str.length(); i++){
            char tmp = str.charAt(i);
            switch(tmp){
                case'-': AddNum(); currentNum=0; MinusAppeared=true; break;
                case'+': AddNum(); currentNum=0; break;
                default: AppendNum(tmp-'0'); break;
            }
        }
        AddNum();
        System.out.print(result);
    }
    public static void AppendNum(int n){
        currentNum = currentNum*10 + n;
    }
    public static void AddNum(){
        if(MinusAppeared) result-=currentNum;
        else result+=currentNum;
    }
}
