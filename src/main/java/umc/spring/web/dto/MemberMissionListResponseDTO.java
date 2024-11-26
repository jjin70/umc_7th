package umc.spring.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Page;
import umc.spring.domain.Review;
import umc.spring.domain.mapping.MemberMission;

import java.util.List;
import java.util.stream.Collectors;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class MemberMissionListResponseDTO {
    private List<MemberMissionResponseDTO> memberMissionList;
    private Integer listSize;
    private Integer totalPage;
    private Long totalElements;
    private Boolean isFirst;
    private Boolean isLast;

    public static MemberMissionListResponseDTO from(Page<MemberMission> memberMissionList) {
        List<MemberMissionResponseDTO> memberMissionPreViewDTOList = memberMissionList.stream()
                .map(MemberMissionResponseDTO::from)
                .collect(Collectors.toList());

        return MemberMissionListResponseDTO.builder()
                .isLast(memberMissionList.isLast())
                .isFirst(memberMissionList.isFirst())
                .totalPage(memberMissionList.getTotalPages())
                .totalElements(memberMissionList.getTotalElements())
                .listSize(memberMissionPreViewDTOList.size())
                .memberMissionList(memberMissionPreViewDTOList)
                .build();
    }
}