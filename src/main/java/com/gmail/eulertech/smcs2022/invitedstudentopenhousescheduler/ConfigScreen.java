package com.gmail.eulertech.smcs2022.invitedstudentopenhousescheduler;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileSystemView;

import org.apache.poi.util.IOUtils;

import com.itextpdf.text.DocumentException;

public class ConfigScreen extends JFrame implements ActionListener{
	private static JFileChooser j = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
	private File map;
	private File dir = FileSystemView.getFileSystemView().getHomeDirectory();
	private File sheet;
	private JLabel selectedFile;
	private JLabel selectedDir;
	private JLabel selectedSheet;
	private TextArea clubs;
	private TextArea trans;
	private TextArea accept;
	private TextArea phs;
	private TextArea comm;
	private TextArea sports;
	private TextArea intro;
	private TextArea genP;
	private TextArea genS;
	private TextArea glob;
	private TextArea smcs;
	private TextArea hum;
	
	
	private static File chooseFile() {

		j.setFileSelectionMode(JFileChooser.FILES_ONLY);
		int r = j.showOpenDialog(null);

		if (r == JFileChooser.APPROVE_OPTION)
			return j.getSelectedFile();
		else {
			return null; 
		}
	}
	
	private static File chooseDirectory() {

		j.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		int r = j.showOpenDialog(null);

		if (r == JFileChooser.APPROVE_OPTION)
			return j.getSelectedFile();
		else {
			return null; 
		}
	}
	

	
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
	
