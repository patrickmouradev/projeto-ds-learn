package com.devsuperior.dslearnbds.entities;

import com.devsuperior.dslearnbds.entities.pk.EnrollMentPK;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@Table(name = "tb_enrollment")

public class Enrollment implements Serializable {

    @Setter(AccessLevel.NONE)
    @Getter(AccessLevel.NONE)
    @EmbeddedId
    private EnrollMentPK id = new EnrollMentPK(); //esquema para fazer chave composta para classe auxiliar, não esquecer de instanciar a classe

    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private Instant enrollMoment;

    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private Instant refundMoment;

    private boolean available;
    private boolean onlyUpdate;

    @Setter(AccessLevel.NONE)
    @ManyToMany(mappedBy = "enrolltmentsDone")
    private Set<Lesson> lessonDone = new HashSet<>();

    //alterar o construtor para setar o User e Offer
    public Enrollment(User user,Offer offer, Instant enrollMoment, Instant refundMoment, boolean available, boolean onlyUpdate) {
        id.setUser(user);
        id.setOffer(offer);
        this.enrollMoment = enrollMoment;
        this.refundMoment = refundMoment;
        this.available = available;
        this.onlyUpdate = onlyUpdate;
    }

    public User getStudent(){
        return id.getUser();
    }
    public void setStudent(User user){
        id.setUser(user);
    }

    public Offer getOffer(){
       return  id.getOffer();
    }

    public void setOffer(Offer offer){
        id.setOffer(offer);
    }
}
