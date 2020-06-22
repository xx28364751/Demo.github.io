package com.example.demo.Mapper;

import com.example.demo.Entity.Msg;
import com.example.demo.Util.BaseParam;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface MsgMapper {
    @Select("select * from msg limit #{beginLine},#{pageSize}")
    List<Msg> getAllMsgs(BaseParam param);

    @Select("select count(*) from msg")
    Integer getAllMsgsCounts(BaseParam param);

    @Insert("insert into msg (msg_info,msg_code,msg_remark) values (#{msg_info},#{msg_code},#{msg_remark})")
    int addMsg(Msg msg);

    @Select("select * from msg where msg_info like '%#{msg_info}%' limit #{beginLine},#{pageSize}")
    List<Msg> findMsgs(BaseParam param);

    @Delete("delete from msg where msg_id=#{msg_id}")
    int deleteMsg(int msg_id);

    @Update("update msg set msg_info=#{msg_info},msg_code=#{msg_code},msg_remark=#{msg_remark} where msg_id=#{msg_id}")
    int updateMsg(Msg msg);

    @Select("select count(*) from msg where msg_info like '%${msg_info}%' and msg_code like '%${msg_code}%' and msg_remark like '%${msg_remark}%'")
    Integer findMsgsCounts(BaseParam param);
}
