package org.starlightfinancial.wechatinterface;

import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;
import org.starlightfinancial.wechatinterface.lang.SimpleParser;

/**
 * Created by sili.chen on 2017/6/8.
 */
public class Test {
    public static void main(String[] args) {
        Serializer serializer = new Persister();
        Lure lure = new Lure();
        lure.setCompany("中国");
        lure.setModel("Marlin Buster");
        lure.setQuantityInStock(23);
        lure.setType("Trolling");

        SimpleParser simpleParser = new SimpleParser(Lure.class);
        String ss = simpleParser.toXML(lure);
    }
}
