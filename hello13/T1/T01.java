package JavaBasis.hello13.T1;

public class T01 {
    public static void main(String[] args){
        Dance[]dances=new Dance[]{new Dancer(),new Danceteacher()};
        for(Dance dance:dances){
            dance.dance();
        }
    }
}
