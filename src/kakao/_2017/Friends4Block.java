package kakao._2017;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Friends4Block {

    public Friends4Block() {
        while(true) {
            try {
                Map<String, Object> map = input();
                if(map.get("m").toString().equals("0") || map.get("n").toString().equals("0")) {
                    break;
                }

                int m = Integer.parseInt(map.get("m").toString());
                int n = Integer.parseInt(map.get("n").toString());
                String board = (String) map.get("board");
                String[] strArr = board.split(",");
                List<StringBuilder> boardList = new ArrayList<>();
                for(int i=0; i<n; i++) {
                    boardList.add(new StringBuilder());
                }

                for(int i=m-1; i>=0; i--) {
                    String tempStr = strArr[i].replaceAll("[“|”|\"| ]", "");
                    for(int j=0; j<n; j++) {
                        boardList.get(j).append(tempStr.charAt(j));
                    }
                }

                int result = calculate(boardList, m, n);
                System.out.println(result);
            } catch(IOException e) {
                e.printStackTrace();
            }
        }
    }

    public Map input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("m : ");
        String m = br.readLine();
        System.out.print("n : ");
        String n = br.readLine();
        System.out.print("board : ");
        String board = br.readLine();

        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("m", m);
        resultMap.put("n", n);
        resultMap.put("board", board);
        return resultMap;
    }

    public int calculate(List<StringBuilder> boardList, int m, int n) {
        int flag = 1;
        Set<String> target = new HashSet<>();
        for(int i=0; i<m-1&&flag!=0; i++) {
            flag = 0;
            for(int j=0; j<n; j++) {
                if(j == n-1) {
                    if(boardList.get(j).charAt(i) != '#') {
                        flag = flag != 2 ? flag+1 : 2;
                    }
                } else {
                    if(boardList.get(j).charAt(i) != '#') {
                        if(boardList.get(j).charAt(i) == boardList.get(j+1).charAt(i)
                                && boardList.get(j).charAt(i) == boardList.get(j).charAt(i+1)
                                && boardList.get(j).charAt(i) == boardList.get(j+1).charAt(i+1)) {
                            target.add(j+"/"+i);
                            target.add((j+1)+"/"+(i));
                            target.add((j)+"/"+(i+1));
                            target.add((j+1)+"/"+(i+1));
                        }
                        flag = flag != 2 ? flag+1 : 2;
                    } else {
                        flag = flag != 2 ? 0 : 2;
                    }
                }
            }
        }

        for(String str : target) {
            String[] tempArr = str.split("/");
            boardList.get(Integer.parseInt(tempArr[0])).setCharAt(Integer.parseInt(tempArr[1]), '0');
        }

        for(int i=0; i<boardList.size(); i++) {
            StringBuilder tempSb = new StringBuilder(boardList.get(i).toString().replaceAll("0", ""));
            while (tempSb.length() != m) {
                tempSb.append('#');
            }
            boardList.set(i,tempSb);
        }

        if(target.size() == 0) {
            return 0;
        } else {
            return target.size() + calculate(boardList, m, n);
        }
    }
}
