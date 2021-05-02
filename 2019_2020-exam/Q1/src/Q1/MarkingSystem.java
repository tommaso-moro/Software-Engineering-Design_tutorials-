package Q1;

import java.util.HashMap;
import java.util.Map;

public class MarkingSystem {


  private static final MarkingSystem instance = new MarkingSystem();
  private final Map<Student, StudentRecord> allStudentMarks;

  public static MarkingSystem getInstance() {
    return instance;
  }

  public MarkingSystem() {
    allStudentMarks = new HashMap<>();
  }

  public void registerMark(ExamResult examResult, double scaleFactor) {

    Student student = examResult.getStudent();

    StudentRecord studentRecord;

    if (!allStudentMarks.containsKey(student)) {
      studentRecord = new StudentRecord(student);
      allStudentMarks.put(student, studentRecord);
    } else {
      studentRecord = allStudentMarks.get(student);
    }

    studentRecord.enter(examResult.getCode(), examResult.calculateTotal(scaleFactor));
  }

  public int averageAcrossAllExams(Student student) {

    if (!allStudentMarks.containsKey(student)) {
      throw new RuntimeException("No marks for student: " + student);
    }
    return allStudentMarks.get(student).calculateExamAverage();
  }
}
