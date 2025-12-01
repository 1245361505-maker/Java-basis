package hello12.T5;

public class Grandpa {
    public Animal chuiAnimal(String type){
        Animal animal;
        if(type.equals("dog")){
            animal = new Dog();
        }else if(type.equals("cat")){
            animal = new Cat();
        }else{
            animal=new Pig();
        }
        return animal;
    }
}
