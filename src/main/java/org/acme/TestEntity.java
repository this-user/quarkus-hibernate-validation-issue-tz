package org.acme;

import io.quarkus.hibernate.reactive.panache.PanacheEntity;

import javax.persistence.Entity;
import javax.validation.constraints.PastOrPresent;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.StringJoiner;

@Entity
public class TestEntity extends PanacheEntity {
	
	@PastOrPresent
	private LocalDateTime timestamp = LocalDateTime.now();
	
	
	public LocalDateTime getTimestamp() {
		return timestamp;
	}
	
	@Override
	public String toString() {
		return new StringJoiner(", ", TestEntity.class.getSimpleName() + "[", "]")
				       .add("id=" + id)
				       .add("timestamp=" + timestamp)
				       .toString();
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		
		final TestEntity entity = (TestEntity) o;
		
		if (!Objects.equals(id, entity.id)) return false;
		return Objects.equals(timestamp, entity.timestamp);
	}
	
	@Override
	public int hashCode() {
		int result = id != null ? id.hashCode() : 0;
		result = 31 * result + (timestamp != null ? timestamp.hashCode() : 0);
		return result;
	}
	
}
