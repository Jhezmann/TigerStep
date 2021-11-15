package com.tyrone.tigerstep.basic;

import org.json.JSONArray;

import java.math.BigDecimal;

public class Arr {
    private JSONArray jArr;

    public int length = jArr.length();

    /**
     * 构造空数组
     */
    public Arr(){//
        this.jArr = new JSONArray();
    }

    /**
     * 通过JSONArray文本构造数组
     * @param str
     */
    public Arr(String str){//
        try{
            if(str.isEmpty()||str==null){
                jArr = new JSONArray();
            }else{
                jArr = new JSONArray(str);
            }
        }catch(Exception e){
            e.printStackTrace();
            jArr = new JSONArray();
        }
    }

    /**
     * 通过String数组构建数组
     * @param str
     */
    public Arr(String[] str){//
        Arr rs=new Arr();
        for(int i=0;i<str.length;i++)rs.add(str[i]);
        this.jArr=rs.jArr;
    }

    /**
     * 以JSONArray数组创建数组
     * @param jsonArr
     */
    public Arr(JSONArray jsonArr){//
        if(jArr == null) jArr = new JSONArray();
        this.jArr = jsonArr;
    }

    /**
     * 通过Arr构造数组
     * @param arr
     */
    public Arr(Arr arr){
        this(arr.toJSONArr());
    }


    public JSONArray toJSONArr() {
        return this.jArr;
    }

    /**
     * 数组最后新增字符串记录
     * @param str
     * @return
     */
    public Arr add(String str){
        this.jArr.put(str);
        return this;
    }

    /**
     * 新增数值记录到数组
     * @param x
     * @return
     */
    public Arr add(int x){
        return add(String.valueOf(x));
    }
    public Arr add(double x){
        x += 0.0;
        BigDecimal bd = new BigDecimal(x);
        bd = bd.setScale(8, BigDecimal.ROUND_HALF_UP);
        return add(String.valueOf(bd));
    }
    public Arr add(double x, int precision){
        x += 0.0;
        BigDecimal bd = new BigDecimal(x);
        bd = bd.setScale(precision, BigDecimal.ROUND_HALF_UP);
        return add(String.valueOf(bd));
    }
    public Arr add(long x){
        return add(String.valueOf(x));
    }

    /**
     * 新增Obj对象到数组
     * @param obj
     * @return
     */
    public Arr add(Obj obj){
        return add(obj.text());
    }

    /**
     * 指定下标处新增字符串
     * @param index
     * @param str
     * @return
     */
    public Arr add(int index, String str){
        if(index<0)index = 0;
        if(index>this.length)index = this.length-1;
        for (int i = this.length; i > index; i++) {
            set(i,get(i-1));
        }
        set(index,str);
        return this;
    }

    /**
     * 指定下标处新增数值
     * @param index
     * @param x
     * @return
     */
    public Arr add(int index, int x){
        this.jArr.put(index, x);
        return this;
    }
    public Arr add(int index, double x){
        x += 0.0;
        BigDecimal bd = new BigDecimal(x);
        bd = bd.setScale(8, BigDecimal.ROUND_HALF_UP);
        this.jArr.put(index, bd);
        return this;
    }
    public Arr add(int index, double x, int precision){
        x += 0.0;
        BigDecimal bd = new BigDecimal(x);
        bd = bd.setScale(precision, BigDecimal.ROUND_HALF_UP);
        return add(index, String.valueOf(bd));
    }
    public Arr add(int index, long x){
        return add(index, String.valueOf(x));
    }

    /**
     * 指定下标处新增Obj对象
     * @param index
     * @param obj
     * @return
     */
    public Arr add(int index, Obj obj){
        return add(index, obj.text());
    }

    /**
     * 指定下标处写入字符串
     * @param index
     * @param str
     * @return
     */
    public Arr set(int index, String str){
        this.jArr.put(index, str);
        return this;
    }

    /**
     * 指定下标处写入数值
     * @param index
     * @param x
     * @return
     */
    public Arr set(int index, int x){
        return set(index, String.valueOf(x));
    }
    public Arr set(int index, double x){
        x += 0.0;
        BigDecimal bd = new BigDecimal(x);
        bd = bd.setScale(8, BigDecimal.ROUND_HALF_UP);
        return set(index, bd.toPlainString());
    }
    public Arr set(int index, double x, int precision){
        x += 0.0;
        BigDecimal bd = new BigDecimal(x);
        bd = bd.setScale(precision, BigDecimal.ROUND_HALF_UP);
        return set(index, bd.toPlainString());
    }
    public Arr set(int index, long x){
        return set(index, String.valueOf(x));
    }

    /**
     * 指定下标处写入Obj对象
     * @param index
     * @param obj
     * @return
     */
    public Arr set(int index, Obj obj){
        return set(index, obj.text());
    }

    /**
     * 删除指定下标的记录
     * @param index
     * @return
     */
    public Arr delete(int index){
        this.jArr.remove(index);
        return this;
    }

    /**
     * 移动指定下标A的记录到指定下标B
     * @param indexA
     * @param indexB
     * @return
     */
    public Arr move(int indexA, int indexB){
        add(indexB,get(indexA));
        if(indexA>indexB)indexA+=1;
        delete(indexA);
        return this;
    }

    /**
     * 读取指定下标的数据
     * @param index
     * @return
     */
    public String get(int index){
        return this.jArr.optString(index);
    }
    public int getInt(int index){
        return this.jArr.optInt(index);
    }
    public double getDouble(int index){
        return this.jArr.optDouble(index);
    }
    public long getLong(int index){
        return this.jArr.optLong(index);
    }
    public Obj getObj(int index){
        return new Obj(this.jArr.optString(index));
    }

    /**
     * 在当前数组后拼接另一段数组
     * @param arr
     * @return
     */
    public Arr combine(Arr arr){
        for (int i = 0; i < arr.length; i++) {
            this.add(arr.get(i));
        }
        return this;
    }

    /**
     * 拼接两组数组
     * @param arrA
     * @param arrB
     * @return
     */
    public Arr combine(Arr arrA, Arr arrB){
        for (int i = 0; i < arrB.length; i++) {
            arrA.add(arrB.get(i));
        }
        return this;
    }

    /**
     * 转字符串
     * @return
     */
    public String text(){
        return this.jArr.toString();
    }
}