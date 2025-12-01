package hello09;

public class CALC {
    public int calcData(int a,int b,char oper){
        int result=0;
        switch(oper){
            case '+':
                result=a+b;
                break;
            case '-':
                result=a-b;
                break;
            case '*':
                result=a*b;
                break;
            case '/':
                if(b!=0){
                    result=a/b;
                }else{
                    result=-1;
                }
                break;
            default:
                result=-2;
                break;
        }
        return result;
    }
}
