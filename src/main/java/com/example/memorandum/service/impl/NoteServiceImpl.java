package com.example.memorandum.service.impl;

import com.example.memorandum.entity.Note;
import com.example.memorandum.mapper.NoteMapper;
import com.example.memorandum.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * 备忘录服务实现类
 * 实现备忘录的增删改查业务逻辑
 */
@Service
public class NoteServiceImpl implements NoteService {


    @Autowired
    private NoteMapper noteMapper;

    /**
     * 新增备忘录
     * 1. 设置创建时间
     * 2. 插入数据库
     * @param note 备忘录信息
     * @return 是否新增成功
     */
    @Override
    public boolean addNote(Note note) {
        // 1. 设置创建时间
        note.setCreateTime(new Date());
        // 2. 插入数据库
        int rows = noteMapper.insert(note);
        return rows > 0;
    }

    /**
     * 根据用户ID查询所有备忘录
     * @param userId 用户ID
     * @return 备忘录列表
     */
    @Override
    public List<Note> getNotesByUserId(Integer userId) {
        return noteMapper.findByUserId(userId);
    }

    /**
     * 修改备忘录
     * @param note 备忘录信息
     * @return 是否修改成功
     */
    @Override
    public boolean updateNote(Note note) {
       int rows = noteMapper.update(note);
       return rows > 0;
    }

    /**
     * 删除备忘录
     * @param id 备忘录ID
     * @return 是否删除成功
     */
    @Override
    public boolean deleteNote(Integer id) {
        int rows = noteMapper.delete(id);
        return rows > 0;
    }
}
