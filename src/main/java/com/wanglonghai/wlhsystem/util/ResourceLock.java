package com.wanglonghai.wlhsystem.util;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/** 
 * 
 * 实体资源锁,防止多个线程操作同一个资源的锁,根据实体ID生成唯一锁,前提是实体ID的字符串唯一性 只适用于资源同时操作数量不多的系统
* (注意本锁只是单机版，并不能解决集群实例下的锁)
* @author jary
*/
public class ResourceLock {
	/**
	 * 公告读取锁
	 */
	public static String NOTICE_READ_LOCK="notice_read_lock";
	
	// 初始化ConcurrentHashMap锁载体
	private static final ConcurrentHashMap<String, AtomicInteger> lockMap = new ConcurrentHashMap<String, AtomicInteger>();

	/**
	 * 执行锁
	 * @param key
	 * @param sourceId
	 * @param service
	 * @return
	 */
	public static Object doLock(String key,String sourceId,IService service) {
		try {
			AtomicInteger resource = ResourceLock.getAtomicInteger(key,sourceId);
			synchronized (resource) {// 防止多个线程同时操作数据同一条实体数据
				return service.service();
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			ResourceLock.giveUpAtomicInteger(key,sourceId);
		}
		return null;
	}
	/**
	 * 执行锁
	 * @param key
	 * @param sourceId
	 * @param service
	 * @return
	 */
//	public static Object doLock(String key,String sourceId,IService service) {
//		Lock lock = null;
//		try {
//			AtomicInteger resource = ResourceLock.getAtomicInteger(key,sourceId);
//			lock = new ReentrantLock();
//			
//			return service.service();
//		}catch (Exception e) {
//			e.printStackTrace();
//		}finally {
//			ResourceLock.giveUpAtomicInteger(key,sourceId);
//		}
//		return null;
//	}
	/**
	 * 获得锁
	 * @param key 锁名称
	 * @param sourceId 需要上锁的资源
	 * @return
	 */
	public static AtomicInteger getAtomicInteger(String key,String sourceId) {
		key = key+":"+sourceId;
		if (lockMap.get(key) == null) {// 当实体ID锁资源为空,初始化锁
			lockMap.putIfAbsent(key, new AtomicInteger(0));// 初始化一个竞争数为0的原子资源
		}
		int count = lockMap.get(key).incrementAndGet();// 线程得到该资源,原子性+1
		//System.out.println("资源ID为:" + key + ",争抢线程数:" + count);
		return lockMap.get(key);// 返回该ID资源锁
	}

	/**
	 * 归还锁
	 * @param key 锁名称
	 * @param sourceId 需要还锁的资源
	 * @return
	 */
	public static void giveUpAtomicInteger(String key,String sourceId) {
		key = key+":"+sourceId;
		if (lockMap.get(key) != null) {// 当实体ID资源不为空,才可以操作锁,防止抛出空指针异常
			int source = lockMap.get(key).decrementAndGet();// 线程释放该资源,原子性-1
			if (source <= 0) {// 当资源没有线程竞争的时候，就删除掉该锁,防止内存溢出
				lockMap.remove(key);
				//System.out.println("资源ID为:" + key + "移除成功");
			}
			//System.out.println("资源ID为:" + key + ",争抢线程数:" + source);
		}
	}

}
