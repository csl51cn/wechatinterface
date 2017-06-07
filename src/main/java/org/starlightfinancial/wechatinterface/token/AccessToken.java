package org.starlightfinancial.wechatinterface.token;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.starlightfinancial.wechatinterface.common.Config;

/**
 * Created by sili.chen on 2017/6/2.
 */
public class AccessToken extends Token {
    private static final Log logger = LogFactory.getLog(AccessToken.class);
    private static final String ACCESS_TOKEN_URL = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential";


    @Override
    protected String tokenName() {
        return "access_token";
    }

    @Override
    protected String expiresInName() {
        return "expires_in";
    }

    /**
     * 组织accesstoken的请求utl
     */
    @Override
    protected String accessTokenUrl() {
        String appid = Config.instance().getAppid();
        String appsecret = Config.instance().getAppSecret();
        String url = ACCESS_TOKEN_URL + "&appid=" + appid + "&secret=" + appsecret;
        logger.info("创建获取access_token url");
        return url;
    }
}
