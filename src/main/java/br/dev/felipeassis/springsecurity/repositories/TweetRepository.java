package br.dev.felipeassis.springsecurity.repositories;

import br.dev.felipeassis.springsecurity.entities.Tweet;
import org.hibernate.query.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TweetRepository extends JpaRepository<Tweet, Long>  {

}
