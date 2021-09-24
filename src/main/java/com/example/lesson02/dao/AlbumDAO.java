package com.example.lesson02.dao;


import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.lesson02.model.Album;

@Repository
public interface AlbumDAO {
	public List<Album> selectAlbumList();
}
