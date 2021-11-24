package ru.andreeva.app.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
@Entity
@Table(name = "logins")
@AllArgsConstructor
@NoArgsConstructor
public class Login {
    @Id
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @GeneratedValue
    private Long id;

    @NotEmpty(message = "Поле обязательно для заполнения")
    @Size(min = 4, max = 30, message = "длина логина от 4 до 30 символов")
    private String login;

    @Override
    public String toString() {
        return login;
    }
}