	public ConfigScreen(ActionListener l) {
		InputStream mapStream = getClass().getResourceAsStream("/MainBuildingMapforInvitedNight.fw.png");
		InputStream sheetStream = getClass().getResourceAsStream("/Sample.xlsx");
		try {
			map = File.createTempFile("TempMap", "png");
			map.deleteOnExit();
			IOUtils.copy(mapStream, map);

			sheet = File.createTempFile("TempSheet", "xlsx");
			sheet.deleteOnExit();
			IOUtils.copy(sheetStream, sheet);
		} catch (IOException e) {
		}
		setTitle("Configuration");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    setSize(750,900);
	    
	    Font font = new Font("Times New Roman", Font.BOLD, 30);
	    add(makeTitle(400, 50, "Configuration", font), BorderLayout.NORTH);
	    
	    JPanel overall = new JPanel();
	    overall.setLayout(new BoxLayout(overall,BoxLayout.Y_AXIS));

        overall.add(new JSeparator(SwingConstants.HORIZONTAL));
	    JPanel file = new JPanel();
		file.setLayout(new BoxLayout(file,BoxLayout.X_AXIS));
		JButton button = new JButton("Choose map image...");
		button.addActionListener(this);
		file.add(Box.createVerticalStrut(2));
		file.add(button);
		selectedFile = new JLabel(map.getName());
		file.add(Box.createVerticalStrut(1));
		file.add(selectedFile);
		file.add(Box.createVerticalStrut(2));
		overall.add(file);
		overall.add(Box.createVerticalStrut(5));
		overall.add(new JSeparator(SwingConstants.HORIZONTAL));
		overall.add(Box.createVerticalStrut(5));
		
		JPanel urlPanel = new JPanel();
		urlPanel.setLayout(new BoxLayout(urlPanel, BoxLayout.X_AXIS));
		urlPanel.add(Box.createHorizontalStrut(10));
		
		JPanel urls = new JPanel();
		urls.setLayout(new GridLayout(6,2));
		urls.add(new JLabel("Clubs URL"));
		clubs = new TextArea("https://www2.montgomeryschoolsmd.org/schools/poolesvillehs/clubs/");
		urls.add(clubs);
		urls.add(new JLabel("Transportation URL"));
		trans = new TextArea("https://www2.montgomeryschoolsmd.org/schools/poolesvillehs/about/busroutes/");
		urls.add(trans);
		urls.add(new JLabel("Acceptance List URL"));
		accept = new TextArea("https://www2.montgomeryschoolsmd.org/siteassets/schools/high-schools/k-q/poolesvillehs/uploadedfiles/magnet/collegeacceptedlistclassof2019.pdf");
		urls.add(accept);
		urls.add(new JLabel("PHS URL"));
		phs = new TextArea("https://www2.montgomeryschoolsmd.org/schools/poolesvillehs/");
		urls.add(phs);
		urls.add(new JLabel("Communication URL"));
		comm = new TextArea("https://www2.montgomeryschoolsmd.org/siteassets/schools/high-schools/k-q/poolesvillehs/uploadedfiles/magnet/phslistserves.pdf");
		urls.add(comm);
		urls.add(new JLabel("Sports URL"));
		sports = new TextArea("https://www2.montgomeryschoolsmd.org/siteassets/schools/high-schools/k-q/poolesvillehs/uploadedfiles/athletics/sports.pdf");
		urls.add(sports);
		
		urlPanel.add(urls);
		urlPanel.add(Box.createHorizontalStrut(10));
		
		overall.add(urlPanel);
		overall.add(Box.createVerticalStrut(5));
		overall.add(new JSeparator(SwingConstants.HORIZONTAL));
		overall.add(Box.createVerticalStrut(5));
		
		JPanel roomPanel = new JPanel();
		roomPanel.setLayout(new BoxLayout(roomPanel, BoxLayout.X_AXIS));
		roomPanel.add(Box.createHorizontalStrut(10));
		
		JPanel rooms = new JPanel();
		rooms.setLayout(new GridLayout(6,2));
		rooms.add(new JLabel("Introduction Room"));
		intro = new TextArea("Auditorium");
		rooms.add(intro);
		rooms.add(new JLabel("General Parents Room"));
		genP = new TextArea("Media Center");
		rooms.add(genP);
		rooms.add(new JLabel("General Students Room"));
		genS = new TextArea("Room 41");
		rooms.add(genS);
		rooms.add(new JLabel("Global Room"));
		glob = new TextArea("Room 33");
		rooms.add(glob);
		rooms.add(new JLabel("SMCS Room"));
		smcs = new TextArea("Room 195");
		rooms.add(smcs);
		rooms.add(new JLabel("Humanities Room"));
		hum = new TextArea("Room 8");
		rooms.add(hum);
		
		roomPanel.add(rooms);
		roomPanel.add(Box.createHorizontalStrut(10));
		
		overall.add(roomPanel);
		overall.add(Box.createVerticalStrut(5));
		overall.add(new JSeparator(SwingConstants.HORIZONTAL));
		overall.add(Box.createVerticalStrut(5));
		
		JPanel output = new JPanel();
		output.setLayout(new BoxLayout(output,BoxLayout.X_AXIS));
		JButton button2 = new JButton("Choose Output Location...");
		button2.addActionListener(this);
		output.add(Box.createVerticalStrut(2));
		output.add(button2);
		selectedDir = new JLabel(dir == null ? "Choose" : dir.getName());
		output.add(Box.createVerticalStrut(1));
		output.add(selectedDir);
		output.add(Box.createVerticalStrut(2));
		overall.add(output);
		

		overall.add(Box.createVerticalStrut(5));
		overall.add(new JSeparator(SwingConstants.HORIZONTAL));
		overall.add(Box.createVerticalStrut(5));
		
		JPanel preview = new JPanel();
		JButton button3 = new JButton("Preview Sample");
		button3.addActionListener(this);
		preview.add(button3);
		
		overall.add(preview);
		overall.add(Box.createVerticalStrut(5));
		overall.add(new JSeparator(SwingConstants.HORIZONTAL));
		overall.add(Box.createVerticalStrut(5));
		
		JPanel input = new JPanel();
		input.setLayout(new BoxLayout(input,BoxLayout.X_AXIS));
		JButton button4 = new JButton("Choose Input Student Spreadsheet...");
		button4.addActionListener(this);
		input.add(Box.createVerticalStrut(2));
		input.add(button4);
		selectedSheet = new JLabel(sheet == null ? "Choose" : sheet.getName());
		input.add(Box.createVerticalStrut(1));
		input.add(selectedSheet);
		input.add(Box.createVerticalStrut(2));
		overall.add(input);

		overall.add(Box.createVerticalStrut(5));
		overall.add(new JSeparator(SwingConstants.HORIZONTAL));
		overall.add(Box.createVerticalStrut(5));
		
		JPanel schedule = new JPanel();
		JButton button5 = new JButton("Schedule!");
		button5.addActionListener(l);
		schedule.add(button5);
		overall.add(schedule);
		
		add(overall);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object origin = e.getSource();
		
		if(origin instanceof JButton) {
			JButton button = (JButton) origin;
			if(button.getText().equals("Choose map image...")){
				File x = chooseFile();
				if(x == null) return;
				try {
					if(ImageIO.read(x) != null) {
						map = x;
						selectedFile.setVisible(false);
						selectedFile.setText(map.getName());
						selectedFile.setVisible(true);
					} else {
						selectedFile.setVisible(false);
						selectedFile.setText("That was not a valid image");
						selectedFile.setVisible(true);
						TimeUnit.SECONDS.sleep(1);
						selectedFile.setVisible(false);
						selectedFile.setText(map.getName());
						selectedFile.setVisible(true);
					}
				} catch (IOException e1) {
					selectedFile.setVisible(false);
					selectedFile.setText("That was not a valid image");
					selectedFile.setVisible(true);
					try {
						TimeUnit.SECONDS.sleep(1);
					} catch (InterruptedException e2) {
					}
					selectedFile.setVisible(false);
					selectedFile.setText(map.getName());
					selectedFile.setVisible(true);
				} catch (InterruptedException e1) {
				}
			} else if(button.getText().equals("Choose Output Location...")){
				dir = chooseDirectory();
				if(dir == null) return;
				selectedDir.setVisible(false);
				selectedDir.setText(dir.getName());
				selectedDir.setVisible(true);
			} else if(button.getText().equals("Preview Sample")) {
				InvitedStudent bob = new InvitedStudent(true, false, false, "Sample");
				bob.setSchedule(0, "g");
				bob.setSchedule(1, "m");
				bob.setSchedule(2, "gen");
				bob.setSchedule(3, "h");
				String[] f = {clubs.getText(), trans.getText(), accept.getText(), phs.getText(), comm.getText(), sports.getText()};
				String[] r = new String[]{intro.getText(), genP.getText(), genS.getText(), glob.getText(), smcs.getText(), hum.getText()};
				System.out.println(dir.getAbsolutePath());
				PDFGenerator x = new PDFGenerator(bob, map.getAbsolutePath(), r, dir.getAbsolutePath() + "\\", f);
				try {
					x.generate();
				} catch (DocumentException e1) {
				}
				try {
					Desktop.getDesktop().open(new File(dir.getAbsolutePath()+"\\SampleSchedule.pdf"));
				} catch (IOException e1) {
				}
			} else if(button.getText().equals("Choose Input Student Spreadsheet...")) {
				File x = chooseFile();
				if(x.getName().endsWith(".xlsx")) {
					sheet = x;
					selectedSheet.setVisible(false);
					selectedSheet.setText(sheet.getName());
					selectedSheet.setVisible(true);
				}
			}
		}
		
	}
	
	public String[] getLinks() {
		return new String[]{clubs.getText(), trans.getText(), accept.getText(), phs.getText(), comm.getText(), sports.getText()};
	}
	
	public String[] getRooms() {
		return new String[]{intro.getText(), genP.getText(), genS.getText(), glob.getText(), smcs.getText(), hum.getText()};
	}
	
	public File getMap() {
		return map;
	}

	public File getDir() {
		return dir;
	}

	public File getSheet() {
		return sheet;
	}
}
