# meta-smstools3
yocto / openembedded smstools3 layer

##Installation

* Add /path/to/meta-smstools3 \ to BBLAYERS in build/conf/bblayers.conf
```
BBLAYERS ?= " \
  /path/to/yocto/dizzy/poky/meta \
  /path/to/yocto/dizzy/poky/meta-yocto \
  /path/to/yocto/dizzy/poky/meta-yocto-bsp \
  /path/to/yocto/dizzy/poky/meta-raspberrypi \
  /path/to/yocto/dizzy/poky/meta-smstools3 \
  "
```
* Add smstools3 to local.conf by IMAGE_INSTALL_append 
```
IMAGE_INSTALL_append = " smstools3 ssh-server-dropbear"
```


##Successful tested on:

* meta-raspberrypi with a Huawei Technologies Co., Ltd. E169 HSDPA Modem

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
