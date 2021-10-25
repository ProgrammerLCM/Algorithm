package kakao._2017;

import java.util.*;

public class ThanksgivingDayTraffic {

    public ThanksgivingDayTraffic() {
        List<List<String>> inputList = new ArrayList<>();
        inputList.add(Arrays.asList("2016-09-15 01:00:04.001 2.0s", "2016-09-15 01:00:07.000 2s"));
        inputList.add(Arrays.asList("2016-09-15 01:00:04.002 2.0s", "2016-09-15 01:00:07.000 2s"));
        inputList.add(Arrays.asList("2016-09-15 20:59:57.421 0.351s", "2016-09-15 20:59:58.233 1.181s", "2016-09-15 20:59:58.299 0.8s", "2016-09-15 20:59:58.688 1.041s", "2016-09-15 20:59:59.591 1.412s", "2016-09-15 21:00:00.464 1.466s", "2016-09-15 21:00:00.741 1.581s", "2016-09-15 21:00:00.748 2.31s", "2016-09-15 21:00:00.966 0.381s", "2016-09-15 21:00:02.066 2.62s"));

        for(List list : inputList) {
            System.out.println(solution(list));
        }
    }

    public int solution(List<String> strList) {
        List<List<Integer>> manufactureList = manufactureData(strList);
        int topTraffic = 0;
        for(List<Integer> list : manufactureList) {
            topTraffic = Math.max(topTraffic,Math.max(getTraffic(manufactureList, list.get(2), list.get(1)), getTraffic(manufactureList, list.get(1), list.get(3))));
        }
        return topTraffic;
    }

    public List<List<Integer>> manufactureData(List<String> strList) {
        List<List<Integer>> result = new ArrayList<>();
        int baseInt = 0;
        int resultInt = 0;
        for(String str : strList) {
            String[] dateArr = str.split(" ");
            List<Integer> tempList = new ArrayList<>();
            String[] timeArr = dateArr[1].split(":");
            baseInt = Integer.parseInt(timeArr[0])*60*60*1000 + Integer.parseInt(timeArr[1])*60*1000 + Math.round(Float.parseFloat(timeArr[2])*1000);

            // 시작시간
            resultInt = baseInt - Math.round(Float.parseFloat(dateArr[2].substring(0, dateArr[2].length()-1))*1000) + 1;
            tempList.add(resultInt);

            // 종료시간
            tempList.add(baseInt);

            // 종료시간 - 0.999초
            resultInt = baseInt - 999 <= 0 ? 0 : baseInt - 999;
            tempList.add(resultInt);

            // 종료시간 + 0.999초
            resultInt = baseInt + 999 >= 86400000 ? 86400000 : baseInt + 999;
            tempList.add(resultInt);
            result.add(tempList);
        }

        Collections.reverse(result);
        return result;
    }

    public int getTraffic(List<List<Integer>> manufactureList, int startTime, int endTime) {
        int count = 0;
        for(List<Integer> list : manufactureList) {
            if(list.get(1) < startTime) {
                break;
            }
            if(list.get(0) <= endTime) {
                count++;
            }
        }
        return count;
    }
}
