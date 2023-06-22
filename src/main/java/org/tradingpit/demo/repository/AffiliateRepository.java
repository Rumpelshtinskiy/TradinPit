package org.tradingpit.demo.repository;

import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.tradingpit.demo.model.AffiliateClient;

import java.util.UUID;

@Repository
public interface AffiliateRepository extends CrudRepository<AffiliateClient, UUID> {
}
