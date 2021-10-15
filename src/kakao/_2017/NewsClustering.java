package kakao._2017;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NewsClustering {

    public NewsClustering() {
        while(true) {
            try {
                Map<String, Object> map = input();
                if(map.get("str1").toString().length() == 0 || map.get("str2").toString().length() == 0) {
                    break;
                }
                int result = calculate(map);
                System.out.println(result);
            } catch(IOException e) {
                e.printStackTrace();
            }
        }
    }

    public Map input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("str1 : ");
        String str1 = br.readLine();
        System.out.print("str2 : ");
        String str2 = br.readLine();

        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("str1", str1);
        resultMap.put("str2", str2);
        return resultMap;
    }

    public int calculate(Map map) {
        char[] chars1 = map.get("str1").toString().toLowerCase().toCharArray();
        char[] chars2 = map.get("str2").toString().toLowerCase().toCharArray();

        List<String> multipleSets1 = new ArrayList<>();
        for(int i=0; i<chars1.length-1; i++) {
            if(Character.isLetter(chars1[i]) && Character.isLetter(chars1[i+1])) {
                multipleSets1.add(String.valueOf(chars1[i])+String.valueOf(chars1[i+1]));
            }
        }
        List<String> multipleSets2 = new ArrayList<>();
        for(int i=0; i<chars2.length-1; i++) {
            if(Character.isLetter(chars2[i]) && Character.isLetter(chars2[i+1])) {
                multipleSets2.add(String.valueOf(chars2[i])+String.valueOf(chars2[i+1]));
            }
        }

        if(multipleSets1.size() == 0 || multipleSets2.size() == 0) {
            return 1 * 65536;
        }

        // 교집합
        List<String> intersectionList = new ArrayList<>();
        intersectionList.addAll(multipleSets1);
        intersectionList.retainAll(multipleSets2);

        // 합집합
        List<String> unionList = new ArrayList<>();
        unionList.addAll(multipleSets1);
        unionList.addAll(multipleSets2);

        return intersectionList.size() * 65536 / (unionList.size() - intersectionList.size());
    }

}
