package vttp.sff.day18.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Repository;

import vttp.sff.day18.contants.Constant;

@Repository
public class ValueRepo {

    @Autowired
    @Qualifier(Constant.TEMPLATE_01)
    private RedisTemplate<String, String> template;

    // set redisKey value
    public void setValue(String redisKey, String value) {

        ValueOperations<String, String> valueOps = template.opsForValue();

        valueOps.set(redisKey, value);
    }

    // get redisKey
    public String getValue(String redisKey) {

        ValueOperations<String, String> valueOps = template.opsForValue();

        return valueOps.get(redisKey);
    }

    // incr redisKey
    public void incrementValue(String redisKey) {

        ValueOperations<String, String> valueOps = template.opsForValue();

        valueOps.increment(redisKey);
    }

    // decr redisKey
    public void decrementValue(String redisKey) {

        ValueOperations<String, String> valueOps = template.opsForValue();

        valueOps.decrement(redisKey);
    }

    // incr redisKey valueToIncrement
    public void incrementValueBy(String redisKey, int valueToIncrement) {
        template.opsForValue().increment(redisKey, valueToIncrement);
    }

    // decr redisKey valueToDecrement
    public void decrementValueBy(String redisKey, int valueToDecrement) {
        template.opsForValue().decrement(redisKey, valueToDecrement);
    }

    // del redisKey
    public void deleteKey(String redisKey) {
        template.delete(redisKey);
    }

    // exists redisKey
    public boolean keyExists(String redisKey) {
        return template.hasKey(redisKey);
    }

}
