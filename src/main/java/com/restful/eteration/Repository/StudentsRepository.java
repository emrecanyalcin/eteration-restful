package com.restful.eteration.Repository;

import com.restful.eteration.Model.Students;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentsRepository extends JpaRepository<Students , Integer> {
}
