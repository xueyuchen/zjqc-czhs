package co.bohc.diet.app.admin.api.weixin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Date;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
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

    /**
     * Function:微信服务
     * 
     * @author JLC
     * @return
     * @throws IOException
     */
    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public String weixinService(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        // try{
        // //微信加密签名
        // String signature = getRequest().getParameter("signature");
        // //时间戳
        // String timestamp = getRequest().getParameter("timestamp");
        // //随机数
        // String nonce = getRequest().getParameter("nonce");
        // //随机字符串
        // String echostr = getRequest().getParameter("echostr");
        // if (StringUtils.isNotEmpty(echostr)) {
        // echostr = checkAuthentication(signature,timestamp,nonce,echostr);
        // //验证通过返回随即字串
        // getResponse().getWriter().write(echostr);
        // getResponse().getWriter().flush();
        // }else{

        String postStr = readStreamParameter(req.getInputStream());
        
        if (null != postStr && !postStr.isEmpty()) {
            Document document = null;
            try {
                document = DocumentHelper.parseText(postStr);
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (null == document) {
                resp.getWriter().write("nothing");
                return null;
            }
            Element root = document.getRootElement();
            String fromUsername = root.elementText("FromUserName"); // 取得发送者
            String toUsername = root.elementText("ToUserName"); // 取得接收者
            String userMsgType = root.elementText("MsgType");
            String userMsgEvent = root.elementText("Event");
            String keyword = new String(root.elementTextTrim("Content").getBytes(), "UTF-8");
            String time = new Date().getTime() + "";
            String textTpl = "<xml>" + "<ToUserName><![CDATA[%1$s]]></ToUserName>"
                    + "<FromUserName><![CDATA[%2$s]]></FromUserName>" + "<CreateTime>%3$s</CreateTime>"
                    + "<MsgType><![CDATA[%4$s]]></MsgType>" + "<Content><![CDATA[%5$s]]></Content>"
                    + "<FuncFlag>0</FuncFlag>" + "</xml>";
            String msgType = "text";
            // 当回复内容为 深圳文字 的指令时
            if (null != keyword) {
                String contentStr = paperService.WCQueryPaper(keyword);
                String resultStr = textTpl.format(textTpl, fromUsername, toUsername, time, msgType, contentStr);
                resp.getWriter().write(resultStr);
            }
        } else {
            resp.getWriter().write("欢迎关注PICC残值管理系统");
        }
        // }
        // }catch(Exception e){
        // }
        return null;
    }

    // 从输入流读取post参数
    public String readStreamParameter(ServletInputStream in) {
        StringBuilder buffer = new StringBuilder();
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new InputStreamReader(in));
            String line = null;
            while ((line = reader.readLine()) != null) {
                buffer.append(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (null != reader) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return buffer.toString();
    }

     /**
     * Function:微信验证方法
     * @author JLC
     * @param signature 微信加密签名
     * @param timestamp 时间戳
     * @param nonce 随机数
     * @param echostr 随机字符串
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
     public String checkAuthentication(String signature,String
     timestamp,String nonce,String echostr) {
     String result ="";
     String Token = "czhsCdZhouQiang";
     // 将获取到的参数放入数组
     String[] ArrTmp = { Token, timestamp, nonce };
     // 按微信提供的方法，对数据内容进行排序
     Arrays.sort(ArrTmp);
     StringBuffer sb = new StringBuffer();
     for (int i = 0; i < ArrTmp.length; i++) {
     sb.append(ArrTmp[i]);
     }
     // 对排序后的字符串进行SHA-1加密
     String pwd = Encrypt(sb.toString());
     if (pwd.equals(signature)) {
     try {
     System.out.println("微信平台签名消息验证成功！");
     result = echostr;
     } catch (Exception e) {
     e.printStackTrace();
     }
     } else {
     System.out.println("微信平台签名消息验证失败！");
     }
     return result;
     }

    /**
     * 用SHA-1算法加密字符串并返回16进制串
     * 
     * @param strSrc
     * @return
     */
    private String Encrypt(String strSrc) {
        MessageDigest md = null;
        String strDes = null;
        byte[] bt = strSrc.getBytes();
        try {
            md = MessageDigest.getInstance("SHA-1");
            md.update(bt);
            strDes = bytes2Hex(md.digest());
        } catch (NoSuchAlgorithmException e) {
            System.out.println("错误");
            return null;
        }
        return strDes;
    }

    private String bytes2Hex(byte[] bts) {
        String des = "";
        String tmp = null;
        for (int i = 0; i < bts.length; i++) {
            tmp = (Integer.toHexString(bts[i] & 0xFF));
            if (tmp.length() == 1) {
                des += "0";
            }
            des += tmp;
        }
        return des;
    }
}
