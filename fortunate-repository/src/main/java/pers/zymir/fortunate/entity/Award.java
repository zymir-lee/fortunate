package pers.zymir.fortunate.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class Award extends BaseEntity {
    private Long awardId;

    /**
     * 奖品类型
     */
    private Integer type;

    /**
     * 奖品图片
     */
    private String picture;

    /**
     * 奖品描述
     */
    private String description;
}
