package com.metamorphosis.kafka.entities;

import lombok.Builder;
import lombok.Data;

@Data @Builder
public class Course {
    Long id;
    String name;
}
