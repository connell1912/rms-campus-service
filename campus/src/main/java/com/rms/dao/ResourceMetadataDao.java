package com.rms.dao;

import com.rms.model.ResourceMetadata;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface ResourceMetadataDao extends CrudRepository<ResourceMetadata, Integer>{

    ResourceMetadata findById(int id);
}