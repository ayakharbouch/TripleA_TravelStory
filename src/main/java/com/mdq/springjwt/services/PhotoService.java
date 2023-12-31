package com.mdq.springjwt.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mdq.springjwt.models.Photo;
import com.mdq.springjwt.repository.PhotoRepository;


@Service
public class PhotoService {

    private final PhotoRepository photoRepository;

    @Autowired
    public PhotoService(PhotoRepository photoRepository) {
        this.photoRepository = photoRepository;
    }
	
	public List<Photo> findAll() {return photoRepository.findAll();}

    public Photo save(Photo entity) {return photoRepository.save(entity);}

    public Optional<Photo> findById(Long id) {return photoRepository.findById(id);}

    public void deleteById(Long id){
    	photoRepository.deleteById(id);
    }
    public void update(Photo photo){
    	photoRepository.save(photo);
    }

}
