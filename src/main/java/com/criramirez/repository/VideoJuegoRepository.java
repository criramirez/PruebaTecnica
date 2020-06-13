package com.criramirez.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.criramirez.collections.VideoJuego;

public interface VideoJuegoRepository extends MongoRepository<VideoJuego, String> {

}
