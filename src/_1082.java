import java.io.*;
import java.util.*;

public class _1082 {

    private static int n, money;
    private static int[] pricePerNumber;
    private static int[] maxNumber;

    private static class AnswerIsZero extends Exception{}

    public static void main(String[] args) throws IOException {
        input();
        try{
            makeMaxLengthNumber();
            switchNumberBigger();
            printMaxNumber();
        }
        catch(Exception AnswerIsZero){
            System.out.println(0);
        }
    }

    private static void input() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        pricePerNumber = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            pricePerNumber[i] = Integer.parseInt(st.nextToken());
        }

        money = Integer.parseInt(br.readLine());
    }

    private static void makeMaxLengthNumber() throws AnswerIsZero{

        if(n == 1){
            throw new AnswerIsZero();
        }

        int cheapestNumberExcludeZero = getCheapestNumberExcludeZero();
        int cheapestNumberExcludeZeroPrice = pricePerNumber[cheapestNumberExcludeZero];
        int cheapestNumberIncludeZero = getCheapestNumberIncludeZero(cheapestNumberExcludeZero);
        int cheapestNumberIncludeZeroPrice = pricePerNumber[cheapestNumberIncludeZero];

        if(money < cheapestNumberExcludeZeroPrice){
            throw new AnswerIsZero();
        }

        money -= cheapestNumberExcludeZeroPrice;
        int length = 1;

        length += money / cheapestNumberIncludeZeroPrice;
        money %= cheapestNumberIncludeZeroPrice;

        maxNumber = new int[length];
        Arrays.fill(maxNumber, cheapestNumberIncludeZero);
        maxNumber[0] = cheapestNumberExcludeZero;
    }

    // cheapest & biggest
    private static int getCheapestNumberExcludeZero(){
        int cheapestNumber = -1;
        int cheapestPrice = Integer.MAX_VALUE;
        for(int i=n-1; i>0; i--){
            if(pricePerNumber[i] < cheapestPrice){
                cheapestNumber = i;
                cheapestPrice = pricePerNumber[i];
            }
        }
        return cheapestNumber;
    }

    private static int getCheapestNumberIncludeZero(int cheapestNumberExcludeZero){
        return pricePerNumber[0] < pricePerNumber[cheapestNumberExcludeZero] ? 0 : cheapestNumberExcludeZero;
    }

    private static void switchNumberBigger(){
        int length = maxNumber.length;
        for(int index=0; index<length; index++){
            int currentNumber = maxNumber[index];
            int currentNumberPrice = pricePerNumber[currentNumber];
            for(int biggerNumber=n-1; biggerNumber>currentNumber; biggerNumber--){
                int biggerNumberPrice = pricePerNumber[biggerNumber];
                int switchNumberPrice = biggerNumberPrice - currentNumberPrice;
                if(money >= switchNumberPrice){
                    maxNumber[index] = biggerNumber;
                    money -= switchNumberPrice;
                    break;
                }
            }
        }
    }

    private static void printMaxNumber(){
        StringBuilder sb = new StringBuilder();
        for(int num : maxNumber){
            sb.append(num);
        }
        System.out.println(sb);
    }

}
