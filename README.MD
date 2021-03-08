Source code from my lecture: TODO

## Startup
java -Xms3G -Xmx3G -XX:+AlwaysPreTouch -XX:+UseParallelGC -jar frogs.jar > /dev/null

## First disaster

Compile and run noisy-neighbor.c

## Second disaster

```shell
#!/bin/sh

for i in `seq 1 34`
do
curl localhost:8080/leak/big
done

for i in `seq 1 100`
do
curl localhost:8080/leak/small
done
```

## Third disaster

```shell
#!/bin/sh
curl localhost:8080/disk
```