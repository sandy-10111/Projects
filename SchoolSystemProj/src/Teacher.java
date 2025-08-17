public class Teacher {
    private String Tname;
    private int Tid;

    public Teacher(String Tname, int Tid){
        this.Tname= Tname;
        this.Tid = Tid;
    }
    public void AddCourseToStudent(Student student, Courses course){
        student.AddCourse(course);
        System.out.println("course "+ course.getCourseName() +" addted to "+ student.getName());
    }

    public void RemoveCourseFromStudent(Student student, String coursecode){
        student.RemoveCourse(coursecode);
        System.out.println("course code "+ coursecode+ "removed from "+ student.getName());
    }
    
}
