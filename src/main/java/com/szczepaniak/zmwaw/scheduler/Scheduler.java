package com.szczepaniak.zmwaw.scheduler;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class Scheduler {
	
	private static Logger logger = LogManager.getLogger(Scheduler.class);
	
	private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

	@Scheduled(cron = "*/10 * * * * *")
    public void reportCurrentTime() {
        logger.error("SCHEDULER TAKS: " + formatter.format(LocalDateTime.now()));
    }
	
}
