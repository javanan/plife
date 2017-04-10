package com.jlife.sys;

import com.jlife.sys.config.DataScopeEnum;
import org.junit.Test;

/**
 * Created by chenjianan on 2017/3/1-19:38.
 * <p>
 * Describe:
 */
public class EunmDoTest {
    @Test
    public  void getName(){
        System.out.println("getName==enum.属性名获取英文名--》"+DataScopeEnum.DATA_SCOPE_ALL.name());
    }

    @Test
    public  void getValueByName(){
        System.out.println("getValueByName==enum.属性名获取英文名.getValue()获取中文名（值）--》"+DataScopeEnum.DATA_SCOPE_ALL.getValue());
    }

    @Test
    public  void getValues(){
      for (DataScopeEnum scopeEnum:DataScopeEnum.values()){
          System.out.println("getValues==ENUM.values()获取所有值--》"+scopeEnum);
      }
    }

    @Test
    public  void getNameByString(){
        System.out.println("getNameByString enum.valueOf(stringname)string转enum--》"+DataScopeEnum.valueOf("DATA_SCOPE_ALL"));
    }

    @Test
    public  void getNameByValue(){
        System.out.println("getNameByValue enum.valueOf(stringname)中文名转英文--》"+DataScopeEnum.getNameByValue("仅本人数据"));
    }
}
