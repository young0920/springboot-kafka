package com.young.springbootkafka.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * EtlSxjyOanew
 * @author  yangbing
 * @date  2020/11/4 10:27 上午
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EtlSxjyOanew implements Serializable {
    /**
    * 唯一标识，封装包ID
    */
    private String id;

    /**
    * 文件的文件题名
    */
    private String nrms;

    /**
    * 系统名称
    */
    private String xxxtmc;

    /**
    * 移交载体
    */
    private String yjzt;

    /**
    * 准确性检验，固定值:0，通过1、不通过2
    */
    private String yjdwZqxjy;

    /**
    * 校验状态档案系统回填，0未校验 1校验中 2 校验成功  3 校验失败 4档案系统归档失败 5 归档失败数据已重新推送
    */
    private String jyzt;

    /**
    * 归档文件封装包文件名, YYSWSP 120171030.zip
    */
    private String filename;

    /**
    * 每家单位有一个固定的全宗号，由档案系统提供清单，见单位全宗库编码对应表
    */
    private String qzh;

    /**
    * 每家单位都有一个对应的编码（档案系统表名
    */
    private String kbm;

    /**
    * 文件年度
    */
    private String nd;

    /**
    * 归档人
    */
    private String yjdwTbr;

    /**
    * 归档时间
    */
    private String yjdwTbsj;

    /**
    * 归档文件封装包名称（不用带后缀）例：OANEW 120171030
    */
    private String ztbh;

    /**
    * 校验信息，上游系统留空
    */
    private String jyxx;

    /**
    * ftp存放路径：文件存放的完整路径，20171030/ OANEW 120171030.zip
    */
    private String path;

    /**
    * 插入时间
    */
    private String times;

    /**
    * 数字摘要值，归档文件封装包MD5值
    */
    private String szzyz;

    /**
    * 文件大小
    */
    private String wjrl;

    /**
    * 归档文件封装包中电子文件数量，不含.xml文件
    */
    private String yjdwDasl;

    /**
    * 完整性检验，固定值:0，通过1、不通过2
    */
    private String yjdwWzxjy;

    /**
    * 可用性检验，固定值:0，通过1、不通过2
    */
    private String yjdwKyxjy;

    /**
    * 安全性检验，固定值:0，通过1、不通过2
    */
    private String yjdwAqxjy;

    /**
    * 归档部门
    */
    private String yjdw;

    /**
    * 创建日期，归档文件封装包创建日期
    */
    private String createdate;

    /**
    * 失败批次封装包ID，对于失败批次数据，重新推送新批次时填写，失败批次的id（失败批次的封装包ID），用以备查关联备查
    */
    private String oldid;

    private static final long serialVersionUID = 1L;
}