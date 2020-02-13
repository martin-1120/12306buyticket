package com.buyticket.core;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.script.Bindings;
import javax.script.Compilable;
import javax.script.CompiledScript;
import javax.script.Invocable;
import javax.script.ScriptContext;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineFactory;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

import com.buyticket.test.Hello;
import com.sun.org.apache.xml.internal.serializer.Method;

public class JSEngineUtil {
	
	//使用脚本引擎运行脚本程序
	public static void test01() throws ScriptException{
		// 如果调用者可访问线程上下文 ClassLoader，则调用此构造方法的效果与调用 ScriptEngineManager(Thread.currentThread().getContextClassLoader()) 相同
		//ScriptEngineManager检索感兴趣的脚本编写的语言的ScriptEngine对象
		ScriptEngineManager manager = new ScriptEngineManager();
		ScriptEngine engine = manager.getEngineByName("js");//ScriptEngine用来处理脚本解释和求值
		System.out.println(engine.getClass());
		engine.put("age", 26);//赋值脚本环境中所使用的变量
		engine.eval("if(age>=18){println('Old enough to vote!');}else{println('Back to school!');}");//解析 JavaScript 脚本,对脚本表达式进行求值
	}
	
	//使用脚本引擎执行外部资源中的脚本  
	public static void test02() throws FileNotFoundException, ScriptException{  
	    ScriptEngineManager manager = new ScriptEngineManager();  
	    ScriptEngine engine = manager.getEngineByName("js");  
	    engine.put("age", 26);  
	    engine.eval(new FileReader("test/test01.js"));//对文件或其它外部资源中得脚本表达式进行求值  
	}  
	//使用脚本引擎检索结果
	public static void test03() throws FileNotFoundException, ScriptException{
		ScriptEngineManager manager = new ScriptEngineManager();
		ScriptEngine engine = manager.getEngineByName("js");
		engine.put("age", 26);
		engine.put("noClaims", Boolean.TRUE);
		Object result = engine.eval(new FileReader("test/test02.js"));//eval()函数返回执行脚本后所返回的值，默认情况下，将返回上次执行的表达式的值
		System.out.println(result.toString());
	}
	//上下文属性的作用域
	public static void test04() throws ScriptException{
		ScriptEngineManager manager = new ScriptEngineManager();
		Bindings globalBindings = manager.getBindings();//属于ScriptEngineManager的全局上下文,每个ScriptEngineManager拥有一个Bindings
		globalBindings.put("name", "yangYong");
		ScriptEngine engine = manager.getEngineByName("js");
		Bindings globalBindings02 = engine.getBindings(ScriptContext.GLOBAL_SCOPE);//每个引擎都共有一个ScriptEngineManager的Bindings
		System.out.println("name="+globalBindings02.get("name"));//name=yangYong
		System.out.println(globalBindings==globalBindings02);//true
		//ScriptContext context = engine.getContext();//每个引擎都有自己独立的scriptContext上下文
		
		Bindings engineDefaultBindings = engine.getBindings(ScriptContext.ENGINE_SCOPE);//每个引擎的scriptContext中都有个默认属于自己的Bindings
		engineDefaultBindings.put("gender", "男");
		engine.eval("name2 = name;println(name2);",engineDefaultBindings);
		engineDefaultBindings.put("name", "zhangSan");
		engine.eval("name2 = name;println(name2);",engineDefaultBindings);
		Bindings engineCreatBindings = engine.createBindings();//每个引擎的scriptContext中也可以新建多个属于自己的Bindings
		engineCreatBindings.put("gender", "女");
		System.out.println(engineDefaultBindings==engineCreatBindings);
		System.out.println(engine.getBindings(ScriptContext.ENGINE_SCOPE).get("gender"));
		System.out.println(engineCreatBindings.get("gender"));
		engine.eval("name2 = name;println(name2);",engineCreatBindings);
	}
	//java应用程序与脚本交互
	public static void test05() throws FileNotFoundException, ScriptException{
		ScriptEngineManager manager = new ScriptEngineManager();
		ScriptEngine engine = manager.getEngineByName("js");
		Bindings bindings = engine.createBindings();//Bindings:KV对映射，用来在Java应用程序和javascript脚本之间交换信息，即上下文
		bindings.put("age", 26);
		bindings.put("noClaims", Boolean.TRUE);
		bindings.put("riskFactor", 1.5);
		engine.eval("if(age<25){riskFactor = 1.5;}else if(noClaims){riskFactor = 0.75;}else{riskFactor = 1.0;}",bindings);//必须绑定bindings执行脚本，否则报变量未定义异常
		double risk = (Double) bindings.get("riskFactor");
		System.out.println(risk);
	}
	public static void say(){
		System.out.println("JAVA hello");
	}
	//脚本内部访问java资源
	public static void test06() throws ScriptException{
		ScriptEngineManager manager = new ScriptEngineManager();
		ScriptEngine engine = manager.getEngineByName("js");
		engine.eval("importPackage(java.util)");//importPackage()函数允许在脚本内部导入java包，即可在脚本中实例化java对象
		engine.eval("importPackage(com.buyticket.test)");
		engine.eval("today = new Date();println(today);");
		engine.put("name", "ZhangSan");
		engine.eval("name2 = name.toUpperCase();println(name2);");
		engine.eval("new TestJS().say();");
	}
	//重定向脚本输出
	public static void test07() throws IOException, ScriptException{
		ScriptEngineManager manager = new ScriptEngineManager();
		ScriptEngine engine = manager.getEngineByName("js");
		
		PipedReader pr = new PipedReader();
		PipedWriter pw = new PipedWriter(pr);
		//用户可以通过与这个 PrintWriter 连通的 PrintReader 读取实际的输出，使 Java 应用程序能获取脚本运行输出
		PrintWriter out = new PrintWriter(pw);
		engine.getContext().setWriter(out);
		
		engine.eval("println('hello from javascript!');");
		
		BufferedReader br = new BufferedReader(pr);
		System.out.println("java :"+br.readLine());
	}
	
