package com.young.springbootkafka.commontest.langtext;

import org.apache.commons.collections4.BidiMap;
import org.apache.commons.collections4.bidimap.DualHashBidiMap;
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
