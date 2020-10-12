package com.feelingtouch.Algorithm;


public class Test {

	static final int MAXIMUM_CAPACITY = 1 << 30;
    static final int tableSizeFor(int cap) {
        int n = cap - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
    }
    
    static final int HASH_BITS = 0x7fffffff;
    static final int spread(int h) {
        return (h ^ (h >>> 16)) & HASH_BITS;
    }
	
    
    public static class MyRunnable implements Runnable {
    	 private ThreadLocal threadLocal = new ThreadLocal();
    	 private ThreadLocal threadLocal2 = new ThreadLocal();
    	 private int k = 0;
    	 
    	 @Override
    	 public void run() {
	    	 //一旦创建了一个ThreadLocal变量，你可以通过如下代码设置某个需要保存的值
	    	 threadLocal.set((int) (Math.random() * 100D));
	    	 threadLocal2.set((int) (Math.random() * 100D));
	    	 k = 1;
	    	 try {
	    		 Thread.sleep(2000);
	    	 } catch (InterruptedException e) {
	    	 }
	    	 //可以通过下面方法读取保存在ThreadLocal变量中的值
	    	 System.out.println("-------threadLocal value-------"+threadLocal.get());
	    	 System.out.println("-------threadLocal2 value-------"+threadLocal2.get());
    	 }
    }
    
	public static void main(String[] args) {
		
		MyRunnable sharedRunnableInstance = new MyRunnable();
		Thread thread1 = new Thread(sharedRunnableInstance);
		Thread thread2 = new Thread(sharedRunnableInstance);
		thread1.start();
		thread2.start();

//		AtomicInteger a = new AtomicInteger(0);
//		
//		for(int i=0; i<2; i++){
//			new Thread(new Runnable() {
//				
//				@Override
//				public void run() {
//					a.getAndIncrement();
//				}
//			}).start();
//		}
		
		
		
		
//		System.out.println(LeetCode.spread(65539));
		
//		Map<Integer, Integer> map = new HashMap<>();
//		for(int i=0; i<10; i++){
//			int j = 64*i+1;
////			int j = i;
//			map.put(j, i);
////			map.get(j);
//		}
//		
//		Iterator<Entry<Integer, Integer>> itr = map.entrySet().iterator();
//		while(itr.hasNext()){
//			Entry<Integer, Integer> entry = itr.next();
//			System.out.println(entry.getKey());
//		}
		
//		System.out.println(LeetCode.tableSizeFor(4682));
//		int i = 1000>>> 2;
//		System.out.println(i);
//		
//		String template = "[localize msg_war_ownarea {0} {1} {2}]";
//		String content = MessageFormat.format(template, "\\[\\[ABCD", "abcd", "123");
//		System.out.println(content);
		try {
			Thread.sleep(Integer.MAX_VALUE);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
