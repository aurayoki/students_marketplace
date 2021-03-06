package com.jm.marketplace.filter;

import com.jm.marketplace.model.Advertisement;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import java.util.Map;

@Log4j2
@Component
public class AdvertisementFilter {

    public Specification<Advertisement> getSpecification(Map<String, String> params) {
        Specification<Advertisement> specification = Specification.where(null);
        if (params == null || params.isEmpty()) return specification;

        specification = processInActiveFilter(specification, params);

        return specification;
    }

    private Specification<Advertisement> processInActiveFilter(Specification<Advertisement> specification, Map<String, String> params) {

        String active = params.get("active");
        if (active != null && !active.isBlank()) {
            specification = specification.and((Specification<Advertisement>)
                    (root, criteriaQuery, criteriaBuilder) ->
                            criteriaBuilder.isTrue(root.get("active")));
        }

        return specification;
    }
}
