package com.teamgold.goldenharvestmasterdata.common.infra.harvest.collector;

import com.teamgold.goldenharvestmasterdata.common.infra.harvest.HarvestClient;
import com.teamgold.goldenharvestmasterdata.common.infra.harvest.HarvestParse;
import com.teamgold.goldenharvestmasterdata.master.command.application.dto.request.master.MasterDataRequest;
import com.teamgold.goldenharvestmasterdata.master.command.application.dto.response.master.MasterResponse;
import com.teamgold.goldenharvestmasterdata.master.command.application.service.master.MasterDataService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Slf4j
@RequiredArgsConstructor

public class MasterCollector {
    private final HarvestClient harvestClient;
    private final HarvestParse harvestParse;
    private final MasterDataService masterService;

    public void collect(MasterDataRequest request) {
        String response = harvestClient.callProduct(request);
        List<MasterResponse> masters = harvestParse.parseProduct(response);

        if(masters.isEmpty()){
            //todo 예외 처리 추가
            log.info("수집된 마스터 데이터 없음");
            return;
        }
        masterService.saveAll(masters);

    }

}

