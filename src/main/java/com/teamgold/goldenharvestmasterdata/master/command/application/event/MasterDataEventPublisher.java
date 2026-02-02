package com.teamgold.goldenharvestmasterdata.master.command.application.event;


import com.teamgold.goldenharvestmasterdata.master.command.application.event.dto.ItemMasterUpdatedEvent;
import com.teamgold.goldenharvestmasterdata.master.command.application.event.dto.ItemOriginPriceUpdatedEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MasterDataEventPublisher {

    private final ApplicationEventPublisher eventPublisher;

    public void publishItemMasterUpdatedEvent(ItemMasterUpdatedEvent event) {
        eventPublisher.publishEvent(event);
    }

    public void publishItemOriginPriceUpdatedEvent(ItemOriginPriceUpdatedEvent event) {
        eventPublisher.publishEvent(event);
    }
}
