import java.util.Objects;

public class UniversityFootballlClub 
{

    	private int ageLimit;

    	public int getAgeLimit() 
    	{
        	return ageLimit;
    	}

    	public void setAgeLimit(int ageLimit) 
    	{
        	this.ageLimit = ageLimit;
    	}

    	@Override
    	public boolean equals(Object o) 
    	{

        	if (this == o) return true;

        	if (o == null || getClass() != o.getClass()) return false;

        	UniversityFootballlClub that = (UniversityFootballlClub) o;

        	return ageLimit == that.ageLimit;
    	}

    	@Override
    	public int hashCode() 
    	{
        	return Objects.hash(ageLimit);
   	}
}
