
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String str=br.readLine();
        Integer[] count=new Integer[26];
        for(int i=0;i<count.length;i++){
            count[i]=0;
        }
        int max=-1;
        char c = '?';
        for(int i=0;i<str.length();i++){
            if('a'<=str.charAt(i)&&str.charAt(i)<='z'){
                count[(str.charAt(i)-97)]++;
            }else if('A'<=str.charAt(i)&&str.charAt(i)<='Z'){
                count[(str.charAt(i)-65)]++;
            }
        }
        for(int i=0;i<26;i++){
            if(count[i]>max){
                max=count[i];
                c=(char)(i+65);
            }else if(count[i]==max){
                c='?';
            }
        }
        System.out.println(Character.toString(c));
    }

}