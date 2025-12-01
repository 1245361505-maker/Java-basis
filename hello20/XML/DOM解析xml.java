package hello20.XML;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class DOM解析xml {
    public static void main(String[] args) {
        //创建文档解析器工厂,no new,use static ways:newInstance
        DocumentBuilderFactory dbf=DocumentBuilderFactory.newInstance();
        //文档解析器
        try {
            DocumentBuilder builder=dbf.newDocumentBuilder();
            //调用parse方法
            Document document=builder.parse("src/hello20/XML基础/books.xml");
            //获取所有book节点的集合
            NodeList list = document.getElementsByTagName("book");
            for(int i=0;i<list.getLength();i++){
                //每个book都是一本书
                Element book=(Element)list.item(i);
                //获取属性值
                String id=book.getAttribute("id");
                //获取名称
                String name=book.getElementsByTagName("name").item(0).getFirstChild().getNodeValue();
                String author=book.getElementsByTagName("author").item(0).getFirstChild().getNodeValue();
                String price=book.getElementsByTagName("price").item(0).getFirstChild().getNodeValue();
                System.out.println(id+","+name+","+author+","+price);
            }
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}
