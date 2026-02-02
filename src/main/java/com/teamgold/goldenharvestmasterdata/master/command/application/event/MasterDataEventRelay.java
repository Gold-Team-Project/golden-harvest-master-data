package com.teamgold.goldenharvestmasterdata.master.command.application.event;

import com.teamgold.goldenharvestmasterdata.common.broker.KafkaProducerHelper;
import com.teamgold.goldenharvestmasterdata.master.command.application.event.dto.ItemMasterUpdatedEvent;
import com.teamgold.goldenharvestmasterdata.master.command.application.event.dto.ItemOriginPriceUpdatedEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor
@Slf4j
public class MasterDataEventRelay {

    private final KafkaProducerHelper producer;

    @Async
    @EventListener
    public void masterDataUpdateRelay(ItemMasterUpdatedEvent event) {
        log.info("producing kafka event: ItemMasterUpdatedEvent");
        producer.send("item.master.updated", UUID.randomUUID().toString(), event, null);
        // Todo: onFailure 콜백 함수 등록
    }

    @Async
    @EventListener
    public void itemOriginPriceUpdateRelay(ItemOriginPriceUpdatedEvent event) {
        log.info("producing kafka event: ItemOriginPriceUpdateEvent");
        producer.send("item.origin.price.updated", UUID.randomUUID().toString(), event, null);
        // Todo: onFailure 콜백 함수 등록
    }
}
