package hello17.序列化;

import java.io.Serializable;

public class Book implements Serializable {
    private static final long serialVersionUID = 1L;
    private String name;

    public int getPrice() {
        return price;
    }

    private int price;

    public String getAuthor() {
        return author;
    }

    private String author;

    public String getName() {
        return name;
    }

    public Book(){

    }
    public Book(String name,int price,String author){
        this.author=author;
        this.price=price;
        this.name=name;
    }
}
