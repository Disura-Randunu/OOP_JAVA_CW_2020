import java.util.Objects;

public class SportsClub {

    private String name;
    private String location;

    SportsClub(String name, String location){
        this.name = name;
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public boolean equals(Object sportsClub) {
        if (this == sportsClub) return true;

        if (sportsClub == null || getClass() != sportsClub.getClass()) return false;

        SportsClub that = (SportsClub) sportsClub;

        return Objects.equals(name, that.name) && Objects.equals(location, that.location);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, location);
    }

    @Override
    public String toString() {
        return "SportsClub{" +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                '}';
    }
}
