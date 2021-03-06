package com.cdut.myschool.persist.mapper;

import com.cdut.myschool.persist.entity.Replay;
import com.cdut.myschool.persist.entity.ReplayExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ReplayMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table replay
     *
     * @mbg.generated Mon May 07 17:46:24 CST 2018
     */
    long countByExample(ReplayExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table replay
     *
     * @mbg.generated Mon May 07 17:46:24 CST 2018
     */
    int deleteByExample(ReplayExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table replay
     *
     * @mbg.generated Mon May 07 17:46:24 CST 2018
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table replay
     *
     * @mbg.generated Mon May 07 17:46:24 CST 2018
     */
    int insert(Replay record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table replay
     *
     * @mbg.generated Mon May 07 17:46:24 CST 2018
     */
    int insertSelective(Replay record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table replay
     *
     * @mbg.generated Mon May 07 17:46:24 CST 2018
     */
    List<Replay> selectByExample(ReplayExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table replay
     *
     * @mbg.generated Mon May 07 17:46:24 CST 2018
     */
    Replay selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table replay
     *
     * @mbg.generated Mon May 07 17:46:24 CST 2018
     */
    int updateByExampleSelective(@Param("record") Replay record, @Param("example") ReplayExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table replay
     *
     * @mbg.generated Mon May 07 17:46:24 CST 2018
     */
    int updateByExample(@Param("record") Replay record, @Param("example") ReplayExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table replay
     *
     * @mbg.generated Mon May 07 17:46:24 CST 2018
     */
    int updateByPrimaryKeySelective(Replay record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table replay
     *
     * @mbg.generated Mon May 07 17:46:24 CST 2018
     */
    int updateByPrimaryKey(Replay record);
}