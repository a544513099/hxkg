package com.util;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.CoreConnectionPNames;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <b>类名称：</b>HttpUtil
 * <b>类描述：</b>Http请求工具类
 * <b>创建人：</b>ChenSong
 * <b>修改人：</b>ChenSong
 * <b>修改时间：</b>2016-8-2 上午11:08:09
 * <b>修改备注：</b>
 * @version v1.0<br/>
 */
public class HttpUtil {

    private static Logger log = LoggerFactory.getLogger(HttpUtil.class);

    /** 默认编码方式 -UTF8 */
    private static final String DEFAULT_ENCODE = "utf-8";

    /**
     * 构造方法
     */
    public HttpUtil() {
        // empty constructor for some tools that need an instance object of the
        // class
    }

    /**
     * GET请求, 结果以字符串形式返回.
     *
     * @param url
     *            请求地址
     * @return 内容字符串
     */
    public static String getUrlAsString(String url) throws Exception {
        return getUrlAsString(url, null, DEFAULT_ENCODE);
    }

    /**
     * GET请求, 结果以字符串形式返回.
     *
     * @param url
     *            请求地址
     * @param params
     *            请求参数
     * @return 内容字符串
     */
    public static String getUrlAsString(String url, Map<String, String> params)
            throws Exception {
        return getUrlAsString(url, params, DEFAULT_ENCODE);
    }

    /**
     * GET请求, 结果以字符串形式返回.
     *
     * @param url
     *            请求地址
     * @param params
     *            请求参数
     * @param encode
     *            编码方式
     * @return 内容字符串
     */
    public static String getUrlAsString(String url, Map<String, String> params,
                                        String encode) throws Exception {
        // 开始时间
        long t1 = System.currentTimeMillis();
        // 获得HttpGet对象
        HttpGet httpGet = getHttpGet(url, params, encode);
        // 调试信息
        log.debug("url:" + url);
        log.debug("params:" + params.toString());
        log.debug("encode:" + encode);
        // 发送请求
        String result = executeHttpRequest(httpGet, null);
        // 结束时间
        long t2 = System.currentTimeMillis();
        // 调试信息
        log.debug("result:" + result);
        log.debug("consume time:" + ((t2 - t1)));
        // 返回结果
        return result;
    }

    /**
     * POST请求, 结果以字符串形式返回.
     *
     * @param url
     *            请求地址
     * @return 内容字符串
     */
    public static String postUrlAsString(String url) throws Exception {
        return postUrlAsString(url, null, null, null);
    }

    /**
     * POST请求, 结果以字符串形式返回.
     *
     * @param url
     *            请求地址
     * @param params
     *            请求参数
     * @return 内容字符串
     */
    public static String postUrlAsString(String url, Map<String, String> params)
            throws Exception {
        return postUrlAsString(url, params, null, null);
    }

    /**
     * POST请求, 结果以字符串形式返回.
     *
     * @param url
     *            请求地址
     * @param params
     *            请求参数
     * @param reqHeader
     *            请求头内容
     * @return 内容字符串
     * @throws Exception
     */
    public static String postUrlAsString(String url,
                                         Map<String, String> params, Map<String, String> reqHeader)
            throws Exception {
        return postUrlAsString(url, params, reqHeader, null);
    }

    /**
     * POST请求, 结果以字符串形式返回.
     *
     * @param url
     *            请求地址
     * @param params
     *            请求参数
     * @param reqHeader
     *            请求头内容
     * @param encode
     *            编码方式
     * @return 内容字符串
     * @throws Exception
     */
    public static String postUrlAsString(String url,
                                         Map<String, String> params, Map<String, String> reqHeader,
                                         String encode) throws Exception {
        // 开始时间
        long t1 = System.currentTimeMillis();
        // 获得HttpPost对象
        HttpPost httpPost = getHttpPost(url, params, encode);
        // 发送请求
        String result = executeHttpRequest(httpPost, reqHeader);
        // 结束时间
        long t2 = System.currentTimeMillis();
        // 调试信息
        log.debug("url:" + url);
        log.debug("params:" + params.toString());
        log.debug("reqHeader:" + reqHeader);
        log.debug("encode:" + encode);
        log.debug("result:" + result);
        log.debug("consume time:" + ((t2 - t1)));
        // 返回结果
        return result;
    }

    /**
     * 获得HttpGet对象
     *
     * @param url
     *            请求地址
     * @param params
     *            请求参数
     * @param encode
     *            编码方式
     * @return HttpGet对象
     */
    private static HttpGet getHttpGet(String url, Map<String, String> params,
                                      String encode) {
        StringBuffer buf = new StringBuffer(url);
        if (params != null) {
            // 地址增加?或者&
            String flag = (url.indexOf('?') == -1) ? "?" : "&";
            // 添加参数
            for (String name : params.keySet()) {
                buf.append(flag);
                buf.append(name);
                buf.append("=");
                try {
                    String param = params.get(name);
                    if (param == null) {
                        param = "";
                    }
                    buf.append(URLEncoder.encode(param, encode));
                } catch (UnsupportedEncodingException e) {
                    log.error("URLEncoder Error,encode=" + encode + ",param="
                            + params.get(name), e);
                }
                flag = "&";
            }
        }
        HttpGet httpGet = new HttpGet(buf.toString());
        return httpGet;
    }

