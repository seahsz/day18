package vttp.sff.day18.repositories;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import vttp.sff.day18.contants.Constant;
import vttp.sff.day18.models.Person;

@Repository
public class PersonRepo {

    @Autowired
    @Qualifier(Constant.TEMPLATE_01)
    RedisTemplate<String, String> template;

    // rpush redisKey person_details
    public void rightPush(String redisKey, Person person) {

        template.opsForList().rightPush(redisKey, person.toString());
    }

    // get redisKey
    public List<Person> getPersonList(String redisKey) {
        
        List<String> stringifyPersonList = template.opsForList().range(redisKey, 0, -1);

        List<Person> personList = stringifyPersonList.stream()
                    .map(str -> {
                        String[] fields = str.split(",");
                        Person person = new Person(Integer.parseInt(fields[0]),
                                                   fields[1],
                                                   fields[2],
                                                   fields[3],
                                                   fields[4]);
                        return person;
                    })
                    .collect(Collectors.toList());
        return personList;
    }
    
}
