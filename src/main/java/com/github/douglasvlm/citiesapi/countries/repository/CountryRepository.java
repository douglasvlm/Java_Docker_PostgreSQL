package com.github.douglasvlm.citiesapi.countries.repository;

import com.github.douglasvlm.citiesapi.countries.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, Long> {
}
