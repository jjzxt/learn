package com.ime.jjz.study;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class TestString {
	public static void main(String[] args) {
//		String str = "12345";
//		String ret = str;
//		System.out.println(ret+","+str);
//		
//		str = "67890";
//		System.out.println(ret+","+str);
		SimpleDateFormat adf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
		long time = System.currentTimeMillis();
		System.out.println(adf.format(time));
//		long ideltime = 8974;
//		String idelT = ((ideltime/3600)/10== 0?"0"+ideltime/3600:ideltime/3600) +":"+ideltime%3600/60+":"+ideltime%3600%60;
//		System.out.println(idelT);
//		
//		String f = "123456";
//		//double x  = Double.parseDouble(f);
//		//double y = x*ideltime/3600;
//		System.out.println(f.substring(0, f.indexOf(".")+2)+","+f.indexOf("."));
//		
//		Map<String,Object> m = new HashMap<String,Object>();
//		System.out.println(m+","+m.isEmpty());
//		
//		m.put("keys", 123);
//		System.out.println("result:"+m.get("key"));
		
		//时区转换test
//		SimpleDateFormat dateFormatGmt = new SimpleDateFormat("yyyy-MM-dd,HH:mm:ss");	
//		Date dt = new Date();
//		
//		Map<String,Object> props = new HashMap<String,Object>();
//		props.put("tzone","300");
//		
//		if(props.containsKey("tzone")){
//			    String tzone = props.get("tzone")+"";//tzone可能值："Asia/Shanghai",-480
//			    long diffTime = 0;
//			    if(tzone.matches("^-?[0-9]\\d*$")){//为整型
//			    	diffTime = TimeZone.getDefault().getRawOffset()-Integer.parseInt(tzone)*60*1000;//时间差(单位:毫秒)
//			    }else{
//			    	//为字符串 指定时区
//					 dateFormatGmt.setTimeZone(TimeZone.getTimeZone(tzone));
//			    }
//			    //转换为指定时区时间
//				 long nowTime = dt.getTime();     
//				 long newNowTime = nowTime - diffTime;   
//		         dt = new Date(newNowTime);
//		         
//		 }
//	     
//		System.out.println(dateFormatGmt.format(dt));
		
		//list to set ,set to list
//		List<String> test = new ArrayList<String>();
//		Set<String> test1 = new HashSet<String>();
//		
//		test1.add("1");
//		test1.add("1");
//		test1.add("2");
//		test.addAll(test1);
//		System.out.println(test+"--------"+test1);
//		
//		String[] str = new String[]{};
//		System.out.println("string array:"+Arrays.toString(str));
//		Integer total = null;
//		int idx = 0;
//		Integer xx = total;
//		if(idx == xx){
//			System.out.println("error");
//		}
//		System.out.println("end");
		
//		String str = "123.23f";
//		
//		 if( null != str && str.startsWith("v")){
//			 	 String vercode = str.substring(str.indexOf("v")+1);
//			 	 double code = 0;
//			 	 if(null != vercode && !vercode.isEmpty() && !vercode.matches(".*[a-zA-Z]+.*")){
//			 			 code = Double.parseDouble(vercode);
//			 	 }
//			 	System.out.println(code);
//		 }else{
//			 System.out.println("xx:"+0);
//		 }
//		if(str.matches(".*\\d+.*")){
//			String vercode = str.substring(str.indexOf("v")+1);
//			double code = 0;
//			System.out.println(vercode.matches(".*[a-zA-Z]+.*"));
//			if(null != vercode && !vercode.isEmpty() && !vercode.matches(".*[a-zA-Z]+.*")){
//	 			 code = Double.parseDouble(vercode);
//			}
			
//			System.out.println(code);
//         }
		
//		double x = 14.456;
//		double y = 14.4560000000000001;
//		//int xx = Double.compare(x, y);
//		System.out.println("result:"+(x == y));
		
//		Map test = new HashMap();
//		
//		test.put("key",1);
//		test.put("test", "nihao");
//		
//		System.out.println(test);
//		test.remove("test");
//		System.out.println(test);
		
//		double xx = 2000D;
//		xx = xx/6378137;
//		System.out.println(xx);
		
		Map<String,Object> xx = new HashMap<String,Object>();
		Map<String,Object> yy = new HashMap<String,Object>();
		yy.put("zz", 2);
		xx.put("yy", yy);
		Iterator it = xx.entrySet().iterator();
		
		while (it.hasNext()) 
		{ 
			Map.Entry entry = (Map.Entry) it.next() ; 
			String key = (String) entry.getKey() ; 
			Object ov = entry.getValue();
			
			System.out.println("res:"+key+"=="+String.valueOf(ov));
		}
		
		TestString ts = new TestString();
		ts.getStats("123");
		
		TreeMap<String,Object> treemap = new TreeMap<String,Object>();

		treemap.put("1502647837155", "2");
		treemap.put("1502647837807", "1");
		System.out.println(treemap);
		System.out.println(treemap.descendingMap());
		
		String fmodal = "%s,Fence Name:%s";
	     
		String msg = String.format(fmodal, "Usj 4 in","Usj 4 park");
	    System.out.println(msg);
	}
	
	public Map<String,Object> getStats(String id,String... keys){
		this.getStats1(id, keys);
		return null;
	}
	
	public Map<String,Object> getStats1(String id,String... keys){
		if(keys == null || keys.length <= 0){
			System.out.println("1x");
		}else{
			System.out.println("2x");
		}
		return null;
	}
}
