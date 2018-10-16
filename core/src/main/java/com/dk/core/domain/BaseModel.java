package com.dk.core.domain;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @autor kevin.dai
 * @Date 2018/9/29
 */
@MappedSuperclass
@EntityListeners(BaseModelListener.class)
public abstract class BaseModel implements Serializable {


    private static final long serialVersionUID = -6586177519899623678L;



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //jpa 主键ID自增长策略
    private Long id;


    @Version
    private long version;

    private Boolean deleted = false;

    private Long createTime = System.currentTimeMillis();

    private Long lastModifyTime = System.currentTimeMillis();






    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public long getVersion() {
        return version;
    }

    public void setVersion(long version) {
        this.version = version;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public Long getLastModifyTime() {
        return lastModifyTime;
    }

    public void setLastModifyTime(Long lastModifyTime) {
        this.lastModifyTime = lastModifyTime;
    }
}
