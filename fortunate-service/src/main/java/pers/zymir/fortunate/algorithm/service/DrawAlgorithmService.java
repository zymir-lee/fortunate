package pers.zymir.fortunate.algorithm.service;

import pers.zymir.fortunate.algorithm.dto.AwardProbabilityDTO;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface DrawAlgorithmService {
    Optional<Long> executeAlgorithm(List<AwardProbabilityDTO> awardProbabilities, Set<Long> excludeAwardIds);
}
