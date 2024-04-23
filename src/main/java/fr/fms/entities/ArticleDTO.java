package fr.fms.entities;
import groovyjarjarantlr4.v4.runtime.misc.NotNull;
import lombok.Getter;
import lombok.Setter;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Size;

/** DTO Article class definition
 * @author Gilles
 * */
@Setter
@Getter
public class ArticleDTO {
    private Long categoryId;
    @NotNull
    @Size(min = 10, max = 50)
    private String description;
    @DecimalMin("50")
    private double price;
}
