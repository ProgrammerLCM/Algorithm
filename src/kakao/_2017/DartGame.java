package kakao._2017;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DartGame {
    int option1 = 1, option2 = 1;

    String DELIMITER = "(?<=[#|*|S|D|T])";
    String[] strArr;

    public void init() {
        option1 = 1;
        option2 = 1;
    }

    public DartGame() {
        while(true) {
            try {
                String str = input();
                if(str.equals("z")) {
                    break;
                }
                init();
                strArr = str.split(DELIMITER);
                int result = calculate(strArr, strArr.length-1);
                System.out.println(result);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public String input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("입력 : ");
        String str = br.readLine();
        return str;
    }

    public int calculate(String[] strArr, int index) {
        if(index == -1) {
            return 0;
        }
        String str = strArr[index--];
        int len = str.length();
        if(str.equals("*")) {
            option1 = option1 * 2;
            option2 = 2;
            return calculate(strArr, index);
        } else if(str.equals("#")) {
            option1 = option1 * (-1);
            option2 = 1;
            return calculate(strArr, index);
        } else {
            int result = (int)(Math.pow(Integer.parseInt(str.substring(0,len-1)), (str.charAt(len-1) == 'S' ? 1 : str.charAt(len-1) == 'D' ? 2 : 3)) * option1);
            option1 = option2;
            option2 = 1;
            return result + calculate(strArr, index);
        }
    }
}
