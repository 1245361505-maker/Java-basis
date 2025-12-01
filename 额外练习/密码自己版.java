package 额外练习;

import java.io.*;
import java.util.ArrayList;

public class 密码自己版 {
    public static void main(String[] args) {
        BufferedReader br=null;
        Reader reader=null;
        Writer writer=null;
        BufferedWriter bw=null;
        try {
            reader=new FileReader("data.txt");
            br=new BufferedReader(reader);
            String line= br.readLine();
            String[] numbers = line.split(" ");
            int n=Integer.parseInt(numbers[0]);
            int a=Integer.parseInt(numbers[1]);
            int k=Integer.parseInt(numbers[2]);
            int total=(int)Math.pow(3,n);
            int cal=(int)Math.pow(10,n-1);
            int len=0;
            writer=new FileWriter("password.txt");
            bw=new BufferedWriter(writer);
            for(int i=cal;i>=1;i/=10){
                int numleft=a/i;
                if(numleft!=0){
                    len=len+1;
                }else{
                    continue;
                }
            }
            int lenof0=n-len;
            String s = String.valueOf(a);
            ArrayList<String> list=new ArrayList<String>();
            for(int i=0;i<lenof0;i++){
                list.add("0");
            }
            for (int i = 0; i < s.length(); i++) {
                list.add(String.valueOf(s.charAt(i)));
            }

            int[] clone = new int[list.size()];
            for (int i = 0; i < list.size(); i++) {
                clone[i] =Integer.parseInt(list.get(i));
            }
            for(int i=0;i<total;i++){
                int[] current = clone.clone();
                int temp=i;
                int count=0;
                for(int j=0;j<n;j++){
                    int op=temp%3;
                    temp=temp/3;
                    if(op!=0){
                        count++;
                    }
                    if(count>k){
                        break;
                    }
                    if(op==1){
                        if(current[j]==9){
                            current[j]=0;
                        }else{
                            current[j]=current[j]+1;
                        }
                    } if(op==2){
                        if(current[j]==0){
                            current[j]=9;
                        }else{
                            current[j]=current[j]-1;
                        }
                    }
                }
                if(count<=k){
                    StringBuilder sb = new StringBuilder();
                    for (int num : current){
                        sb.append(num);
                    }
                    while (sb.length() > 1 && sb.charAt(0) == '0') {
                        sb.deleteCharAt(0);
                    }
                    bw.write(sb.toString());
                    bw.newLine();
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                bw.close();
                writer.close();
                br.close();
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
