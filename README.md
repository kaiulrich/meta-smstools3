# meta-smstools3
yocto / openembedded smstools3 layer

Tested on meta-raspberrypi with a Huawei Technologies Co., Ltd. E169 HSDPA Modem

smsd.conf:

```
devices = GSM1
logfile = /var/log/smsd.log
loglevel = 7

[GSM1]
device = /dev/ttyUSB2
incoming = yes
check_memory_method = 1 
memory_start = 0
```
