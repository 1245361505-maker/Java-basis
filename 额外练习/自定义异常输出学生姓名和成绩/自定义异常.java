package 额外练习.自定义异常输出学生姓名和成绩;

public class 自定义异常 {
    public static class IllegalScoreException extends Exception {
        public IllegalScoreException(String message) {
            super(message);
        }
    }
    public static class IllegalNameException extends Exception {
        public IllegalNameException(String message) {
            super(message);
        }
    }
}
