package com.cstr;
import java.util.ArrayList;
import java.util.List;
public class ZH {
	static String te;
	static String t[]={};//��ʱ�⼰������
    void count1(int i, String str, String[] num,int n) {	//���� ��� 2^n-1
    	String sArrays[]=str.split(",");String st="";
    	List<String> iL = new ArrayList<String>();//�ַ�������
    	count(0,st,sArrays,2,iL);//���
    	int temp=0;//��� n^2
    	for (int k=0;k<iL.size();k++){
    		String tArrays[]=iL.get(k).split(",");
    		temp+=Input.matrix[Integer.parseInt(tArrays[0])][Integer.parseInt(tArrays[1])];
    		if (temp>0) return;}//���
    	if (sArrays.length>t.length&&!str.equals("")) {
    		ZH.te=str;
    		ZH.t=sArrays;//��ʱ����
    	System.out.println("n:"+t.length+",te:"+ZH.te);}
//  	System.out.println("n:"+t.length+",te:"+ZH.te+"at:"+str);
        if(n==0){
        	if(temp==0){Input.end = System.nanoTime();
        	System.out.println("Time taken : "+ (Input.end-Input.start)/1.0e9);
        	System.out.println("MIS : "+ZH.t.length+" , set : "+ZH.te.substring(0, ZH.te.length()-1));}//�������
        	return;}//����
        if(i==num.length){return;}//�߽�
        count1(i+1,str+num[i]+",",num,n-1);
        count1(i+1,str,num,n);}//�ݹ�
    void count(int i, String str, String[] num,int n,List<String> iL) {    //���
        if(n==0){iL.add(str);return;}
        if(i==num.length){return;}
        count(i+1,str+num[i]+",",num,n-1,iL);
        count(i+1,str,num,n,iL);}
}