package br.com.web3clubtravel.blog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.web3clubtravel.blog.model.Destinations;
import br.com.web3clubtravel.blog.model.Reference;
import br.com.web3clubtravel.blog.record.ReferenceRecord;
import br.com.web3clubtravel.blog.repository.ReferenceRepository;

@Service
public class ReferenceService {

    private final ReferenceRepository referenceRepository;

    @Autowired
    public ReferenceService(final ReferenceRepository referenceRepository) {
        this.referenceRepository = referenceRepository;
    }

    public void save(List<ReferenceRecord> dtos, Destinations destinations) {
        for (ReferenceRecord dto : dtos) {
            final var reference = new Reference(dto.keyReference(), dto.valor(), dto.imageLink(), destinations);
            this.referenceRepository.save(reference);
        }
    }

}
