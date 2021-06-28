package com.jdt.sdkdemo1.supply.common;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.UUID;

@Slf4j
public class DES3Generator {

    private static String rasPath = "D://export/Data/shoppoint/.des3/";

    /**
     * 给appId生成license
     * @param appId
     */
    public static String generateLicense(String appId) throws IOException {
        String license = UUID.randomUUID().toString();
        String licenseFile = new StringBuffer(rasPath).append(appId).append("_des3.license").toString();

        log.debug("生成license文件,appId={"+appId+"},file={"+licenseFile+"}");
        FileUtils.writeStringToFile(new File(licenseFile),license, StandardCharsets.UTF_8);
        return license;
    }

    /**
     * 查询appId的license
     * @param appId
     */
    public static String getLicense(String appId) throws IOException {
        String licenseFile = new StringBuffer(rasPath).append(appId).append("_des3.license").toString();
        String license = FileUtils.readFileToString(new File(licenseFile),StandardCharsets.UTF_8);
        log.debug("查询des3-license,appId={"+appId+"},license={"+license+"}");
        return license;
    }

    public static void  main(String args[]) throws IOException {
        String appId = "xcapp10005";

        //(1)生成des3-license文件
        generateLicense(appId);

        //(2)获取公钥
        getLicense(appId);

    }
}
