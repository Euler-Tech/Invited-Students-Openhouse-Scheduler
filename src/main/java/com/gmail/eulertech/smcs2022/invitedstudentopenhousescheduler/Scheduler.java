package com.gmail.eulertech.smcs2022.invitedstudentopenhousescheduler;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Scheduler {

	
	private ArrayList<InvitedStudent> onemArr;
	private ArrayList<InvitedStudent> onegArr;
	private ArrayList<InvitedStudent> onehArr;
	private ArrayList<InvitedStudent> twomgArr;
	private ArrayList<InvitedStudent> twomhArr;
	private ArrayList<InvitedStudent> twoghArr;
	private ArrayList<InvitedStudent> threeArr;
	private ArrayList<InvitedStudent> total;
	private ArrayList<InvitedStudent>[] general;
	private ArrayList<InvitedStudent>[] smcs;
	private ArrayList<InvitedStudent>[] global;
	private ArrayList<InvitedStudent>[] hum;
	private String sheet;
	
	public Scheduler(File sheet) {
		this.sheet = sheet.getAbsolutePath();
	}

	private void editTwoGH(int gen, int i1, int i2, int two) {
		general[gen].add(twoghArr.get(0));
		if(global[i1].size() < 50 && hum[i2].size() < 50) {
			global[i1].add(twoghArr.get(0));
			hum[i2].add(twoghArr.get(0));
			twoghArr.remove(0);
		}
		else if(global[i2].size() < 50 && hum[i1].size() < 50) {
			global[i2].add(twoghArr.get(0));
			hum[i1].add(twoghArr.get(0));
			twoghArr.remove(0);
		} else if(global[i2].size() < 50 || hum[i1].size() < 50) {
			global[i2].add(twoghArr.get(0));
			hum[i1].add(twoghArr.get(0));
			twoghArr.remove(0);
		} else if(global[i1].size() < 50 || hum[i2].size() < 50) {
			global[i1].add(twoghArr.get(0));
			hum[i2].add(twoghArr.get(0));
			twoghArr.remove(0);
		} else if(two % 2 == 0) {
			global[i1].add(twoghArr.get(0));
			hum[i2].add(twoghArr.get(0));
			twoghArr.remove(0);
		} else {
			global[i2].add(twoghArr.get(0));
			hum[i1].add(twoghArr.get(0));
			twoghArr.remove(0);
		}
	}
	
	private void editTwoMH(int gen, int i1, int i2, int two) {
		general[gen].add(twomhArr.get(0));
		if(smcs[i1].size() < 50 && hum[i2].size() < 50) {
			smcs[i1].add(twomhArr.get(0));
			hum[i2].add(twomhArr.get(0));
			twomhArr.remove(0);
		}
		else if(smcs[i2].size() < 50 && hum[i1].size() < 50) {
			smcs[i2].add(twomhArr.get(0));
			hum[i1].add(twomhArr.get(0));
			twomhArr.remove(0);
		} else if(smcs[i2].size() < 50 || hum[i1].size() < 50) {
			smcs[i2].add(twomhArr.get(0));
			hum[i1].add(twomhArr.get(0));
			twomhArr.remove(0);
		} else if(smcs[i1].size() < 50 || hum[i2].size() < 50) {
			smcs[i1].add(twomhArr.get(0));
			hum[i2].add(twomhArr.get(0));
			twomhArr.remove(0);
		} else if(two % 2 == 0) {
			smcs[i1].add(twomhArr.get(0));
			hum[i2].add(twomhArr.get(0));
			twomhArr.remove(0);
		} else {
			smcs[i2].add(twomhArr.get(0));
			hum[i1].add(twomhArr.get(0));
			twomhArr.remove(0);
		}
	}
	
	private void editTwoMG(int gen, int i1, int i2, int two) {
		general[gen].add(twomgArr.get(0));
		if(smcs[i1].size() < 50 && global[i2].size() < 50) {
			smcs[i1].add(twomgArr.get(0));
			global[i2].add(twomgArr.get(0));
			twomgArr.remove(0);
		}
		else if(smcs[i2].size() < 50 && global[i1].size() < 50) {
			smcs[i2].add(twomgArr.get(0));
			global[i1].add(twomgArr.get(0));
			twomgArr.remove(0);
		} else if(smcs[i2].size() < 50 || global[i1].size() < 50) {
			smcs[i2].add(twomgArr.get(0));
			global[i1].add(twomgArr.get(0));
			twomgArr.remove(0);
		} else if(smcs[i1].size() < 50 || global[i2].size() < 50) {
			smcs[i1].add(twomgArr.get(0));
			global[i2].add(twomgArr.get(0));
			twomgArr.remove(0);
		} else if(two % 2 == 0) {
			smcs[i1].add(twomgArr.get(0));
			global[i2].add(twomgArr.get(0));
			twomgArr.remove(0);
		} else {
			smcs[i2].add(twomgArr.get(0));
			global[i1].add(twomgArr.get(0));
			twomgArr.remove(0);
		}
	}
	
	private void editThree(int gen, int i1, int i2, int i3) {
		general[gen].add(threeArr.get(0));
		int[][] permute = new int[][] {
			{i1,i2,i3},
			{i1,i3,i2},
			{i2,i1,i3},
			{i2,i3,i1},
			{i3,i1,i2},
			{i3,i2,i1}			
		};
		
		for(int i = 0; i < permute.length; i++) {
			boolean b1 = smcs[permute[i][0]].size() < 50;
			boolean b2 = global[permute[i][1]].size() < 50;
			boolean b3 = hum[permute[i][2]].size() < 50;
			if(b1 && b2 && b3) {
				smcs[permute[i][0]].add(threeArr.get(0));
				global[permute[i][1]].add(threeArr.get(0));
				hum[permute[i][2]].add(threeArr.get(0));
				threeArr.remove(0);
				return;
			}
		}
		
		for(int i = 0; i < permute.length; i++) {
			boolean b1 = smcs[permute[i][0]].size() < 50;
			boolean b2 = global[permute[i][1]].size() < 50;
			boolean b3 = hum[permute[i][2]].size() < 50;
			if(b1 && b2 || b1 && b3 || b2 && b3) {
				smcs[permute[i][0]].add(threeArr.get(0));
				global[permute[i][1]].add(threeArr.get(0));
				hum[permute[i][2]].add(threeArr.get(0));
				threeArr.remove(0);
				return;
			}
		}
		
		for(int i = 0; i < permute.length; i++) {
			boolean b1 = smcs[permute[i][0]].size() < 50;
			boolean b2 = global[permute[i][1]].size() < 50;
			boolean b3 = hum[permute[i][2]].size() < 50;
			if(b1 || b2 || b3) {
				smcs[permute[i][0]].add(threeArr.get(0));
				global[permute[i][1]].add(threeArr.get(0));
				hum[permute[i][2]].add(threeArr.get(0));
				threeArr.remove(0);
				return;
			}
		}

		smcs[permute[threeArr.size()%6][0]].add(threeArr.get(0));
		global[permute[threeArr.size()%6][1]].add(threeArr.get(0));
		hum[permute[threeArr.size()%6][2]].add(threeArr.get(0));
		threeArr.remove(0);
	}

	public ArrayList<InvitedStudent> schedule() {
		ExcelReader er = new ExcelReader(sheet);
		onemArr = new ArrayList<InvitedStudent>();
		onegArr = new ArrayList<InvitedStudent>();
		onehArr = new ArrayList<InvitedStudent>();
		twomgArr = new ArrayList<InvitedStudent>();
		twomhArr = new ArrayList<InvitedStudent>();
		twoghArr = new ArrayList<InvitedStudent>();
		threeArr = new ArrayList<InvitedStudent>();
		total = new ArrayList<InvitedStudent>();
		for(int i = 1; i < er.getRowCount(0); i++) {
			boolean e = er.getString(0,i,3).strip().equals("Yes");
			boolean h = er.getString(0,i,4).strip().equals("Yes");
			boolean m = er.getString(0,i,5).strip().equals("Yes");
			String name = er.getString(0, i, 1);
			InvitedStudent is = new InvitedStudent(m,e,h, name);
			total.add(is);
			switch(is.getNumberOfInvitations()) {
			case 1:
				if(is.isGlob()) onegArr.add(is);
				if(is.isHum()) onehArr.add(is);
				if(is.isSmcs()) onemArr.add(is);
				break;
			case 2:
				if(is.isGlob() && is.isHum()) twoghArr.add(is);
				if(is.isGlob() && is.isSmcs()) twomgArr.add(is);
				if(is.isHum() && is.isSmcs()) twomhArr.add(is);
				break;
			case 3:
				threeArr.add(is);
				break;
			default:
				System.out.println("Error: the student with name " + name + " is listed as having an invalid number invitations (" + is.getNumberOfInvitations() + ").");
			}
		}
		
		System.out.println(onegArr.size());
		System.out.println(onehArr.size());
		System.out.println(onemArr.size());
		System.out.println(twoghArr.size());
		System.out.println(twomhArr.size());
		System.out.println(twomgArr.size());
		System.out.println(threeArr.size());
		
		
		general = new ArrayList[] {new ArrayList<InvitedStudent>(), new ArrayList<InvitedStudent>(), new ArrayList<InvitedStudent>(), new ArrayList<InvitedStudent>()};
		smcs = new ArrayList[] {new ArrayList<InvitedStudent>(), new ArrayList<InvitedStudent>(), new ArrayList<InvitedStudent>(), new ArrayList<InvitedStudent>()};
		global = new ArrayList[] {new ArrayList<InvitedStudent>(), new ArrayList<InvitedStudent>(), new ArrayList<InvitedStudent>(), new ArrayList<InvitedStudent>()};
		hum = new ArrayList[] {new ArrayList<InvitedStudent>(), new ArrayList<InvitedStudent>(), new ArrayList<InvitedStudent>(), new ArrayList<InvitedStudent>()};
		
		for(int i = 0; i < 10; i++) {
			general[0].add(threeArr.get(0));
			smcs[1].add(threeArr.get(0));
			global[2].add(threeArr.get(0));
			hum[3].add(threeArr.get(0));
			threeArr.remove(0);
			
			general[1].add(threeArr.get(0));
			smcs[2].add(threeArr.get(0));
			global[3].add(threeArr.get(0));
			hum[0].add(threeArr.get(0));
			threeArr.remove(0);
			
			general[2].add(threeArr.get(0));
			smcs[3].add(threeArr.get(0));
			global[0].add(threeArr.get(0));
			hum[1].add(threeArr.get(0));
			threeArr.remove(0);
			
			general[3].add(threeArr.get(0));
			smcs[0].add(threeArr.get(0));
			global[1].add(threeArr.get(0));
			hum[2].add(threeArr.get(0));
			threeArr.remove(0);
		}

		while(onemArr.size() > 0) {
			if(onemArr.size() % 2 == 0) {
				general[0].add(onemArr.get(0));
				smcs[1].add(onemArr.get(0));
				onemArr.remove(0);
			} else {
				general[1].add(onemArr.get(0));
				smcs[0].add(onemArr.get(0));
				onemArr.remove(0);
			}

			
		}
		while(onegArr.size() > 0) {
			if(onegArr.size() % 2 == 0) {
				general[0].add(onegArr.get(0));
				global[1].add(onegArr.get(0));
				onegArr.remove(0);
			} else {
				general[1].add(onegArr.get(0));
				global[0].add(onegArr.get(0));
				onegArr.remove(0);
			}

			
		}
		while(onehArr.size() > 0) {
			if(onehArr.size() % 2 == 0) {
				general[0].add(onehArr.get(0));
				hum[1].add(onehArr.get(0));
				onehArr.remove(0);
			} else {
				general[1].add(onehArr.get(0));
				hum[0].add(onehArr.get(0));
				onehArr.remove(0);
			}

			
		}
		int two = twoghArr.size()+twomhArr.size()+twomgArr.size();
		while(twoghArr.size() > 0 && twomhArr.size() > 0 && twomgArr.size() > 0) {
			two = twoghArr.size()+twomhArr.size()+twomgArr.size();
			switch(two % 3) {

				case 0:
					if(general[2].size() < 70){
						editTwoGH(2, 0, 1, two);
					} 
					else if(general[0].size() < 70) {
						editTwoGH(0, 1, 2, two);
					}
					else if(general[1].size() < 70) {
						editTwoGH(2, 1, 0, two);
					}
					else { //if need to overfill, even distribution
						switch(two % 9) {
							case 0:
								editTwoGH(2, 0, 1, two);
								break;
							case 3:
								editTwoGH(0, 1, 2, two);
								break;
							case 6:
								editTwoGH(2, 1, 0, two);
								break;
						}
					
					} //end evenly overdistribute
					
					break;

				case 1:
					if(general[2].size() < 70){
						editTwoMH(2, 0, 1, two);
					} 
					else if(general[0].size() < 70) {
						editTwoMH(0, 1, 2, two);
					}
					else if(general[1].size() < 70) {
						editTwoMH(2, 1, 0, two);
					}
					else { //if need to overfill, even distribution
						switch(two % 9) {
							case 1:
								editTwoMH(2, 0, 1, two);
								break;
							case 4:
								editTwoMH(0, 1, 2, two);
								break;
							case 7:
								editTwoMH(2, 1, 0, two);
								break;
						}
					
					} //end evenly overdistribute
					
					break;

				case 2:
					if(general[2].size() < 70){
						editTwoMG(2, 0, 1, two);
					} 
					else if(general[0].size() < 70) {
						editTwoMG(0, 1, 2, two);
					}
					else if(general[1].size() < 70) {
						editTwoMG(2, 1, 0, two);
					}
					else { //if need to overfill, even distribution
						switch(two % 9) {
							case 2:
								editTwoMG(2, 0, 1, two);
								break;
							case 5:
								editTwoMG(0, 1, 2, two);
								break;
							case 8:
								editTwoMG(2, 1, 0, two);
								break;
						}
					
					} //end evenly overdistribute
					
					break;
				

			}
		} // end even distribute all 3
		
		if(twoghArr.size() == 0) {
			two = twoghArr.size() + twomhArr.size() + twomgArr.size();
			while(twomhArr.size() > 0 && twomgArr.size() > 0) {
				switch(two % 2) {
					case 0:
						if(general[2].size() < 70){
							editTwoMH(2, 0, 1, two);
						} 
						else if(general[0].size() < 70) {
							editTwoMH(0, 1, 2, two);
						}
						else if(general[1].size() < 70) {
							editTwoMH(2, 1, 0, two);
						}
						else { //if need to overfill, even distribution
							switch(two % 6) {
								case 0:
									editTwoMH(2, 0, 1, two);
									break;
								case 2:
									editTwoMH(0, 1, 2, two);
									break;
								case 4:
									editTwoMH(2, 1, 0, two);
									break;
							}
						
						} //end evenly overdistribute
						
						break;
						
					case 1:
						if(general[2].size() < 70){
							editTwoMG(2, 0, 1, two);
						} 
						else if(general[0].size() < 70) {
							editTwoMG(0, 1, 2, two);
						}
						else if(general[1].size() < 70) {
							editTwoMG(2, 1, 0, two);
						}
						else { //if need to overfill, even distribution
							switch(two % 6) {
								case 1:
									editTwoMG(2, 0, 1, two);
									break;
								case 3:
									editTwoMG(0, 1, 2, two);
									break;
								case 5:
									editTwoMG(2, 1, 0, two);
									break;
							}
						
						} //end evenly overdistribute
						break;
				}
			}
		}
		
		else if (twomhArr.size() == 0) {
			two = twoghArr.size() + twomhArr.size() + twomgArr.size();
			while(twoghArr.size() > 0 && twomgArr.size() > 0) {
				switch(two % 2) {
					case 0:
						if(general[2].size() < 70){
							editTwoGH(2, 0, 1, two);
						} 
						else if(general[0].size() < 70) {
							editTwoGH(0, 1, 2, two);
						}
						else if(general[1].size() < 70) {
							editTwoGH(2, 1, 0, two);
						}
						else { //if need to overfill, even distribution
							switch(two % 6) {
								case 0:
									editTwoGH(2, 0, 1, two);
									break;
								case 2:
									editTwoGH(0, 1, 2, two);
									break;
								case 4:
									editTwoGH(2, 1, 0, two);
									break;
							}
						
						} //end evenly overdistribute
						break;
						
					case 1:
						if(general[2].size() < 70){
							editTwoMG(2, 0, 1, two);
						} 
						else if(general[0].size() < 70) {
							editTwoMG(0, 1, 2, two);
						}
						else if(general[1].size() < 70) {
							editTwoMG(2, 1, 0, two);
						}
						else { //if need to overfill, even distribution
							switch(two % 6) {
								case 1:
									editTwoMG(2, 0, 1, two);
									break;
								case 3:
									editTwoMG(0, 1, 2, two);
									break;
								case 5:
									editTwoMG(2, 1, 0, two);
									break;
							}
						
						} //end evenly overdistribute
						break;
				}
			}
		}
		
		else {
			two = twoghArr.size() + twomhArr.size() + twomgArr.size();
			while(twoghArr.size() > 0 && twomhArr.size() > 0) {
				switch(two % 2) {
					case 0:
						if(general[2].size() < 70){
							editTwoGH(2, 0, 1, two);
						} 
						else if(general[0].size() < 70) {
							editTwoGH(0, 1, 2, two);
						}
						else if(general[1].size() < 70) {
							editTwoGH(2, 1, 0, two);
						}
						else { //if need to overfill, even distribution
							switch(two % 6) {
								case 0:
									editTwoGH(2, 0, 1, two);
									break;
								case 2:
									editTwoGH(0, 1, 2, two);
									break;
								case 4:
									editTwoGH(2, 1, 0, two);
									break;
							}
						
						} //end evenly overdistribute
						break;
						
					case 1:
						if(general[2].size() < 70){
							editTwoMH(2, 0, 1, two);
						} 
						else if(general[0].size() < 70) {
							editTwoMH(0, 1, 2, two);
						}
						else if(general[1].size() < 70) {
							editTwoMH(2, 1, 0, two);
						}
						else { //if need to overfill, even distribution
							switch(two % 6) {
								case 1:
									editTwoMH(2, 0, 1, two);
									break;
								case 3:
									editTwoMH(0, 1, 2, two);
									break;
								case 5:
									editTwoMH(2, 1, 0, two);
									break;
							}
						
						} //end evenly overdistribute
						break;
				}
			}
		} //end even distrubution of remaining 2
		
		if(twoghArr.size() != 0) {
			while(twoghArr.size() != 0) {
				two = twoghArr.size() + twomhArr.size() + twomgArr.size();
				if(general[2].size() < 70){
					editTwoGH(2, 0, 1, two);
				} 
				else if(general[0].size() < 70) {
					editTwoGH(0, 1, 2, two);
				}
				else if(general[1].size() < 70) {
					editTwoGH(2, 1, 0, two);
				}
				else { //if need to overfill, even distribution
					switch(two % 3) {
						case 0:
							editTwoGH(2, 0, 1, two);
							break;
						case 1:
							editTwoGH(0, 1, 2, two);
							break;
						case 2:
							editTwoGH(2, 1, 0, two);
							break;
					}
				
				} //end evenly overdistribute
			}
		} else if(twomhArr.size() != 0) {
			while(twomhArr.size() != 0) {
				two = twoghArr.size() + twomhArr.size() + twomgArr.size();
				if(general[2].size() < 70){
					editTwoMH(2, 0, 1, two);
				} 
				else if(general[0].size() < 70) {
					editTwoMH(0, 1, 2, two);
				}
				else if(general[1].size() < 70) {
					editTwoMH(2, 1, 0, two);
				}
				else { //if need to overfill, even distribution
					switch(two % 3) {
						case 0:
							editTwoMH(2, 0, 1, two);
							break;
						case 1:
							editTwoMH(0, 1, 2, two);
							break;
						case 2:
							editTwoMH(2, 1, 0, two);
							break;
					}
				
				} //end evenly overdistribute
			}
		} else {
			while(twomgArr.size() != 0) {
				if(general[2].size() < 70){
					editTwoMG(2, 0, 1, two);
				} 
				else if(general[0].size() < 70) {
					editTwoMG(0, 1, 2, two);
				}
				else if(general[1].size() < 70) {
					editTwoMG(2, 1, 0, two);
				}
				else { //if need to overfill, even distribution
					switch(two % 3) {
						case 0:
							editTwoMG(2, 0, 1, two);
							break;
						case 1:
							editTwoMG(0, 1, 2, two);
							break;
						case 2:
							editTwoMG(2, 1, 0, two);
							break;
					}
				
				} //end evenly overdistribute
			}
		}
		
		
		while(threeArr.size() > 0) {
			if(general[3].size() < 70) {
				editThree(3, 0, 1, 2);
			} else if(general[0].size() < 70) {
				editThree(0, 1, 2, 3);
			} else if(general[1].size() < 70) {
				editThree(1, 0, 2, 3);
			} else if(general[2].size() < 70) {
				editThree(2, 0, 1, 3);
			} else {
				switch(threeArr.size() % 4) {
					case 0:
						editThree(3, 0, 1, 2);
						break;
					case 1:
						editThree(0, 1, 2, 3);
						break;
					case 2:
						editThree(1, 0, 2, 3);
						break;
					case 3:
						editThree(2, 0, 1, 3);
						break;
						
				}
			}
			
		}
		
		for(int i = 0; i < 4; i++) {
			for(InvitedStudent is : general[i]) {
				is.setSchedule(i,"gen");
			}
			for(InvitedStudent is : global[i]) {
				is.setSchedule(i,"g");
			}
			for(InvitedStudent is : smcs[i]) {
				is.setSchedule(i,"m");
			}
			for(InvitedStudent is : hum[i]) {
				is.setSchedule(i,"h");
			}
		}
		
		
		
		return total;
	}

	public ArrayList<InvitedStudent> getGeneral(int i) {
		return general[i];
	}

	public ArrayList<InvitedStudent> getGlobal(int i) {
		return global[i];
	}

	public ArrayList<InvitedStudent> getSMCS(int i) {
		return smcs[i];
	}

	public ArrayList<InvitedStudent> getHumanities(int i) {
		return hum[i];
	}
}
