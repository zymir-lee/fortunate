package pers.zymir.fortunate.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class AwardProbabilityInfo {
    @TableId(type = IdType.AUTO)
    private Long id;
    private Long awardAllocationId;
    private Long campaignId;
    private Long awardId;
    private Integer awardCount;
    private BigDecimal probability;
    private Integer distributeMode;
    private Date createTime;
    private Date updateTime;
    private boolean deleted;
}
