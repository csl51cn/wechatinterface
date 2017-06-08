package org.starlightfinancial.wechatinterface.util;

import com.alibaba.fastjson.JSONObject;
import org.starlightfinancial.wechatinterface.exception.WeChatException;
import org.starlightfinancial.wechatinterface.exception.WeChatReturnCode;

/**
 * Created by sili.chen on 2017/6/8.
 */
public class WeChatUtil {
    /**
     * 判断是否请求成功
     *
     * @param resultStr
     * @throws WeChatException
     */
    public static void isSuccess(String resultStr) throws WeChatException {
        JSONObject jsonObject = JSONObject.parseObject(resultStr);
        Integer errCode = jsonObject.getIntValue("errcode");
        if (errCode != null && errCode != 0) {
            String errMsg = WeChatReturnCode.getMsg(errCode);
            if (errMsg.equals("")) {
                errMsg = jsonObject.getString("errmsg");
            }
            throw new WeChatException("异常码:" + errCode + ";异常说明:" + errMsg);
        }
    }
}
