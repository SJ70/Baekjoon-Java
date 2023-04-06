import java.io.*;
import java.util.*;

public class _17292 {
    static PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
    static HashMap<Integer, String> hs = new HashMap<>();

    public static void main(String[] args) throws IOException{
        init();

        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty()){
            sb.append(hs.get(pq.poll())).append('\n');
        }
        System.out.print(sb);
    }

    static void init() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] word = br.readLine().split(",");

        for(int i=0; i<word.length-1; i++){
            for(int j=i+1; j<word.length; j++){
                String str = word[i]+word[j];
                int value = toValue(word[i], word[j]);
                pq.add(value);
                hs.put(value,str);
            }
        }
    }
    static int toValue(String str1, String str2){
        String[] str = new String[]{str1, str2};
        Arrays.sort(str, new Comparator<String>() {
            public int compare(String str1, String str2) {
                if(str1.charAt(0)!=str2.charAt(0)){
                    return str2.charAt(0) - str1.charAt(0);
                }
                return str1.charAt(1)=='b' ? -1 : 1;
            }
        });
//        System.out.println(str[0]+","+str[1]);

        int value = 0;
        // 연속/동일/그외
        if(isContinuous(str)) value += 2000000;
        else if(isSameNum(str)) value += 1000000;

        if(isSameColor(str)) value += 100000;

        value += getNumValue(str[0].charAt(0)) * 1000;
        value += getNumValue(str[1].charAt(0)) * 10;

        if(isBigNumBlack(str)) value++;

//        System.out.println(str[0]+str[1]+":"+value);
        return value;
    }
    static boolean isContinuous(String[] str){
        int n1 = str[0].charAt(0);
        int n2 = str[1].charAt(0);
        return (n1=='a' && n2=='9') || (n1=='f' && n2=='1') || (n1 - n2 == 1);
    }
    static boolean isSameNum(String[] str){
        return str[0].charAt(0) == str[1].charAt(0);
    }
    static boolean isSameColor(String[] str){
        return str[0].charAt(1) == str[1].charAt(1);
    }
    static int getNumValue(char c){
        if(c>='a') return c-'a'+10;
        return c-'0';
    }
    static boolean isBigNumBlack(String[] str){
        return str[0].charAt(1)=='b';
    }
}
