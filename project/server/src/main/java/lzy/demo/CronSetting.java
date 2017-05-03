package lzy.demo;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * User: longzhiyou
 * Date: 2017/5/3
 * Time: 11:40
 */
@Component
@ConfigurationProperties(prefix = "cron")
public class CronSetting {
    private String cron1;
    private String cron2;

    public String getCron1() {
        return cron1;
    }
    public void setCron1(String cron1) {
        this.cron1 = cron1;
    }
    public String getCron2() {
        return cron2;
    }
    public void setCron2(String cron2) {
        this.cron2 = cron2;
    }
}
