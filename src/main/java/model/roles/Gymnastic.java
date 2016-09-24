package model.roles;

/**
 * Gymnastic
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
