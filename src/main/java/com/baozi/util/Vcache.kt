package com.baozi.util

/**
 * @author wenjun.zhang
 * @create 2018-06-12 16:39
 * @description 模拟缓存，服务器没空间了没办法装redis等
 **/
class VCache {
    companion object {
        /**
         * 定义全局静态变量，用于缓存存储
         */
        val map: MutableMap<String, Any> = LinkedHashMap()

        /**
         * 存储
         */
        fun put(key:String,value:Any) = map.put(key,value)

        /**
         * 获取
         */
        fun get(key:String) = map.get(key)

        /**
         * 删除
         */
        fun delete(key:String) = map.remove(key)

        /**
         * size
         */
        fun size(key:String) = map.size

        /**
         * keys & values
         */
        fun keys() = map.keys
        fun values() = map.values

        /**
         * 添加一个值并且带ttl
         * @param ttl 时间（秒）
         */
        fun setex(key:String,value:Any,ttl:Int){
            map.put(key,value)
            object : Thread() {
                override fun run() {
                    println("running from Thread: ${Thread.currentThread()}")
                    sleep((ttl * 1000).toLong())
                    delete(key)
                }
            }.start()


        }
    }

}