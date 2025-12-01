package hello13.T4;

public class T04 {
    static void main() {
       // Goldfish goldfish=new Goldfish("金鱼");
       // goldfish.eat();
        //goldfish.swim();
        //goldfish.show();
       // System.out.println("==============");
       // Shark shark=new Shark("鲨鱼");
       // shark.show();
       // shark.swim();
       // shark.power();
       // shark.eat();
        Fish[]fishes={new Goldfish("金鱼"),new Shark("鲨鱼")};
        for(Fish fish:fishes){
            fish.eat();
            fish.swim();
            if(fish instanceof Shark){
                Shark shark=(Shark)fish;
                shark.power();
            }
            fish.show();
            System.out.println("================");
        }
    }
}
