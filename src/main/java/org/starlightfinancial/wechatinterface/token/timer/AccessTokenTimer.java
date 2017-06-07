package org.starlightfinancial.wechatinterface.token.timer;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.starlightfinancial.wechatinterface.token.server.AccessTokenMemServer;

import java.util.TimerTask;

/**
 * Created by sili.chen on 2017/6/5.
 */
public class AccessTokenTimer extends TimerTask {
    private static Log logger = LogFactory.getLog(AccessTokenTimer.class);

    //accessToken有效期7200秒,提前200秒请求新的token
    public static final long PERIOD = 7000 * 1000;
    public static final long DELAY = 0; //此任务的延迟时间为0，即立即执行

    @Override
    public void run() {
        logger.info("accessToken 定时任务启动，获取新的accessToken");
        AccessTokenMemServer accessTokenMemServer = AccessTokenMemServer.instance();

//        //得到新的access token
//        AccessToken accessToken = new AccessToken();
//        //获取成功之后持久化accessToken 如果要持久化，需要自己实现CustomerServer
//        if (accessToken.request()) {
//            AccessTokenServer accessTokenServer = new AccessTokenServer();
//            CustomerServer customerServer = (CustomerServer) accessTokenServer.customerServer();
//            customerServer.save(accessToken);
//        }
    }
}
