package cn.lgq.www.dao;

import cn.lgq.www.domain.Member_tab;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository("memberdao")
public interface Member_tabDao {

    @Select("select * from member_tab where id = #{memberId}")
    public Member_tab findById(String memberId);
}
