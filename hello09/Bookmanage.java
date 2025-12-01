package hello09;

public class Bookmanage {
    Book[]books=new Book[50];
    public void initBooks(){
        Book book=new Book();
        book.name="阿泰勒的角落";
        book.author="李娟";
        book.price=100;
        books[0]=book;

        Book book1=new Book();
        book1.name="平凡的世界";
        book1.author="路遥";
        book1.price=200;
        books[1]=book1;

    }
    public void booklist(){
        System.out.println("这里是图书列表");
        System.out.printf("%-20s%-15s%-10s\n", "书名", "作者", "价格");
        System.out.println("-------------------------------------------");
        for(int i=0;i<books.length;i++){
            if(books[i]!=null){
                System.out.printf("%-20s%-15s%-10d\n", books[i].name, books[i].author, books[i].price);
            }
        }
        System.out.println("-------------------------------------------");
    }
    public Boolean addbooks(Book book){
        boolean flag=false;
        for(int i=0;i<books.length;i++){
            if(books[i]==null){
                books[i]=book;
                flag=true;
                break;
            }
        }
        return flag;
    }
}
