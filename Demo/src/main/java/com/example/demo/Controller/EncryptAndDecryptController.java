package com.example.demo.Controller;

import cn.hutool.http.HttpRequest;
import com.example.demo.Util.ThreeDesUtil;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
public class EncryptAndDecryptController {
    private static final Logger logger = LoggerFactory.getLogger(EncryptAndDecryptController.class);

    /**
     * 跳转到加密解密功能页面
     */
    @RequestMapping(value = "/encryptAnddecrypt")
    public ModelAndView toencryptAnddecrypt() {
        ModelAndView mav = new ModelAndView("/jsp/encryptAnddecrypt.jsp");
        return mav;
    }

    /**
     * 3Des加密
     *
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/toTDencrypt", method = RequestMethod.POST)
    public Map<String, Object> toTDencrypt(HttpServletRequest request) {
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            String TDencryptText = request.getParameter("TDencryptText");
            String result = ThreeDesUtil.desEncrypt(TDencryptText);
            if (StringUtils.isNotBlank(result)) {
                map.put("code", 1);
                map.put("data", result);
                return map;
            } else {
                map.put("code", 0);
                return map;
            }
        } catch (Exception e) {
            logger.error("3Des加密异常", e);
        }
        map.put("code", 0);
        return map;
    }

    /**
     * 3Des解密
     *
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/toTDdecrypt", method = RequestMethod.POST)
    public Map<String, Object> toTDdecrypt(HttpServletRequest request) {
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            String TDdecryptText = request.getParameter("TDdecryptText");
            String result = ThreeDesUtil.desDecrypt(TDdecryptText);
            if (StringUtils.isNotBlank(result)) {
                map.put("code", 1);
                map.put("data", result);
                return map;
            } else {
                map.put("code", 0);
                return map;
            }
        } catch (Exception e) {
            logger.error("3Des解密异常", e);
        }
        map.put("code", 0);
        return map;
    }
}
