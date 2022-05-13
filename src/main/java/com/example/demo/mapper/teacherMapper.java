package com.example.demo.mapper;

import com.example.demo.entity.teacher;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface teacherMapper {
    @Select("select * from teacher")
    List<teacher> FindALL();

    @Select("select * from teacher where tid = #{tid}")
    teacher findById(int tid);
    
    //int 返回插入结果
    @Insert("Insert into teacher(tid,name) values(#{tid},#{name})")
    int addTeacher(teacher t);

    @Delete("Delete from teacher where tid=#{tid}")
    int deleteT(int tid);

    @Update("update teacher set name=#{name} where tid=#{tid}")
    int update(teacher t);

}
