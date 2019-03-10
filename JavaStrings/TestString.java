public class TestString{
    
    
    //字符串的比较，以及==比较
    public static void code1(){
        int x =10;
         int y =10;
         System.out.println(x==y);//true
         
         //直接赋值法和构造方法法有差异
         String str1 = "java is best";
         String str2 = "java is best";
         
         String str3 = new String("java is best");
         System.out.println(str1==str2);//true 
         System.out.println(str1==str3);//false
         
         //比较字符串的值
         System.out.println("str1 equals str3 "+ str1.equals(str3));
         
         
         //如果字符串变量和字符串匿名对象进行equals比较
         //字符串匿名对象放在前面
         //String str1 = "java is best";
         //String str1 = null;
         System.out.println("hello".equals(str1));
    }
    
    //直接赋值法和构造方法差异
    public static void code2(){
         String str1 ="java is best"; 
        String str2 ="java is best";
        String str3 ="java is best";
        System.out.println("str1 == str2 "+ (str1==str2));//true
        
        //intern() String对象入池
        String str4 = new String("java is best").intern();
        String str5 = "java is best";
        System.out.println("str4 == str5 "+ (str4==str5));//true
    }
    
    //字符串拼接对象空间开辟
    public static void code3(){
         //堆空间开辟了5个块
        String str = "hello" ; 
		str = str + " world" ; 
		str += "!!!" ; 
		System.out.println(str); // hello world!!!
    }
    
    //如果是0-9组成返回true,否则返回false
    public static boolean isNumber(String str){
        if(str==null){
            return false;
        }
        char[] chars = str.toCharArray();
        for(int i=0; i<chars.length; i++){
            char c = chars[i];
            if(c >='0' && c <='9'){
                 continue;
            }else{
                return false;
            }
        }
        return true;
    }
    
    //字符和字符串转换
    public static void code4(){
        //charAt
        String str1 = "helloworld"; //10字符
        System.out.println(str1.charAt(0));//h   //System.out.println(str1.charAt(10));//StringIndexOutOfBoundsException
        //字符和字符串转换
        char[] chars = str1.toCharArray();
        for(int i=0; i<chars.length; i++){
            System.out.print(chars[i]);
            if(i<chars.length-1){
                System.out.print(", ");
            }
        }
        System.out.println();
        String str2 =new String(chars);
        System.out.println(str2);//helloworld
        String str3 =new String(chars,1,2);
        System.out.println(str3);//el
 
        //指定字符串，判断字符串是否由数字组成 0-9
        String [] strArray = {"abc123","0123","abcdef"};
        for(int i=0; i<strArray.length; i++){
            System.out.println(strArray[i]+" is number "+ isNumber(strArray[i]));
        }
    }
    
    //字节和字符串转换
    public static void code5(){
         String str1 = "helloworld"; //10字符
         byte[] bytes =str1.getBytes();
         for(int i=0;i<bytes.length;i++){
            System.out.print(bytes[i]);//ASCII
            if(i<bytes.length-1){
                System.out.print(", ");
            }
         }
         String str2 =new String(bytes,0,2);//he
         System.out.println(str2);
         System.out.println('h'-'a');//7
    }
    
    //String比较
    public static void code6(){
        String str1 ="helloworld";
        String str2 ="Helloworld";
        System.out.println(str1.equals(str2));//false
        System.out.println(str1.equalsIgnoreCase(str2));//true
        
        System.out.println("A".compareTo("a")); // -32 <0
        System.out.println("a".compareTo("A")); // 32 >0
        System.out.println("A".compareTo("A")); // 0  =0
        System.out.println("AB".compareTo("AC")); // -1 <0
        //\u4e00 \u9fa5
        System.out.println("刘".compareTo("杨"));// -5456 <0
    }
    
    //字符串查找
    public static void code7(){
        String str1 = "helloworld";
        System.out.println(str1.contains("world"));//true
        System.out.println(str1.contains("java"));//false
        
        System.out.println(str1.indexOf("w"));//5
        System.out.println(str1.indexOf("J"));//-1
        System.out.println(str1.indexOf("world"));//5
        
        int index = str1.indexOf(".");
        if(index ==-1 ){
            System.out.println(str1+" 中找不到 .");
        }else{
            System.out.println(str1+" 中找到 .");
        }
        
        String filename="Test.java";
        System.out.println(filename+"是否是java源文件:"+filename.endsWith(".java"));
        String url ="http://51cto.com";
        boolean rs=  url.startsWith("http") ||  url.startsWith("https");
        System.out.println(url+"是否是网址:"+ rs);
    }
    
    //字符串替换
    public static void code8(){
        String str1 = "helloworld";
        System.out.println(str1.replaceAll("w","l"));
        System.out.println(str1.replaceAll("l","a"));
        System.out.println(str1.replaceFirst("l","a"));
    }
    
    public static void printStringArray(String[] strArray){
        for(int i=0; i<strArray.length; i++){
           System.out.print(strArray[i]);
           if(i < strArray.length-1){
               System.out.print(", ");
           }
       }
       System.out.println();
    }
    
    //字符串的拆分
    public static void code9(){
        String str1 = "java is best";
       //String[] strArray = str1.split(" ");
       //String[] strArray = str1.split(" ",2);
       String[] strArray = str1.split("w");
       for(int i=0; i<strArray.length; i++){
           System.out.print(strArray[i]);
           if(i < strArray.length-1){
               System.out.print(", ");
           }
       }
       System.out.println();
    
       String str2 = "192.168.1.1";
       String[] ips = str2.split("\\.");
       printStringArray(ips);
       
       String str3 = "张三:28:男|王五:18:男|李四:18:女";
       String[] persons = str3.split("\\|");
       for(int i=0; i<persons.length;i++){
           String person = persons[i];
           String[] infos = person.split(":");
           System.out.println("姓名："+infos[0]+" 年龄："+infos[1]+" 性别："+infos[2]);
       }
    }
    
    //字符串截取
    public static void code10(){
       String str1 = "helloworld";
       System.out.println(str1.substring(5));//world
       System.out.println(str1.substring(3,5));//lo
    }
    
    //字符串其它方法
    public static void code11(){
         String str1 ="   hello   world  ";
        System.out.println("["+str1+"]");
        System.out.println("["+str1.trim()+"]");
        
        //大小写转换：a-z A-Z 
        System.out.println("abc".toUpperCase());//ABC
        System.out.println("abc123".toUpperCase());//ABC123
        System.out.println("中文".toUpperCase());//
        System.out.println("HelloWorld".toLowerCase());//
       
        //isEmpty
        System.out.println(" ".isEmpty());//false
        System.out.println("".isEmpty());//true
        System.out.println("null".isEmpty());//false
        System.out.println("abc".isEmpty());//false
        
    }
    
    //首字母大写
    public static String firstCharUpperCase(String str){
        if(str==null){
            return null;
        }
        if(str.isEmpty()){
            return str;
        }
        String first = str.substring(0,1);//endIndex )
        String second =  str.substring(1);
        return first.toUpperCase()+second;
        
        /* //测试用例
         System.out.println(firstCharUpperCase(""));
        System.out.println(firstCharUpperCase(" "));
        System.out.println(firstCharUpperCase(null));
        System.out.println(firstCharUpperCase("aBC"));
        System.out.println(firstCharUpperCase("abc"));
        System.out.println(firstCharUpperCase("ABC"));
        */
    }
    
    public static void main(String[] args){
        StringBuffer sb = new StringBuffer();
        sb.append("java ") //链式调用
          .append(" is ")
          .append(" best"); //return this
        
        System.out.println(sb);
        String str1 = sb.toString();
        System.out.println(str1);
        
        System.out.println(sb.reverse());
        System.out.println(sb.delete(1,3));
        System.out.println(sb.insert(3,"aa"));
       
    }
}