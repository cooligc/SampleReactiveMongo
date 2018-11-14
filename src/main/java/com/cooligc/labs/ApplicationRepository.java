/**
 * 
 */
package com.cooligc.labs;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

import reactor.core.publisher.Flux;

/**
 * @author sitakant
 *
 */
@Repository
public interface ApplicationRepository extends ReactiveCrudRepository<Application, String> {
	Flux<Application> findAllByStatus(String value);
}
