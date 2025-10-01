package topic5_Hibern.model;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tag", uniqueConstraints = @UniqueConstraint(name = "uk_tag_name", columnNames = "name"))
public class Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable=false, length=64)
    private String name;

    @ManyToMany(mappedBy = "tags", fetch = FetchType.LAZY)
    private Set<CustomerOrder> orders = new HashSet<>();

    public Tag() {}
    public Tag(String name) { this.name = name; }

    public Long getId() { return id; }
    public String getName() { return name; }
    public void setName(String n) { this.name = n; }
    public Set<CustomerOrder> getOrders() { return orders; }
}