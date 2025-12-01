package JavaBasis.hello16;

public class Stringbuffer {
    static void main(String[] args) {
        StringBuffer sb=new StringBuffer();
        sb.append("北京");
        sb.append("天津");
        sb.insert(2,"上海");
        String a=sb.toString();
        System.out.println(a);
    }
}
