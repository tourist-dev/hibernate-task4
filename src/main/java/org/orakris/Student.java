package org.orakris;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;

    @ManyToMany(targetEntity = Teacher.class, cascade = {CascadeType.ALL})
    @JoinTable(name = "teacher_student", joinColumns = {@JoinColumn(name = "s_id")}, inverseJoinColumns = { @JoinColumn(name = "t_id") })
    private List<Teacher> teacherList;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Teacher> getTeacherList() {
        return teacherList;
    }

    public void setTeacherList(List<Teacher> teacherList) {
        this.teacherList = teacherList;
    }
}
