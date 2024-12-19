abstract class Student {
    private DegreeProgram degreeProgram;
    private String studentNumber;
    private String name;
    private String surname;

    public Student(DegreeProgram degreeProgram, String studentNumber, String name, String surname) {
        this.degreeProgram = degreeProgram;
        this.studentNumber = studentNumber;
        this.name = name;
        this.surname = surname;
    }

    public void setDegree(DegreeProgram degr) {
        degreeProgram = degr;
    }

    public String toString() {
        String out;
        out = String.format("Student name: %s \nName: %s \nSurname: %s \n", studentNumber, name, surname);
        if(degreeProgram!=null)
            out += degreeProgram.toString();
        else
            out += "No degree enrolled \n";
        return out;
    }
}
