package com.gc.guoch_kafka.kafkaUtils;

import com.alibaba.fastjson.JSON;
import com.gc.guoch_kafka.domain.ReportInfo;
import com.gc.guoch_kafka.domain.ReportRes;
import org.apache.kafka.clients.producer.Producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.*;
import java.util.Map;

@RestController
public class MyKafkaProducer {

    @Autowired
    private KafkaTemplate<String,Object> kafkaTemplate;


     FileInputStream fis = null;
     InputStreamReader isr = null;
     BufferedReader br = null;
     String tempString = null;
     int count = 0;
    //kafka Producer 静态变量创建对象
     Producer<String, String> producer = null;
     File file = null;

    @RequestMapping("/producer/send2")
    public boolean send() throws IOException {

        file = new File("D:\\develop\\odpscmd_public_May\\bin\\res_tmp_guoch_kafka_0608.txt");
//            file = new File("/home/datag/guoch/tmp_guoch_kafka2.txt");
        fis = new FileInputStream(file);
        isr = new InputStreamReader(fis);
        br = new BufferedReader(isr);

        ReportRes reportRes = new ReportRes();
        reportRes.setEventType("INSERT");
        reportRes.setTable("report");
        while ((tempString = br.readLine()) != null) {
            System.out.println(tempString);
            String[] split = tempString.split("\\|\\|\\$\\&",-1);
            ReportInfo reportInfo = new ReportInfo();
//                reportInfo.
            reportInfo.setHealthReportId(Integer.valueOf(split[0]));
            reportInfo.setReportContent((Map) JSON.parse(split[1]));
            reportInfo.setReportCreateTime(split[2]);
            reportInfo.setLastUpdateTime(split[4]);
            String s = split[5];
            if (split[5].length() >= 10){
                reportInfo.setBirthday(split[5].substring(0,10));
            }else {
                reportInfo.setBirthday(split[5]);
            }
            if (split[6].length() >= 10){
                reportInfo.setCheckDate(split[6].substring(0,10));
            }else {
                reportInfo.setCheckDate(split[6]);
            }
            reportInfo.setCheckUnitCode(split[7]);
            reportInfo.setCheckUnitName(split[8]);
            reportInfo.setDwdm(split[9]);
            reportInfo.setDwmc(split[10]);
            reportInfo.setSex(split[11]);
            reportInfo.setUserLoadTime(split[4]);

//                JSONObject jsonObj = (JSONObject) JSON.toJSON(data);
            reportRes.setObj(reportInfo);

            String reportStr = JSON.toJSON(reportRes).toString();
//            kafkaTemplate.send("dev-syn-report", reportStr);
        }
        return true;
    }

    @RequestMapping("/producer/send")
    public boolean send2() throws IOException {
            file = new File("/home/datag/guoch/tmp_guoch_kafka2.txt");
        fis = new FileInputStream(file);
        isr = new InputStreamReader(fis);
        br = new BufferedReader(isr);

        ReportRes reportRes = new ReportRes();
        reportRes.setEventType("INSERT");
        reportRes.setTable("report");
        while ((tempString = br.readLine()) != null) {
            System.out.println(tempString);
            String[] split = tempString.split("\\|\\|\\$\\&",-1);
            ReportInfo reportInfo = new ReportInfo();
//                reportInfo.
            reportInfo.setHealthReportId(Integer.valueOf(split[0]));
            reportInfo.setReportContent((Map) JSON.parse(split[1]));
            reportInfo.setReportCreateTime(split[2]);
            reportInfo.setLastUpdateTime(split[4]);
            if (split[5].length() >= 10){
                reportInfo.setBirthday(split[5].substring(0,10));
            }else {
                reportInfo.setBirthday(split[5]);
            }
            if (split[6].length() >= 10){
                reportInfo.setCheckDate(split[6].substring(0,10));
            }else {
                reportInfo.setCheckDate(split[6]);
            }
            reportInfo.setCheckUnitCode(split[7]);
            reportInfo.setCheckUnitName(split[8]);
            reportInfo.setDwdm(split[9]);
            reportInfo.setDwmc(split[10]);
            reportInfo.setSex(split[11]);
            reportInfo.setIdCardNoMd5(split[12]);
            reportInfo.setName(split[13]);
            reportInfo.setUserId(split[14]);
            reportInfo.setUserLoadTime(split[4]);
//                JSONObject jsonObj = (JSONObject) JSON.toJSON(data);
            reportRes.setObj(reportInfo);

            String reportStr = JSON.toJSON(reportRes).toString();
            kafkaTemplate.send("dev-syn-report", reportStr);
        }
        return true;
    }


    @RequestMapping("/producer/send3")
    public boolean send3() throws IOException {
        file = new File("/home/datag/guoch/tmp_guoch_kafka2.txt");
        fis = new FileInputStream(file);
        isr = new InputStreamReader(fis);
        br = new BufferedReader(isr);

        ReportRes reportRes = new ReportRes();
        reportRes.setEventType("INSERT");
        reportRes.setTable("report");
        while ((tempString = br.readLine()) != null) {
            String[] split = tempString.split("\\|\\|\\$\\&",-1);
            ReportInfo reportInfo = new ReportInfo();
//                reportInfo.
            reportInfo.setHealthReportId(Integer.valueOf(split[0]));
            reportInfo.setReportContent((Map) JSON.parse(split[1]));
            reportInfo.setReportCreateTime(split[2]);
            reportInfo.setLastUpdateTime(split[4]);
            if (split[5].length() >= 10){
                reportInfo.setBirthday(split[5].substring(0,10));
            }else {
                reportInfo.setBirthday(split[5]);
            }
            if (split[6].length() >= 10){
                reportInfo.setCheckDate(split[6].substring(0,10));
            }else {
                reportInfo.setCheckDate(split[6]);
            }
            reportInfo.setCheckUnitCode(split[7]);
            reportInfo.setCheckUnitName(split[8]);
            reportInfo.setDwdm(split[9]);
            reportInfo.setDwmc(split[10]);
            reportInfo.setSex(split[11]);
            reportInfo.setIdCardNoMd5(split[12]);
            reportInfo.setName(split[13]);
            reportInfo.setUserId(split[14]);
            reportInfo.setUserLoadTime(split[4]);
//                JSONObject jsonObj = (JSONObject) JSON.toJSON(data);
            reportRes.setObj(reportInfo);

            String reportStr = JSON.toJSON(reportRes).toString();
//            kafkaTemplate.send("dev-syn-report", reportStr);
        }
        return true;
    }
}
