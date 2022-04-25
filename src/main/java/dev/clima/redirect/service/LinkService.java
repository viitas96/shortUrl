package dev.clima.redirect.service;

import dev.clima.redirect.model.Link;

import java.util.List;
import java.util.Optional;

public interface LinkService {
    Link save(Link link);
    Optional<Link> get(long id);
}
