package jp.matrix.mapper.poko;

import java.util.List;
import jp.matrix.dao.poko.Parts;
import jp.matrix.dao.poko.PartsExample;
import org.apache.ibatis.annotations.Param;

public interface PartsMapper {
    long countByExample(PartsExample example);

    int deleteByExample(PartsExample example);

    int deleteByPrimaryKey(Integer PID);

    int insert(Parts record);

    int insertSelective(Parts record);

    List<Parts> selectByExample(PartsExample example);

    Parts selectByPrimaryKey(Integer PID);

    int updateByExampleSelective(@Param("record") Parts record, @Param("example") PartsExample example);

    int updateByExample(@Param("record") Parts record, @Param("example") PartsExample example);

    int updateByPrimaryKeySelective(Parts record);

    int updateByPrimaryKey(Parts record);
}