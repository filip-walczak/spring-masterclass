package pl.training.shop.users;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import pl.training.shop.common.PagedResult;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "users")
@Entity
@Setter
@Getter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    public String id;
    public String firstName;
    public String lastName;
}
