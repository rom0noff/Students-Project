package uz.roadmap.entity.model;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "students")
public class Students {
    //
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    private String first_name;
    @Column(name = "last_name")
    private String last_name;
    @Column(name = "middle_name")
    private String middle_name;
    @Column(name = "description")
    private String description;
    @Column(name = "study_state_date")
    private String study_state_date;
    @Column(name = "study_end_date")
    private String study_end_date;
    @Column(name = "gender")
    private String gender;
    @Column(name = "birthdate")
    private String birthdate;
    @Column(name = "created_at")
    private String created_at;
}
