package uz.roadmap.entity.model;

import lombok.*;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "university")
public class University {
    //
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "university", fetch =FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Field> fields = new LinkedList<>();

}
