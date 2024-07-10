package repository;

import org.springframework.data.jpa.repository.JpaRepository;

import entity.Admin;

public interface AdminRepository extends JpaRepository<Admin,Long> {

	Admin findByUsername(String username);

}
