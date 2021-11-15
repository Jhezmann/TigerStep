package com.tyrone.tigerstep.basic;

import java.math.BigDecimal;
import java.util.Iterator;
import org.json.JSONObject;

/**
 * 使用JsonObject格式塑造的
 */
public class Obj {
    private JSONObject jObj;

    //构造空对象
    public Obj(){
        this.jObj = new JSONObject();
    }

    /**
     * 通过String构造对象
     * @param str
     */
    public Obj(String str){
        try {
            if (str.isEmpty()||str==null){
                this.jObj = new JSONObject();
            } else {
                this.jObj=new JSONObject(str);
            }
        }catch (Exception e){
            this.jObj = new JSONObject();
        }
    }

    /**
     * 通过JSONObject构造对象
     * @param jsonObject
     */
    public Obj(JSONObject jsonObject){
        this.jObj = jsonObject;
    }

    public void setjObj(JSONObject jsonObject){
        this.jObj = jsonObject;
    }

    /**
     * 获取jObj对象
     * @return JSONObject
     */
    public JSONObject toJson(){
        return this.jObj;
    }

    /**
     * 设置String字符串
     * @param key
     * @param value
     * @return Obj
     */
    public Obj set(String key, String value){
        if (key.isEmpty()||key==null)return this;
        if (value.isEmpty())value = "";
        this.jObj.put(key,value);
        return this;
    }

    /**
     * 设置StringBuffer
     * @param key
     * @param value
     * @return Obj
     */
    public Obj set(String key, StringBuffer value){
        return this.set(key,value.toString());
    }

    /**
     * 设置int
     * @param key
     * @param value
     * @return Obj
     */
    public Obj set(String key, int value){
        return set(key, String.valueOf(value));
    }

    /**
     * 设置double类型（默认8位小数）
     * @param key
     * @param value
     * @return Obj
     */
    public Obj set(String key, double value){
        BigDecimal bd = new BigDecimal(value);
        if (bd.scale()>8) {
            bd = bd.setScale(8,BigDecimal.ROUND_HALF_UP);
        }
        return set(key,bd.toPlainString());
    }

    /**
     * 设置固定小数位的double类型
     * @param key
     * @param value
     * @param precision
     * @return
     */
    public Obj set(String key, double value, int precision){
        value += 0.0;
        BigDecimal bd = new BigDecimal(value);
        bd = bd.setScale(precision,BigDecimal.ROUND_HALF_UP);
        return set(key,bd.toPlainString());
    }

    /**
     * 设置长浮点
     * @param key
     * @param value
     * @return Obj
     */
    public Obj set(String key, long value){
        if (key.isEmpty()||key==null)return this;
        this.jObj.put(key,value);
        return this;
    }

    /**
     * 设置布尔值
     * @param key
     * @param value
     * @return Obj
     */
    public Obj set(String key, boolean value){
        if (key.isEmpty()||key==null)return this;
        this.jObj.put(key,value);
        return this;
    }

    /**
     * 设置对象
     * @param key
     * @param value
     * @return Obj
     */
    public Obj set(String key, Object value){
        if (key.isEmpty()||key==null)return this;
        this.jObj.put(key, value);
        return this;
    }

    /**
     * 设置Obj
     * @param key
     * @param obj
     * @return Obj
     */
    public Obj set(String key, Obj obj){
        if (key.isEmpty()||key==null)return this;
        this.jObj.put(key, obj.toJson());
        return this;
    }

    /**
     * 设置Arr
     * @param key
     * @param arr
     * @return
     */
    public Obj set(String key, Arr arr){
        if (key.isEmpty()||key==null)return this;
        this.jObj.put(key, arr.toJSONArr());
        return this;
    }

    /**
     * 获取指定下标的键文本
     * @param index
     * @return
     */
    public String key(int index){
        JSONObject jTemp = jObj;
        Iterator<String> keys = jTemp.keys();
        int x = 0;
        while (keys.hasNext()){
            String key = (String) keys.next();
            x+=1;
            if(x>index)return key;
        }
        return "";
    }

    /**
     * 获取所有的键
     * @return
     */
    public Arr keys(){
        JSONObject jTemp = jObj;
        Iterator<String> keys = jTemp.keys();
        Arr arr = new Arr();
        while (keys.hasNext()){
            String key = (String) keys.next();
            arr.add(key);
        }
        return arr;
    }

    public boolean hasKey(String key){
        if (key.isEmpty()||key==null)return false;
        Arr keys = this.keys();
        for (int i = 0; i < keys.length; i++) {
            if(key.equals(keys.get(i)))return true;
        }
        return false;
    }

    /**
     * 转字符串
     * @return
     */
    public String text(){
        return this.jObj.toString();
    }

}
