package org.starlightfinancial.wechatinterface.common;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by sili.chen on 2017/6/5.
 */
public class Config {
    private static final Log logger = LogFactory.getLog(Config.class);

    private static final String configFile = "/wechat.properties";

    private String url;
    private String token;
    private String encodingAESKey;
    private String appid;
    private String appSecret;
    private String mchId;
    private String mchKey;
    private String accessTokenServer;
    private String jsApiTicketServer;
    private static Config config = new Config();

    private Config() {
        Properties p = new Properties();
        InputStream inStream = this.getClass().getResourceAsStream(configFile);
        if (inStream == null) {
            logger.error("根目录下找不到wechat.properties文件");
            return;
        }
        try {
            p.load(inStream);
            this.url = p.getProperty("wechat.url");
            if (StringUtils.isNotBlank(url)) this.url = this.url.trim();
            this.encodingAESKey = p.getProperty("wechat.encodingaeskey");
            if (StringUtils.isNotBlank(encodingAESKey)) this.encodingAESKey = this.encodingAESKey.trim();
            this.token = p.getProperty("wechat.token");
            if (StringUtils.isNotBlank(token)) this.token = this.token.trim();
            this.appid = p.getProperty("wechat.appid");
            if (StringUtils.isNotBlank(appid)) this.appid = this.appid.trim();
            this.appSecret = p.getProperty("wechat.appsecret");
            if (StringUtils.isNotBlank(appSecret)) this.appSecret = this.appSecret.trim();
            this.mchId = p.getProperty("wechat.mch.id");
            if (StringUtils.isNotBlank(mchId)) this.mchId = this.mchId.trim();
            this.mchKey = p.getProperty("wechat.mch.key");
            if (StringUtils.isNotBlank(mchKey)) this.mchKey = this.mchKey.trim();
            this.accessTokenServer = p.getProperty("wechat.accessToken.server.class");
            if (StringUtils.isNotBlank(accessTokenServer)) this.accessTokenServer = this.accessTokenServer.trim();
            this.jsApiTicketServer = p.getProperty("wechat.ticket.jsapi.server.class");
            if (StringUtils.isNotBlank(jsApiTicketServer)) this.jsApiTicketServer = this.jsApiTicketServer.trim();
            inStream.close();
        } catch (IOException e) {
            logger.error("load wechat.properties error,class根目录下找不到wechat.properties文件");
            e.printStackTrace();
        }
        logger.info("load wechat.properties success");
    }

    public static Config instance() {
        return config;
    }

    public String getToken() {
        return token;
    }

    public String getAppid() {
        return appid;
    }

    public String getAppSecret() {
        return appSecret;
    }

    public String getMchId() {
        return mchId;
    }

    public String getMchKey() {
        return mchKey;
    }

    public String getUrl() {
        return url;
    }

    public String getEncodingAESKey() {
        return encodingAESKey;
    }

    public String getAccessTokenServer() {
        return accessTokenServer;
    }

    public String getJsApiTicketServer() {
        return jsApiTicketServer;
    }
}
