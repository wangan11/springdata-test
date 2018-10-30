package com.example.demo.repostorty;//package com.wangan.springdata.repostorty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface PersonBaseRepository<T,ID> extends JpaRepository<T, ID> {
}