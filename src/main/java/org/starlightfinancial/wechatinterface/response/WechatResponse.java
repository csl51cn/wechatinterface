package org.starlightfinancial.wechatinterface.response;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

import java.util.List;

/**
 * Created by sili.chen on 2017/6/7.
 */
@Root(name = "xml")
public class WechatResponse {
    @Element(name = "ToUserName")
    private String ToUserName;
    @Element(name = "FromUserName")
    private String FromUserName;
    @Element(name = "CreateTime")
    private String CreateTime;
    @Element(name = "MsgType")
    private String MsgType;
    @Element(name = "Content", required = false)
    private String Content;
    @Element(name = "ArticleCount", required = false)
    private String ArticleCount;
    @Element(name = "Image", required = false)
    private ImageResponse Image;
    @Element(name = "Voice", required = false)
    private VoiceResponse Voice;
    @Element(name = "Video", required = false)
    private VideoResponse Video;
    @Element(name = "Music", required = false)
    private MusicResponse Music;
    @Element(name = "article", required = false)
    private List<ArticleResponse> article;
    @Element(name = "TransInfo", required = false)
    private TransInfoResponse TransInfo;

    public static String[] CDATA_TAG = {"ToUserName",
            "FromUserName", "MsgType", "Event", "MsgId", "Content", "MediaId", "Title", "Description", "MusicUrl", "HQMusicUrl", "ThumbMediaId",
            "PicUrl", "Url"
    };


    public String getToUserName() {
        return ToUserName;
    }

    public void setToUserName(String toUserName) {
        ToUserName = toUserName;
    }

    public String getFromUserName() {
        return FromUserName;
    }

    public void setFromUserName(String fromUserName) {
        FromUserName = fromUserName;
    }

    public String getCreateTime() {
        return CreateTime;
    }

    public void setCreateTime(String createTime) {
        CreateTime = createTime;
    }

    public String getMsgType() {
        return MsgType;
    }

    public void setMsgType(String msgType) {
        MsgType = msgType;
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }

    public String getArticleCount() {
        return ArticleCount;
    }

    public void setArticleCount(String articleCount) {
        ArticleCount = articleCount;
    }

    public ImageResponse getImage() {
        return Image;
    }

    public void setImage(ImageResponse image) {
        Image = image;
    }

    public VoiceResponse getVoice() {
        return Voice;
    }

    public void setVoice(VoiceResponse voice) {
        Voice = voice;
    }

    public VideoResponse getVideo() {
        return Video;
    }

    public void setVideo(VideoResponse video) {
        Video = video;
    }

    public MusicResponse getMusic() {
        return Music;
    }

    public void setMusic(MusicResponse music) {
        Music = music;
    }

    public List<ArticleResponse> getArticle() {
        return article;
    }

    public void setArticle(List<ArticleResponse> article) {
        this.article = article;
    }

    public TransInfoResponse getTransInfo() {
        return TransInfo;
    }

    public void setTransInfo(TransInfoResponse transInfo) {
        TransInfo = transInfo;
    }
}
