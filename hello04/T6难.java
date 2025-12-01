package JavaBasis.hello04;

public class T6难 {
    public static void main(String[] args) {
        int teacher,stu1,stu2;
        teacher=stu1=stu2=1;
        int time=0,num=1;
        boolean flag=false;
        StringBuilder count = new StringBuilder();
        count.append("拍手的时刻：0");

        do{
            flag=false;
            time++;
            if(teacher<10){
                teacher=teacher+1;
                flag=true;
            }
            if(stu1<10 && time%2==0){
                stu1=stu1+1;
                flag=true;
            }
            if(stu2<10 && time%4==0){
                stu2=stu2+1;
                flag=true;
            }
            if(flag==true){
                num++;
                count.append(",").append(time);
            }

        }while(teacher+stu1+stu2<30);
        System.out.println("总共有多少次掌声："+num);
        System.out.println(count.toString());
    }
}
