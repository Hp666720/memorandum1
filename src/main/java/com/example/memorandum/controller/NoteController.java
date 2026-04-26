package com.example.memorandum.controller;

import com.example.memorandum.entity.Note;
import com.example.memorandum.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 备忘录控制器
 * 处理备忘录的增删改查HTTP请求
 */
@RestController
@RequestMapping("/api/note")
public class NoteController {


    @Autowired
    private NoteService noteService;

    /**
     * 新增备忘录
     * @param note 备忘录信息
     * @return 操作结果
     */
    @PostMapping("/add")
    public Map<String, Object> addNote(@RequestBody Note note) {
        Map<String,Object> result = new HashMap<>();

        //简单参数校验
        if(note.getTitle() == null || note.getTitle().trim().isEmpty()){
            result.put("success",false);
            result.put("message","标题不能为空");
            return result;
        }
       if(note.getContent() == null || note.getContent().trim().isEmpty()){
           result.put("success",false);
           result.put("message","内容不能为空");
           return result;
       }
       //调用服务层新增方法
       boolean isSuccess = noteService.addNote(note);

       if(isSuccess){
           result.put("success",true);
           result.put("message","新增成功");
           return result;
       }else{
           result.put("success",false);
           result.put("message","新增失败");

       }
        return result;
    }

    /**
     * 根据用户ID查询所有备忘录
     * @param userId 用户ID
     * @return 备忘录列表
     */
    @GetMapping("/list/{userId}")
    public Map<String,Object> getNotesByUserId(@PathVariable Integer userId){
        Map<String,Object> result = new HashMap<>();

        //调用服务层查询方法
        List<Note> notes = noteService.getNotesByUserId(userId);

        result.put("success",true);
        result.put("data",notes);
        return result;
    }

    /**
     * 修改备忘录
     * @param note 备忘录信息
     * @return 操作结果
     */
    @PutMapping("/update")
    public Map<String,Object> updateNote(@RequestBody Note note){
        Map<String,Object> result = new HashMap<>();

        if(note.getId() ==null){
            result.put("success",false);
            result.put("message","备忘录ID不能为空");
            return result;
        }

        //调用服务层修改方法
        boolean isSuccess = noteService.updateNote(note);
        if(isSuccess){
        result.put("success",true);
        result.put("message","修改成功");
        }else{
            result.put("success",false);
            result.put("message","修改失败");
        }
        return result;
    }

    /**
     * 删除备忘录
     * @param id 备忘录ID
     * @return 操作结果
     */
    @DeleteMapping("/delete/{id}")
    public Map<String,Object> deleteNote(@PathVariable Integer id){
        Map<String,Object> result = new HashMap<>();

        boolean isSuccess = noteService.deleteNote(id);
        if(isSuccess){
            result.put("success",true);
            result.put("message","删除成功");
        }else{
            result.put("success",false);
            result.put("message","删除失败");
        }
        return result;
    }

}
