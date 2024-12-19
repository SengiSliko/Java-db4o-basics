public class Postgraduate extends Student {
    private String supervisorInitials;
    private String supervisorSurname;
    private String researchTopic;
    public Postgraduate(DegreeProgram degreeProgram, String studentNumber,
                        String name, String surname, String supervisorInitials, String supervisorSurname,
                        String researchTopic) {
        super(degreeProgram, studentNumber, name, surname);
        this.supervisorInitials = supervisorInitials;
        this.supervisorSurname = supervisorSurname;
        this.researchTopic = researchTopic;
    }

    public String toString() {
        String out = super.toString();
        out += String.format("Supervisor Initials: %s \nSupervisor Surname: %s \nResearch Topic: %s \n", supervisorInitials, supervisorSurname, researchTopic);
        return out;
    }

    public void setSupervisorInitials(String supervisorInitials) {
        this.supervisorInitials = supervisorInitials;
    }

    public void setSupervisorSurname(String supervisorSurname) {
        this.supervisorSurname = supervisorSurname;
    }

    public void setResearchTopic(String researchTopic) {
        this.researchTopic = researchTopic;
    }
}
