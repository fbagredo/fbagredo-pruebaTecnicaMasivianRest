
package co.pruebatecnica.masivian.users.client.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "lat",
    "lng"
})
@Entity
public class Geo {

	@Id
	@GeneratedValue
	private Long id;
    @JsonProperty("lat")
    private String lat;

	@JsonProperty("lng")
    private String lng;


    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@JsonProperty("lat")
    public String getLat() {
        return lat;
    }

    @JsonProperty("lat")
    public void setLat(String lat) {
        this.lat = lat;
    }

    @JsonProperty("lng")
    public String getLng() {
        return lng;
    }

    @JsonProperty("lng")
    public void setLng(String lng) {
        this.lng = lng;
    }

	@Override
	public String toString() {
		return "Geo [id=" + id + ", lat=" + lat + ", lng=" + lng + "]";
	}
    
}
