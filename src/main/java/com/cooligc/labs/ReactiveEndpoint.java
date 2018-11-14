/**
 * 
 */
package com.cooligc.labs;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author sitakant
 *
 */
@RestController
@RequestMapping("/applications")
public class ReactiveEndpoint {

	@Autowired
	ApplicationRepository applicationRepository;

	@GetMapping("/health")
	public Mono<Map<String, String>> getVersion() {
		Map<String, String> versionMap = new HashMap<String, String>();
		versionMap.put("version", "1.0");
		versionMap.put("status", "I am up");
		return Mono.just(versionMap);

	}

	@GetMapping
	public Flux<Application> getAllApplications() {
		return applicationRepository.findAll();
	}

	@GetMapping("/{id}")
	public Mono<Application> getApplication(@PathVariable("id") String id) {
		return applicationRepository.findById(id);
	}

	@PostMapping
	public Mono<Application> createApplications(@RequestBody Application application) {
		application.setId(UUID.randomUUID().toString());
		return applicationRepository.save(application);
	}

}
