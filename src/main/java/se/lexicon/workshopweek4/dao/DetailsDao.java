package se.lexicon.workshopweek4.dao;

import se.lexicon.workshopweek4.entity.Details;

import java.util.Collection;

public interface DetailsDao {
    Details findById(int id);
    Collection<Details> findAll();
    Details create(Details details);
    Details update(Details details);
    void delete(Details details);
}
