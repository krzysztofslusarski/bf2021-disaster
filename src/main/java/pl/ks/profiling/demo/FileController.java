package pl.ks.profiling.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
class FileController {
    @GetMapping("/disk")
    void saveToDisk() {
        RequestIdGenerator.saveToLog = true;
    }

    @GetMapping("/no-disk")
    void doNotSaveToDisk() {
        RequestIdGenerator.saveToLog = false;
    }
}
