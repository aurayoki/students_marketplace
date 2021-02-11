package com.jm.marketplace.filter;

import com.jm.marketplace.model.Advertisement;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.jpa.domain.Specification;

import java.util.Map;

@Log4j2
public class AdvertisementFilter {

    private Specification<Advertisement> specification;
    private final Map<String, String> params;

    public AdvertisementFilter(Map<String, String> params) {
        this.params = params;
        this.specification = Specification.where(null);
    }


    public Specification<Advertisement> getSpecification() {
        if (params == null || params.isEmpty()) return specification;

        processInActiveFilter();

        return specification;
    }

    private void processInActiveFilter() {

        String active = params.get("active");
        if (active != null && !active.isBlank()) {
            specification = specification.and((Specification<Advertisement>)
                    (root, criteriaQuery, criteriaBuilder) ->
                            criteriaBuilder.isTrue(root.get("active")));
        }
    }
}
