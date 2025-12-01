package hello12.T3;

public class Master {
    public void feed(Pet pet, int num){
        pet.eat(num);
    }
    public void work(Pet pet){
        //区分动物类型
        if(pet instanceof Cat){
            Cat cat = (Cat)pet;
            cat.catchMice();
        }else if(pet instanceof Dog){
            Dog dog = (Dog)pet;
            dog.seeDoor();
        }
    }
}
