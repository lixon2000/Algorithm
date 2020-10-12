package com.lx.classLoad;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class LogicTestExecutor {
	public static void main(String[] args) throws IOException {
		LogicTestExecutor.exec();
	}

	public static void exec() throws IOException {
		InputStream inputStream = new FileInputStream("cfg/LogicTestClass.class");
		byte[] classBytes = new byte[inputStream.available()];
		inputStream.read(classBytes);
		inputStream.close();
		
		// 偷梁换柱
		ClassModifier classModifier = new ClassModifier(classBytes);
		classBytes = classModifier.modifyUTF8Constant("java/lang/System", "com/jvm/classLoad/HackSystem");
		
//		{
//			// 输出查看
//			OutputStream outputStream = new FileOutputStream("cfg/LogicTestClass2.class");
//			outputStream.write(classBytes);
//			outputStream.flush();
//			outputStream.close();
//		}
		
		//
		HotSwapClassLoader loader = new HotSwapClassLoader();
		Class clazz = loader.loadByte(classBytes);
		try {
			Method method = clazz.getMethod("main", new Class[] { String[].class });
			method.invoke(null, new String[] { null });
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}

	}

}
