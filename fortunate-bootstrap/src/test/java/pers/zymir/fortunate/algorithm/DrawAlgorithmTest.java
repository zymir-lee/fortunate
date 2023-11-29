package pers.zymir.fortunate.algorithm;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import pers.zymir.fortunate.algorithm.dto.AwardProbabilityDTO;
import pers.zymir.fortunate.algorithm.service.DrawAlgorithmService;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

@SpringBootTest
@RunWith(SpringRunner.class)
public class DrawAlgorithmTest {

    @Resource
    private DrawAlgorithmService drawAlgorithmService;

    @Test
    public void drawAlgorithmTest() {
        List<AwardProbabilityDTO> awardProbabilities = new ArrayList<>();
        AwardProbabilityDTO awardOne = new AwardProbabilityDTO();
        awardOne.setProbability(new BigDecimal("0.50"));
        awardOne.setAwardId(1L);
        awardProbabilities.add(awardOne);

        Optional<Long> awardIdOptional = drawAlgorithmService.execute(awardProbabilities, new HashSet<>());
        Assert.assertTrue(awardIdOptional.isPresent());
        Long awardId = awardIdOptional.get();
        System.out.println("奖品ID: " + awardId);
    }
}
