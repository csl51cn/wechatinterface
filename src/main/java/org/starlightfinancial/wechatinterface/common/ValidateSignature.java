package org.starlightfinancial.wechatinterface.common;

import org.apache.commons.codec.digest.DigestUtils;

import java.util.Arrays;

/**
 * Created by sili.chen on 2017/6/7.
 */
public class ValidateSignature {
    private String signature;
    private String timestamp;
    private String nonce;
    private String token;

    /**
     * 前面验证构造
     *
     * @param signature
     * @param timestamp
     * @param nonce
     * @param token
     */
    public ValidateSignature(String signature, String timestamp, String nonce, String token) {
        this.signature = signature;
        this.timestamp = timestamp;
        this.nonce = nonce;
        this.token = token;
    }

    /**
     * 验证
     *
     * @return true 验证通过，false 验证失败
     */
    public boolean check() {
        String sha1 = encode();
        return sha1.equals(this.signature);
    }

    /**
     * 得到加密后的数据
     *
     * @return
     */
    private String encode() {
        String[] sa = {this.token, this.timestamp, this.nonce};
        Arrays.sort(sa);
        String sortStr = sa[0] + sa[1] + sa[2];
        return DigestUtils.sha1Hex(sortStr);
    }
}
