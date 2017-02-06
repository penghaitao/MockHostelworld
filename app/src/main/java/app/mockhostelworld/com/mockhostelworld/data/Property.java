
package app.mockhostelworld.com.mockhostelworld.data;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Property {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("overallRating")
    @Expose
    private OverallRating overallRating;
    @SerializedName("rating")
    @Expose
    private Rating rating;
    @SerializedName("bestFor")
    @Expose
    private List<Object> bestFor = null;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("latitude")
    @Expose
    private String latitude;
    @SerializedName("longitude")
    @Expose
    private String longitude;
    @SerializedName("address1")
    @Expose
    private String address1;
    @SerializedName("address2")
    @Expose
    private String address2;
    @SerializedName("directions")
    @Expose
    private String directions;
    @SerializedName("city")
    @Expose
    private City city;
    @SerializedName("paymentMethods")
    @Expose
    private List<String> paymentMethods = null;
    @SerializedName("policies")
    @Expose
    private List<String> policies = null;
    @SerializedName("totalRatings")
    @Expose
    private String totalRatings;
    @SerializedName("images")
    @Expose
    private List<Image> images = null;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("depositPercentage")
    @Expose
    private Integer depositPercentage;
    @SerializedName("associations")
    @Expose
    private List<Object> associations = null;
    @SerializedName("checkIn")
    @Expose
    private CheckIn checkIn;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Rating getRating() {
        return rating;
    }

    public void setRating(Rating rating) {
        this.rating = rating;
    }

    public List<Object> getBestFor() {
        return bestFor;
    }

    public void setBestFor(List<Object> bestFor) {
        this.bestFor = bestFor;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getAddress() {
        String address = "";
        if (!"".equals(address2)) {
            address = address1 + ", " + address2 + ", " + city.getName();
        } else {
            address = address1 + ", " + city.getName();
        }
        return  address;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getDirections() {
        return directions;
    }

    public void setDirections(String directions) {
        this.directions = directions;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public List<String> getPaymentMethods() {
        return paymentMethods;
    }

    public void setPaymentMethods(List<String> paymentMethods) {
        this.paymentMethods = paymentMethods;
    }

    public List<String> getPolicies() {
        return policies;
    }

    public void setPolicies(List<String> policies) {
        this.policies = policies;
    }

    public String getTotalRatings() {
        return totalRatings;
    }

    public void setTotalRatings(String totalRatings) {
        this.totalRatings = totalRatings;
    }

    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getDepositPercentage() {
        return depositPercentage;
    }

    public void setDepositPercentage(Integer depositPercentage) {
        this.depositPercentage = depositPercentage;
    }

    public List<Object> getAssociations() {
        return associations;
    }

    public void setAssociations(List<Object> associations) {
        this.associations = associations;
    }

    public CheckIn getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(CheckIn checkIn) {
        this.checkIn = checkIn;
    }

    public OverallRating getOverallRating() {
        return overallRating;
    }

    public void setOverallRating(OverallRating overallRating) {
        this.overallRating = overallRating;
    }

    public class Rating {

        @SerializedName("overall")
        @Expose
        private Integer overall;
        @SerializedName("atmosphere")
        @Expose
        private Integer atmosphere;
        @SerializedName("cleanliness")
        @Expose
        private Integer cleanliness;
        @SerializedName("facilities")
        @Expose
        private Integer facilities;
        @SerializedName("staff")
        @Expose
        private Integer staff;
        @SerializedName("security")
        @Expose
        private Integer security;
        @SerializedName("location")
        @Expose
        private Integer location;
        @SerializedName("valueForMoney")
        @Expose
        private Integer valueForMoney;

        public Integer getOverall() {
            return overall;
        }

        public void setOverall(Integer overall) {
            this.overall = overall;
        }

        public Integer getAtmosphere() {
            return atmosphere;
        }

        public void setAtmosphere(Integer atmosphere) {
            this.atmosphere = atmosphere;
        }

        public Integer getCleanliness() {
            return cleanliness;
        }

        public void setCleanliness(Integer cleanliness) {
            this.cleanliness = cleanliness;
        }

        public Integer getFacilities() {
            return facilities;
        }

        public void setFacilities(Integer facilities) {
            this.facilities = facilities;
        }

        public Integer getStaff() {
            return staff;
        }

        public void setStaff(Integer staff) {
            this.staff = staff;
        }

        public Integer getSecurity() {
            return security;
        }

        public void setSecurity(Integer security) {
            this.security = security;
        }

        public Integer getLocation() {
            return location;
        }

        public void setLocation(Integer location) {
            this.location = location;
        }

        public Integer getValueForMoney() {
            return valueForMoney;
        }

        public void setValueForMoney(Integer valueForMoney) {
            this.valueForMoney = valueForMoney;
        }

    }

    public class Image {

        @SerializedName("suffix")
        @Expose
        private String suffix;
        @SerializedName("prefix")
        @Expose
        private String prefix;

        public String getSuffix() {
            return suffix;
        }

        public void setSuffix(String suffix) {
            this.suffix = suffix;
        }

        public String getPrefix() {
            return prefix;
        }

        public void setPrefix(String prefix) {
            this.prefix = prefix;
        }

    }

    public class CheckIn {

        @SerializedName("startsAt")
        @Expose
        private String startsAt;
        @SerializedName("endsAt")
        @Expose
        private Integer endsAt;

        public String getStartsAt() {
            return startsAt;
        }

        public void setStartsAt(String startsAt) {
            this.startsAt = startsAt;
        }

        public Integer getEndsAt() {
            return endsAt;
        }

        public void setEndsAt(Integer endsAt) {
            this.endsAt = endsAt;
        }

    }

    public class OverallRating {

        @SerializedName("overall")
        @Expose
        private String overall;
        @SerializedName("numberOfRatings")
        @Expose
        private Integer numberOfRatings;

        public String getOverall() {
            return overall;
        }

        public void setOverall(String overall) {
            this.overall = overall;
        }

        public Integer getNumberOfRatings() {
            return numberOfRatings;
        }

        public void setNumberOfRatings(Integer numberOfRatings) {
            this.numberOfRatings = numberOfRatings;
        }

    }

}
