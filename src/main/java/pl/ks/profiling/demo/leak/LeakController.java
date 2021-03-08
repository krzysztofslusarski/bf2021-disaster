package pl.ks.profiling.demo.leak;

import java.lang.reflect.Field;
import java.util.LinkedList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
class LeakController {
    private final List<byte[]> leak = new LinkedList<>();

    @GetMapping("/leak/big")
    void doBigLeak() {
        leak.add(new byte[1024 * 1024 * 100]);
    }

    @GetMapping("/leak/small")
    void doSmallLeak() {
        leak.add(new byte[1024 * 1024]);
    }
}
