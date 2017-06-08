package org.starlightfinancial.wechatinterface.message;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.starlightfinancial.wechatinterface.constant.MsgType;
import org.starlightfinancial.wechatinterface.lang.HttpUtils;
import org.starlightfinancial.wechatinterface.response.ArticleResponse;
import org.starlightfinancial.wechatinterface.response.MusicResponse;
import org.starlightfinancial.wechatinterface.response.VideoResponse;
import org.starlightfinancial.wechatinterface.token.TokenProxy;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sili.chen on 2017/6/8.
 */
public class CustomerMsg {
    private static final Log logger = LogFactory.getLog(CustomerMsg.class);

    private static final String MSG_URL = "https://api.weixin.qq.com/cgi-bin/message/custom/send?access_token=";
    private String toUserOpenId;
    private String msgType;   //msgtype
    private String msgBody;   //发送的消息post数据

    /**
     * 需要主动去刷新access_token,不建议使用
     * 建议自己去获取access_token保存，并定时刷新。
     * 然后使用SendMsg(String toUserOpenId,String accessToken)来替代本方法
     *
     * @param toUserOpenId
     */
    public CustomerMsg(String toUserOpenId) {
        this.toUserOpenId = toUserOpenId;
    }

//
//	public String getMsgBody() {
//		return msgBody;
//	}

    /**
     * 发送客服消息
     */
    private void send() {
        String accessToken = TokenProxy.accessToken();
        if (StringUtils.isBlank(this.toUserOpenId))
            return;
        //token不存在则重新刷新token
        if (StringUtils.isBlank(accessToken)) {
            logger.error("发送失败，无法得到accessToken");
            return;
        }
        //需要判断一下，防止上面刷新token失败
        if (StringUtils.isNotBlank(accessToken)) {
            String url = MSG_URL + accessToken;
            HttpUtils.post(url, msgBody);
        }
    }

    /**
     * {
     * "touser":"OPENID",
     * "msgtype":"text",
     * "text":
     * {
     * "content":"Hello World"
     * }
     * }
     *
     * @param content
     */
    public void sendText(String content) {
        this.msgType = MsgType.text.name();

        JSONObject jsonMsg = new JSONObject();
        jsonMsg.put("content", content);

        JSONObject json = new JSONObject();
        json.put("touser", this.toUserOpenId);
        json.put("msgtype", this.msgType);
        json.put("text", jsonMsg);

        this.msgBody = json.toJSONString();
        send();
    }

    /**
     * 发送图片消息
     * {
     * "touser":"OPENID",
     * "msgtype":"image",
     * "image":
     * {
     * "media_id":"MEDIA_ID"
     * }
     * }
     *
     * @param mediaId
     */
    public void sendImage(String mediaId) {
        this.msgType = MsgType.image.name();

        JSONObject jsonMsg = new JSONObject();
        jsonMsg.put("media_id", mediaId);

        JSONObject json = new JSONObject();
        json.put("touser", this.toUserOpenId);
        json.put("msgtype", this.msgType);
        json.put("image", jsonMsg);

        this.msgBody = json.toJSONString();

        send();
    }

    /**
     * 发送语音消息
     * <p>
     * {
     * "touser":"OPENID",
     * "msgtype":"voice",
     * "voice":
     * {
     * "media_id":"MEDIA_ID"
     * }
     * }
     */
    public void sendVoice(String mediaId) {
        this.msgType = MsgType.voice.name();

        JSONObject jsonMsg = new JSONObject();
        jsonMsg.put("media_id", mediaId);

        JSONObject json = new JSONObject();
        json.put("touser", this.toUserOpenId);
        json.put("msgtype", this.msgType);
        json.put("voice", jsonMsg);

        this.msgBody = json.toJSONString();
        send();
    }

    /**
     * 发送视频消息
     *
     * @param title
     * @param description
     * @param mediaId
     * @param thumbMediaId
     */
    public void sendVideo(String title, String description, String mediaId, String thumbMediaId) {
        VideoResponse video = new VideoResponse();
        video.setTitle(title);
        video.setDescription(description);
        video.setMediaId(thumbMediaId);
        video.setThumbMediaId(thumbMediaId);
        sendVideo(video);
    }

