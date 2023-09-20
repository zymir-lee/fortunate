package pers.zymir.fortunate.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum DistributeModeEnum implements Markable {
    EXPRESS_MAIL(1, "快递邮寄"),
    VIRTUAL_GOOD(2, "虚拟物品");

    private final Integer mark;
    private final String description;

    @Override
    public Integer mark() {
        return mark;
    }
}
