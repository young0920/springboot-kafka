package com.young.springbootkafka.commontest.utiltest;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 根据resultMap生成相应别名
 *
 * @Author yangbing
 * @Date 2020/9/18 2:48 下午
 */
public class GenerateAliases {
    public static void main(String[] args) {
        String s = "\t\t\t<id property=\"indocno\" column=\"INDOCNO\" jdbcType=\"VARCHAR\"/>\n" +
                "\t\t\t<result property=\"dmodt\" column=\"DMODT\" jdbcType=\"TIMESTAMP\"/>\n" +
                "\t\t\t<result property=\"dregt\" column=\"DREGT\" jdbcType=\"TIMESTAMP\"/>\n" +
                "\t\t\t<result property=\"gsqdcode\" column=\"GSQDCODE\" jdbcType=\"VARCHAR\"/>\n" +
                "\t\t\t<result property=\"gsqdnm\" column=\"GSQDNM\" jdbcType=\"VARCHAR\"/>\n" +
                "\t\t\t<result property=\"iattcount\" column=\"IATTCOUNT\" jdbcType=\"VARCHAR\"/>\n" +
                "\t\t\t<result property=\"ibuildprice\" column=\"IBUILDPRICE\" jdbcType=\"VARCHAR\"/>\n" +
                "\t\t\t<result property=\"icompanyid\" column=\"ICOMPANYID\" jdbcType=\"VARCHAR\"/>\n" +
                "\t\t\t<result property=\"icompanyno\" column=\"ICOMPANYNO\" jdbcType=\"VARCHAR\"/>\n" +
                "\t\t\t<result property=\"icurrentid\" column=\"ICURRENTID\" jdbcType=\"VARCHAR\"/>\n" +
                "\t\t\t<result property=\"idel\" column=\"IDEL\" jdbcType=\"VARCHAR\"/>\n" +
                "\t\t\t<result property=\"ideptid\" column=\"IDEPTID\" jdbcType=\"VARCHAR\"/>\n" +
                "\t\t\t<result property=\"ideptno\" column=\"IDEPTNO\" jdbcType=\"VARCHAR\"/>\n" +
                "\t\t\t<result property=\"idoctypeid\" column=\"IDOCTYPEID\" jdbcType=\"VARCHAR\"/>\n" +
                "\t\t\t<result property=\"iequipmentprice\" column=\"IEQUIPMENTPRICE\" jdbcType=\"VARCHAR\"/>\n" +
                "\t\t\t<result property=\"iinstallprice\" column=\"IINSTALLPRICE\" jdbcType=\"VARCHAR\"/>\n" +
                "\t\t\t<result property=\"ijsjjtarget\" column=\"IJSJJTARGET\" jdbcType=\"VARCHAR\"/>\n" +
                "\t\t\t<result property=\"ilengthUnit\" column=\"ILENGTH_UNIT\" jdbcType=\"VARCHAR\"/>\n" +
                "\t\t\t<result property=\"iline\" column=\"ILINE\" jdbcType=\"VARCHAR\"/>\n" +
                "\t\t\t<result property=\"ilinkno\" column=\"ILINKNO\" jdbcType=\"VARCHAR\"/>\n" +
                "\t\t\t<result property=\"iotherprice\" column=\"IOTHERPRICE\" jdbcType=\"VARCHAR\"/>\n" +
                "\t\t\t<result property=\"iparentid\" column=\"IPARENTID\" jdbcType=\"VARCHAR\"/>\n" +
                "\t\t\t<result property=\"ipostid\" column=\"IPOSTID\" jdbcType=\"VARCHAR\"/>\n" +
                "\t\t\t<result property=\"ipronum\" column=\"IPRONUM\" jdbcType=\"VARCHAR\"/>\n" +
                "\t\t\t<result property=\"isaveormodify\" column=\"ISAVEORMODIFY\" jdbcType=\"VARCHAR\"/>\n" +
                "\t\t\t<result property=\"isort\" column=\"ISORT\" jdbcType=\"VARCHAR\"/>\n" +
                "\t\t\t<result property=\"istate\" column=\"ISTATE\" jdbcType=\"VARCHAR\"/>\n" +
                "\t\t\t<result property=\"istepcharttype\" column=\"ISTEPCHARTTYPE\" jdbcType=\"VARCHAR\"/>\n" +
                "\t\t\t<result property=\"istepid\" column=\"ISTEPID\" jdbcType=\"VARCHAR\"/>\n" +
                "\t\t\t<result property=\"istepoperid\" column=\"ISTEPOPERID\" jdbcType=\"VARCHAR\"/>\n" +
                "\t\t\t<result property=\"itotalprice\" column=\"ITOTALPRICE\" jdbcType=\"VARCHAR\"/>\n" +
                "\t\t\t<result property=\"itotalpriceUs\" column=\"ITOTALPRICE_US\" jdbcType=\"VARCHAR\"/>\n" +
                "\t\t\t<result property=\"saddr\" column=\"SADDR\" jdbcType=\"VARCHAR\"/>\n" +
                "\t\t\t<result property=\"schapterno\" column=\"SCHAPTERNO\" jdbcType=\"VARCHAR\"/>\n" +
                "\t\t\t<result property=\"scode\" column=\"SCODE\" jdbcType=\"VARCHAR\"/>\n" +
                "\t\t\t<result property=\"scompanynm\" column=\"SCOMPANYNM\" jdbcType=\"VARCHAR\"/>\n" +
                "\t\t\t<result property=\"sdeptnm\" column=\"SDEPTNM\" jdbcType=\"VARCHAR\"/>\n" +
                "\t\t\t<result property=\"sdescribe\" column=\"SDESCRIBE\" jdbcType=\"VARCHAR\"/>\n" +
                "\t\t\t<result property=\"sestimatecode\" column=\"SESTIMATECODE\" jdbcType=\"VARCHAR\"/>\n" +
                "\t\t\t<result property=\"sline\" column=\"SLINE\" jdbcType=\"VARCHAR\"/>\n" +
                "\t\t\t<result property=\"slinegsbm\" column=\"SLINEGSBM\" jdbcType=\"VARCHAR\"/>\n" +
                "\t\t\t<result property=\"slineno\" column=\"SLINENO\" jdbcType=\"VARCHAR\"/>\n" +
                "\t\t\t<result property=\"smodid\" column=\"SMODID\" jdbcType=\"VARCHAR\"/>\n" +
                "\t\t\t<result property=\"smodnm\" column=\"SMODNM\" jdbcType=\"VARCHAR\"/>\n" +
                "\t\t\t<result property=\"sname\" column=\"SNAME\" jdbcType=\"VARCHAR\"/>\n" +
                "\t\t\t<result property=\"snote\" column=\"SNOTE\" jdbcType=\"VARCHAR\"/>\n" +
                "\t\t\t<result property=\"sphoto\" column=\"SPHOTO\" jdbcType=\"VARCHAR\"/>\n" +
                "\t\t\t<result property=\"spostnm\" column=\"SPOSTNM\" jdbcType=\"VARCHAR\"/>\n" +
                "\t\t\t<result property=\"spricecomponent\" column=\"SPRICECOMPONENT\" jdbcType=\"VARCHAR\"/>\n" +
                "\t\t\t<result property=\"sproorpricenm\" column=\"SPROORPRICENM\" jdbcType=\"VARCHAR\"/>\n" +
                "\t\t\t<result property=\"sregid\" column=\"SREGID\" jdbcType=\"VARCHAR\"/>\n" +
                "\t\t\t<result property=\"sregnm\" column=\"SREGNM\" jdbcType=\"VARCHAR\"/>\n" +
                "\t\t\t<result property=\"ssectionno\" column=\"SSECTIONNO\" jdbcType=\"VARCHAR\"/>\n" +
                "\t\t\t<result property=\"ssonnode\" column=\"SSONNODE\" jdbcType=\"VARCHAR\"/>\n" +
                "\t\t\t<result property=\"ssort\" column=\"SSORT\" jdbcType=\"VARCHAR\"/>\n" +
                "\t\t\t<result property=\"sstepnm\" column=\"SSTEPNM\" jdbcType=\"VARCHAR\"/>\n" +
                "\t\t\t<result property=\"sstepopernm\" column=\"SSTEPOPERNM\" jdbcType=\"VARCHAR\"/>\n" +
                "\t\t\t<result property=\"sstepstate\" column=\"SSTEPSTATE\" jdbcType=\"VARCHAR\"/>";
        getColoum(s,"g2");
    }

    private static void getColoum(String str,String per){
        String[] lineArray = str.split("\n");
        List<String> coloumAs = new ArrayList<>();
        for (String eachLine : lineArray) {
            String[] splits = eachLine.split("\"");
            StringBuilder sbb = new StringBuilder();
            sbb.append(StringUtils.isNotBlank(per) ? per + "." : "").append(splits[3]).append(" as ").append((StringUtils.isNotBlank(per) ? per+ "_" : "" )+splits[1]).append(",");
            coloumAs.add(sbb.toString());
            splits[3] = (StringUtils.isNotBlank(per)  ? per+ "_" : "") +splits[1];
            StringBuilder sb = new StringBuilder();
            for (String s1 : splits) {
                sb.append(s1).append("\"");
            }
            String substring = sb.substring(0, sb.length() - 1);
            System.out.println(substring);
        }
        coloumAs.forEach(s -> System.out.println(s));
    }
}
