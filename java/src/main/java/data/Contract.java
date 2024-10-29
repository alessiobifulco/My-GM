package data;

public class Contract {
    private int contractId;
    private int duration;         // Duration in months or years
    private double salary;        // Player's salary
    private String clause;        // Contract clause
    private String status;        // Contract status
    private String contractDate;  // Contract start date

    public Contract(int contractId, int duration, double salary, String clause, String status, String contractDate) {
        this.contractId = contractId;
        this.duration = duration;
        this.salary = salary;
        this.clause = clause;
        this.status = status;
        this.contractDate = contractDate;
    }

    public int getContractId() { return contractId; }
    public void setContractId(int contractId) { this.contractId = contractId; }
    public int getDuration() { return duration; }
    public void setDuration(int duration) { this.duration = duration; }
    public double getSalary() { return salary; }
    public void setSalary(double salary) { this.salary = salary; }
    public String getClause() { return clause; }
    public void setClause(String clause) { this.clause = clause; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public String getContractDate() { return contractDate; }
    public void setContractDate(String contractDate) { this.contractDate = contractDate; }
}
