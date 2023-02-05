package com.gpmrks.strconsumer.listeners;

import com.gpmrks.strconsumer.custom.StrConsumerCustomListener;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

@Component
@Log4j2
public class StrConsumerListener {

    @StrConsumerCustomListener(groupId = "group-1")
    public void create(String message) {
        log.info("CREATE ::: Message received {}", message);
        throw new IllegalArgumentException("EXCEPTION ...");
    }

    @StrConsumerCustomListener(groupId = "group-1")
    public void log(String message) {
        log.info("LOG ::: Message received {}", message);
    }

    @StrConsumerCustomListener(groupId = "group-2", containerFactory = "validMessageContainerFactory")
    public void history(String message) {
        log.info("HISTORY ::: Message received {}", message);
    }
}
