package com.common;

/**
 * Created by wangyi  
 */
public class Constants {
    
    public static final int DCT_PAGE_SIZE = 20;//单词通每关词汇量
    
    public static final String DCT_JEDIS_STAR_KEY  = "JEDIS_STAR_KEY";  //单词通存放缓存的 用户对应关卡的星星数量的key的标识
   
    public static final String DCT_JEDIS_POINT_NUM  = "JEDIS_POINT_NUM";  //单词通存放缓存的 用户闯到多少关的key的标识
   
    public static final String DCT_JEDIS_NEAR_DAY  = "JEDIS_NEAR_DAY";  //单词通存放缓存的 用户最近闯关的日期的key的标识
  
    public static final String DCT_JEDIS_INSIST_DAY  = "JEDIS_INSIST_DAY";  //单词通存放缓存的 用户闯关坚持天数的key的标识
   
    public static final String DCT_JEDIS_IS_MORE_ONE  = "JEDIS_IS_MORE_ONE";  //单词通存放缓存的用户最近闯关时间是否超过一天的key的标识
    
    public static final String PKSTOREID  = "PKSTOREID_";  //PK关卡人数的key的标识
    
    public static final String COURSECOUNT  = "COURSECOUNT_";  //PK关卡人数的key的标识
    
    public static final String PK_EXTERNAL_REFERENCE_KEY = "PKREFERENCEKEY";  //H5跳转Pk凭证
    
}
