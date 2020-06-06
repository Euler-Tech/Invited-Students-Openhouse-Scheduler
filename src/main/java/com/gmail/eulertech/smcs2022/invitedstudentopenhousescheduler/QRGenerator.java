package com.gmail.eulertech.smcs2022.invitedstudentopenhousescheduler;

import java.io.File;

import net.glxn.qrgen.core.scheme.Url;
import net.glxn.qrgen.javase.QRCode;

public class QRGenerator {
	private String data;

	public QRGenerator(String data) {
		this.data = data;
	}
	
	public byte[] generate() {
		Url u = new Url();
		return QRCode.from(data).stream().toByteArray();
	}
}
