package com.cstr;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
public class Input {
	public static int[][] matrix;//�ڽӾ���
	public static long start;public static long end;//��ʱ��
	public static void main(String[] args) {
			try {
				File file = new File("C:/Users/acer/Desktop/game/frb30-15-mis/5.txt");//�����ĵ� ����һ��size/�ڶ���link��
				FileInputStream finput=new FileInputStream(file);
				BufferedReader br=new BufferedReader(new InputStreamReader(finput));//�ļ���
				int size=Integer.parseInt(br.readLine());
				String link=br.readLine();//size-�ڵ�����,link-���ӷ�ʽ
		    	String kArrays[]=link.split(",");matrix=new int[size+1][size+1];//����ע�����
		        for(String k : kArrays){
		        	String[] array = k.split(" ");
		        	matrix[Integer.parseInt(array[0])][Integer.parseInt(array[1])]=1;
		        	matrix[Integer.parseInt(array[1])][Integer.parseInt(array[0])]=1;}//����ע�����
			        ZH zh=new ZH();
			        String str="";String num[]=new String[size];
			        for (int i=0;i<size;i++) num[i]=Integer.toString(i+1);//��ռ�-���
			        int du[]=new int[size];
			        for (int i=0;i<size;i++)
			        	for(int j=1;j<size+1;j++)
			        		du[i]+=matrix[j][i+1];
			        List<String> list = Arrays.asList(num);
			        Collections.shuffle(list);//���
					Collections.sort(list, new Comparator< String>() {//����
						public int compare(String o1, String o2) {
							if (du[Integer.parseInt(o1)-1]<du[Integer.parseInt(o2)-1])
								return -1;
							if (du[Integer.parseInt(o1)-1]>du[Integer.parseInt(o2)-1])
								return 1;
							return 0;}});
			        num=(String[]) list.toArray();
			        start = System.nanoTime();
			        zh.count1(0,str,num,size-1);
			        end = System.nanoTime();//���
			        System.out.println("------------");
		        	System.out.println("Time taken : "+ (end-start)/1.0e9);
		        	System.out.println("Size: "+size);
		        	System.out.println("MIS : "+ZH.t.length);
		        	System.out.println("Set : "+ZH.te.substring(0, ZH.te.length()-1));
		        	System.out.println("------------");
		        	br.close();}//����
			catch (Throwable e) {
				e.printStackTrace();}
	}
}