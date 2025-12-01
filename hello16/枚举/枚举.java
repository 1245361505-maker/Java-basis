package JavaBasis.hello16.枚举;

public class 枚举 {
    public static void test(WWKDAY day){
        switch (day){
            case MONDAY :
                System.out.println("周一");
                break;
            case TUESDAY:
                System.out.println("周二");
                break;
            case WEDNESDAY:
                System.out.println("周三");
                break;
            case THURSDY:
                System.out.println("周四");
                break;
            case FRIDAY:
                System.out.println("周五");
                break;
            case SATURDAY:
                System.out.println("周六");
                break;
            case SUNDAY:
                System.out.println("周日");
                break;
            default:
                System.out.println("未知数据");
                break;
        }
    }
    static void main(String[] args) {
        int num=1;
        WWKDAY day=WWKDAY.MONDAY;
        test(day);
    }
}
