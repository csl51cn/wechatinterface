package org.starlightfinancial.wechatinterface.token;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.starlightfinancial.wechatinterface.token.timer.AccessTokenTimer;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.util.Timer;

/**
 * Created by sili.chen on 2017/6/5.
 */
@WebListener
public class TokenListener implements ServletContextListener {
    private static final Log logger = LogFactory.getLog(TokenListener.class);

    private Timer timer = null;

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        logger.info("accessToken监听器启动..........");
        timer = new Timer(true);
        //注册定时任务
        registeAccessTokenTimer();
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        timer.cancel();
    }

    /**
     * 注册accessToken定时器
     */
    private void registeAccessTokenTimer() {
        AccessTokenTimer accessTokenTimer = new AccessTokenTimer();
        timer.schedule(accessTokenTimer, AccessTokenTimer.DELAY, AccessTokenTimer.PERIOD);
        logger.info("accessToken定时器注册成功，执行间隔为" + AccessTokenTimer.PERIOD);
    }
}
