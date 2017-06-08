package org.starlightfinancial.wechatinterface.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.starlightfinancial.wechatinterface.common.ValidateSignature;
import org.starlightfinancial.wechatinterface.service.CoreService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by sili.chen on 2017/6/8.
 */
@Controller
public class CoreController {
    @RequestMapping(path = "/", method = RequestMethod.GET)
    @ResponseBody
    String checkSignature(@RequestParam(value = "signature", required = false) String signature,
                          @RequestParam(value = "timestamp", required = false) String timestamp,
                          @RequestParam(value = "nonce", required = false) String nonce,
                          @RequestParam(value = "echostr", required = false) String echostr, Model model) {
        ValidateSignature validateSignature = new ValidateSignature(signature, timestamp, nonce, echostr);
        if (validateSignature.check())
            return echostr;
        return "";
    }

    @RequestMapping(path = "/", method = RequestMethod.POST)
    @ResponseBody
    String post(HttpServletRequest req, HttpServletResponse res) throws IOException {
        CoreService coreService = new CoreService(req);
//        BufferedReader bufferReader = req.getReader();
//        StringBuffer buffer = new StringBuffer();
//        String line = "";
//        while ((line = bufferReader.readLine()) != null) {
//            buffer.append(line);
//        }
//        String postData = buffer.toString();
//        System.out.println(postData);
        return coreService.execute();
    }
}
