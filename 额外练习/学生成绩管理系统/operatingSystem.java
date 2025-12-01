package 额外练习.学生成绩管理系统;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class operatingSystem {
    //建立学生信息的Arraylist
    ArrayList<studentInfo>students=new ArrayList<>();
    Scanner sc=new Scanner(System.in);

    public void addStudent(){
        System.out.println("log in a new student");
        try{
        studentInfo student1=new studentInfo();
        System.out.print("please log in student name:");
        String name=sc.nextLine();
        System.out.println();
        student1.setName(name);
        System.out.print("please log in student age:");
        while (!sc.hasNextInt()) {
                System.out.println("Invalid age, please enter an integer!");
                sc.next();  // 清空错误输入
        }
        int age=sc.nextInt();
        System.out.println();
        student1.setAge(age);
        System.out.print("please log in student score:");

        while (!sc.hasNextDouble()) {
                System.out.println("Invalid score, please enter a number!");
                sc.next();  // 清空错误输入
        }
        double score=sc.nextDouble();
        System.out.println();
        student1.setScore(score);
        students.add(student1);
        addNode(student1);
        addNode1(student1);
        }catch(Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
    public void listStudents(){
        int index=0;
        for(studentInfo student:students){
            System.out.println("ID"+"\t\t"+"age"+"\t\t"+"name"+"\t\t"+"score");
            System.out.println(index+"\t\t"+student.getAge()+"\t\t"+student.getName()+"\t\t"+student.getScore());
            index++;
        }
    }
    public void searchStudent(int num) {
        switch (num) {
            case 1:
                System.out.println("Please input part of the student's name:");

                String keyword = sc.nextLine().trim().toLowerCase();
                boolean found = false;
                for (int i = 0; i < students.size(); i++) {
                    studentInfo s = students.get(i);
                    if (s.getName().toLowerCase().contains(keyword)) {
                        found = true;
                        System.out.println(i + "\t" + s.getName() + "\t" + s.getAge() + "\t" + s.getScore());
                    }
                }
                if (!found) {
                    System.out.println("No student matched your search.");
                }
                break;
            case 2:
                System.out.println("Please input ID of student");
                while(!sc.hasNextInt()) {
                    System.out.println("Invalid ID!");
                    sc.next();
                }
                try{
                int id=sc.nextInt();
                System.out.println(students.get(id).getName()+"\t"+students.get(id).getAge()+"\t"+students.get(id).getScore());
                }catch(ArrayIndexOutOfBoundsException e){
                    e.printStackTrace();
                    System.out.println("Invalid ID!");
                }
            case 3:
                System.out.println("thank you for using the search system");
                break;
                default:
                    System.out.println("Invalid input!");
        }

    }
    public void deleteStudent() {
        System.out.println("please input the student id that you want to delete:");
        while (!sc.hasNextInt()) {
            System.out.println("Invalid ID number, please enter an integer!");
            sc.next();  // 清空错误输入
        }
        int id=sc.nextInt();
        //这里可以用||，没必要用else if
        //删除学生的id用的是数组下标，从0开始，可能不便于阅读
        if(id>students.size()-1){
            System.out.println("too big id,please check again!");
        }else if(id<0){
            System.out.println("too small id,please check again!");
        }else{
            System.out.println(students.get(id).getName()+" information has been deleted!");
            students.remove(id);
        }
    }
    public void showStats(){
        int total=0;
        if (students.isEmpty()) {
            System.out.println("No students found.");
            return;
        }
        for(studentInfo student:students){
            total+=student.getScore();
        }
        double avg = (double) total / students.size();
        //这里可以不用构建新数组，而是采用double[] scores = students.stream().mapToDouble(studentInfo::getScore).toArray();方式
        //自动化程度高
        double[]scores=new double[students.size()];
        for(int i=0;i<scores.length;i++){
            scores[i]=students.get(i).getScore();
        }
        //这里可以不用冒泡排序，直接用内置函数sort
        for(int j=0;j<scores.length-1;j++){
            for(int i=0;i<scores.length-1-j;i++){
                if(scores[i]>scores[i+1]){
                    double temp=scores[i+1];
                    scores[i+1]=scores[i];
                    scores[i]=temp;
                }
            }
        }
        System.out.println("Total student number is:"+students.size());
        System.out.println("Total score is:"+total);
        System.out.println("Average student score is:"+avg);
        System.out.println("the maximum score is:"+scores[scores.length-1]);
        System.out.println("the minimum score is:"+scores[0]);
    }
    public void updateStudent() {
        System.out.println("please enter the student id you want to update:");
        while (!sc.hasNextInt()) {
            System.out.println("Invalid ID number, please enter an integer!");
        }
        int id = sc.nextInt();
        sc.nextLine();
        if(id>students.size()-1){
            System.out.println("too big id,please check again!");
        }else{
            System.out.println("what do u want to update?");
            System.out.println("1 represent name");
            System.out.println("2 represent age");
            System.out.println("3 represent score");
            int num = sc.nextInt();
            sc.nextLine();
            if (num != 1 && num != 2 && num != 3) {
                System.out.println("Invalid input!");
                sc.next();
            } else {
                switch(num){
                    case 1:
                        System.out.println("please enter the new student name:");
                        String name=sc.nextLine().trim();
                        sc.nextLine();
                        students.get(id).setName(name);
                        break;
                        case 2:
                            System.out.println("please enter the new student age:");
                            int age=sc.nextInt();
                            sc.nextLine();
                            students.get(id).setAge(age);
                            break;
                            case 3:
                                System.out.println("please enter the new student score:");
                                double score=sc.nextDouble();
                                sc.nextLine();
                                students.get(id).setScore(score);
                                break;
                }
            }
        }

    }
    private static void addNode(studentInfo student1){
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder=null;
        try {
            builder = factory.newDocumentBuilder();
            Document document=builder.parse("src/额外练习/学生成绩管理系统/student.xml");
            Element student = document.createElement("student");
            Element name = document.createElement("name");
            name.setTextContent(student1.getName());
            Element score = document.createElement("score");
            score.setTextContent(student1.getScore()+"");
            Element age = document.createElement("age");
            age.setTextContent(student1.getAge()+"");
            student.appendChild(name);
            student.appendChild(score);
            student.appendChild(age);
            //book绑定到文档上
            document.getElementsByTagName("student").item(0).appendChild(student);
            //落地到硬盘文件上
            TransformerFactory factory1 = TransformerFactory.newInstance();
            Transformer transformer = factory1.newTransformer();
            //构建source and result
            Source source = new DOMSource(document);
            Result result = new StreamResult("src/额外练习/学生成绩管理系统/student.xml");
            transformer.transform(source,result);
            System.out.println("添加成功");
            //下面的抛出异常懒得改了。
        } catch (ParserConfigurationException e) {
            throw new RuntimeException(e);
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
    private static void addNode1(studentInfo student1){
        try {
            File file = new File("src/额外练习/学生成绩管理系统/student.xml");
            Document document;
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            // 1. 判断文件是否存在
            if (!file.exists()) {
                // 新建 XML 文档
                document = builder.newDocument();
                Element root = document.createElement("students");
                document.appendChild(root);
            } else {
                // 读取已有 XML
                document = builder.parse(file);
            }

            // 2. 创建 <student> 节点
            Element student = document.createElement("student");

            Element name = document.createElement("name");
            name.setTextContent(student1.getName());

            Element score = document.createElement("score");
            score.setTextContent(String.valueOf(student1.getScore()));

            Element age = document.createElement("age");
            age.setTextContent(String.valueOf(student1.getAge()));

            student.appendChild(name);
            student.appendChild(score);
            student.appendChild(age);

            // 3. 获得根节点 <students>
            Element root = document.getDocumentElement();
            root.appendChild(student);

            // 4. 写回文件
            TransformerFactory tfFactory = TransformerFactory.newInstance();
            Transformer transformer = tfFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");

            transformer.transform(
                    new DOMSource(document),
                    new StreamResult(file)
            );

            System.out.println("添加成功!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
