package JavaBasis.hello15.学生管理系统;

public class Student {
    private String stuNo;

    public void setStuNo(String stuNo) {
        this.stuNo = stuNo;
    }
    public String getStuNo() {
        return stuNo;
    }
    private String stuName;
    public void setStuName(String stuName) {
        this.stuName = stuName;
    }
    public String getStuName() {
        return stuName;
    }



    private int stuAge;

    public int getStuAge() {
        return stuAge;
    }

    public void setStuAge(int stuAge) {
        this.stuAge = stuAge;
    }
    public Student(){

    }
    public Student(String stuNo,String stuName,int stuAge){
        this.stuAge=stuAge;
        this.stuName=stuName;
        this.stuNo=stuNo;
    }
}
