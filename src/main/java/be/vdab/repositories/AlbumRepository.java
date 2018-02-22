package be.vdab.repositories;

import java.util.List;
import java.util.Optional;

import be.vdab.entities.Album;

public class AlbumRepository extends AbstractRepository{
	public List<Album> findAll(){
		return getEntityManager()
				.createNamedQuery("Album.findAll", Album.class)
				.getResultList();
	}
	
	public Optional<Album> read(long id){
		return Optional.ofNullable(getEntityManager().find(Album.class, id));
	}
}
