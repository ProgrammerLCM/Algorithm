package kakao._2017;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SecretMap {

    public SecretMap() {
        while(true) {
            try {
                Map<String, Object> map = input();
                if(map.get("n").toString().equals("0")) {
                    break;
                }
                System.out.println(calculate(map));
            } catch(IOException e) {
                e.printStackTrace();
            }
        }
    }

    public Map input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("n : ");
        String n = br.readLine();
        System.out.print("arr1 : ");
        String[] arr1 = br.readLine().split(",");
        System.out.print("arr2 : ");
        String[] arr2 = br.readLine().split(",");

        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("n", n);
        resultMap.put("arr1", arr1);
        resultMap.put("arr2", arr2);
        return resultMap;
    }

    public List<String> calculate(Map map) {
        String[] arr1 = (String[]) map.get("arr1");
        String[] arr2 = (String[]) map.get("arr2");
        List<String> result = new ArrayList<>();
        for(int i=0; i<arr1.length; i++) {
            String binaryStr = Integer.toBinaryString(Integer.parseInt(arr1[i])|Integer.parseInt(arr2[i]));
            binaryStr = binaryStr.replace("1", "#");
            binaryStr = binaryStr.replace("0", " ");
            while(binaryStr.length() < Integer.parseInt(map.get("n").toString())) {
                binaryStr = " " + binaryStr;
            }
            result.add("\""+binaryStr+"\"");
        }
        return result;
    }
}
