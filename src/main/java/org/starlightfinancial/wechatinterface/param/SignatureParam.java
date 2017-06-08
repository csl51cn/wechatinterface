package org.starlightfinancial.wechatinterface.param;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by sili.chen on 2017/6/7.
 */
public class SignatureParam {
    private String signature;
    private String timestamp;
    private String nonce;
    private String echostr;

    public SignatureParam(HttpServletRequest request) {
        signature = request.getParameter(WechatParamName.SIGNATURE);
        timestamp = request.getParameter(WechatParamName.TIMESTAMP);
        nonce = request.getParameter(WechatParamName.NONCE);
        echostr = request.getParameter(WechatParamName.ECHOSTR);
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getNonce() {
        return nonce;
    }

    public void setNonce(String nonce) {
        this.nonce = nonce;
    }

    public String getEchostr() {
        return echostr;
    }

    public void setEchostr(String echostr) {
        this.echostr = echostr;
    }
}
