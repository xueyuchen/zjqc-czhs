package co.bohc.diet.app.admin.api.weixin;

import java.io.InputStream;
import java.util.Date;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import co.bohc.diet.domain.common.utils.MessageUtils;
import co.bohc.diet.domain.model.TextMessage;
import co.bohc.diet.domain.service.paper.PaperService;
import co.bohc.diet.domain.service.wechat.WeChatService;

@Controller
@RequestMapping(value = "wechat")
public class WeChatController {

    @Inject
    private PaperService paperService;

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public String test(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        InputStream inputStream = req.getInputStream();
        String postData = IOUtils.toString(inputStream, "UTF-8");
        Map<String, String> map = WeChatService.processRequest(postData);
        String Content = map.get("Content");
        String result = paperService.WCQueryPaper(Content);
        TextMessage returnMesg = new TextMessage();
        returnMesg.setCreateTime(new Date().getTime());
        returnMesg.setFromUserName(map.get("ToUserName"));
        returnMesg.setToUserName(map.get("FromUserName"));
        returnMesg.setMsgType(map.get("MsgType"));
        returnMesg.setContent(result);
        result = MessageUtils.textMessageToXml(returnMesg);
        result = new String(result.getBytes(), "gb2312");
        return "阿萨德";
    }
}
