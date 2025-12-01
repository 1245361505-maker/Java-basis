package hello08;

import java.util.Scanner;

public class 用户登录 {
    public static void main(String[] args) {
        Userinfo[] users=new Userinfo[50];
        Userinfo info=new Userinfo();
        info.username="微冷的雨";
        info.password="666666";
        users[0]=info;
        Scanner input=new Scanner(System.in);
        System.out.println("请输入用户名");
        String uname=input.next();
        System.out.println("请输入密码");
        String psw=input.next();
        boolean flag=false;
        for(int i=0;i<users.length;i++){
            if(users[i]!=null&&users[i].username.equals(uname)&&users[i].password.equals(psw)){
                flag=true;
                break;
            }
        }
        if(flag==false){
            System.out.println("登录失败");
        }else{
            System.out.println("登陆成功");
        }
    }
}
