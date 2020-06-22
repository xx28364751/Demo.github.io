package com.example.demo.Service.ServiceImpl;

import com.example.demo.Entity.Msg;
import com.example.demo.Mapper.MsgMapper;
import com.example.demo.Service.MsgService;
import com.example.demo.Util.BaseParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MsgServiceImpl implements MsgService {

    @Autowired
    private MsgMapper msgMapper;

    @Override
    public List<Msg> getAllMsgs(BaseParam param) {
        return msgMapper.getAllMsgs(param);
    }

    @Override
    public Integer getAllMsgsCounts(BaseParam param) {
        return msgMapper.getAllMsgsCounts(param);
    }

    @Override
    public int addMsg(Msg msg) {
        return msgMapper.addMsg(msg);
    }

    @Override
    public int deleteMsg(int msg_id) {
        return msgMapper.deleteMsg(msg_id);
    }

    @Override
    public int updateMsg(Msg msg) {
        return msgMapper.updateMsg(msg);
    }

    //模糊查询
    @Override
    public Integer findMsgsCounts(BaseParam param) {
        return msgMapper.findMsgsCounts(param);
    }
}
