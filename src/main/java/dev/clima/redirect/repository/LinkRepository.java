package dev.clima.redirect.repository;

import dev.clima.redirect.model.Link;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LinkRepository extends JpaRepository<Link, Long> {
}
