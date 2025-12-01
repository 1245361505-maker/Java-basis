package hello09;

public class MOVIEintro {
    String name;
    String director;
    String[] actors;
    public void initActors(String[]acts){
        actors=acts;

    }
    public void show(){
        System.out.println("电影名称为："+name);
        System.out.println("电影导演为："+director);
        System.out.println("电影的演员为：");
        for(int i=0;i<actors.length;i++){
            System.out.println(actors[i]);
        }
        ;
    }
}
