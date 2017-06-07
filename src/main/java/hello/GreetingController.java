package hello;

import org.starlightfinancial.wechatinterface.constant.MsgTypeConstant;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;

/**
 * Created by sili.chen on 2017/5/31.
 */
@Controller
public class GreetingController extends MsgTypeConstant {


    @RequestMapping(path = "/checkSignature", method = RequestMethod.GET)
    @ResponseBody
    String checkSignature(@RequestParam(value = "signature", required = false) String signature,
                          @RequestParam(value = "timestamp", required = false) String timestamp,
                          @RequestParam(value = "nonce", required = false) String nonce,
                          @RequestParam(value = "echostr", required = false) String echostr, Model model) {
        return echostr;
    }

    @RequestMapping(path = "/checkSignature", method = RequestMethod.POST)
    @ResponseBody
    String dealUserMessages(HttpServletRequest req, HttpServletResponse res) throws IOException {
        BufferedReader bufferReader = req.getReader();
        StringBuffer buffer = new StringBuffer();
        String line = "";
        while ((line = bufferReader.readLine()) != null) {
            buffer.append(line);
        }
        String postData = buffer.toString();
        System.out.println(postData);
        return "你好";
    }

    private void receiveEvent(String postData) {
        int msgType = parseMsgType(postData);
        switch (msgType) {
            case 1:
                receiveTextData(postData);
                break;
            case 2:
                receiveImageData(postData);
                break;
            case 3:
                receiveVoiceData(postData);
                break;
            case 4:
                receiveVideoData(postData);
                break;
            case 5:
                receiveLocationData(postData);
                break;
            case 6:
                receiveLinkData(postData);
                break;
            default:
        }
    }

    private void receiveLinkData(String postData) {
    }

    private void receiveLocationData(String postData) {
    }

    private void receiveVideoData(String postData) {
    }

    private void receiveVoiceData(String postData) {
    }

    private void receiveImageData(String postData) {

    }

    private void receiveTextData(String postData) {

    }

    private int parseMsgType(String postData) {

        return 0;
    }
}
