package com.blu4ck.Programming_Languages.repositories;

import com.blu4ck.Programming_Languages.models.Specs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpecsRepository extends JpaRepository<Specs,Long> {
}
