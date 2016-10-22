package model.roles;

/**
 * Gymnastic
 *
 * @author Jack
 * @email jackkobec@gmail.com
 * @skype skypejs77
 */
public class Gymnastic {
    private String name;
    private double complexity;
    private GymnasticInfo info;
    private double numbersOfRepeats;
    private int numberOfSets;

    public Gymnastic() {
    }

    public Gymnastic(String name, double complexity, GymnasticInfo info, double numbersOfRepeats, int numberOfSets) {
        this.name = name;
        this.complexity = complexity;
        this.info = info;
        this.numbersOfRepeats = numbersOfRepeats;
        this.numberOfSets = numberOfSets;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getComplexity() {
        return complexity;
    }

    public void setComplexity(double complexity) {
        this.complexity = complexity;
    }

    public GymnasticInfo getInfo() {
        return info;
    }

    public void setInfo(GymnasticInfo info) {
        this.info = info;
    }

    public double getNumbersOfRepeats() {
        return numbersOfRepeats;
    }

    public void setNumbersOfRepeats(double numbersOfRepeats) {
        this.numbersOfRepeats = numbersOfRepeats;
    }

    public int getNumberOfSets() {
        return numberOfSets;
    }

    public void setNumberOfSets(int numberOfSets) {
        this.numberOfSets = numberOfSets;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Gymnastic gymnastic = (Gymnastic) o;

        if (Double.compare(gymnastic.complexity, complexity) != 0) return false;
        if (Double.compare(gymnastic.numbersOfRepeats, numbersOfRepeats) != 0) return false;
        if (numberOfSets != gymnastic.numberOfSets) return false;
        if (name != null ? !name.equals(gymnastic.name) : gymnastic.name != null) return false;
        return info != null ? info.equals(gymnastic.info) : gymnastic.info == null;

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = name != null ? name.hashCode() : 0;
        temp = Double.doubleToLongBits(complexity);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (info != null ? info.hashCode() : 0);
        temp = Double.doubleToLongBits(numbersOfRepeats);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + numberOfSets;
        return result;
    }

    @Override
    public String toString() {
        return "Gymnastic{" +
                "name='" + name + '\'' +
                ", complexity=" + complexity +
                ", info=" + info +
                ", numbersOfRepeats=" + numbersOfRepeats +
                ", numberOfSets=" + numberOfSets +
                '}';
    }
}
