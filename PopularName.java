/**
 The PopularName class shows a name that is
 well-liked by both men and women. It includes
 the name, rank, and overall number of infants
 for a specific year
 */
public class PopularName {
    private String name;
    private Integer rank;
    private Integer totalBabies;
    //combines the given name, rank, and overall number
    // of infants to create a new PopularName.
    public PopularName(String name, Integer rank, Integer totalBabies) {
        this.name = name;
        this.rank = rank;
        this.totalBabies = totalBabies;
    }
    //returnining the name of the popular name
    public String getName() {
        return name;
    }

    //setting the name of the popular name
    public void setName(String name) {
        this.name = name;
    }

    //returning the rank of the popular name
    public Integer getRank() {
        return rank;
    }

    // setting the rank of the popular name
    public void setRank(Integer rank) {
        this.rank = rank;
    }

    //returning the total number of bebek
    public Integer getTotalBabies() {
        return totalBabies;
    }

    //setting the total number of babies with the popular name.
    public void setTotalBabies(Integer totalBabies) {
        this.totalBabies = totalBabies;
    }
}
