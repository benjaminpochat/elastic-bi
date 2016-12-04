package org.elasticbi.core.pojo;

import java.time.Instant;

public interface State<T> {
	public Instant getStartTime();
	public Instant getEndTime();
	public T getPojo();
}
