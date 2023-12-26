package org.example.encryption.security.hash;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * 哈希算法（Hash）又称摘要算法（Digest），它的作用是：对任意一组输入数据进行计算，得到一个固定长度的输出摘要。
 *  常见摘要算法 MD5， SHA1 SHA-256
 * @author zhaoqw
 * @date 2023/10/19
 */
public class HashDigestTest {
    public static void main(String[] args) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            // 反复调用update输入数据:
            md.update("Hello".getBytes("UTF-8"));
            md.update("World".getBytes("UTF-8"));
            byte[] result = md.digest(); // 16 bytes: 68e109f0f40ca72a15e05cc22786f8e6
            System.out.println(new BigInteger(1, result).toString(16));
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }
}
