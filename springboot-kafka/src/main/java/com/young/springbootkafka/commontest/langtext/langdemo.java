package com.young.springbootkafka.commontest.langtext;

import org.apache.commons.collections.BidiMap;
import org.apache.commons.collections.MultiMap;
import org.apache.commons.collections.bidimap.DualHashBidiMap;
import org.apache.commons.collections.map.MultiValueMap;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.Map;

public class langdemo {
    public static void main(String[] args) {
        /**
         * value取key
         */
        System.out.println(StringUtils.center("demoBidiMap",80,"="));
        BidiMap bidiMap=new DualHashBidiMap();
        bidiMap.put("SH","SHANGHAI");
        bidiMap.put("CD","CHENGDU");
        bidiMap.put("BJ","CHENGDU");
        bidiMap.put("SH","CHANGZHOU");
        System.out.println("KEY-VALUE:BJ  "+bidiMap.get("SH"));
        System.out.println("VALUE-KEY:CHENGDU  "+bidiMap.getKey("CHENGDU"));
        System.out.println(StringUtils.repeat("==",40));

        /**
         * 构造Map<String,Collection>
         */
        System.out.println(StringUtils.center("MultiMap",80,"="));
        MultiMap multiMap=new MultiValueMap();
        multiMap.put("SH","SHANGHAI");
        multiMap.put("CD","CHENGDU");
        multiMap.put("BJ","CHENGDU");
        multiMap.put("SH","CHANGZHOU");
        System.out.println("key:SH: "+multiMap.get("SH"));
        System.out.println(StringUtils.repeat("==",40));

        System.out.println(StringUtils.repeat("==",40));
        Map colorMap = ArrayUtils.toMap(new String[][] {
                {"RED", "#FF0000"},
                {"GREEN", "#00FF00"},
                {"BLUE", "#0000FF"}
        });
        System.out.println(colorMap.toString());
        System.out.println(StringUtils.repeat("==",40));

/*        System.out.println(StringUtils.repeat("==",40));

        System.out.println(StringUtils.repeat("==",40));*/

        System.out.println(StringUtils.repeat("==",40));

        System.out.println(StringUtils.repeat("==",40));
    }
}
