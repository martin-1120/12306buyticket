package com.buyticket.core;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Properties;
 
public class PropertiesUtil extends Properties {
 
   private static final long serialVersionUID = 1L;
 
   private ListEnumerationAdapter<Object> keyList = new ListEnumerationAdapter<Object>();
  
   /**
    * 默认构造方法
    */
   public PropertiesUtil() {
     
   }
  
   /**
    * 从指定路径加载信息到Properties
    * @param path
    */
   public PropertiesUtil(String path) {
      try {
         InputStream is = new FileInputStream(path);
         this.load(is);
      } catch (FileNotFoundException e) {
         e.printStackTrace();
         throw new RuntimeException("指定文件不存在！");
      } catch (IOException e) {
         e.printStackTrace();
      }
   }
  
   /**
    * 重写put方法，按照property的存入顺序保存key到keyList，遇到重复的后者将覆盖前者。
    */
   @Override
   public synchronized Object put(Object key, Object value) {
      if (keyList.contains(key)) {
         keyList.remove(key);
      }
      keyList.add(key);
      return super.put(key, value);
   }
  
   /**
    * 获取Properties中key的有序集合
    * @return
    */
   public List<Object> getKeyList() {
      return keyList;
   }
  
   /**
    * 保存Properties到指定文件，默认使用UTF-8编码
    * @param path 指定文件路径
    */
   public void store(String path) {
      this.store(path, "UTF-8");
   }
  
   /**
    * 保存Properties到指定文件，并指定对应存放编码
    * @param path 指定路径
    * @param charset 文件编码
    */
   public void store(String path, String charset) {
      if (path != null && !"".equals(path)) {
         try {
            OutputStream os = new FileOutputStream(path);
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(os, charset));
            this.store(bw, null);
            bw.close();
         } catch (FileNotFoundException e) {
            e.printStackTrace();
         } catch (IOException e) {
            e.printStackTrace();
         }
      } else {
         throw new RuntimeException("存储路径不能为空!");
      }
   }
 
   /**
    * 重写keys方法
    */
   @Override
   public synchronized Enumeration<Object> keys() {
      keyList.reset();
      return keyList;
   }
   
   /**
    * ArrayList到Enumeration的适配器
    */
    private static class ListEnumerationAdapter<T> extends ArrayList<T> implements Enumeration<T> {
      private static final long serialVersionUID = 1L;
      private int index = 0;
     
      public boolean hasMoreElements() {
         return index < this.size();
      }
 
      public T nextElement() {
         if (this.hasMoreElements()) {
            return this.get(index++);
         }
         return null;
      }
     
      /**
       * 重置index的值为0，使得Enumeration可以继续从头开始遍历
       */
      public void reset() {
         this.index = 0;
      }
    }
}