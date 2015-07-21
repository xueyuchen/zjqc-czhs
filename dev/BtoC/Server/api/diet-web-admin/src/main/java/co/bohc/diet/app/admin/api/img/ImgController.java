package co.bohc.diet.app.admin.api.img;

import java.io.FileInputStream;

import sun.misc.BASE64Encoder;

import java.io.IOException;
import java.io.InputStream;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "imgs")
public class ImgController {

    @RequestMapping(value = "{modelId}/{styleId}/{partId}/{imgName}", method = RequestMethod.GET)
    @ResponseBody
    public String getImg(@PathVariable String modelId, @PathVariable String styleId, @PathVariable String partId,
            @PathVariable String imgName) {
        String imgFilePath = "d://img//" + modelId + "//" + styleId + "//" + partId + "//" + imgName + ".jpg";// 新生成的图片
        return getImageStr(imgFilePath);
    }
    
    private String getImageStr(String imgFilePath) {// 将图片文件转化为字节数组字符串，并对其进行Base64编码处理
        byte[] data = null;
        
        // 读取图片字节数组
        try {
            InputStream in = new FileInputStream(imgFilePath);
            data = new byte[in.available()];
            in.read(data);
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        // 对字节数组Base64编码
        BASE64Encoder encoder = new BASE64Encoder();
        return encoder.encode(data);// 返回Base64编码过的字节数组字符串
    }
}
