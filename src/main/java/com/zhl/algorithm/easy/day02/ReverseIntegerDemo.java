package com.zhl.algorithm.easy.day02;

import org.omg.PortableServer.POA;

/**
 * Created by zhl on 18/9/28 下午7:39.
 */
public class ReverseIntegerDemo {

    public static void main(String[] args) {
        int x = 102;
        // x /=10 => x/10
        System.out.println(x /= 10);

        System.out.println(reverse(123));
    }

    public static int reverse(int x) {
        int rev = 0;
        while (x != 0){
            int pop = x % 10;
            x /= 10;
            if(rev > Integer.MAX_VALUE / 10 ||
                    (rev == Integer.MAX_VALUE / 10 && pop > 7)) {
                return 0;
            }
            if(rev < Integer.MIN_VALUE / 10 ||
                    (rev == Integer.MIN_VALUE / 10 && pop < -8)) {
                return 0;
            }
            rev = rev * 10 + pop;

        }
        return rev;
    }
}
