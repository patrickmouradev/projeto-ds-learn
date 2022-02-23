package com.devsuperior.dslearnbds.controllers.exeptions;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class OAuthCustomErros implements Serializable {
    private static final long serialVersionUID = 4683969143264282759L;

    private String error;

    @JsonProperty("error_description")
    private String errorDescription;
}
