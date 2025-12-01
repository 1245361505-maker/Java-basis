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
import static 额外练习.图书管理系统.LoggerUtil.logInfo;

public class BookOperatingSystem {
    ArrayList<Books> books=new ArrayList<>();
    Scanner sc=new Scanner(System.in);
    private static final String XML_FILE_PATH = "src/额外练习/图书管理系统/books.xml";
    public void saveAllBooksToXML() {
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
            StreamResult result = new StreamResult(new File("src/额外练习/图书管理系统/books.xml"));
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
    public void loadBooksFromXML() {
        /**
         * 从指定的 XML 文件中加载图书数据到内存列表中。
         *
         * 该方法会读取项目路径下的 books.xml 文件，并解析其中的图书信息，
         * 将其转换为 Books 对象并添加到 books 列表中。如果文件不存在，则记录警告日志并返回。
         * 加载前会清空当前 books 列表以避免重复加载。
         *
         * 注意：XML 中的标签名需与保存时使用的标签保持一致（如 bookname、bookauthor 等）。
         *
         * 异常处理包括对文件解析错误和数值转换异常的捕获，并输出相应日志及控制台提示。
         */
        try {
            File file = new File(XML_FILE_PATH);
            if (!file.exists()) {
                logWarning("XML doesn't exist");
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
                    String name = element.getElementsByTagName("bookname").item(0).getTextContent();
                    String author = element.getElementsByTagName("bookauthor").item(0).getTextContent();
                    String priceStr = element.getElementsByTagName("price").item(0).getTextContent();
                    String countStr = element.getElementsByTagName("count").item(0).getTextContent();

                    book.setBookName(name);
                    book.setBookAuthor(author);
                    // 解析数字，增加简单的防错处理
                    book.setPrice(priceStr.isEmpty() ? 0.0 : Double.parseDouble(priceStr));
                    book.setCount(countStr.isEmpty() ? 0 : Integer.parseInt(countStr));

                    books.add(book);
                }
            }
            System.out.println("成功从文件加载了 " + books.size() + " 本书。");
            logInfo("成功从 XML 文件加载了 " + books.size() + " 本书");
        } catch (Exception e) {
            String errorMsg = "加载 XML 数据时出错: " + e.getMessage();
            System.out.println(errorMsg);
            logError(errorMsg);
            e.printStackTrace();
        }
    }
    public void addBook(){
        logInfo("开始添加图书操作");
        System.out.println("welcome to the adding system");
        System.out.println("please tell how many books you want to add");
        while(!sc.hasNextInt()){
            System.out.println("please enter a number");
            sc.next();
        }
        int num=sc.nextInt();
        sc.nextLine();
        if(num<=0){
            System.out.println("are u joking?");
            logWarning("用户输入了无效的图书数量: " + num);
        }else{
            for(int i=1;i<=num;i++){
                Books book=new Books();
                System.out.println("This is the "+i+" book");
                System.out.println("please input the book name");
                String bookName=sc.nextLine();
                book.setBookName(bookName);
                System.out.println("please input the book author");
                String bookAuthor=sc.nextLine();
                book.setBookAuthor(bookAuthor);
                System.out.println("please input the book price");
                while(!sc.hasNextDouble()){
                    System.out.println("please input a number");
                    sc.next();
                }
                double bookPrice=sc.nextDouble();
                sc.nextLine();
                book.setPrice(bookPrice);
                System.out.println("please input the book quantity");
                while(!sc.hasNextInt()){
                    System.out.println("please input an integer");
                    sc.next();
                }
                int bookQuantity=sc.nextInt();
                book.setCount(bookQuantity);
                System.out.println("book No."+i+"successfully added");
                books.add(book);
                //addNode(book);
            }
            saveAllBooksToXML();
            System.out.println("All books saved to file.");
            logInfo("成功添加 " + num + " 本书到系统");
        }

    }
    /*public void addNode(Books book){
        try{
            File file=new File("src/额外练习/图书管理系统/books.xml");
            Document document;
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            // 1. 判断文件是否存在
            if (!file.exists()) {
                // 新建 XML 文档
                document = builder.newDocument();
                Element root = document.createElement("books");
                document.appendChild(root);
            } else {
                // 读取已有 XML
                document = builder.parse(file);
            }
            Element newbook = document.createElement("book");

            Element name = document.createElement("bookname");
            name.setTextContent(book.getBookName());

            Element author = document.createElement("bookauthor");
            author.setTextContent(book.getBookAuthor());

            Element price = document.createElement("price");
            price.setTextContent(String.valueOf(book.getPrice()));
            Element quantity = document.createElement("count");
            quantity.setTextContent(String.valueOf(book.getCount()));

            newbook.appendChild(name);
            newbook.appendChild(author);
            newbook.appendChild(price);
            newbook.appendChild(quantity);

            // 3. 获得根节点 <books>
            Element root = document.getDocumentElement();
            root.appendChild(newbook);

            // 4. 写回文件
            TransformerFactory tfFactory = TransformerFactory.newInstance();
            Transformer transformer = tfFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");

            transformer.transform(
                    new DOMSource(document),
                    new StreamResult(file)
            );

            System.out.println("添加成功!");
        }catch(Exception e){
            e.printStackTrace();
        }
    }*/
    public void checkInformation(){
        logInfo("管理员登录尝试");
        String ID="Admin";
        String password="Admin";
        int attempt=5;
        System.out.println("please log in the admin password and ID");
        while(attempt>=0){
            System.out.println("please input the ID");
            String IDinput=sc.nextLine();
            System.out.println("please input the password");
            String passwordinput=sc.nextLine();
            if(ID.equals(IDinput)&&password.equals(passwordinput)){
                System.out.println("succesfully login");
                logInfo("管理员登录成功");
                for(int i=0;i< books.size();i++){
                    System.out.println(books.get(i).getBookName()+"  with "+books.get(i).getCount()+"  left");
                }
                break;
            }else{
                System.out.println("wrong password or ID,you only have"+attempt+"times left");
                logWarning("管理员登录失败，剩余尝试次数: " + attempt);
                attempt--;
            }
        }
    }
    public void borrow(){
        logInfo("用户尝试借书");
        System.out.println("请输入想要借阅的书籍名称:");
        String borrow = sc.nextLine().trim().toLowerCase();
        // 使用ArrayList存储匹配项更安全
        ArrayList<Integer> matchedIndices = new ArrayList<>();
        System.out.println("找到以下匹配的书籍:");
        int displayNumber = 1;
        for(int i = 0; i < books.size(); i++){
            if(books.get(i).getBookName().toLowerCase().contains(borrow)) {
                System.out.println(displayNumber + ". " + books.get(i).getBookName() +
                        " (库存: " + books.get(i).getCount() + ")");
                matchedIndices.add(i);
                displayNumber++;
            }
        }
        // 如果没有匹配项，直接返回
        if(matchedIndices.isEmpty()) {
            System.out.println("未找到相关书籍");
            logInfo("未找到匹配书籍: " + borrow);
            return;
        }
        System.out.println("请选择要借阅的书籍编号:");
        while(!sc.hasNextInt()){
            System.out.println("请输入有效数字:");
            sc.next();
        }
        int choice = sc.nextInt();
        sc.nextLine(); // 消费换行符
        // 验证用户选择
        if(choice < 1 || choice > matchedIndices.size()){
            System.out.println("无效的选择");
            logInfo("无效的书籍选择: " + choice);
            return;
        }
        // 获取选中的书籍索引
        int bookIndex = matchedIndices.get(choice - 1);
        Books selectedBook = books.get(bookIndex);
        System.out.println("请输入要借阅的数量:");
        while(!sc.hasNextInt()){
            System.out.println("请输入有效整数:");
            sc.next();
        }
        int borrowCount = sc.nextInt();
        sc.nextLine();
        if(borrowCount <= 0) {
            System.out.println("借阅数量必须大于0");
            return;
        }
        // 处理借书逻辑
        if(selectedBook.getCount() >= borrowCount) {
            selectedBook.setCount(selectedBook.getCount() - borrowCount);
            System.out.println("成功借阅 " + borrowCount + " 本《" + selectedBook.getBookName() + "》");
            logInfo("成功借出图书: " + selectedBook.getBookName() + ", 数量: " + borrowCount);
            saveAllBooksToXML();
        } else {
            System.out.println("库存不足，当前仅有 " + selectedBook.getCount() + " 本");
            logWarning("图书库存不足，请求: " + borrowCount + ", 库存: " + selectedBook.getCount());
        }
    }

