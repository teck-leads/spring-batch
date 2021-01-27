package com.techleads.app.process;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;

import com.techleads.app.model.Person;

public class PersonItemProcessor implements ItemProcessor<Person, Person>{

	Logger logger=LoggerFactory.getLogger(this.getClass());
	@Override
	public Person process(Person person) throws Exception {
		final String firstName=person.getFirstName().toUpperCase();
		final String lastName=person.getLastName().toUpperCase();
		final Person transformedPerson =new Person(firstName, lastName, person.getEmail(), person.getAge());
		logger.info("converting ("+person+") into ("+transformedPerson+")");
		return transformedPerson;
	}

}
