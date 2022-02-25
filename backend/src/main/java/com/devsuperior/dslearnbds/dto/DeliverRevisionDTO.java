package com.devsuperior.dslearnbds.dto;

import com.devsuperior.dslearnbds.entities.enuns.DeliverStatus;
import lombok.Data;

import java.io.Serializable;

@Data
public class DeliverRevisionDTO implements Serializable {
    private final DeliverStatus status;
    private final String feedback;
    private final Integer correctCount;
}
