package com.example.SensorService.domain;

import lombok.AllArgsConstructor;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

@AllArgsConstructor
public class TempSpecification implements Specification<Temp> {

    private TempSearchCriteria criteria;

    @Override
    public Predicate toPredicate(Root<Temp> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {

            if (criteria.getTempState() != null) {
                return criteriaBuilder.equal(
                        root.<String> get(criteria.getTempState().name()), TempState.VALID.name());
            }

            return null;
    }
}