package be.vdab.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collections;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import be.vdab.valueobjects.Track;

@Entity
@Table(name = "albums")
public class Album implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "artiestid")
	private Artiest artiest;
	private String naam;
	@ElementCollection
	@CollectionTable(name = "tracks", joinColumns = @JoinColumn(name = "albumid"))
	private Set<Track> tracks;

	public Artiest getArtiest() {
		return artiest;
	}

	public String getNaam() {
		return naam;
	}

	public long getId() {
		return id;
	}

	public Set<Track> getTracks() {
		return Collections.unmodifiableSet(tracks);
	}
	
	public BigDecimal getAlbumTijd() {
		return tracks.stream()
				.map(track -> track.getTijd())
				.reduce(BigDecimal.ZERO, BigDecimal::add);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((artiest == null) ? 0 : artiest.hashCode());
		result = prime * result + ((naam == null) ? 0 : naam.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Album))
			return false;
		Album other = (Album) obj;
		if (artiest == null) {
			if (other.artiest != null)
				return false;
		} else if (!artiest.equals(other.artiest))
			return false;
		if (naam == null) {
			if (other.naam != null)
				return false;
		} else if (!naam.equals(other.naam))
			return false;
		return true;
	}
}
