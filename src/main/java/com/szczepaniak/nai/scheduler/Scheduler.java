package com.szczepaniak.nai.scheduler;

import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class Scheduler {

	@Scheduled(cron = "*/10 * * * * *")
    public void reportCurrentTime() {
        System.out.println("SOMETHING HAPPEND");
    }
	
}
