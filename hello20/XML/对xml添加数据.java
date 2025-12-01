package hello20.XML;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.IOException;

public class 对xml添加数据 {
    public static void main(String[] args) {
        //添加book节点
        addNode();
        readxml();
    }
    private static void addNode() {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder=null;
        try {
            builder = factory.newDocumentBuilder();
            Document document=builder.parse("src/hello20/XML基础/books.xml");
            //构建一个节点
            Element book = document.createElement("book");
            book.setAttribute("id", "b03");
            Element name = document.createElement("name");
            name.setTextContent("我的阿勒泰");
            Element price = document.createElement("price");
            price.setTextContent("70");
            Element author = document.createElement("author");
            author.setTextContent("Java");
            //将游离的节点绑定到book上
            book.appendChild(name);
            book.appendChild(price);
            book.appendChild(author);
            //book绑定到文档上
            document.getElementsByTagName("books").item(0).appendChild(book);
            //落地到硬盘文件上
            TransformerFactory factory1 = TransformerFactory.newInstance();
            Transformer transformer = factory1.newTransformer();
            //构建source and result
            Source source = new DOMSource(document);
            Result result = new StreamResult("src/hello20/XML基础/books.xml");
            transformer.transform(source,result);
            System.out.println("添加成功");
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (SAXException e) {
            throw new RuntimeException(e);
        } catch (TransformerConfigurationException e) {
            throw new RuntimeException(e);
        } catch (TransformerException e) {
            throw new RuntimeException(e);
        }
    }
    private static void readxml(){
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
