package hello12.T5;

public class T05 {
    public static void main(String[] args) {
        Grandpa grandpa = new Grandpa();
        String[] types={"cat","pig","dog"};
        for(String type:types){
            Animal animal= grandpa.chuiAnimal(type);
            animal.getShape();
        }
    }
}
