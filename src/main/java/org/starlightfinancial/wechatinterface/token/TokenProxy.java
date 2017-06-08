package org.starlightfinancial.wechatinterface.token;

import org.starlightfinancial.wechatinterface.token.server.AccessTokenMemServer;

/**
 * AccessToken代理
 * 所有获取accessToken的地方都通过此代理获得
 * 获得方法String token = AccessTokenProxy.token()
 * Created by sili.chen on 2017/6/2.
 */
public class TokenProxy {
    /**
     * 通过代理得到accessToken的串
     */
    public static String accessToken() {
        AccessTokenMemServer accessTokenMemServer = AccessTokenMemServer.instance();
        return accessTokenMemServer.token();
    }
}
