package org.starlightfinancial.wechatinterface.request;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import java.util.List;

/**
 * Created by sili.chen on 2017/6/7.
 */
public class SendPicsInfo {
    private String Count;
    private List item;

    @XmlElement(name = "Count")
    public String getCount() {
        return Count;
    }

    public void setCount(String count) {
        Count = count;
    }

    @XmlElementWrapper(name = "PicList")
    @XmlElement(name = "item")
    public List getItem() {
        return item;
    }

    public void setItem(List item) {
        this.item = item;
    }
}
