package com.cstr;
import java.util.ArrayList;
import java.util.List;
public class ZH {
	static String te;
	static String t[]={};//临时解及其数组
    void count1(int i, String str, String[] num,int n) {	//独立 组合 2^n-1
    	String sArrays[]=str.split(",");String st="";
    	List<String> iL = new ArrayList<String>();//字符串处理
    	count(0,st,sArrays,2,iL);//配对
    	int temp=0;//检查 n^2
    	for (int k=0;k<iL.size();k++){
    		String tArrays[]=iL.get(k).split(",");
    		temp+=Input.matrix[Integer.parseInt(tArrays[0])][Integer.parseInt(tArrays[1])];
    		if (temp>0) return;}//检查
    	if (sArrays.length>t.length&&!str.equals("")) {
    		ZH.te=str;
    		ZH.t=sArrays;//临时解检查
    	System.out.println("n:"+t.length+",te:"+ZH.te);}
//  	System.out.println("n:"+t.length+",te:"+ZH.te+"at:"+str);
        if(n==0){
        	if(temp==0){Input.end = System.nanoTime();
        	System.out.println("Time taken : "+ (Input.end-Input.start)/1.0e9);
        	System.out.println("MIS : "+ZH.t.length+" , set : "+ZH.te.substring(0, ZH.te.length()-1));}//特殊情况
        	return;}//结束
        if(i==num.length){return;}//边界
        count1(i+1,str+num[i]+",",num,n-1);
        count1(i+1,str,num,n);}//递归
    void count(int i, String str, String[] num,int n,List<String> iL) {    //配对
        if(n==0){iL.add(str);return;}
        if(i==num.length){return;}
        count(i+1,str+num[i]+",",num,n-1,iL);
        count(i+1,str,num,n,iL);}
}