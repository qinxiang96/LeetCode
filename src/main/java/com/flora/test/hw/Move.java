package com.flora.test.hw;

import java.util.Scanner;

/**
 * @Author qinxiang
 * @Date 2023/6/18-下午5:10
 */
public class Move {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            String[] strs = scanner.nextLine().split(";");
            int x = 0;
            int y = 0;
            for (String s : strs){
                if (!s.matches("[ADWS][0-9]{1,2}")){
                    continue;
                }
                switch (s.substring(0,1)){
                    case "A": x -= Integer.parseInt(s.substring(1));break;
                    case "D": x += Integer.parseInt(s.substring(1));break;
                    case "W": y += Integer.parseInt(s.substring(1));break;
                    case "S": y -= Integer.parseInt(s.substring(1));break;

                }
            }
            System.out.println(x+","+y);
        }
    }
}
