package pers.zymir.fortunate.algorithm.service;

import pers.zymir.fortunate.algorithm.dto.AwardProbabilityDTO;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface DrawAlgorithmService {

    /**
     * 执行抽奖算法 策略模式
     * Q1:excludeAwardIds的作用？
     * 排除无法参与抽奖的奖品，例如无库存奖品 抽奖算法只关注抽奖算法流程 不关注任何业务
     * Q2:TODO 为什么排除无法参与抽奖奖品的步骤不放到抽奖算法之前
     *
     * @param awardProbabilities 奖品概率信息
     * @param excludeAwardIds    不参与抽奖的奖品id
     * @return 中奖奖品ID
     */
    Optional<Long> execute(List<AwardProbabilityDTO> awardProbabilities, Set<Long> excludeAwardIds);
}
