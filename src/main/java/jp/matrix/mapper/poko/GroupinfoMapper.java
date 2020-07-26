package jp.matrix.mapper.poko;

import java.util.List;
import jp.matrix.dao.poko.Groupinfo;
import jp.matrix.dao.poko.GroupinfoExample;
import org.apache.ibatis.annotations.Param;

public interface GroupinfoMapper {
    long countByExample(GroupinfoExample example);

    int deleteByExample(GroupinfoExample example);

    int deleteByPrimaryKey(Integer GPID);

    int insert(Groupinfo record);

    int insertSelective(Groupinfo record);

    List<Groupinfo> selectByExample(GroupinfoExample example);

    Groupinfo selectByPrimaryKey(Integer GPID);

    int updateByExampleSelective(@Param("record") Groupinfo record, @Param("example") GroupinfoExample example);

    int updateByExample(@Param("record") Groupinfo record, @Param("example") GroupinfoExample example);

    int updateByPrimaryKeySelective(Groupinfo record);

    int updateByPrimaryKey(Groupinfo record);
}