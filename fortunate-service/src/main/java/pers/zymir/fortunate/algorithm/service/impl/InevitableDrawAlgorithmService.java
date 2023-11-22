package pers.zymir.fortunate.algorithm.service.impl;

import cn.hutool.core.collection.CollUtil;
import org.springframework.stereotype.Service;
import pers.zymir.fortunate.algorithm.dto.AwardProbabilityDTO;
import pers.zymir.fortunate.algorithm.service.DrawAlgorithmService;
import pers.zymir.fortunate.util.RandomUtil;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class InevitableDrawAlgorithmService implements DrawAlgorithmService {

    @Override
    public Optional<Long> executeAlgorithm(List<AwardProbabilityDTO> awardProbabilities, Set<Long> excludeAwardIds) {
        excludeDisableAward(awardProbabilities, excludeAwardIds);
        if (CollUtil.isEmpty(awardProbabilities)) {
            return Optional.empty();
        }
        if (onlyOneAward(awardProbabilities)) {
            AwardProbabilityDTO soleAward = getSoleAward(awardProbabilities);
            return Optional.of(soleAward.getAwardId());
        }
        averageAwardProbability(awardProbabilities);
        return Optional.ofNullable(executeInevitableAlgorithm(awardProbabilities));
    }

    private AwardProbabilityDTO getSoleAward(List<AwardProbabilityDTO> awardProbabilities) {
        return awardProbabilities.get(0);
    }

    private Long executeInevitableAlgorithm(List<AwardProbabilityDTO> awardProbabilities) {
        int winnerNumber = generateWinnerNumber();
        int cursor = 0;
        for (AwardProbabilityDTO each : awardProbabilities) {
            BigDecimal probability = each.getProbability();
            cursor += probability.multiply(BigDecimal.valueOf(100)).intValue();
            if (inWinningRange(cursor, winnerNumber)) {
                return each.getAwardId();
            }
        }
        return null;
    }

    private boolean inWinningRange(int cursor, int winnerNumber) {
        return winnerNumber <= cursor;
    }

    private int generateWinnerNumber() {
        return RandomUtil.randomInt(1, 100);
    }

    private void averageAwardProbability(List<AwardProbabilityDTO> awardProbabilities) {
        BigDecimal totalProbability = computeTotalProbability(awardProbabilities);
        if (inevitableWinner(totalProbability)) {
            return;
        }
        for (AwardProbabilityDTO each : awardProbabilities) {
            BigDecimal currentProbability = each.getProbability();
            each.setProbability(computeNewProbability(currentProbability, totalProbability));
        }
    }

    private boolean inevitableWinner(BigDecimal totalProbability) {
        return totalProbability.compareTo(BigDecimal.ONE) >= 0;
    }

    private BigDecimal computeNewProbability(BigDecimal currentProbability, BigDecimal totalProbability) {
        return currentProbability.divide(totalProbability, RoundingMode.UP);
    }

    private BigDecimal computeTotalProbability(List<AwardProbabilityDTO> awardProbabilities) {
        return awardProbabilities.stream().map(AwardProbabilityDTO::getProbability).reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    private boolean onlyOneAward(List<AwardProbabilityDTO> awardProbabilities) {
        return awardProbabilities.size() == 1;
    }

    private void excludeDisableAward(List<AwardProbabilityDTO> awardProbabilities, Set<Long> excludeAwardIds) {
        if (CollUtil.isEmpty(awardProbabilities) || CollUtil.isEmpty(excludeAwardIds)) {
            return;
        }
        awardProbabilities.removeIf(a -> excludeAwardIds.contains(a.getAwardId()));
    }
}
