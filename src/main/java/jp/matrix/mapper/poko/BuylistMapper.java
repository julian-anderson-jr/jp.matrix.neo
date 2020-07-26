package jp.matrix.mapper.poko;

import java.util.List;
import jp.matrix.dao.poko.Buylist;
import jp.matrix.dao.poko.BuylistExample;
import jp.matrix.dao.poko.BuylistKey;
import org.apache.ibatis.annotations.Param;

public interface BuylistMapper {
    long countByExample(BuylistExample example);

    int deleteByExample(BuylistExample example);

    int deleteByPrimaryKey(BuylistKey key);

    int insert(Buylist record);

    int insertSelective(Buylist record);

    List<Buylist> selectByExample(BuylistExample example);

    Buylist selectByPrimaryKey(BuylistKey key);

    int updateByExampleSelective(@Param("record") Buylist record, @Param("example") BuylistExample example);

    int updateByExample(@Param("record") Buylist record, @Param("example") BuylistExample example);

    int updateByPrimaryKeySelective(Buylist record);

    int updateByPrimaryKey(Buylist record);
}