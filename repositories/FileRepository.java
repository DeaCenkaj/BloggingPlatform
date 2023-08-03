package com.dea.codingdojo.blogplatform.repositories;

import com.dea.codingdojo.blogplatform.models.File;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FileRepository extends JpaRepository<File, Long> {

}
