import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * FinalData class.
 *
 * @author Xu Zheng
 * <p>
 * Andrew id: xuzheng
 */
public class FinalData implements Comparable<FinalData> {
    private String title;
    private int number;
    private LocalTime startTime;
    private LocalTime endTime;
    private DayOfWeek[] days;
    private List<String> instructors;

    public FinalData(String newTitle, int newNumber) {
        if (newTitle == null || newTitle.trim().equals("")) {
            throw new IllegalArgumentException("Illegal title");
        }
        if (newNumber <= 0) {
            throw new IllegalArgumentException("Illegal number");
        }
        title = newTitle;
        number = newNumber;
        instructors = new ArrayList<>();
    }

    public String getTitle() {
        return title;
    }

    public int getNumber() {
        return number;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public DayOfWeek[] getDays() {
        DayOfWeek[] re = new DayOfWeek[days.length];
        for (int i = 0; i < days.length; i++) {
            re[i] = days[i];
        }
        return re;
    }

    public List<String> getInstructors() {
        return new ArrayList<>(instructors);
    }

    public void setTitle(String newTitle) {
        if (newTitle == null || newTitle.trim().equals("")) {
            throw new IllegalArgumentException("Illegal title");
        }
        this.title = newTitle;
    }

    public void setNumber(int newNumber) {
        if (newNumber <= 0) {
            throw new IllegalArgumentException("Illegal number");
        }
        this.number = newNumber;
    }

    public void setStartTime(LocalTime newStartTime) {
        if (newStartTime == null) {
            throw new IllegalArgumentException("Illegal startTime");
        }
        this.startTime = newStartTime;
    }

    public void setEndTime(LocalTime newEndTime) {
        if (newEndTime == null) {
            throw new IllegalArgumentException("Illegal endTime");
        }
        this.endTime = newEndTime;
    }

    public void setDays(DayOfWeek[] newDays) {
        if (newDays == null || newDays.length == 0) {
            throw new IllegalArgumentException("Illegal days");
        }
        days = new DayOfWeek[newDays.length];
        for (int i = 0; i < days.length; i++) {
            days[i] = newDays[i];
        }
    }

    public void addInstructor(String name) {
        if (name == null || name.trim().equals("")) {
            throw new IllegalArgumentException("Illegal instructor name");
        }
        instructors.add(name);
    }

    public void removeInstructor(String name) {
        if (name == null || name.trim().equals("")) {
            throw new IllegalArgumentException("Illegal instructor name");
        }
        instructors.remove(name);
    }

    @Override
    public String toString() {
        return number + " " + title + " " + Arrays.toString(days) + " " + startTime.toString() + " to " + endTime.toString();
    }

    @Override
    public int compareTo(FinalData o) {
        return number - o.getNumber();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FinalData finalData = (FinalData) o;

        return number == finalData.number;
    }


}
