
package co.pruebatecnica.masivian.users.client.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "name",
    "catchPhrase",
    "bs"
})
@Entity
public class Company {

	@Id
	@GeneratedValue
	private Long id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("catchPhrase")
    private String catchPhrase;
    @JsonProperty("bs")
    private String bs;

    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("catchPhrase")
    public String getCatchPhrase() {
        return catchPhrase;
    }

    @JsonProperty("catchPhrase")
    public void setCatchPhrase(String catchPhrase) {
        this.catchPhrase = catchPhrase;
    }

    @JsonProperty("bs")
    public String getBs() {
        return bs;
    }

    @JsonProperty("bs")
    public void setBs(String bs) {
        this.bs = bs;
    }

	@Override
	public String toString() {
		return "Company [id=" + id + ", name=" + name + ", catchPhrase=" + catchPhrase + ", bs=" + bs + "]";
	}
}
