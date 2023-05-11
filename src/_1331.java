import java.io.*;

public class _1331 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean[] visited = new boolean[36];

        int first = toInt(br.readLine());

        int current = first;
        visited[current] = true;

        for(int i=1; i<36; i++){
            int next = toInt(br.readLine());
            if(canGo(current,next) && !visited[next]){
                visited[next] = true;
                current = next;
            }
            else{
                System.out.println("Invalid");
                return;
            }
        }

        if(canGo(current, first)){
            System.out.println("Valid");
        }
        else{
            System.out.println("Invalid");
        }
    }
    public static int toInt(String str){
        int a = str.charAt(0)-'A';
        int b = str.charAt(1)-'1';
        return a*6 + b;
    }
    public static boolean canGo(int from, int to){
        int a = Math.abs(from/6 - to/6);
        int b = Math.abs(from%6 - to%6);
        return (a==2 && b==1) || (a==1 && b==2);
    }
}
