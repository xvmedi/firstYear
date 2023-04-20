public class Employee {
    private static int numOfEmployees = 0;
    private int id;
    private String name, jobTitle, jobStatus, gender;

    @Override
    public String toString() {
        return  "ID: " + id + "    " +
                "Name: " + name + "    " +
                "JobTitle: " + jobTitle + "    " +
                "JobStatus: " + jobStatus +
                "    " + "Gender: " + gender;
    }

    public Employee(int id, String name, String jobTitle, String jobStatus, String gender) {
        this.id = id;
        this.name = name;
        this.jobTitle = jobTitle;
        this.jobStatus = jobStatus;
        this.gender = gender;
        numOfEmployees++;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getJobStatus() {
        return jobStatus;
    }

    public void setJobStatus(String jobStatus) {
        this.jobStatus = jobStatus;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public static int getNumOfEmployees() {
        return numOfEmployees;
    }
}