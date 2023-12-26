package org.example.encryption.security.code;

import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Base64;

/**
 * @author zhaoqw
 * @date 2023/10/19
 */
public class EncoderDecoderTest {
    public static void main(String[] args) {
        // URL编码
        String encoded = URLEncoder.encode("中文!", StandardCharsets.UTF_8);
        System.out.println("中文! URL编码: " + encoded);

        //URL编码的目的是把任意文本数据编码为%前缀表示的文本
        // 编码后的文本仅包含A~Z，a~z，0~9，-，_，.，*和%，便于浏览器和服务器处理
        String decode = URLDecoder.decode("%E4%B8%AD%E6%96%87%21", StandardCharsets.UTF_8);
        System.out.println("%E4%B8%AD%E6%96%87%21 URL解码: " + decode);


        // Base64编码
        // Base64编码是对二进制数据进行编码，表示成文本格式
        byte[] input = new byte[] { (byte) 0xe4, (byte) 0xb8, (byte) 0xad };
        String b64encoded = Base64.getEncoder().encodeToString(input);
        System.out.println(b64encoded);
        byte[] output = Base64.getDecoder().decode("5Lit");
        System.out.println(Arrays.toString(output)); // [-28, -72, -83]


        input = new byte[] { (byte) 0xe4, (byte) 0xb8, (byte) 0xad, 0x21 };
        b64encoded = Base64.getEncoder().encodeToString(input);
        String b64encoded2 = Base64.getEncoder().withoutPadding().encodeToString(input);
        System.out.println(b64encoded);
        System.out.println(b64encoded2);
        output = Base64.getDecoder().decode(b64encoded2);
        System.out.println(Arrays.toString(output));
    }
}
