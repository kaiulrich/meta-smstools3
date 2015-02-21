SUMMARY = "The SMS Server Tools 3 is a SMS Gateway software which can send and receive short messages through GSM modems and mobile phones."
SECTION = "network"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://LICENSE;md5=4d21efa1bb2a186360dde4035f860682"
HOMEPAGE = "http://smstools3.kekekasvi.com"

SRC_URI = "http://smstools3.kekekasvi.com/packages/${PN}-${PV}.tar.gz;name=tarball \
           file://sms3_bin_path.patch;name=patch"

SRC_URI[tarball.md5sum] = "0241ef60e646fac1a06254a848e61ed7"
SRC_URI[tarball.sha256sum] = "ed00ffaeaa312a5b4f969f4e97a64603a866bbe16e393ea02f5bf05234814d59"
SRC_URI[patch.md5sum] = "1bcfc6797913e38751efde764a96d03f"
SRC_URI[patch.sha256sum] = "39d53d02da09dec05c59d26c61cbe9b79b4917ef7bf80bfad5f81f68f092dd77"


S = "${WORKDIR}/${PN}"

do_install () {
	
	install -d ${D}${bindir}	
	install -m 644 ${S}/src/smsd "${D}${bindir}/smsd"
	
	install -m 644 ${S}/scripts/sendsms "${D}${bindir}/sendsms"
	install -m 644 ${S}/scripts/sms2html "${D}${bindir}/sms2html"
	install -m 644 ${S}/scripts/sms2unicode "${D}${bindir}/sms2unicode" 
	install -m 644 ${S}/scripts/unicode2sms "${D}${bindir}/unicode2sms"

	install -d ${D}${sysconfdir}	
	install -m 644 ${S}/examples/smsd.conf.easy "${D}${sysconfdir}/smsd.conf"

	install -d "${D}${localstatedir}/spool"
	install -d "${D}${localstatedir}/spool/sms"
	install -d "${D}${localstatedir}/spool/sms/incoming"
	install -d "${D}${localstatedir}/spool/sms/outgoing"
	install -d "${D}${localstatedir}/spool/sms/checked"

	install -d ${D}${sysconfdir}/init.d
	install -m 644 ${S}/scripts/sms3 "${D}${sysconfdir}/init.d/sms3"

}
