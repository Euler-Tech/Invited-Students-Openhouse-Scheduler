package com.gmail.eulertech.smcs2022.invitedstudentopenhousescheduler;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.util.ArrayList;
import javax.swing.*;

import com.itextpdf.text.DocumentException;

public class ResultsScreen extends JFrame implements ActionListener{

	private File map;
	private String[] rooms;
	private File dir;
	private String[] links;
	private ArrayList<InvitedStudent> al;
	private JLabel statusText;
	private JButton proceed;
	
	public static JPanel makeTitle(int x, int y, String text, Font font) {
		JPanel out = new JPanel();
		JLabel textArea;
		out.setAlignmentX(Component.CENTER_ALIGNMENT);
		out.setPreferredSize(new Dimension(x, y));
		textArea = new JLabel(text);
        textArea.setFont(font);
        out.add(textArea);
        
        return out;
	}
	
	public ResultsScreen(ActionListener l, Scheduler s, File map, File dir, String[] links, String[] rooms, ArrayList<InvitedStudent> al) {
		this.map = map;
		this.rooms = rooms;
		this.dir = dir;
		this.links = links;
		this.al = al;
		setTitle("Confirmation");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    setSize(750,900);
	    setResizable(false);
	    
	    Font font = new Font("Times New Roman", Font.BOLD, 30);
	    add(makeTitle(400, 50, "Results", font), BorderLayout.NORTH);
	    
	    JPanel overall = new JPanel();
	    overall.setLayout(new BoxLayout(overall, BoxLayout.Y_AXIS));
	    
	    JPanel grid = new JPanel();
	    grid.setLayout(new GridLayout(5,5));
	    
	    grid.add(new JLabel(""));
	    grid.add(new JLabel("General Session"));
	    grid.add(new JLabel("SMCS Session"));
	    grid.add(new JLabel("Global Session"));
	    grid.add(new JLabel("Humanities Session"));
	    
	    for(int i = 0; i < 4; i++) {
	    	grid.add(new JLabel("Session " + (i+1)));
	    	JLabel num = new JLabel("" + s.getGeneral(i).size());
	    	if(s.getGeneral(i).size() > 70) {
	    		num.setForeground(Color.RED);
	    	}
	    	grid.add(num);

	    	num = new JLabel("" + s.getSMCS(i).size());
	    	if(s.getSMCS(i).size() > 50) {
	    		num.setForeground(Color.RED);
	    	}
	    	grid.add(num);
	    	
	    	num = new JLabel("" + s.getGlobal(i).size());
	    	if(s.getGlobal(i).size() > 50) {
	    		num.setForeground(Color.RED);
	    	}
	    	grid.add(num);
	    	
	    	num = new JLabel("" + s.getHumanities(i).size());
	    	if(s.getHumanities(i).size() > 50) {
	    		num.setForeground(Color.RED);
	    	}
	    	grid.add(num);	    	
	    }
	    
	    overall.add(grid);
	    
	    JPanel confirm = new JPanel();
		proceed = new JButton("Proceed");
		statusText = new JLabel("Click to generate pdfs");
		proceed.addActionListener(this);
		confirm.add(proceed);
		confirm.add(statusText);
		
		overall.add(confirm);
		
		add(overall);
	
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object origin = e.getSource();
		
		if(origin instanceof JButton) {
			JButton button = (JButton) origin;
			if(button.getText().equals("Proceed")){
				statusText.setText("Generating");
				for(InvitedStudent is : al) {
					PDFGenerator p = new PDFGenerator(is, map.getAbsolutePath(),rooms,dir.getAbsolutePath() + "\\",links);
					try {
						p.generate();
					} catch (DocumentException e1) {
						System.out.println("????");
					}
				}
				proceed.setVisible(false);
				statusText.setText("Complete!");
			}
		}
		
	}
	
}