    /**
     * 发送视频消息
     * {
     * "touser":"OPENID",
     * "msgtype":"video",
     * "video":
     * {
     * "media_id":"MEDIA_ID",
     * "thumb_media_id":"MEDIA_ID",
     * "title":"TITLE",
     * "description":"DESCRIPTION"
     * }
     * }
     *
     * @param video
     */
    public void sendVideo(VideoResponse video) {
        this.msgType = MsgType.video.name();

        JSONObject jsonMsg = new JSONObject();
        jsonMsg.put("media_id", video.getMediaId());
        jsonMsg.put("thumb_media_id", video.getThumbMediaId());
        jsonMsg.put("title", video.getTitle());
        jsonMsg.put("description", video.getDescription());

        JSONObject json = new JSONObject();
        json.put("touser", this.toUserOpenId);
        json.put("msgtype", this.msgType);
        json.put("video", jsonMsg);

        this.msgBody = json.toJSONString();
        send();
    }

    /**
     * 发送音乐消息
     *
     * @param title
     * @param description
     * @param musicURL
     * @param hQMusicUrl
     * @param thumbMediaId
     */
    public void sendMusic(String title, String description, String musicURL, String hQMusicUrl, String thumbMediaId) {
        MusicResponse music = new MusicResponse();
        music.setTitle(title);
        music.setDescription(description);
        music.setMusicURL(musicURL);
        music.setHQMusicUrl(hQMusicUrl);
        music.setThumbMediaId(thumbMediaId);
        sendMusic(music);
    }

    /**
     * 发送音乐消息
     * {
     * "touser":"OPENID",
     * "msgtype":"music",
     * "music":
     * {
     * "title":"MUSIC_TITLE",
     * "description":"MUSIC_DESCRIPTION",
     * "musicurl":"MUSIC_URL",
     * "hqmusicurl":"HQ_MUSIC_URL",
     * "thumb_media_id":"THUMB_MEDIA_ID"
     * }
     * }
     *
     * @param music 音乐消息
     */
    public void sendMusic(MusicResponse music) {
        this.msgType = MsgType.music.name();

        JSONObject jsonMsg = new JSONObject();
        jsonMsg.put("title", music.getTitle());
        jsonMsg.put("description", music.getDescription());
        jsonMsg.put("musicurl", music.getMusicURL());
        jsonMsg.put("hqmusicurl", music.getHQMusicUrl());
        jsonMsg.put("thumb_media_id", music.getThumbMediaId());

        JSONObject json = new JSONObject();
        json.put("touser", this.toUserOpenId);
        json.put("msgtype", this.msgType);
        json.put("music", jsonMsg);

        this.msgBody = json.toJSONString();
        send();
    }

    /**
     * 发送图文消息，单条图文消息
     *
     * @param title       图文消息标题
     * @param description 图文消息描述
     * @param picUrl      图片链接，支持JPG、PNG格式，较好的效果为大图360*200，小图200*200
     * @param url         点击图文消息跳转链接
     */
    public void sendNew(String title, String description, String picUrl, String url) {
        ArticleResponse item = new ArticleResponse();
        item.setTitle(title);
        item.setDescription(description);
        item.setPicUrl(picUrl);
        item.setUrl(url);
        sendNews(item);
    }

    /**
     * 发送图文消息，单条图文消息
     *
     * @param item
     */
    public void sendNews(ArticleResponse item) {
        List<ArticleResponse> items = new ArrayList<ArticleResponse>();
        items.add(item);
        sendNews(items);
    }

    /**
     * 发送图文消息
     * {
     * "touser":"OPENID",
     * "msgtype":"news",
     * "news":{
     * "articles": [
     * {
     * "title":"Happy Day",
     * "description":"Is Really A Happy Day",
     * "url":"URL",
     * "picurl":"PIC_URL"
     * },
     * {
     * "title":"Happy Day",
     * "description":"Is Really A Happy Day",
     * "url":"URL",
     * "picurl":"PIC_URL"
     * }
     * ]
     * }
     * }
     *
     * @param items
     */
    public void sendNews(List<ArticleResponse> items) {
        this.msgType = MsgType.news.name();
        JSONArray jsonArray = new JSONArray();
        for (ArticleResponse item : items) {
            JSONObject jsonItem = new JSONObject();
            jsonItem.put("title", item.getTitle());
            jsonItem.put("description", item.getDescription());
            jsonItem.put("url", item.getUrl());
            jsonItem.put("picurl", item.getPicUrl());

            jsonArray.add(jsonItem);
        }

        JSONObject jsonMsg = new JSONObject();
        jsonMsg.put("articles", jsonArray);

        JSONObject json = new JSONObject();
        json.put("touser", this.toUserOpenId);
        json.put("msgtype", this.msgType);
        json.put("news", jsonMsg);

        this.msgBody = json.toJSONString();
        send();

    }
}
