
package co.pruebatecnica.masivian.users.client.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "street",
    "suite",
    "city",
    "zipcode",
    "geo"
})
@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class Address {

	@Id
	@GeneratedValue
	private Long id;
    @JsonProperty("street")
    private String street;
    @JsonProperty("suite")
    private String suite;
    @JsonProperty("city")
    private String city;
    @JsonProperty("zipcode")
    private String zipcode;
    @JsonProperty("geo")
    @OneToOne(fetch = FetchType.EAGER,cascade=CascadeType.ALL)
    private Geo geo;

    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@JsonProperty("street")
    public String getStreet() {
        return street;
    }

    @JsonProperty("street")
    public void setStreet(String street) {
        this.street = street;
    }

    @JsonProperty("suite")
    public String getSuite() {
        return suite;
    }

    @JsonProperty("suite")
    public void setSuite(String suite) {
        this.suite = suite;
    }

    @JsonProperty("city")
    public String getCity() {
        return city;
    }

    @JsonProperty("city")
    public void setCity(String city) {
        this.city = city;
    }

    @JsonProperty("zipcode")
    public String getZipcode() {
        return zipcode;
    }

    @JsonProperty("zipcode")
    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    @JsonProperty("geo")
	public Geo getGeo() {
		return geo;
	}

    @JsonProperty("geo")
	public void setGeo(Geo geo) {
		this.geo = geo;
	}

	@Override
	public String toString() {
		return "Address [id=" + id + ", street=" + street + ", suite=" + suite + ", city=" + city + ", zipcode="
				+ zipcode + ", geo=" + geo + "]";
	}
}
