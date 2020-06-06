package com.gmail.eulertech.smcs2022.invitedstudentopenhousescheduler;

import java.awt.EventQueue;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;


public class GUI implements ActionListener{
	private static JFrame window;

	protected GUI() {
		EventQueue.invokeLater(() -> {
			window = new ConfigScreen(this);
			window.setVisible(true);
        });

	}
	
	public static void main(String[] args) {
		GUI x = new GUI();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object origin = e.getSource();
		
		if(origin instanceof JButton) {
			JButton button = (JButton) origin;
			if(button.getText().equals("Schedule!")){
				ConfigScreen cs = (ConfigScreen) window;
				String[] links = cs.getLinks();
				String[] rooms = cs.getRooms();
				Scheduler s = new Scheduler(cs.getSheet());
				ArrayList<InvitedStudent> al = s.schedule();
				window.setVisible(false);
				window = new ResultsScreen(this, s, cs.getMap(), cs.getDir(), links, rooms, al);
				window.setVisible(true);
			}
		}

		
	}
}
