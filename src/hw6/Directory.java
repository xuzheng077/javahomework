package hw6;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Directory class.
 *
 * @author Xu Zheng
 * <p>
 * Andrew id: xuzheng
 */
public class Directory {

    /**
     * map andrew id to student.
     */
    private Map<String, Student> andrewIdMap;

    /**
     * map firstname to a list of students.
     */
    private Map<String, List<Student>> firstNameMap;

    /**
     * map lastname to a list of students.
     */
    private Map<String, List<Student>> lastNameMap;

    /**
     * Constructor.
     */
    public Directory() {
        andrewIdMap = new HashMap<>();
        firstNameMap = new HashMap<>();
        lastNameMap = new HashMap<>();
    }

    /**
     * addStudent.
     * given the student object, add the new student into the three maps
     * if the given Andrew ID is not present in the directory.
     * If the Andrew ID is present, throw IllegalArgumentException.
     *
     * @param s student
     */
    public void addStudent(Student s) {
        if (s != null && s.getAndrewId() != null && s.getLastName() != null
                && s.getFirstName() != null && !andrewIdMap.containsKey(s.getAndrewId())) {
            Student student = new Student(s.getAndrewId(), s.getFirstName(), s.getLastName(), s.getPhoneNumber());
            andrewIdMap.put(student.getAndrewId(), student);
            boolean foundFirst = false;
            for (String firstName : firstNameMap.keySet()) {
                if (firstName.equals(student.getFirstName())) {
                    firstNameMap.get(student.getFirstName()).add(student);
                    foundFirst = true;
                    break;
                }
            }
            if (!foundFirst) {
                List<Student> list = new ArrayList<>();
                list.add(student);
                firstNameMap.put(student.getFirstName(), list);
            }

            boolean foundLast = false;
            for (String lastName : lastNameMap.keySet()) {
                if (lastName.equals(student.getLastName())) {
                    lastNameMap.get(student.getLastName()).add(student);
                    foundLast = true;
                    break;
                }
            }
            if (!foundLast) {
                List<Student> list = new ArrayList<>();
                list.add(student);
                lastNameMap.put(student.getLastName(), list);
            }
        } else {
            throw new IllegalArgumentException();
        }
    }

    /**
     * deleteStudent.
     * given the andrew id string value, this method should remove the
     * corresponding student object from the three maps if present.
     * If no andrew id matches, throw IllegalArgumentException
     *
     * @param andrewId andrew id
     */
    public void deleteStudent(String andrewId) {
        if (andrewId != null && andrewIdMap.containsKey(andrewId)) {
            Student s = andrewIdMap.get(andrewId);
            andrewIdMap.remove(andrewId);
            firstNameMap.get(s.getFirstName()).remove(s);
            lastNameMap.get(s.getLastName()).remove(s);
        } else {
            throw new IllegalArgumentException();
        }
    }

    /**
     * searchByAndrewId.
     * given the andrew id string value, this method should return the student in
     * the directory. If no student in the directory has the given Andrew ID, return null.
     *
     * @param andrewId andrew id
     * @return student
     */
    public Student searchByAndrewId(String andrewId) {
        if (andrewId == null || andrewId.trim().equals("")) {
            throw new IllegalArgumentException();
        }
        if (andrewIdMap.containsKey(andrewId)) {
            Student s = andrewIdMap.get(andrewId);
            Student newStudent = new Student(s.getAndrewId(), s.getFirstName(), s.getLastName(), s.getPhoneNumber());
            return newStudent;
        } else {
            return null;
        }
    }

    /**
     * searchByAndrewId.
     * given the first name string value, this method should return a list
     * containing all students that match the given first name. If no students in the directory have the
     * given first name, return a zero length list of students.
     *
     * @param firstName firstName
     * @return students
     */
    public List<Student> searchByFirstName(String firstName) {
        if (firstName == null || firstName.trim().equals("")) {
            throw new IllegalArgumentException();
        }
        if (firstNameMap.containsKey(firstName)) {
            List<Student> list = firstNameMap.get(firstName);
            List<Student> newList = new ArrayList<>();
            for (Student s : list) {
                newList.add(new Student(s.getAndrewId(), s.getFirstName(), s.getLastName(), s.getPhoneNumber()));
            }
            return newList;
        } else {
            return new ArrayList<>();
        }
    }

    /**
     * searchByLastName.
     * given the last name string value, this method should return a list containing
     * all students that match the given last name. If no students in the directory have the given last
     * name, return a zero length list of students
     *
     * @param lastName lastName
     * @return students
     */
    public List<Student> searchByLastName(String lastName) {
        if (lastName == null || lastName.trim().equals("")) {
            throw new IllegalArgumentException();
        }
        if (lastNameMap.containsKey(lastName)) {
            List<Student> list = lastNameMap.get(lastName);
            List<Student> newList = new ArrayList<>();
            for (Student s : list) {
                newList.add(new Student(s.getAndrewId(), s.getFirstName(), s.getLastName(), s.getPhoneNumber()));
            }
            return newList;
        } else {
            return new ArrayList<>();
        }
    }

    /**
     * size.
     *
     * @return Returns the number of students in the directory
     */
    public int size() {
        return andrewIdMap.size();
    }


}
