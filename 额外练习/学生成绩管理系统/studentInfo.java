package 额外练习.学生成绩管理系统;

public class studentInfo {
    String name;
    int age;
    double score;
    //构建一个studentInfo类，包含name age score 三个信息及其set和get方法
    public double getScore() {
        return score;
    }
    public void setScore(double score) {
        this.score = score;
    }

    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
