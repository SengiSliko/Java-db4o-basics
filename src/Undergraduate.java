public class Undergraduate extends Student {
    private int yearOfStudy;
    private double averageMark;
    public Undergraduate(DegreeProgram degreeProgram, String studentNumber,
                         String name, String surname, int yearOfStudy, double averageMark) {
        super(degreeProgram, studentNumber, name, surname);
        this.yearOfStudy = yearOfStudy;
        this.averageMark = averageMark;
    }

    public void SetUndergradDegree(DegreeProgram degr) {
        super.setDegree(degr);
    }

    public String toString() {
        String out = super.toString();
        out += String.format("Year of Study: %d \nAverage Mark: %f \n", yearOfStudy, averageMark);
        return out;
    }

    public void setYearOfStudy(int yearOfStudy) {
        this.yearOfStudy = yearOfStudy;
    }

    public void setAverageMark(double averageMark) {
        this.averageMark = averageMark;
    }
}
