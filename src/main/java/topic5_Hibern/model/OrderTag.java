package topic5_Hibern.model;

import jakarta.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "order_tag_link",
        uniqueConstraints = @UniqueConstraint(name="uk_order_tag_link", columnNames={"order_id","tag_id"}),
        indexes = {
                @Index(name="idx_link_order", columnList="order_id"),
                @Index(name="idx_link_tag", columnList="tag_id")
        })
public class OrderTag {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch=FetchType.LAZY, optional=false)
    @JoinColumn(name="order_id", nullable=false,
            foreignKey=@ForeignKey(name="fk_link_order"))
    private CustomerOrder order;

    @ManyToOne(fetch=FetchType.LAZY, optional=false, cascade = {CascadeType.PERSIST})
    @JoinColumn(name="tag_id", nullable=false,
            foreignKey=@ForeignKey(name="fk_link_tag"))
    private Tag tag;

    @Column(name="applied_at", nullable=false)
    private Instant appliedAt = Instant.now();

    // getters/setters
    public Long getId() { return id; }
    public CustomerOrder getOrder() { return order; }
    public void setOrder(CustomerOrder order) { this.order = order; }
    public Tag getTag() { return tag; }
    public void setTag(Tag tag) { this.tag = tag; }
    public Instant getAppliedAt() { return appliedAt; }
    public void setAppliedAt(Instant t) { this.appliedAt = t; }
}
