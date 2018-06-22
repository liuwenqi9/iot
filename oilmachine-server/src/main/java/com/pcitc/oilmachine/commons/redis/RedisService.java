package com.pcitc.oilmachine.commons.redis;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;

public class RedisService<K extends Serializable, V > {
	
	private RedisTemplate<?, ?> redisTemplate;
	
	/**
	 * 
	 * @Description:存入
	 * @throws
	 * @param 
	 * @return boolean
	 * @author zizhi.zhang
	 * @date 2016年11月11日 下午3:47:27
	 */
	@SuppressWarnings("unchecked")
	public Boolean put(final K key,final V value) throws Exception{
		final RedisSerializer<K> keySerializer = (RedisSerializer<K>) redisTemplate.getKeySerializer();
		final RedisSerializer<V> valueSerializer = (RedisSerializer<V>) redisTemplate.getValueSerializer();
		return redisTemplate.execute(new RedisCallback<Boolean>(){
			@Override
			public Boolean doInRedis(RedisConnection connection)
					throws DataAccessException {
				connection.set(keySerializer.serialize(key),valueSerializer.serialize(value));
				return true;
			}
		});
	}
	
	/**
	 * 
	 * @Description:取出
	 * @throws
	 * @param 
	 * @return boolean
	 * @author zizhi.zhang
	 * @date 2016年11月11日 下午3:47:27
	 */
	@SuppressWarnings("unchecked")
	public V get(final K key) throws Exception{
		final RedisSerializer<K> keySerializer = (RedisSerializer<K>) redisTemplate.getKeySerializer();
		final RedisSerializer<V> valueSerializer = (RedisSerializer<V>) redisTemplate.getValueSerializer();
		return redisTemplate.execute(new RedisCallback<V>() {
			@Override
			public V doInRedis(RedisConnection connection)
					throws DataAccessException {
				byte[] vb = connection.get(keySerializer.serialize(key));
				return valueSerializer.deserialize(vb);
			}
		});
	}
	
	/**
	 * 
	 * @Description:删除
	 * @throws
	 * @param 
	 * @return boolean
	 * @author zizhi.zhang
	 * @date 2016年11月11日 下午3:47:27
	 */
	@SuppressWarnings("unchecked")
	public boolean del(final K k) throws Exception{
		final RedisSerializer<K> keySerializer = (RedisSerializer<K>) redisTemplate.getKeySerializer();
		Long re =  redisTemplate.execute(new RedisCallback<Long>() {
			@Override
			public Long doInRedis(RedisConnection connection)
					throws DataAccessException {
				return connection.del(keySerializer.serialize(k));
			}
		});
		return re >= 0?true:false;
	}

	
	/**
	 * 
	 * @Description:从redis 队列尾部取一条数据，并删除该数据
	 * @throws
	 * @param 
	 */
	@SuppressWarnings("unchecked")
	public V lpop(final K key) throws Exception{
		final RedisSerializer<K> keySerializer = (RedisSerializer<K>) redisTemplate.getKeySerializer();
		final RedisSerializer<V> valueSerializer = (RedisSerializer<V>) redisTemplate.getValueSerializer();
		return redisTemplate.execute(new RedisCallback<V>() {
			@Override
			public V doInRedis(RedisConnection connection)
					throws DataAccessException {
				byte[] vb = connection.lPop(keySerializer.serialize(key));
				return valueSerializer.deserialize(vb);
			}
		});
	}
	
	
	/**
	 * 
	 * @Description:判断key队列，总数
	 * @throws
	 * @param 
	 */
	@SuppressWarnings("unchecked")
	public Long llength(final K key) throws Exception{
		final RedisSerializer<K> keySerializer = (RedisSerializer<K>) redisTemplate.getKeySerializer();
		return redisTemplate.execute(new RedisCallback<Long>() {
			@Override
			public Long doInRedis(RedisConnection connection)
					throws DataAccessException {
				Long l = connection.lLen(keySerializer.serialize(key));
				return l;
			}
		});
	}
	
	/**
	 * 
	 * @Description:队列头部插入一条数据
	 * @throws
	 * @param 
	 */
	@SuppressWarnings("unchecked")
	public Long lpush(final K key,final V value) throws Exception{
		final RedisSerializer<K> keySerializer = (RedisSerializer<K>) redisTemplate.getKeySerializer();
		final RedisSerializer<V> valueSerializer = (RedisSerializer<V>) redisTemplate.getValueSerializer();
		return redisTemplate.execute(new RedisCallback<Long>() {
			@Override
			public Long doInRedis(RedisConnection connection)
					throws DataAccessException {
				Long l = connection.lPush(keySerializer.serialize(key),valueSerializer.serialize(value));
				return l;
			}
		});
	}
	