    /**
     * 获得HttpPost对象
     *
     * @param url
     *            请求地址
     * @param params
     *            请求参数
     * @param encode
     *            编码方式
     * @return HttpPost对象
     */
    private static HttpPost getHttpPost(String url, Map<String, String> params,
                                        String encode) {
        HttpPost httpPost = new HttpPost(url);
        if (params != null) {
            List<NameValuePair> form = new ArrayList<NameValuePair>();
            for (String name : params.keySet()) {
                form.add(new BasicNameValuePair(name, params.get(name)));
            }
            try {
                UrlEncodedFormEntity entity = new UrlEncodedFormEntity(form,
                        encode);
                httpPost.setEntity(entity);
            } catch (UnsupportedEncodingException e) {
                log.error("UrlEncodedFormEntity Error,encode=" + encode
                        + ",form=" + form, e);
            }
        }
        return httpPost;
    }

    /**
     * 执行HTTP请求
     *
     * @param request
     *            请求对象
     * @param reqHeader
     *            请求头信息
     * @return 内容字符串
     */
    private static String executeHttpRequest(HttpUriRequest request,
                                             Map<String, String> reqHeader) throws Exception {
        HttpClient client = null;
        String result = null;
        try {
            // 创建HttpClient对象
            client = new DefaultHttpClient();
            // 设置连接超时时间
            client.getParams().setParameter(
                    CoreConnectionPNames.CONNECTION_TIMEOUT, 60);
            // 设置Socket超时时间
            client.getParams().setParameter(CoreConnectionPNames.SO_TIMEOUT,
                    36600);
            // 设置请求头信息
            if (reqHeader != null) {
                for (String name : reqHeader.keySet()) {
                    request.addHeader(name, reqHeader.get(name));
                }
            }
            // 获得返回结果
            HttpResponse response = client.execute(request);
            // 如果成功
            if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                result = EntityUtils.toString(response.getEntity());
            }
            // 如果失败
            else {
                StringBuffer errorMsg = new StringBuffer();
                errorMsg.append("httpStatus:");
                errorMsg.append(response.getStatusLine().getStatusCode());
                errorMsg.append(response.getStatusLine().getReasonPhrase());
                errorMsg.append(", Header: ");
                Header[] headers = response.getAllHeaders();
                for (Header header : headers) {
                    errorMsg.append(header.getName());
                    errorMsg.append(":");
                    errorMsg.append(header.getValue());
                }
                log.error("HttpResonse Error:" + errorMsg);
            }
        } catch (Exception e) {
            log.error("http连接异常", e);
            throw new Exception("http连接异常");
        } finally {
            try {
                client.getConnectionManager().shutdown();
            } catch (Exception e) {
                log.error("finally HttpClient shutdown error", e);
            }
        }
        return result;
    }

    /**
     * 下载文件保存到本地
     *
     * @param path
     *            文件保存位置
     * @param url
     *            远程文件地址
     * @throws IOException
     */
    public static void downloadFile(String url,String path) throws IOException {
        log.debug("path:" + path);
        log.debug("url:" + url);
        HttpClient client = null;
        try {
            // 创建HttpClient对象
            client = new DefaultHttpClient();
            // 获得HttpGet对象
            HttpGet httpGet = getHttpGet(url, null, null);
            // 发送请求获得返回结果
            HttpResponse response = client.execute(httpGet);
            // 如果成功
            if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                byte[] result = EntityUtils.toByteArray(response.getEntity());
                BufferedOutputStream bw = null;
                try {
                    // 创建文件对象
                    File f = new File(path);
                    // 创建文件路径
                    if (!f.getParentFile().exists())
                        f.getParentFile().mkdirs();
                    // 写入文件
                    bw = new BufferedOutputStream(new FileOutputStream(path));
                    bw.write(result);
                } catch (Exception e) {
                    log.error("保存文件错误,path=" + path + ",url=" + url, e);
                } finally {
                    try {
                        if (bw != null)
                            bw.close();
                    } catch (Exception e) {
                        log.error(
                                "finally BufferedOutputStream shutdown close",
                                e);
                    }
                }
            }
            // 如果失败
            else {
                StringBuffer errorMsg = new StringBuffer();
                errorMsg.append("httpStatus:");
                errorMsg.append(response.getStatusLine().getStatusCode());
                errorMsg.append(response.getStatusLine().getReasonPhrase());
                errorMsg.append(", Header: ");
                Header[] headers = response.getAllHeaders();
                for (Header header : headers) {
                    errorMsg.append(header.getName());
                    errorMsg.append(":");
                    errorMsg.append(header.getValue());
                }
                log.error("HttpResonse Error:" + errorMsg);
            }
        } catch (ClientProtocolException e) {
            log.error("下载文件保存到本地,http连接异常,path=" + path + ",url=" + url, e);
            throw e;
        } catch (IOException e) {
            log.error("下载文件保存到本地,文件操作异常,path=" + path + ",url=" + url, e);
            throw e;
        } finally {
            try {
                client.getConnectionManager().shutdown();
            } catch (Exception e) {
                log.error("finally HttpClient shutdown error", e);
            }
        }
    }
    
    /**
     * 获取客户端ip
     * @param request
     * @return
     */
    public static String getIp(HttpServletRequest request) {
    	String ip = request.getHeader("X-Forwarded-For");
    	if(StringUtils.isNotEmpty(ip) && !"unKnown".equalsIgnoreCase(ip)){
    		//多次反向代理后会有多个ip值，第一个ip才是真实ip
    		int index = ip.indexOf(",");
    		if(index != -1){
    			return ip.substring(0,index);
    		}else{
    			return ip;
    		}
    	}
    	ip = request.getHeader("X-Real-IP");
    	if(StringUtils.isNotEmpty(ip) && !"unKnown".equalsIgnoreCase(ip)){
    		return ip;
    	}
    	return request.getRemoteAddr();
    }

    public static void main(String[] args) throws IOException {
    }
}