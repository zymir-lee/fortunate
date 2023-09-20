package pers.zymir.fortunate.util;

import java.security.SecureRandom;

public class RandomUtil {

    public static int randomInt(int min, int max) {
        SecureRandom secureRandom = cn.hutool.core.util.RandomUtil.getSecureRandom();
        return secureRandom.nextInt(min - 1, max) + 1;
    }
}
