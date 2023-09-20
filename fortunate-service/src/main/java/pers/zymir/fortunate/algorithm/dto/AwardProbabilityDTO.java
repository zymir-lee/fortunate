package pers.zymir.fortunate.algorithm.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class AwardProbabilityDTO {
    private Long awardId;
    private BigDecimal probability;
}
