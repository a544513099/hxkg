package com.util;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 接口返回信息
 * 
 */
public class ResultMsg {
    private static final Logger log = LoggerFactory.getLogger(ResultMsg.class);
    private Long result;
    private String desc;
    private Map body = new HashMap();
    
    /**
     * 返回ret为0的信息
     * @param desc
     * @return
     */
    public static ResultMsg success(String desc) {
        return desc(0l, desc);
    }

    /**
     * 返回ret为0的信息
     * @param desc
     * @param body
     * @return
     */
    public static ResultMsg success(String desc, Map body) {
        return desc(0l, desc, body);
    }

    public static ResultMsg success(String desc, Object... params) {
        return desc(0l, desc, params);
    }

    public static ResultMsg desc(Long result, String desc) {
        ResultMsg rm = new ResultMsg();
        rm.setResult(result);
        rm.setDesc(desc);
        return rm;
    }

    /**
     * ResultMsg.desc(-1l,"成功","key1","value1","key2","value2");
     * @param ret
     * @param desc
     * @param params 这里参数为key、value可变长数组
     * @return
     */
    public static ResultMsg desc(Long result, String desc, Object... params) {
        ResultMsg rm = desc(result, desc);
        Map body = rm.getBody();
        if (params.length % 2 == 0) {
            for (int i = 0; i < params.length; i += 2) {
                Object param = params[i];
                Object paramValue = params[i + 1];
                body.put(param, paramValue);
            }
        } else {
            log.error("参数必须为偶数个，符合Key/Value");
        }
        return rm;
    }

    public static ResultMsg desc(Long result, String desc, Map body) {
        ResultMsg rm = desc(result, desc);
        rm.setBody(body);
        return rm;
    }

    public Long getResult() {
        return result;
    }

    public void setResult(Long result) {
        this.result = result;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Map getBody() {
        return body;
    }

    public void setBody(Map body) {
        this.body = body;
    }

    @Override
    public String toString() {
        return "ResultMsg{" +
                "result=" + result +
                ", desc='" + desc + '\'' +
                ", body=" + body +
                '}';
    }
}
