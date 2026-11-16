package tn.esprit.autoloc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.autoloc.domain.Client;
@Repository
public interface ClientRepository extends CrudRepository<Client,Long> {




}
