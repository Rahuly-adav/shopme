package com.shopme.admin.user;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import com.shopme.common.entity.User;

public interface UserRepository extends PagingAndSortingRepository<User, Integer> {

	@Query("Select u from User u where u.email = :email")
	public User getUserByEmail(@Param("email") String email);
	
	@Query("SELECT count(*) FROM User WHERE id = :id")
	public Long countById(Integer id);
	
	@Query("Select u from User u where Concat(u.id,' ' ,u.email,' ', u.firstName,' ',u.lastName)Like %?1%")
	public Page<User> findAll(String keyword, Pageable pageable);
	
	@Query("Update User u set u.enabled = ?2 where u.id=?1")
	@Modifying
	public void updateEnabledStatus(Integer id, boolean enabled);
}
