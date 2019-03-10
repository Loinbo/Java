//String类扩展功能实现
public class Strings{
    
     /**
     * 1.重复某个字符
     * 
     * 例如： 
     * 'a' 5   => "aaaaa"  
     * 'a' -1  => ""
     * 
     * @param c     被重复的字符
     * @param count 重复的数目，如果小于等于0则返回""
     * @return 重复字符字符串
     */
    public static String repeat(char c, int count) {
       StringBuffer sb = new StringBuffer();//定义StringBuffer类便于字符串内容的修改
		if(count >0){
			for(int i = 0;i<count;i++){
				sb.append(c);
			}
				return sb.toString();//将StringBuffer类转为String类
		}
		else
			return "";
    }

	public static void main(String[] args){
		String str1 = new String();
		System.out.println(str1.repeat('a',3));
	}
    
    
    
     /**
     * 2.将已有字符串填充为规定长度，如果已有字符串超过这个长度则返回这个字符串
     * 字符填充于字符串前
     *
     * 例如： 
     * "abc" 'A' 5  => "AAabc"
     * "abc" 'A' 3  => "abc"
     *
     * @param str        被填充的字符串
     * @param filledChar 填充的字符
     * @param len        填充长度
     * @return 填充后的字符串
     */
    public static String fillBefore(String str, char filledChar, int len) {
       if(len>0)
	   {
		 char[] c = new char[len];//定义要填充的字符数组
		 for(int i = 0;i<len;i++){
			 c[i]=filledChar;
		 }
		 String str1 = new String(c);//将字符数组再转化成字符串
		 String str2 = str1 + str;//进行拼接
		 return str2;
	   }
	   else
	   {
		    return "";
	   }
     
    }
	
	public static void main(String[] args){
		Strings test = new Strings();
		System.out.println(Strings.fillBefore("a",'s',3));

	}
    
    /**
     * 3.将已有字符串填充为规定长度，如果已有字符串超过这个长度则返回这个字符串<br>
     * 字符填充于字符串后
     * 例如： 
     * "abc" 'A' 5  => "abcAA"
     * "abc" 'A' 3  => "abc"
     *
     * @param str        被填充的字符串
     * @param filledChar 填充的字符
     * @param len        填充长度
     * @return 填充后的字符串
     */
    public static String fillAfter(String str, char filledChar, int len) {
		char[] c=str.toCharArray();
		int n = len-c.length;
		if(c.length<len){
			for(int i=0;i<n;i++){
				str+=filledChar;
			}
		}
        return str;
    }
	
	public static void main(String[] args){
		Strings test = new Strings();
		System.out.println(test.fillAfter("a",'s',3));

	}

    /**
     * 4.移除字符串中所有给定字符串
     * 例：removeAll("aa-bb-cc-dd", "-") => aabbccdd
     *
     * @param str         字符串
     * @param strToRemove 被移除的字符串
     * @return 移除后的字符串
     */
       public static String removeAll(CharSequence str, CharSequence strToRemove) {//定义字符串，被移除的字符串
		String str1=str.toString();//将字符序列转变为String类
		String str2=strToRemove.toString();
		String strs="";
        char[] c=str1.toCharArray();//将字符串转变为字符数组
		char[] c2=str2.toCharArray();
		char c1=strToRemove.charAt(0);
		for(int i=0;i<c.length;i++){
			if(c[i]!=c1){
			strs+=c[i];//移除给定字符串，余下的字符串组成新字符串
			}
			else{
				i=i+c2.length-1;//移除整个字符串
			}
		}
        return strs;
    }
	
		public static void main(String[] args){
		String test = new String();
		System.out.println(test.removeAll("aa-bb-cc-dd", "-"));

	}
	
    
    /**
     * 5.反转字符串
     * 例如：abcd => dcba
     *
     * @param str 被反转的字符串
     * @return 反转后的字符串
     */
        public static String reverse(String str) {
		
        char[] c = str.toCharArray();//将String类转化为字符数组
		int left = 0;
		int right = c.length - 1;//定义左右指针，遍历逆序摆放
		while(left<right){
			char tmp;
			tmp = c[left];
			c[left] = c[right];
			c[right] = tmp;
			left++;
			right--;
		}
		
	  return new String(c);//将字符数组再转换成字符串
	}
	
	
	public static void main(String[] args){
		Strings test = new Strings();
		System.out.println(test.reverse("abc"));

	}

}