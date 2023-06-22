package org.tradingpit.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.tradingpit.demo.model.FailedCall;

import java.util.UUID;

public interface FailedRepository extends CrudRepository<FailedCall, UUID> {
}
