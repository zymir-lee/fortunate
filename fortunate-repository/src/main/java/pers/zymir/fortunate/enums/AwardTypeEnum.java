package pers.zymir.fortunate.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum AwardTypeEnum implements Markable {
    CDK(1, "CDK兑换码"),
    COUPON(2, "优惠券"),
    MATERIAL_OBJECT(3, "实物奖品");

    private final Integer mark;
    private final String description;

    @Override
    public Integer mark() {
        return mark;
    }
}
