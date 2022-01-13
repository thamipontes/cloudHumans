package com.pro.pro.service;

import com.pro.pro.enuns.EducationLevel;
import com.pro.pro.model.DTO.OutputDTO;
import com.pro.pro.model.DTO.ProDTO;
import com.pro.pro.utils.ValidateUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class ProService {

    private final String DARK = "calculate_dark_matter_nasa";
    private final String CAT = "determine_schrodinger_cat_is_alive";
    private final String SUPPORT = "support_users_from_xyz";
    private final String COLLECT = "collect_information_for_xpto";

    public OutputDTO createOutput(ProDTO proDTO) {
        ValidateUtils.validateProDTO(proDTO);
        OutputDTO outputDTO = new OutputDTO();

        if (proDTO.getAge() < 18) {
            outputDTO.setScore(0);
            outputDTO.setSelected_project("");
            outputDTO.setEligible_projects(Collections.emptyList());
            outputDTO.setIneligible_projects(underAge());
            return outputDTO;
        }

        Integer finalScore = calculeScore(proDTO);
        List<String> eligible = projectListEligible(finalScore);
        outputDTO.setScore(finalScore);
        outputDTO.setEligible_projects(eligible);
        outputDTO.setIneligible_projects(projectListIneligible(eligible.size()));
        outputDTO.setSelected_project(projectListSelect(finalScore));

        return outputDTO;
    }

    public Integer eligibilityScoreEducationLevel(String educationLevel) {
        if (EducationLevel.HIGH_SCHOOL.getValor().equals(educationLevel)) return 1;
        if (EducationLevel.BACHELORS_DEGREE_OR_HIGH.getValor().equals(educationLevel)) return 2;
        return 0;
    }

    public Integer eligibilityScorePastExperiences(boolean sales, boolean support) {
        if (sales && support) return 8;
        if (!sales && !support) return 0;

        return sales ? 5 : 3;
    }

    public Integer eligibilityScoreInternetTest(float speed) {
        return speed > 50 ? 1 : -1;
    }

    public Integer eligibilityScoreWritingScore(float writingScore) {
        if (writingScore < 0.3) {
            return -1;
        } else if (writingScore > 0.7) {
            return 2;
        } else return 1;
    }

    public Integer eligibilityScoreReferralCode(String value) {
        return value.equals("token1234") ? 1 : 0;
    }

    public List<String> underAge() {
        List<String> all = new ArrayList<>();
        all.add(DARK);
        all.add(CAT);
        all.add(SUPPORT);
        all.add(COLLECT);
        return all;
    }

    public List<String> projectListEligible(Integer score) {
        List<String> eligibleProject = new ArrayList<>();

        if (score > 10) eligibleProject.add(DARK);
        if (score > 5) eligibleProject.add(CAT);
        if (score > 3) eligibleProject.add(SUPPORT);
        if (score > 2) eligibleProject.add(COLLECT);

        return eligibleProject;
    }

    public List<String> projectListIneligible(Integer eligibleProject) {
        List<String> ineligibleProject = new ArrayList<>();
        switch (eligibleProject) {
            case 1:
                ineligibleProject.add(SUPPORT);
            case 2:
                ineligibleProject.add(CAT);
            case 3:
                ineligibleProject.add(DARK);
            default:
                break;
        }
        return ineligibleProject;
    }

    public String projectListSelect(Integer score) {
        if (score > 10) return DARK;
        if (score > 5) return CAT;
        if (score > 3) return SUPPORT;
        if (score > 2) return COLLECT;
        return "";
    }

    public Integer calculeScore(ProDTO proDTO) {
        Integer totalScore = 0;
        totalScore += eligibilityScoreEducationLevel(proDTO.getEducation_level());
        totalScore +=
            eligibilityScorePastExperiences(
                proDTO.getPast_experiences().isSales(),
                proDTO.getPast_experiences().isSupport()
            );
        totalScore += eligibilityScoreInternetTest(proDTO.getInternet_test().getDownload_speed());
        totalScore += eligibilityScoreInternetTest(proDTO.getInternet_test().getUpload_speed());
        totalScore += eligibilityScoreWritingScore(proDTO.getWriting_score());
        totalScore += eligibilityScoreReferralCode(proDTO.getReferral_code());

        return totalScore;
    }
}
