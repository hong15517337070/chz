package com.example.nihao.zawu;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.HashMap;

public class ShA1 {
    public static HashMap<String, String> sha1() {
        try {
            String timestamp = String.valueOf(System.currentTimeMillis() / 1000);
            String nonce = String.valueOf((int) ((Math.random() * 9 + 1) * 100000));
            String str="K;9)Bq|ScMF1h=Vp5uA-G87d(_fi[aP,.w^{vQ:WWWWW";

            //将“密钥”，“系统当前的Unix时间戳”，“随机数”放到数组中，然后对数组进⾏字符串排序，将排序结果重
            //新拼接成字符串，然后计算字符串的sha1散列值，这个值就是“signature”签名结果值
            String[] arr = new String[3];
            arr[0] = str;
            arr[1] = timestamp;
            arr[2] = nonce;
            Arrays.sort(arr);
            StringBuffer stringBuffer = new StringBuffer();
            for (String s : arr) {
                stringBuffer.append(s);
            }
            String string = stringBuffer.toString();

            MessageDigest md = MessageDigest.getInstance("SHA1");
            md.update(string.getBytes());
            StringBuffer buf = new StringBuffer();
            byte[] bits = md.digest();
            for(int i=0;i<bits.length;i++){
                int a = bits[i];
                if(a<0) a+=256;
                if(a<16) buf.append("0");
                buf.append(Integer.toHexString(a));
            }

//signature 是 签名结果串（参考签名机制）
//timestamp 是 系统当前的Unix时间戳
//nonce 是 随机数
//lang 是 语⾔信息，⽬前⽀持：zh（中⽂），en（英⽂），ar（阿拉伯⽂）
//from 是 来源信息，⽬前⽀持：android，
            HashMap<String, String> map = new HashMap<>();
            map.put("signature",buf.toString());
            map.put("timestamp",timestamp);
            map.put("nonce",nonce);
            map.put("lang","zh");
            map.put("from","android");
            return map;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }
}
