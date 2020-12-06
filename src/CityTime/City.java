package CityTime;

import java.time.LocalDateTime;
import java.time.ZoneId;

public class City implements ClockInterface, Comparable<City>, Runnable {

    protected String name;
    protected String code;
    protected Double gmtDifference;

    public City(String name, String code, Double gmtDifference) {
        this.name = name;
        this.code = code;
        this.gmtDifference = gmtDifference;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Double getGmtDifference() {
        return gmtDifference;
    }

    public void setGmtDifference(Double gmtDifference) {
        this.gmtDifference = gmtDifference;
    }

    @Override
    public void showTime() {
        LocalDateTime dateTime = LocalDateTime.now(ZoneId.of("GMT"));
        System.out.println(getName() + " : " + dateTime.plusMinutes((long) (gmtDifference * 60)));
    }

    @Override
    public int compareTo(City city) {
        return name.compareTo(city.getName());
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(2000);
                showTime();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public String toString() {
        return name;
    }

}
