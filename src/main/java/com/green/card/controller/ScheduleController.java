package com.green.card.controller;

import com.green.card.common.ResCommonCode;
import com.green.card.service.ScheduleService;
import com.green.card.vo.ReqPageVo;
import com.green.card.vo.ResCommonVo;
import com.green.card.vo.ScheduleVo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/groovy")
public class ScheduleController {
    private final ScheduleService scheduleService;

    /**
     * 전체 일정 출력
     * @param reqPageVo
     * @return
     */
    @PostMapping(value="/api/schedule", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResCommonVo getScheduleList(@Valid @RequestBody ReqPageVo reqPageVo){

        return  ResCommonVo.builder()
                .result(scheduleService.getScheduleList(reqPageVo))
                .code(ResCommonCode.SUCCESS)
                .build();
    }

    /**
     * 일정 등록
     * @param scheduleVo
     */
    @PostMapping(value="/api/insert", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public void scheduleAdd(@RequestBody ScheduleVo scheduleVo){
        scheduleService.scheduleAdd(scheduleVo);
    }

    /**
     * 일정 수정
     * @param scheduleVo
     * @return
     */
    @PutMapping(value="/api/update", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResCommonVo updateContent(@RequestBody ScheduleVo scheduleVo){

        return ResCommonVo.builder()
                .result(scheduleService.updateContent(scheduleVo))
                .code(ResCommonCode.SUCCESS)
                .build();
    }

    /**
     * 일정 삭제
     * @param scheduleVo
     * @return
     */
    @DeleteMapping(value="/api/delete", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResCommonVo deleteSchedule(@RequestBody ScheduleVo scheduleVo){

        return ResCommonVo.builder()
                .result(scheduleService.deleteSchedule(scheduleVo))
                .code(ResCommonCode.SUCCESS)
                .build();
    }

    /**
     * 날짜별 일정 개수
     * @param scheduleVo
     * @return
     */
    @PostMapping(value="/api/scheduleCount", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResCommonVo groupDateCnt(@RequestBody ScheduleVo scheduleVo){

        return ResCommonVo.builder()
                .result(scheduleService.groupDateCnt(scheduleVo))
                .code(ResCommonCode.SUCCESS)
                .build();
    }
}
