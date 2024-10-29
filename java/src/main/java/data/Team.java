package data;

public class Team {
    private int teamId;
    private String name;
    private String city;
    private int numberOfPlayers;
    private int gmId;
    private int staffId;

    public Team(int teamId, String name, String city, int numberOfPlayers, int gmId, int staffId) {
        this.teamId = teamId;
        this.name = name;
        this.city = city;
        this.numberOfPlayers = numberOfPlayers;
        this.gmId = gmId;
        this.staffId = staffId;
    }

    public int getTeamId() {
        return teamId;
    }

    public void setTeamId(int teamId) {
        this.teamId = teamId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getNumberOfPlayers() {
        return numberOfPlayers;
    }

    public void setNumberOfPlayers(int numberOfPlayers) {
        this.numberOfPlayers = numberOfPlayers;
    }

    public int getGmId() {
        return gmId;
    }

    public void setGmId(int gmId) {
        this.gmId = gmId;
    }

    public int getStaffId() {
        return staffId;
    }

    public void setStaffId(int staffId) {
        this.staffId = staffId;
    }
}
