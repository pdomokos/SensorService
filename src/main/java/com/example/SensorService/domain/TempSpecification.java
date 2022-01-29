package com.example.SensorService.domain;

import lombok.Builder;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

@Builder
public class TempSpecification implements Specification<Temp> {

    private TempSearchCriteria criteria;

    @Override
    public Predicate toPredicate(Root<Temp> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {

        Predicate result = criteriaBuilder.conjunction();

        if (criteria != null && criteria.getTempStateList() != null && !criteria.getTempStateList().isEmpty()) {
            result.in(root.get("tempState"), criteria.getTempStateList());
        }

        return result;
    }
}
