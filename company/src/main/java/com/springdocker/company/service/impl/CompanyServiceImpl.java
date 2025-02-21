package com.springdocker.company.service.impl;

import java.util.List;
import java.util.Optional;

import com.springdocker.company.data.Company;
import com.springdocker.company.data.CompanyRepository;
import com.springdocker.company.service.CompanyService;

import org.springframework.stereotype.Service;

@Service
public class CompanyServiceImpl implements CompanyService {
    CompanyRepository companiesRepository;

    public CompanyServiceImpl(CompanyRepository companiesRepository) {
        this.companiesRepository = companiesRepository;
    }

    @Override
    public List<Company> getCompanies() {
        return companiesRepository.findAll();
    }

    @Override
    public void addCompanies(Company companies) {
        companiesRepository.save(companies);
    }

    @Override
    public Company getCompaniesById(Long id) {
        // return companiess.stream().filter(j ->
        // j.getId().equals(id)).findFirst().orElse(null);
        return companiesRepository.findById(id).orElse(null);
    }

    @Override
    public boolean deleteCompanies(Long id) {
        // return companiess.removeIf(companies -> companies.getId().equals(id));
        try {
            companiesRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean updateCompanies(Long id, Company companies_updated) {

        Optional<Company> companiesOptional = companiesRepository.findById(id);
        if (companiesOptional.isPresent()) {
            Company companies = companiesOptional.get();
            companies.setName(companies_updated.getName());
            companies.setDescription(companies_updated.getDescription());
            companiesRepository.save(companies);
            return true;
        }
        return false;
    }

}
