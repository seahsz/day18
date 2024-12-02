package vttp.sff.day18.repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import vttp.sff.day18.contants.Constant;

@Repository
public class ListRepo {

    @Autowired
    @Qualifier(Constant.TEMPLATE_01)
    RedisTemplate<String, String> template;

    // lpush redisKey value
    public void leftPush(String redisKey, String value) {
        ListOperations<String, String> listOps = template.opsForList();
        listOps.leftPush(redisKey, value);
    }

    // rpush redisKey value
    public void rightPush(String redisKey, String value) {
        template.opsForList().rightPush(redisKey, value);
    }

    // lpop redisKey
    public void leftPop(String redisKey) {
        template.opsForList().leftPop(redisKey);
    }

    // rpop redisKey
    public void rightPop(String redisKey) {
        template.opsForList().rightPop(redisKey);
    }

    // llen redisKey
    public Long size(String redisKey) {
        return template.opsForList().size(redisKey);
    }

    // lindex redisKey index
    public String getValueAtIndex(String redisKey, int index) {
        return template.opsForList().index(redisKey, index);
    }

    // ?????
    public List<String> getList(String redisKey) {
        return template.opsForList().range(redisKey, 0, -1);
    }

}
