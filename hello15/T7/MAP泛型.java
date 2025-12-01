package JavaBasis.hello15.T7;

import hello15.T2.Book;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Stream;

public class MAP泛型 {
    public static void main(String[] args) {
        Map<String, Book>map=new HashMap<String,Book>();
        Book b1=new Book("阿泰勒的角落",60,"李娟");
        Book b2=new Book("你是人间四月天",70,"林徽因");
        map.put(b1.getName(),b1);
        map.put(b2.getName(),b2);
        Set<String>keys=map.keySet();
        for(String key:keys){
            Book value=map.get(key);
            System.out.println(key+"==="+value.getAuthor());
            System.out.println("=========");
        }
        Collection<Book>values=map.values();
        for(Book value:values){
            System.out.println(value.getName()+"====="+value.getAuthor());
        }
        Set<Map.Entry<String,Book>>entries=map.entrySet();
        for(Map.Entry<String,Book>entry:entries){
            System.out.println(entry.getKey()+"==========="+entry.getValue().getAuthor());
        }
        System.out.println("-------------------");
        Stream<Map.Entry<String,Book>> stream=map.entrySet().stream();
        stream.forEach(entry-> System.out.println(entry.getKey()+"=========="+entry.getValue().getAuthor()));
    }
}
