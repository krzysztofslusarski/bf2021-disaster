package pl.ks.profiling.demo;

import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import lombok.extern.slf4j.Slf4j;

@Slf4j
class RequestIdGenerator {
    private static Random random = ThreadLocalRandom.current();

    private static MagicNumbersCreator magicNumbersCreator = new MagicNumbersCreatorImpl();

    static volatile boolean saveToLog;

    static String generate() {
        double sum = 0;
        for (int i = 0; i < 1000; i++) {
            sum += doSomeMagic(random.nextDouble());
        }
        return "ID-" + sum;
    }

    private static double doSomeMagic(double arg) {
        List<Integer> magicNumbers = magicNumbersCreator.generateRandomMagicIntegers();

        double sum = 0;
        for (Integer magicNumber : magicNumbers) {
            if (saveToLog) {
                log.info("Magic: {}", magicNumber);
            }
            sum += arg * magicNumber;
        }
        return sum;
    }
}
