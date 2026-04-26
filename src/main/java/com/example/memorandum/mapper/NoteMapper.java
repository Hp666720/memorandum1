package com.example.memorandum.mapper;


import com.example.memorandum.entity.Note;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * 备忘录数据访问接口
 * 定义备忘录相关的数据操作方法
 */
@Mapper
public interface NoteMapper {

    /**
     * 新增备忘录
     * @param note 备忘录信息
     * @return 影响的行数
     */
    @Insert("INSERT INTO note(title,content,category,create_time, user_id) " +
            "VALUES(#{title},#{content},#{category},#{createTime},#{userId})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insert(Note note);

    /**
     * 根据用户ID查询备忘录列表
     * @param userId 用户ID
     * @return 备忘录列表
     */
    @Select("SELECT * FROM note WHERE user_id = #{userId}")
    List<Note> findByUserId(Integer userId);

    /**
     * 修改备忘录
     * @param note 备忘录信息
     * @return 影响的行数
     */
    @Update("UPDATE note SET title = #{title}, content = #{content}, category = #{category}, create_time = #{createTime} WHERE id = #{id}")
    int update(Note note);


    /**
     * 删除备忘录
     * @param id 备忘录ID
     * @return 影响的行数
     */
    @Delete("DELETE FROM note WHERE id = #{id}")
    int delete(Integer id);



}
