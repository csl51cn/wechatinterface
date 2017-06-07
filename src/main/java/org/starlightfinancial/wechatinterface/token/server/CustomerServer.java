package org.starlightfinancial.wechatinterface.token.server;

import org.starlightfinancial.wechatinterface.token.Token;

/**
 * Created by sili.chen on 2017/6/5.
 */
public abstract class CustomerServer implements IServer {
    @Override
    public String token() {
        return null;
    }

    /**
     * 保存或者更新accesstoken到数据库
     * 由客户自己实现数据库插入或者更新操作
     *
     * @param token 得到的token或者ticket，需要保存
     * @return
     */
    public abstract boolean save(Token token);

    /**
     * 从数据库得到accessToken
     * 由客户自己实现数据库的查询操作
     *
     * @return
     */
    protected abstract String find();
}
