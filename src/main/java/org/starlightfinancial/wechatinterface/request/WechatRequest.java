package org.starlightfinancial.wechatinterface.request;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/**
 * 微信request的对象属性
 * 不用cdata标记直接可以解析
 * 包括所有类型的节点,若报文中无此属性则解析的时候不会生成本属性
 * Created by sili.chen on 2017/6/7.
 */
@Root(name = "xml")
public class WechatRequest {
    @Element(name = "ToUserName", required = false)
    private String ToUserName;
    @Element(name = "FromUserName", required = false)
    private String FromUserName;
    @Element(name = "CreateTime", required = false)
    private String CreateTime;
    @Element(name = "MsgType", required = false)
    private String MsgType;
    @Element(name = "Event", required = false)
    private String Event;
    @Element(name = "EventKey", required = false)
    private String EventKey;
    @Element(name = "MsgId", required = false)
    private String MsgId;
    @Element(name = "Content", required = false)
    private String Content;
    @Element(name = "Location_X", required = false)
    private String Location_X;
    @Element(name = "Location_Y", required = false)
    private String Location_Y;
    @Element(name = "Scale", required = false)
    private String Scale;
    @Element(name = "Label", required = false)
    private String Label;
    @Element(name = "Title", required = false)
    private String Title;
    @Element(name = "Description", required = false)
    private String Description;
    @Element(name = "Url", required = false)
    private String Url;
    @Element(name = "PicUrl", required = false)
    private String PicUrl;
    @Element(name = "MediaId", required = false)
    private String MediaId;
    @Element(name = "Format", required = false)
    private String Format;
    @Element(name = "Status", required = false)
    private String Status;
    @Element(name = "Latitude", required = false)
    private String Latitude;  //上报地理位置事件Latitude
    @Element(name = "Longitude", required = false)
    private String Longitude; //上报地理位置事件Longitude
    @Element(name = "Precision", required = false)
    private String Precision; //上报地理位置事件Precision
    @Element(name = "Ticket", required = false)
    private String Ticket;    //扫描带参数二维码事件Ticket
    @Element(name = "ThumbMediaId", required = false)
    private String ThumbMediaId; //视频消息 ThumbMediaId 视频消息缩略图的媒体id，可以调用多媒体文件下载接口拉取数据
    @Element(name = "ScanCodeInfo", required = false)
    private ScanCodeInfo ScanCodeInfo; //扫描信息
    @Element(name = "SendPicsInfo", required = false)
    private SendPicsInfo SendPicsInfo; //发送的图片信息
    @Element(name = "SendLocationInfo", required = false)
    private SendLocationInfo SendLocationInfo;   //发送的位置信息
    @Element(name = "Recognition", required = false)
    private String Recognition;

    public String getRecognition() {
        return Recognition;
    }

    public void setRecognition(String recognition) {
        Recognition = recognition;
    }

    public String getFormat() {
        return Format;
    }

    public void setFormat(String format) {
        Format = format;
    }

    public String getPicUrl() {
        return PicUrl;
    }

    public void setPicUrl(String picUrl) {
        PicUrl = picUrl;
    }

    public String getMediaId() {
        return MediaId;
    }

    public void setMediaId(String mediaId) {
        MediaId = mediaId;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getUrl() {
        return Url;
    }

    public void setUrl(String url) {
        Url = url;
    }

    public String getLocation_X() {
        return Location_X;
    }

    public void setLocation_X(String location_X) {
        Location_X = location_X;
    }

    public String getLocation_Y() {
        return Location_Y;
    }

    public void setLocation_Y(String location_Y) {
        Location_Y = location_Y;
    }

    public String getScale() {
        return Scale;
    }

    public void setScale(String scale) {
        Scale = scale;
    }

    public String getLabel() {
        return Label;
    }

    public void setLabel(String label) {
        Label = label;
    }

    public String getMsgId() {
        return MsgId;
    }

    public void setMsgId(String msgId) {
        MsgId = msgId;
    }

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

    public String getEvent() {
        return Event;
    }

    public void setEvent(String event) {
        Event = event;
    }

    public String getEventKey() {
        return EventKey;
    }

    public void setEventKey(String eventKey) {
        EventKey = eventKey;
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public String getLatitude() {
        return Latitude;
    }

    public void setLatitude(String latitude) {
        Latitude = latitude;
    }

    public String getLongitude() {
        return Longitude;
    }

    public void setLongitude(String longitude) {
        Longitude = longitude;
    }

    public String getPrecision() {
        return Precision;
    }

    public void setPrecision(String precision) {
        Precision = precision;
    }

    public String getTicket() {
        return Ticket;
    }

    public void setTicket(String ticket) {
        Ticket = ticket;
    }

    public String getThumbMediaId() {
        return ThumbMediaId;
    }

    public void setThumbMediaId(String thumbMediaId) {
        ThumbMediaId = thumbMediaId;
    }

    public ScanCodeInfo getScanCodeInfo() {
        return ScanCodeInfo;
    }

    public void setScanCodeInfo(ScanCodeInfo scanCodeInfo) {
        ScanCodeInfo = scanCodeInfo;
    }

    public SendPicsInfo getSendPicsInfo() {
        return SendPicsInfo;
    }

    public void setSendPicsInfo(SendPicsInfo sendPicsInfo) {
        SendPicsInfo = sendPicsInfo;
    }

    public SendLocationInfo getSendLocationInfo() {
        return SendLocationInfo;
    }

    public void setSendLocationInfo(SendLocationInfo sendLocationInfo) {
        SendLocationInfo = sendLocationInfo;
    }
}
