package org.launchcode.codingevents.data;

import org.launchcode.codingevents.models.Event;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

//CrudRepository needs parameters. object first and object of int for primary key
@Repository
public interface EventRepository extends CrudRepository<Event, Integer> {
}


