package ru.liga.util;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ru.liga.domain.Country;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
public class CsvParser {
    private final CsvReader csvReader;

    public List<Country> parseCountriesFromFile(String filePath) {
        return csvReader.readAllLines(filePath).stream()
                .skip(1)
                .map(s -> s.split(";"))
                .map(fields -> Country.builder()
                        .id(Long.valueOf(fields[0]))
                        .name(fields[1])
                        .build())
                .collect(Collectors.toList());
    }
}
