package com.devsuperior.dslearnbds.entities.pk;

import com.devsuperior.dslearnbds.entities.Offer;
import com.devsuperior.dslearnbds.entities.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Embeddable //para usar em atributo composto para outra classe
public class EnrollMentPK implements Serializable {

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @ManyToOne
    @JoinColumn(name = "offer_id")
    private Offer offer;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EnrollMentPK that = (EnrollMentPK) o;
        return getUser().equals(that.getUser()) && getOffer().equals(that.getOffer());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUser(), getOffer());
    }
}
