package org.starlightfinancial.wechatinterface.token.server;

import org.starlightfinancial.wechatinterface.common.Config;

/**
 * Created by sili.chen on 2017/6/2.
 */
public class AccessTokenServer extends AbsServer implements TokenServer {
    /**
     *
     */
    public String token(){
        return super.token();
    }

    @Override
    protected String getCustomerServerClass() {
        return Config.instance().getAccessTokenServer();
    }

    @Override
    public IServer defaultServer() {
        return AccessTokenMemServer.instance();
    }
}
