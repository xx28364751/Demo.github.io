package com.example.demo.Service;

import com.example.demo.Entity.Msg;
import com.example.demo.Util.BaseParam;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MsgService {
    //获取所有用户
    List<Msg> getAllMsgs(BaseParam param);

    //查询数据总数
    Integer getAllMsgsCounts(BaseParam param);

    //添加msg信息
    int addMsg(Msg msg);

    //删除msg信息
    int deleteMsg(int msg_id);

    //修改msg信息
    int updateMsg(Msg msg);
    //模糊查询总条数
    Integer findMsgsCounts(BaseParam param);
}
