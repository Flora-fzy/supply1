package com.jdt.sdkdemo1.supply.common;
import com.jdt.sdkdemo1.supply.util.RSAUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.NoSuchAlgorithmException;
import java.util.Map;

@Slf4j
public class RSAGenerator {

    private static String rasPath = "D://export/Data/shoppoint/.ras/";

    /**
     * 给appId生成公钥和私钥对
     * @param appId
     */
    public static Map<String,String> generateRSAKeyPair(String appId) throws NoSuchAlgorithmException, IOException {
        Map<String,String> keyMap = RSAUtil.genKeyPair();

        String privateFile = new StringBuffer(rasPath).append(appId).append("_privateKey.pem").toString();
        String publicFile = new StringBuffer(rasPath).append(appId).append("_publicKey.pem").toString();

        log.debug("生成私钥文件,appId={"+appId+"},file={"+privateFile+"}");
        log.debug("生成公钥文件,appId={"+appId+"},file={"+publicFile+"}");
        FileUtils.writeStringToFile(new File(privateFile),keyMap.get("privateKey"), StandardCharsets.UTF_8);
        FileUtils.writeStringToFile(new File(publicFile),keyMap.get("publicKey"), StandardCharsets.UTF_8);
        return keyMap;
    }

    /**
     * 查询appId公钥
     * @param appId
     */
    public static String getPublicKey(String appId) throws IOException {
        String publicFile = new StringBuffer(rasPath).append(appId).append("_publicKey.pem").toString();
        String publicKey = FileUtils.readFileToString(new File(publicFile),StandardCharsets.UTF_8);
        log.debug("查询公钥,appId={"+appId+"},publicKey={"+publicKey+"}");
        return publicKey;
    }

    /**
     * 查询appId私钥
     * @param appId
     */
    public static String getPrivateKey(String appId) throws IOException {
        String privateFile = new StringBuffer(rasPath).append(appId).append("_privateKey.pem").toString();
        String privateKey = FileUtils.readFileToString(new File(privateFile),StandardCharsets.UTF_8);
        log.debug("查询私钥,appId={"+appId+"},privateKey={"+privateKey+"}");
        return privateKey;
    }


    public static void  main(String args[]) throws IOException, NoSuchAlgorithmException {
        String appId = "xcapp10005";

        //(1)生成rsa文件
        generateRSAKeyPair(appId);

        //(2)获取公钥
        getPublicKey(appId);

        //(3)获取私钥
        getPrivateKey(appId);
    }
}
