package hello08;

public class MOVIE {
    String moviename;
    String director;
    String [] actors=new String[10] ;
    public void initdate(){
        actors[0]="a";
        actors[1]="b";
        actors[2]="c";
        actors[3]="d";
        actors[4]="e";
    }
    public void show(){
        System.out.println("电影名字为"+moviename);
        System.out.println("电影导演为"+director);
        System.out.println("电影参演人员有");
        for(int i=0;i<actors.length;i++){
            if(actors[i]!=null) {
                System.out.println(actors[i]);
            }
        }
    }
}
