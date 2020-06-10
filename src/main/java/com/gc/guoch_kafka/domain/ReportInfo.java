package com.gc.guoch_kafka.domain;

import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class ReportInfo {

    private String birthday;

    private String checkDate;

    private String checkUnitCode;

    private String checkUnitName;

    private String dwdm;

    private String dwmc;

    private Integer healthReportId;

    private String idCardNoMd5;

    private String lastUpdateTime;

    private String name = "";

    private Map<String,List> reportContent;

    private String reportCreateTime;

    private String sex;

    private String userId;

    private String userLoadTime;

}
