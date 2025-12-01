package JavaBasis.hello15.学生管理系统;

import java.util.ArrayList;
import java.util.List;

public class StudentMgr {
    List<Student>list=new ArrayList<Student>();
    public boolean addStudent(Student stu){
        boolean flag=list.add(stu);
        return flag;
    }
    public void printAll(){
        for(Student stu:list){
            System.out.println(stu.getStuNo() + " "+stu.getStuName()+" "+stu.getStuAge());
        }
    }
}
