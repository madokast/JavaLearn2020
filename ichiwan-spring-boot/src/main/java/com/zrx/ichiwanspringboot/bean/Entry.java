package com.zrx.ichiwanspringboot.bean;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

/**
 * Description
 * Entry
 * 学习记录
 * id	int	NO	PRI		auto_increment
 * dateDone	date	NO
 * name	varchar(20)	NO
 * lengthMinute	int	NO
 * describing	varchar(100)	YES
 * deleteBool	tinyint(1)	NO		0
 * <p>
 * Data
 * 22:46
 *
 * @author zrx
 * @version 1.0
 */

public class Entry {
    private final static Logger LOGGER = LoggerFactory.getLogger(Entry.class);

    private Integer id;
    private Date dateDone;
    private String name;
    private Integer lengthMinute;
    private String describing;
    private Boolean deleteBool;

    public Entry() {
    }

    public Entry(Integer id, Date dateDone, String name, Integer lengthMinute, String describing, Boolean deleteBool) {
        this.id = id;
        this.dateDone = dateDone;
        this.name = name;
        this.lengthMinute = lengthMinute;
        this.describing = describing;
        this.deleteBool = deleteBool;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDateDone() {
        return dateDone;
    }

    public void setDateDone(Date dateDone) {
        this.dateDone = dateDone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getLengthMinute() {
        return lengthMinute;
    }

    public void setLengthMinute(Integer lengthMinute) {
        this.lengthMinute = lengthMinute;
    }

    public String getDescribing() {
        return describing;
    }

    public void setDescribing(String describing) {
        this.describing = describing;
    }

    public Boolean getDeleteBool() {
        return deleteBool;
    }

    public void setDeleteBool(Boolean deleteBool) {
        this.deleteBool = deleteBool;
    }

    @Override
    public String toString() {
        return "Entry{" +
                "id=" + id +
                ", dateDone=" + dateDone +
                ", name='" + name + '\'' +
                ", lengthMinute=" + lengthMinute +
                ", describing='" + describing + '\'' +
                ", deleteBool=" + deleteBool +
                '}';
    }
}
