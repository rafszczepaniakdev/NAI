package com.szczepaniak.nai.scheduler;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class Scheduler {
	
	private static Logger logger = LogManager.getLogger(Scheduler.class);

	@Scheduled(cron = "*/10 * * * * *")
    public void reportCurrentTime() {
        logger.error("SOMETHING HAPPEND");
    }
	
}
