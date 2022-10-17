package com.green.card.controller;

import com.green.card.common.ResCommonCode;
import com.green.card.service.ScheduleService;
import com.green.card.vo.ReqPageVo;
import com.green.card.vo.ResCommonVo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class ScheduleController {
    private final ScheduleService scheduleService;

    @PostMapping(value="/api/schedule", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResCommonVo getScheduleList(@Valid @RequestBody ReqPageVo reqPageVo){

        return  ResCommonVo.builder()
                .result(scheduleService.getScheduleList(reqPageVo))
                .code(ResCommonCode.SUCCESS)
                .build();
    }
}
