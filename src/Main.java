import kakao._2017.*;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
//        DartGame dartGame = new DartGame();
//        SecretMap secretMap = new SecretMap();
//        Cache cache = new Cache();
//        ShuttleBus shuttleBus = new ShuttleBus();
//        NewsClustering newsClustering = new NewsClustering();

        Map<String, String> testMap = new HashMap<>();
        testMap.put("a", "1");
        testMap.put("b", "2");
        testMap.put("c", "3");
        testMap.put("d", "4");
        testMap.put("e", "5");
        testMap.containsKey("a");
        testMap.containsKey("f");
        for(String key : testMap.keySet()) {
            String testStr = testMap.get(key);
            System.out.println("key : " + key + " value : " + testStr);
        }


    }
}
