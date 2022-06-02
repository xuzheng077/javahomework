import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.List;

/**
 * @author Xu Zheng
 * @description
 */
public class Backup {

    public static void main(String[] args) {
        FinalApp app = new FinalApp(2022, "Spring");
        FinalData course = new FinalData("Cloud Computing", 15619);
        FinalData course1 = new FinalData("Java Computing", 17681);
        course.addInstructor("Xu Zheng");
        course.addInstructor("Xu Zheng1");
        course.setDays(new DayOfWeek[]{DayOfWeek.SUNDAY, DayOfWeek.FRIDAY});
        course.setStartTime(LocalTime.of(15, 30));
        course.setEndTime(LocalTime.of(16, 30));
        course1.addInstructor("Xu Zheng");
        course1.setDays(new DayOfWeek[]{DayOfWeek.SUNDAY, DayOfWeek.FRIDAY});
        course1.setStartTime(LocalTime.of(15, 30));
        course1.setEndTime(LocalTime.of(16, 30));
        System.out.println(course);
        course.removeInstructor("Xu Zheng1");
        System.out.println(course);

        app.addCourse(course);
        app.addCourse(course1);
        FinalData another = app.searchByNumber(course.getNumber());
        System.out.println(another);
        System.out.println(course == another);
        System.out.println(course.equals(another));
        List<FinalData> list = app.searchByKeyword("computing");
        for (FinalData d : list) {
            System.out.println(d);
        }
    }
}
