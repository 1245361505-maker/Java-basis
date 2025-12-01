package 额外练习.皇室战争角色数值查询;

public class Witch extends People {
    @Override
    public String getName() {
        return "witch";
    }

    @Override
    public void character() {
        System.out.println("女巫血量为1220，攻击为197");
    }
}
