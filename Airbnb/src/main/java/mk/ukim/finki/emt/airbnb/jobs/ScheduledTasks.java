package mk.ukim.finki.emt.airbnb.jobs;

import mk.ukim.finki.emt.airbnb.service.HostService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduledTasks {
    private final HostService hostService;

    public ScheduledTasks(HostService hostService) {
        this.hostService = hostService;
    }

    //@Scheduled(fixedDelay = 10000)
//    public void refreshMaterializedView(){
//        this.hostService.refreshMaterializedView();
//    }


}
