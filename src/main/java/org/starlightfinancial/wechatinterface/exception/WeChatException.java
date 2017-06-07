package org.starlightfinancial.wechatinterface.exception;

/**
 * Created by sili.chen on 2017/6/7.
 */
public class WeChatException extends Exception {
    private static final long serialVersionUID = 1L;

    public WeChatException(String msg) {
        super(msg);
    }
}
