package com.example.demo.Controller;

import com.example.demo.Entity.EnumEntity;
import com.example.demo.Entity.Msg;
import com.example.demo.Entity.User;
import com.example.demo.Param.MsgParam;
import com.example.demo.Service.LogService;
import com.example.demo.Service.MsgService;
import com.example.demo.Util.IPUtil;
import com.example.demo.Util.Page;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class MsgController {
    private final Logger log = LoggerFactory.getLogger(MsgController.class);

    @Autowired
    private MsgService msgService;

    @Autowired
    private LogService logService;

    /**
     * 查询Msg字典库，结果分页
     */
    @RequestMapping(value = "/getAllMsgs")
    public ModelAndView getAllMsgs(MsgParam param) {
        ModelAndView mav = new ModelAndView("/jsp/msgpage.jsp");
        List<Msg> msgList = msgService.getAllMsgs(param);
        Integer totalpage = msgService.getAllMsgsCounts(param);
        mav.addObject("msgList", msgList);
        param.setBeginLine((param.getCurrentPage() - 1) * param.getPageSize());
        Page p = new Page(totalpage, param);
        p.setList(msgList);
        p.setCurrentPage(param.getCurrentPage());
        mav.addObject("page", p);
        return mav;
    }

    /**
     * 跳转添加Msg字典库页面
     */
    @RequestMapping(value = "/addMsgpage")
    public ModelAndView toaddMsgpage() {
        ModelAndView mav = new ModelAndView("/jsp/msgadd.jsp");
        return mav;
    }

    /**
     * 添加Msg字典库
     */
    @RequestMapping(value = "/addMsg")
    @ResponseBody
    public Map<String, Object> addMsg(HttpServletRequest request, MsgParam param) {
        Map<String, Object> map = new HashMap<String, Object>();
        Msg msg = new Msg();
        msg.setMsg_id(param.getMsg_id());
        msg.setMsg_info(param.getMsg_info());
        msg.setMsg_code(param.getMsg_code());
        msg.setMsg_remark(param.getMsg_remark());
        int result = msgService.addMsg(msg);
        if (result != 0) {
            map.put("re", "40");
            String username = ((User) request.getSession().getAttribute("userInfo")).getUser_name();
            logService.addLog(username, EnumEntity.OperationTypeEnum.ADD, "添加Msg", IPUtil.getIpAddr(request), EnumEntity.StatusEnum.SUCCESS);
        }
        return map;
    }

    /**
     * 删除Msg字典库
     */
    @RequestMapping(value = "/deleteMsg")
    @ResponseBody
    public Map<String, Object> deleteMsg(HttpServletRequest request, Integer msg_id) {
        String username = ((User) request.getSession().getAttribute("userInfo")).getUser_name();
        Map<String, Object> map = new HashMap<String, Object>();
        int result = msgService.deleteMsg(msg_id);
        if (result != 0) {
            map.put("re", "41");
            logService.addLog(username, EnumEntity.OperationTypeEnum.DELETE, "删除Msg", IPUtil.getIpAddr(request), EnumEntity.StatusEnum.SUCCESS);
        } else {
            map.put("re", "42");
            logService.addLog(username, EnumEntity.OperationTypeEnum.DELETE, "删除Msg", IPUtil.getIpAddr(request), EnumEntity.StatusEnum.FAILURE);
        }
        return map;
    }

    /**
     * 跳转到修改Msg页面
     */
    @RequestMapping(value = "/toUpdateMsg")
    public ModelAndView toUpdateMsg(Msg msg) {
        ModelAndView mav = new ModelAndView("/jsp/msgadd.jsp");
        mav.addObject("msg", msg);
        mav.addObject("flag", 2);
        return mav;
    }

    /**
     * 修改Msg字典库
     */
    @RequestMapping(value = "/updateMsg")
    @ResponseBody
    public Map<String, Object> updateMsg(HttpServletRequest request, Msg msg) {
        String username = ((User) request.getSession().getAttribute("userInfo")).getUser_name();
        Map<String, Object> map = new HashMap<String, Object>();
        int result = msgService.updateMsg(msg);
        if (result != 0) {
            map.put("re", "11");
            logService.addLog(username, EnumEntity.OperationTypeEnum.UPDATE, "修改Msg", IPUtil.getIpAddr(request), EnumEntity.StatusEnum.SUCCESS);
        } else {
            map.put("re", "12");
            logService.addLog(username, EnumEntity.OperationTypeEnum.UPDATE, "修改Msg", IPUtil.getIpAddr(request), EnumEntity.StatusEnum.FAILURE);
        }
        return map;
    }
}
