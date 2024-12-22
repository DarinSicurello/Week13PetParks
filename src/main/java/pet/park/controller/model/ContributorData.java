package pet.park.controller.model;

import java.util.HashSet;
import java.util.Set;

import lombok.Data;
import lombok.NoArgsConstructor;
import pet.park.entity.Amenity;
import pet.park.entity.Contributor;
import pet.park.entity.GeoLocation;
import pet.park.entity.PetPark;

@Data
@NoArgsConstructor
public class ContributorData {
    private Long contributorId;
    private String contributorName;
    private String contributorEmail;
    private Set<PetParkResponse> petParks = new HashSet<>();

 
    public ContributorData(Contributor contributor) {
        contributorId = contributor.getContributorId();
        contributorName = contributor.getContributorName();
        contributorEmail = contributor.getContributorEmail();

      
        for (PetPark petPark : contributor.getPetParks()) {
            petParks.add(new PetParkResponse(petPark));
        }
    }

    // Error!! on Video for Public class Fixed
    @Data
    @NoArgsConstructor
    public static class PetParkResponse {
        private Long petParkId;
        private String parkName;
        private String directions;
        private String stateorProvince;
        private String country;
        private GeoLocation geolocation;
        private Set<String> amenities = new HashSet<>();

        
        public PetParkResponse(PetPark petPark) {
            petParkId = petPark.getPetParkId();
            parkName = petPark.getParkName();
            directions = petPark.getDirections();
            stateorProvince = petPark.getStateorProvince();
            country = petPark.getCountry();
            geolocation = new GeoLocation(petPark.getGeolocation()); 
            
            
            for (Amenity amenity : petPark.getAmenities()) {
                this.amenities.add(amenity.getAmenity());
            }
        }
    }
}
