package com.gc.guoch_kafka.domain;

import lombok.Data;

@Data
public class ReportRes {

    private String eventType;

    private ReportInfo obj;

    private String table;

}
