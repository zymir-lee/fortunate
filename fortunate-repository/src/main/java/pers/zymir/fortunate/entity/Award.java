package pers.zymir.fortunate.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Award {
    private Long id;
    private Long awardId;
    private Integer type;
    private String picture;
    private String description;
    private Date createTime;
    private Date updateTime;
    private boolean deleted;
}
