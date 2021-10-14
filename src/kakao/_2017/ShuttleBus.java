package kakao._2017;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class ShuttleBus {

    public ShuttleBus() {
        while(true) {
            try {
                Map<String, Object> map = input();
                if(map.get("n").toString().equals("0") || map.get("t").toString().equals("0") || map.get("m").toString().equals("0")) {
                    break;
                }
                int result = calculate(map);
                System.out.println(String.format("%02d",result/60) + ":" + String.format("%02d",result%60));
            } catch(IOException e) {
                e.printStackTrace();
            }
        }
    }

    public Map input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("n : ");
        String n = br.readLine();
        System.out.print("t : ");
        String t = br.readLine();
        System.out.print("m : ");
        String m = br.readLine();
        System.out.print("timeTable : ");
        String timetable = br.readLine();

        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("n", n);
        resultMap.put("t", t);
        resultMap.put("m", m);
        resultMap.put("timeTable", timetable);
        return resultMap;
    }

    public int calculate(Map map) {
        int n = Integer.parseInt(map.get("n").toString());
        int t = Integer.parseInt(map.get("t").toString());
        int m = Integer.parseInt(map.get("m").toString());
        String timeTable = (String) map.get("timeTable");

        List<String> timetable = Arrays.asList(timeTable.split(","));
        List<Integer> manufactureList = timetable
                .stream()
                .map(one -> {
                    one = one.replaceAll("[“|”|\"| ]", "");
                    String[] tempArr = one.split(":");
                    return Integer.parseInt(tempArr[0])*60 + Integer.parseInt(tempArr[1]);
                }).collect(Collectors.toCollection(LinkedList::new));
        Collections.sort(manufactureList);
        Queue queue = (Queue)manufactureList;

        int startTime = 540;

        int passengerCount = 0;
        int passTime = 0;
        for (int i=0; i<n; i++) {
            passengerCount = 0;
            passTime = 0;
            while(queue.size() != 0) {
                if((int) queue.peek() <= startTime+(t*i) && passengerCount < m) {
                    passTime = (int) queue.poll();
                    passengerCount++;
                } else {
                    break;
                }
            }
        }
        if(passengerCount < m) {
            return startTime+(t*(n-1));
        } else {
            return passTime - 1;
        }
    }
}