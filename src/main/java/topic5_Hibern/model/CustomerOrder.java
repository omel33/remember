package topic5_Hibern.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.Instant;


@Entity
@Table(
        name = "customer_order",
        indexes = {
                @Index(name = "idx_order_user_id", columnList = "user_id"),
                @Index(name = "idx_order_status", columnList = "status")
        }
)
public class CustomerOrder {
    public enum Status {NEW, PAID, CANCELLED}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false,
            foreignKey = @ForeignKey(name = "fk_order_user"))
    private AppUser user;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private Status status = Status.NEW;

    @Column(nullable = false, precision = 12, scale = 2)
    private BigDecimal amount = BigDecimal.ZERO;

    @Column(name = "created_at", nullable = false)
    private Instant createdAt = Instant.now();
    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST}) // без REMOVE!
    @JoinTable(
            name = "order_tag",
            joinColumns = @JoinColumn(name = "order_id", foreignKey = @ForeignKey(name = "fk_order_tag_order")),
            inverseJoinColumns = @JoinColumn(name = "tag_id", foreignKey = @ForeignKey(name = "fk_order_tag_tag")),
            uniqueConstraints = @UniqueConstraint(name = "uk_order_tag", columnNames = {"order_id","tag_id"})
    )
    private java.util.Set<Tag> tags = new java.util.HashSet<>();



    public java.util.Set<Tag> getTags() { return tags; }

    public void addTag(Tag t) {
        tags.add(t);
        t.getOrders().add(this);
    }
    public void removeTag(Tag t) {
        tags.remove(t);
        t.getOrders().remove(this);
    }

    public Long getId() {
        return id;
    }

    public AppUser getUser() {
        return user;
    }

    public void setUser(AppUser user) {
        this.user = user;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "Order{id=" + id + ", status=" + status + ", amount=" + amount + "}";
    }
}
