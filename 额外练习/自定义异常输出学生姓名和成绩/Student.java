package 额外练习.自定义异常输出学生姓名和成绩;

import static 额外练习.自定义异常输出学生姓名和成绩.自定义异常.*;

public class Student {
    private String name;
    private double score;

    public void setName(String name) throws IllegalNameException {
        if (name == null) {
            throw new IllegalNameException("name shouldn't be null");
        } else if (name.length() < 2 || name.length() > 100) {
            throw new IllegalNameException("wrong name " + name);
        }
        this.name = name;
        System.out.println("name set successfully: " + name);
    }

    public void setScore(double score) throws IllegalScoreException {
        if (score < 0 || score > 100) {
            throw new IllegalScoreException("wrong score " + score);
        }
        this.score = score;
        System.out.println("score set successfully: " + score);
    }
}