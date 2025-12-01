package JavaBasis.hello15.T5;

import java.util.*;

public class haximap {
    public static void main(String[] args) {
        Map map=new HashMap();
        map.put("CBC","中国建设银行");
        map.put("ABC","中国农业银行");
        map.put("ICBC","中国工商银行");
        String value=(String)map.get("CBC");
        System.out.println(value);
        System.out.println("==================");
        Set set=map.keySet();
        Iterator iterator = set.iterator();
        //不是所有对象都是new出来的，可以通过对象的方法创建对象
        System.out.println(set);
        Collection values=map.values();
        System.out.println(values);
        System.out.println("=============");
        System.out.println(map);
        System.out.println(map.size());
        if(map.containsKey("ICBC")){
            System.out.println("存在");
        }else{
            System.out.println("不存在");
        }
        while(iterator.hasNext()){
            String key =(String) iterator.next();
            String v=(String)map.get(key);
            System.out.println(key+" "+v);
        }
    }
}
