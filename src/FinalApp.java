import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.*;

/**
 * FinalApp class.
 *
 * @author Xu Zheng
 * <p>
 * Andrew id: xuzheng
 */
public class FinalApp {
    private String semester;
    private int year;
    private Map<Integer, FinalData> byCourseNumber;
    private Map<String, List<FinalData>> byKeyword;
    private int size;

    public FinalApp(int newYear, String newSemester) {
        if (newSemester == null || (!newSemester.equals("Fall") && !newSemester.equals("Spring") && !newSemester.equals("Summer"))) {
            throw new IllegalArgumentException("Illegal semester");
        }
        if (newYear <= 0) {
            throw new IllegalArgumentException("Illegal year");
        }
        year = newYear;
        semester = newSemester;
        byCourseNumber = new HashMap<>();
        byKeyword = new HashMap<>();
    }

    public List<FinalData> searchByKeyword(String keyword) {
        if (keyword == null || keyword.trim().equals("")) {
            throw new IllegalArgumentException("Illegal keyword");
        }
        keyword = keyword.toLowerCase(Locale.ROOT);
        List<FinalData> result = byKeyword.get(keyword);
        if (result == null) {
            return null;
        }
        List<FinalData> re = new ArrayList<>();
        for (int i = 0; i < result.size(); i++) {
            FinalData origin = result.get(i);
            FinalData d = new FinalData(origin.getTitle(), origin.getNumber());
            d.setDays(origin.getDays());
            d.setStartTime(origin.getStartTime());
            d.setEndTime(origin.getEndTime());
            for (String instructor : origin.getInstructors()) {
                d.addInstructor(instructor);
            }
            re.add(d);
        }
        Collections.sort(re, (o1, o2) -> o1.getTitle().compareToIgnoreCase(o2.getTitle()));
        return re;
    }

    public void addCourse(FinalData course) {
        if (course == null || course.getTitle() == null || course.getTitle().trim().equals("") || course.getNumber() <= 0
                || course.getDays() == null || course.getStartTime() == null || course.getEndTime() == null
                || course.getDays() == null || course.getInstructors() == null) {
            throw new IllegalArgumentException("Invalid course");
        }
        FinalData myCourse = new FinalData(course.getTitle(), course.getNumber());
        myCourse.setDays(course.getDays());
        myCourse.setStartTime(course.getStartTime());
        myCourse.setEndTime(course.getEndTime());
        for (String instructor : course.getInstructors()) {
            myCourse.addInstructor(instructor);
        }
        int number = myCourse.getNumber();
        if (byCourseNumber.containsKey(number)) {
            throw new IllegalArgumentException("Course number should be unique");
        }

        byCourseNumber.put(number, myCourse);
        size++;
        String title = myCourse.getTitle();
        String[] keywords = title.split(" ");
        for (String keyword : keywords) {
            keyword = keyword.toLowerCase(Locale.ROOT);
            if (byKeyword.containsKey(keyword)) {
                byKeyword.get(keyword).add(myCourse);
            } else {
                List<FinalData> li = new ArrayList<>();
                li.add(myCourse);
                byKeyword.put(keyword, li);
            }
        }
    }

    public String getSemester() {
        return semester;
    }

    public int getYear() {
        return year;
    }

    public int size() {
        return size;
    }

    public FinalData searchByNumber(int number) {
        if (number <= 0) {
            throw new IllegalArgumentException("Illegal number");
        }
        FinalData course = byCourseNumber.get(number);
        FinalData myCourse = new FinalData(course.getTitle(), course.getNumber());
        myCourse.setDays(course.getDays());
        myCourse.setStartTime(course.getStartTime());
        myCourse.setEndTime(course.getEndTime());
        for (String instructor : course.getInstructors()) {
            myCourse.addInstructor(instructor);
        }
        return myCourse;
    }
}
