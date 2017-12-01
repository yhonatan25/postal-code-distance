package org.yhonatan.practice.postal.code.distance.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.yhonatan.practice.postal.code.distance.log.DistanceRequestReport;
import org.yhonatan.practice.postal.code.distance.service.LogService;

import java.util.List;

@RestController
public class RequestLogController {

    private final LogService logService;

    @Autowired
    public RequestLogController(final LogService logService) {
        this.logService = logService;
    }

    @RequestMapping("/requests")
    public List<DistanceRequestReport> getRequestsReport(@RequestParam("postal-code") final String postalCode){
        return logService.getDistanceRequestLogList(postalCode);
    }

}
