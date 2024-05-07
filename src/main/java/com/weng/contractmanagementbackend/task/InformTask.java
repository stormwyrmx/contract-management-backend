package com.weng.contractmanagementbackend.task;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class InformTask {


    /**
     * 每天6点提醒还未完成的合同
     */
    @Scheduled(cron = "0 0 6 * * ?")
    public void processClear(){
    }



}
