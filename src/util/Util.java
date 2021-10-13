package util;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Util {
    public static String input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("입력 : ");
        String inputStr = br.readLine();
        return inputStr;
    }

    public static void loop(){

    }
}
