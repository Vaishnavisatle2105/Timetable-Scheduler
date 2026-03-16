package com.model;



public class Timetable {

    private int tt_id;
    private String sem;
    private String day;
    private String time_slot;
    private String sub_abbr;
    private int fac_id;
    private int room_id;
    private int dept_id;
    private String year;
   

    public Timetable() {
		super();
	}
	public Timetable(String sem, String day, String time_slot, String sub_abbr, int fac_id, int room_id, int dept_id,String year) {

		this.sem = sem;
		this.day = day;
		this.time_slot = time_slot;
		this.sub_abbr = sub_abbr;
		this.fac_id = fac_id;
		this.room_id = room_id;
		this.dept_id = dept_id;
		this.year=year;
	}
	public Timetable(int tt_id, String sem, String day, String time_slot, String sub_abbr, int fac_id, int room_id,
			int dept_id,String year) {

		this.tt_id = tt_id;
		this.sem = sem;
		this.day = day;
		this.time_slot = time_slot;
		this.sub_abbr = sub_abbr;
		this.fac_id = fac_id;
		this.room_id = room_id;
		this.dept_id = dept_id;
		this.year=year;
	}
	

	public int getTt_id() { return tt_id; }
    public void setTt_id(int tt_id) { this.tt_id = tt_id; }

    public String getSem() { return sem; }
    public void setSem(String sem) { this.sem = sem; }

    public String getDay() { return day; }
    public void setDay(String day) { this.day = day; }

    public String getTime_slot() { return time_slot; }
    public void setTime_slot(String time_slot) { this.time_slot = time_slot; }

    public String getSub_abbr() { return sub_abbr; }
    public void setSub_abbr(String sub_abbr) { this.sub_abbr = sub_abbr; }

    public int getFac_id() { return fac_id; }
    public void setFac_id(int fac_id) { this.fac_id = fac_id; }

    public int getRoom_id() { return room_id; }
    public void setRoom_id(int room_id) { this.room_id = room_id; }

    public int getDept_id() { return dept_id; }
    public void setDept_id(int dept_id) { this.dept_id = dept_id; }
    
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
}

