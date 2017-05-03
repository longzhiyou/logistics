package lzy.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * http://qiita.com/rubytomato@github/items/4f0c64eb9a24eaceaa6e
 * https://spring.io/guides/gs/scheduling-tasks/
 * User: longzhiyou
 * Date: 2017/5/3
 * Time: 11:23
 */
@Component
public class ScheduledTasks {

    @Autowired
    CronSetting cron;

    private static final Logger log = LoggerFactory.getLogger(ScheduledTasks.class);
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    @Scheduled(fixedRate = 5000)
    public void reportCurrentTime() {
        log.info("doRate {}", dateFormat.format(new Date()));
    }

    @Scheduled(fixedDelay = 5000)
    public void doDelay() {
        log.info("doDelay {}", dateFormat.format(new Date()));
    }

    @Scheduled(cron = "0 * * * * *", zone = "Asia/Tokyo")
    public void doCron() {
        log.info("doCron {}", dateFormat.format(new Date()));
    }

    @Scheduled(cron = "${cron.cron1}")
    public void doCronSetting() {
        log.info("doCronSetting {}", dateFormat.format(new Date()));
    }
}
