package uz.roadmap.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
public class StudentDto {
    //
    private Long id;
    @JsonProperty("first_name")
    private String first_name;
    @JsonProperty("last_name")
    private String last_name;
    @JsonProperty("middle_name")
    private String middle_name;
    @JsonProperty("description")
    private String description;
    @JsonProperty("study_state_date")
    private String study_state_date;
    @JsonProperty("study_end_date")
    private String study_end_date;
    @JsonProperty("gender")
    private String gender;
    @JsonProperty("birthdate")
    private String birthdate;
    @JsonProperty("created_at")
    private String created_at;
}
