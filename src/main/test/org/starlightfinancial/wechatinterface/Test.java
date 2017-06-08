package org.starlightfinancial.wechatinterface;

import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;
import org.starlightfinancial.wechatinterface.lang.SimpleParser;
import org.starlightfinancial.wechatinterface.request.WechatRequest;

/**
 * Created by sili.chen on 2017/6/8.
 */
public class Test {
    public static void main(String[] args) {
//        Serializer serializer = new Persister();
//        Lure lure = new Lure();
//        lure.setCompany("中国");
//        lure.setModel("Marlin Buster");
//        lure.setQuantityInStock(23);
//        lure.setType("Trolling");
//
//        SimpleParser simpleParser = new SimpleParser(Lure.class);
//        String ss = simpleParser.toXML(lure);

        String ss = "<xml><ToUserName><![CDATA[gh_69575c9a7ffc]]></ToUserName>\n" +
                "<FromUserName><![CDATA[oNEhJw5nYXzLXm8u2oP175RqYG2o]]></FromUserName>\n" +
                "<CreateTime>1496894052</CreateTime>\n" +
                "<MsgType><![CDATA[text]]></MsgType>\n" +
                "<Content><![CDATA[haha]]></Content>\n" +
                "<MsgId>6429110999339606161</MsgId>\n" +
                "</xml>";
        SimpleParser simpleParser = new SimpleParser(WechatRequest.class);
        WechatRequest wechatRequest = (WechatRequest) simpleParser.toObj(ss);
    }
}
