package com.flora.test.hw;

import java.util.HashMap;
import java.util.Scanner;

/**
 * @Author qinxiang
 * @Date 2023/6/18-下午5:59
 * 1--1， abc--2, def--3, ghi--4, jkl--5, mno--6, pqrs--7, tuv--8 wxyz--9, 0--0，
 */
public class ConvertPassword {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            String s = scanner.nextLine();
            char[] chars = s.toCharArray();
            for (int i = 0; i < s.length(); i ++){
                if(chars[i]>='0'&&chars[i]<10){
                    continue;
                }
                if(chars[i]>='a'&& chars[i]<='c'){
                    chars[i] = '2';
                    continue;
                }
                if(chars[i]>='d'&& chars[i]<='f'){
                    chars[i] = '3';
                    continue;
                }
                if(chars[i]>='g'&& chars[i]<='i'){
                    chars[i] = '4';
                    continue;
                }
                if(chars[i]>='j'&& chars[i]<='l'){
                    chars[i] = '5';
                    continue;
                }
                if(chars[i]>='m'&& chars[i]<='o'){
                    chars[i] = '6';
                    continue;
                }
                if(chars[i]>='p'&& chars[i]<='s'){
                    chars[i] = '7';
                    continue;
                }
                if(chars[i]>='t'&& chars[i]<='v'){
                    chars[i] = '8';
                    continue;
                }
                if(chars[i]>='w'&& chars[i]<='z'){
                    chars[i] = '9';
                    continue;
                }
                if(chars[i]>='a'&& chars[i]<='c'){
                    chars[i] = '2';
                    continue;
                }
                if(chars[i]>='A'&& chars[i]<='Y'){
                    chars[i] = (char) (chars[i]+33);
                    continue;
                }
                if(chars[i]=='Z'){
                    chars[i] = 'a';
                    continue;
                }
            }
            for (char a:chars){
                System.out.print(a);
            }
        }
    }
}
