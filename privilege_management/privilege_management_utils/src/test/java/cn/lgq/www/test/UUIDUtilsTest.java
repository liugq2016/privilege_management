package cn.lgq.www.test;

import cn.lgq.www.utils.UUIDUtils;
import org.junit.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class UUIDUtilsTest {
    @Test
    public void uuidTest(){
        String uuid = UUIDUtils.getUuid();
        System.out.println(uuid);
    }

    @Test
    public void enconemy(){
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String encode = bCryptPasswordEncoder.encode("123");
        int length = encode.toCharArray().length;
        System.out.println(encode);
        System.out.println(length);
    }
}
