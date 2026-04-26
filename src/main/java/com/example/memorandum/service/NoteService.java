package com.example.memorandum.service;


import com.example.memorandum.entity.Note;

import java.util.List;

/**
 * 备忘录服务接口
 * 定义备忘录相关的业务方法
 */
public interface NoteService {

    /**
     * 新增备忘录
     * @param note 备忘录信息
     * @return 是否新增成功
     */
    boolean addNote(Note note);

    /**
     * 根据用户ID查询所有备忘录
     * @param userId 用户ID
     * @return 备忘录列表
     */
    List<Note> getNotesByUserId(Integer userId);

    /**
     * 修改备忘录
     * @param note 备忘录信息
     * @return 是否修改成功
     */
    boolean updateNote(Note note);

    /**
     * 删除备忘录
     * @param id 备忘录ID
     * @return 是否删除成功
     */
    boolean deleteNote(Integer id);
}
