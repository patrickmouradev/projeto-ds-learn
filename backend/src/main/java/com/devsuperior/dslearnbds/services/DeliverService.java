package com.devsuperior.dslearnbds.services;

import com.devsuperior.dslearnbds.dto.DeliverRevisionDTO;
import com.devsuperior.dslearnbds.entities.Deliver;
import com.devsuperior.dslearnbds.repositories.DeliveryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DeliverService {

    @Autowired
    private DeliveryRepository deliveryRepository;

    @Transactional
    public void saveDeliver(Long id, DeliverRevisionDTO revisionDTO){

        Deliver deliver = deliveryRepository.getOne(id);
        deliver.setStatus(revisionDTO.getStatus());
        deliver.setCorrectCount(revisionDTO.getCorrectCount());
        deliver.setFeedback(revisionDTO.getFeedback());
        deliveryRepository.save(deliver);
    }
}
