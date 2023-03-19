package ru.liga.service;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ru.liga.domain.Country;
import ru.liga.repository.CountryRepository;
import ru.liga.util.CsvParser;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
public class CountryImportService {
    private final CsvParser csvParser;
    private final CountryRepository countryRepository;

    public void importCountries(String filePath) {
        List<Country> countries = csvParser.parseCountriesFromFile(filePath);
        countryRepository.saveAll(countries);
    }
}
