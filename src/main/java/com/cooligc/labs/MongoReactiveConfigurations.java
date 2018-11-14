/**
 * 
 */
package com.cooligc.labs;

import org.springframework.data.mongodb.config.AbstractReactiveMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

import com.mongodb.reactivestreams.client.MongoClient;
import com.mongodb.reactivestreams.client.MongoClients;

/**
 * @author sitakant
 *
 */
@EnableReactiveMongoRepositories
public class MongoReactiveConfigurations extends AbstractReactiveMongoConfiguration {

	/* (non-Javadoc)
	 * @see org.springframework.data.mongodb.config.AbstractReactiveMongoConfiguration#reactiveMongoClient()
	 */
	@Override
	public MongoClient reactiveMongoClient() {
		return MongoClients.create();
	}

	/* (non-Javadoc)
	 * @see org.springframework.data.mongodb.config.MongoConfigurationSupport#getDatabaseName()
	 */
	@Override
	protected String getDatabaseName() {
		return "sample-reactive";
	}

}
