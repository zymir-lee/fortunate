package pers.zymir.fortunate.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

@EqualsAndHashCode(callSuper = true)
@Data
public class AwardProbabilityInfo extends BaseEntity {
    private Long awardProbabilityInfoId;

    /**
     * 所属活动ID
     */
    private Long activityId;

    /**
     * 奖品ID
     */
    private Long awardId;

    /**
     * 奖品数量
     */
    private Integer awardCount;

    /**
     * 中奖概率 目前仅支持最低为0.01
     */
    private BigDecimal probability;

    /**
     * 发奖方式
     */
    private Integer awardDistributeMode;
}
