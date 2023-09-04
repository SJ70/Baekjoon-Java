import java.io.*;

public class _14470 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int currentTemp = Integer.parseInt(br.readLine());
        int goalTemp = Integer.parseInt(br.readLine());
        int timePerHeatUpUntilZero = Integer.parseInt(br.readLine());
        int timeToMelt = Integer.parseInt(br.readLine());
        int timePerHeatUpOverZero = Integer.parseInt(br.readLine());

        int resultTimeToHeatUpUntilZero = currentTemp>0 ? 0 : -currentTemp * timePerHeatUpUntilZero;
        int resultTimeToMeltTime = currentTemp>0 ? 0 : timeToMelt;
        int resultTimeToHeatUpOverZeroTime = (goalTemp - (Math.max(currentTemp, 0))) * timePerHeatUpOverZero;

        System.out.println(resultTimeToHeatUpUntilZero + resultTimeToMeltTime + resultTimeToHeatUpOverZeroTime);
    }
}
