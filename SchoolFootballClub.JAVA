import java.util.*;

public class SchoolFootballClub {

    private int ageCategory;

    public int getAgeCategory() {
        return ageCategory;
    }

    public void setAgeCategory(int ageCategory) {
        this.ageCategory = ageCategory;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SchoolFootballClub that = (SchoolFootballClub) o;
        return ageCategory == that.ageCategory;
    }

    @Override
    public int hashCode() {
        return Objects.hash(ageCategory);
    }
}
