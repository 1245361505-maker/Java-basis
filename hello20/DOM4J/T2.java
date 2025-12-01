package hello20.DOM4J;

import org.dom4j.*;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import java.io.*;
import java.util.List;


public class T2 {
    public static void main(String[] args) {
        //readXml();
        //addNode();
        updateNode();
        //deleteNode();
    }
    private static void readXml() {
        //构建读取器对象
        SAXReader reader = new SAXReader();
        try {
            Document document=reader.read("src/hello20/XML/books.xml");
            //获取根节点
            Element root=document.getRootElement();
            //通过根节点获取子节点
            List<Element> list=root.elements();
            for(Element book:list){
                //获取属性值
                String id = book.attributeValue("id");
                //name
                Element bookname=(Element)book.elements().get(0);
                String name = bookname.getText();
                //author
                Element authorname=(Element)book.elements().get(1);
                String author = authorname.getText();
                //price
                Element bookprice=(Element)book.elements().get(2);
                String price = bookprice.getText();
                System.out.println(id+","+name+","+author+","+price);
            }
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }
    private static void addNode() {
        try {
            // 1️⃣ 读取 XML
            File xmlFile = new File("src/hello20/XML/books.xml");
            if (!xmlFile.exists()) {
                System.err.println("❌ XML 文件不存在：" + xmlFile.getAbsolutePath());
                return;
            }

            SAXReader reader = new SAXReader();
            Document document = reader.read(xmlFile);
            Element root = document.getRootElement();

            // 2️⃣ 构建新节点
            Element book = root.addElement("book");
            book.addAttribute("id", "b04");
            book.addElement("name").setText("你是人间四月天");
            book.addElement("author").setText("林徽因");
            book.addElement("price").setText("90");

            // 3️⃣ 格式化输出，安全写回文件
            OutputFormat format = OutputFormat.createPrettyPrint(); // 美观缩进
            format.setEncoding("UTF-8"); // 指定编码
            format.setIndent(true);
            format.setNewlines(true);

            try (Writer writer = new OutputStreamWriter(new FileOutputStream(xmlFile, false), "UTF-8")) {
                XMLWriter xmlWriter = new XMLWriter(writer, format);
                xmlWriter.write(document);
                xmlWriter.flush();
                xmlWriter.close();
            }

            System.out.println("✅ 节点添加成功，文件已更新！");
        } catch (Exception e) {
            System.err.println("❌ 添加节点时出错：");
            e.printStackTrace();
        }
    }
    private static void updateNode() {
        SAXReader reader = new SAXReader();
        try {
            Document document= reader.read("src/hello20/XML/books.xml");
            Element root=document.getRootElement();
            List<Element> list=root.elements();
            Element book = list.get(2);
            Element name=book.element("name");
            name.setText("昨日世界");
            OutputFormat format = OutputFormat.createPrettyPrint();
            format.setEncoding("UTF-8");
            try (Writer writer = new OutputStreamWriter(new FileOutputStream("src/hello20/XML/books.xml", false), "UTF-8")) {
                XMLWriter xmlWriter = new XMLWriter(writer, format);
                xmlWriter.write(document);
                xmlWriter.flush();
                xmlWriter.close();
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            } catch (UnsupportedEncodingException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            System.out.println("✅ 修改成功，第4本书名称已更新");
        } catch (DocumentException e) {
            throw new RuntimeException(e);
        }
    }
}
