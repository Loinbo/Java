import java.util.Arrays;
public class ArrayUtils{
	//计算数组最大值
	public static int arrayMaxElement(int [] data1){
		if(data == null){
		   //参数异常IlegalArgumentException
		   throw new IlegalArgumentException("data must not be null");
		}
		int max=Integer.MIN_VALUE;
		for(int i=0;i<data1.length;i++){
			if(data1[i]>max){
				max=data1[i];
			}
		}
		return max;
	}
	//计算数组最小值
	public static int arrayMinElement(int [] data){
		if(data == null){
		throw new IlegalArgumentException("data must not be null");
		}
		int min=Integer.MAX_VALUE;
		for(int i=0;i<data.length;i++){
			if(data[i]<min){
				min=data[i];
			}
		}
		return min;
	}
	//计算数组值之和
	public static int arrayElementSum(int [] data2){
		if(data == null){
		throw new IlegalArgumentException("data must not be null");
		}
		int sum=0;
		for(int i=0;i<data2.length;i++){
			sum+=data2[i];
			}
		}
		return sum;
	}
	//数组拼接
	public static int arrayJoin(int [] a,int [] b){
		if(a == null){
		throw new IlegalArgumentException("data must not be null");
		}
		if(b == null){
		throw new IlegalArgumentException("data must not be null");
		}
		//动态初始化
		int []c=new int[a.length+b.length];
		for(int i=0;i<a.length;i++)
		{
			c[i]=a[i];
		}
		for(int i=a.length;i<c.length;i++)
		{
			c[i]=b[i-a.length];
		}
		  return c;
		}
	}
	//数组截取
	//[start,end)半闭半开区间
	public static int arraySub(int [] d,int start,int end){
		//int []d = new int[]{0,1,2,3,4,5};
		if(d == null){
		   throw new IlegalArgumentException("data must not be null");
		}
		if(start<0||end<0){
			throw new IlegalArgumentException("data must  be >0");
		}
		if(end<start){
			throw new IlegalArgumentException("end must  be >start");
		}
		if(start>=d.length){
			throw new IlegalArgumentException("start must  be <d.length");
		}
		
		//TODO 需要对start和end进行判断
		int count = end-start;
		if(count>a.length){
		throw new IlegalArgumentException("count must  be <a.length");
		}
		int []b=new int [count]; 
		for(int i=start;i<end;i++)
		{
			e[i-start]=d[i];
		}
		return d;
	}
	public static void main(String [] args){
		int []data1={20.3,6,8,0};
		int max=arrayMaxElement(a);
		System.out.println(max);
		/*int []data={5,7,2,0,1};
		System.out.println(min);
		int []data2={2,1,4,3};
		System.out.println(sum);
		int []a={0,1,2,3,4};
		int []b={4,5,6};
		int []c=arrayJoin(a,b);
		for(i=0;i<c.length;i++){
		   System.out.print(c[i]+" ");
		}
	
		//int []d={0,1,2,3,4,5};
		*/
		//截取
		int []sub=arraySub(d,0,2);
		PrintArray(sub);
		
	}
}