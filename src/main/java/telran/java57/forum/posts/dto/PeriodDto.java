package telran.java57.forum.posts.dto;

import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
public class PeriodDto {
    LocalDate dateFrom;
    LocalDate dateTo;
}
