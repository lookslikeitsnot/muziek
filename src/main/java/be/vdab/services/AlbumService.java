package be.vdab.services;

import java.util.List;
import java.util.Optional;

import be.vdab.entities.Album;
import be.vdab.repositories.AlbumRepository;

public class AlbumService extends AbstractService{
	private final AlbumRepository albumRespository = 
			new AlbumRepository(); 
	
	public List<Album> findAll() { // voor later in de cursus
		return albumRespository.findAll();
	}
	
	public Optional<Album> read(long id){
		return albumRespository.read(id);
	}
}
