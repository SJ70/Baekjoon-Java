import java.io.*;

public class _1076 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        sb.append(getValue(br.readLine()));
        sb.append(getValue(br.readLine()));
        sb.append("0".repeat(getValue(br.readLine())));
        System.out.println(Long.parseLong(sb.toString()));
    }
    public static int getValue(String str){
        switch(str){
            case "black" : return 0;
            case "brown" : return 1;
            case "red" : return 2;
            case "orange" : return 3;
            case "yellow" : return 4;
            case "green" : return 5;
            case "blue" : return 6;
            case "violet" : return 7;
            case "grey" : return 8;
            case "white" : return 9;
            default: return -1;
        }
    }
}
