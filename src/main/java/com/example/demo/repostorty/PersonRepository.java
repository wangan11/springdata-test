package com.example.demo.repostorty;//package com.wangan.springdata.repostorty;
import com.example.demo.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}