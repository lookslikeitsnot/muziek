package be.vdab.valueobjects;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Embeddable;

@Embeddable
public class Track implements Serializable {
	private static final long serialVersionUID = 1L;
	private String naam;
	private BigDecimal tijd;

	public String getNaam() {
		return naam;
	}

	public BigDecimal getTijd() {
		return tijd;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((naam == null) ? 0 : naam.hashCode());
		result = prime * result + ((tijd == null) ? 0 : tijd.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Track))
			return false;
		Track other = (Track) obj;
		if (naam == null) {
			if (other.naam != null)
				return false;
		} else if (!naam.equals(other.naam))
			return false;
		if (tijd == null) {
			if (other.tijd != null)
				return false;
		} else if (!tijd.equals(other.tijd))
			return false;
		return true;
	}

	public Track(String naam, BigDecimal tijd) {
		this.naam = naam;
		this.tijd = tijd;
	}

	public Track() {
	}
}
