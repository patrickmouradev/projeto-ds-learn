package com.devsuperior.dslearnbds.entities;

import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@EqualsAndHashCode(of = {"id"})
@Entity
@Table(name = "tb_lesson")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Lesson implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private Integer position;

    @ManyToOne
    @JoinColumn(name = "section_id")
    private Section section;

    @Setter(AccessLevel.NONE)
    @OneToMany(mappedBy = "enrollment")
    private List<Deliver> deliveries = new ArrayList<>();

    @Setter(AccessLevel.NONE)//para não adicionar o set no lombok
    @ManyToMany()
    @JoinTable(
            name = "tb_lessons_done",
            joinColumns = @JoinColumn(name = "lesson_id"), //ENTIDADE QUE ESTOU
            inverseJoinColumns = { //ENTIDADE REFERENCIA_COM_CHAVE_COMPOSTA
                    @JoinColumn(name = "user_id"),
                    @JoinColumn(name = "offer_id")
            }
    )
    private Set<Enrollment> enrolltmentsDone = new HashSet<>();

    public Lesson(Long id, String title, Integer position, Section section) {
        this.id = id;
        this.title = title;
        this.position = position;
        this.section = section;
    }
}
