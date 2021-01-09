package com.liutao.supone.service;

import com.liutao.supone.dao.PersonMapper;
import com.liutao.supone.entity.Person;
import com.liutao.supone.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * .
 * Created by liutao20 on 2020/8/11
 */
@Service
public class PersonService {

    @Autowired
    private PersonMapper personMapper;

    public Map<String, Object> selectPersonList(Integer personId, String startDate, String endDate) {
        Map<String, Object> resultMap = new HashMap<>();
        List<Person> personList = personMapper.selectList();
        if (personId == null) {
            personList.get(0).setStartDate(DateUtil.emptyDefaultDay(startDate));
            personList.get(0).setEndDate(DateUtil.emptyDefaultDay(endDate));
            resultMap.put("currentPerson", personList.get(0));
        } else {
            for (int i = 0; i < personList.size(); i++) {
                if (personList.get(i).getId().equals(personId)) {
                    personList.get(i).setStartDate(DateUtil.emptyDefaultDay(startDate));
                    personList.get(i).setEndDate(DateUtil.emptyDefaultDay(endDate));
                    resultMap.put("currentPerson", personList.get(i));
                    break;
                }
            }
        }
        resultMap.put("personList", personList);
        return resultMap;
    }
}
