package kakao._2017;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Cache {

    public Cache() {
        while(true) {
            try {
                Map<String, Object> map = input();
                if(map.get("cacheSize").toString().equals("31")) {
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
        System.out.print("cacheSize : ");
        String n = br.readLine();
        System.out.print("cities : ");
        String[] arr1 = br.readLine().split(",");

        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("cacheSize", n);
        resultMap.put("cities", arr1);
        return resultMap;
    }

    public int calculate(Map map) {
        int totalTime = 0;
        Queue<String> queue = new LinkedList<>();
        int cacheSize = Integer.parseInt(map.get("cacheSize").toString());
        String[] cities = (String[]) map.get("cities");
        for(String city : cities) {
            String tempCity = city.toLowerCase().replaceAll("[“|”|\"| ]", "");
            totalTime += (queue.contains(tempCity) ? 1 : 5);
            queue.offer(tempCity);
            if(queue.size() > cacheSize) {
                queue.remove();
            }
        }
        return totalTime;
    }
}