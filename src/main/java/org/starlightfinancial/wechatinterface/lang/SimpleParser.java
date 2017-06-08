package org.starlightfinancial.wechatinterface.lang;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;

/**
 * Created by sili.chen on 2017/6/7.
 */
public class SimpleParser {
    private static final Log logger = LogFactory.getLog(SimpleParser.class);

    private Class clazz;
    private String[] cdataNode;

    /**
     * @param clazz
     */
    public SimpleParser(Class clazz) {
        this.clazz = clazz;
    }

    /**
     * 设置需要包含CDATA的节点
     *
     * @param cdataNode
     */
    public void setCdataNode(String[] cdataNode) {
        this.cdataNode = cdataNode;
    }

    /**
     * 转为xml串
     *
     * @param obj
     * @return
     */
    public String toXML(Object obj) {
        String result = null;
        Serializer serializer = new Persister();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            serializer.write(obj, byteArrayOutputStream);
            result = byteArrayOutputStream.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        logger.info("response text:\n" + result);
        return result;
    }


    /**
     * 转为对象
     *
     * @param is
     * @return
     */
    public Object toObj(InputStream is) {
        Serializer serializer = new Persister();
        try {
            Object obj = serializer.read(Object.class, is);
            return obj;
        } catch (Exception e) {
            logger.error("post data parse error");
            e.printStackTrace();
        }
        return null;
    }

    /**
     * XML转为对象
     *
     * @param xmlStr
     * @return
     */
    public Object toObj(String xmlStr) {
        InputStream is = new ByteArrayInputStream(xmlStr.getBytes());
        return toObj(is);
    }

    /**
     * 适配cdata tag
     */
    private void formatCDataTag() {
        for (int i = 0; i < cdataNode.length; i++) {
            cdataNode[i] = "^" + cdataNode[i];
        }
    }
}