	/**
	 * 
	 * @Description:向名称为key的hash中添加元素field<—>value
	 * @throws
	 * @param 
	 */
	@SuppressWarnings("unchecked")
	public Boolean hset(final K key,final K field,final V value) throws Exception{
		final RedisSerializer<K> keySerializer = (RedisSerializer<K>) redisTemplate.getKeySerializer();
		final RedisSerializer<V> valueSerializer = (RedisSerializer<V>) redisTemplate.getHashValueSerializer();
		final RedisSerializer<K> fieldSerializer = (RedisSerializer<K>) redisTemplate.getKeySerializer();
		return redisTemplate.execute(new RedisCallback<Boolean>() {
			@Override
			public Boolean doInRedis(RedisConnection connection)
					throws DataAccessException {
				Boolean b = connection.hSet(keySerializer.serialize(key),fieldSerializer.serialize(field),valueSerializer.serialize(value));
				return b;
			}
		});
	}
	
	/**
	 * 
	 * @Description:删除哈希表key中的一个指定域，不存在的域将被忽略。
	 * @throws
	 * @param 
	 */
	@SuppressWarnings("unchecked")
	public Long hdel(final K key,final K field) throws Exception{
		final RedisSerializer<K> keySerializer = (RedisSerializer<K>) redisTemplate.getKeySerializer();
		final RedisSerializer<K> fieldSerializer = (RedisSerializer<K>) redisTemplate.getKeySerializer();
		return redisTemplate.execute(new RedisCallback<Long>() {
			@Override
			public Long doInRedis(RedisConnection connection)
					throws DataAccessException {
				Long l = connection.hDel(keySerializer.serialize(key),fieldSerializer.serialize(field));
				return l;
			}
		});
	}
	
	/**
	 * 
	 * @Description:返回名称为key的hash中field对应的value
	 * @throws
	 * @param 
	 */
	@SuppressWarnings("unchecked")
	public V hget(final K key,final K field) throws Exception{
		final RedisSerializer<K> keySerializer = (RedisSerializer<K>) redisTemplate.getKeySerializer();
		final RedisSerializer<V> valueSerializer = (RedisSerializer<V>) redisTemplate.getHashValueSerializer();
		final RedisSerializer<K> fieldSerializer = (RedisSerializer<K>) redisTemplate.getKeySerializer();
		return redisTemplate.execute(new RedisCallback<V>() {
			@Override
			public V doInRedis(RedisConnection connection)
					throws DataAccessException {
				byte[] vb = connection.hGet(keySerializer.serialize(key),fieldSerializer.serialize(field));
				return valueSerializer.deserialize(vb);
			}
		});
	}
	
	
	/**
	 * 
	 * @Description:返回名称为key的hash中元素个数
	 * @throws
	 * @param 
	 */
	@SuppressWarnings("unchecked")
	public Long hlen(final K key) throws Exception{
		final RedisSerializer<K> keySerializer = (RedisSerializer<K>) redisTemplate.getKeySerializer();
		return redisTemplate.execute(new RedisCallback<Long>() {
			@Override
			public Long doInRedis(RedisConnection connection)
					throws DataAccessException {
				Long l = connection.hLen(keySerializer.serialize(key));
				return l;
			}
		});
	}
	
	/**
	 * 
	 * @Description:查找所有符合给定模式( pattern)的 key 
	 * @throws
	 * @param 
	 */
	@SuppressWarnings({ "unchecked"})
	public Set<K> keys(final K key) throws Exception{
		final RedisSerializer<K> keySerializer = (RedisSerializer<K>) redisTemplate.getKeySerializer();
		return redisTemplate.execute(new RedisCallback<Set<K>>() {
			@Override
			public Set<K> doInRedis(RedisConnection connection)
					throws DataAccessException {
				Set<byte[]> vblist = connection.keys(keySerializer.serialize(key));
				Set<K> set = new HashSet<K>();
				for(byte[] b:vblist){
					set.add(keySerializer.deserialize(b));
				}
				return set;
			}
		});
	}
	
	public RedisTemplate<?, ?> getRedisTemplate() {
		return redisTemplate;
	}

	public void setRedisTemplate(RedisTemplate<?, ?> redisTemplate) {
		this.redisTemplate = redisTemplate;
	}
}
