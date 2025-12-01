package hello10.T01;

public class Dog {
    //public private
    private String name;
    private int age;
    //
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public void setAge(int age) {
        if (age < 0) {
            age = 0;
        }else{
            this.age = age;
        }
    }
    public int getAge() {
        return age;
    }
}
