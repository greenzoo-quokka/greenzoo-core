package com.greenzoo.greenzoologger.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

@RestController
public class LoggerController {

    private Logger logger = LoggerFactory.getLogger(LoggerController.class);

    @PostConstruct
    public void init() {
        String loggerDesc = "로그 내용";
        logger.error("Logger Error : {}" , loggerDesc);
        logger.warn("Logger Warn : {}" , loggerDesc);
        logger.info("Logger Info : {}" , loggerDesc);
        logger.debug("Logger Debug : {}" , loggerDesc);
        logger.trace("Logger Trace : {}" , loggerDesc);
    }
}
