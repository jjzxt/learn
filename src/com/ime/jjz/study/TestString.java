package com.ime.jjz.study;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

public class TestString {
	public static void main(String[] args) {
		String str = "12345";
		String ret = str;
		System.out.println(ret+","+str);
		
		str = "67890";
		System.out.println(ret+","+str);
		SimpleDateFormat adf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		long time = 1463969381972L;
		System.out.println(adf.format(time));
		long ideltime = 8974;
		String idelT = ((ideltime/3600)/10== 0?"0"+ideltime/3600:ideltime/3600) +":"+ideltime%3600/60+":"+ideltime%3600%60;
		System.out.println(idelT);
		
		String f = "123456";
		//double x  = Double.parseDouble(f);
		//double y = x*ideltime/3600;
		System.out.println(f.substring(0, f.indexOf(".")+2)+","+f.indexOf("."));
		
		Map<String,Object> m = new HashMap<String,Object>();
		System.out.println(m+","+m.isEmpty());
		
		m.put("keys", 123);
		System.out.println("result:"+m.get("key"));
	}

}
