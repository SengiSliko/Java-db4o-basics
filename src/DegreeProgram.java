public class DegreeProgram {
    private String degreeName;
    private String department;
    private String faculty;

    DegreeProgram(String degreeName, String department, String faculty) {
        this.degreeName = degreeName;
        this.department = department;
        this.faculty = faculty;
    }

    public String toString() {
         return String.format("Degree: %s \nDepartment: %s \nFaculty: %s \n", degreeName, department, faculty);
    }


}
