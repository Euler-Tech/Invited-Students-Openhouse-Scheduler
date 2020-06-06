package com.gmail.eulertech.smcs2022.invitedstudentopenhousescheduler;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

class TextArea extends JTextArea{

	public TextArea(String text) {
		super(text);
		Border border = BorderFactory.createLineBorder(Color.BLACK);
	    setBorder(BorderFactory.createCompoundBorder(border,
	            BorderFactory.createEmptyBorder(5, 5, 5, 5)));
		setEditable(true);
		setLineWrap(true);
		setForeground(Color.BLACK);
	}
}
