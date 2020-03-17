package com.zrx.ichiwanspringboot.bean;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Description
 * 处理后显示在前端的 entry
 * 编号	时间	项目	说明	时长/min	总时长/h	日均时长/min
 * <p>
 * Data
 * 23:12
 *
 * @author zrx
 * @version 1.0
 */

public class EntryPost {
    private Integer id;
    private String time;
    private String project;
    private String describing;
    private Integer lengthMin;
    private String totalLengthHHmm;
    private Double averageLengthMin;

    private final static Logger LOGGER = LoggerFactory.getLogger(EntryPost.class);

    public EntryPost() {
    }

    public EntryPost(Integer id, String time, String project, String describing, Integer lengthMin, String totalLengthHHmm, Double averageLengthMin) {
        this.id = id;
        this.time = time;
        this.project = project;
        this.describing = describing;
        this.lengthMin = lengthMin;
        this.totalLengthHHmm = totalLengthHHmm;
        this.averageLengthMin = averageLengthMin;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public String getDescribing() {
        return describing;
    }

    public void setDescribing(String describing) {
        this.describing = describing;
    }

    public Integer getLengthMin() {
        return lengthMin;
    }

    public void setLengthMin(Integer lengthMin) {
        this.lengthMin = lengthMin;
    }

    public String getTotalLengthHHmm() {
        return totalLengthHHmm;
    }

    public void setTotalLengthHHmm(String totalLengthHHmm) {
        this.totalLengthHHmm = totalLengthHHmm;
    }

    public Double getAverageLengthMin() {
        return averageLengthMin;
    }

    public void setAverageLengthMin(Double averageLengthMin) {
        this.averageLengthMin = averageLengthMin;
    }

    @Override
    public String toString() {
        return "EntryPost{" +
                "id=" + id +
                ", time='" + time + '\'' +
                ", project='" + project + '\'' +
                ", describing='" + describing + '\'' +
                ", lengthMin=" + lengthMin +
                ", totalLengthHHmm='" + totalLengthHHmm + '\'' +
                ", averageLengthMin=" + averageLengthMin +
                '}';
    }
}