    public void returnbook(){
        logInfo("用户尝试还书");
        System.out.println("please in which book you will return");
        String returnbook=sc.nextLine().trim().toLowerCase();
        ArrayList<Integer> matchedIndices = new ArrayList<>();
        int displayNumber = 1;
        System.out.println("找到以下匹配的书籍:");
        for(int i=0;i<books.size();i++){
            if(books.get(i).getBookName().toLowerCase().contains(returnbook)){
                System.out.println(displayNumber+books.get(i).getBookName());
                matchedIndices.add(i);
                displayNumber++;
            }
        }
        if(matchedIndices.isEmpty()) {
            System.out.println("未找到相关书籍");
            logInfo("未找到匹配书籍: " + returnbook);
            return;
        }
        System.out.println("请选择要归还的书籍编号:");
        while(!sc.hasNextInt()){
            System.out.println("请输入有效数字:");
            sc.next();
        }
        int choice = sc.nextInt();
        sc.nextLine(); // 消费换行符
        // 验证用户选择
        if(choice < 1 || choice > matchedIndices.size()){
            System.out.println("无效的选择");
            logInfo("无效的书籍选择: " + choice);
            return;
        }
        // 获取选中的书籍索引
        int bookIndex = matchedIndices.get(choice - 1);
        Books selectedBook = books.get(bookIndex);
        System.out.println("请输入要归还的数量:");
        while(!sc.hasNextInt()){
            System.out.println("请输入有效整数:");
            sc.next();
        }
        int returnCount = sc.nextInt();
        sc.nextLine();
        if(returnCount <= 0) {
            System.out.println("归还数量必须大于0");
            return;
        }
        // 处理还书逻辑
        selectedBook.setCount(selectedBook.getCount() + returnCount);
        System.out.println("成功归还 " + returnCount + " 本《" + selectedBook.getBookName() + "》");
        logInfo("成功归还图书: " + selectedBook.getBookName() + ", 数量: " + returnCount);
        saveAllBooksToXML();
    }
    /*String answer=sc.nextLine().trim().toLowerCase();
                if(answer.equals("yes")||answer.equals("y")){
                    System.out.println("how many books do you will return?");
                    while(!sc.hasNextInt()){
                        System.out.println("please input an integer");
                        sc.next();
                    }
                    int returnbooknumber=sc.nextInt();
                    sc.nextLine();
                    int count=books.get(i).getCount();
                    books.get(i).setCount(count+returnbooknumber);
                    System.out.println("successfully return");
                    logInfo("成功归还图书: " + books.get(i).getBookName() + ", 数量: " + returnbooknumber);
                    //updateXML();
                    saveAllBooksToXML();
                }*/
    /*logInfo("用户尝试借书");
        System.out.println("please in which book you want");
        String borrow=sc.nextLine().trim().toLowerCase();
        int j=1;
        int[]booksNum=new int[books.size()];
        for(int i=0;i<books.size();i++){
            if(books.get(i).getBookName().toLowerCase().contains(borrow)) {
                System.out.print(j + books.get(i).getBookName());
                booksNum[j-1]=i;
                j++;
                /*if(answer.equals("yes")||answer.equals("y")){
                    System.out.println("how many books do you want?");
                    while(!sc.hasNextInt()){
                        System.out.println("please input an integer");
                        sc.next();
                    }
                    int borrownumber=sc.nextInt();
                    sc.nextLine();
                    int count=books.get(i).getCount();
                    if(count>=borrownumber){
                        System.out.println("successfully borrow");
                        logInfo("成功借出图书: " + books.get(i).getBookName() + ", 数量: " + borrownumber);
                        books.get(i).setCount(count-borrownumber);
                        //updateXML();
                        saveAllBooksToXML();
                    }else{
                        System.out.println("not enough books,only "+count+" left");
                        logWarning("图书库存不足，请求: " + borrownumber + ", 库存: " + count);
                    }
                }
            }
        }
        System.out.println("what book do u want to borrow");
        while(!sc.hasNextInt()){
            System.out.println("please enter a number");
            sc.next();
        }
        int answer=sc.nextInt();
        if(answer>j||answer<1){
            System.out.println("Invalid input");
            logInfo("无效写入");
        }else{
            int count=books.get(booksNum[answer-1]).getCount();
            System.out.println("how many books do you want to borrow?");
            while(!sc.hasNextInt()){
                System.out.println("please input an integer");
                sc.next();
            }
            int borrownumber=sc.nextInt();
            if(count>=borrownumber){
                System.out.println("successfully borrow");
                logInfo("成功借出图书: " + books.get(booksNum[answer-1]).getBookName() + ", 数量: " + borrownumber);
                books.get(booksNum[answer-1]).setCount(count-borrownumber);
                //updateXML();
                saveAllBooksToXML();
            }else{
                System.out.println("not enough books,only "+count+" left");
                logWarning("图书库存不足，请求: " + borrownumber + ", 库存: " + count);
            }
        }
    }*/
    /*public void updateXML(){
        try {
            // 创建 DocumentBuilderFactory 实例，用于创建文档构建器工厂
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            // 通过工厂创建 DocumentBuilder 实例，用于解析 XML
            DocumentBuilder builder = factory.newDocumentBuilder();
            // 解析指定路径的 XML 文件，生成 Document 对象
            Document document = builder.parse("src/额外练习/图书管理系统/books.xml");

            // 规范化文档结构（合并相邻文本节点，删除空文本节点）
            document.getDocumentElement().normalize();

            // 获取文档中所有名为 "book" 的节点列表
            NodeList nodeList = document.getElementsByTagName("book");

            // 遍历 books 列表和 XML 中的 book 节点（取两者中较小的长度）
            for (int j = 0; j < books.size() && j < nodeList.getLength(); j++) {
                // 获取第 j 个 book 节点
                Node bookNode = nodeList.item(j);

                // 检查节点类型是否为元素节点（排除文本节点、注释节点等）
                if (bookNode.getNodeType() == Node.ELEMENT_NODE) {
                    // 将 Node 转换为 Element 类型，以便使用元素相关方法
                    Element bookElement = (Element) bookNode;

                    // 更新 <count> 节点的文本内容：
                    // 1. 获取 book 元素下所有名为 "count" 的子元素
                    // 2. 取第一个 count 元素（item(0)）
                    // 3. 将 books 列表中对应索引的 count 值转换为字符串并设置为文本内容
                    bookElement
                            .getElementsByTagName("count")
                            .item(0)
                            .setTextContent(String.valueOf(books.get(j).getCount()));
                }
            }

            // 创建 TransformerFactory 实例，用于创建 XML 转换器工厂
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            // 通过工厂创建 Transformer 实例，用于将 DOM 树转换输出
            Transformer transformer = transformerFactory.newTransformer();
            // 设置输出属性：启用缩进格式化，使输出的 XML 有良好的可读性
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");

            // 创建 DOMSource 对象，包装修改后的 Document 对象作为转换源
            DOMSource source = new DOMSource(document);
            // 创建 StreamResult 对象，指定输出到原始 XML 文件
            StreamResult result = new StreamResult(
                    new File("src/额外练习/图书管理系统/books.xml")
            );

            // 执行转换，将修改后的 DOM 树写回到 XML 文件
            transformer.transform(source, result);

            // 输出成功信息
            System.out.println("XML updated successfully.");

        } catch (Exception e) {
            // 捕获并打印任何异常信息
            e.printStackTrace();
        }
    }*/
    public void run(){
        logInfo("图书管理系统启动");
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
            while (!sc.hasNextInt()) {
                System.out.println("please input an integer");
                sc.next();
            }
            int number = sc.nextInt();
            sc.nextLine();
            if(number==1){
                addBook();
            }else if(number==2){
                borrow();
            }else if(number==3){
                returnbook();
            }else if(number==4){
                checkInformation();
            }else if(number==5){
                flag=false;
                logInfo("图书管理系统退出");
            }else{
                System.out.println("Invalid input");
                logWarning("用户输入了无效选项: " + number);
            }
        }

    }
    public static void main(String[] args) {
        logInfo("程序启动");
        BookOperatingSystem bos=new BookOperatingSystem();
        bos.loadBooksFromXML();
        bos.run();
        logInfo("程序结束");
    }
}
