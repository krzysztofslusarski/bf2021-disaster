package pl.ks.profiling.demo;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import pl.ks.profiling.demo.other.OtherController;
import pl.ks.profiling.demo.stat.StatController;

import javax.annotation.PostConstruct;

@Slf4j
@Component
@RequiredArgsConstructor
class Jitter {
    private final OtherController otherController;
    private final StatController statController;

    @PostConstruct
    void jitIt() {
        log.info("Starting jitter");
        MagicNumbersCreatorImpl.beforeJIT();
        for (int i = 0; i < 15_000; i++) {
            if (i % 100 == 0) {
                log.info(i + "");
            }
            otherController.doOther(i);
            statController.get();
            RequestIdGenerator.generate();
        }
        MagicNumbersCreatorImpl.afterJIT();
        log.info("Ending jitter");
    }
}
