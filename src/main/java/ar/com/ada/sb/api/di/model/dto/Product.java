package ar.com.ada.sb.api.di.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;


@Getter @Setter
@NoArgsConstructor
@JsonPropertyOrder({"id", "name", "expire"})
public class Product {
    private Long id;
    @NotBlank(message = "name is required")
    private String name;
@NotNull(message = "expire is required")
@JsonFormat(pattern = "yyyy- MM- dd")
    private Date expire;

    public Product(Long id, String name, Date expire) {
        this.id = id;
        this.name = name;
        this.expire = expire;
    }

    public Product(String name, Date expire) {
        this.name = name;
        this.expire = expire;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", expire=" + expire +
                '}';
    }

}
