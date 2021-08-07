package com.github.douglasvlm.citiesapi.repository;

import com.github.douglasvlm.citiesapi.countries.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, Long> {
}
