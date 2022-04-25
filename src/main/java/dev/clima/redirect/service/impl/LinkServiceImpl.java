package dev.clima.redirect.service.impl;
import dev.clima.redirect.model.Link;
import dev.clima.redirect.repository.LinkRepository;
import dev.clima.redirect.service.LinkService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LinkServiceImpl implements LinkService {
    private final LinkRepository linkRepository;

    public LinkServiceImpl(LinkRepository linkRepository){
        super();
        this.linkRepository = linkRepository;
    }

    @Override
    public Link save(Link link) {
        return linkRepository.save(link);
    }

    @Override
    public Optional<Link> get(long id) {
        return linkRepository.findById(id);
    }

}
