package com.pro.pro;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.pro.pro.model.DTO.InternetTestDTO;
import com.pro.pro.model.DTO.OutputDTO;
import com.pro.pro.model.DTO.PastExperiencesDTO;
import com.pro.pro.model.DTO.ProDTO;
import com.pro.pro.service.ProService;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = ProService.class)
@ExtendWith(SpringExtension.class)
public class ProServiceTest {

    private final String DARK = "calculate_dark_matter_nasa";
    private final String CAT = "determine_schrodinger_cat_is_alive";
    private final String SUPPORT = "support_users_from_xyz";
    private final String COLLECT = "collect_information_for_xpto";

    @Autowired
    private ProService proService;

    @Test
    void eligibilityScoreEducationLevelTest() {
        String educationLevelHS = "high_school";
        String educationLevelNS = "no_education";
        String educationLevelBDH = "bachelors_degree_or_high";

        Integer scoreHS, scoreNS, scoreBDH;

        scoreHS = proService.eligibilityScoreEducationLevel(educationLevelHS);
        scoreNS = proService.eligibilityScoreEducationLevel(educationLevelNS);
        scoreBDH = proService.eligibilityScoreEducationLevel(educationLevelBDH);

        assertEquals(1, scoreHS);
        assertEquals(0, scoreNS);
        assertEquals(2, scoreBDH);
    }

    @Test
    void eligibilityScorePastExperiencesTest() {
        Integer scoreSales, scoreSupport, scoreSalesSupportTrue, scoreSalesSupportFalse;

        scoreSales = proService.eligibilityScorePastExperiences(true, false);
        scoreSupport = proService.eligibilityScorePastExperiences(false, true);
        scoreSalesSupportTrue = proService.eligibilityScorePastExperiences(true, true);
        scoreSalesSupportFalse = proService.eligibilityScorePastExperiences(false, false);

        assertEquals(5, scoreSales);
        assertEquals(3, scoreSupport);
        assertEquals(8, scoreSalesSupportTrue);
        assertEquals(0, scoreSalesSupportFalse);
    }

    @Test
    void eligibilityScoreInternetTestTest() {
        float speedBigger = 52.3f;
        float speedSmaller = 40f;

        Integer scoreSpeedBigger = proService.eligibilityScoreInternetTest(speedBigger);
        Integer scoreSpeedSmaller = proService.eligibilityScoreInternetTest(speedSmaller);

        assertEquals(1, scoreSpeedBigger);
        assertEquals(-1, scoreSpeedSmaller);
    }

    @Test
    void eligibilityScoreWritingScoreTest() {
        Integer scoreSmaller = proService.eligibilityScoreWritingScore(0.2f);
        Integer scoreBigger = proService.eligibilityScoreWritingScore(0.8f);
        Integer scoreBetween = proService.eligibilityScoreWritingScore(0.4f);

        assertEquals(-1, scoreSmaller);
        assertEquals(2, scoreBigger);
        assertEquals(1, scoreBetween);
    }

    @Test
    void eligibilityScoreReferralCodeTest() {
        String valideToken = "token1234";
        String noValideToken = "token";

        Integer scoreValideToken = proService.eligibilityScoreReferralCode(valideToken);
        Integer scoreNoValideToken = proService.eligibilityScoreReferralCode(noValideToken);

        assertEquals(1, scoreValideToken);
        assertEquals(0, scoreNoValideToken);
    }

    @Test
    void underAgeTest() {
        List<String> allList = proService.underAge();

        assertEquals(DARK, allList.get(0));
        assertEquals(4, allList.size());
    }

    @Test
    void projectListEligibleTest() {
        List<String> eligibleProject = new ArrayList<>();

        eligibleProject = proService.projectListEligible(6);

        assertEquals(CAT, eligibleProject.get(0));
        assertEquals(3, eligibleProject.size());
    }

    @Test
    void projectListIneligibleTest() {
        List<String> ineligibleProject = new ArrayList<>();

        ineligibleProject = proService.projectListIneligible(2);

        assertEquals(2, ineligibleProject.size());
        assertEquals(CAT, ineligibleProject.get(0));
    }

    @Test
    void projectListSelectTest() {
        String select;
        select = proService.projectListSelect(11);
        assertEquals(DARK, select);
    }

    @Test
    void calculeScoreTest() {
        ProDTO proDTO = createPro();

        Integer totalScore = proService.calculeScore(proDTO);

        assertEquals(6, totalScore);
    }

    @Test
    void createOutputTest() {
        ProDTO proDTO = createPro();
        OutputDTO outputDTO = proService.createOutput(proDTO);
        assertEquals(6, outputDTO.getScore());
        assertEquals(CAT, outputDTO.getSelected_project());
    }

    public ProDTO createPro() {
        ProDTO proDTO = new ProDTO();
        PastExperiencesDTO pastExperiencesDTO = new PastExperiencesDTO(false, true);
        InternetTestDTO internetTestDTO = new InternetTestDTO(50.4f, 40.2f);

        proDTO.setAge(35);
        proDTO.setEducation_level("high_school");
        proDTO.setPast_experiences(pastExperiencesDTO);
        proDTO.setInternet_test(internetTestDTO);
        proDTO.setWriting_score(0.6f);
        proDTO.setReferral_code("token1234");

        return proDTO;
    }
}
