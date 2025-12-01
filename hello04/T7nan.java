package JavaBasis.hello04;

public class T7nan {
    public static void main(String[] args) {
        int stu1=0,stu2=0,num=0,total=0;//相同和总
        do{
            stu1++;
            if(stu1>20){
                stu1=1;
            }
            stu2++;
            if(stu2>30){
                stu2=1;
            }
            if(stu1==stu2){
                num++;
            }
            total++;

        }while(total<=1000);
        System.out.println(num);
    }
}
