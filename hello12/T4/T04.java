package hello12.T4;

public class T04 {
    public static void main(String[] args) {
        Chinese chinese=new Chinese();
        American american=new American();
        Korean korean=new Korean();
        //对象数组
        Person[] persons=new Person[3];
        persons[0]=chinese;
        persons[1]=american;
        persons[2]=korean;
        for(Person p:persons){
            p.sayHello();
        }
    }
}
