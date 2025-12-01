package 额外练习.皇室战争角色数值查询;

public class Prince extends People {
    @Override
    public String getName() {
        return "Prince";
    }

    @Override
    public void character() {
        System.out.println("王子血量为2790，攻击为569");
    }
}