	//可编译且可调用的引擎
	public static void test08() throws ScriptException{
		ScriptEngineManager manager = new ScriptEngineManager();
		ScriptEngine engine = manager.getEngineByName("js");
		if(engine instanceof Compilable){//判断脚本引擎是否支持编译操作
			Compilable compilable = (Compilable)engine;//用来保存编译的结果，从而能重复调用脚本而没有重复解释的开销
			//compile()方法将脚本编译成无需重新编译就能反复执行的CompiledScript容器
			CompiledScript script = compilable.compile("if(age<25){riskFactor = 1.5;}else if(noClaims){riskFactor = 0.75;}else{riskFactor = 1.0;}");
			
			Bindings bindings = engine.createBindings();
			bindings.put("age", 26);
			bindings.put("noClaims", Boolean.TRUE);
			bindings.put("riskFactor", 1.0);
			
			Object result = script.eval(bindings);//使用CompiledScript的eval()方法计算编译后的表达式
			System.out.println(result.toString());
		}
	}
		
	//调用脚本中的函数和方法
	public static void test09() throws ScriptException, NoSuchMethodException, FileNotFoundException{
		ScriptEngineManager manager = new ScriptEngineManager();
		ScriptEngine engine = manager.getEngineByName("js");
		engine.eval("function increment(i){return i+1;}");
		if (engine instanceof Invocable) {//判断脚本引擎是否支持编译操作
			Invocable invocable = (Invocable)engine;//Invocable允许从java代码调用定义在脚本中的单个函数
			Object result = invocable.invokeFunction("increment", new Object[]{10});// 调用脚本中定义的顶层程序和函数
			System.out.println("result = "+result);
		}
		
		ScriptEngine engine2 = manager.getEngineByName("js");
		engine2.eval(new FileReader("test/test03.js"));
		if(engine2 instanceof Invocable){
			Invocable invocable = (Invocable)engine2;
			invocable.invokeMethod(engine2.get("hello"), "sayHello", "yangYong");//对以前的脚本执行中已经编译的脚本对象（以 ScriptEngine 的状态保持）调用某一方法
		}
	}
	//调用脚本中的函数和方法并将他们作为java程序中的接口实现
	public static void test10() throws FileNotFoundException, ScriptException{
		ScriptEngineManager manager = new ScriptEngineManager();
		ScriptEngine engine = manager.getEngineByName("js");
		engine.eval("function increment(i){return i+1;}");
		if (engine instanceof Invocable) {
			Invocable invocable = (Invocable)engine;
			Hello hello = invocable.getInterface(Hello.class);//返回一个接口的实现，该接口使用解释器中编译的函数
			Object result = hello.increment(2);
			System.out.println("result = "+result);
		}
		engine.eval(new FileReader("test/test03.js"));
		if(engine instanceof Invocable){
			Invocable invocable2 = (Invocable)engine;
			Hello hello = invocable2.getInterface(engine.get("hello"), Hello.class);// 返回一个接口的实现，该接口使用解释器中已编译脚本对象的成员函数
			hello.sayHello("zhangSan");
		}
	}

	
	public static String getVarFromJS(String path,String varName) throws FileNotFoundException, ScriptException{
		ScriptEngineManager manager = new ScriptEngineManager();
		ScriptEngine engine = manager.getEngineByName("js");
//		try {
			//替换FileReader防止乱码报错
			engine.eval(new FileReader(path));//new InputStreamReader(new FileInputStream(path),"UTF-8")
//		} catch (UnsupportedEncodingException e) {
//			e.printStackTrace();
//		}
		String stations=(String)engine.get(varName);
		
		return stations;
	}
	public static String getStationName(String path){
		try {
			return getVarFromJS(path,"station_names");
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return null;
	}
	public static String getFavoriteName(String path){
		try {
			return getVarFromJS(path,"favorite_names");
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return null;
	}
	public static void test11() throws ScriptException{
		ScriptEngineManager manager = new ScriptEngineManager();
		ScriptEngine engine = manager.getEngineByName("js");
		/*engine.eval("importPackage(java.util)");//importPackage()函数允许在脚本内部导入java包，即可在脚本中实例化java对象
		engine.eval("importPackage(com.buyticket.test)");
		engine.eval("today = new Date();println(today);");
		engine.put("name", "ZhangSan");
		engine.eval("name2 = name.toUpperCase();println(name2);");
		engine.eval("new TestJS().say();");*/
		List<Map<String,Object>> payload=new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			Map<String,Object> row=new HashMap<>();
			row.put("row", i);
			row.put("name","aaa:"+ i);
			row.put("isMale", true);
			row.put("date",new Date());
			row.put("num",11.0123);
			payload.add(row);
		}
		engine.put("payload", payload);
		engine.eval("for(var i=0;i<payload.size();i++){var os=payload.get(i).get('row')%2==0;var name=payload.get(i).get('name');if(os){payload.get(i).put('name',name+' 偶数');} }");
		
		System.out.println(payload);
		
		System.out.println("==================");
		Object obj=engine.get("payload");
		System.out.println(obj);
		
		engine.put("a", 1);
		engine.eval("println(a)");
		
		engine.eval("println(a)");
	}
	public static void printAllEngine(){
		 ScriptEngineManager manager = new ScriptEngineManager();  
        for (ScriptEngineFactory f : manager.getEngineFactories()) {  
            printBasicInfo(f);  
            System.out.println();  
        }  
   
        ScriptEngine nashorn = manager.getEngineByName("nashorn");  
        if(nashorn != null) {  
            System.out.println("Nashorn is present.");  
        }  
        else {  
            System.out.println("Nashorn is not present.");  
        }  
	}
    public static void printBasicInfo(ScriptEngineFactory factory) {  
        System.out.println("engine name=" + factory.getEngineName());  
        System.out.println("engine version=" + factory.getEngineVersion());  
        System.out.println("language name=" + factory.getLanguageName());  
        System.out.println("extensions=" + factory.getExtensions());  
        System.out.println("language version=" + factory.getLanguageVersion());  
        System.out.println("names=" + factory.getNames());  
        System.out.println("mime types=" + factory.getMimeTypes());  
    }
    public static String retString(){
    	return "h w d";
    }
    public static void test12() throws Exception{
    	ScriptEngineManager manager = new ScriptEngineManager();
		ScriptEngine engine = manager.getEngineByName("js");
		engine.eval("var ret=com.buyticket.core.JSEngineUtil.retString();println(ret)");
		Object ret=engine.get("ret");
		ret.getClass().getDeclaredMethod("getDefaultValue", Class.class).invoke(ret,new Object[]{null});
		//System.out.println(((sun.org.mozilla.javascript.internal.NativeJavaObject)ret).getDefaultValue(null));
    }
    public static void test13()throws ScriptException{
    	ScriptEngineManager manager = new ScriptEngineManager();
		ScriptEngine engine = manager.getEngineByName("js");
		Bindings gbind=engine.getBindings(ScriptContext.GLOBAL_SCOPE);
		Bindings ebind=engine.getBindings(ScriptContext.ENGINE_SCOPE);
		Bindings cbind=engine.createBindings();
		Bindings cbind2=engine.createBindings();
		gbind.put("a", " 全局");
		ebind.put("a", " 局部");
		cbind.put("a", " createBindings 局部");
		cbind2.put("a", " createBindings 2 局部");
		engine.eval("a=2;println(a)",ebind);
		
		engine.eval("println(a)");

    }
	public static void main(String[] args) throws Exception {
		printAllEngine() ;
		
	}
}


