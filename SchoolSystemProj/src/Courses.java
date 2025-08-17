public class Courses {
    public String courseName;
    public String courseCode;

    public Courses(String courseName, String courseCode){
        this.courseName = courseName;
        this.courseCode = courseCode;
    }

    public String getCourseName(){
        return courseName;
    }
    public String getCourseCode(){
        return courseCode;
    }

    public String toString(){
        return courseName +" and "+courseCode;
    }

}
