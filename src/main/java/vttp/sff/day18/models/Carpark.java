package vttp.sff.day18.models;

public class Carpark {

    private Integer id;

    private String name;

    private String category;

    private String weekday1Rate;

    private String weekday2Rate;

    private String saturdayRate;

    private String sundayPhRate;

    public Carpark(Integer id, String name, String category, String weekday1Rate, String weekday2Rate,
            String saturdayRate, String sundayPhRate) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.weekday1Rate = weekday1Rate;
        this.weekday2Rate = weekday2Rate;
        this.saturdayRate = saturdayRate;
        this.sundayPhRate = sundayPhRate;
    }
    
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

    public String getWeekday1Rate() { return weekday1Rate; }
    public void setWeekday1Rate(String weekday1Rate) { this.weekday1Rate = weekday1Rate; }

    public String getWeekday2Rate() { return weekday2Rate; }
    public void setWeekday2Rate(String weekday2Rate) { this.weekday2Rate = weekday2Rate; }

    public String getSaturdayRate() { return saturdayRate; }
    public void setSaturdayRate(String saturdayRate) { this.saturdayRate = saturdayRate; }

    public String getSundayPhRate() { return sundayPhRate; }
    public void setSundayPhRate(String sundayPhRate) { this.sundayPhRate = sundayPhRate; }


    @Override
    public String toString() {
        return "Carpark [id=" + id + ", name=" + name + ", category=" + category + ", weekday1Rate=" + weekday1Rate
                + ", weekday2Rate=" + weekday2Rate + ", saturdayRate=" + saturdayRate + ", sundayPhRate=" + sundayPhRate
                + "]";
    }  
    
}
