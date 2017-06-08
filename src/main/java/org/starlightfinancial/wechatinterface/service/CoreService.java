package org.starlightfinancial.wechatinterface.service;

import org.starlightfinancial.wechatinterface.WechatSupport;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by sili.chen on 2017/6/8.
 */
public class CoreService extends WechatSupport {
    /**
     * 构建微信处理
     *
     * @param request 微信服务发过来的http请求
     */
    public CoreService(HttpServletRequest request) {
        super(request);
    }

    @Override
    protected void onText() {
        this.responseText("哈哈");
    }

    @Override
    protected void onImage() {

    }

    @Override
    protected void onVoice() {

    }

    @Override
    protected void onVideo() {

    }

    @Override
    protected void onShortVideo() {

    }

    @Override
    protected void onLocation() {

    }

    @Override
    protected void onLink() {

    }

    @Override
    protected void onUnknown() {

    }

    @Override
    protected void click() {

    }

    @Override
    protected void subscribe() {

    }

    @Override
    protected void unSubscribe() {

    }

    @Override
    protected void scan() {

    }

    @Override
    protected void location() {

    }

    @Override
    protected void view() {

    }

    @Override
    protected void templateMsgCallback() {

    }

    @Override
    protected void scanCodePush() {

    }

    @Override
    protected void scanCodeWaitMsg() {

    }

    @Override
    protected void picSysPhoto() {

    }

    @Override
    protected void picPhotoOrAlbum() {

    }

    @Override
    protected void picWeixin() {

    }

    @Override
    protected void locationSelect() {

    }

    @Override
    protected void kfCreateSession() {

    }

    @Override
    protected void kfCloseSession() {

    }

    @Override
    protected void kfSwitchSession() {

    }
}
