package com.stark.demo.specifications;

import java.util.Map;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import com.stark.demo.entitys.User;

public class UserSpecs {

	/**
	 * 设置查询条件
	 * @param paramMap
	 * @return
	 */
	public static Specification<User> setQuery(final Map<String, Object> paramMap) {
		return new Specification<User>() {
			public Predicate toPredicate(Root<User> root, CriteriaQuery<?> query,
					CriteriaBuilder builder) {
				Predicate p = null;
				if (paramMap != null && !paramMap.isEmpty()) {
					if(paramMap.containsKey("key") && paramMap.get("key") != null){
						String key = "%" + paramMap.get("key") + "%";
						Path<String> _p1 = root.get("name");
						Path<String> _p2 = root.get("description");
						p = builder.or(builder.like(_p1, key), builder.like(_p2, key));
					}
				}
				if(p == null){
					p = builder.equal(root.get("state"), "1");
				}else{
					p = builder.and(builder.equal(root.get("state"), "1"), p);
				}
				if(p == null){
					query.where();
				}else{
					query.where(p);
				}
				return p;
			}
		};
	}
	
}
