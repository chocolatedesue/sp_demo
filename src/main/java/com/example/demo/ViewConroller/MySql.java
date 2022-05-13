package com.example.demo.ViewConroller;

import com.example.demo.entity.teacher;
import com.example.demo.mapper.teacherMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class MySql {
    @Resource
    teacherMapper mapper;

    @RequestMapping("/query")
    public List<teacher> test_teacher(){
    List<teacher> res=  mapper.FindALL();
//        System.out.println(res);
        for (var i: res){
            System.out.println(i);
        }
        return res;
    }

    @RequestMapping("/insert")
    public String add_teacher(@Param("name")String name){
        teacher t = new teacher();
        t.setName(name);
        mapper.addTeacher(t);
        return "插入成功,name=="+name;
    }

    @RequestMapping("/update")
    public  String update_t(@Param("name")String name,@Param("id")int tid){
        teacher t = new teacher();
        t.setName(name);
        t.setTid(tid);
        mapper.update(t);
        System.out.println(name+" "+String.valueOf(tid));
        return null;
    }

    @RequestMapping("/delete")
    public String del_t(@Param("tid")int tid){
        var t = mapper.findById(tid);
        mapper.deleteT(tid);
        return t.getName();
    }


}
