package 额外练习.图书管理系统;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

import static 额外练习.图书管理系统.LoggerUtil.*;

public class NewBookOperatingSystem {
    ArrayList<Books> books=new ArrayList<>();
    Scanner sc;
    private static final String XML_FILE_PATH = "src/额外练习/图书管理系统/books.xml";
    private Books searchAndSelectBook(String keyword) {
        keyword = keyword.trim().toLowerCase();
        ArrayList<Integer> matchedIndices = new ArrayList<>();
        int displayNumber = 1;
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getBookName().toLowerCase().contains(keyword)) {
                System.out.println(displayNumber + ". " + books.get(i).getBookName()
                        + " (left with: " + books.get(i).getCount() + ")");
                matchedIndices.add(i);
                displayNumber++;
            }
        }

        if (matchedIndices.isEmpty()) {
            System.out.println("no such books found");
            return null;
        }
        if (matchedIndices.size() == 1) {
            System.out.println("Only one match, auto-selected.");
            return books.get(matchedIndices.get(0));
        }
        int choice =readInt("please log in the number of the book");
        if (choice < 1 || choice > matchedIndices.size()) {
            System.out.println("Invalid choice");
            return null;
        }

        return books.get(matchedIndices.get(choice - 1));
    }
    private double readDouble(String prompt) {
        System.out.println(prompt);
        while (!sc.hasNextDouble()) {
            System.out.println("Please input proper number (double):");
            sc.next(); // 丢弃错误输入
        }
        double value = sc.nextDouble();
        sc.nextLine(); // 清掉换行符，保证下一次 readLine 可用
        return value;
    }
    private int readInt(String prompt) {
        System.out.println(prompt);
        while (!sc.hasNextInt()) {
            System.out.println("Please input proper number:");
            sc.next(); // 丢弃错误输入
        }
        int value = sc.nextInt();
        sc.nextLine(); // 清掉换行符
        return value;
    }
    public synchronized void saveAllBooksToXML() {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            // 1. 创建一个新的空文档
            Document document = builder.newDocument();
            // 2. 创建根节点 <books>
            Element root = document.createElement("books");
            document.appendChild(root);
            // 3. 遍历内存中的列表，将每本书转换为 XML 节点
            for (Books b : books) {
                Element book = document.createElement("book");
                Element name = document.createElement("bookname");
                name.setTextContent(b.getBookName());
                Element author = document.createElement("bookauthor");
                author.setTextContent(b.getBookAuthor());
                Element price = document.createElement("price");
                price.setTextContent(String.valueOf(b.getPrice()));
                Element count = document.createElement("count");
                count.setTextContent(String.valueOf(b.getCount()));
                book.appendChild(name);
                book.appendChild(author);
                book.appendChild(price);
                book.appendChild(count);
                root.appendChild(book);
            }
            // 4. 将构建好的 DOM树 写入硬盘（覆盖原文件）
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes"); // 开启缩进，方便阅读
            DOMSource source = new DOMSource(document);
            StreamResult result = new StreamResult((new File(XML_FILE_PATH)));
            transformer.transform(source, result);
            logInfo("successfully store " + books.size() + " books to xmlFile");
            // System.out.println("数据已自动保存。"); // 可选：调试时打开
        } catch (Exception e) {
            String errorMsg = "fail store: " + e.getMessage();
            System.out.println(errorMsg);
            logError(errorMsg);
            e.printStackTrace();
        }
    }
    private String getSafeElementTextContent(Element element, String tagName) {
        NodeList nodeList = element.getElementsByTagName(tagName);
        if (nodeList.getLength() > 0 && nodeList.item(0) != null) {
            Node node = nodeList.item(0);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                return node.getTextContent();
            }
        }
        return ""; // 返回默认值
    }
    public void loadBooksFromXML() {
        try {
            File file = new File(XML_FILE_PATH);
            if (!file.exists()) {
                logWarning("XML file doesn't exist");
                return; // 如果文件不存在，直接返回，不做加载
            }
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(file);
            document.getDocumentElement().normalize();
            NodeList nodeList = document.getElementsByTagName("book");
            // 清空现有列表，防止重复加载
            books.clear();
            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    Books book = new Books();
                    // 注意：这里的标签名必须和你 addNode 方法里写入的标签名完全一致
                    String name = getSafeElementTextContent(element, "bookname");
                    String author = getSafeElementTextContent(element, "bookauthor");
                    String priceStr = getSafeElementTextContent(element, "price");
                    String countStr = getSafeElementTextContent(element, "count");
                    book.setBookName(name);
                    book.setBookAuthor(author);
                    // 解析数字，增加简单的防错处理
                    try {
                        book.setPrice(priceStr.isEmpty() ? 0.0 : Double.parseDouble(priceStr));
                    } catch (NumberFormatException e) {
                        logWarning("Invalid price format, using default 0.0: " + priceStr);
                        book.setPrice(0.0);
                    }
                    try {
                        book.setCount(countStr.isEmpty() ? 0 : Integer.parseInt(countStr));
                    } catch (NumberFormatException e) {
                        logWarning("Invalid count format, using default 0: " + countStr);
                        book.setCount(0);
                    }
                    books.add(book);
                }
            }
            System.out.println("successfully scan " + books.size() + " books");
            logInfo("successfully scan " + books.size() + " books");
        } catch (Exception e) {
            String errorMsg = "something goes wrong when scanning: " + e.getMessage();
            System.out.println(errorMsg);
            logError(errorMsg);
            e.printStackTrace();
        }
    }
    public void addBook(){
        logInfo("begin adding books");
        System.out.println("welcome to the adding system");
        int num=readInt("please tell how many books you want to add");
        if(num<=0){
            System.out.println("are u joking?");
            logWarning("users input invalid book number: " + num);
        }else{
            for(int i=1;i<=num;i++){
                Books book=new Books();
                System.out.println("This is the "+i+" book");
                System.out.println("please input the book name");
                String bookName=sc.nextLine();
                if (bookName == null || bookName.trim().isEmpty()) {
                    System.out.println("Invalid book name");
                    logWarning("invalid book name");
                    continue; // 或者返回错误
                }
                book.setBookName(bookName);
                System.out.println("please input the book author");
                String bookAuthor=sc.nextLine();
                if (bookAuthor == null || bookAuthor.trim().isEmpty()) {
                    System.out.println("Invalid book author");
                    logWarning("invalid book author");
                    continue; // 或者返回错误
                }
                book.setBookAuthor(bookAuthor);
                double bookPrice=readDouble("please input the book price");
                if(bookPrice<0){
                    System.out.println("Invalid book price");
                    bookPrice = readDouble("please input valid bookPrice");
                }else{
                    book.setPrice(bookPrice);
                }
                int bookQuantity=readInt("please input the book quantity");
                while(bookQuantity < 0) {
                    System.out.println("Invalid book price, must be non-negative");
                    bookQuantity = readInt("please input valid bookQuantity");
                }
                book.setCount(bookQuantity);
                System.out.println("book No."+i+"successfully added");
                books.add(book);
            }
            saveAllBooksToXML();
            System.out.println("All books saved to file.");
            logInfo("successfully add " + num + " books to the system");
        }
        logInfo("end adding books");
    }
    private static final String ADMIN_ID = "Admin";
    private static final String ADMIN_PASSWORD = "Admin";
    public void checkInformation(){
        logInfo("adminer try log in");
        String ID=ADMIN_ID;
        String password=ADMIN_PASSWORD;
        int attempt=5;
        System.out.println("please log in the admin password and ID");
        while(attempt>0){
            System.out.println("please input the ID");
            String IDinput=sc.nextLine();
            System.out.println("please input the password");
            String passwordinput=sc.nextLine();
            if(ID.equals(IDinput)&&password.equals(passwordinput)){
                System.out.println("succesfully login");
                logInfo("admin successfully log in");
                for(int i=0;i< books.size();i++){
                    System.out.println(books.get(i).getBookName()+"  with "+books.get(i).getCount()+"  left");
                }
                break;
            }else{
                System.out.println("wrong password or ID,you only have"+attempt+"times left");
                logWarning("admin account log in fails: " + attempt);
                attempt--;
            }
        }
        logInfo("admin log in end");
    }
    public synchronized void borrowBook(){
        logInfo("user begins borrow");
        System.out.println("please log in the name of the book");
        String borrowName=sc.nextLine();
        Books bookborrow = searchAndSelectBook(borrowName);
        if(bookborrow!=null){
            int borrowNum=readInt("please input the number of books u want");
            if(borrowNum<=bookborrow.getCount()&&borrowNum>0){
                bookborrow.setCount(bookborrow.getCount()-borrowNum);
                System.out.println("successfully borrow " + borrowNum  + bookborrow.getBookName());
                logInfo("user successfully borrow: " + bookborrow.getBookName() + ", num: " + borrowNum);
                saveAllBooksToXML();
            }
            else if(borrowNum>bookborrow.getCount()){
                System.out.println("sorry,we only have "+bookborrow.getCount()+" books left");
                logWarning("users try to borrow too many books: " + bookborrow.getBookName() + ", num is: " + borrowNum);
            }
            else{
                System.out.println("are u joking?");
                return;
            }
        }
    }
    public void returnBook(){
        logInfo("user begins return");
        System.out.println("please log in the name of the book");
        String borrowName=sc.nextLine();
        Books bookReturn = searchAndSelectBook(borrowName);
        if(bookReturn!=null){
            int returnNum=readInt("please input the number of books u want return");
            if(returnNum>0){
                bookReturn.setCount(bookReturn.getCount()+returnNum);
                System.out.println("successfully return " + returnNum  + bookReturn.getBookName());
                logInfo("user successfully return: " + bookReturn.getBookName() + ", num: " + returnNum);
                saveAllBooksToXML();
            }else{
                System.out.println("are u joking?");
                logWarning("book return fails: " + bookReturn.getBookName() + ", num is: " + returnNum);
            }
        }
    }
    public void run(){
        logInfo("Books operating system launch");
        System.out.println("======================");
        System.out.println("welcome to the library");
        System.out.println("======================");
        System.out.println("please input the operating number");
        System.out.println("1 for add book");
        System.out.println("2 for borrow");
        System.out.println("3 for return");
        System.out.println("4 for check info(admin only)");
        System.out.println("5 for exit");
        boolean flag=true;
        while(flag==true) {
            int number = readInt("please input the operating number");
            if(number==1){
                addBook();
            }else if(number==2){
                borrowBook();
            }else if(number==3){
                returnBook();
            }else if(number==4){
                checkInformation();
            }else if(number==5){
                flag=false;
                logInfo("exit the system");
            }else{
                System.out.println("Invalid input");
                logWarning("user input invalid operating num: " + number);
            }
        }
    }
    public static void main(String[] args) {
        logInfo("program launch");
        try (Scanner scanner = new Scanner(System.in)) {
            NewBookOperatingSystem bos = new NewBookOperatingSystem(scanner);
            bos.loadBooksFromXML();
            bos.run();
        }
        logInfo("program end");
    }
    // 需要修改构造函数
    public NewBookOperatingSystem(Scanner scanner) {
        this.sc = scanner;
        this.books = new ArrayList<>();
    }
}
