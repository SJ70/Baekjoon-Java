import java.io.*;
import java.util.*;

public class _5430 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static Deque<Integer> Arr;
    static String Command;
    static boolean Reversed;
    static int size;
    static boolean Error;

    public static void Reset(){
        Arr = new ArrayDeque<>();
        Reversed = false;
        Error = false;
    }
    public static void Input() throws IOException {
        Command = br.readLine();
        size = Integer.parseInt(br.readLine());

        String input = br.readLine();
        input = input.substring(1,input.length()-1);
        StringTokenizer st = new StringTokenizer(input, ",");
        for(int i=0; i<size; i++){
            Arr.add(Integer.parseInt(st.nextToken()));
        }
    }
    public static void Calc(){
        for(int i=0; i<Command.length(); i++){
            if(Command.charAt(i)=='R'){
                Reversed = !Reversed;
            }
            else { // D
                if(Arr.size()==0){
                    Error = true;
                    break;
                }
                else{
                    size--;
                    if(!Reversed) Arr.pollFirst();
                    else Arr.pollLast(); //뒤집힌 경우 뒤에서부터 뺌
                }
            }
        }
    }
    public static void Output() throws IOException{
        if(Error){
            bw.write("error\n");
        }
        else {
            bw.write('[');
            for (int i=0; i<size; i++) {
                if(i!=0) bw.write(",");
                if (Reversed) bw.write(String.valueOf(Arr.pollLast()));
                else bw.write(String.valueOf(Arr.pollFirst()));
            }
            bw.write("]\n");
        }
    }

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for(int i=0; i<T; i++){
            Reset();
            Input();
            Calc();
            Output();
        }
        bw.flush();
    }
}
